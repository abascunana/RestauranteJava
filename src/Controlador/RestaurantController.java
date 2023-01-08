package Controlador;

import Modelo.RestaurantModel;
import Vista.RestaurantView;

import java.util.ArrayList;
import java.util.Random;
import Otro.*;

public class RestaurantController implements Runnable{
    //Esta clase se encarga de las comunicaciones entre el modelo y la vista
    RestaurantModel restaurantModel;
    public ArrayList<Thread> thread;
    public RestaurantModel getRestaurantModel() {
        return restaurantModel;
    }

    public RestaurantView getRestaurantView() {
        return restaurantView;
    }

    RestaurantView restaurantView;

    public void setRestaurantModel(RestaurantModel restaurantModel) {
        this.restaurantModel = restaurantModel;
    }

    public void setRestaurantView(RestaurantView restaurantView) {
        this.restaurantView = restaurantView;
    }

    Estadistiques estadistiques;


    public Estadistiques getEstadistiques() {
        return estadistiques;
    }

    public void setEstadistiques(Estadistiques estadistiques) {
        this.estadistiques = estadistiques;
    }

    public synchronized  void play(){
        notifyAll();

    }
    public synchronized void pause()  {
        try {
            System.out.println("dormido");
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void stop(){

        for (int i = 0; i < thread.size(); i++) {
            thread.get(i).interrupt();
        }
    }
    public RestaurantController() {

        this.thread = restaurantModel.getThreads();
    }


    public void canviStatusChef(Chef chef, Estatchef statuscu){
        for (int i = 0; i < restaurantModel.getChefs().size(); i++) {
            if (restaurantModel.getChefs().get(i).equals(chef)){
                restaurantModel.getChefs().get(i).setEstatchef(statuscu);
            }
        }
    }

    public void canviStatusAreaBuffet(AreaBuffet areaBuffet){
        for (int i  = 0; i < restaurantModel.getCms().size(); i++) {
            if (restaurantModel.getCms().get(i).equals(areaBuffet)){
                restaurantModel.getCms().get(i);
            }
        }
    }
    public void canviStatusGrill(Grill grill){
        for (int i = 0; i < restaurantModel.getGls().size(); i++) {
            if (restaurantModel.getGls().get(i).equals(grill)){
                restaurantModel.getGls().get(i).isEnServei();
            }
        }
    }
    public void canviStatusComensal(Comensal comensal){
        for (int i = 0; i < restaurantModel.getGls().size(); i++) {
            if (restaurantModel.getCms().get(i).equals(comensal)){
                restaurantModel.getCms().get(i).setStatuscm(Estatcomensal.valueOf(String.valueOf(comensal.getStatuscm().ordinal() -1)));
            }
        }
    }
    public AreaBuffet getRandomBuffet(){
        Random randomnumber = new Random();

        int randomindex = randomnumber.nextInt(0,restaurantModel.getAb().size());
        return restaurantModel.getAb().get(randomindex);
    }

    @Override
    public void run() {
            //Utilizado para actualizar la vista
    }
}
