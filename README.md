# API Test Automation with Java

Las pruebas están diseñadas para interactuar con una API pública que gestiona usuarios, específicamente la API de GoRest. A través de Playwright, realizamos solicitudes HTTP para crear un usuario, obtener una lista de usuarios y consultar el detalle de un usuario creado previamente.

## Requisitos

Antes de ejecutar las pruebas, asegúrate de tener los siguientes requisitos:

- **Java 11 o superior**: Playwright se integra con Java, por lo que necesitas tener instalado Java.
- **Maven**: Para gestionar las dependencias del proyecto.
- **Playwright**: Para ejecutar las pruebas de la API.
- **TestNG**: Para estructurar y ejecutar las pruebas.

### Instalación

1. **Clona este repositorio**:

   ```bash
   git clone https://github.com/mdoguinz27/challenge-backend.git

2. **Pasos para ejecutar el test**:

    Accede al repositorio del proyecto:
    ```cd playwright-java-fravega```

    Abrir el test y ejecutar PosCreateUserTest en ```src/test/java/com/qa/api/test/PostCreateUserTest.java```

# Crear un nuevo usuario
![image](https://github.com/user-attachments/assets/1ac5f259-5731-4781-8693-01bdcc869aa7)

# Obtener la lista de usuarios
![image](https://github.com/user-attachments/assets/d7ddcddd-aafa-42e6-a9e2-0634ed7b0d21)

# Obtener el detalle de un usuario específico.
![image](https://github.com/user-attachments/assets/edea5e81-d213-4f94-948b-ccaf91ac728c)
