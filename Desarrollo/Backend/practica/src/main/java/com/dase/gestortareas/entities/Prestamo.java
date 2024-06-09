/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dase.gestortareas.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author egarc
 */
@Entity
@Table(name = "prestamo", catalog = "postgres", schema = "banco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p"),
    @NamedQuery(name = "Prestamo.findByIdPrestamo", query = "SELECT p FROM Prestamo p WHERE p.idPrestamo = :idPrestamo"),
    @NamedQuery(name = "Prestamo.findByMontoAprobado", query = "SELECT p FROM Prestamo p WHERE p.montoAprobado = :montoAprobado"),
    @NamedQuery(name = "Prestamo.findByFechaAprobacion", query = "SELECT p FROM Prestamo p WHERE p.fechaAprobacion = :fechaAprobacion"),
    @NamedQuery(name = "Prestamo.findByCantidadMesesPlazo", query = "SELECT p FROM Prestamo p WHERE p.cantidadMesesPlazo = :cantidadMesesPlazo"),
    @NamedQuery(name = "Prestamo.findBySaldoPendiente", query = "SELECT p FROM Prestamo p WHERE p.saldoPendiente = :saldoPendiente"),
    @NamedQuery(name = "Prestamo.findByUsuarioAdiciono", query = "SELECT p FROM Prestamo p WHERE p.usuarioAdiciono = :usuarioAdiciono"),
    @NamedQuery(name = "Prestamo.findByFechaAdiciono", query = "SELECT p FROM Prestamo p WHERE p.fechaAdiciono = :fechaAdiciono"),
    @NamedQuery(name = "Prestamo.findByUsuarioModifico", query = "SELECT p FROM Prestamo p WHERE p.usuarioModifico = :usuarioModifico"),
    @NamedQuery(name = "Prestamo.findByFechaModifico", query = "SELECT p FROM Prestamo p WHERE p.fechaModifico = :fechaModifico"),
    @NamedQuery(name = "Prestamo.findByEstado", query = "SELECT p FROM Prestamo p WHERE p.estado = :estado")})
public class Prestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prestamo", nullable = false)
    private Integer idPrestamo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_aprobado", nullable = false, precision = 10, scale = 2)
    private BigDecimal montoAprobado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_aprobacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaAprobacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_meses_plazo", nullable = false)
    private int cantidadMesesPlazo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saldo_pendiente", nullable = false, precision = 10, scale = 2)
    private BigDecimal saldoPendiente;
    @Size(max = 20)
    @Column(name = "usuario_adiciono", length = 20)
    private String usuarioAdiciono;
    @Column(name = "fecha_adiciono")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAdiciono;
    @Size(max = 20)
    @Column(name = "usuario_modifico", length = 20)
    private String usuarioModifico;
    @Column(name = "fecha_modifico")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModifico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private int estado;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", nullable = false)
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "no_solicitud", referencedColumnName = "no_solicitud", nullable = false)
    @ManyToOne(optional = false)
    private Solicitud noSolicitud;

    public Prestamo() {
    }

    public Prestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Prestamo(Integer idPrestamo, BigDecimal montoAprobado, Date fechaAprobacion, int cantidadMesesPlazo, BigDecimal saldoPendiente, int estado) {
        this.idPrestamo = idPrestamo;
        this.montoAprobado = montoAprobado;
        this.fechaAprobacion = fechaAprobacion;
        this.cantidadMesesPlazo = cantidadMesesPlazo;
        this.saldoPendiente = saldoPendiente;
        this.estado = estado;
    }

    public Integer getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Integer idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public BigDecimal getMontoAprobado() {
        return montoAprobado;
    }

    public void setMontoAprobado(BigDecimal montoAprobado) {
        this.montoAprobado = montoAprobado;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public int getCantidadMesesPlazo() {
        return cantidadMesesPlazo;
    }

    public void setCantidadMesesPlazo(int cantidadMesesPlazo) {
        this.cantidadMesesPlazo = cantidadMesesPlazo;
    }

    public BigDecimal getSaldoPendiente() {
        return saldoPendiente;
    }

    public void setSaldoPendiente(BigDecimal saldoPendiente) {
        this.saldoPendiente = saldoPendiente;
    }

    public String getUsuarioAdiciono() {
        return usuarioAdiciono;
    }

    public void setUsuarioAdiciono(String usuarioAdiciono) {
        this.usuarioAdiciono = usuarioAdiciono;
    }

    public Date getFechaAdiciono() {
        return fechaAdiciono;
    }

    public void setFechaAdiciono(Date fechaAdiciono) {
        this.fechaAdiciono = fechaAdiciono;
    }

    public String getUsuarioModifico() {
        return usuarioModifico;
    }

    public void setUsuarioModifico(String usuarioModifico) {
        this.usuarioModifico = usuarioModifico;
    }

    public Date getFechaModifico() {
        return fechaModifico;
    }

    public void setFechaModifico(Date fechaModifico) {
        this.fechaModifico = fechaModifico;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Solicitud getNoSolicitud() {
        return noSolicitud;
    }

    public void setNoSolicitud(Solicitud noSolicitud) {
        this.noSolicitud = noSolicitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrestamo != null ? idPrestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
        if ((this.idPrestamo == null && other.idPrestamo != null) || (this.idPrestamo != null && !this.idPrestamo.equals(other.idPrestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dase.gestortareas.entities.Prestamo[ idPrestamo=" + idPrestamo + " ]";
    }
    
}
