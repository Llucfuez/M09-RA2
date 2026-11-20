import java.util.Random;

public class DormAleatori extends Thread{

    private final int NUM_ITERACIONS = 10; 
    private final long MOMENT_CREACIO;
    private final Random RANDOM = new Random();
    private final int INTERVAL_MAXIM = 1000;


    public DormAleatori(String nom){
        super(nom);
        this.MOMENT_CREACIO = System.currentTimeMillis();
    }


    @Override 
    public void run(){
        for (int i = 0; i < NUM_ITERACIONS; i++){
            int interval = RANDOM.nextInt(INTERVAL_MAXIM + 1);
            long totalTemps = System.currentTimeMillis() - MOMENT_CREACIO;

            System.out.println(String.format("%-4s(%d) a dormir %4dms total %5dms", getName(), i, interval, totalTemps));

            try{
                Thread.sleep(interval);
            } catch (InterruptedException e){
                System.out.println(getName() + " interromput");
                return;
            }

        }
    }

    public static void main(String[] args) {
        DormAleatori joan = new DormAleatori("Joan");
        DormAleatori pep = new DormAleatori("Pep");

        joan.start();
        pep.start();

        System.out.println("-- Fi de main -----------");
    }
}