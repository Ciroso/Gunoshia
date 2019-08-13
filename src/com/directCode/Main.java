package com.directCode;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Session session = new Session();
        boolean adding = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nBenvenuto nella selezione personaggi!");
        while (adding) {
            System.out.println("Immetti il nome del prossimo partecipante oppure scrivi   start   per cominciare la partita");
            String tempName = scanner.nextLine();
            if (tempName.equals("start"))
                adding = false;
            else {
                int tempNumber;
                do {
                    System.out.println("Immetti il numero corrisppondente al personaggio");
                    tempNumber = scanner.nextInt();
                    scanner.nextLine();
                    if (tempNumber > 14 || tempNumber < 0)
                        System.out.println("Selezione non valida, riprova!");
                } while (tempNumber > 14 || tempNumber < 0);
                session.addPlayer(tempName, tempNumber);
            }
        }
        session.start();
    }
}
