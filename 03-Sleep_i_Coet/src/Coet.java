import java.util.InputMismatchException;
import java.util.Scanner;

public class Coet {

    private static final int NUM_MOTORS = 4;
    private static final int POTENCIA_MIN = 0;
    private static final int POTENCIA_MAX = 10;

    private final Motor[] motors = new Motor[NUM_MOTORS];

    public Coet() {
        for (int i = 0; i < NUM_MOTORS; i++) {
            motors[i] = new Motor(i);
        }
    }

    public void passaAPotencia(int p) {
        if (p < POTENCIA_MIN || p > POTENCIA_MAX) {
            throw new IllegalArgumentException(
                    "Potència incorrecta: " + p + " (ha d'estar entre 0 i 10)");
        }
        System.out.println("Passant a potència " + p);
        for (Motor m : motors) {
            m.setPotencia(p);
        }
    }

    public void arranca() {
        for (Motor m : motors) {
            m.start();
        }
    }

    public void llegeixPotencies() {
        Scanner sc = new Scanner(System.in);
        int p = -1; 
        while (p != 0) {
            try {
                p = sc.nextInt();
                passaAPotencia(p);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                p = -1; 
            } catch (InputMismatchException e) {
                System.out.println("Valor no numèric");
                sc.next(); 
                p = -1;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Coet coet = new Coet();
        coet.arranca();
        coet.llegeixPotencies();

        for (Motor m : coet.motors) {
            m.join();
        }
    }
}