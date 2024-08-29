package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void gravaArquivoCsv(List<Cachorro> lista, String nomeArq) {
        FileWriter arq = null; // Representa o arquivo a ser gravado
        Formatter saida = null; // Representa os dados que estão saido do programa
        Boolean deuRuim = false;

        //Acrescenta a extensão .csv no arquivo
        nomeArq += ".csv";

        // Bloco try-cath para abrir o arquivo
        try {
            arq = new FileWriter(nomeArq); // Abre o arquivo
            saida = new Formatter(arq);
        }
        catch (IOException erro) {
            System.out.println("Erro o abrir o arquivo");
            erro.printStackTrace();
            System.exit(1);
        }

        // Bloco try-catch para gravar o arquivo
        try {

            for (Cachorro dog : lista) {
                saida.format("%d;%s;%s;%.1f\n", dog.getId(), dog.getNome(),dog.getPorte(), dog.getPeso());
            }

        }
        catch (FormatterClosedException erro) {
            System.out.println("Erro ao grvar o arquivo");
            erro.printStackTrace();
            deuRuim = true;
        }

        finally {
            saida.close();
            try {
                arq.close();
            }
            catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
        }
        public static void leExibeArquivoCsv(String nomeArq){
            FileReader arq = null; // Representa o arquivo a ser lido
            Scanner entrada = null; // objeto usado para ler o arquivo
            Boolean deuRuim = false;

            // Acrescenta a extensao .csv ao nome do arquivo
            nomeArq += ".csv";

            // Bloco try catch para abrir o arquivo
            try{
                arq = new FileReader(nomeArq);
                entrada = new Scanner(arq).useDelimiter(";|\\n");
            }
            catch (FileNotFoundException erro) {
                System.out.println("Erro ao abrir o arquivo");
                erro.printStackTrace();
                System.exit(1);
        }
            // Bloco try-catch para ler o arquivo
            try {
                System.out.printf("%4S %-15S %-9S %4S\n", "id", "nome", "porte", "peso");
                while (entrada.hasNext()){
                    int id = entrada.nextInt();
                    String nome = entrada.next();
                    String porte = entrada.next();
                    Double peso = entrada.nextDouble();

                    System.out.printf("%4d %-15S %-9S %4.1f\n", id,nome,porte,peso);
                }
            }
        catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            erro.printStackTrace();
            deuRuim = true;
        }
            catch (IllegalStateException erro) {
                System.out.println("Erro na leitura do arquivo");
                erro.printStackTrace();
                deuRuim = true;
            }
            finally {
                entrada.close();
                try {
                    arq.close();
                }
                catch (IOException erro) {
                    System.out.println("Erro ao fechar o arquivo");
                    deuRuim = true;
                }
                if (deuRuim) {
                    System.exit(1);
                }
            }
        }

    public static void main(String[] args) {
            List<Cachorro> listaDog = new ArrayList<>();

            listaDog.add(new Cachorro(1,"Mel","Medio",5.0));
            listaDog.add(new Cachorro(2,"Mel","Medio",5.0));
            listaDog.add(new Cachorro(3,"Mel","Medio",5.0));
            listaDog.add(new Cachorro(4,"Mel","Medio",5.0));
             listaDog.add(new Cachorro(5,"Mel","Medio",5.0));

        System.out.println("Lista de dogs");
            for (Cachorro dog : listaDog) {
                System.out.println(dog);
            }

            gravaArquivoCsv(listaDog, "dogs");

            //Le e exibe o arquivo .csv
        System.out.println("\nDados lidos do arquivo:");
        leExibeArquivoCsv("dogs");
     }
}