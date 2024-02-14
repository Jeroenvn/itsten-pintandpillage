package nl.duckstudios.pintandpillage;

import nl.duckstudios.pintandpillage.entity.buildings.Building;
import nl.duckstudios.pintandpillage.helper.ResourceManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LevelUpTests {
    @Test
    public void When_NotEnoughResources_Should_ReturnException(){
        ResourceManager resourceManager = mock(ResourceManager.class);
        when(resourceManager.hasEnoughResourcesAvailable(any(), any())).thenReturn(false);
        Building buildingUnderTesting = new Building();
    }
}
