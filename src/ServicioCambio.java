import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
/**
 * @author ybermeo
 * @since 1.0.0
 **/

public class ServicioCambio {

    private static final String API_KEY = "720a6c84b7711196d37ab81f";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static double obtenerTasaCambio(String monedaDestino) {
        try {
            String url = BASE_URL + API_KEY + "/latest/USD";

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            JsonObject json = gson.fromJson(response.body(), JsonObject.class);

            if (!json.get("result").getAsString().equals("success")) {
                System.out.println("Error en la respuesta de la API.");
                return -1;
            }

            JsonObject rates = json.getAsJsonObject("conversion_rates");

            if (!rates.has(monedaDestino.toUpperCase())) {
                System.out.println("La moneda especificada no está disponible.");
                return -1;
            }

            return rates.get(monedaDestino.toUpperCase()).getAsDouble();

        } catch (Exception e) {
            System.out.println("Error al obtener tasa de cambio: " + e.getMessage());
            return -1;
        }
    }
}

