package Otro;

public class ColaPlatsCuinats extends BufferPlats{

    private int capacitatMaxima;
    private int quantitatActual;
    public AreaBuffet areaBuffet;


    public AreaBuffet getAreaBuffet() {
        return areaBuffet;
    }

    public void setAreaBuffet(AreaBuffet areaBuffet) {
        this.areaBuffet = areaBuffet;
    }
    public ColaPlatsCuinats(int capacitatMaxima) {
        super(capacitatMaxima);
        this.capacitatMaxima = capacitatMaxima;
    }
@Override
    public synchronized void afegirplat() {
        while(quantitatActual == capacitatMaxima) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        quantitatActual++;
        if (getAreaBuffet().getQuantitatActual() < getAreaBuffet().getCapacitatMaxima()){
            retirarPlat();
            getAreaBuffet().afegirplat();
        }
        notifyAll();
    }
@Override
    public synchronized void retirarPlat(){
        while(quantitatActual == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        quantitatActual--;
        notifyAll();

    }
}
