package lovecalculator.main;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import static org.junit.Assert.*;

public class GetTest {
    
    private WebTarget lc;
    
    public GetTest()  { 
        // Creazione del client e connessione al servizio
        Client cli = ClientBuilder.newClient();
        lc = cli.target("http://localhost:50002/lovecalculator");
    }    
    
    @Test
    public void testGetOk() throws ParseException {
        String n1 = "Mickey Mouse";
        String n2 = "Minnie Mouse";
        
        // Richiesta di GET
        Response rGet = lc.queryParam("nome1", n1).queryParam("nome2", n2).request().get();
        
        // Verifica che la risposta sia 200 OK
        assertEquals(Status.OK.getStatusCode(), rGet.getStatus());
        
        // Verifica che il contenuto della risposta sia corretto
        JSONParser p = new JSONParser();
        JSONObject risposta = (JSONObject) p.parse(rGet.readEntity(String.class));
        assertEquals(n1, risposta.get("nome1"));
        assertEquals(n2, risposta.get("nome2"));
    }
    
}
