/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dase.gestortareas.services;

import com.dase.gestortareas.commons.CommonSvc;
import com.dase.gestortareas.entities.Cliente;
import java.util.Optional;

/**
 *
 * @author egarc
 */
public interface ClienteSvc extends CommonSvc<Cliente> {

    Optional<Cliente> obtenerRegistroById(Integer id);
}
