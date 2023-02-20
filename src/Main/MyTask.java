package Main;

import Controlador.RestaurantController;
import Modelo.RestaurantModel;
import Otro.*;

import java.util.ArrayList;
import java.util.Random;

public class MyTask {
    public MyTask(){
//TODO Hay algo que hace que el programa vaya lento,solucionarlo
        Random random = new Random();
        //Estadísticas
        EstadistiquesComensals estadistiquesComensals = new EstadistiquesComensals();
        EstadistiquesBuffets estadistiquesBuffets = new EstadistiquesBuffets();
        EstadistiquesChefs estadistiquesChefs = new EstadistiquesChefs();
        Estadistiques estadistiques = new Estadistiques(estadistiquesChefs,estadistiquesComensals,estadistiquesBuffets);

        //Restaurante
        ArrayList<AreaBuffet> areaBuffets = new ArrayList<>();
        AreaBuffet areaBuffettacos = new AreaBuffet("tacos",100);
        AreaBuffet areaBuffethamburger = new AreaBuffet("hamburger",100);
        AreaBuffet areaBuffetshrimp = new AreaBuffet("shrimp",100);

        areaBuffets.add(areaBuffettacos);
        areaBuffets.add(areaBuffethamburger);
        areaBuffets.add(areaBuffetshrimp);

        ColaPlatsCuinats colaPlatsCuinats = new ColaPlatsCuinats(100);
        colaPlatsCuinats.setAreaBuffet(areaBuffettacos);



        //

        //Listas
        ArrayList<Comensal> comensals = new ArrayList<>();
        ArrayList<Chef> chefs = new ArrayList<>();
        ArrayList<Grill> grills = new ArrayList<>();
        //

        for (int i = 0; i < 3; i++) {
            Grill grill = new Grill(areaBuffets.get(i),100,colaPlatsCuinats);
            grills.add(grill);
            areaBuffets.get(i).setGrill(grill);
        }


        //Reloj
        Rellotge rellotge = Rellotge.getInstance();

        ///Elementos del restaurante

        for (int i = 0; i < 12; i++) {
            Comensal comensal = new Comensal(rellotge);
            comensals.add(comensal);
        }


        for (int i = 0; i < 9; i++){
            Chef chef = new Chef(rellotge,grills.get(random.nextInt(grills.size())),areaBuffets.get(random.nextInt(areaBuffets.size())));
            chefs.add(chef);
        }





///Lógica del restaurante
        RestaurantModel restaurantModel = new RestaurantModel(comensals,chefs,rellotge,grills);
        rellotge.setRm(restaurantModel);
        for (int i = 0; i < areaBuffets.size(); i++) {
            restaurantModel.getAb().add(areaBuffettacos);
        }

        for (int i = 0; i < comensals.size(); i++) {
            comensals.get(i).setRm(restaurantModel);
            comensals.get(i).setAreaBuffet(areaBuffettacos);
        }

        for (int i = 0; i < chefs.size(); i++) {
            chefs.get(i).setRm(restaurantModel);
            chefs.get(i).setAreaBuffet(areaBuffettacos);
        }


///Vista y controlador


        RestaurantController restaurantController = new RestaurantController();

        restaurantController.setRestaurantModel(restaurantModel);


        restaurantController.setEstadistiques(estadistiques);
        restaurantModel.setController(restaurantController);
        /*
        RestaurantVentana restaurantVentana = new RestaurantVentana(restaurantController);
        restaurantController.setRestaurantView(restaurantVentana);*/

        try {
            restaurantModel.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
