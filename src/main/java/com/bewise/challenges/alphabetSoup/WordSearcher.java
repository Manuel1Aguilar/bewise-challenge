package com.bewise.challenges.alphabetSoup;

public class WordSearcher {

    private char[][] soup;

    public WordSearcher(char[][] soup) {
        this.soup = soup;
    }

    public boolean isPresent(String word) {
        //Loop through all chars
        boolean found = false;
        for(int i = 0; i < this.soup.length; i++){
            for(int j = 0; j < this.soup[i].length; j++){
                //If first char of word then loop cardinal points for 2nd
                if(this.soup[i][j] == word.charAt(0)){
                    if(findWordFromStartingPoint(1, new int[]{i,j},word)){
                        return true;
                    }
                }
            }
        }

        //if didn't find = false
        return false;
    }
    public boolean findWordFromStartingPoint(int wordIndex, int[] coordinates, String word){

        //if end of word = true
        if(wordIndex == word.length()){return true;}
        char nextChar = word.charAt(wordIndex);
        int[] newCoordinates = null;
        boolean found = false;

            if(coordinates[0] + 1 < soup.length){
                if(nextChar == this.soup[coordinates[0] + 1][coordinates[1]]){
                    newCoordinates = new int[]{coordinates[0] + 1, coordinates[1]};
                    found = findNextChar(wordIndex + 1, newCoordinates, word, coordinates);

                }
            }
            if(coordinates[0] - 1 >= 0){
                if (nextChar == this.soup[coordinates[0] - 1][coordinates[1]]) {
                    newCoordinates = new int[]{coordinates[0] - 1, coordinates[1]};
                    found = found || findNextChar(wordIndex + 1, newCoordinates, word, coordinates);

                }
            }
            if(coordinates[1] + 1 < soup[0].length){
                if (nextChar == this.soup[coordinates[0]][coordinates[1] + 1]) {
                    newCoordinates = new int[]{coordinates[0], coordinates[1] + 1};
                    found = found || findNextChar(wordIndex + 1, newCoordinates, word, coordinates);

                }
            }
            if(coordinates[1] - 1 >= 0){
                if (nextChar == this.soup[coordinates[0]][coordinates[1] - 1]) {
                    newCoordinates = new int[]{coordinates[0], coordinates[1] - 1};
                    found = found || findNextChar(wordIndex + 1, newCoordinates, word, coordinates);
                }
            }
        return found;
    }
    public boolean findNextChar(int wordIndex, int[] coordinates, String word, int[] prevCoordinates){

        //if end of word = true
        if(wordIndex == word.length()){return true;}
        char nextChar = word.charAt(wordIndex);
        int[] newCoordinates = null;
        boolean found = false;
        if(coordinates[0] + 1 < soup.length){
            if(nextChar == this.soup[coordinates[0] + 1][coordinates[1]]){
                newCoordinates = new int[]{coordinates[0] + 1, coordinates[1]};
                found = findNextChar(wordIndex + 1, newCoordinates, word, coordinates);

            }
        }
        if(coordinates[0] - 1 >= 0){
            if (nextChar == this.soup[coordinates[0] - 1][coordinates[1]]) {
                newCoordinates = new int[]{coordinates[0] - 1, coordinates[1]};
                found = found || findNextChar(wordIndex + 1, newCoordinates, word, coordinates);

            }
        }
        if(coordinates[1] + 1 < soup[0].length){
            if (nextChar == this.soup[coordinates[0]][coordinates[1] + 1]) {
                newCoordinates = new int[]{coordinates[0], coordinates[1] + 1};
                found = found || findNextChar(wordIndex + 1, newCoordinates, word, coordinates);

            }
        }
        if(coordinates[1] - 1 >= 0){
            if (nextChar == this.soup[coordinates[0]][coordinates[1] - 1]) {
                newCoordinates = new int[]{coordinates[0], coordinates[1] - 1};
                found = found || findNextChar(wordIndex + 1, newCoordinates, word, coordinates);
            }
        }
        return found;
    }
}