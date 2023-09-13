package edu.eci.arsw.blueprints.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.BlueprintsPersistence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

/**
 *
 * @author hcadavid
 */
@Service
public class submuestreoBlueprintPersistence implements BlueprintsPersistence {

    private final Map<Tuple<String, String>, Blueprint> blueprints = new HashMap<>();

    public submuestreoBlueprintPersistence() {
        // load stub data
        Point[] pts = new Point[] { new Point(140, 140), new Point(115, 115), new Point(100, 100), new Point(90, 90), new Point(80, 80), new Point(70, 70)};
        Blueprint bp = new Blueprint("prueba", "funca? ", pts);
        blueprints.put(new Tuple<>(bp.getAuthor(), bp.getName()), bp);

    }

    @Override
    public void saveBlueprint(Blueprint bp) throws BlueprintPersistenceException {
        if (blueprints.containsKey(new Tuple<>(bp.getAuthor(), bp.getName()))) {
            throw new BlueprintPersistenceException("The given blueprint already exists: " + bp);
        } else {
            blueprints.put(new Tuple<>(bp.getAuthor(), bp.getName()), bp);
        }
    }

    @Override
    public Blueprint getBlueprint(String author, String bprintname) throws BlueprintNotFoundException {
       Blueprint pb = blueprints.get(new Tuple<>(author, bprintname));
       pb.resetFilter();
        for(int i = 0; i < pb.getPoints().size(); i ++){
            if(i % 2 == 0){
                pb.addPointFilter(pb.getPoints().get(i));
            }
        }
        return pb;
    }

    @Override
    public Set<Blueprint> getBlueprintsByAuthor(String author) throws BlueprintNotFoundException {
        Set<Blueprint> resp = new HashSet<>();
        for(Map.Entry<Tuple<String, String>, Blueprint> space : blueprints.entrySet()){
            if(space.getKey().getElem1().equals(author)){
                resp.add(space.getValue());
            }
        }
        return resp;
    }

    @Override
    public Set<Blueprint> getAllBlueprints() throws BlueprintNotFoundException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllBlueprints'");
    }
    
}
