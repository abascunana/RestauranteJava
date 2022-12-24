package Otro;

public class Rellotge implements Runnable{
    //Singleton
    private static Rellotge rellotge;


    private static int minutActual;
    private static int multiplicadorTemps;

    private Rellotge() {
        this.minutActual = 0;
        this.multiplicadorTemps = 100;
    }



    public int getMinutActual() {
        return minutActual;
    }

    public synchronized void setMinutActual(int minutActual) {
        this.minutActual = minutActual;
    }

    public int getMultiplicadorTemps() {
        return multiplicadorTemps;
    }

    public void setMultiplicadorTemps(int multiplicadorTemps) {
        this.multiplicadorTemps = multiplicadorTemps;
    }

    public int convertirTemps(int temps){
        return temps * 1000;
    }

    public int getTemps(int temps){
        return temps;
    }


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
            setMinutActual(this.getMinutActual()+1*getMultiplicadorTemps());

        }
    }
}
