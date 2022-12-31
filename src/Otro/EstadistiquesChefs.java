package Otro;

public class EstadistiquesChefs {
    //estadísticas generales de los chefs
    public int tempsDescansChef;
    public int platsCuinatChef;
    public int[] chefsPerEstat = new int[3];

    public int getTempsDescansChef() {
        return tempsDescansChef;
    }

    public void setTempsDescansChef(int tempsDescansChef) {
        this.tempsDescansChef = tempsDescansChef;
    }

    public int getPlatsCuinatChef() {
        return platsCuinatChef;
    }

    public void setPlatsCuinatChef(int platsCuinatChef) {
        this.platsCuinatChef = platsCuinatChef;
    }

    public int[] getChefsPerEstat() {
        return chefsPerEstat;
    }

    public void setChefsPerEstat(int[] chefsPerEstat) {
        this.chefsPerEstat = chefsPerEstat;
    }
}
