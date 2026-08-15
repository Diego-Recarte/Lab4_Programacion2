
package lab4_prog2;

public class AhorcadoPalabraFija extends JuegoAhorcado {

    public AhorcadoPalabraFija(String palabraFija) {

        super();

        if (palabraFija == null ||
            palabraFija.trim().isEmpty()) {

            throw new IllegalArgumentException(
                "La palabra secreta no puede estar vacía."
            );
        }

        palabraFija = palabraFija.trim().toLowerCase();

        this.palabraSecreta = palabraFija;

        this.palabraMostrada =
            new char[this.palabraSecreta.length()];

        for (int i = 0;
             i < this.palabraMostrada.length;
             i++) {

            this.palabraMostrada[i] = '_';
        }
    }

    @Override
    public boolean verificarLetra(char letra) {

        char letraNormalizada =
            normalizarLetra(letra);

        for (int i = 0;
             i < palabraSecreta.length();
             i++) {

            char letraSecreta =
                normalizarLetra(
                    palabraSecreta.charAt(i)
                );

            if (letraSecreta == letraNormalizada) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void actualizarPalabraMostrada(char letra) {

        char letraNormalizada =
            normalizarLetra(letra);

        for (int i = 0;
             i < palabraSecreta.length();
             i++) {

            char letraSecreta =
                normalizarLetra(
                    palabraSecreta.charAt(i)
                );

            if (letraSecreta == letraNormalizada) {

                palabraMostrada[i] =
                    palabraSecreta.charAt(i);
            }
        }
    }

    @Override
    public boolean determinarVictoria() {

        for (char c : palabraMostrada) {

            if (c == '_') {
                return false;
            }
        }

        return true;
    }
}