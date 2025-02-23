package de.schumann_lukas.dice;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("throw")
public class ThrowDiceRes {

    @Inject
    private Dice dice;

    @GET
    public Response throwDive(@DefaultValue("6") @QueryParam("max") final int max){
        return Response.ok(dice.generateDiceValue(max)).build();
    }
    
}
