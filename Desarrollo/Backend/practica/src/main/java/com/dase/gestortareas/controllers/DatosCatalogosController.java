/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dase.gestortareas.controllers;

import com.dase.gestortareas.commons.CommonController;
import com.dase.gestortareas.entities.Cliente;
import com.dase.gestortareas.entities.DatosCatalogos;
import com.dase.gestortareas.services.ClienteSvc;
import com.dase.gestortareas.services.DatosCatalogosSvc;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author egarc
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/catalogo")
public class DatosCatalogosController extends CommonController<DatosCatalogos, DatosCatalogosSvc>{
    
}
