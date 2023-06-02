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
  pertenecen y no desde otra de encapsularon de forma privada.
 -Debido a la funcionalidad del programa se asume que siempre se requiere de un mazo lleno de cartas en desorden, por lo que
  cada vez que se instancie un mazo este tendrá las 52 cartas distintas en desorden.

Análisis de los cambios:
Lo primero que se puede ver es la cantidad de métodos dentro de cada clase. Se agregaron más métodos con el fin de distribuir de mejor forma las acciones y mantener una de las buenas prácticas en la programación. A la clase Carta se le agregó el atributo 'Valor' con el fin de acceder más fácilmente al valor de cada carta sin tener que gestinar su símbolo. A la clase Jugador se le agregó el atributo 'puntaje' para gestionar de mejor forma el puntaje de cada jugador y no sólo como variable. Y por último, el cambio visible desde el nuevo diagrama de clases es el tipo de relación entre la clase Carta con las clases Jugador y Mazo, son asociaciones debido a que los atributos 'Mano' y 'Cartas' son ArrayList llenos de objetos de tipo Carta respectivamente.
