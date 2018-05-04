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

    public static BigInteger toplam = BigInteger.valueOf(0);
    public static BigInteger cikarma = BigInteger.valueOf(0);
    public static String power = " ";
    public static int size = 0;
    private static Node header;
    public String NameOfFile;
    private FileWriter fileWriter = null;
    private BufferedWriter bufferedWriter = null;
    
/*
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
            System.out.print(" ([" + temp.rakem + "] [" + temp.kuvvet + "])-----> ");
            temp = temp.nextNode;
        }

        System.out.print("null\n");
    }
*/
    public void Addtofile() {
        try {
            fileWriter = new FileWriter(NameOfFile);
            bufferedWriter = new BufferedWriter(fileWriter);
            Node temp = header;
            while (temp != null) {
                bufferedWriter.write(" ([" + temp.rakem + "] [" + temp.kuvvet + "]) -----> ");
                temp = temp.nextNode;
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }
/*
    public static void Toplam_islem(LinkedList linkedList) {
        int ToplamRekam = 0;
        int T = 0;
        int size = 0;
        int Toplampower = 0;
        int yemp;
        boolean eq = false;
        // BigInteger toplam = BigInteger.valueOf(0);
        Node temp = header;
        Node temp2 = linkedList.header;
        boolean durum = false, durum2 = false;
        StringBuilder sb = new StringBuilder();
        StringBuilder sbp = new StringBuilder();
        int intr = 0;
        // try{
        String Str = "";
        char arry[] = temp.kuvvet.toCharArray();
        //"1x^2-10+8x^2";
        while (temp != null) {
            temp2 = temp.nextNode;
            while (temp2 != null ) {
                if (temp.kuvvet.isEmpty() || temp.kuvvet.equals(" ")) {
                    durum = true;
                } else {
                    durum = false;
                }
                if (temp2.kuvvet.isEmpty() || temp2.kuvvet.equals(" ")) {
                    durum2 = true;
                } else {
                    durum2 = false;
                }
                eq = temp.kuvvet.charAt(0) == temp2.kuvvet.charAt(0);
                if (eq || temp.kuvvet.equals(temp2.kuvvet)) {
                    char t[] = temp.rakem.toCharArray();
                    if (t[1] == ' ') {
                        sb.append(t);
                        sb.deleteCharAt(1);
                        ToplamRekam = Integer.parseInt(String.copyValueOf(sb.toString().toCharArray())) + Integer.parseInt(temp2.rakem);
                        Toplampower = Integer.parseInt(temp.kuvvet);
                        toplam.add(BigInteger.valueOf((long) Math.pow(ToplamRekam * 2, Toplampower)));
                        temp.kuvvet = null;
                        temp.rakem = null;
                        temp2.kuvvet = null;
                        temp2.rakem = null;

                    } else {

                        String sayi = " ", sayi1 = " ";
                        char h[] = temp.rakem.toCharArray();
                        char y[] = temp2.rakem.toCharArray();
                        StringBuilder builder = new StringBuilder();
                        StringBuilder builder1 = new StringBuilder();
                        builder.append(h);
                        builder1.append(y);
                        try {
                            Toplampower = Integer.valueOf(temp2.kuvvet);
                        } catch (NumberFormatException ex) {
                            sbp.append(temp2.kuvvet.toCharArray());
                            sbp.deleteCharAt(1);
                            Toplampower = Integer.valueOf(sbp.toString());
                        }
                        try {

                            if (h[1] == ' ') {
                                builder.deleteCharAt(1);
                            }
                            if (y[2] == ' ') {
                                builder1.deleteCharAt(2);
                            }
                            // sayi = String.valueOf(builder.toString().toCharArray());
                            sayi1 = String.valueOf(builder1.toString().toCharArray());
                            ToplamRekam = Integer.valueOf(sayi);

                        } catch (NumberFormatException ex) {
                            builder.deleteCharAt(1);
                            sayi = String.valueOf(builder.toString().toCharArray());
                            ToplamRekam = (Integer.valueOf(sayi)*2);
                            ToplamRekam += (Integer.valueOf(sayi1)*2);

                        }
                        toplam = toplam.add(BigInteger.valueOf((int) Math.pow(ToplamRekam , Toplampower)));
                    }
                    break;
                    // temp.kuvvet.charAt(0) == ' ' && temp.kuvvet.charAt(1) == ' ' 
                }
                if (durum) {

                    ToplamRekam = Integer.parseInt(temp.rakem);
                    yemp = ToplamRekam;
                    T = +ToplamRekam;
                    if (size != yemp) {
                        toplam = toplam.add(BigInteger.valueOf(ToplamRekam));
                    }
                }
                if (durum2) {

                    T += Integer.parseInt(temp2.rakem);
                    size = T;
                    toplam = toplam.add(BigInteger.valueOf(T));
                }
                temp2 = temp2.nextNode;
            }
            temp = temp.nextNode;
        }
      //}catch(NumberFormatException ex){

        // }
    }

    public void Cikarma_islem(LinkedList linkedList) {
        int ToplamRekam = 0;
        int T = 0;
        int Toplampower = 0;
        // BigInteger toplam = BigInteger.valueOf(0);
        Node temp = header;
        Node temp2 = linkedList.header;
        boolean durum = false, durum2 = false;
        StringBuilder sb = new StringBuilder();
        // try{
        String Str = "";
        char arry[] = temp.kuvvet.toCharArray();
        while (temp != null) {
            temp2 = temp.nextNode;
            while (temp2 != null) {
                if (temp.kuvvet.isEmpty() || temp.kuvvet.equals(" ")) {
                    durum = true;
                } else {
                    durum = false;
                }
                if (temp2.kuvvet.isEmpty() || temp2.kuvvet.equals(" ")) {
                    durum2 = true;
                } else {
                    durum2 = false;
                }
                if (temp.kuvvet.equals(temp2.kuvvet)) {
                    char t[] = temp.rakem.toCharArray();
                    if (t[1] == ' ') {
                        sb.append(t);
                        sb.deleteCharAt(1);
                        ToplamRekam = Integer.parseInt(String.copyValueOf(sb.toString().toCharArray())) - Integer.parseInt(temp2.rakem);
                        Toplampower = Integer.parseInt(temp.kuvvet);
                        toplam.add(BigInteger.valueOf((long) Math.pow(ToplamRekam * 2, Toplampower)));
                        temp.kuvvet = null;
                        temp.rakem = null;
                        temp2.kuvvet = null;
                        temp2.rakem = null;

                    } else {

                        String sayi = " ", sayi1 = " ";
                        char h[] = temp.rakem.toCharArray();
                        char y[] = temp2.rakem.toCharArray();
                        StringBuilder builder = new StringBuilder();
                        StringBuilder builder1 = new StringBuilder();
                        builder.append(h);
                        builder1.append(y);
                        try {
                            if (h[1] == ' ') {
                                builder.deleteCharAt(1);
                            }
                            if (y[2] == ' ') {
                                builder1.deleteCharAt(2);
                            }
                            // sayi = String.valueOf(builder.toString().toCharArray());
                            sayi1 = String.valueOf(builder1.toString().toCharArray());
                            ToplamRekam = Integer.valueOf(sayi);
                        } catch (NumberFormatException ex) {
                            builder.deleteCharAt(1);
                            sayi = String.valueOf(builder.toString().toCharArray());
                            ToplamRekam = Integer.valueOf(sayi);
                            ToplamRekam -= Integer.valueOf(sayi1);
                            Toplampower = Integer.valueOf(temp.kuvvet);
                        }
                        cikarma = cikarma.add(BigInteger.valueOf((long) Math.pow(ToplamRekam * 2, Toplampower)));

                    }
                    break;
                    // temp.kuvvet.charAt(0) == ' ' && temp.kuvvet.charAt(1) == ' ' 
                } else if (durum) {
                    ToplamRekam = Integer.parseInt(temp.rakem);
                    T = -ToplamRekam;
                    cikarma = cikarma.add(BigInteger.valueOf(ToplamRekam));
                } else if (durum2) {
                    T -= Integer.parseInt(temp2.rakem);
                    cikarma = cikarma.add(BigInteger.valueOf(T));
                }
                temp2 = temp2.nextNode;
            }
            temp = temp.nextNode;
        }
      //}catch(NumberFormatException ex){

        // }
    }
*/
    public static void main(String[] args) throws IOException {
        String denklem = "10+18x^88";
        LinkedList Linklist_1 = new LinkedList();
        //Linklist_1.add(denklem);
        //  Linklist_1.printList();
        Linklist_1.NameOfFile = "list1.txt";
        Linklist_1.Addtofile();
        // String Q = "17x^56+18x^44-11x^37-21x^19+94";
        LinkedList linklist_2 = new LinkedList();
        linklist_2.add(denklem);
        linklist_2.printList();
        linklist_2.NameOfFile = "list2.txt";
        linklist_2.Addtofile();
        LinkedList sonuc = new LinkedList();
        sonuc.Toplam_islem(linklist_2);
        System.out.println("sonuc : " + toplam);

    }
}
