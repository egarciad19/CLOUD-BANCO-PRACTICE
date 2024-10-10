/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dase.gestortareas.services.impl;

import com.dase.gestortareas.commons.CommonSvcImpl;
import com.dase.gestortareas.entities.Solicitud;
import com.dase.gestortareas.repositories.PagosRepository;
import com.dase.gestortareas.repositories.SolicitudRepository;
import com.dase.gestortareas.services.SolicitudSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author egarc
 */
@Service
public class SolicitudSvcImpl extends CommonSvcImpl<Solicitud, SolicitudRepository> implements SolicitudSvc{

    @Autowired
    private SolicitudRepository solicitudRepository;
    
    public void actualizaEstado(String pUsuario, Integer pEstado, Integer pNoSolicitud) {
        this.solicitudRepository.actualizarEstado(pUsuario, pEstado, pNoSolicitud);
    }
    
}
