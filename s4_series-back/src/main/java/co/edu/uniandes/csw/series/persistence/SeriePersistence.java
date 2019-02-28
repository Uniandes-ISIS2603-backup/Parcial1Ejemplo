/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.series.persistence;

import co.edu.uniandes.csw.series.entities.SerieEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jose Bocanegra
 */

@Stateless
public class SeriePersistence {
    private static final Logger LOGGER = Logger.getLogger(SeriePersistence.class.getName());
    
    @PersistenceContext(unitName = "seriesPU")
    protected EntityManager em;
    
    public SerieEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando serie por nombre ", name);

        // Se crea un query para buscar series con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From SerieEntity e where e.name = :name", SerieEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("name", name);
        // Se invoca el query se obtiene la lista resultado
        List<SerieEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }

  
    public SerieEntity find(Long id) {
        return em.find(SerieEntity.class, id);
    }
    
    //TODO método crear de serie

    public SerieEntity create(SerieEntity entity){
        em.persist(entity);
        return entity;
    }
}
