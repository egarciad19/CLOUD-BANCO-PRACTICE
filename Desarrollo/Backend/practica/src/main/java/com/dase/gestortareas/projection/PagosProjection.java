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
public interface PagosProjection {
    
    Integer getCodigoPago();

    Date getFechaPago();

    BigDecimal getMontoPago();

    String getUsuarioAdiciono();

    Date getFechaAdiciono();

    String getUsuarioModifico();

    Date getFechaModifico();

    Integer getIdPrestamo();
}
