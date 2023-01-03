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
        //TODO solucionar problema: en algún punto del código minutoactual se cambia a un valor negativo
        if (minutActual < 0) {

            System.err.println("EL RELOJ NO DEBERÍA DE DAR VALORES NEGATIVOS");

        }
        return minutActual;


    }

    public int getMultiplicadorTemps() {
        return multiplicadorTemps;
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
          // con el multiplicador a mil llega a 68788264
            minutActual = (this.getMinutActual()+1)*getMultiplicadorTemps();


        }
    }
}
