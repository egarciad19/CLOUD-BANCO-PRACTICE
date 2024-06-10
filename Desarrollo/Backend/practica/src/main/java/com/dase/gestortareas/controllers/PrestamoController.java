/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dase.gestortareas.controllers;

import com.dase.gestortareas.commons.CommonController;
import com.dase.gestortareas.entities.Prestamo;
import com.dase.gestortareas.projection.PagosProjection;
import com.dase.gestortareas.projection.PrestamosProjection;
import com.dase.gestortareas.services.PrestamoSvc;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author egarc
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/prestamo")
public class PrestamoController extends CommonController<Prestamo, PrestamoSvc>{
    
    @Autowired
    private PrestamoSvc svc;
    
    
    @GetMapping(path = "/obtenerPrestamos/{noIdentificacion}")
    @ApiOperation(value = "Obtener prestamos por cliene")
    public ResponseEntity<List<PrestamosProjection>> obtenerPrestamos(
            @PathVariable("noIdentificacion") String noIdentificacion) {
        try {
            List<PrestamosProjection> pagosOpt = this.svc.obtenerPagosByIdPrstamo(noIdentificacion);
            if (!pagosOpt.isEmpty()) {
                return new ResponseEntity<>(pagosOpt, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // Log the error (consider using a logging framework like SLF4J)
            System.err.println("Error al obtener el pago por ID de préstamo: " + e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
