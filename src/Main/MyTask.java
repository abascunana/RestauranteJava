package Main;

import Controlador.RestaurantController;
import Modelo.RestaurantModel;
import Otro.*;
import Vista.RestaurantView;

import java.util.ArrayList;
import java.util.Random;

public class MyTask {
    public MyTask(){

        Random random = new Random();
        //Estadísticas
        EstadistiquesComensals estadistiquesComensals = new EstadistiquesComensals();
        EstadistiquesBuffets estadistiquesBuffets = new EstadistiquesBuffets();
        EstadistiquesChefs estadistiquesChefs = new EstadistiquesChefs();
        Estadistiques estadistiques = new Estadistiques(estadistiquesChefs,estadistiquesComensals,estadistiquesBuffets);

        //Restaurante
        ArrayList<AreaBuffet> areaBuffets = new ArrayList<>();
        AreaBuffet areaBuffettacos = new AreaBuffet("tacos",100);
        AreaBuffet areaBuffetHamburguesas = new AreaBuffet("hamburguesas",200);
        AreaBuffet areaBuffetGambas = new AreaBuffet("gambas",300);

        areaBuffets.add(areaBuffettacos);
        areaBuffets.add(areaBuffetHamburguesas);
        areaBuffets.add(areaBuffetGambas);

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
            Chef chef = new Chef(rellotge,grills.get(random.nextInt(grills.size())),areaBuffettacos);
            chefs.add(chef);
        }





///Lógica del restaurante
        RestaurantModel restaurantModel = new RestaurantModel(comensals,chefs,rellotge,grills);
        rellotge.setRm(restaurantModel);
        for (int i = 0; i < 3; i++) {
            restaurantModel.getAb().add(areaBuffets.get(i));
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
        RestaurantView restaurantView = new RestaurantView(restaurantController);
        restaurantController.setRestaurantView(restaurantView);



    }
}
