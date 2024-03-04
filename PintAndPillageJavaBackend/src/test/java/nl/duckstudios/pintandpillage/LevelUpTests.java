package nl.duckstudios.pintandpillage;

import nl.duckstudios.pintandpillage.Exceptions.BuildingConditionsNotMetException;
import nl.duckstudios.pintandpillage.entity.Village;
import nl.duckstudios.pintandpillage.helper.ResourceManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LevelUpTests {
    @Test
    public void When_NotEnoughResources_Should_ReturnException(){
        MockBuilding buildingUnderTesting = new MockBuilding();
        ResourceManager resourceManager = mock(ResourceManager.class);
        when(resourceManager.hasEnoughResourcesAvailable(any(), any())).thenReturn(false);
        buildingUnderTesting.setResourceManager(resourceManager);
        String exceptionMessage = "";

        try {
            buildingUnderTesting.levelUp();
        } catch (BuildingConditionsNotMetException e) {
            exceptionMessage = e.getMessage();
        }

        assertThat(exceptionMessage, is("Not enough resources available"));
    }

    @Test
    public void When_LevelingUp_Should_CallSubtractResourcesOnce(){
        MockBuilding buildingUnderTesting = new MockBuilding();
        ResourceManager resourceManager = mock(ResourceManager.class);
        when(resourceManager.hasEnoughResourcesAvailable(any(), any())).thenReturn(true);
        buildingUnderTesting.setResourceManager(resourceManager);
        Village village = mock(Village.class);
        when(village.hasEnoughPopulation(anyInt())).thenReturn(true);
        buildingUnderTesting.setVillage(village);

        buildingUnderTesting.levelUp();

        verify(resourceManager, times(1)).subtractResources(any(), any());
    }
}
