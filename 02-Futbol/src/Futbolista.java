public class Futbolista extends Thread {
    
    public static final int NUM_JUGADORS = 11;
    public static final int NUM_TIRADES = 20;
    public static final float PROBABILITAT = 0.5f;

    private int ngols;
    private int ntirades;


    public Futbolista(String nom){
        super(nom);
        this.ngols = 0;
        this.ntirades = 0;
    }

    @Override 
    public void run(){
        for(int i = 0; i < NUM_TIRADES; i++){
            ntirades++;
            if(Math.random() < PROBABILITAT){
                ngols++;
            }
        }
    }

    public int getNgols() {
        return ngols;
    }

    public int getNtirades() {
        return ntirades;
    }

    public static void main(String[] args) throws InterruptedException {
        String[] noms = {"Piqué", "Vinicius", "Torres", "Ramos", "Ronaldo", "Lewan", "Belli", "Arnau", "Aspas", "Messi", "Mbappe"};

        Futbolista[] jugadors = new Futbolista[noms.length];
        for(int i = 0; i < noms.length; i++){
            jugadors[i] = new Futbolista(noms[i]);
        }

        System.out.println("Inici dels xuts --------------------");
        for (Futbolista f : jugadors) {
            f.start();
        }

        System.out.println("Fi dels xuts------------------");
        for (Futbolista f: jugadors){
            f.join();
        }

        System.out.println("-------Estadistiques-------");
        for (Futbolista f : jugadors){
            System.out.printf("%-8s -> %2d gols%n", f.getName(), f.getNgols());
        }

    }
}
