import java.util.PriorityQueue;

public class Biglietteria{
    
    MyComparator comparator = new MyComparator();
    private PriorityQueue<Cliente> codaBiglietti = new PriorityQueue<Cliente>(20, comparator);
    private Cliente clienteServito;

    //Il Cliente Entra E Si Mette In Coda
    public synchronized void mettiInCoda(Cliente cliente){
        System.out.println("Cliente " + cliente.idCliente + " Entra E Si Mette In Coda.");
        codaBiglietti.add(cliente);
        notifyAll();
    }

    //Acquisto Biglietti Pro
    public synchronized void vendiBiglietto(Venditore venditore){
        while(codaBiglietti.size() == 0){
            try{
                System.out.println("Venditore " + venditore.getIdVenditore() + " Attende L'Arrivo Di Clienti");
                wait();
            }catch (Exception e){
                //TODO: handle exception
            } 
        }
        
        /*for(int x=0; x<codaBiglietti.size(); x++){
            System.out.println(codaBiglietti.poll().toString());
        }*/

        while(codaBiglietti.size() != 0){
        //System.out.println(codaBiglietti.poll().toString());
        //System.out.println("Biglietti Venditore " + venditore.getIdVenditore() + ": " + venditore.getBigliettiVenditore()); 
        //System.out.println("Biglietti Cliente " + codaBiglietti.peek().idCliente + ": " + codaBiglietti.peek().numeroBiglietti);
        if( venditore.getBigliettiVenditore() > 0 && venditore.getBigliettiVenditore() > codaBiglietti.peek().getBigliettiCliente()){
            System.out.println("Il Venditore " + venditore.getIdVenditore() + " Serve Il Cliente " + codaBiglietti.peek().getIdCliente() + " ...");
            clienteServito = codaBiglietti.poll();
            //System.out.println(codaBiglietti);
            System.out.println("Ultimo Servito (Tolto Dalla Coda): " + clienteServito.toString());
        } else if(venditore.getBigliettiVenditore() == 0 || venditore.getBigliettiVenditore() < codaBiglietti.peek().getBigliettiCliente()){
            System.out.println("Venditore " + venditore.getIdVenditore() + " Non Ha Abbastanza Biglietti");
            System.out.println("Venditore " + venditore.getIdVenditore() + " Richiede Lotto...");
            venditore.bigliettiDisponibiliVenditore += venditore.evento.ottieniLotto();
            //Poichè Durante La Richiesta Dei Biglietti Non Può Venderne Allora Per Simulare L'Attesa Si Manda In Sleep
            try {
                Thread.sleep((int)Math.random() * 2500); //Da 1 a 2,5 Secondi
            } catch (Exception e) {
                //TODO: handle exception
            }
            System.out.println("Venditore " + venditore.getIdVenditore() + " Nuovo Lotto Ottenuto. Biglietti Rimanenti: " + venditore.getBigliettiVenditore());
        }
        
        notifyAll();
        }
    }

}