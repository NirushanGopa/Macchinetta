
package macchinetta;
import java.util.ArrayList;

public class Main {
    
    static int numClienti = 35;
    static int M = 10; //numero di aranciate riempite per volta
    
    public static void main(String[] args) {
        
        Macchinetta m = new Macchinetta(M);
        ArrayList<Cliente> clienti = new ArrayList<>();
        
        
        for (int i = 1; i < numClienti+1; i++) {
            clienti.add(new Cliente(m, "Clint["+i + "]"));
        }
        
        Rifornitore rif = new Rifornitore(m, clienti.size(), M);
        
        rif.start();
        for (int i = 0; i < clienti.size(); i++) {
            clienti.get(i).start();
        }
        
    }
}