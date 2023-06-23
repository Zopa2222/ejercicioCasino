Sofia Medina Riquelme
# ejercicioCasino
Ejercicio de ayudantía del ramo POO

Análisis del problema:
Debido a que es necesario implementar el juego 'Blackjack' se requiere lo siguiente:
 -Que exista un mazo con 52 cartas para utilizar en cada partida
 -Cada carta tiene una pinta (corazón, trébol, diamante, pica) y un símbolo o valor (1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)

Y para realizar cada partida se crearon las siguientes clases:
 -Main: Su única función es la generación de la partida.
 -Partida: Es la clase encargada de realizar la partida y mostrar el 
  resultado.
 -Jugador: Es la clase plantilla de cada jugador, con su respectiva mano de 
  cartas propias.
 -Mazo: Clase encargada del mazo de la partida, instanciando las 52 cartas, 
  además se encarga de administrar el mismo, descartando las cartas 
  entregadas a cada jugador.
 -Carta: Es la plantilla usada para cada carta del mazo.

Decisiones al momento de programar:
 -Se encapsulan todos los atributos como privados.
 -La mayoría de los métodos se encapsularon de forma pública, únicamente los utilizados sólo por la misma clase a la que
  pertenecen y no desde otra se encapsularon de forma privada.
 -Debido a la funcionalidad del programa se asume que siempre se requiere de un mazo lleno de cartas en desorden al inicio de   cada partida, por lo que cada vez que se instancie un mazo este tendrá las 52 cartas distintas en desorden.

Análisis de los cambios:
Lo primero que se puede ver es la cantidad de métodos dentro de cada clase. Se agregaron más métodos con el fin de distribuir de mejor forma las acciones y mantener una de las buenas prácticas en la programación. A la clase Carta se le agregó el atributo 'Valor' con el fin de acceder más fácilmente al valor de cada carta sin tener que gestinar su símbolo. A la clase Jugador se le agregó el atributo 'puntaje' para gestionar de mejor forma el puntaje de cada jugador y no sólo como variable. Y por último, el cambio visible desde el nuevo diagrama de clases es el tipo de relación entre la clase Carta con las clases Jugador y Mazo, son asociaciones debido a que los atributos 'Mano' y 'Cartas' son ArrayList llenos de objetos de tipo Carta respectivamente.

Tercera entrega----------------------------------------------------------------------------------------------------

Cambios:
-Se crea la clase 'Casino', encargada de dar la bienvenida y registrar a cada nuevo usuario, además de preguntar el juego del que quiere participar y comenzar con la ejecución. Dependiendo de la respuesta.
-Se cambia el nombre de la ex-clase 'Jugador' a 'JugadorBlackJack' con el fin de de separala de la nueva clase 'JugadorBullseye', además se crea la clase 'Usuario' y se define como una clase 'padre', con el fin de que las 2 clases jugador hereden los datos del usuario.
-Se cambia el nombre de la ex-clase 'Partida' a 'PartidaBlackJack' con el fin de de separala de la nueva clase 'PartidaBullseye', para separar cada juego.

Decisiones al momento de programar:
-Debido a las indicaciones del problema, cada jugador de Bullseye se genera automáticamente con un monto inical para apostar     de 50.000.
-Se crea la clse 'Tools' que servirá para las verificaciones al momento de ingresar información mediante la consola.
-Se crea la clase 'Caballo' para poder generar los caballos de carrera.
-Como el enfoque del programa es con un jugador directo, se decide no mostrar el el caballo ganador ni el jugador ganador, sino que se le informa al usuario registrado si ha ganado o perdido al finalizar la carrera.
-Por la misma razón que el punto anterior, cada jugador extra generado a parte del registrado desde la clase 'Casino' se queda con el monto de apuesta inicial, que es de 50.000.

Análisis:
La relación entre la clase 'Caballo' y 'JugadorBullseye' es una asociación unidireccional debido a que a cada jugador se le asigna como atributo el caballo al cual le realizó la apuesta, pero el caballo no necesita saber quien apostó por él. Luego la clase 'PartidaBullseye' depende de las clases 'Caballo' y 'JugadorBullseye' ya que instancia objetos de estos tipos y utiliza métodos de los mismos, y depende de 'Tools' ya que utiliza sus métodos para realizar las validaciones de Input dela consola.

Cuarta entrega--------------------------------- ----------------------------------------------------------------------------
Se clasificaron las clases en 3 diferentes paquetes:
-Launcher (Lanzador)
-Org.example (Contexto problema)
-Gui (Gestion de ventanas): Se crearon 4 clases:
 -VentanaPrincipal: Plantilla encargada de la primera ventana que ve el usuario, mediante la cual puede acceder a las otras 2.
 -VentanaBlackjack: Plantilla de la ventana que usa el método relacionado con el juego 'Blackjack'.
 -VentanaBullseye: Plantilla de la ventana usada en el juego 'Bullseye', que llama a la clase con contexto de este juego.
 -Controlador: Instancia las 3 ventanas anteriores y tiene métodos que permiten abrirlas y cerrarlas.

Además se modificaron métodos dentro del contexto problema con el fin de que no interfieran con el funcionamiento de las ventanas.
