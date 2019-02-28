/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.series.ejb;

import co.edu.uniandes.csw.series.entities.SerieEntity;
import co.edu.uniandes.csw.series.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.series.persistence.SeriePersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Jose Bocanegra
 */
@Stateless
public class SerieLogic {
    @Inject
    private SeriePersistence persistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.
   
    public SerieEntity getSerie(Long id) {
        return persistence.find(id);
    }
    
    //TODO modificar el método createHeroe
  
    public SerieEntity createSerie(SerieEntity entity) throws BusinessLogicException{
        return persistence.create(entity);
    }
    
}
