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
    private long tempsTotalCuinant;
    private long tempsNoDescans;
    private long nombrePlatsCuinats;
    private long horariIniciDescans;
    private long tempsTotalDescans;
    private Grill grill;
    private long tempsEspera;
    private Rellotge rellotge;
    private AreaBuffet areaBuffet;
    private int Platos=0;
    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    boolean paused;


    public Estadistiques getStats() {
        return stats;
    }

    public void setStats(Estadistiques stats) {
        this.stats = stats;
    }

    private Estadistiques stats;


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
        this.areaBuffet = areaBuffet;
        this.status = new EstadistiquesChefs();

    }
                                                                              
    public  void cuinar() throws InterruptedException {

        while (this.getAreaBuffet().getColaPlatCuinats().getQuantitatActual() < this.getAreaBuffet().getCapacitatMaxima()) {
                this.grill.setEnServei(true);

                this.setEstatchef(Estatchef.cuinant);

                boolean cocinado = false;
                long minInicio;
                minInicio = this.getRellotge().getMinutActual();
            System.out.println("cocinando");
                while (!cocinado) {

                    tempsTotalCuinant++;
                    //Relojproblema
                    //getRellotge().getMiliEnMinuts(getHorariIniciDescans())
                    if (this.getRellotge().getInterval(minInicio) >= 3000) {

                        cocinado = true;
                        descansar();
                        entregarPlat();

                    }
                }
            }
        this.grill.setEnServei(false);
        }






    public void descansar() throws InterruptedException {

            this.setEstatchef(Estatchef.descansant);
            Random rm = new Random();
            long numbre = rm.nextInt(this.getRm().getPs().tempsDescans.getMin(), this.getRm().getPs().tempsDescans.getMax());
            System.out.println("descansando");
            tempsTotalDescans+=1;
            status.setTempsDescansChef(tempsTotalDescans);
            //ESTO HACE LA SIMULACIÓN MÁS REALISTA PERO ESPERA TODOS LOS MINUTOS, QUITAR SI SE VE NECESARIO
        //Thread.sleep(this.getRellotge().getMiliEnMinuts(numbre));
            //Thread.sleep(this.getRellotge().minutsEnMilisegons(numbre));
        Thread.sleep(3000);
    }
    public void entregarPlat() throws InterruptedException {

            System.out.println("entregando");
            this.setEstatchef(Estatchef.entregant);
            Platos+=1;
            status.setPlatsCuinatChef(Platos);
        Thread.sleep(3000);
            this.getGrill().afegirplat();


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


    public long getTempsTotalCuinant() {
        return tempsTotalCuinant;
    }

    public void setTempsTotalCuinant(long tempsTotalCuinant) {
        this.tempsTotalCuinant = tempsTotalCuinant;
    }

    public long getTempsNoDescans() {
        return tempsNoDescans;
    }

    public void setTempsNoDescans(long tempsNoDescans) {
        this.tempsNoDescans = tempsNoDescans;
    }

    public long getNombrePlatsCuinats() {
        return nombrePlatsCuinats;
    }

    public void setNombrePlatsCuinats(long nombrePlatsCuinats) {
        this.nombrePlatsCuinats = nombrePlatsCuinats;
    }

    public long getHorariIniciDescans() {
        return horariIniciDescans;
    }

    public void setHorariIniciDescans(long horariIniciDescans) {
        this.horariIniciDescans = horariIniciDescans;
    }

    public long getTempsTotalDescans() {
        return tempsTotalDescans;
    }

    public void setTempsTotalDescans(long tempsTotalDescans) {
        this.tempsTotalDescans = tempsTotalDescans;
    }

    public Grill getGrill() {
        return grill;
    }

    public long getTempsEspera() {
        return tempsEspera;
    }

    public void setTempsEspera(long tempsEspera) {
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
