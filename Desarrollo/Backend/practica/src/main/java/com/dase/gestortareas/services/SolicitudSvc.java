/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dase.gestortareas.services;

import com.dase.gestortareas.commons.CommonSvc;
import com.dase.gestortareas.entities.Solicitud;

/**
 *
 * @author egarc
 */
public interface SolicitudSvc extends CommonSvc<Solicitud>{
    public void actualizaEstado(String pUsuario, Integer pEstado, Integer pNoSolicitud);
}
