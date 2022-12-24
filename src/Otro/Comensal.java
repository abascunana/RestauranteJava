package Otro;

import Modelo.RestaurantModel;

import java.util.Random;
import Modelo.RestaurantModel;

public class Comensal implements Runnable{


    //rever vídeo threads
    private static EstadistiquesComensals estadistiquescomensal;
    private int platsMenjats;
    private int tempsMenjat;
    private int tempsEspera;
    private Rellotge rellotge;
    private RestaurantModel rm;
    private Estatcomensal Statuscm;
    private int tempsTertulia;
    private ParametresSimulacio parametresSimulacio;

    public AreaBuffet getAreaBuffet() {
        return areaBuffet;
    }

    public void setAreaBuffet(AreaBuffet areaBuffet) {
        this.areaBuffet = areaBuffet;
    }

    private AreaBuffet areaBuffet;


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

    public int getTempsEspera() {
        return tempsEspera;
    }

    public void setTempsEspera(int tempsEspera) {
        this.tempsEspera = tempsEspera;
    }



    public int getPlatsMenjats() {
        return platsMenjats;
    }

    public void setPlatsMenjats(int platsMenjats) {
        this.platsMenjats = platsMenjats;
    }

    public int getTempsMenjat() {
        return tempsMenjat;
    }

    public void setTempsMenjat(int tempsMenjat) {
        this.tempsMenjat = tempsMenjat;
    }

    public int getTempsTertulia() {
        return tempsTertulia;
    }

    public void setTempsTertulia(int tempsTertulia) {
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
        this.tempsEspera=0;
        this.rellotge = rellotge;




    }

     public void menjar() {
       this.setStatuscm(Statuscm.menjant);
       this.tempsMenjat+=1;
      System.out.println("comiendo");
       Random rm = new Random();
       agafarPlat(getAreaBuffet());
       int minInicio = this.getRellotge().getMinutActual();
       int numbre= rm.nextInt( this.getRm().getPs().tempsConsumir.getMin(), this.getRm().getPs().tempsConsumir.getMax());
         if (this.getRellotge().getInterval(minInicio) >= numbre) {

             tertulia();

         }


    }

    public void tertulia()  {
            this.setStatuscm(Statuscm.xerrant);
            this.tempsTertulia+=1;
            Random rm = new Random();
            int minInicio = this.getRellotge().getMinutActual();
            int numbre= rm.nextInt( this.getRm().getPs().tempsTertulia.getMin(), this.getRm().getPs().tempsTertulia.getMax());
        //TODO EL RELOJ TIENE QUE INICIALSE EN OTRO LUGAR O MODIFICARLO PARA QUE NO VAYA TAN RÁPIDO

            if (this.getRellotge().getInterval(minInicio) >=this.getRellotge().convertirTemps( numbre) ){
                for (int i = 0; i < getRm().getAb().size(); i++) {
                    if (getRm().getAb().get(i).getQuantitatActual() > 0){
                        menjar();
                    }
        }

            }
    }


    public void agafarPlat(AreaBuffet areaBuffet)  {
        this.setStatuscm(Statuscm.agafantPlat);
        System.out.println("agafarplat");
        this.platsMenjats+=1;
        areaBuffet.retirarPlat();
        System.out.println(platsMenjats);


    }


    @Override
    public void run() {
        while (true){
            tertulia();
        }


    }
}
