package com.company;

import java.net.*;
import java.io.*;

public class Main {
    public static void main(String args[]) {
        // Comprueba los argumentos
        if (args.length != 1) {
            System.err.println("Uso: java EmisorUDP maquina mensaje");
        } else try {
            // Crea el socket
            DatagramSocket sSocket = new DatagramSocket();
            // Construye la dirección del socket del receptor
            InetAddress maquina = InetAddress.getByName("192.168.0.112");
            int Puerto = 1500;
            // Crea el mensaje
            byte[] cadena = args[0].getBytes();
            DatagramPacket mensaje = new DatagramPacket(cadena, args[0].length(), maquina, Puerto);
            // Envía el mensaje
            sSocket.send(mensaje);
            // Cierra el socket
            sSocket.close();
        } catch (UnknownHostException e) {
            System.err.println("Desconocido: " + e.getMessage());
        } catch (SocketException e) {
            System.err.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("E/S: " + e.getMessage());
        }
    }
}