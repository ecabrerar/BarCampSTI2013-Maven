##BarCampSTI 2013


Pagina Oficial:
http://barcamp.org.do


Ejemplos básicos de maven con motivo de mi charla `Primeros Pasos con Maven` impartida en el BarCamp STI 2013

####Requisitos:
Para mejor entendiemiento es recomendable conocimientos básicos de Java

####Requerimientos
* Java 1.7+


###Instalar Maven

* Descargar y descomprimir instalador desde http://maven.apache.org/download.html
* Asegúrese de que la variable de entorno JAVA_HOME está en apuntando al directorio del JDK
* Añadir a la variable de entorno PATH
  
Ejemplo:
   
####Linux
```bash
     export MAVEN_HOME=~/apache-maven-3.1.0
	 export PATH=$PATH:$MAVEN_HOME/bin
```
####Windows
```bash
    set M2_HOME=:\Program Files\apache-maven-3.1.0
    set PATH=%PATH%;%M2_HOME%\bin
```

###Comprobar instalación

Desde la línea de comandos
Escribir `mvn -version` y debe obtener como resultado la versión instalada y la ruta de la variable de entorno `MAVEN_HOME`



###Ejercicio I: Crear un proyecto maven simple


Desde la línea de comando crear un proyecto maven simple usando el artefacto `maven-archetype-quickstart`

Ejecutar comando :
 
```bash
     mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart
```

* Llenar información requerida para el proyecto maven

 
Ejemplo

   <pre>
      groupId:    org.ecabrerar.barcampsti
    artifactId: simple-project (nombre del proyecto)
    version:    dejar version por defecto
    package:     org.ecabrerar.barcampsti.
    </pre>



###Ejercicio II : Personalizar un proyecto maven
####Parte I:
Desde la línea de comando crear un proyecto maven simple usando el siguiente comando
```bash
mvn archetype:generate -DgroupId=org.ecabrerar.barcampsti \
      -DartifactId=simple-custom-project \
      -Dpackage=org.ecabrerar.barcampsti.examples \
      -DarchetypeArtifactId=maven-archetype-quickstart \
      -DinteractiveMode=false \
      -Dversion=1.0
```
####Parte II:

Modificar el archivo pom.xml y agregar configuración del compilador

```xml
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
```


Personalizar información del proyecto

```xml
<licenses>
        <license>
            <name>Apache 2</name>
            <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
            <distribution>repo</distribution>
            <comments>A business-friendly OSS license</comments>
        </license>
    </licenses>
```


Agregar información de la institución
```xml
<organization>
        <name>Barcamp STI</name>
        <url>http://www.barcamp.org.do</url>
    </organization>
```

Agregar información del equipo de trabajo
```xml
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
```


Agregar información sobre el control de versiones

```xml
<scm>
	<connection>scm:git:git@github.com:BarcampSTI/BarCampSTI2013-Maven.git</connection>
	<url>scm:git:git@github.com:BarcampSTI/BarCampSTI2013-Maven.git</url>
	<developerConnection>scm:git:git@github.com:BarcampSTI/BarCampSTI2013-Maven.git</developerConnection>
  </scm>
```


Modificar el archivo pom.xml y agregar información sobre la distribucion

```xml
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

```

####Parte III: Correr un ejemplo simple java usando Maven
Al crear nuestro proyecto maven se crea un paquete por defecto para el código fuente (debajo de `src/main/java`) y otro paquete para las pruebas unitarias( debajo de `src/test/java`).
Por lo regular el paquete creado en `src/main/java` y en `src/test/java` se llaman iguales, en nuestro caso `org.ecabrerar.barcampsti.examples`.
Dentro de cada paquete se crea una clase java simple `App.java` y `AppTest.java` en el paquete para las pruebas unitarias.

```java

package org.ecabrerar.barcampsti.examples;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
```
Para correr este ejemplo simple ejecutamos los siguientes comandos en la lína de comandos.

```bash
mvn install
mvn exec:java -Dexec.mainClass=org.ecabrerar.barcampsti.examples.App
```

####Parte IV: Generar documentación del proyecto en formato html

Desde la línea de comandos ejecutar `mvn site` en el directorio donde se encuentra el archivo `pom.xml` para generar
un sitio `html` con toda la información de nuestro proyecto.

Ir al directorio `target/site` para comprobar que se haya generado la documentación y abrir  el archivo `index.hml` con nuestro navegador 



###Ejercicio III : Crear una aplicación web simple


####Parte I


Desde la línea de comando crear un proyecto maven web simple usando el artefacto `maven-archetype-webapp`

Ejecutar comando : 
```bash
    mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp
```

Llenar información requerida para el proyecto maven

 Ejemplo:

  <pre> 
    groupId: org.ecabrerar.barcampsti 
    artifactId: webapp-simple-project (nombre del proyecto) 
    version: dejar version por defecto 
    package: org.ecabrerar.barcampsti.examples
    </pre>

 
####Parte II

Modificar el archivo `pom.xml` y agregar el plugin para el servidor jetty (http://www.eclipse.org/jetty)
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


####Parte III

Compilar y empaquetar los archivos compilados.
<pre>
mvn clean compile package
</pre>
Lanzar aplicacion
<pre>
mvn jetty:run
</pre>

###Ejercicio IV : Crear un proyecto multi-módulo

Un proyecto de varios módulos (multi-modulo) se define por un POM padre haciendo referencia 
a uno o más submódulos(proyectos descendientesdel padre).

Para crear nuestro proyecto padre ejecutamos el siguiente comando:

```bash
mvn archetype:generate -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=pom-root -D  archetypeVersion=RELEASE
```

Dentro del proyecto padre, podemos ejecutar los comandos para crear los sub-módulos.
El comando ejecutado dependerá del tipo de proyecto que queremos crear.
Por ejemplo: 

Crear un proyecto web
```bash
mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp
```

Una librería, un proyecto web service, etc

```bash
mvn archetype:generate  -DarchetypeArtifactId=maven-archetype-quickstart 
```

Para nuestra demostración vamos a crear un proyecto multi-módulo que combina los ejercicios II y III.
El ejercicio II, un proyecto Java simple y el ejercicio III, un proyecto web simple.

####Paso I: Crear Proyecto Padre (POM padre)

Ejecutar en la línea de comando:

```bash
mvn archetype:generate -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=pom-root -D  archetypeVersion=RELEASE
```
Información general del proyecto
 <pre>
      groupId:    org.ecabrerar.barcampsti
    artifactId: multi-module-project (nombre del proyecto)
    version:    dejar version por defecto
    package:     dejar paquete por defecto
</pre>

POM padre

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>org.ecabrerar.barcampsti</groupId>
  <artifactId>multi-module-project</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>pom</packaging>
  <name>multi-module-project</name>
</project>
```

Al igual que los proyectos maven anteriores, el POM padre posee la misma estructura de groupId, artifactId, version, etc..
La diferencia con otros tipos de proyectos está en la coordenada `packaging`, en lugar de tener un formato de archivo (jar, war,ear, etc.) como vimos anteriormente,
el valor para este tipo de proyecto es `pom`.

####Paso II: Definir sub-modulos.

Anteriormente creamos los ejercicios II y III, en esta oportunidad no vamos a volver a crearlos, vamos a copiar ambos proyectos dentro del proyecto multi-modulo.
Si deseas crearlos desde cero, recuerde ejecutar los comandos para crear los sub-módulos dentro del proyecto padre.

Para el ejercicio II
```bash
mvn archetype:generate  -DarchetypeArtifactId=maven-archetype-quickstart 
```

Para el Ejercicio III
```bash
mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp
```

Estructura del proyecto multi-modulo
<pre>
multi-module-project
  simple-custom-project
  webapp-simple-project
  pom.xml
</pre>
  
####Paso III: Agregar dependencias
Modificar el archivo `pom.xml` del proyecto padre y agregar los dos sub-módulos
```xml
<modules>
        <module>simple-custom-project</module>
        <module> webapp-simple-project</module>
</modules>
```

Modificar el archivo `pom.xml` de cada sub-módulo para:
Remover la siguiente coordenada
<pre>
 <groupId>org.ecabrerar.barcampsti</groupId>
</pre>

Luego agregar la referencia del proyecto padre
```xml
<parent>
  <groupId>org.ecabrerar.barcampsti</groupId>
  <artifactId>multi-module-project</artifactId>
  <version>1.0-SNAPSHOT</version>
</parent>
```

Luego de hacer las modificaciones anteriores podemos compilar el proyecto para comprobar que las modificaciones se realizaron de la forma correcta.
```bash
mvn clean install
```

En su resultado final debe aparecer una salida similar a la siguiente
```bash
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO] 
[INFO] multi-module-project .............................. SUCCESS [5.300s]
[INFO] simple-custom-project ............................. SUCCESS [25.091s]
[INFO] webapp-simple-project Maven Webapp ................ SUCCESS [8.364s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 39.732s
[INFO] Finished at: Tue Dec 10 18:35:06 EST 2013
[INFO] Final Memory: 16M/183M
[INFO] ------------------------------------------------------------------------
```

Ahora podemos correr cada módulo de forma independiente.

Desde el directorio raíz ir al proyecto correspondiente al ejercicio II
```bash
cd simple-custom-project
mvn install
mvn exec:java -Dexec.mainClass=org.ecabrerar.barcampsti.examples.App
```
Desde el directorio raíz ir al proyecto correspondiente al ejercicio III

```bash
cd webapp-simple-project
mvn clean compile package
mvn jetty:run
```
Hasta este punto, tenemos un proyecto multi-módulo simple con pocas funcionalidades, la idea principal es mostrar las características de Maven para proyectos de este tipo. 

Todavía nos falta re-estructurar los poms para eliminar las duplicaciones de dependencias.


####Paso IV: Re-estructurar POMs.

* Mover dependencias al POM padre. 
* Eliminar las duplicadas.
* Mover otras informaciones relevantes(tipo de licencia, control de versiones, etc) al pom padre.



#### Author

* [Eudris Cabrera](https://github.com/ecabrerar)
* [![endorse](https://api.coderwall.com/ecabrerar/endorsecount.png)](https://coderwall.com/ecabrerar)
