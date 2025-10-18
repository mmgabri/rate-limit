package br.com.mmgabri.testes;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.math.BigInteger;

public class CalculadoraFatorial {

    // Calcula fatorial usando BigInteger para evitar overflow
    private static BigInteger calcularFatorial(int numero) {
        if (numero < 0) {
            throw new IllegalArgumentException("O número não pode ser negativo");
        }
        BigInteger resultado = BigInteger.ONE;
        for (int i = 2; i <= numero; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }
        return resultado;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número para calcular o fatorial: ");
        try {
            int numero = scanner.nextInt();
            BigInteger resultado = calcularFatorial(numero);
            System.out.printf("O fatorial de %d é %s%n", numero, resultado.toString());
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida: digite um número inteiro.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

