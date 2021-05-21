# Getting Started

### Prerequisitos

* JDK 11
* Tener configurado la variable de entorno JAVA_HOME con el JDK 11

NOTA: a definición de los controladores son autogenerados a partir del OAS (`demo/doc/open-api.yaml`) por tanto al abrirlo en el IDE posiblemente salga errores de compilacion porque faltan clases.
Sin embargo al utilizar gradle a nivel de comando como se muestra acontinuacion no habria problema alguno.

### Documentacion del Api
La documentacion la encuentra en la siguiente ruta:
`demo/doc/open-api.yaml`

### Ejecutar los test
`./gradlew test`

### Ejecutar el Api
`./gradlew bootRun`

### Probar el Api
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Por Mejorar
* Configuración entre [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) y `demo/doc/open-api.yaml`

# Diseño

## Arquitectura

La arquitectura es hexagonal sin la capa de aplicación (Innecesaria por lo simple del ejercicio).  
Las capas que la componen son: infraestructura y dominio.  

### Dominio: `com.test.demo.domain.*`

La capa de dominio esta formada por:

* Dominio: `com.test.demo.domain.Price`
* Servicios de Dominio: `com.test.demo.domain.service.*`
* Excepciones de Dominio: `com.test.demo.domain.exception.*`
* Adaptador de Acceso a Dato: `com.test.demo.domain.adapter.repository`

### Infraestructura: `com.test.demo.infrastructure.*`

La capa de infraestructura esta formada por los siguientes adaptadores I/O:

* Controladores (Input): `com.test.demo.infrastructure.controller.*`
* Adaptador de Acceso a Dato (Output): `com.test.demo.infrastructure.repository.*`

#### Controladores: `com.test.demo.infrastructure.controller.*`
En esta capa se auto-generan los Dtos (Request y Response) y una interface que define el contrato del controlador, a partir del OAS (`demo/doc/open-api.yaml`)

* Controlador (Input): `com.test.demo.infrastructure.controller.BrandsApiImpl`
* Excepciones: `com.test.demo.infrastructure.controller.exception.*`, donde definimos excepciones y el control de excepciones (advice)
* convertidores: `com.test.demo.infrastructure.controller.converter.*`, donde se definen los mappers entre los Dtos y los dominios.

#### Adaptador de Acceso a Dato: `com.test.demo.infrastructure.repository.*`

* Adaptador de Acceso a Dato: `com.test.demo.infrastructure.repository.PricesAdapterRepositoryImpl`
* Entidades: `com.test.demo.infrastructure.repository.entity.*`
* Convertidores: `com.test.demo.infrastructure.repository.converter.*`, Mappers de entidad a dominio
