import java.util.Random;

public class Motor extends Thread{
    
    private volatile int PotenciaObjectiu = 0;
    private int PotenciaActual = 0;
    private volatile boolean activatPrimerCop = false;
    private int numMotor;
    private Random RANDOM = new Random();


    public void setPotencia(int p){
        activatPrimerCop = true;
        PotenciaObjectiu = p;

    }

    public Motor(int numMotor){
        this.numMotor = numMotor;
    }

    @Override 
    public void run(){
        while (true){

            if(PotenciaActual == PotenciaObjectiu){
                
                if (PotenciaObjectiu == 0 && activatPrimerCop) {
                    return; 
                }
                dorm(100);
            } else {
                dorm(1000 + RANDOM.nextInt(1001));

                String text = "Incre.";
                if (PotenciaActual < PotenciaObjectiu){
                    PotenciaActual++;
                } else {
                    PotenciaActual--;
                    text = "Decre.";
                }
                if (PotenciaActual == PotenciaObjectiu) {
                    text = "FerRes";
                }
                System.out.println("Motor " + numMotor + ": " + text + " Objectiu: " + PotenciaObjectiu + " Actual: " + PotenciaActual);
            }
        }
    }

    private void dorm(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }

}
