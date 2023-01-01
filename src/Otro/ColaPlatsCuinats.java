package Otro;

public class ColaPlatsCuinats extends BufferPlats{

    private int capacitatMaxima;
    private int quantitatActual;
    public AreaBuffet areaBuffet;
    public ColaPlatsCuinats(int capacitatMaxima) {
        super(capacitatMaxima);
    }

    public AreaBuffet getAreaBuffet() {
        return areaBuffet;
    }

    public void setAreaBuffet(AreaBuffet areaBuffet) {
        this.areaBuffet = areaBuffet;
    }
@Override
    public synchronized void afegirplat() {
        while(quantitatActual == capacitatMaxima) {
            try {
                System.out.println("dormido");

                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        quantitatActual++;

        notifyAll();
    }
@Override
    public synchronized void retirarPlat(){
        while(quantitatActual == 0) {
            try {
                System.out.println("Resucitado");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        quantitatActual--;
        notifyAll();

    }
}
