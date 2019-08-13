package com.directCode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class Character {
    private String nome;
    private String nomeVero = "NA";
    private int attacco;
    private int difesa;
    private int prob;

    Character[] pool;

    Character() {
        //readFromFile();
        pool = new Character[14];
        pool[0] = new Character("Arman", 35, 40, 18);
        pool[1] = new Character("SalvoF", 18, 24, 16);
        pool[2] = new Character("SalvoL", 0, 30, 25);
        pool[3] = new Character("Giano", 50, 12, 0);
        pool[4] = new Character("Magazzu", 31, 20, 11);
        pool[5] = new Character("Laura", 32, 20, 8);
        pool[6] = new Character("Anna", 20, 25, 15);
        pool[7] = new Character("Borzi", 18, 38, 3);
        pool[8] = new Character("Ivana", 28, 18, 18);
        pool[9] = new Character("SimoneL", 35, 13, 12);
        pool[10] = new Character("Sofia", 20, 38, 14);
        pool[11] = new Character("Simone", 2, 31, 1);
        pool[12] = new Character("Luca", 12, 2, 4);
        pool[13] = new Character("Francesca", 27, 36, 0);
        for (int i = 0; i < 14; i++)
            System.out.println(i + " - " + pool[i].getNome());
    }

    private Character(String n, int a, int d, int p) {
        nome = n;
        attacco = a;
        difesa = d;
        prob = p;
    }

    void setNomeVero(String nomeVero) {
        this.nomeVero = nomeVero;
    }

    String getNome() {
        return nome;
    }

    String getNomeVero() {
        return nomeVero;
    }

    int getAttacco() {
        return attacco;
    }

    int getDifesa() {
        return difesa;
    }

    int getProb() {
        return prob;
    }

    private void readFromFile() {
        String fileName = "character.txt";
        String line;
        int t = 0;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            pool = new Character[Integer.parseInt(bufferedReader.readLine())];
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(t + " - " + line);
                String N = line;
                line = bufferedReader.readLine();
                int A = Integer.parseInt(line);

                line = bufferedReader.readLine();
                int D = Integer.parseInt(line);

                line = bufferedReader.readLine();
                int P = Integer.parseInt(line);

                pool[t] = new Character(N, A, D, P);
                t++;
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }


}
