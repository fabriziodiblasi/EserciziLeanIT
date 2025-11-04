package org.leanit;


import java.util.*;

public class Esercizio_UNO {

    private static int convertRomanNumber(String romanNum){

        Map<String, Integer> romanMapKey = new LinkedHashMap<>();
        romanMapKey.put("X", 10);
        romanMapKey.put("V", 5);
        romanMapKey.put("I", 1);

        List<Integer> values = new ArrayList<Integer>();

        for (char c : romanNum.toCharArray()) {
            String key = String.valueOf(c).toUpperCase();
            Integer i = romanMapKey.get(key);
            values.add(i);
        }

        int sum = 0;

        List<Integer> valuesToSum = new ArrayList<Integer>();


        if(values.size()==1){
            sum =  values.get(0);
        }else{
            for(int i=1; i < values.size() ; i++){
                int actual = values.get(i);
                int prev = values.get(i-1);
                if(prev >= actual){
                    /* se il numero precedente è maggiore dell'attuale, inserisco nella lista della somma
                    solo il numero precedente, poichè non so se dopo ho una sottrazione da dover calcolare
                     */
                    valuesToSum.add(prev);
                    if(i ==  values.size()-1){
                        /*
                         * se viene eseguito questo if significa che il contatore del for è fermo sull'ultima posizione
                         * e contemporaneamente l'ultima posizione ha un valore minore o uguale a quella precedente e quindi
                         * l'ultimo valore va sommato a quello precedente
                         *
                         * */
                        valuesToSum.add(actual);
                    }
                }else{
                    valuesToSum.add(actual-prev);
                }
                //i++;
            }
        }
        // calcolo la somma
        for (Integer i : valuesToSum) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        /*
        *
        * Write a method in Java that takes a string representing a number in Roman numerals, returning an integer:
        * the number represented.
        * E.g. IV is 4, VII is 7. Numbers may be between 1 and 20.
        * */


//        Scanner input = new Scanner(System.in);
//        System.out.print("Inserisci il numero romano: ");
//        String romanNum = input.nextLine().trim().toUpperCase();
        String[] romanNumList = {
                "I",
                "II",
                "III",
                "IV",
                "V",
                "VI",
                "VII",
                "VIII",
                "IX",
                "X",
                "XI",
                "XII",
                "XIII",
                "XIV",
                "XV",
                "XVI",
                "XVII",
                "XVIII",
                "XIX",
                "XX"};


        for (String s : romanNumList) {
            System.out.println("il corrispondente di "+ s +" decimale è: "+ convertRomanNumber(s));

        }




    }
}