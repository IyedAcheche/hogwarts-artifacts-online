package edu.tcu.cs.hogwartsartifactsonline.artifact;

import edu.tcu.cs.hogwartsartifactsonline.system.Result;
import edu.tcu.cs.hogwartsartifactsonline.system.StatusCode;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/artifacts")
public class ArtifactController {

    private final ArtifactService artifactService;

    public ArtifactController(ArtifactService artifactService) {
        this.artifactService = artifactService;
    }

    @GetMapping
    public Result findAllArtifacts() {
        List<Artifact> foundArtifacts = this.artifactService.findAll();
        List<ArtifactDto> artifactDtos = foundArtifacts.stream()
                .map(ArtifactDto::new)
                .collect(Collectors.toList());
        return new Result(true, StatusCode.SUCCESS, "Find All Success", artifactDtos);
    }

    @GetMapping("/{artifactId}")
    public Result findArtifactById(@PathVariable String artifactId){
        Artifact foundArtifact = this.artifactService.findById(artifactId);
        ArtifactDto artifactDto = new ArtifactDto(foundArtifact);
        return new Result(true, StatusCode.SUCCESS, "Find One Success", artifactDto);
    }

    @PostMapping
    public Result addArtifact(@RequestBody Artifact artifact) {
        Artifact savedArtifact = this.artifactService.save(artifact);
        ArtifactDto artifactDto = new ArtifactDto(savedArtifact);
        return new Result(true, StatusCode.SUCCESS, "Add Success", artifactDto);
    }

    @PutMapping("/{artifactId}")
    public Result updateArtifact(@PathVariable String artifactId, @RequestBody Artifact artifact) {
        Artifact updatedArtifact = this.artifactService.update(artifactId, artifact);
        ArtifactDto artifactDto = new ArtifactDto(updatedArtifact);
        return new Result(true, StatusCode.SUCCESS, "Update Success", artifactDto);
    }

    @DeleteMapping("/{artifactId}")
    public Result deleteArtifact(@PathVariable String artifactId) {
        this.artifactService.delete(artifactId);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");
    }

    @PutMapping("/{artifactId}/owner/{wizardId}")
    public Result assignArtifactOwner(@PathVariable String artifactId, @PathVariable Integer wizardId) {
        this.artifactService.assignOwner(artifactId, wizardId);
        return new Result(true, StatusCode.SUCCESS, "Artifact Assignment Success");
    }
}
