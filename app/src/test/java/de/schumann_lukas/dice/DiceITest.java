package de.schumann_lukas.dice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("IntegrationTest")
public class DiceITest {
    
    @Test
    void callRest() throws URISyntaxException, IOException, InterruptedException{
        final String uri = "http://localhost:3080/diceThrow/dice/throw";
        
        final HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI(uri)).GET().build();

        final int value = Integer.parseInt(HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString()).body());

        assertEquals(true, 1 <= value && value <= 6 );
    }

    @Test
    void callRestWithValidUrlParameter() throws URISyntaxException, IOException, InterruptedException{
        final URI uri = new URI("http://localhost:3080/diceThrow/dice/throw?max=80");
        //http://fedora.fritz.box:3080/diceThrow/dice/throw?max=80
        
        final HttpRequest httpRequest = HttpRequest.newBuilder().uri(uri).GET().build();

        final int value = Integer.parseInt(HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString()).body());

        assertEquals(true, 1 <= value && value <= 80);
    }


}
