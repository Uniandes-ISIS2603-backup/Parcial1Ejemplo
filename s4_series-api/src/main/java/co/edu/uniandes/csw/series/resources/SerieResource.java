/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.series.resources;

import co.edu.uniandes.csw.series.dtos.SerieDetailDTO;
import co.edu.uniandes.csw.series.ejb.SerieLogic;
import co.edu.uniandes.csw.series.entities.SerieEntity;
import co.edu.uniandes.csw.series.exceptions.BusinessLogicException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author Jose Bocanegra
 */

@Path("series")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class SerieResource {
    @Inject
    private SerieLogic serieLogic;
    
    @POST
    public SerieDetailDTO createSerie(SerieDetailDTO serie) throws BusinessLogicException {
        SerieEntity serieEntity = serie.toEntity();
        serieEntity = serieLogic.createSerie(serieEntity); 
        return new SerieDetailDTO(serieEntity);
    }


    @GET
    @Path("{id: \\d+}")
    public SerieDetailDTO getSerie(@PathParam("id") Long id) {
        SerieEntity serie = serieLogic.getSerie(id);
        if (serie == null) 
            throw new WebApplicationException("La serie no existe");
        return new SerieDetailDTO(serie); 
    }
    
}
