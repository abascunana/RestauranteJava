package Otro;

public class EstadistiquesComensals {
    public int tempsMenjantComensals;
    public int tempsTertuliaComensals;
    public int tempsEsperantComensals;
    public int[] comensalsPerEstat = new int[3];

    public EstadistiquesComensals(int tempsMenjantComensals, int tempsTertuliaComensals, int tempsEsperantComensals, int[] comensalsPerEstat) {
        this.tempsMenjantComensals = tempsMenjantComensals;
        this.tempsTertuliaComensals = tempsTertuliaComensals;
        this.tempsEsperantComensals = tempsEsperantComensals;
        this.comensalsPerEstat = comensalsPerEstat;
    }
}
