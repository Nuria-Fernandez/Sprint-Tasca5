Para ejecutar el programa en la linea de comandos:

Abrimos el cmd y nos ponemos en la carpeta en la que está el programa que queremos ejecutar.

Una vez en ella, escribimos mvn clean. Una vez hecho, mvn compile. Luego mvn install y por último mvn exec:java.

Para que todo vaya bien, antes hemos tenido que pasar el pom a una extensión .jar (<packaging>jar</packaging>). Además hemos tenido que crear
la carpeta target en la que se guardan las clases del proyecto. Además, se ha tenido que añadir el siguiente plugin:
<build>
        <sourceDirectory>src</sourceDirectory>
        <plugins>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <version>3.1.0</version>
                <configuration>
                    <mainClass>n1exercici1.Main</mainClass>
                </configuration>
            </plugin>
        </plugins>
    </build>
Es importante aquí añadir en <mainClass> la clase que queremos que se ejecute.
