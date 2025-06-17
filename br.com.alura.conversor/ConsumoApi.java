import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class ConsumoApi {
    private String moedaOrigem;
    private String moedaDestino;
    private double valor;
    private double valorConvertido;
    private String apiKey; 

    public ConsumoApi(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getMoedaOrigem() {
        return moedaOrigem;
    }

    public void setMoedaOrigem(String moedaOrigem) {
        this.moedaOrigem = moedaOrigem;
    }

    public String getMoedaDestino() {
        return moedaDestino;
    }

    public void setMoedaDestino(String moedaDestino) {
        this.moedaDestino = moedaDestino;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }

    public void solicitarValor(Scanner scanner) {
        System.out.println("\nDigite o valor que deseja converter: ");
        this.valor = scanner.nextDouble();
    }

    public void realizarConversao() throws IOException, JsonSyntaxException {
        String endereco = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + moedaOrigem;

        URL url = new URL(endereco);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        int responseCode = request.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new IOException("Erro ao conectar à API: " + responseCode + " " + request.getResponseMessage());
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder jsonText = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonText.append(line);
        }
        reader.close();

        JsonObject jsonObject = JsonParser.parseString(jsonText.toString()).getAsJsonObject();

        if (!jsonObject.has("conversion_rates") || !jsonObject.getAsJsonObject("conversion_rates").has(moedaDestino)) {
            throw new IllegalArgumentException("Não foi possível obter a taxa de câmbio para a moeda de destino: " + moedaDestino);
        }

        double taxaDeCambio = jsonObject.getAsJsonObject("conversion_rates").get(moedaDestino).getAsDouble();

        this.valorConvertido = this.valor * taxaDeCambio;
        System.out.printf("\nO valor de %.2f %s equivale a %.2f %s%n", this.valor, this.moedaOrigem, this.valorConvertido, this.moedaDestino);
    }
    
}
