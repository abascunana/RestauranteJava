package Otro;

public class EstadistiquesChefs {
    public int tempsDescansChef;
    public int platsCuinatChef;
    public int[] chefsPerEstat = new int[3];

    public EstadistiquesChefs(int tempsDescansChef, int platsCuinatChef, int[] chefsPerEstat) {
        this.tempsDescansChef = tempsDescansChef;
        this.platsCuinatChef = platsCuinatChef;
        this.chefsPerEstat = chefsPerEstat;
    }
}
