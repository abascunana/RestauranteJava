package Otro;

public class AreaBuffet extends BufferPlats{

    private ColaPlatsCuinats colaPlatCuinats;


    private String descripcio;

    @Override
    public synchronized void afegirplat() {
        super.afegirplat();
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
        //PARA QUÉ SIRVE ÑA DESCRIPCION ME CAGO EN TOD000
        this.colaPlatCuinats = new ColaPlatsCuinats(100);
        this.descripcio = descripcio;
    }

}





