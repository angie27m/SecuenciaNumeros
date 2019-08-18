/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.secuencia;

import java.util.Scanner;

/**
 * Esta clase se encarga de eliminar repetidos de una secuencia e imprimir los números faltantes de la misma
 * @author Angie Manrique
 * @version 1.0
 */
public class Secuencia {
private byte[] numeros;
    private int[] cadena;
    private String[] arraySecuencia;
    /**
     * Método constructor: Ingreso de los números
     */
    public Secuencia() {
            String seguir = "";
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite una secuencia de números separados por espacios:  ");
            String array = scanner.nextLine();
            arraySecuencia = array.split(" ");
            numeros = new byte[arraySecuencia.length];
            for (int i = 0; i < arraySecuencia.length; i++) {
                numeros[i] = Byte.parseByte(arraySecuencia[i]);
            }
            Ordenamiento();
            Scanner respuesta = new Scanner(System.in);
            System.out.println("¿Desea continuar? S=>Si o N=>No");
            seguir = respuesta.nextLine();
        } while (seguir.equals("s") || seguir.equals("S"));
    }

    /**
     * Método encargado de ordenar los números de mayor a menor
     * @param aux variable auxiliar en la comparación de los números dentro del array
     */
    public void Ordenamiento() {
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = 0; j < numeros.length - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    byte aux = numeros[j + 1];
                    numeros[j + 1] = numeros[j];
                    numeros[j] = aux;
                }
            }
        }
        EliminarRepetidos();
    }

    /**
     * Método encargado de eliminar los números que están repetidos dentro de la secuencia
     * @param cadena[] array que guarda la cadena de números sin repetidos
     */
    public void EliminarRepetidos() {
        Byte j = 0, k = 0;
        cadena = new int[numeros.length];
        for (int i = 0; i < cadena.length; i++) {
            cadena[i] = 255;
        }
        for (int i = 0; i < numeros.length - 1; i++) {
            if (k == 0) {
                cadena[j] = numeros[i];
                k++;
                j++;
            }
            if (k > 0) {
                if (numeros[i] != numeros[i + 1]) {
                    cadena[j] = numeros[i + 1];
                    j++;
                }
            }
        }
        NumerosFaltantes();
    }

    /**
     * Método que imprime los números faltantes
     * @param minimo variable que guarda el número menor de la secuencia
     * @param maximo variable que guarda el número mayor de la secuencia
     */
    public void NumerosFaltantes() {
        int minimo = cadena[0];
        int maximo = minimo;
        try{
        for (int i = 0; cadena[i] != 255; i++) {
            if (cadena[i] == maximo) {
                maximo++;
            } else {
                System.out.println("Falta: " + maximo);
                maximo++;
                i--;
            }
        }
        }catch(Exception e){
            
        }
    }
}