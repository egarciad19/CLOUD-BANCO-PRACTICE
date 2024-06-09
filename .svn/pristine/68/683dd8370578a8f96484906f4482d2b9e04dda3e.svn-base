/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dase.gestortareas.repositories;

import com.dase.gestortareas.entities.Pagos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author egarc
 */
public interface PagosRepository extends JpaRepository<Pagos, Object> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO banco.pagos (fecha_pago, monto_pago, id_prestamo, usuario_adiciono, fecha_adiciono, usuario_modifico, fecha_modifico) "
            + "VALUES (now(), :pMontoPago, :pIdPrestamo, :pUsuario, now(), NULL, NULL)", nativeQuery = true)
    void almacenarPago(@Param("pMontoPago") double pMontoPago,
            @Param("pIdPrestamo") Integer pIdPrestamo,
            @Param("pUsuario") String pUsuario);
}
