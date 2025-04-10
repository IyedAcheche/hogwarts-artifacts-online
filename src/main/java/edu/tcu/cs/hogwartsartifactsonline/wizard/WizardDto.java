package edu.tcu.cs.hogwartsartifactsonline.wizard;

import edu.tcu.cs.hogwartsartifactsonline.artifact.ArtifactDto;
import edu.tcu.cs.hogwartsartifactsonline.artifact.Artifact;

import java.util.ArrayList;
import java.util.List;

public class WizardDto {
    private Integer id;
    private String name;
    private List<ArtifactDto> artifacts = new ArrayList<>();

    public WizardDto() {
    }

    public WizardDto(Wizard wizard) {
        this.id = wizard.getId();
        this.name = wizard.getName();
        if (wizard.getArtifacts() != null) {
            this.artifacts = wizard.getArtifacts().stream()
                    .map(artifact -> new ArtifactDto(artifact.getId(), artifact.getName(), artifact.getDescription(), artifact.getImageUrl()))
                    .toList();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ArtifactDto> getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(List<ArtifactDto> artifacts) {
        this.artifacts = artifacts;
    }

    public Wizard toWizard() {
        Wizard wizard = new Wizard();
        wizard.setId(this.id);
        wizard.setName(this.name);
        return wizard;
    }
} 