package Otro;
import Modelo.RestaurantModel;

public class Grill extends BufferPlats {

    private AreaBuffet areaBuffet;
    private RestaurantModel rm;
    private boolean enServei;
    private BufferPlats colaPlatCuinats;

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

    public BufferPlats getColaPlatCuinats() {
        return colaPlatCuinats;
    }

    public void setColaPlatCuinats(BufferPlats colaPlatCuinats) {
        this.colaPlatCuinats = colaPlatCuinats;
    }


    @Override
    public synchronized void afegirplat() {
        super.afegirplat();
    }

    public synchronized void posarEnServei(){
        this.setEnServei(true);
    }
    public synchronized void treureDeServei(){
        this.setEnServei(false);
    }

    public boolean isEnServei() {
        return enServei;
    }

    public void setEnServei(boolean enServei) {
        this.enServei = enServei;
    }

    public Grill(AreaBuffet areaBuffet, int cm) {
        super(cm);
        this.areaBuffet = areaBuffet;
        this.posarEnServei();
        //No entiendo muy bien para que srve esta variable
        this.colaPlatCuinats = new BufferPlats(cm);

    }





}
