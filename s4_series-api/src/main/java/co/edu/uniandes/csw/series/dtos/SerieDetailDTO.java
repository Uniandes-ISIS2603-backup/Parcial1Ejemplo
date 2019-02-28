/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.series.dtos;

import co.edu.uniandes.csw.series.entities.SerieEntity;

/**
 *
 * @author Jose Bocanegra
 */
public class SerieDetailDTO extends SerieDTO {
    
    public SerieDetailDTO(){
    
    }
    
    public SerieDetailDTO(SerieEntity entity){
        super(entity);
    }
    
}
