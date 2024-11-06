# API Test Automation with Playwright

Este proyecto automatiza pruebas de la API utilizando Playwright, que es una herramienta moderna de automatización para pruebas de aplicaciones web. En este caso, las pruebas están diseñadas para interactuar con una API pública que gestiona usuarios, específicamente la API de GoRest. A través de Playwright, realizamos solicitudes HTTP para crear un usuario, obtener una lista de usuarios y consultar el detalle de un usuario creado previamente.

## Requisitos

Antes de ejecutar las pruebas, asegúrate de tener los siguientes requisitos:

- **Java 11 o superior**: Playwright se integra con Java, por lo que necesitas tener instalado Java.
- **Maven**: Para gestionar las dependencias del proyecto.
- **Playwright**: Para ejecutar las pruebas de la API.
- **TestNG**: Para estructurar y ejecutar las pruebas.

### Instalación

1. **Clona este repositorio**:

   ```bash
   git clone [<url-del-repositorio>](https://github.com/mdoguinz27/challenge-backend.git)

2. **Pasos para ejecutar el test**:

    Accede al repositorio del proyecto:
    ```cd playwright-java-fravega```

    Abrir el test y ejecutar PosCreateUserTest en ```src/test/java/com/qa/api/test/PostCreateUserTest.java```
