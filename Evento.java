public class Evento{
    
    public int count = 0;
    
    private int idEvento;
    private int bigliettiDisponibili;

    //Costruttore
    public Evento(int bigliettiDisponibili){
        this.idEvento = count++;
        this.bigliettiDisponibili = bigliettiDisponibili;
    }

    public int getBigliettiDisponibili(){
        return bigliettiDisponibili;
    }

    public int ottieniLotto(){
        System.out.println("Ottenimento Biglietti..");
        int lotto = (int) (Math.random()*30); //Numero Casuale Da 1 A 30 ( 30 = max - min + 1)

        return lotto;
    }

    public String toString(){
        return ("Evento: " + idEvento + "(Biglietti Disponibili: " + bigliettiDisponibili + " )" );
    }
}