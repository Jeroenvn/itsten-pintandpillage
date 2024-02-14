package nl.duckstudios.pintandpillage;

import nl.duckstudios.pintandpillage.entity.buildings.Building;
import nl.duckstudios.pintandpillage.helper.ResourceManager;

public class MockBuilding extends Building {

    @Override
    public void updateBuilding() {

    }

    public void setResourceManager(ResourceManager resourceManager){
        super.resourceManager = resourceManager;
    }
}
