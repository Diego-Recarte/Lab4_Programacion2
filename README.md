Douglas Romero
Diego Enamorado
Daniel Katan



 Mayúsculas y minúsculas:
Las vamos a tratar como equivalentes. En el código usamos la función `Character.toLowerCase(letra)`, lo que significa que el juego convierte todo a minúsculas . Da  igual si el jugador teclea una 'A' mayúscula o una 'a' minúscula; el sistema lo lee igual.
  Palabras con tildes y la letra Ñ:
  Las tildes:El jugador no necesita que su entrada coincida exactamente con el acento. Gracias al método `normalizarLetra()` que programamos, si la palabra secreta es "avión" y el jugador ingresa una 'o' sin tilde, el juego lo cuenta como un acierto válido. Eso sí, al revelar la letra en la pantalla, el código manda la 'ó' original con su acento para que ortográficamente se vea correcto.
La letra Ñ: Esta se maneja como una letra  independiente. El jugador sí tiene que teclear la 'ñ'  para adivinarla; si la palabra tiene 'ñ' y el jugador ingresa una 'n' normal, no se la vamos a valer y contará como un error.

Mensajes de error: las validaciones de letra inválida y letra repetida se manejan con excepciones propias (LetraInvalidaException, LetraRepetidaException) y se muestran temporalmente (2 segundos) en la interfaz mediante un label de error. La condición de intentos agotados no se trata como excepción, sino como resultado normal de fin de partida, y se muestra como mensaje final fijo indicando la palabra secreta
