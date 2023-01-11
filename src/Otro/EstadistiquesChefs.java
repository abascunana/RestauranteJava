package Otro;

public class EstadistiquesChefs {
    //estadísticas generales de los chefs
    public long tempsDescansChef;
    public long platsCuinatChef;
    public int[] chefsPerEstat = new int[3];

    public long getTempsDescansChef() {
        return tempsDescansChef;
    }

    public void setTempsDescansChef(long tempsDescansChef) {
        this.tempsDescansChef = tempsDescansChef;
    }

    public long getPlatsCuinatChef() {
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
