package Otro;

public class ColaPlatsCuinats extends BufferPlats{
    public ColaPlatsCuinats(int capacitatMaxima) {
        super(capacitatMaxima);
    }

    @Override
    public synchronized void afegirplat() {
        super.afegirplat();
    }

    @Override
    public synchronized void retirarPlat() {
        super.retirarPlat();
    }
}
