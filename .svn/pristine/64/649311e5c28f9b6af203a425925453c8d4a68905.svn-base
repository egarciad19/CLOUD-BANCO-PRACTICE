/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dase.gestortareas.controllers;

import com.dase.gestortareas.commons.CommonController;
import com.dase.gestortareas.entities.Pagos;
import com.dase.gestortareas.services.PagosSvc;
import io.swagger.annotations.ApiOperation;
import java.util.Locale;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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

}
