public class PrincipalEstricte {
    public static void main(String[] args) throws InterruptedException {
        Fil juan = new Fil("Juan", Thread.NORM_PRIORITY, 100, false);
        Fil pepe = new Fil("Pepe", Thread.NORM_PRIORITY, 100, false);
        System.out.println("Termina thread main");
        juan.start();
        Thread.sleep(50); 
        pepe.start();
    }
}
