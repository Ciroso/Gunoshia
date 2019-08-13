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
        readFromFile();
    }

    Character(String n, int a, int d, int p) {
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
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
    //SKill


}
