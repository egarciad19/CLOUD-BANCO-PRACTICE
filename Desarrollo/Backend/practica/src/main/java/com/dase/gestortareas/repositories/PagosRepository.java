/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dase.gestortareas.repositories;

import com.dase.gestortareas.entities.Pagos;
import com.dase.gestortareas.projection.PagosProjection;
import java.util.List;
import java.util.Optional;
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
    
        @Query(value = "SELECT \n"
            + "    codigo_pago AS codigoPago, \n"
            + "    fecha_pago AS fechaPago, \n"
            + "    monto_pago AS montoPago, \n"
            + "    id_prestamo AS idPrestamo, \n"
            + "    usuario_adiciono AS usuarioAdiciono, \n"
            + "    fecha_adiciono AS fechaAdiciono, \n"
            + "    usuario_modifico AS usuarioModifico, \n"
            + "    fecha_modifico AS fechaModifico\n"
            + "FROM banco.pagos where id_prestamo = ?1",
            nativeQuery = true)
    public List<PagosProjection> findByIdPrestamo1(Integer idPrestamo);
}
