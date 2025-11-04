package org.leanit;

import org.leanit.esercizioTre.User;
import org.leanit.esercizioTre.UsersConsumer;

import java.util.ArrayList;

public class Esercizio_TRE {

    public static void main(String[] args) {
        ArrayList<User> listaUtenti = new ArrayList<>();


        listaUtenti.add(new User("Mario", "Rossi", 30));
        listaUtenti.add(new User("Anna", "Verdi", 25));
        listaUtenti.add(new User("Luca", "Bianchi", 45));
        listaUtenti.add(new User("Elena", "Neri", 38));
        listaUtenti.add(new User("Gigi", "Doe", 85));
        listaUtenti.add(new User("Ajeje", "Brazorf", 23));
        listaUtenti.add(new User("Mike", "Scotti", 25));
        listaUtenti.add(new User("John", "Snow", 27));

        UsersConsumer usersConsumer = new UsersConsumer();
        usersConsumer.consume(listaUtenti);

    }
}
