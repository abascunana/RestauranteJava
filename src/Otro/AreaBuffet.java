package Otro;

public class AreaBuffet extends BufferPlats{

    private ColaPlatsCuinats colaPlatCuinats;



    public Estadistiques stats;

    private Grill grill;

    public Grill getGrill() {
        return grill;
    }

    public void setGrill(Grill grill) {
        this.grill = grill;
    }

    private String descripcio;

    @Override
    public synchronized void afegirplat() {
        super.afegirplat();
    }

    public Estadistiques getStats() {
        return stats;
    }

    public void setStats(Estadistiques stats) {
        this.stats = stats;
    }

    @Override
    public synchronized void retirarPlat() {
        super.retirarPlat();
    }

    public ColaPlatsCuinats getColaPlatCuinats() {
        return colaPlatCuinats;
    }
    public void setColaPlatCuinats(ColaPlatsCuinats colaPlatCuinats) {
        this.colaPlatCuinats = colaPlatCuinats;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }


    public AreaBuffet(String descripcio, int cm) {
        super(cm);
        //TODO  no entiendo nada jodeeeeeeeeeeeeeeeeeeer
        this.colaPlatCuinats = new ColaPlatsCuinats(100);
        this.descripcio = descripcio;
    }

}





