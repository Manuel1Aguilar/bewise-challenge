package com.bewise.challenges.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorting {

    /**
     * Se debe ordenar primero por puntuación de manera descendente, luego por nombre de manera ascendente.
     *
     * @param jugadores la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */
    public static List<Jugador> ordenarPorPuntuacionYNombre(List<Jugador> jugadores) {
        //Ordenar por puntuacion de manera descendente

        for(int i = 0; i < jugadores.size() - 1 ; i++){
            boolean swapped = false;
            for(int j = 0; j < jugadores.size() - i - 1 ; j++){
                if(jugadores.get(j).getPuntuacion() < jugadores.get(j + 1).getPuntuacion()){
                    Jugador aux = jugadores.get(j);
                    jugadores.set(j,jugadores.get(j + 1));
                    jugadores.set(j + 1,aux);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }

        //Ordenar por nombre de manera ascendente
        for(int i = 0; i < jugadores.size() - 1; i++){
            boolean swapped = false;
            for(int j = 0; j < jugadores.size() - i - 1; j++){
                if(jugadores.get(j).getPuntuacion() == jugadores.get(j + 1).getPuntuacion()){
                    if(jugadores.get(j).getNombre().compareToIgnoreCase(jugadores.get(j + 1).getNombre()) > 0){
                        Jugador aux = jugadores.get(j);
                        jugadores.set(j,jugadores.get(j + 1));
                        jugadores.set(j + 1,aux);
                        swapped = true;
                    }
                }
            }
            if(!swapped){
                break;
            }
        }
//        jugadores.sort(Comparator.comparing(Jugador::getPuntuacion, Comparator.reverseOrder())
//                .thenComparing(Jugador::getNombre));
        return jugadores;
    }

    /**
     * Se debe ordenar primero por puntuación de manera descendente. Cuando 2 jugadores tienen igual cantidad de puntos,
     * el que tiene menos perdidas se lo considerara el mayor. Luego a igual puntos y perdidas se segxxuirá usando el
     * nombre de manera ascendente.
     *
     * @param jugadores la lista de jugadores a ordenar
     * @return la lista ordenada de jugadores
     */
    public static List<Jugador> ordenarPorPuntuacionPerdidasYNombre(List<Jugador> jugadores) {

        //Ordenar por puntuacion de manera descendente
        for(int i = 0; i < jugadores.size() - 1; i++){
            boolean swapped = false;
            for(int j = 0; j < jugadores.size() - i - 1; j++){
                if(jugadores.get(j).getPuntuacion() < jugadores.get(j + 1).getPuntuacion()){
                    Jugador aux = jugadores.get(j);
                    jugadores.set(j,jugadores.get(j + 1));
                    jugadores.set(j + 1,aux);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        //Ordenar por perdidas de manera ascendente
        for(int i = 0; i < jugadores.size() - 1; i++){
            boolean swapped = false;
            for(int j = 0; j < jugadores.size() - i - 1; j++){
                if(jugadores.get(j).getPuntuacion() == jugadores.get(j + 1).getPuntuacion()){
                    if(jugadores.get(j).getPerdidas() > jugadores.get(j + 1).getPerdidas()){
                        Jugador aux = jugadores.get(j);
                        jugadores.set(j,jugadores.get(j + 1));
                        jugadores.set(j + 1,aux);
                        swapped = true;
                    }
                }
            }
            if(!swapped){
                break;
            }
        }

        //Ordenar por nombre de manera ascendente
        for(int i = 0; i < jugadores.size() - 1; i++){
            boolean swapped = false;
            for(int j = 0; j < jugadores.size() - i - 1; j++){
                if(jugadores.get(j).getPuntuacion() == jugadores.get(j + 1).getPuntuacion()
                    && jugadores.get(j).getPerdidas() == jugadores.get(j + 1).getPerdidas()){
                    if(jugadores.get(j).getNombre().compareToIgnoreCase(jugadores.get(j + 1).getNombre()) > 0){
                        Jugador aux = jugadores.get(j);
                        jugadores.set(j,jugadores.get(j + 1));
                        jugadores.set(j + 1,aux);
                        swapped = true;
                    }
                }
            }
            if(!swapped){
                break;
            }
        }
//        jugadores.sort(Comparator.comparing(Jugador::getPuntuacion, Comparator.reverseOrder())
//                .thenComparing(Jugador::getPerdidas)
//                .thenComparing(Jugador::getNombre));

        return jugadores;
    }
}
