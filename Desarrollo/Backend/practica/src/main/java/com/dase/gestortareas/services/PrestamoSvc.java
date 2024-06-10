/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dase.gestortareas.services;

import com.dase.gestortareas.commons.CommonSvc;
import com.dase.gestortareas.entities.Prestamo;
import com.dase.gestortareas.projection.PagosProjection;
import com.dase.gestortareas.projection.PrestamosProjection;
import java.util.List;

/**
 *
 * @author egarc
 */
public interface PrestamoSvc extends CommonSvc<Prestamo>{
    
    public List<PrestamosProjection> obtenerPagosByIdPrstamo(String noIdentificacion);
}
