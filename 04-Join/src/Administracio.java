public class Administracio {

    private final int num_poblacio_activa = 50;
    private final Treballador[] poblacio_activa = new Treballador[num_poblacio_activa];

    public Administracio() {
        for (int i = 0; i < num_poblacio_activa; i++) {
            poblacio_activa[i] = new Treballador("Ciutadà-" + i, 25000, 20, 65);
        }
    }

    public void iniciaSimulacio() {
        // Posem en marxa tots els fils
        for (Treballador t : poblacio_activa) {
            t.start();
        }

        // Esperem que acabin tots (sense això, mostraríem dades a mitges)
        for (Treballador t : poblacio_activa) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Estadístiques
        for (Treballador t : poblacio_activa) {
            System.out.printf("%-10s -> edat: %d / total: %.2f%n",
                    t.getName(), t.getEdat(), t.getCobrat());
        }
    }

    public static void main(String[] args) {
        new Administracio().iniciaSimulacio();
    }
}