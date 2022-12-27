package Otro;

public  class BufferPlats {
    private int capacitatMaxima;
    private int quantitatActual;

    public BufferPlats(int capacitatMaxima) {
        this.capacitatMaxima = capacitatMaxima;
        this.quantitatActual = 0;

    }


    public int getCapacitatMaxima() {
        return capacitatMaxima;
    }

    public void setCapacitatMaxima(int capacitatMaxima) {
        this.capacitatMaxima = capacitatMaxima;
    }

    public int getQuantitatActual() {
        return quantitatActual;
    }

    public void setQuantitatActual(int quantitatActual) {
        this.quantitatActual = quantitatActual;
    }


    public synchronized void afegirplat() {
        while(quantitatActual == capacitatMaxima) {
            try {
                System.out.println("dormido");

                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
      quantitatActual++;

        notifyAll();
    }

    public synchronized void retirarPlat(){
        while(quantitatActual == 0) {
            try {
                System.out.println("Resucitado");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        quantitatActual--;
        notifyAll();

    }

}
