package br.com.hsa.resources;

import java.net.MalformedURLException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.hsa.models.User;

public class UserCreationClientTest
{

   public static void main(String[] args) throws MalformedURLException
   {
      Client client = ClientBuilder.newClient();
      Builder request = client.target("https://localhost:8443/hsanotes/users/signup")
            .request().accept(MediaType.APPLICATION_JSON);

      Entity<User> entity = Entity.entity(new User(), MediaType.APPLICATION_JSON);
      Response response = request.buildPost(entity).invoke();

      System.out.println("Following location " + response.getLocation());

      NotesListClientTest.list(response.getLocation().toURL().toExternalForm());

   }
}
