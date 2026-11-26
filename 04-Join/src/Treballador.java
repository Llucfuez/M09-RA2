import java.util.Random;

public class Treballador extends Thread{

    private final float souAnualBrut;
    private final int edatIniciTreball;
    private final int edatFiTreball;
    private int edatActual;
    private float cobrat;
    private final Random random;

    public Treballador(String nom, float souAnualBrut, int edatIniciTreball, int edatFiTreball){
        super(nom);
        this.souAnualBrut = souAnualBrut;
        this.edatIniciTreball = edatIniciTreball;
        this.edatFiTreball = edatFiTreball;
        this.edatActual = 0;
        this.cobrat = 0.0f;
        this.random = new Random();
    }

    private void cobrar(){
        cobrat += (souAnualBrut / 12);
    }

    private void pagaImpostos(){
        cobrat -= (souAnualBrut / 12) * 0.24f;
    }

    @Override 
    public void run(){
        edatActual = edatIniciTreball;
        while (edatActual < edatFiTreball){
            for(int i = 0; i < 12; i++){
                cobrar();
                pagaImpostos();
            }
            edatActual++;
        }
    }

    public float getCobrat(){
        return cobrat;
    }

    public int getEdat(){
        return edatActual;
    }
}