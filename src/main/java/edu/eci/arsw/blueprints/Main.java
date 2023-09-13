package edu.eci.arsw.blueprints;

import edu.eci.arsw.blueprints.services.BlueprintsServices;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import edu.eci.arsw.blueprints.persistence.BlueprintNotFoundException;
import edu.eci.arsw.blueprints.persistence.BlueprintPersistenceException;
import edu.eci.arsw.blueprints.persistence.impl.InMemoryBlueprintPersistence;
import edu.eci.arsw.blueprints.persistence.impl.Tuple;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        BlueprintsServices bs = ac.getBean(BlueprintsServices.class);
        System.out.println("-----------------GET BLUEPRINTS-----------------");
        try {
            System.out.println(bs.getAllBlueprints());
        } catch (BlueprintNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("-----------------NEW BLUEPRINT-----------------");
        Point[] pts0 = new Point[] { new Point(10, 10), new Point(60, 60) };
        Blueprint bp0 = new Blueprint("haorl", "airetuapal", pts0);
        System.out.println("Blueprint Creado");
        try {
            bs.addNewBlueprint(bp0);
        } catch (BlueprintPersistenceException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------GET BLUEPRINTS-----------------");

        try {
            System.out.println(bs.getAllBlueprints());
        } catch (BlueprintNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
