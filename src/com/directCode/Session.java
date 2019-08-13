package com.directCode;

import java.util.Random;
import java.util.Scanner;

class Session extends Thread {
    private int day;
    private Character[] pool;

    Session() {
        Character c = new Character();
        day = 1;
        this.pool = c.pool;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean alive = true;
        while (alive) {
            System.out.println("~Console Comandi~ \n 1: chi è ancora vivo \n 2: Incomincia il nuovo giorno + calcola flat \n 3: Qualcuno ha capito qualcosa? \n 4: Uccidi/congela qualcuno \n 0: Termina sessione\nComandi Signore!");
            int temp = scanner.nextInt();
            System.out.println("\n\n\n################################################################################");
            if (temp == 0)
                alive = false;
            if (temp == 1)
                whoIsAlive();
            if (temp == 2)
                newDay();
            if (temp == 3)
                scopri();
            if (temp == 4) {
                System.out.println("Chi? (nome vero)");
                scanner.nextLine();
                String t = scanner.nextLine();
                removePlayer(t);
            }
            System.out.println("################################################################################\n\n");
        }
    }

    void addPlayer(String personavera, int personafinta) {
        if (!pool[personafinta].getNomeVero().equals("NA")) {
            System.out.println(pool[personafinta].getNome() + "  gia assegnato a  " + pool[personafinta].getNomeVero());
        } else {
            pool[personafinta].setNomeVero(personavera);
            System.out.println("Aggiunto " + pool[personafinta].getNomeVero() + " con il ruolo di " + pool[personafinta].getNome() + "\n\n");
        }
    }

    private void removePlayer(String personavera) {
        int i = 0;
        while (!personavera.equals(pool[i].getNomeVero()) && i < 13) {
            i++;
        }
        if (!pool[i].getNomeVero().equals(personavera))
            System.out.println("Nome non trovato");
        else {
            System.out.println("Rimosso " + pool[i].getNomeVero() + " dal ruolo di " + pool[i].getNome());
            pool[i].setNomeVero("NA");
        }
    }

    private void newDay() {
        Random random = new Random();
        System.out.println("Oggi è il giorno numero " + day);
        day++;
        int count = 0;
        for (Character character : pool) {
            if ((character.getProb()) >= random.nextInt(100) && !character.getNomeVero().equals("NA")) {
                System.out.println(character.getNomeVero() + " supera la prova flat!");
                count++;
            }
        }
        if (count == 0)
            System.out.println("Nessuno supera la prova flat");

    }

    private void scopri() {
        int count = 0;
        Random random = new Random();
        for (int i = 0; i < pool.length; i++) {
            for (int j = 0; j < pool.length && i != j; j++) {
                if ((pool[i].getAttacco() - pool[j].getDifesa()) >= random.nextInt(100) && !pool[i].getNomeVero().equals("NA") && !pool[j].getNomeVero().equals("NA")) {
                    System.out.println(pool[i].getNomeVero() + " potrebbe capire qualcosa su " + pool[j].getNomeVero());
                    count++;
                }
            }
        }
        if (count == 0)
            System.out.println("Nessuno ci ha capito un tubo");
    }

    private void whoIsAlive() {
        for (Character character : pool)
            if (!character.getNomeVero().equals("NA"))
                System.out.println(character.getNomeVero());
    }
}
