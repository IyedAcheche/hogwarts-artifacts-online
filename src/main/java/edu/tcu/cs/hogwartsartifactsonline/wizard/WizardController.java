package edu.tcu.cs.hogwartsartifactsonline.wizard;

import edu.tcu.cs.hogwartsartifactsonline.system.Result;
import edu.tcu.cs.hogwartsartifactsonline.system.StatusCode;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/wizards")
public class WizardController {
    private final WizardService wizardService;

    public WizardController(WizardService wizardService) {
        this.wizardService = wizardService;
    }

    @GetMapping
    public Result findAll() {
        List<Wizard> wizards = this.wizardService.findAll();
        List<WizardDto> wizardDtos = wizards.stream()
                .map(WizardDto::new)
                .collect(Collectors.toList());
        return new Result(true, StatusCode.SUCCESS, "Find All Success", wizardDtos);
    }

    @GetMapping("/{wizardId}")
    public Result findById(@PathVariable Integer wizardId) {
        Wizard wizard = this.wizardService.findById(wizardId);
        WizardDto wizardDto = new WizardDto(wizard);
        return new Result(true, StatusCode.SUCCESS, "Find One Success", wizardDto);
    }

    @PostMapping
    public Result save(@RequestBody Wizard wizard) {
        Wizard savedWizard = this.wizardService.save(wizard);
        WizardDto wizardDto = new WizardDto(savedWizard);
        return new Result(true, StatusCode.SUCCESS, "Save Success", wizardDto);
    }

    @PutMapping("/{wizardId}")
    public Result update(@PathVariable Integer wizardId, @RequestBody Wizard wizard) {
        Wizard updatedWizard = this.wizardService.update(wizardId, wizard);
        WizardDto wizardDto = new WizardDto(updatedWizard);
        return new Result(true, StatusCode.SUCCESS, "Update Success", wizardDto);
    }

    @DeleteMapping("/{wizardId}")
    public Result delete(@PathVariable Integer wizardId) {
        this.wizardService.delete(wizardId);
        return new Result(true, StatusCode.SUCCESS, "Delete Success");
    }
} 