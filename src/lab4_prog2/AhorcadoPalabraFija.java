
package lab4_prog2;

public class AhorcadoPalabraFija extends JuegoAhorcado {

    public AhorcadoPalabraFija(String palabraFija) {
        super();
        this.palabraSecreta = palabraFija.toLowerCase();
        
        this.palabraMostrada = new char[this.palabraSecreta.length()];
        for (int i = 0; i < this.palabraMostrada.length; i++) {
            this.palabraMostrada[i] = '_';
        }
    }

    @Override
    public boolean verificarLetra(char letra) {
        return this.palabraSecreta.indexOf(letra) >= 0;
    }

    @Override
    public void actualizarPalabraMostrada(char letra) {
        for (int i = 0; i < this.palabraSecreta.length(); i++) {
            if (this.palabraSecreta.charAt(i) == letra) {
                this.palabraMostrada[i] = letra;
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
