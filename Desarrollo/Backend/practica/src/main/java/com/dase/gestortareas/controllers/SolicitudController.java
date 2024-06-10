/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dase.gestortareas.controllers;

import com.dase.gestortareas.commons.CommonController;
import com.dase.gestortareas.entities.Solicitud;
import com.dase.gestortareas.jsons.SolicitudActualizaRest;
import com.dase.gestortareas.services.SolicitudSvc;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author egarc
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/solicitud")
public class SolicitudController extends CommonController<Solicitud, SolicitudSvc>{
    
    @Autowired
    private SolicitudSvc solicitudService;
    
    @PostMapping("/actualiza/estado")
    @ApiOperation(value = "actualiza estado", notes = "actualiza estado")
    public void actualizaEstado(
            @RequestBody SolicitudActualizaRest params) {
        this.solicitudService.actualizaEstado(params.getUsuario(), params.getEstado(), params.getNoSolicitud());
    }
}
