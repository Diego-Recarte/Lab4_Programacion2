package lab4_prog2;

public class AhorcadoPalabraAzar extends JuegoAhorcado {

    public AhorcadoPalabraAzar(
        AdministradorPalabras administradora
    ) {

        super();

        if (administradora == null) {

            throw new IllegalArgumentException(
                "El administrador de palabras no puede ser null."
            );
        }

        String palabraObtenida =
            administradora.obtenerPalabraAzar();

        if (palabraObtenida == null ||
            palabraObtenida.trim().isEmpty()) {

            throw new IllegalArgumentException(
                "No hay palabras disponibles para iniciar el juego."
            );
        }

        this.palabraSecreta =
            palabraObtenida.trim().toLowerCase();

        this.palabraMostrada =
            new char[this.palabraSecreta.length()];

        for (int i = 0;
             i < this.palabraMostrada.length;
             i++) {

            this.palabraMostrada[i] = '_';
        }
    }

    @Override
    public boolean verificarLetra(
        char letraNormalizada
    ) {

        letraNormalizada =
            normalizarLetra(letraNormalizada);

        for (int i = 0;
             i < palabraSecreta.length();
             i++) {

            char letraDeLaPalabra =
                normalizarLetra(
                    palabraSecreta.charAt(i)
                );

            if (letraDeLaPalabra ==
                letraNormalizada) {

                return true;
            }
        }

        return false;
    }

    @Override
    public void actualizarPalabraMostrada(
        char letraNormalizada
    ) {

        letraNormalizada =
            normalizarLetra(letraNormalizada);

        for (int i = 0;
             i < palabraSecreta.length();
             i++) {

            char letraDeLaPalabra =
                normalizarLetra(
                    palabraSecreta.charAt(i)
                );

            if (letraDeLaPalabra ==
                letraNormalizada) {

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