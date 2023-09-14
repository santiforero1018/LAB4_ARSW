/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blueprints.test.persistence.impl;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;
import edu.eci.arsw.blueprints.persistence.impl.Redundancia;
// import java.util.logging.Level;
// import java.util.logging.Logger;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 *
 * @author hcadavid
 */
public class InMemoryPersistenceTest {

    @Test
    public void saveNewAndLoadTest() throws BlueprintPersistenceException, BlueprintNotFoundException {
        InMemoryBlueprintPersistence ibpp = new InMemoryBlueprintPersistence();

        Point[] pts0 = new Point[] { new Point(40, 40), new Point(15, 15) };
        Blueprint bp0 = new Blueprint("mack", "mypaint", pts0);

        ibpp.saveBlueprint(bp0);

        Point[] pts = new Point[] { new Point(0, 0), new Point(10, 10) };
        Blueprint bp = new Blueprint("john", "thepaint", pts);

        ibpp.saveBlueprint(bp);

        assertNotNull("Loading a previously stored blueprint returned null.",
                ibpp.getBlueprint(bp.getAuthor(), bp.getName()));

        assertEquals("Loading a previously stored blueprint returned a different blueprint.",
                ibpp.getBlueprint(bp.getAuthor(), bp.getName()), bp);

    }

    @Test
    public void saveExistingBpTest() {
        InMemoryBlueprintPersistence ibpp = new InMemoryBlueprintPersistence();

        Point[] pts = new Point[] { new Point(0, 0), new Point(10, 10) };
        Blueprint bp = new Blueprint("john", "thepaint", pts);

        try {
            ibpp.saveBlueprint(bp);
        } catch (BlueprintPersistenceException ex) {
            fail("Blueprint persistence failed inserting the first blueprint.");
        }

        Point[] pts2 = new Point[] { new Point(10, 10), new Point(20, 20) };
        Blueprint bp2 = new Blueprint("john", "thepaint", pts2);

        try {
            ibpp.saveBlueprint(bp2);
            fail("An exception was expected after saving a second blueprint with the same name and autor");
        } catch (BlueprintPersistenceException ex) {

        }

    }

    @Test
    public void searchBlueprintsByAuthorName() {
        InMemoryBlueprintPersistence ibpp = new InMemoryBlueprintPersistence();

        Point[] pts = new Point[] { new Point(0, 0), new Point(10, 10) };
        Blueprint bp1 = new Blueprint("john", "thepaint", pts);

        Point[] pts2 = new Point[] { new Point(10, 15), new Point(20, 20) };
        Blueprint bp2 = new Blueprint("Martha", "thepaint1", pts2);

        Point[] pts3 = new Point[] { new Point(16, 7), new Point(30, 30) };
        Blueprint bp3 = new Blueprint("john", "thepaint2", pts3);

        Point[] pts4 = new Point[] { new Point(20, 35), new Point(40, 40) };
        Blueprint bp4 = new Blueprint("Alex", "thepaint3", pts4);

        try {
            ibpp.saveBlueprint(bp1);
            ibpp.saveBlueprint(bp2);
            ibpp.saveBlueprint(bp3);
            ibpp.saveBlueprint(bp4);
        } catch (BlueprintPersistenceException e) {

        }

        try {
            assertNotNull("the result wasn't null", ibpp.getBlueprintsByAuthor("john"));
            assertTrue("This BluePrint is in the set", ibpp.getBlueprintsByAuthor("john").contains(bp1));
            assertTrue("This BluePrint is in the set", ibpp.getBlueprintsByAuthor("john").contains(bp3));
            assertFalse("This BluePrint isn't in the set", ibpp.getBlueprintsByAuthor("john").contains(bp2));
        } catch (BlueprintNotFoundException e) {
            fail("And Exception was expected after looking for the blue print");
        }

    }

    // prueba del primer filtrado
    

}
