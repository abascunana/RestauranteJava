package Modelo;
import Otro.*;
import Controlador.*;
import java.util.ArrayList;

public class RestaurantModel {
    private  ArrayList <AreaBuffet> abs;
    private  ArrayList <Chef> chefs;
    private  ArrayList <Comensal> cms;
    private  ArrayList <Grill> gls;
    private  ParametresSimulacio ps;
    private  Rellotge rl;
    private RestaurantController controller;
    private static ArrayList<Thread> threads;


    public ArrayList<AreaBuffet> getAb() {
        return abs;
    }

    public void setAb(ArrayList<AreaBuffet> ab) {
        this.abs = ab;
    }

    public ArrayList<Chef> getChefs() {
        return chefs;
    }

    public void setChefs(ArrayList<Chef> chefs) {
        this.chefs = chefs;
    }

    public ArrayList<Comensal> getCms() {
        return cms;
    }

    public void setCms(ArrayList<Comensal> cms) {
        this.cms = cms;
    }

    public ArrayList<Grill> getGls() {
        return gls;
    }

    public void setGls(ArrayList<Grill> gls) {
        this.gls = gls;
    }

    public ParametresSimulacio getPs() {
        return ps;
    }

    public void setParametresSimulacio(ParametresSimulacio ps) {
        this.ps = ps;
    }

    public Rellotge getRl() {
        return rl;
    }

    public void setRl(Rellotge rl) {
        this.rl = rl;
    }


public void getEstadistiques(){
        //TODO el tiempo en el que cocinero y cliente han hecho cosas (tertulia,descanso etc)
}
    public RestaurantModel(ArrayList<Comensal> cms, ArrayList<Chef> chefs, Rellotge rellotge) {
        this.abs=new ArrayList<AreaBuffet>();
        this.chefs =new ArrayList<Chef>();
        this.threads = new ArrayList<Thread>();
        this.gls = new ArrayList<Grill>();

        for (int i = 0; i < chefs.size(); i++) {

            threads.add(new Thread(chefs.get(i)));
        }
        this.cms =new ArrayList<Comensal>();
        for (int i = 0; i < cms.size(); i++) {
            threads.add(new Thread(cms.get(i)));
        }
        this.rl = rellotge;

        this.ps = new ParametresSimulacio(10,11,10);





    }
    public  void start() throws InterruptedException {
        for (int i = 0; i <threads.size() ; i++) {
            threads.get(i).start();
        }
    }
    public synchronized void play() throws InterruptedException {
        controller.play();

    }
    public synchronized void stop() throws InterruptedException {
      controller.stop();

    }
    public synchronized void pause() throws InterruptedException {
       controller.pause();
    }


}
