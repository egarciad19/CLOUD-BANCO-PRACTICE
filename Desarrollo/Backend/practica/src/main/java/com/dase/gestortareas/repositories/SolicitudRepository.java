/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dase.gestortareas.repositories;

import com.dase.gestortareas.entities.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author egarc
 */
public interface SolicitudRepository extends JpaRepository<Solicitud, Object> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE banco.solicitud\n"
            + "SET usuario_modifico= :pUsuario, \n"
            + "fecha_modifico= now(),\n"
            + "estado= :pEstado\n"
            + "WHERE no_solicitud= :pNoSolicitud ", nativeQuery = true)
    void actualizarEstado(@Param("pUsuario") String pUsuario,
            @Param("pEstado") Integer pEstado,
            @Param("pNoSolicitud") Integer pNoSolicitud);
}
