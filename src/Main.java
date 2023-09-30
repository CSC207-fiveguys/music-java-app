import java.util.Base64;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        Base64.Encoder encoder = Base64.getUrlEncoder();

        // loads spotify client id and spotify client secret from environment variables
        String auth = System.getenv("SPOTIFY_CLIENT_ID") + ":" + System.getenv("SPOTIFY_CLIENT_SECRET");
        byte[] authByteEncoded = auth.getBytes();
        String authB64Encoded = encoder.encodeToString(authByteEncoded);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://accounts.spotify.com/api/token"
                                + "?" + "grant_type=client_credentials"))
                .header("Authorization", "Basic " + authB64Encoded)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .method("POST", HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assert response != null;
        System.out.println(response.body());
    }
}