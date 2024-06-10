/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dase.gestortareas.repositories;

import com.dase.gestortareas.entities.Prestamo;
import com.dase.gestortareas.projection.PagosProjection;
import com.dase.gestortareas.projection.PrestamosProjection;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author egarc
 */
public interface PrestamosRepository extends JpaRepository<Prestamo, Object> {

    @Query(value = "select \n"
            + "p.id_prestamo as idPrestamo,\n"
            + "c.numero_identificacion as noIdentificacion,\n"
            + "p.monto_aprobado as montoAprobado,\n"
            + "p.fecha_aprobacion as fechaAprobacion,\n"
            + "p.cantidad_meses_plazo as cantidadMeses,\n"
            + "p.saldo_pendiente as saldoPendiente, \n"
            + "dc.nombre as nombreEstado\n"
            + "from banco.prestamo p \n"
            + "inner join banco.datos_catalogos dc on dc.codigo_dato_catalogo = p.estado \n"
            + "inner join banco.cliente c on c.numero_identificacion = ?1\n"
            + "inner join banco.solicitud s on s.id_cliente = c.id_cliente \n"
            + "where p.id_cliente = c.id_cliente  and p.no_solicitud = s.no_solicitud and s.estado = 4",
            nativeQuery = true)
    public List<PrestamosProjection> obtenerPrestamos(String noIdentificacion);
}
