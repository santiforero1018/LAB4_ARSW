package edu.eci.arsw.blueprints.test.persistence.impl;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;


import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;
import edu.eci.arsw.blueprints.persistence.impl.Submuestreo;


/**
 * @author Juan Sebastian Cepeda
 * @author Santiago Forero Yate
 */
public class subsampleTest {

    @Test
    public void correctSubsample() {
        InMemoryBlueprintPersistence bpp = new InMemoryBlueprintPersistence();
        Submuestreo sm = new Submuestreo();

        Point[] pts0 = new Point[] { new Point(140, 140), new Point(115, 115), new Point(100, 100), new Point(80, 80),
                new Point(80, 80), new Point(80, 80), new Point(70, 70) };
        Blueprint bp0 = new Blueprint("haorl", "airetuapal", pts0);
        try {
            bpp.saveBlueprint(bp0);
        } catch (BlueprintPersistenceException e) {
            // TODO Auto-generated catch block
            fail("Exception launched");
        }

        try {
            ArrayList<Point> test = new ArrayList<>(sm.getPoints(bpp.getBlueprint("haorl", "airetuapal")));

            assertNotNull("Result not null", test);

            assertEquals("Size excepted after filter",4,test.size());

        } catch (BlueprintNotFoundException e) {
            // TODO: handle exception
            fail("Exception launched");

        }
    }
}
