package mancala.api;

import jakarta.servlet.http.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import mancala.api.models.*;
import mancala.domain.MancalaException;
import mancala.domain.MancalaImpl;

@Path("/move")
public class MoveMancala {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response initialize(@Context HttpServletRequest request, @QueryParam("index") int index) {
        HttpSession session = request.getSession();
        MancalaImpl mancala = (MancalaImpl) session.getAttribute("mancala");

        try{mancala.playPit(index);

            session.setAttribute("mancala", mancala);
            String namePlayer1 = (String) session.getAttribute("namePlayer1");
            String namePlayer2 = (String) session.getAttribute("namePlayer2");

            var output = new Mancala(mancala, namePlayer1, namePlayer2);
            return Response.status(200).entity(output).build();
        }

        catch (MancalaException mancalaException){
            mancalaException.getMessage(); 
            return null;
        }
        
    }
}
