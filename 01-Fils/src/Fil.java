public class Fil extends Thread {
    private static final int FEINA = 1000;

    private final int delay;   
    private final boolean treball; 

    public Fil(String nom, int prioritat, int delay, boolean treball) {
        super(nom);
        setPriority(prioritat);
        this.delay = delay;
        this.treball = treball;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {
            System.out.println(getName() + " " + i);
            if (treball) {
                simulaFeina();
            }
            if (delay > 0) {
                
                    Thread.sleep(delay);
        }
        System.out.println("Acaba el fil " + getName());
    }

    private void simulaFeina() {
        long suma = 0;
        for (int j = 0; j < FEINA; j++) {
            suma += j;
        }
        if (suma < 0) System.out.print(""); 
    }
}
