package hilosadivinadores;

import java.util.Random;

public class NumeroOculto {
    private final int numeroOculto;
    private boolean juegoTerminado;

    public NumeroOculto() {
        Random rand = new Random();
        this.numeroOculto = rand.nextInt(101);
        this.juegoTerminado = false;
    }

    synchronized public int propuestaNumero(int num) {
        if (juegoTerminado) {
            return -1;
        }
        if (num == numeroOculto) {
            juegoTerminado = true;
            return 1;
        }
        return 0;
    }

    public int getNumeroOculto() {
        return numeroOculto;
    }
}