package com.example.proyectotesting.patterns.behavioral.mediator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("TelegramTest")
class TelegramTest {

    @Test
    @DisplayName("Enviar mensaje")
    void sendMessage() {
        Telegram telegram=new Telegram();
        String mensaje="Mensaje para enviar";

        AbstractUser mockUser=mock(AbstractUser.class);
        AbstractUser mockUser2=mock(AbstractUser.class);

        doNothing().when(mockUser).receive(anyString());


        telegram.addUser(mockUser);
        telegram.addUser(mockUser2);
        //Envia el mensaje el mockUser
        telegram.sendMessage(mensaje,mockUser);

        //El mockuser no tiene que recibir el mensaje
        verify(mockUser,never()).receive(mensaje);
        //El mockUser2 si tiene que recibir elmensaje
        verify(mockUser2).receive(mensaje);


    }

    @Test
    @DisplayName("Añadir Usuario")
    void addUser() {
        Telegram telegram=new Telegram();
        AbstractUser user1 = new User(telegram, "Francisco");
        assertEquals(1,telegram.users.size());
        telegram.addUser(user1);
        assertEquals(2,telegram.users.size());

    }

    @Test
    @DisplayName("Eliminar usuario")
    void removeUser() {
        Telegram telegram=new Telegram();

        AbstractUser user1 = new User(telegram, "Francisco");
        telegram.addUser(user1);
        assertEquals(2,telegram.users.size());
        telegram.removeUser(user1);
        assertEquals(1,telegram.users.size());
    }
}