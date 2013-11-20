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
     export MAVEN_HOME=~/apache-maven-3.0.1
	 export PATH=$PATH:$MAVEN_HOME/bin
```
####Windows
```bash
    set M2_HOME=:\Program Files\apache-maven-3.0.1
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
	<connection>scm:git:git@github.com:ecabrerar/barcampsti.git</connection>
	<url>scm:git:git@github.com:ecabrerar/barcampsti.git</url>
	<developerConnection>scm:git:git@github.com:ecabrerar/barcampsti.git</developerConnection>
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

####Parte III:
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

`Aun trabajo en la documentación ....

#### Author

* [Eudris Cabrera](https://github.com/ecabrerar)
