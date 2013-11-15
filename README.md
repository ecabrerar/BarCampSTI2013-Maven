barcampsti 2013
==========

Pagina Oficial:
http://barcamp.org.do


Ejemplos básicos de maven con motivo de mi charla "Primeros Pasos con Maven" impartida en el BarCamp STI 2013

Ejercicio I
=================

Desde la línea de comando crear un proyecto maven simple usando el artefacto "maven-archetype-quickstart"
* Ejecutar comando : mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart
* Llenar información requerida para el proyecto maven
 ...Ejemplo:
   ..* groupId:    org.ecabrerar.barcampsti
   ..* artifactId: simple-project (nombre del proyecto)
   ..* version:    dejar version por defecto
   ..* package:     org.ecabrerar.barcampsti.examples




Ejercicio II
==========================================

Parte I
--------------

... archetype:generate -DarchetypeArtifactId=maven-archetype-webapp

Desde la línea de comando crear un proyecto maven web simple usando el artefacto "maven-archetype-webapp" 
* Ejecutar comando : mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp
* Llenar información requerida para el proyecto maven
 Ejemplo:

    ..*groupId: org.ecabrerar.barcampsti 
    ..*artifactId: webapp-simple-project (nombre del proyecto) 
    ..*version: dejar version por defecto 
    ..*package: org.ecabrerar.barcampsti.examples

Parte II
---------------
...Modificar el archivo pom.xml y agregar lo siguiente:
```Xml

<plugins>
      <plugin>
          <groupId>org.mortbay.jetty</groupId>
          <artifactId>jetty-maven-plugin</artifactId>
          <version>8.0.0.M3</version>
          <configuration>
           <scanIntervalSeconds>10</scanIntervalSeconds>
           <contextPath>/</contextPath>
           <scanIntervalSeconds>10</scanIntervalSeconds>
           <stopKey>STOP</stopKey>
           <stopPort>8005</stopPort>
           <port>8080</port>
           </configuration>
   </plugin>
</plugins>
```
Parte III
------------------
Compilar y empaquetar los archivos compilados.
<pre>
mvn clean compile package
</pre>
Lanzar aplicacion
<pre>
mvn jetty:run
</pre>
