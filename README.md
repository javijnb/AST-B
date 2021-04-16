# AST
Arquitectura y servicios telemáticos

***VARIABLES DE ENTORNO***

> export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64

> export PATH=$JAVA_HOME/bin:$PATH

> export AXIS2_HOME=/home/javi/axis2-1.7.9

> export PATH=$AXIS2_HOME/bin:$PATH


***TOMCAT-AXIS2***

Abrimos terminal para iniciarlos:

> ./home/javi/apache-tomcat-9.0.43/bin/startup.sh

Lo detenemos con:

> ./home/javi/apache-tomcat-9.0.43/bin/shutdown.sh

Comprobamos su ejecución desde navegador:

> localhost:8080/axis2


***SERVICIO 1 - CALCULADORA***

Nos dirijimos a la carpeta del servicio:

> cd /home/javi/apache-tomcat-9.0.43/webapps/axis2/WEB-INF/pojo 

Compilamos los ficheros java:

> javac -cp "/home/javi/axis2-1.7.9/lib/*" *.java

Ejecutamos el cliente con la siguiente sintaxis:

> java  -cp "/home/javi/axis2-1.7.9/lib/*:" ClienteCalculadora OPERACION numero1 numero2


***SERVICIO 2 - NOTICIAS***

Una vez obtenido el WSDL del servicio, generamos el código Java en la carpeta actual:

> wsdl2java.sh -ss -sd -g -s -uri Noticia.wsdl

Una vez creado el código pertinente en el Skeleton, compilamos los .java del servicio:

> javac -cp "/home/javi/axis2-1.7.9/lib/*" *.java

Compilamos los ficheros al formato .aar con el siguiente comando, desde el directorio donde se encuentre el fichero build.xml:

> ant

Movemos el fichero .aar a la carpeta:

> /home/javi/apache-tomcat-9.0.43/webapps/axis2/WEB-INF/services/

Compilamos el cliente y comprobamos su correcto funcionamiento:

> javac -cp "/home/javi/axis2-1.7.9/lib/*" *.java

> java -cp "/home/javi/axis2-1.7.9/lib/*" ClienteNoticias.java


***SERVICIO 3 - PERSONALIZADO***

Nuevo servicio que conecta con una API abierta: [link](https://english.api.rakuten.net/SharkAPIs/api/body-mass-index-bmi-calculator/endpoints)
La API devuelve en un objeto JSON el IMC,pasándole por parámetros altura y peso en formato float

Escribimos el código pertinente del servicio en el fichero `imc.wsdl`
Posteriormente generamos el código Java del servicio con el siguiente comando donde se encuentre el fichero WSDL (si está AXIS2/bin como variable de entorno):

> wsdl2java.sh -ss -sd -g -s -uri imc.wsdl

Escribimos el código necesario en IMCSkeleton para conectar con la API, una vez finalizado, lo compilamos:

> javac -cp "/home/javi/axis2-1.7.9/lib/*" *.java

Si no da errores y estamos seguros de su correcto funcionamiento, generamos su archivo .aar para incrustarlo como servicio en nuestro Axis2:

> ant

Y lo movemos a la carpeta de servicios de nuestro Axis2:

> /home/javi/apache-tomcat-9.0.43/webapps/axis2/WEB-INF/services/

Por último escribimos el código del cliente. Simula una interfaz en la que se pide el IMC del cliente a partir de una altura y peso introducidos por él.
A continuación se llama al servicio IMC para calcular dicho valor, y luego se conecta con el servicio Noticia para ofrecer una "noticia" a modo de parte médico con la información extra introducida (nombre y fecha de nacimiento del paciente).
Para compilar y ejecutar el cliente:

> javac -cp "/home/javi/axis2-1.7.9/lib/*" *.java

> java -cp "/home/javi/axis2-1.7.9/lib/*" ClienteIMC.java
