/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastr_homework_01_ahmettekalan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

/**
 *
 * @author AhmetTekalan
 */
public class LinkedList {

    public static String power = " ";
    public static int size = 0;
    private static Node header;
    public String NameOfFile;
    private FileWriter fileWriter = null;
    private BufferedWriter bufferedWriter = null;

    public void add(String line) {
        // 17x^56+18x^44-11x^37-21x^19+94
        char kuvvet[] = new char[3];
        char rakem[] = new char[3];
        int j = 0, k = 0, ku = 0, rak = 0;
        boolean tempk = false, tempr = true;
        char denklem[] = line.toCharArray();
        for (int i = 0; i < denklem.length; i++) {
//            if (rak == 1) {
//                tempr = true;
//                rak = 0;
//            }
            if (denklem[i] == '+' || denklem[i] == '-') {
                addFirst(rakem, kuvvet);
                for (int l = 0; l < rakem.length; l++) {
                    rakem[l] = ' ';
                }
                for (int l = 0; l < kuvvet.length; l++) {
                    kuvvet[l] = ' ';
                }
                j = 0;
                k = 0;
                tempk = false;
                tempr = true;
//                rak++;
            }
            if (denklem[i] == 'x') {
                tempr = false;
            }
            if (tempr) {

                rakem[j] = denklem[i];
                j++;
            }
            if (ku == 1) {
                tempk = true;
                ku = 0;
            }
            if (denklem[i] == '^') {
                ku++;
            }
            if (tempk) {
                if (denklem[i] != ' ') {
                    kuvvet[k] = denklem[i];
                    k++;
                }

            }

        }
        addFirst(rakem, kuvvet);
    }

    public static Node getHeader() {
        return header;
    }

    public static void setHeader(Node header) {
        LinkedList.header = header;
    }

    private static void addFirst(char rakem[], char kuvvet[]) {
        String numb = " ";
        String powerb = " ";
        // boolean nigt = rakem[0] == '-';
        StringBuilder sb = new StringBuilder();
        sb.append(rakem);
        if (size != 0) {
            //  sb.deleteCharAt(0);
        } else {
            sb.deleteCharAt(2);
            size++;
        }

        String num = String.valueOf(sb.toString().toCharArray());
        StringBuilder sb1 = new StringBuilder();
        sb1.append(kuvvet);
        try {
            if (sb1 == null || sb1.toString().isEmpty() || sb1.charAt(0) == ' ' && sb1.charAt(1) == ' ' && sb1.charAt(2) == ' ') {
                sb1.deleteCharAt(0);
                sb1.deleteCharAt(1);//eger kuvvet sfir oluyor 
                //sb.deleteCharAt(2);
            } else {
                sb1.deleteCharAt(2);
            }

            power = String.valueOf(sb1.toString().toCharArray());
            numb = num;
            powerb = power;
            //    if (nigt) {
            //      numb *= -1;
            //  }
        } catch (NumberFormatException ex) {
            power = " ";
        }
        Node newNode = new Node(numb, powerb);
        Node temp = header;
        if (header == null) {
            header = newNode;
        } else {
            while (temp.nextNode != null) {
                temp = temp.nextNode;
            }
            temp.nextNode = newNode;
        }
    }

    void printList() {
        Node temp = header;

        while (temp != null) {
            System.out.print("(" + temp.rakem + "x^" + temp.kuvvet + ") -----> ");
            temp = temp.nextNode;
        }

        System.out.print("null\n");
    }

    public void Addtofile() {
        try {
            fileWriter = new FileWriter(NameOfFile);
            bufferedWriter = new BufferedWriter(fileWriter);
            Node temp = header;
            while (temp != null) {
                bufferedWriter.write("(" + temp.rakem + " x  ^" + temp.kuvvet + ") -----> ");
                temp = temp.nextNode;
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public static void Toplam_islem(LinkedList linkedList) {
        int ToplamRekam = 0;
        int Toplampower = 0;
        BigInteger toplam = BigInteger.valueOf(0);
        Node temp = header;
        Node temp2 = linkedList.header;
        while (temp != null) {
            temp2 = temp.nextNode;
            while (temp2 != null) {
                if (temp.kuvvet.equals(temp2.kuvvet)) {
                    ToplamRekam = Integer.parseInt(temp.rakem) + Integer.parseInt(temp2.rakem);
                    Toplampower = Integer.parseInt(temp.kuvvet);
                    toplam.add(BigInteger.valueOf((long) Math.pow(ToplamRekam * 2, Toplampower)));
                    temp.kuvvet = null;
                    temp.rakem = null;
                    temp2.kuvvet = null;
                    temp2.rakem = null;
                    break;
                } else if (temp.kuvvet.isEmpty() || temp.kuvvet.charAt(0) == ' ' && temp.kuvvet.charAt(1) == ' ' && temp.kuvvet.charAt(2) == ' '
                        || temp2.kuvvet.isEmpty() || temp2.kuvvet.charAt(0) == ' ' && temp2.kuvvet.charAt(1) == ' ' && temp2.kuvvet.charAt(2) == ' ') {
                    ToplamRekam = Integer.parseInt(temp.rakem) + Integer.parseInt(temp2.rakem);
                    toplam.add(BigInteger.valueOf(ToplamRekam));
                    temp.kuvvet = null;
                    temp.rakem = null;
                    temp2.kuvvet = null;
                    temp2.rakem = null;
                }
                temp2 = temp2.nextNode;
            }
            temp = temp.nextNode;
        }
    }

    public void Cikarma_islem(LinkedList linkedList) {

    }

    public static void main(String[] args) throws IOException {
        String denklem = "18x^75-12";
        LinkedList Linklist_1 = new LinkedList();
        Linklist_1.add(denklem);
        Linklist_1.printList();
        Linklist_1.NameOfFile = "list1.txt";
        Linklist_1.Addtofile();
        String Q = "17x^56+18x^44-11x^37-21x^19+94";
        LinkedList linklist_2 = new LinkedList();
        linklist_2.add(Q);
        linklist_2.printList();
        linklist_2.NameOfFile = "list2.txt";
        linklist_2.Addtofile();
        LinkedList sonuc = new LinkedList();
        //  sonuc.Toplam_islem(linklist_2);

    }
}
