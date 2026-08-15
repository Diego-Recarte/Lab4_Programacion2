package lab4_prog2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdministradorPalabras {

    private List<String> palabrasDisponibles;
    private Random random;

    public AdministradorPalabras() {

        palabrasDisponibles = new ArrayList<>();
        random = new Random();

        cargarPalabras();
    }

    private void cargarPalabras() {

        palabrasDisponibles.add("computadora");
        palabrasDisponibles.add("programacion");
        palabrasDisponibles.add("java");
        palabrasDisponibles.add("teclado");
        palabrasDisponibles.add("mouse");
        palabrasDisponibles.add("monitor");
        palabrasDisponibles.add("internet");
        palabrasDisponibles.add("algoritmo");
        palabrasDisponibles.add("variable");
        palabrasDisponibles.add("metodo");
        palabrasDisponibles.add("clase");
        palabrasDisponibles.add("objeto");
        palabrasDisponibles.add("herencia");
        palabrasDisponibles.add("polimorfismo");
        palabrasDisponibles.add("encapsulamiento");
        palabrasDisponibles.add("abstraccion");
        palabrasDisponibles.add("programador");
        palabrasDisponibles.add("software");
        palabrasDisponibles.add("hardware");
        palabrasDisponibles.add("servidor");
        palabrasDisponibles.add("base");
        palabrasDisponibles.add("datos");
        palabrasDisponibles.add("sistema");
        palabrasDisponibles.add("aplicacion");
        palabrasDisponibles.add("desarrollo");
    }

    public void agregarPalabra(String nuevaPalabra) {

        if (nuevaPalabra == null) {
            return;
        }

        nuevaPalabra = nuevaPalabra.trim().toLowerCase();

        if (nuevaPalabra.isEmpty()) {
            return;
        }

        if (!nuevaPalabra.matches(
            "[a-záéíóúüñ]+"
        )) {
            return;
        }

        if (!palabrasDisponibles.contains(nuevaPalabra)) {
            palabrasDisponibles.add(nuevaPalabra);
        }
    }

    public String obtenerPalabraAzar() {

        if (palabrasDisponibles.isEmpty()) {
            return null;
        }

        int indice =
            random.nextInt(
                palabrasDisponibles.size()
            );

        return palabrasDisponibles.get(indice);
    }

    public List<String> getPalabrasDisponibles() {
        return new ArrayList<>(
            palabrasDisponibles
        );
    }

    public int cantidadPalabras() {
        return palabrasDisponibles.size();
    }

    public boolean contienePalabra(
        String palabra
    ) {

        if (palabra == null) {
            return false;
        }

        return palabrasDisponibles.contains(
            palabra.trim().toLowerCase()
        );
    }
}