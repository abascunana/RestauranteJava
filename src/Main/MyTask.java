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

        AreaBuffet areaBuffet = new AreaBuffet("tacos",100);

        ColaPlatsCuinats colaPlatsCuinats = new ColaPlatsCuinats(100);
        colaPlatsCuinats.setAreaBuffet(areaBuffet);
        //

        //Listas
        ArrayList<Comensal> comensals = new ArrayList<>();
        ArrayList<Chef> chefs = new ArrayList<>();
        ArrayList<Grill> grills = new ArrayList<>();
        //

        for (int i = 0; i < 3; i++) {
            Grill grill = new Grill(areaBuffet,100,colaPlatsCuinats);
            grills.add(grill);
            areaBuffet.setGrill(grill);
        }


        //Reloj
        Rellotge rellotge = Rellotge.getInstance();
        Thread thread = new Thread(rellotge);
        thread.start();
        ///Elementos del restaurante

        for (int i = 0; i < 1; i++) {
            Comensal comensal = new Comensal(rellotge);
            comensals.add(comensal);
        }


        for (int i = 0; i < 3; i++){
            Chef chef = new Chef(rellotge,grills.get(random.nextInt(grills.size())),areaBuffet);
            chefs.add(chef);
        }





///Lógica del restaurante
        RestaurantModel restaurantModel = new RestaurantModel(comensals,chefs,rellotge,grills);
        restaurantModel.getAb().add(areaBuffet);
        for (int i = 0; i < comensals.size(); i++) {
            comensals.get(i).setRm(restaurantModel);
            comensals.get(i).setAreaBuffet(areaBuffet);
        }

        for (int i = 0; i < chefs.size(); i++) {
            chefs.get(i).setRm(restaurantModel);
            chefs.get(i).setAreaBuffet(areaBuffet);
        }


///Vista y controlador

        RestaurantView restaurantView = new RestaurantView();
        RestaurantController restaurantController = new RestaurantController(restaurantModel,restaurantView);
        restaurantView.setController(restaurantController);
        restaurantController.setEstadistiques(estadistiques);
        restaurantModel.setController(restaurantController);


//Inicialización de los threads


    }
}
