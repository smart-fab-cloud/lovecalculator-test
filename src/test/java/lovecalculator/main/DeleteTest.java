package inventario.main;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeleteTest {
    
    private WebTarget lc;
    public DeleteTest()  { 
        // Creazione del client e connessione al servizio
        Client cli = ClientBuilder.newClient();
        lc = cli.target("http://localhost:50002/lovecalculator");
    }    
    
    @Test
    public void testDeleteNotAllowed() {
        // Richiesta di Delete sulla risorsa principale
        Response rDelete = lc.request().delete();
        
        // Verifica che la risposta sia "405 Not Allowed"
        assertEquals(405, rDelete.getStatus());
    }
    
}
