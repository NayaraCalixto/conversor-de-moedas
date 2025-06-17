import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.google.gson.JsonSyntaxException;

public class Principal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String apiKey = "1beac8861b9e387841e20d02"; 
        ConsumoApi consumoApi = new ConsumoApi(apiKey);

        String menu = """
            ***********************************************
            ## Seja bem-vindo(a) ao Conversor de Moedas ##

            1) Real (BRL) para Dólar (USD).
            2) Real (BRL) para Euro (EUR).
            3) Real (BRL) para Peso Mexicano (MXN).
            4) Real (BRL) para Iene (JPY).

            5) Dólar (USD) para Real (BRL).
            6) Dólar (USD) para Euro (EUR).
            7) Dólar (USD) para Peso Mexicano (MXN).
            8) Dólar (USD) para Iene (JPY).

            9) Sair.
            ***********************************************
            Escolha uma opção válida:
            """;

        int opcao = 0;
        while (opcao != 9) {
            System.out.println(menu);
            try {
                opcao = scan.nextInt();

                if (opcao >= 1 && opcao <= 8) {
                    // Refatoração para evitar duplicação de código
                    String moedaOrigem = "";
                    String moedaDestino = "";

                    switch (opcao) {
                        case 1:
                            moedaOrigem = "BRL";
                            moedaDestino = "USD";
                            break;
                        case 2:
                            moedaOrigem = "BRL";
                            moedaDestino = "EUR";
                            break;
                        case 3:
                            moedaOrigem = "BRL";
                            moedaDestino = "MXN";
                            break;
                        case 4:
                            moedaOrigem = "BRL";
                            moedaDestino = "JPY";
                            break;
                        case 5:
                            moedaOrigem = "USD";
                            moedaDestino = "BRL";
                            break;
                        case 6:
                            moedaOrigem = "USD";
                            moedaDestino = "EUR";
                            break;
                        case 7:
                            moedaOrigem = "USD";
                            moedaDestino = "MXN";
                            break;
                        case 8:
                            moedaOrigem = "USD";
                            moedaDestino = "JPY";
                            break;
                    }

                    consumoApi.setMoedaOrigem(moedaOrigem);
                    consumoApi.setMoedaDestino(moedaDestino);
                    consumoApi.solicitarValor(scan); 
                    consumoApi.realizarConversao();

                } else if (opcao != 9) { 
                    System.out.println("Opção inválida! Por favor, escolha uma opção entre 1 e 9.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                scan.next(); 
            } catch (IOException e) {
                System.err.println("Erro de comunicação com a API: " + e.getMessage());
            } catch (JsonSyntaxException e) {
                System.err.println("Erro ao processar a resposta da API (JSON inválido): " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.err.println("Erro: " + e.getMessage());
            } catch (Exception e) { 
                System.err.println("Ocorreu um erro inesperado: " + e.getMessage());
            } finally {
                // Adiciona uma pausa para o usuário ler a mensagem antes de exibir o menu novamente
                if (opcao != 9) {
                    System.out.println("\nPressione Enter para continuar...");
                    scan.nextLine(); 
                    scan.nextLine(); 
                }
            }
        }
        System.out.println("Obrigado por usar o Conversor de Moedas! Até logo.");
        scan.close(); 
    }

}
