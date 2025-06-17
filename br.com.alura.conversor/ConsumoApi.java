import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConsumoApi {
    private String endereco;
    private String siglas;
    private double valor;
    private double conversao;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getConversao() {
        return conversao;
    }

    public void setConversao(double conversao) {
        this.conversao = conversao;
    }

    public void solicitarDados() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o valor que deseja converter: ");
        valor = scan.nextDouble();

    }

    public void conversorMoedas() throws IOException {

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
        double exchangeRate = jsonObject.getAsJsonObject("conversion_rates").get(siglas).getAsDouble();

        conversao = valor * exchangeRate;
        System.out.printf("R$ %.2f equivalem a US$ %.2f%n", valor, conversao);

    }
    
}
