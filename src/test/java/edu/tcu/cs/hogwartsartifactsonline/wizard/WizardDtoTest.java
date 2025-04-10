package edu.tcu.cs.hogwartsartifactsonline.wizard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class WizardDtoTest {

    @Test
    void testWizardDtoCreation() {
        // Given
        WizardDto wizardDto = new WizardDto();
        wizardDto.setId(1);
        wizardDto.setName("Albus Dumbledore");

        // When and Then
        assertNotNull(wizardDto);
        assertEquals(1, wizardDto.getId());
        assertEquals("Albus Dumbledore", wizardDto.getName());
    }

    @Test
    void testWizardDtoFromWizard() {
        // Given
        Wizard wizard = new Wizard();
        wizard.setId(1);
        wizard.setName("Albus Dumbledore");

        // When
        WizardDto wizardDto = new WizardDto(wizard);

        // Then
        assertNotNull(wizardDto);
        assertEquals(1, wizardDto.getId());
        assertEquals("Albus Dumbledore", wizardDto.getName());
    }

    @Test
    void testWizardDtoToWizard() {
        // Given
        WizardDto wizardDto = new WizardDto();
        wizardDto.setId(1);
        wizardDto.setName("Albus Dumbledore");

        // When
        Wizard wizard = wizardDto.toWizard();

        // Then
        assertNotNull(wizard);
        assertEquals(1, wizard.getId());
        assertEquals("Albus Dumbledore", wizard.getName());
    }
} 