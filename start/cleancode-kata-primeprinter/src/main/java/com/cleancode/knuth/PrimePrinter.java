package com.cleancode.knuth;

public class PrimePrinter {
    public static final int numberOfNumbers = 1000; // Champ rendu statique
    // Méthode pour imprimer les nombres premiers
    public void printPrimes(int[] numbers, int numberOfNumbers) {
        int linesPerPage = 50;
        int columns = 4;
        int pagenumber = 1;
        int pageoffset = 1;

        while (pageoffset <= numberOfNumbers) {
            System.out.print("The First ");
            System.out.print(numberOfNumbers);
            System.out.print(" Prime Numbers === Page ");
            System.out.print(pagenumber);
            System.out.println("\n");

            for (int rowoffset = pageoffset; rowoffset < pageoffset + linesPerPage; rowoffset++) {
                for (int column = 0; column < columns; column++) {
                    if (rowoffset + column * linesPerPage <= numberOfNumbers) {
                        System.out.printf("%10d", numbers[rowoffset + column * linesPerPage]);
                    }
                }
                System.out.println();
            }
            System.out.println("\f");

            pagenumber++;
            pageoffset += linesPerPage * columns;
        }
    }

    // Ajouter une méthode main() pour le test
    public static void main(String[] args) {
        PrimePrinterHelper helper = new PrimePrinterHelper();
        helper.generateAndPrintPrimes(); // Appelle la méthode pour générer et imprimer les nombres premiers
    }
}
