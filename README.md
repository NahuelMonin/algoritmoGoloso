# algoritmoGoloso
Tp Program 3

El objetivo del trabajo pr´actico es implementar un algoritmo goloso para asignar ´arbitros
a partidos de un campeonato, intentando maximizar la equidad de la asignaci´on. Se deber´a tambi´en implementar una aplicaci´on visual para ejecutar este algoritmo y visualizar sus
resultados.
Tenemos un campeonato con 2n equipos, de modo tal que en cada fecha se juegan n partidos
(cada equipo juega exactamente un partido por fecha). Como parte de los datos de entrada
tenemos el calendario de partidos. Tenemos adem´as n ´arbitros. El problema consiste en
determinar qui´en ser´a el ´arbitro de cada partido, con el siguiente criterio. Para cada equipo i,
llamemos mi a la m´axima cantidad de partidos de i con un mismo ´arbitro (es decir, si mi = 4
entonces el equipo i tiene a un mismo ´arbitro en cuatro partidos, y no tiene a ning´un otro
´arbitro en cinco o m´as partidos). El objetivo es minimizar

Se deber´a implementar una aplicaci´on visual con la siguiente funcionalidad.
1. Leer el calendario de partidos desde un archivo, cuyo formato queda a criterio del grupo.
Puede ser un archivo JSON, XML o de texto plano.
2. Mostrar el calendario de partidos en controles visuales adecuados.
3. Ejecutar el algoritmo goloso para asignar los ´arbitros. Por una cuesti´on de transparencia, los ´arbitros se denominan con los n´umeros de 1 a n en lugar de tener sus nombres.
4. Mostrar el resultado de la asignaci´on (es decir, qu´e n´umero de ´arbitro estar´a a cargo de
cada partido).
Como objetivos opcionales no obligatorios, se pueden contemplar los siguientes elementos:
1. Mostrar estad´ısticas de la asignaci´on realizada (menor y mayor ´arbitro para cada equipo,
cantidad de equipos distintos de cada ´arbitro, etc.).
2. Una vez que se realiz´o la asignaci´on de n´umeros de ´arbitros a partidos, dar la posibilidad
de cargar los nombres de los n ´arbitros y hacer un sorteo para determinar a qu´e ´arbitro
corresponde cada n´umero.
3. Permitir la edici´on de la soluci´on obtenida por el algoritmo.
Condiciones de entrega: El trabajo pr´actico se debe entregar por mail a los docentes
de la materia. Adem´as del c´odigo, se debe incluir un documento en el que se describa la
1
implementaci´on y se detallen las decisiones tomadas durante el desarrollo. Todas las clases de
negocio deben incluir un conjunto adecuado de tests unitarios. El trabajo pr´actico se puede
hacer en grupos de hasta tres personas.
Fecha de entrega: Martes 9 de noviembre.
