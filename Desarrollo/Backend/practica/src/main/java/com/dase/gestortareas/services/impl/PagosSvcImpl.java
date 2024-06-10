/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dase.gestortareas.services.impl;

import com.dase.gestortareas.commons.CommonSvcImpl;
import com.dase.gestortareas.entities.Pagos;
import com.dase.gestortareas.projection.PagosProjection;
import com.dase.gestortareas.repositories.PagosRepository;
import com.dase.gestortareas.services.PagosSvc;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author egarc
 */
@Service
public class PagosSvcImpl extends CommonSvcImpl<Pagos, PagosRepository> implements PagosSvc{
    
    @Autowired
    private PagosRepository pagosRepository;
    

    public void almacenarPago(double pMontoPago, Integer pIdPrestamo, String pUsuario) {
         this.pagosRepository.almacenarPago(pMontoPago, pIdPrestamo, pUsuario);
    }

    

    public List<PagosProjection> obtenerPagosByIdPrstamo(Integer idPrestamo) {
        try {
            List<PagosProjection> response = this.pagosRepository.findByIdPrestamo1(idPrestamo);
            return response;
        } catch (Exception e) {
            System.err.println("Error al obtener el pago por ID de préstamo: " + e.getMessage());
            return null;
        }
    }
    
}
