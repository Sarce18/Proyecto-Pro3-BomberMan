OBJETIVO
Evaluar las habilidades de los estudiantes en cuanto al desarrollo de software, utilizando
conceptos de la Programación Orientada a Objetos y la aplicación de modelos de proceso
de desarrollo de software en la solución de problemas.
PLANTEAMIENTO DEL PROBLEMA
Bomberman es un videojuego originalmente desarrollado por Hudson Soft. El personaje
principal tiene un cuerpo azul, brazos y piernas blancas con un cinturón negro, la cabeza
está toda cubierta de color blanco, menos su frente, donde posee unas largas rayas
totalmente negras como ojos, pero no tiene pelo, nariz, ni orejas, sino que tiene una especie
de antena en su cabeza con una bola rosada en la punta. Los zapatos son rosados y no
tiene boca.
Su arma principal, como el nombre lo indica, es la fabricación y uso de bombas contra sus
enemigos.
El juego tiene lugar en una pantalla sin movimiento. La pantalla está conformada por una
cuadricula 7x6. La red limita el movimiento de los personajes por lo que sólo puede moverse
horizontalmente o verticalmente por la pantalla. Al pulsar el botón A hará que BomberMan
tire una bomba que cae sobre sus pies. Esta bomba tiene un tiempo límite lo cual permite
huir, dispara llamas horizontal y vertical. El juego gira en torno a la idea de utilizar estas
explosiones de bombas para destruir los muros y enemigos.

Si una bomba explota y la llama alcanza a la otra bomba esta hará que la segunda bomba
explote antes de tiempo. Esto puede provocar grandes reacciones en cadena.
La mayoría de los niveles tienen al comenzar paredes suaves de destruir con una bomba.
Si una bomba golpea estas paredes esta hará que se desintegre haciendo posible pasar a
otro lado.
Una vez que una bomba se coloca, por lo general es imposible caminar sobre ella hasta
que haya explotado. Esto conduce a la táctica de la capturar enemigos con bombas y
obligarlos a morir.
El Modo Multiplayer se centra en Batalla entre 4 jugadores, los cuales pueden ser personas
ó PC, entre escenario interactivos. El ganador será quien logre más copas antes que los
demás.
Bomberman puede encontrar Power-ups ocultos que le pueden ayudar durante los
diferentes niveles del juego, generalmente se encuentran al eliminar a un enemigo o un
objeto que puede ser destruido por Bomberman, como muros. Entre ellos están:
 Skates o boots: este objeto puede aumentar la velocidad de Bomberman
 Boot/bomb kick: da a Bomberman la capacidad de poder patear las bombas lejos de
él.
 Clog sandals: disminuyen la velocidad de Bomberman en algunos juegos de la serie.
 Mitts/power glove: Ayuda a Bomberman a poder agarrar bombas con las manos,
agigantarlas y hacerlas más poderosas para lanzarlas a sus enemigos y tengan mayor
alcance de explosión.
 Punching gloves: Permite a Bomberman golpear las bombas a cortas distancias para
destruir ciertas cosas en algunos juegos de la serie.
 Block wall pass: Ayuda a Bomberman a cruzar ciertos peligrosos lugares que podrían
desplomarse sin estos objetos. Si Bomberman le pega una bomba antes de cruzar
sobre un muro, éste cae y muere.
 Extra bombs: es un objeto en forma de bomba que le da más bombas a bomberman.
El máximo es de 4 o 9 bombas a la vez en algunos juegos de la serie.
 Mines: Permite convertir las bombas en minas y se hacen invisibles. Estas minas
explotan cuando hay alguien cerca de ella. La desventaja es que por la invisibilidad la
explosión puede matar a todos por igual, haciendo que el juego sea muy peligroso para
cada jugador.
 Bomb pass: Con esto Bomberman puede caminar entre las bombas, esto se cancela
con skates o boots.

 Detonator/bomb control: Bomberman puede controlar el tiempo de explosión de
cualquier bomba suya.
 Spiky bomb: Bomberman puede destruir sin fin de cajas u otros objetos que puedan
estar en el radio de alcance de esta bomba.
 Line bomb: Bomberman lanza directamente hacia la cara de su enemigo con esta
bomba y la cantidad que tenga disponible de estas bombas.
 Jelly bomb: esta bomba va a cualquier dirección al apenas patearla, es muy
incontrolable y no muy recomendable su uso (aunque puede usarse muy bien
estratégicamente).
 Egg: Es un huevo que contiene animales que Bomberman puede montarlos.
 Fire power: Un objeto en forma de fuego que aumenta el radio de explosión las
bombas.
 Cherry bomb: es un objeto con forma de bomba roja que hace más fuerte y peligrosa
la explosión de las bombas con una especie de color azul la explosión.
 Dirt bike: Es una bicicleta que ayuda a Bomberman a saltar muros y es muy útil para
escapar de explosiones.
 Salt bomb: es una bomba exclusiva para Bomberman Hero, esta explota y elimina a
todos los enemigos inmunes al fuego de una bomba normal. También aparece en
Bomberman Jetters.
Adicionalmente tiene elementos de Extra Vidas como:
 Fire suit/Flame proof jacket/Asbestos Vest: esto ayuda a Bomberman a ser invisible
a todos por 10 segundos, mas no esconde a las bombas, y el enemigo se percata si las
ve.
 Heart: es un corazón de vida para Bomberman, que si se hace daño durante el juego,
no muere, pero le arrancan el corazón, y otra vez vuelve a ser susceptible a morir. En
algunos juegos de la serie en vez de tener solo un corazón, se puede hasta tener varios.
 1-up: Si Bomberman muere, con esto puede volver a la vida, pero solo se tiene una
cantidad limitada de vidas.
Se pide desarrollar una solución informática para BomberMan edición Batalla considerando
lo siguiente:
 La partida se juega en Red. En ella deben participar mínimo 2 - máximo 4 jugadores.
 Cada participante estará representado por un BomberMan del color seleccionado
por el usuario.

 Se presentara un solo escenario de juego donde las paredes a destruir aparecerán
aleatoriamente. Tomar en cuenta diseño de la pantalla del juego original, para la
distribución de paredes que no pueden destruirse.
 Para este nivel sólo permitir colocar bombas y alejarse de ellas para evitar ser
destruido. Si una bomba alcanza a un contrincante este pierde una vida. Si alcanza
un Power-Ups o un Extra Vida, estos serán destruidos.
 Habilitar el uso y la aparición de los siguientes Power-Ups Extra bombs y Fire
power: Estos deben estar distribuidos aleatoriamente a lo largo del tablero. Habilitar
otros Power-ups queda de parte del equipo desarrollador.
 Habilitar el uso del siguiente comodín de Extra Vidas 1-up. Debe estar distribuido
aleatoriamente a lo largo de la pantalla y el incremento de vidas deberá visualizarse
en el jugador que lo tome. Habilitar otros Extra Vidas queda de parte del equipo
desarrollador
 En esta edición gana quien sobreviva al ataque de sus contrincantes.
Para el desarrollo de esta versión de BomberMan, deberá realizarse el análisis, diseño e
implementación de los módulos que se detallan a continuación.
MODULOS A DESARROLLAR
Módulo Jugar
Este módulo debe permitir al usuario jugar y configurar una nueva batalla. Para ello se
solicitará al usuario datos básicos para configurar la misma, entre ellos están: nickname,
BomberMan del color de su preferencia (siempre y cuando no haya sido seleccionado por
otro jugador). Mínimo deben estar conectados dos jugadores para poder iniciar batalla. Una
vez iniciada la partida el usuario podrá abandonar partida lo que implica que desaparecerá
del torneo sin afectar la participación de los otros jugadores. En caso de que quede un único
jugador este será el vencedor de la batalla en curso.
Módulo Estadísticas
Módulo que muestra al usuario las estadísticas generadas considerando: Cantidad de
partidas jugadas, cantidad de partidas ganadas, cantidad de partidas perdidas, cantidad de
partidas abandonadas. Este control se registrará por participante/Nickname.
Para la generación de estadísticas, se debe considerar desarrollar el módulo de
almacenamiento de datos utilizando archivos. El equipo definirá la estructura y cantidad de
archivos a utilizar.
Módulo Ayuda y Acerca De:
El usuario puede consultar la Ayuda del juego BomberMan donde se le indique Cómo jugar
y las reglas que debe seguir.
Adicionalmente mostrar una pantalla Acerca de donde se detalla Lenguaje de
Programación y librerías externas utilizadas en el desarrollo del juego, Desarrolladores,
versión Actualizada.

LIBRERIAS A UTILIZAR
 JAVADOC: Utilizar para generar la documentación del proyecto.
CONSIDERACIONES FINALES
 Se conformarán equipos de 4 integrantes cada uno.
 El proyecto debe desarrollarse utilizando el IDE Netbeans en cualquiera de
sus versiones. Preferiblemente a partir de la 8.0.
 Es indispensable que estén presentes todos los integrantes del equipo al
momento de corregir el proyecto. De lo contrario habrá penalización.
 La entrega final del proyecto se hará en digital, en una carpeta organizada
con todo el código fuente del juego y el informe correspondiente.
 Las fechas de entrega están detalladas en el cronograma de actividades.
