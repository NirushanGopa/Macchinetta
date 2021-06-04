
package macchinetta;

import java.util.concurrent.Semaphore;

//classe buffer
public class Macchinetta {
    
    private int buffer;

    private Semaphore coda = new Semaphore(1);
    private Semaphore vuoto = new Semaphore(0);
    
    public Macchinetta(int aranciateIniziali) {
        buffer = aranciateIniziali;
    }
    
    public void rifornisci(int qta){
        
        try {
            vuoto.acquire();
        } catch (InterruptedException ex) {}
        System.out.println("Rifornitore rifornisce la macchinetta con " + qta + " aranciate\n");
        
        buffer = qta;
        
        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {}
        
        synchronized(this){
            this.notify(); //sveglia il thread che attende il rifornimento
        }
    }
    
    public int prendiAranciata(String nome){

        try {
            coda.acquire();
        } catch (InterruptedException ex) {}
        
        if(buffer == 0){
            System.out.println("\n" + nome + " trova la macchinetta vuota e chiama il rifornitore");
            vuoto.release();
            
            synchronized(this){ //in questo blocco si attende che il rifornimento
                try {
                    this.wait();
                } catch (InterruptedException ex) {}
            }
            
        }
        
        System.out.println(nome + " prende l'aranciata n." + buffer);
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {}
        
        int tmp = buffer;
        buffer--;
        
        coda.release();
        
        return tmp;
    }
    
}