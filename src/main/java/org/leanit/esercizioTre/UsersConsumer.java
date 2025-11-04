package org.leanit.esercizioTre;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UsersConsumer implements UsersConsumerInterface {
//    Versione con i comparator .. ma non so se potevo modificare le classi aggiungendo il getAge
//    @Override
//    public void consume(List<User> collection) {
//        collection.sort(Comparator.comparingInt(User::getAge));
//    }

    @Override
    public void consume(List<User> collection) {

        User[] userArray = collection.toArray(new User[0]);

        int n = userArray.length;

        // buble sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int currValue = userArray[j].getAge();
                int nextValue = userArray[j+1].getAge();

                // Confronta l'elemento corrente con il successivo
                // Se l'elemento corrente è maggiore del successivo, scambiali
                if (currValue > nextValue) {
                    // Scambio usando una variabile temporanea
                    User temp = userArray[j];
                    userArray[j] = userArray[j+1];
                    userArray[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            User user = userArray[i];
            System.out.printf("%s, %s (%d)\n", user.surname, user.name, user.age);
        }
    }

}
