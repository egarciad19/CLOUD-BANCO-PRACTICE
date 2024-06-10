/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dase.gestortareas.projection;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author egarc
 */
public interface PrestamosProjection {

    Integer getIdPrestamo();

    String getNoIdentificacion();

    double getMontoAprobado();

    Date getFechaAprobacion();

    Integer getCantidadMeses();

    double getSaldoPendiente();

    String getNombreEstado();

}
