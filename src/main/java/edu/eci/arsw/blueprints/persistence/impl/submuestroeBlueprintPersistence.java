package edu.eci.arsw.blueprints.persistence.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;

@Service
public class submuestroeBlueprintPersistence implements BlueprintsPersistence {

    @Override
    public void saveBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveBlueprint'");
    }

    @Override
    public Blueprint getBlueprint(String author, String bprintname) throws BlueprintNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBlueprint'");
    }

    @Override
    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBlueprintsByAuthor'");
    }

    @Override
    public Set<Blueprint> getAllBlueprints() throws BlueprintNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllBlueprints'");
    }
    
}
