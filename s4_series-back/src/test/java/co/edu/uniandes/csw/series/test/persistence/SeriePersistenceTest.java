/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.series.test.persistence;

import co.edu.uniandes.csw.series.entities.SerieEntity;
import co.edu.uniandes.csw.series.persistence.SeriePersistence;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author Jose Bocanegra
 */

@RunWith(Arquillian.class)
public class SeriePersistenceTest {
    @Inject
    SeriePersistence seriePersistence;

    @PersistenceContext
    EntityManager em;
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(SerieEntity.class.getPackage())
                .addPackage(SeriePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Test
    public void createSerieTest() {
        PodamFactory factory = new PodamFactoryImpl();
        SerieEntity newEntity = factory.manufacturePojo(SerieEntity.class);
        SerieEntity result = seriePersistence.create(newEntity);

        Assert.assertNotNull(result);

        /*SerieEntity entity = em.find(SerieEntity.class, result.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());     
        Assert.assertEquals(newEntity.getDescription(), entity.getDescription());     */

        //TODO agregar protagonistas, persistirlos y validar si se están relacionando correctamente
         
    }
}
