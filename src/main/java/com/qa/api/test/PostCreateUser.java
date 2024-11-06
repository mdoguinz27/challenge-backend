package com.qa.api.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import java.io.IOException;
import java.util.UUID;
import java.util.Random;

public class PostCreateUser {

    private static final String AUTH_TOKEN = "Bearer 2bf0e5cc033dd6cd3897fb8f99d37901df1d10431c6a5b85c737156bf3ed70da";
    private static final String BASE_URL = "https://gorest.co.in/public/v2/users";

    // Método para crear un nuevo usuario
    public String postCreateUserApi() throws IOException {
        Playwright playwright = Playwright.create();
        APIRequestContext requestContext = playwright.request().newContext();

        // Generar datos aleatorios para el usuario
        String randomName = "User" + UUID.randomUUID().toString().substring(0, 5);
        String randomEmail = "user" + UUID.randomUUID().toString().substring(0, 5) + "@example.com";
        String[] genders = {"male", "female"};
        String randomGender = genders[new Random().nextInt(genders.length)];
        String status = "active";

        // Crear el cuerpo de la solicitud POST para crear el nuevo usuario
        String requestBody = "{\n" +
                "    \"name\": \"" + randomName + "\",\n" +
                "    \"email\": \"" + randomEmail + "\",\n" +
                "    \"gender\": \"" + randomGender + "\",\n" +
                "    \"status\": \"" + status + "\"\n" +
                "}";

        // Enviar la solicitud POST
        APIResponse createResponse = requestContext.post(BASE_URL,
                RequestOptions.create()
                        .setData(requestBody)
                        .setHeader("Content-Type", "application/json")
                        .setHeader("Authorization", AUTH_TOKEN));

        if (createResponse.status() != 201) {
            System.out.println("Error creating user: " + createResponse.statusText());
            return null;
        }

        // Obtener el ID del usuario recién creado
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode createdUserResponse = objectMapper.readTree(createResponse.body());
        String userId = createdUserResponse.get("id").asText();

        System.out.println("Usuario creado con el ID: " + userId);

        playwright.close(); // Cerrar Playwright después de la operación

        return userId; // Devuelve el ID del usuario recién creado
    }

    // Método para obtener todos los usuarios
    public String getUsers() throws IOException {
        Playwright playwright = Playwright.create();
        APIRequestContext requestContext = playwright.request().newContext();

        // Realizar la solicitud GET para obtener los usuarios
        APIResponse getUsersResponse = requestContext.get(BASE_URL,
                RequestOptions.create().setHeader("Authorization", AUTH_TOKEN));

        if (getUsersResponse.status() != 200) {
            System.out.println("Error fetching users: " + getUsersResponse.statusText());
            return null;
        }

        // Procesar la respuesta
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode getUsersJsonResponse = objectMapper.readTree(getUsersResponse.body());

        System.out.println("Lista de usuarios: " + getUsersJsonResponse.toPrettyString());

        playwright.close(); // Cerrar Playwright después de la operación
        return getUsersJsonResponse.toPrettyString(); // Devuelve la lista de usuarios como JSON
    }

    // Método para obtener los detalles de un usuario específico
    public String getUserDetails(String userId) throws IOException {
        Playwright playwright = Playwright.create();
        APIRequestContext requestContext = playwright.request().newContext();

        // Realizar la solicitud GET para obtener los detalles de un usuario específico
        APIResponse userDetailsResponse = requestContext.get(BASE_URL + "/" + userId,
                RequestOptions.create().setHeader("Authorization", AUTH_TOKEN));

        if (userDetailsResponse.status() != 200) {
            System.out.println("Error fetching user details: " + userDetailsResponse.statusText());
            return null;
        }

        // Procesar la respuesta
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode userDetails = objectMapper.readTree(userDetailsResponse.body());

        System.out.println("User details: " + userDetails.toPrettyString());

        playwright.close(); // Cerrar Playwright después de la operación
        return userDetails.toPrettyString(); // Devuelve los detalles del usuario como JSON
    }
}
