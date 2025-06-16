
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Principal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Double valor;
        Double conversao;
        String endereco;
        String siglas;

        String menu = """ 
			***********************************************
			## Seja bem-vindo(a) ao Conversor de Moedas ##

			1) Real para Dólar.
			2) Real para Euro.
			3) Real para Peso Mexicano.
			4) Real para Iene.

			5) Dólar para Real.
			6) Dólar para Euro.
			7) Dólar para Peso Mexicano.
			8) Dólar para Iene.

			9) Sair.
			10) Continuar convertendo moedas.

			Escolha uma opção válida:
			***********************************************
		"""; 

        int opcao = 0;
        while(opcao != 9) {
            System.out.println(menu);
            opcao = scan.nextInt();

            System.out.println("Digite o valor que deseja converter: ");
            valor = scan.nextDouble();

            try {
                String key = "1beac8861b9e387841e20d02";

                URL url = new URL(endereco);
                HttpURLConnection request = (HttpURLConnection) url.openConnection();
                request.connect();

                BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
                StringBuilder jsonText = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonText.append(line);
                }
                reader.close();

                JsonObject jsonObject = JsonParser.parseString(jsonText.toString()).getAsJsonObject();
                double taxaDeCambio = jsonObject.getAsJsonObject("conversion_rates").get(siglas).getAsDouble();

                conversao = valor * taxaDeCambio;
                System.out.printf("R$ %.2f equivalem a US$ %.2f%n", valor, conversao);


                switch(opcao){
                    case 1:
                        endereco = "https://v6.exchangerate-api.com/v6/"+ key + "/latest/BRL/USD";
                        String sigla = "USD";
                        break;

                    default:
                    System.out.println("Opção inválida!");

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            

        }
        
        scan.close();
    }

}

