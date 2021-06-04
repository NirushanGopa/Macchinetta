
package macchinetta;

//consumatore
public class Cliente extends Thread{
    
    private Macchinetta m;
    protected int aranciata;

    public Cliente(Macchinetta m, String name) {
        super(name);
        this.m = m;
    }

    @Override
    public void run() {
        aranciata = m.prendiAranciata(super.getName());
    }
    
}