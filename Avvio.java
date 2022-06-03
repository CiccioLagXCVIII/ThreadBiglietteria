import java.util.concurrent.TimeUnit;

public class Avvio {

    public static final int NUMERO_VENDITORI = 4;
    public static final int NUMERO_CLIENTI = 10;
    public static final int MAX_BIGLIETTI_ACQUISTABILI = 5;

    public static void main(String[] args) {
        System.out.println("Avvio Biglietteria...");

        //Monitor
        Biglietteria biglietteria = new Biglietteria();

        //Ogni Venditore si occupa di un evento specifico (che avrà un numero casuale di biglietti)
        //Ognuno di questi avrà come argomento il monitor (Biglietteria), l'Evento e il suo id
        Venditore[] venditore = new Venditore[NUMERO_VENDITORI];
        for(int i=0; i < venditore.length; i++){
            Evento evento = new Evento( (int) Math.random()*30 ); //Numero Casuale Da 1 A 30 ( 30 = max - min + 1)
            venditore[i] = new Venditore(biglietteria, evento, i);
            venditore[i].start();
            //System.out.println("Venditore " +i + " Aperto!");
        }

        //Distacchiamo la creazione di Venditori e Clienti (stessa cosa di Thread.sleep(value) ma per
        //sospendere l'esecuzione del Main per un determinato numero di secondi, invece che millisecondi)
            try {
                Thread.sleep(5000); //Il Thread va in sleep per 3 secondi
            } catch (Exception e) {
                //TODO: handle exception
            }

        //Istanziamo un array con k Clienti, ognuno dei quali avrà come argomento il monitor (Biglietteria)
        //il suo id e il numero di biglietti che vuole acquistare
        Cliente[] cliente = new Cliente[NUMERO_CLIENTI];
        for(int i=0; i < cliente.length; i++){
            int numBigl = (int)((Math.random()*4) + 1);
            int pag = (int)((Math.random()*90) % 2);
            cliente[i] = new Cliente(biglietteria, i, numBigl, pag);
            //System.out.println("Cliente " + i + " Creato!");
            cliente[i].start();
        }

    }
}

