package hilosadivinadores;

import java.util.Random;

public class Hilos implements Runnable {
    private final int id;
    private final NumeroOculto numeroOculto;
    private static final Random random = new Random();

    public Hilos(int id, NumeroOculto numeroOculto) {
        this.id = id;
        this.numeroOculto = numeroOculto;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int numeroPropuesto = random.nextInt(101);
            System.out.println("Hilo " + id + " propone el número: " + numeroPropuesto);
            int resultado = numeroOculto.propuestaNumero(numeroPropuesto);
            if (resultado == 1) {
                System.out.println("El hilo " + id + " adivinó el número: " + numeroPropuesto);
                break;
            } else if (resultado == -1) {
                System.out.println("El hilo " + id + " se detiene porque otro hilo ya adivinó el número.");
                break;
            }
        }
    }
}