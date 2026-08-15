package lab4_prog2;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class JuegoAhorcado {

    protected String palabraSecreta;
    protected char[] palabraMostrada;
    protected int intentosRestantes;
    protected final int MAX_INTENTOS = 6;
    protected List<Character> letrasIngresadas;

    protected JLabel[] figura;
    protected List<String> figuraAhorcado;

    public JuegoAhorcado() {

        this.intentosRestantes = MAX_INTENTOS;
        this.letrasIngresadas = new ArrayList<>();
        this.figuraAhorcado = new ArrayList<>();
        this.figura = new JLabel[6];

        InicializarfiguraAhorcado();
    }

    public abstract void actualizarPalabraMostrada(char letra);

    public abstract boolean verificarLetra(char letra);

    public abstract boolean determinarVictoria();

    public boolean procesarJugada(char letra)
            throws IllegalArgumentException {

        if (!Character.isLetter(letra)) {
            throw new IllegalArgumentException(
                "Error: El carácter '" + letra +
                "' no es válido. Ingresa solo letras."
            );
        }

        char letraNormalizada = normalizarLetra(letra);

        if (letrasIngresadas.contains(letraNormalizada)) {
            return false;
        }

        letrasIngresadas.add(letraNormalizada);

        if (verificarLetra(letraNormalizada)) {

            actualizarPalabraMostrada(letraNormalizada);

        } else {

            if (intentosRestantes > 0) {
                intentosRestantes--;
            }

            if (figuraAhorcado.size() < MAX_INTENTOS) {
                figuraAhorcado.add(
                    "error_" + figuraAhorcado.size()
                );
            }
        }

        return true;
    }

    protected char normalizarLetra(char c) {

        c = Character.toLowerCase(c);

        switch (c) {

            case 'á':
            case 'à':
            case 'ä':
            case 'â':
                return 'a';

            case 'é':
            case 'è':
            case 'ë':
            case 'ê':
                return 'e';

            case 'í':
            case 'ì':
            case 'ï':
            case 'î':
                return 'i';

            case 'ó':
            case 'ò':
            case 'ö':
            case 'ô':
                return 'o';

            case 'ú':
            case 'ù':
            case 'ü':
            case 'û':
                return 'u';

            default:
                return c;
        }
    }

    protected JLabel[] InicializarfiguraAhorcado() {

        for (int i = 0; i < figura.length; i++) {

            figura[i] = new JLabel();

            figura[i].setHorizontalAlignment(
                JLabel.CENTER
            );

            figura[i].setVerticalAlignment(
                JLabel.CENTER
            );

            ImageIcon icono =
                new ImageIcon(
                    "src/imagenes/" + (i + 1) + ".jpg"
                );

            figura[i].setIcon(icono);
            figura[i].setVisible(false);
        }

        return figura;
    }

    public int getIntentosRestantes() {
        return intentosRestantes;
    }

    public int getMaxIntentos() {
        return MAX_INTENTOS;
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

    public JLabel[] getFigura() {
        return figura;
    }

    public String getPalabraSecreta() {
        return palabraSecreta;
    }
}