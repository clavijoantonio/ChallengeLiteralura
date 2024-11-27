<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
   
</head>
<body>
    <h1>Alura Challenge: Consumo de API de Libros</h1>
    <h2>Descripción</h2>
    <p>Este proyecto es parte del curso de Alura y tiene como objetivo consumir la API de <a href="https://gutendex.com">GutenDEX</a>, la cual almacena libros con sus características. El objetivo es crear una aplicación de consola interactiva que permita al usuario realizar varias consultas y almacenar datos en una base de datos.</p>
    <h2>Tecnologías Utilizadas</h2>
    <ul>
        <li><strong>Java 17</strong></li>
        <li><strong>Spring Boot</strong></li>
        <li><strong>Maven</strong></li>
        <li><strong>JPA (Java Persistence API)</strong></li>
        <li><strong>Streams y Lambdas</strong></li>
        <li><strong>Records en Java</strong></li>
    </ul>
    <h2>Funcionalidades</h2>
    <p>La aplicación de consola permite a los usuarios:</p>
    <ul>
        <li><strong>Buscar libros en la API y almacenarlos en una base de datos</strong>.</li>
        <li><strong>Listar todos los libros almacenados</strong>.</li>
        <li><strong>Mostrar los autores de los libros almacenados</strong>.</li>
        <li><strong>Buscar libros por idioma</strong>.</li>
        <li><strong>Buscar autores vivos en un año específico</strong>.</li>
    </ul>
    <h2>Requisitos</h2>
    <ul>
        <li><strong>JDK 17</strong> instalado.</li>
        <li><strong>Maven</strong> instalado.</li>
        <li>Conexión a una base de datos compatible con JPA.</li>
    </ul>
    <h2>Instalación y Ejecución</h2>
    <p>Sigue estos pasos para clonar el repositorio, construir y ejecutar la aplicación:</p>
    <h3>Clonar el Repositorio</h3>
    <pre><code>
        git clone https://github.com/tu-usuario/alura-challenge.git
        cd alura-challenge
    </code></pre>
    <h3>Configurar la Base de Datos</h3>
    <p>Asegúrate de configurar tu base de datos en el archivo <code>application.properties</code>. Por ejemplo:</p>
    <pre><code>
        spring.datasource.url=jdbc:mysql://localhost:3306/alura_challenge
        spring.datasource.username=tu_usuario
        spring.datasource.password=tu_contraseña
        spring.jpa.hibernate.ddl-auto=update
    </code></pre>
    <h3>Compilar y Ejecutar</h3>
    <pre><code>
        mvn clean install
        mvn spring-boot:run
    </code></pre>
    <h2>Uso de la Aplicación</h2>
    <p>Al ejecutar la aplicación, se mostrará un menú interactivo en la consola. Las opciones disponibles son:</p>
    <ol>
        <li><strong>Buscar y almacenar libros</strong>: Realiza una consulta a la API de GutenDEX y almacena los resultados en la base de datos.</li>
        <li><strong>Listar todos los libros almacenados</strong>: Muestra una lista de todos los libros almacenados en la base de datos.</li>
        <li><strong>Mostrar autores de los libros</strong>: Lista todos los autores de los libros almacenados.</li>
        <li><strong>Buscar libros por idioma</strong>: Permite al usuario buscar libros almacenados filtrando por idioma.</li>
        <li><strong>Buscar autores vivos en un año específico</strong>: Permite al usuario buscar autores que estaban vivos en un año específico.</li>
        <li><strong>Salir</strong></li>
    </ol>
    <h3>Ejemplo de Interacción</h3>
    <pre><code>
        =============================
        Menú de la Aplicación
        =============================
        1. Buscar y almacenar libros
        2. Listar todos los libros almacenados
        3. Mostrar autores de los libros
        4. Buscar libros por idioma
        5. Buscar autores vivos en un año específico
        6. Salir
        Selecciona una opción:     
    </code></pre> 
    <h2>Implementación Destacada</h2>
    <h3>Uso de Streams y Lambdas</h3>
    <p>El proyecto hace un uso intensivo de Streams y Lambdas para realizar operaciones sobre colecciones de manera eficiente y concisa. Aquí un ejemplo de cómo se filtran los autores vivos en un año específico:</p>
   <pre><code>
        public List<Author> findAuthorsAliveInYear(int year) {
            return authors.stream()
                          .filter(author -> author.getBirthYear() <= year && (author.getDeathYear() == null || author.getDeathYear() > year))
                          .collect(Collectors.toList());
        }     
    </code></pre>
  <h3>Uso de Records</h3>
    <p>Para aprovechar las características modernas de Java, se utilizan records para modelar datos inmutables. Aquí un ejemplo de cómo se define un record para un libro:</p>
    <pre><code>
        public record Book(String title, List<Author> authors, String language, String publisher, int downloadCount) {}
    </code></pre>
    <h2>Contribución</h2>
    <p>Si deseas contribuir a este proyecto, por favor sigue estos pasos:</p>
    <ol>
        <li>Haz un fork del repositorio.</li>
        <li>Crea una nueva rama (<code>git checkout -b feature/nueva-funcionalidad</code>).</li>
        <li>Realiza tus cambios y haz commit (<code>git commit -am 'Añadir nueva funcionalidad'</code>).</li>
        <li>Envía tus cambios a una nueva rama (<code>git push origin feature/nueva-funcionalidad</code>).</li>
        <li>Abre un Pull Request.</li>
    </ol>
    <h2>Licencia</h2>
    <p>Este proyecto está licenciado bajo la Licencia MIT. Para más detalles, revisa el archivo <a href="LICENSE">LICENSE</a>.</p>
</body>
</html>
