package edu.eci.arsw.blueprints.test.persistence.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;
import edu.eci.arsw.blueprints.persistence.impl.Redundancia;

public class RedundanceTest {
    
    @Test
    public void correctRedundance() {
        InMemoryBlueprintPersistence bpp = new InMemoryBlueprintPersistence();
        Redundancia rd = new Redundancia();

        Point[] pts0 = new Point[] { new Point(140, 140), new Point(115, 115), new Point(100, 100), new Point(80, 80),
                new Point(80, 80), new Point(80, 80), new Point(70, 70) };
        Blueprint bp0 = new Blueprint("haorl", "airetuapal", pts0);
        try {
            bpp.saveBlueprint(bp0);
        } catch (BlueprintPersistenceException e) {
            // TODO Auto-generated catch block
            fail("Exception Launched");

        }

        
        try {
            ArrayList<Point> test = new ArrayList<>(rd.getPoints(bpp.getBlueprint("haorl", "airetuapal")));
            assertNotNull("The result wasnt null", test);

            assertTrue(test.size() == 5);

            int contained = 0; 
            for(int i = 0; i <test.size(); i++){
                contained += test.get(i).getX()==80&&test.get(i).getY()==80?1:0;
            }

            assertTrue(contained == 1);
        } catch (BlueprintNotFoundException e) {
            // TODO Auto-generated catch block
            fail("Exception Launched");

        }

    }
}
