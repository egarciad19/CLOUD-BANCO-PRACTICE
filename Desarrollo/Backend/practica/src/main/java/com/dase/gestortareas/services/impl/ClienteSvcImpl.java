/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dase.gestortareas.services.impl;

import com.dase.gestortareas.commons.CommonSvcImpl;
import com.dase.gestortareas.entities.Cliente;
import com.dase.gestortareas.repositories.ClienteRepository;
import com.dase.gestortareas.services.ClienteSvc;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author egarc
 */
@Service
public class ClienteSvcImpl extends CommonSvcImpl<Cliente, ClienteRepository> implements ClienteSvc {

    @Autowired
    private ClienteRepository clienteRepository;

    public Optional<Cliente> obtenerRegistroById(Integer id) {
        Optional<Cliente> respuesta = this.findById(id);
        return respuesta;
    }

}
