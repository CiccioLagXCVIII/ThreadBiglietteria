public class Venditore extends Thread {

    private Biglietteria biglietteria;
    public Cliente cliente;
    public Evento evento;
    public int idVenditore;
    public int bigliettiDisponibiliVenditore;

    //Costruttore
    public Venditore(Biglietteria b, Evento e, int id){
        biglietteria = b;
        evento = e;
        idVenditore = id;
        bigliettiDisponibiliVenditore = evento.ottieniLotto();
    }

    public int getIdVenditore(){
        return idVenditore;
    }

    public int getBigliettiVenditore(){
        return bigliettiDisponibiliVenditore;
    }

    //Metodo Che Vende Biglietti
    public void run(){
        try {
            biglietteria.vendiBiglietto(this);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

}
