package edu.tcu.cs.hogwartsartifactsonline.artifact;

import edu.tcu.cs.hogwartsartifactsonline.wizard.WizardDto;

public class ArtifactDto {
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private WizardDto owner;

    public ArtifactDto() {
    }

    public ArtifactDto(String id, String name, String description, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public ArtifactDto(Artifact artifact) {
        this.id = artifact.getId();
        this.name = artifact.getName();
        this.description = artifact.getDescription();
        this.imageUrl = artifact.getImageUrl();
        if (artifact.getOwner() != null) {
            this.owner = new WizardDto(artifact.getOwner());
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public WizardDto getOwner() {
        return owner;
    }

    public void setOwner(WizardDto owner) {
        this.owner = owner;
    }

    public Artifact toArtifact() {
        Artifact artifact = new Artifact();
        artifact.setId(this.id);
        artifact.setName(this.name);
        artifact.setDescription(this.description);
        artifact.setImageUrl(this.imageUrl);
        if (this.owner != null) {
            artifact.setOwner(this.owner.toWizard());
        }
        return artifact;
    }
} 