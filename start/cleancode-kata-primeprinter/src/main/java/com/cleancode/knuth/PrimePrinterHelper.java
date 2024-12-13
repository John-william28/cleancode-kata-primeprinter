package com.cleancode.knuth;

public class PrimePrinterHelper {

    private final int[] primes = new int[PrimePrinter.numberOfNumbers + 1]; // Utilise le champ statique
    private final int ordmax = 30;
    private final int[] multiples = new int[ordmax + 1];
    private int candidate = 1;
    private int primeIndex = 1;
    private boolean possiblyPrime;
    private int ord = 2;
    private int square = 9;
    private int n = 0;

    // Méthode pour générer et retourner les nombres premiers
    public int[] generatePrimes() {
        primes[1] = 2;

        while (primeIndex < PrimePrinter.numberOfNumbers) {
            do {
                candidate += 2;
                if (candidate == square) {
                    ord++;
                    square = primes[ord] * primes[ord];
                    multiples[ord - 1] = candidate;
                }
                n = 2;
                possiblyPrime = true;
                while (n < ord && possiblyPrime) {
                    while (multiples[n] < candidate)
                        multiples[n] += primes[n] + primes[n];
                    if (multiples[n] == candidate)
                        possiblyPrime = false;
                    n++;
                }
            } while (!possiblyPrime);
            primeIndex++;
            primes[primeIndex] = candidate;
        }

        return primes; // Retourne les nombres premiers générés
    }

    // Classe interne déplacée au niveau supérieur
    public static class NumberPrinter {

        public void printNumbers(int[] primes, int numberOfPrimes) {
            PrimePrinter printer = new PrimePrinter();
            printer.printPrimes(primes, numberOfPrimes); // Appelle printPrimes
        }
    }

    // Méthode qui génère les nombres premiers et les imprime
    public void generateAndPrintPrimes() {
        int[] numbers = generatePrimes(); // Génère les nombres premiers
        NumberPrinter printer = new NumberPrinter(); // Crée une instance de NumberPrinter
        printer.printNumbers(numbers, PrimePrinter.numberOfNumbers); // Appelle printNumbers
    }
}
