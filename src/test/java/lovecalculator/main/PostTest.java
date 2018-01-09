package lovecalculator.main;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.Test;
import static org.junit.Assert.*;

public class PostTest {
    
    private WebTarget lc;
    public PostTest()  { 
        // Creazione del client e connessione al servizio
        Client cli = ClientBuilder.newClient();
        lc = cli.target("http://localhost:50002/lovecalculator");
    }    
    
    @Test
    public void testPostNotAllowed() {
        // Richiesta di POST sulla risorsa principale
        Response rPost = lc.request().post(Entity.entity("",MediaType.TEXT_PLAIN));
        
        // Verifica che la risposta sia "405 Not Allowed"
        assertEquals(405, rPost.getStatus());
    }
    
}
