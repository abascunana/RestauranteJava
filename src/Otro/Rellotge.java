package Otro;

import Modelo.RestaurantModel;
import com.sun.jdi.event.MethodExitEvent;

public class Rellotge implements Runnable{
    //Singleton
    private static Rellotge rellotge;

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    boolean paused;
    public static RestaurantModel getRm() {
        return rm;
    }

    public static void setRm(RestaurantModel rm) {
        Rellotge.rm = rm;
    }

    private static RestaurantModel rm;

    private static int minutActual;
    private static int multiplicadorTemps;




    private Rellotge() {
        this.minutActual = 0;
        this.multiplicadorTemps = 1;
    }




    public void testPaused() {
        if (this.isPaused()) {
            try {
                rm.pause();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                rm.play();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public int getMinutActual() {

        //Este sout cambia completamente el funcionamiento del programa :,,,)
        System.out.println(".");
        return minutActual;


    }

//Esto lo que hace es que cada actividad (descansar, cocinar...) pueda calcular el intervalo de inicio de actividad al tiempo transcurrido al realizar la actividad
    public int getInterval(int minutInicioActividad){
        return getMinutActual() - minutInicioActividad;
    }

    public int getMiliEnMinuts(int minutActual){
        return minutActual * 60000;
    }

    public int minutsEnMilisegons(int minutActual){
        return minutActual / 60000;
    }

    //Singleton
    public static Rellotge getInstance() {
        if (rellotge == null){
            rellotge = new Rellotge();
        }
        else {
            System.out.println("ya existe un reloj");
        }
        return rellotge;

    }


    @Override
        public void run() {
        while (true){
          //el programa para repentinamente porque eñ valor de minutactual da a parar en un valor que no puede ser almacenadp en un integer
          // con el multiplicador a mil llega a 687 882 64
            minutActual = (this.getMinutActual()+1)*multiplicadorTemps;
            if (minutActual < 0) {
                System.err.println("EL RELOJ NO DEBERÍA DE DAR VALORES NEGATIVOS");
                minutActual=0;
            }
            testPaused();



        }
    }
}
