package Otro;

import Modelo.RestaurantModel;

import java.util.Random;
import Modelo.RestaurantModel;

public class Comensal implements Runnable {


    //rever vídeo threads
    private static EstadistiquesComensals estadistiquescomensal;
    private long platsMenjats;
    private long tempsMenjat;
    private long tempsEspera;
    private Rellotge rellotge;
    private RestaurantModel rm;
    private Estatcomensal Statuscm;
    private long tempsTertulia;
    private ParametresSimulacio parametresSimulacio;

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    private boolean paused;


    private static Estadistiques stats;


    public AreaBuffet getAreaBuffet() {
        return areaBuffet;
    }

    public void setAreaBuffet(AreaBuffet areaBuffet) {
        this.areaBuffet = areaBuffet;
    }

    private AreaBuffet areaBuffet;

    public static Estadistiques getStats() {
        return stats;
    }

    public static void setStats(Estadistiques stats) {
        Comensal.stats = stats;
    }

    public RestaurantModel getRm() {
        return rm;
    }

    public void setRm(RestaurantModel rm) {
        this.rm = rm;
    }


    public static EstadistiquesComensals getEstadistiquescomensal() {
        return estadistiquescomensal;
    }

    public static void setEstadistiquescomensal(EstadistiquesComensals estadistiquescomensal) {
        Comensal.estadistiquescomensal = estadistiquescomensal;
    }

    public Rellotge getRellotge() {
        return rellotge;
    }

    public long getTempsEspera() {
        return tempsEspera;
    }

    public void setTempsEspera(long tempsEspera) {
        this.tempsEspera = tempsEspera;
    }


    public long getPlatsMenjats() {
        return platsMenjats;
    }

    public void setPlatsMenjats(long platsMenjats) {
        this.platsMenjats = platsMenjats;
    }

    public long getTempsMenjat() {
        return tempsMenjat;
    }

    public void setTempsMenjat(long tempsMenjat) {
        this.tempsMenjat = tempsMenjat;
    }

    public long getTempsTertulia() {
        return tempsTertulia;
    }

    public void setTempsTertulia(long tempsTertulia) {
        this.tempsTertulia = tempsTertulia;
    }

    public Estatcomensal getStatuscm() {
        return Statuscm;
    }

    public void setStatuscm(Estatcomensal statuscm) {
        Statuscm = statuscm;
    }

    public Comensal(Rellotge rellotge) {
        this.platsMenjats = 0;
        this.tempsMenjat = 0;
        this.tempsTertulia = 0;
        this.tempsEspera = 0;
        this.rellotge = rellotge;


    }

    public void menjar() {
        this.setStatuscm(Statuscm.menjant);
        this.tempsMenjat += 1;
        Random rm = new Random();
        agafarPlat(getAreaBuffet());
        long minInicio = this.getRellotge().getMinutActual();
        long numbre = rm.nextInt(this.getRm().getPs().tempsConsumir.getMin(), this.getRm().getPs().tempsConsumir.getMax());
        //Relojproblema
        if (this.getRellotge().getInterval(minInicio) >= getRellotge().getMiliEnMinuts(numbre)) {
            tertulia();
        }


    }

    public void tertulia() {

        this.setStatuscm(Statuscm.xerrant);
        this.tempsTertulia += 1;
        Random rm = new Random();
        long minInicio = this.getRellotge().getMinutActual();
        long numbre = rm.nextInt(this.getRm().getPs().tempsTertulia.getMin(), this.getRm().getPs().tempsTertulia.getMax());
        while (this.getRellotge().getInterval(minInicio) >= this.getRellotge().minutsEnMilisegons(numbre)) {
            for (int i = 0; i < getRm().getAb().size(); i++) {
                    if (getRm().getAb().get(i).getQuantitatActual() > 0) {
                        menjar();

                    }
                }

            }

        }




    public void agafarPlat(AreaBuffet areaBuffet) {
        System.out.println(this + "ha recogido plato hora:" + this.getRellotge().getMinutActual());
        this.setStatuscm(Statuscm.agafantPlat);
        this.platsMenjats += 1;
        areaBuffet.retirarPlat();



    }


    @Override
    public void run() {

            tertulia();



    }

    }
