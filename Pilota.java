import javax.swing.plaf.TableHeaderUI;

public class Pilota implements Runnable{

    //Si tiene in considerazione che 15 giri = 5 secondi
    //Tempo per spogliarsi: 1s

    //5000ms e rilasciare la pista
    //1000ms e rilasciare lo spogliatoio

    public static final int NPILOTI = 8;
    public static final int MAXPISTA = 4;
    public static final int MAXSPOGLIATOI = 2;

    public static int nInPista = 0;
    public static int nInSpogliatoi = 0;


    String name;

    public Pilota(String name){
        this.name = name;
    }

    @Override
    public void run(){
        try {
            entraSpogliatoi();
            entraPista();

            effettuaGiriPista();

            lasciaPista();
            lasciaSpogliatoi();


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void entraSpogliatoi() throws InterruptedException {

        while (nInSpogliatoi >= MAXSPOGLIATOI){
            wait();
        }
        System.out.println("Il pilota " + name + " è nello spogliatoio");
        Thread.sleep(1000);
        nInSpogliatoi++;

    }

    private synchronized void entraPista() throws InterruptedException {

        while (nInPista >= MAXPISTA){
            wait();
        }
        System.out.println("Il pilota " + name + " è nello pista");
        nInPista++;
    }

    private synchronized void effettuaGiriPista() throws InterruptedException {
        System.out.println("Il pilota " + name + "ha iniziato");
        Thread.sleep(5000);
        System.out.println("Il pilota " + name + " ha terminato");
    }

    private synchronized void lasciaPista() throws InterruptedException{
        System.out.println("Il pilota " + name + " ha lasciato la pista");
    }

    private synchronized void lasciaSpogliatoi() throws InterruptedException{
        System.out.println("Il pilota " + name + " ha lasciato lo spogliatoio");
        Thread.sleep(1000);
    }



}
