package Otro;

public class ParametresSimulacio {
    public int maxPlatsAreaBuffet;
    public int limitPlatsenCoa;
    public int maxPlatsGrill;
    public Rango tempsConsumir;
    public Rango tempsCoccio;
    public Rango numChef;
    public Rango numComensal;
    public Rango tempsTertulia;
    public  Rango tempsDescans;
    public Rango numChefPerGrill;
    public Rango tempsCuinant;





    public ParametresSimulacio(int maxPlatsAreaBuffet, int limitPlatsenCoa, int maxPlatsGrill) {
        this.maxPlatsGrill = maxPlatsGrill;
        this.maxPlatsAreaBuffet = maxPlatsAreaBuffet;
        this.limitPlatsenCoa = limitPlatsenCoa;
        this.tempsConsumir = new Rango(8,10);
        this.tempsCoccio = new Rango(4,8);
        this.numChef= new Rango(4,9);
        this.numComensal=  new Rango(10,36);
        this.tempsTertulia= new Rango(5,15);
        this.tempsDescans= new Rango(2,12);
        this.numChefPerGrill= new Rango(1,3);
        this.tempsCuinant=new Rango(60,120);
    }




}
