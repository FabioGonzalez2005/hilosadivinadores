package hilosadivinadores;

public class HilosAdivinadores {

    public static void main(String[] args) {
        NumeroOculto numeroOculto = new NumeroOculto();
        Thread[] adivinadores = new Thread[10];

        for (int i = 0; i < adivinadores.length; i++) {
            adivinadores[i] = new Thread(new Hilos(i + 1, numeroOculto));
            adivinadores[i].start();
        }
        
        for (Thread adivinador : adivinadores) {
            try {
                adivinador.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Juego terminado. El número oculto era: " + numeroOculto.getNumeroOculto());
    }
}
   
