package Otro;

public class Estadistiques {
    public EstadistiquesChefs chef;

    public EstadistiquesComensals comensals;
    public EstadistiquesBuffets areaBuffet;


    public Estadistiques(EstadistiquesChefs chef, EstadistiquesComensals comensals, EstadistiquesBuffets areaBuffet) {
        this.chef = chef;
        this.comensals = comensals;
        this.areaBuffet = areaBuffet;
    }

}
