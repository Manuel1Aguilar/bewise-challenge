package com.bewise.challenges.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class RepeatedCharacters {

    /**
     * El metodo debe retornar un booleano indicando si el parametro `cadena` cumple con alguna de las siguientes propiedades:
     * 1- Todos los caracteres aparecen la misma cantidad de veces.
     * Ejemplos: "aabbcc", "abcdef", "aaaaaa"
     * 2- Todos los caracteres aparecen la misma cantidad de veces, a excepcion de 1, que aparece un vez mas o una vez menos.
     * Ejemplos: "aabbccc", "aabbc", "aaaaccccc"
     *
     * @param cadena la cadena a evaluar
     * @return booleano indicando si la cadena cumple con las propiedades
     */
    public Boolean isValid(String cadena) {
        HashMap<Character, Integer> values = new HashMap<Character, Integer>();

        // Contar las apariciones
        for(int i = 0; i < cadena.length(); i ++){
            values.put(cadena.charAt(i), values.getOrDefault(cadena.charAt(i), 0) + 1);
        }
        ArrayList<Integer> appearances = values.values().stream().distinct().collect(Collectors.toCollection(ArrayList::new));
        //Verificar condiciones
        //Si hay mas de dos cantidades de caracteres ya no es valido
        if(appearances.size() > 2) {return false;}
        //Si hay dos pero las cantidades tienen una diferencia de > 1 entre ellas entonces no es valido
        //Si la diferencia entre cantidades es menor o igual a uno entonces es valido
        else if  (appearances.size() == 2){
            return Math.abs(appearances.get(0) - appearances.get(1)) <= 1;
        }
        // Si paso las otras condiciones es valido
        else{
            return true;
        }


    }
}



