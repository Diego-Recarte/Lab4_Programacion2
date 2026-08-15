package lab4_prog2;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import javax.swing.*;
public abstract class JuegoAhorcado {
    protected String palabraSecreta;
    protected char[] palabraMostrada;
    protected int intentosRestantes;
    protected final int Maxintentos = 6;
    protected List<Character> letrasIngresadas;
    protected JLabel[] figuraAhorcado;
    public JuegoAhorcado() {
        this.intentosRestantes = Maxintentos;
        this.letrasIngresadas = new ArrayList<>();
        this.figuraAhorcado = new JLabel[6];
        
        InicializarfiguraAhorcado();
    }
    public abstract void actualizarPalabraMostrada(char letra);
    public abstract boolean verificarLetra(char letra);
    public abstract boolean determinarVictoria();
    public boolean procesarJugada(char letra) throws LetraInvalidaException, LetraRepetidaException {
        if (!Character.isLetter(letra)) {
            throw new LetraInvalidaException("Debes ingresar solo una letra, sin números ni símbolos.");
        }
        char letraNormalizada = normalizarLetra(letra);
        if (letrasIngresadas.contains(letraNormalizada)) {
            throw new LetraRepetidaException("Ya ingresaste la letra '" + letra + "' antes.");
        }
        letrasIngresadas.add(letraNormalizada);
        if (verificarLetra(letraNormalizada)) {
            actualizarPalabraMostrada(letraNormalizada);
            return true;
        } else {
            intentosRestantes--;
            return false;
        }
    }
    protected char normalizarLetra(char c) {
        c = Character.toLowerCase(c);
        switch (c) {
            case 'á': return 'a';
            case 'é': return 'e';
            case 'í': return 'i';
            case 'ó': return 'o';
            case 'ú': return 'u';
            default: return c;
        }
    }
    protected JLabel[] InicializarfiguraAhorcado(){
        for (int i = 0; i < figuraAhorcado.length; i++) {
        figuraAhorcado[i] = new JLabel();
        figuraAhorcado[i].setHorizontalAlignment(JLabel.CENTER);
        figuraAhorcado[i].setVerticalAlignment(JLabel.CENTER);

        ImageIcon icono = new ImageIcon(""); // ruta de la imagen
        figuraAhorcado[i].setIcon(icono);
        }

    return figuraAhorcado;
        
        
        
        
    }
    public int getIntentosRestantes() { return intentosRestantes; }
    public char[] getPalabraMostrada() { return palabraMostrada; }
    public List<Character> getLetrasIngresadas() { return letrasIngresadas; }
    public JLabel[] getFiguraAhorcado() { return figuraAhorcado; }
}