
package lab4_prog2;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdministradorPalabras {
    private List<String> palabrasDisponibles;
    private Random random;

    public AdministradorPalabras() {
        this.palabrasDisponibles = new ArrayList<>();
        this.random = new Random();
    }

    public void agregarPalabra(String nuevaPalabra) {
        if (!palabrasDisponibles.contains(nuevaPalabra)) {
            palabrasDisponibles.add(nuevaPalabra);
        } else {
        }
    }

    public String obtenerPalabraAzar() {
        if (palabrasDisponibles.isEmpty()) {
            return null; 
        }
        
        int indice = random.nextInt(palabrasDisponibles.size());
        return palabrasDisponibles.get(indice);
    }
} 