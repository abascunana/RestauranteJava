package Main;

import Controlador.RestaurantController;
import Modelo.RestaurantModel;
import Otro.*;
import Vista.RestaurantView;

import java.util.ArrayList;

public class MyTask {
    public MyTask(){
        AreaBuffet areaBuffet = new AreaBuffet("tacos",100);
        ColaPlatsCuinats colaPlatsCuinats = new ColaPlatsCuinats(100);
        colaPlatsCuinats.setAreaBuffet(areaBuffet);
        ArrayList<Comensal> comensals = new ArrayList<>();
        ArrayList<Chef> chefs = new ArrayList<>();
        ArrayList<Grill> grills = new ArrayList<>();
        Grill grill = new Grill(areaBuffet,100,colaPlatsCuinats);
        Rellotge rellotge = Rellotge.getInstance();
        Thread thread = new Thread(rellotge);
        thread.start();
        Comensal comensal = new Comensal(rellotge);
        Chef chef = new Chef(rellotge,grill,areaBuffet);
        chefs.add(chef);
        comensals.add(comensal);
        grills.add(grill);
        areaBuffet.setGrill(grill);
        RestaurantModel restaurantModel = new RestaurantModel(comensals,chefs,rellotge);
        restaurantModel.getAb().add(areaBuffet);
        comensal.setRm(restaurantModel);
        comensal.setAreaBuffet(areaBuffet);
        chef.setRm(restaurantModel);
        chef.setAreaBuffet(areaBuffet);
        RestaurantView restaurantView = new RestaurantView();
        RestaurantController restaurantController = new RestaurantController(restaurantModel,restaurantView);

    }
}
