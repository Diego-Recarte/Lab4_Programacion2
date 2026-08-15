package lab4_prog2;
import java.util.ArrayList;
import java.util.List;

public abstract class JuegoAhorcado {
    protected String palabraSecreta;
    protected char[] palabraMostrada;
    protected int intentosRestantes;
    protected final int MAX_INTENTOS = 6;
    protected List<Character> letrasIngresadas;
    protected List<String> figuraAhorcado;

    public JuegoAhorcado() {
        this.intentosRestantes = MAX_INTENTOS;
        this.letrasIngresadas = new ArrayList<>();
        this.figuraAhorcado = new ArrayList<>();
    }

    public abstract void actualizarPalabraMostrada(char letra);
    public abstract boolean verificarLetra(char letra);
    public abstract boolean determinarVictoria();

    public boolean procesarJugada(char letra) throws IllegalArgumentException {
        
        if (!Character.isLetter(letra)) {
            throw new IllegalArgumentException("Error: El carácter '" + letra + "' no es válido. Ingresa solo letras.");
        }

        char letraNormalizada = normalizarLetra(letra);

        if (letrasIngresadas.contains(letraNormalizada)) {
            return false; 
        }

        letrasIngresadas.add(letraNormalizada);

        if (verificarLetra(letraNormalizada)) {
            actualizarPalabraMostrada(letraNormalizada);
        } else {
            intentosRestantes--;
            figuraAhorcado.add("error_" + figuraAhorcado.size());
        }

        return true; 
    }

    protected char normalizarLetra(char c) {
        c = Character.toLowerCase(c);
        switch (c) {
            case 'á': return 'a';
            case 'é': return 'e';
            case 'í': return 'i';
            case 'ó': return 'o';
            case 'ú': case 'ü': return 'u';
            default: return c;
        }
    }

    public int getIntentosRestantes() {
        return intentosRestantes; 
    }
    public char[] getPalabraMostrada() { 
        return palabraMostrada; 
    }
    public List<Character> getLetrasIngresadas() { 
        return letrasIngresadas;
    }
    public List<String> getFiguraAhorcado() { 
        return figuraAhorcado;
    }
}