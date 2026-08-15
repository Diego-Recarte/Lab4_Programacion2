package lab4_prog2;

public class AhorcadoPalabraAzar extends JuegoAhorcado {

    public AhorcadoPalabraAzar(AdministradorPalabras administradora) {
        super();
        
        String palabraObtenida = administradora.obtenerPalabraAzar();
        if (palabraObtenida != null) {
            this.palabraSecreta = palabraObtenida.toLowerCase();
        } else {
            this.palabraSecreta = ""; 
        }
        
        this.palabraMostrada = new char[this.palabraSecreta.length()];
        for (int i = 0; i < this.palabraMostrada.length; i++) {
            this.palabraMostrada[i] = '_';
        }
    }

    @Override
    public boolean verificarLetra(char letraNormalizada) {
        for (int i = 0; i < palabraSecreta.length(); i++) {
            char letraDeLaPalabra = normalizarLetra(palabraSecreta.charAt(i));
            if (letraDeLaPalabra == letraNormalizada) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void actualizarPalabraMostrada(char letraNormalizada) {
        for (int i = 0; i < palabraSecreta.length(); i++) {
            char letraDeLaPalabra = normalizarLetra(palabraSecreta.charAt(i));
            if (letraDeLaPalabra == letraNormalizada) {
                this.palabraMostrada[i] = palabraSecreta.charAt(i);
            }
        }
    }

    @Override
    public boolean determinarVictoria() {
        for (char c : this.palabraMostrada) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }
}