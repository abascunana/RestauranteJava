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
        ArrayList<AreaBuffet> areaBuffets = new ArrayList();

        AreaBuffet areaBuffettacos = new AreaBuffet("tacos",100);
        AreaBuffet areaBuffethaburguesas = new AreaBuffet("haburguesas",100);
        AreaBuffet areaBuffetgambas = new AreaBuffet("gambas",100);

       areaBuffets.add(areaBuffettacos);
       areaBuffets.add(areaBuffethaburguesas);
       areaBuffets.add(areaBuffetgambas);

       ColaPlatsCuinats colaPlatsCuinats = new ColaPlatsCuinats(100);


        //

        //Listas
        ArrayList<Comensal> comensals = new ArrayList<>();
        ArrayList<Chef> chefs = new ArrayList<>();
        ArrayList<Grill> grills = new ArrayList<>();
        //




        //Reloj
        Rellotge rellotge = Rellotge.getInstance();

        ///Elementos del restaurante

        for (int i = 0; i < 12; i++) {
            Comensal comensal = new Comensal(rellotge);
            comensals.add(comensal);
        }






///Lógica del restaurante
        RestaurantModel restaurantModel = new RestaurantModel(comensals,chefs,rellotge,grills,areaBuffets);
        rellotge.setRm(restaurantModel);



///Vista y controlador


        RestaurantController restaurantController = new RestaurantController();

        restaurantController.setRestaurantModel(restaurantModel);
        for (int i = 0; i < 3; i++) {

            Grill grill = new Grill(areaBuffets.get(i),100,colaPlatsCuinats);
            grills.add(grill);
            areaBuffets.get(i).setGrill(grill);
        }
        for (int i = 0; i < 9; i++){
            Chef chef = new Chef(rellotge,grills.get(random.nextInt(grills.size())),restaurantController.getRandomBuffet());
            chefs.add(chef);
        }


        restaurantController.setEstadistiques(estadistiques);
        restaurantModel.setController(restaurantController);

        for (int i = 0; i <areaBuffets.size() ; i++) {
            areaBuffets.get(i).setColaPlatCuinats(colaPlatsCuinats);
        }

        for (int i = 0; i < comensals.size(); i++) {
            comensals.get(i).setRm(restaurantModel);
            comensals.get(i).setAreaBuffet(restaurantController.getRandomBuffet());
        }

        for (int i = 0; i < chefs.size(); i++) {
            chefs.get(i).setRm(restaurantModel);
            chefs.get(i).setAreaBuffet(restaurantController.getRandomBuffet());
        }


        RestaurantView restaurantView = new RestaurantView(restaurantController);
        restaurantController.setRestaurantView(restaurantView);



    }
}
