package Otro;
import Modelo.RestaurantModel;

public class Grill extends BufferPlats {

    private AreaBuffet areaBuffet;
    private RestaurantModel rm;
    private boolean enServei;
    private ColaPlatsCuinats colaPlatCuinats;

    public AreaBuffet getAreaBuffet() {
        return areaBuffet;
    }

    public void setAreaBuffet(AreaBuffet areaBuffet) {
        this.areaBuffet = areaBuffet;
    }

    public RestaurantModel getRm() {
        return rm;
    }

    public void setRm(RestaurantModel rm) {
        this.rm = rm;
    }

    public ColaPlatsCuinats getColaPlatCuinats() {
        return colaPlatCuinats;
    }

    public void setColaPlatCuinats(ColaPlatsCuinats colaPlatCuinats) {
        this.colaPlatCuinats = colaPlatCuinats;
    }


    @Override
    public synchronized void afegirplat() {
   getColaPlatCuinats().afegirplat();
    }

    public synchronized void posarEnServei(){
        enServei = true;
    }
    public synchronized void treureDeServei(){
        enServei = false;
    }

    public boolean isEnServei() {
        return enServei;
    }

    public void setEnServei(boolean enServei) {
        this.enServei = enServei;
    }

    public Grill(AreaBuffet areaBuffet, int cm,ColaPlatsCuinats cps) {
        super(cm);
        this.areaBuffet = areaBuffet;
        this.posarEnServei();
        this.colaPlatCuinats =cps;

    }





}
