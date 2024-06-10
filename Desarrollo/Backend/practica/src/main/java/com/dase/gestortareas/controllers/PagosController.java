/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dase.gestortareas.controllers;

import com.dase.gestortareas.commons.CommonController;
import com.dase.gestortareas.entities.Pagos;
import com.dase.gestortareas.projection.PagosProjection;
import com.dase.gestortareas.services.PagosSvc;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author egarc
 */
@RestController

@RequestMapping(path = "/pagos")
public class PagosController extends CommonController<Pagos, PagosSvc> {

    @Autowired
    private PagosSvc pagoService;

    @PostMapping(path = "/almacenar/{monto}/{idPrestamo}/{usuario}")
    @ApiOperation(value = "Guarda la informacion")
    public void save(
            @PathVariable("monto") double monto,
            @PathVariable("idPrestamo") Integer idPrestamo,
            @PathVariable("usuario") String usuario) {
        this.pagoService.almacenarPago(monto, idPrestamo, usuario);
    }
    
    @GetMapping(path = "/obtenerPagos/{idPrestamo}")
    @ApiOperation(value = "Obtener pagos por ID de prestamo")
    public ResponseEntity<List<PagosProjection>> obtenerPagosByIdPrestamo(
            @PathVariable("idPrestamo") Integer idPrestamo) {
        try {
            List<PagosProjection> pagosOpt = this.pagoService.obtenerPagosByIdPrstamo(idPrestamo);
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
