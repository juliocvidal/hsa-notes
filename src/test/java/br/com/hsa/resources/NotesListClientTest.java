package br.com.hsa.resources;

import java.util.Arrays;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.hsa.models.Note;

public class NotesListClientTest
{

   public static void main(String[] args)
   {
      list("https://localhost:8443/hsaNotes-1.0.0/notes");

   }

   public static void list(String uri)
   {
      Client client = ClientBuilder.newClient();
      Builder request = client.target(uri)
            .request().accept(MediaType.APPLICATION_JSON);
      Response response = request.buildGet().invoke();

      System.out.println("List of products " + Arrays.toString(response.readEntity(Note[].class)));
   }
}
