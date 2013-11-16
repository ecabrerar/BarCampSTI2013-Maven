barcampsti 2013
==========

Pagina Oficial:
http://barcamp.org.do


Ejemplos básicos de maven con motivo de mi charla `Primeros Pasos con Maven` impartida en el BarCamp STI 2013

Ejercicio I: Crear un proyecto maven simple
===========================================

Desde la línea de comando crear un proyecto maven simple usando el artefacto `maven-archetype-quickstart`
* Ejecutar comando : mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart
* Llenar información requerida para el proyecto maven

 
Ejemplo

   <pre>
      groupId:    org.ecabrerar.barcampsti
    artifactId: simple-project (nombre del proyecto)
    version:    dejar version por defecto
    package:     org.ecabrerar.barcampsti.
    </pre>




Ejercicio II : 
==============
Personalizar de un proyecto maven
---------------

Desde la línea de comando crear un proyecto maven simple usando el siguiente comando

mvn archetype:generate -DgroupId=org.ecabrerar.barcampsti \
      -DartifactId=simple-custom-project \
      -Dpackage=org.ecabrerar.barcampsti.examples \
      -DarchetypeArtifactId=maven-archetype-quickstart \
      -DinteractiveMode=false \
      -Dversion=1.0

Modificar el archivo pom.xml y agregar configuración del compilador

<code>

<build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>2.3.2</version>
                <configuration>
                    <source>1.7</source>
                    <target>1.7</target>
                </configuration>
            </plugin>
        </plugins>
    </build>

</code>

Modificar el archivo pom.xml y personalizar información del proyecto
<pre>
<licenses>
        <license>
            <name>Apache 2</name>
            <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
            <distribution>repo</distribution>
            <comments>A business-friendly OSS license</comments>
        </license>
    </licenses>

</pre>
<pre>
<organization>
        <name>Barcamp STI</name>
        <url>http://www.barcamp.org.do</url>
    </organization>
</pre>
<pre>
<developers>
        <developer>
            <id>ecabrerar</id>
            <name>Eudris Cabrera</name>
            <email>eudris@gmail.com</email>
            <url>https://github.com/ecabrerar</url>
            <organization>Barcamp STI</organization>
            <organizationUrl>http://www.barcamp.org.do</organizationUrl>
            <roles>
                <role>developer</role>
            </roles>
            <timezone>-4</timezone>
        </developer>
    </developers>
</pre>

Modificar el archivo pom.xml y agregar información sobre el control de versiones
<pre>
<scm>
	<connection>scm:git:git@github.com:ecabrerar/barcampsti.git</connection>
	<url>scm:git:git@github.com:ecabrerar/barcampsti.git</url>
	<developerConnection>scm:git:git@github.com:ecabrerar/barcampsti.git</developerConnection>
  </scm>
</pre>

Modificar el archivo pom.xml y agregar información sobre la distribucion
<pre>
<distributionManagement>
        
        <repository>
            <id>releases</id>
            <name>Eudris Cabrera Release Repository</name>
            <url>https://repository-ecabrerar.forge.cloudbees.com/release/</url>
        </repository>
        <snapshotRepository>
            <id>snapshots</id>
            <name>Eudris Cabrera Snapshots Repository</name>
            <url>https://repository-ecabrerar.forge.cloudbees.com/snapshot/</url>
        </snapshotRepository>
    </distributionManagement>    
</pre>


Ejercicio III : 
==============
Crear una aplicación web simple
-------------------------------

Parte I
--------------

Desde la línea de comando crear un proyecto maven web simple usando el artefacto `maven-archetype-webapp`
* Ejecutar comando : mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp
* Llenar información requerida para el proyecto maven

 Ejemplo:

  <pre> 
    groupId: org.ecabrerar.barcampsti 
    artifactId: webapp-simple-project (nombre del proyecto) 
    version: dejar version por defecto 
    package: org.ecabrerar.barcampsti.examples
    </pre>

 
Parte II
---------------
Modificar el archivo `pom.xml` y agregar lo siguiente:
```xml
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

Ejercicio IV : 
=============
Crear un proyecto multi-módulo
-----------------------------------------
