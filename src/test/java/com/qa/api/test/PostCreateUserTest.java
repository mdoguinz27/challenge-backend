package com.qa.api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PostCreateUserTest {

    private PostCreateUser postCreateUser;

    @BeforeClass
    public void setup() {
        postCreateUser = new PostCreateUser();  // Inicializa la clase que contiene la lógica
    }

    @Test(priority = 1)
    public void testCreateUser() throws Exception {
        // Llama al método que crea el usuario y obtiene el ID
        String userId = postCreateUser.postCreateUserApi();

        // Verifica que el userId no sea nulo ni vacío
        Assert.assertNotNull(userId, "El ID del usuario no debe ser nulo");
    }

    @Test(priority = 2)
    public void testGetUsers() throws Exception {
        // Llama al metodo que obtiene la lista de usuarios
        String users = postCreateUser.getUsers();

        // Verifica que la lista de usuarios no sea nula ni vacía
        Assert.assertNotNull(users, "La lista de usuarios no debe ser nula");
        Assert.assertFalse(users.isEmpty(), "La lista de usuarios no debe estar vacía");
    }

    @Test(priority = 3)
    public void testGetUserDetails() throws Exception {
        // Crea un nuevo usuario para obtener su ID
        String userId = postCreateUser.postCreateUserApi();

        // Verifica que el userId no sea nulo ni vacío
        Assert.assertNotNull(userId, "El ID del usuario no debe ser nulo");

        // Llama al método que obtiene los detalles del usuario creado
        String userDetails = postCreateUser.getUserDetails(userId);

        // Verifica que los detalles del usuario no sean nulos ni vacíos
        Assert.assertNotNull(userDetails, "Los detalles del usuario no deben ser nulos");
        Assert.assertFalse(userDetails.isEmpty(), "Los detalles del usuario no deben estar vacíos");

    }
}
