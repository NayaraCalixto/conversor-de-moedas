import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ConsumoApi consumo = new ConsumoApi();

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

            try {
                String key = "1beac8861b9e387841e20d02";
                switch(opcao){
                    case 1:
                        String endereco = "https://v6.exchangerate-api.com/v6/"+ key + "/latest/BRL/USD";
                        consumo.setEndereco(endereco);
                        String sigla = "USD";
                        consumo.setSiglas(sigla);
                        consumo.solicitarDados();
                        consumo.conversorMoedas();
                        break;

                    case 2: 
                        String endereco = "https://v6.exchangerate-api.com/v6/"+ key + "/latest/BRL/EUR";
                        consumo.setEndereco(endereco);
                        String sigla = "EUR";
                        consumo.setSiglas(sigla);
                        consumo.solicitarDados();
                        consumo.conversorMoedas();
                        break;

                    case 3: 
                        String endereco = "https://v6.exchangerate-api.com/v6/"+ key + "/latest/BRL/MXN";
                        consumo.setEndereco(endereco);
                        String sigla = "MXN";
                        consumo.setSiglas(sigla);
                        consumo.solicitarDados();
                        consumo.conversorMoedas();
                        break;

                    case 4: 
                        String endereco = "https://v6.exchangerate-api.com/v6/"+ key + "/latest/BRL/JPY";
                        consumo.setEndereco(endereco);
                        String sigla = "JPY";
                        consumo.setSiglas(sigla);
                        consumo.solicitarDados();
                        consumo.conversorMoedas();
                        break;
                    
                    case 5:
                        String endereco = "https://v6.exchangerate-api.com/v6/"+ key + "/latest/USD/BRL";
                        consumo.setEndereco(endereco);
                        String sigla = "BRL";
                        consumo.setSiglas(sigla);
                        consumo.solicitarDados();
                        consumo.conversorMoedas();
                        break;

                    case 6: 
                        String endereco = "https://v6.exchangerate-api.com/v6/"+ key + "/latest/USD/EUR";
                        consumo.setEndereco(endereco);
                        String sigla = "EUR";
                        consumo.setSiglas(sigla);
                        consumo.solicitarDados();
                        consumo.conversorMoedas();
                        break;

                    case 7: 
                        String endereco = "https://v6.exchangerate-api.com/v6/"+ key + "/latest/USD/MXN";
                        consumo.setEndereco(endereco);
                        String sigla = "MXN";
                        consumo.setSiglas(sigla);
                        consumo.solicitarDados();
                        consumo.conversorMoedas();
                        break;

                    case 8: 
                        String endereco = "https://v6.exchangerate-api.com/v6/"+ key + "/latest/USD/JPY";
                        consumo.setEndereco(endereco);
                        String sigla = "JPY";
                        consumo.setSiglas(sigla);
                        consumo.solicitarDados();
                        consumo.conversorMoedas();
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
