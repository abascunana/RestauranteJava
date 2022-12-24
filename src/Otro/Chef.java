package Otro;

import java.util.Random;
import Modelo.RestaurantModel;

public class Chef implements Runnable {

    private static EstadistiquesChefs status;

    public Estatchef getEstatchef() {
        return estatchef;
    }

    public void setEstatchef(Estatchef estatchef) {
        this.estatchef = estatchef;
    }

    private Estatchef estatchef;
    private int tempsTotalCuinant;
    private int tempsNoDescans;
    private int nombrePlatsCuinats;
    private int horariIniciDescans;
    private int tempsTotalDescans;
    private Grill grill;
    private int tempsEspera;
    private Rellotge rellotge;
    private AreaBuffet areaBuffet;

    public void setRm(RestaurantModel rm) {
        this.rm = rm;
    }

    private RestaurantModel rm;
    public RestaurantModel getRm() {
        return rm;
    }
                                                                              


    public Chef(Rellotge rellotge, Grill grill, AreaBuffet areaBuffet) {
        this.tempsTotalCuinant = 0;
        this.tempsNoDescans = 0;
        this.nombrePlatsCuinats = 0;
        this.horariIniciDescans = 3;
        this.tempsTotalDescans = 0;
        this.tempsEspera = 0;
        this.rellotge = rellotge;
        this.grill = grill;
        this.rm = new RestaurantModel();
        this.areaBuffet = areaBuffet;

    }
                                                                              
    public  void cuinar() throws InterruptedException {
        while (this.getAreaBuffet().getColaPlatCuinats().getQuantitatActual() < this.getAreaBuffet().getCapacitatMaxima()) {
                this.grill.setEnServei(true);
                this.setEstatchef(Estatchef.cuinant);
                boolean cocinado = false;
                System.out.println("cocinando");
                int minInicio;
                minInicio = this.getRellotge().getMinutActual();
                while (!cocinado) {
                    this.setTempsTotalCuinant(this.getTempsTotalCuinant() + 1);
                    if (this.getRellotge().getInterval(minInicio) >= this.getRellotge().convertirTemps(this.getHorariIniciDescans())) {
                       entregarPlat();
                        cocinado = true;
                        descansar();

                    }
                }
            }
        }






    public void descansar() throws InterruptedException {

            this.setEstatchef(Estatchef.descansant);
            Random rm = new Random();
            int numbre = rm.nextInt(this.getRm().getPs().tempsDescans.getMin(), this.getRm().getPs().tempsDescans.getMax());
            System.out.println("descansando");
            //ESTO HACE LA SIMULACIÓN MÁS REALISTA PERO ESPERA TODOS LOS MINUTOS, QUITAR SI SE VE NECESARIO
            //Thread.sleep(this.getRellotge().getMiliEnMinuts(numbre));
            Thread.sleep(this.getRellotge().minutsEnMilisegons(numbre));

    }
    public void entregarPlat() throws InterruptedException {

            System.out.println("entregando");
            this.setEstatchef(Estatchef.entregant);
            this.grill.getAreaBuffet().afegirplat();


    }

    public EstadistiquesChefs getStatus() {
        return status;
    }
    public Rellotge getRellotge() {
        return rellotge;
    }
    public void setStatus(EstadistiquesChefs status) {
        this.status = status;
    }

    public void setGrill(Grill grill){
       this.grill = grill;
    }

    public void setAreaBuffet(AreaBuffet areaBuffet){
        this.areaBuffet = areaBuffet;
    }


    public int getTempsTotalCuinant() {
        return tempsTotalCuinant;
    }

    public void setTempsTotalCuinant(int tempsTotalCuinant) {
        this.tempsTotalCuinant = tempsTotalCuinant;
    }

    public int getTempsNoDescans() {
        return tempsNoDescans;
    }

    public void setTempsNoDescans(int tempsNoDescans) {
        this.tempsNoDescans = tempsNoDescans;
    }

    public int getNombrePlatsCuinats() {
        return nombrePlatsCuinats;
    }

    public void setNombrePlatsCuinats(int nombrePlatsCuinats) {
        this.nombrePlatsCuinats = nombrePlatsCuinats;
    }

    public int getHorariIniciDescans() {
        return horariIniciDescans;
    }

    public void setHorariIniciDescans(int horariIniciDescans) {
        this.horariIniciDescans = horariIniciDescans;
    }

    public int getTempsTotalDescans() {
        return tempsTotalDescans;
    }

    public void setTempsTotalDescans(int tempsTotalDescans) {
        this.tempsTotalDescans = tempsTotalDescans;
    }

    public Grill getGrill() {
        return grill;
    }

    public int getTempsEspera() {
        return tempsEspera;
    }

    public void setTempsEspera(int tempsEspera) {
        this.tempsEspera = tempsEspera;
    }

    public AreaBuffet getAreaBuffet() {
        return areaBuffet;
    }

    @Override
    public void run() {

            try {

                cuinar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

}
