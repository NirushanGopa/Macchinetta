
package macchinetta;

//produttore
public class Rifornitore extends Thread{ 
    
    private Macchinetta m;
    private int numClienti;
    private int M; //quantitÃ  di aranciate da rifornire

    public Rifornitore(Macchinetta m, int numClienti, int M) {
        this.m = m;
        this.M = M;
        this.numClienti = numClienti/M;
    }
    
    @Override
    public void run() {
        while (numClienti > 0){            
            m.rifornisci(M);
            numClienti--;
        }
    }
}