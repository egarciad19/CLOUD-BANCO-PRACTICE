/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dase.gestortareas.services.impl;

/**
 *
 * @author egarc
 */

import com.dase.gestortareas.commons.CommonSvcImpl;
import com.dase.gestortareas.entities.Prestamo;
import com.dase.gestortareas.repositories.PrestamosRepository;
import com.dase.gestortareas.services.PrestamoSvc;
import org.springframework.stereotype.Service;

@Service
public class PrestamoSvcImpl extends CommonSvcImpl<Prestamo, PrestamosRepository> implements PrestamoSvc{
    
}
