package mancala.api;

import java.io.IOException;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import mancala.api.models.*;
import mancala.domain.MancalaImpl;

@Path("/move")
public class MoveMancala {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
	public Response initialize(@Context HttpServletRequest request, @QueryParam("index") int index) {
        HttpSession session = request.getSession(true);
        MancalaImpl mancala = (MancalaImpl) session.getAttribute("mancala");

        mancala.playPit(index);

        session.setAttribute("mancala", mancala);
        String namePlayer1 = (String) session.getAttribute("namePlayer1");
        String namePlayer2 = (String) session.getAttribute("namePlayer2");
        
        return Response.status(200).entity(output).build();
    }
}
