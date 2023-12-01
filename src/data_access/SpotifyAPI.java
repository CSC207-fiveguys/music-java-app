package data_access;

import java.net.URLEncoder;
import java.util.Base64;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.io.IOException;
import org.json.JSONObject;
import java.nio.charset.StandardCharsets;

public class SpotifyAPI {
    private String accessToken;
    private String authB64Encoded;

    public String requestToken() {
        HttpClient client = HttpClient.newHttpClient();
        Base64.Encoder encoder = Base64.getUrlEncoder();
        String auth =
            System.getenv("SPOTIFY_CLIENT_ID") + ":" + System.getenv("SPOTIFY_CLIENT_SECRET");
        byte[] authByteEncoded = auth.getBytes();
        authB64Encoded = encoder.encodeToString(authByteEncoded);

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(
                "https://accounts.spotify.com/api/token" + "?" + "grant_type=client_credentials"))
            .header("Authorization", "Basic " + authB64Encoded)
            .header("Content-Type", "application/x-www-form-urlencoded")
            .method("POST", HttpRequest.BodyPublishers.noBody())
            .build();

        HttpResponse<String> response = null;
        JSONObject jsonResponse = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            jsonResponse = new JSONObject(response.body());
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        assert jsonResponse != null;
        accessToken = jsonResponse.getString("access_token");
        return accessToken;
    }

    public JSONObject search_artist(String query, String accessToken) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.spotify.com/v1/search?q=" + URLEncoder.encode(query,
                StandardCharsets.UTF_8) + "&type=artist" + "&market=CA" + "&limit=5"))
            .header("Authorization", "Bearer " + accessToken)
            .method("GET", HttpRequest.BodyPublishers.noBody())
            .build();

        HttpResponse<String> response = null;
        JSONObject jsonResponse = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            jsonResponse = new JSONObject(response.body());
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        return jsonResponse;
    }

    public JSONObject search_track(String query, String accessToken) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.spotify.com/v1/search?q=" + URLEncoder.encode(query,
                StandardCharsets.UTF_8) + "&type=track" + "&market=CA" + "&limit=5"))
            .header("Authorization", "Bearer " + accessToken)
            .method("GET", HttpRequest.BodyPublishers.noBody())
            .build();

        HttpResponse<String> response = null;
        JSONObject jsonResponse = null;

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            jsonResponse = new JSONObject(response.body());
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        return jsonResponse;
    }
}
