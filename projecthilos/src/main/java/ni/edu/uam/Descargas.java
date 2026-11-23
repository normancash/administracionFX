package ni.edu.uam;

public class Descargas {

    public static void main(String[] args) {
        Thread descarga1 = new Thread(
                ()->{
                    System.out.println("Descargando archivo A...");
                    try {
                        Thread.sleep(5000);
                    }
                    catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    System.out.println("Archivo descargado..A");
                }
        );
        Thread descarga2 = new Thread(
                ()->{
                    System.out.println("Descargando archivo B...");
                    try {
                        Thread.sleep(10000);
                    }
                    catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("Archivo descargado..B");
                }
        );
        descarga1.start();
        descarga2.start();
    }
}
