public class Cliente extends Thread {

    private Biglietteria biglietteria;
    public int idCliente;
    public int tipoPagamento;
    //tipoOperazione Rules:
    //  0   Pagamento Contanti
    //  1   Pagamento Carta
    public int numeroBiglietti;

    //Costruttore
    public Cliente(Biglietteria b, int id, int num, int tipo){
        biglietteria = b;
        idCliente = id;
        numeroBiglietti = num;
        tipoPagamento = tipo;
    }

    public String pagamentoToString(){
        String pagamento = "";
        if(tipoPagamento == 0){
            pagamento = "Contanti";
        } else if (tipoPagamento == 1){
            pagamento = "Carta";
        }
        return pagamento;
    }

    public int getBigliettiCliente(){
        return numeroBiglietti;
    }

    public int getIdCliente(){
        return idCliente;
    }

    public String toString(){
        return ("Cliente " + idCliente + ": " + numeroBiglietti + " Biglietti ( " + this.pagamentoToString() + " )" );
    }

    //Metodo Run
    public void run(){
        try {
            //Per evitare che si metta in coda appena creato si manda in sleep
            Thread.sleep((int)Math.random() * 200);
            biglietteria.mettiInCoda(this);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

}