package Otro;

public class ColaPlatsCuinats extends BufferPlats{


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
        super.afegirplat();
    }

    @Override
    public synchronized void retirarPlat() {
        super.retirarPlat();
    }
}
