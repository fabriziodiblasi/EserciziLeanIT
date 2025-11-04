package org.leanit;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/*
* Write an application that acts as a super market point of sale application.
* Input is product names, one per line – e.g. Apple or Banana. Application ends when a blank line is received; at
* the end the application should output the total cost of shopping. Prices are as follows:
* · Apple 0.35 euro
* · Banana 0.20 euro
* · Melon 0.50 euro, but available on a 3 for the price of 2 offer
* · Lime 0.15, but available in a buy one get one free offer
* This can be written in Java or can also be an HTML+Javascript page
*
* */
public class Esercizio_DUE {



    private static double getItemPrice(String itemName, int itemNum) {
        Map<String, Double> priceMapKey = new LinkedHashMap<>();
        priceMapKey.put("apple", 0.35);
        priceMapKey.put("banana", 0.20);
        priceMapKey.put("melon", 0.50);
        priceMapKey.put("lime", 0.15);

        itemName = itemName.toLowerCase();

        double totalPrice = 0;

        if (priceMapKey.containsKey(itemName)) {
            Double itemPrice = priceMapKey.get(itemName);

            if(itemName.equals("melon") ) {
                double melonPrice = 0;

                int resto = itemNum % 3;
                int numTerzine = itemNum / 3;

                if(resto == 0 && numTerzine > 0) {
                    melonPrice = itemPrice * numTerzine * 2;
                }
                if(resto != 0) {
                    melonPrice= itemPrice * (double) resto + itemPrice * numTerzine * 2;
                }
                totalPrice = melonPrice + totalPrice;

            }else if(itemName.equals("lime")){
                double limePrice = 0;
                int resto = itemNum % 2;
                int numCoppie = itemNum / 2;
                if(resto == 0 && numCoppie > 0) {
                    limePrice =  itemPrice * numCoppie;
                }
                if(resto != 0) {
                    limePrice = itemPrice * (double) resto + itemPrice * numCoppie;
                }
                totalPrice += limePrice;
            }else{
                totalPrice +=itemPrice * itemNum;
            }

        }else{
            throw new RuntimeException("Attenzione l'item "+ itemName +" non trovato, inserire solo [apple, banana, melon, lime]");
        }


        return totalPrice;
    }


    public static void main(String[] args) {
        String[] shoppingList = {"melon", "melon", "melon", "melon", "melon", "melon", "melon", "lime", "lime", "apple","lime","lime","lime","banana"};
        Map<String, Integer> shoppingMapQty = new LinkedHashMap<>();

        for(String itemName : shoppingList){
            if(shoppingMapQty.containsKey(itemName)){
                shoppingMapQty.put(itemName, shoppingMapQty.get(itemName) + 1);
            }else {
                shoppingMapQty.put(itemName, 1);
            }
        }

        double totalPrice = 0.0;
        for (Map.Entry<String, Integer> purchasedItem : shoppingMapQty.entrySet()) {
            System.out.printf("%s : %d\n", purchasedItem.getKey(), purchasedItem.getValue());
            totalPrice += getItemPrice(purchasedItem.getKey(), purchasedItem.getValue());
        }
        System.out.println("il prezzo totale della lista della spesa è: "+ totalPrice);
        System.err.println("\n\n!!! Warning: sarebbe stato meglio usare BigDecimal per le operazioni" +
                ", ma avrebbe complicato la lettura delle operazioni matematiche.. !!!");

    }
}