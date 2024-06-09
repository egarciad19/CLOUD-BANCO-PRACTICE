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
@Table(name = "solicitud", catalog = "postgres", schema = "banco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s"),
    @NamedQuery(name = "Solicitud.findByNoSolicitud", query = "SELECT s FROM Solicitud s WHERE s.noSolicitud = :noSolicitud"),
    @NamedQuery(name = "Solicitud.findByMontoPrestamo", query = "SELECT s FROM Solicitud s WHERE s.montoPrestamo = :montoPrestamo"),
    @NamedQuery(name = "Solicitud.findByCantidadMeses", query = "SELECT s FROM Solicitud s WHERE s.cantidadMeses = :cantidadMeses"),
    @NamedQuery(name = "Solicitud.findByTasaInteres", query = "SELECT s FROM Solicitud s WHERE s.tasaInteres = :tasaInteres"),
    @NamedQuery(name = "Solicitud.findByUsuarioAdiciono", query = "SELECT s FROM Solicitud s WHERE s.usuarioAdiciono = :usuarioAdiciono"),
    @NamedQuery(name = "Solicitud.findByFechaAdiciono", query = "SELECT s FROM Solicitud s WHERE s.fechaAdiciono = :fechaAdiciono"),
    @NamedQuery(name = "Solicitud.findByUsuarioModifico", query = "SELECT s FROM Solicitud s WHERE s.usuarioModifico = :usuarioModifico"),
    @NamedQuery(name = "Solicitud.findByFechaModifico", query = "SELECT s FROM Solicitud s WHERE s.fechaModifico = :fechaModifico"),
    @NamedQuery(name = "Solicitud.findByEstado", query = "SELECT s FROM Solicitud s WHERE s.estado = :estado")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "no_solicitud", nullable = false)
    private Integer noSolicitud;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_prestamo", nullable = false, precision = 10, scale = 2)
    private BigDecimal montoPrestamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad_meses", nullable = false)
    private int cantidadMeses;
    @Size(max = 25)
    @Column(name = "tasa_interes", length = 25)
    private String tasaInteres;
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

    public Solicitud() {
    }

    public Solicitud(Integer noSolicitud) {
        this.noSolicitud = noSolicitud;
    }

    public Solicitud(Integer noSolicitud, BigDecimal montoPrestamo, int cantidadMeses, int estado) {
        this.noSolicitud = noSolicitud;
        this.montoPrestamo = montoPrestamo;
        this.cantidadMeses = cantidadMeses;
        this.estado = estado;
    }

    public Integer getNoSolicitud() {
        return noSolicitud;
    }

    public void setNoSolicitud(Integer noSolicitud) {
        this.noSolicitud = noSolicitud;
    }

    public BigDecimal getMontoPrestamo() {
        return montoPrestamo;
    }

    public void setMontoPrestamo(BigDecimal montoPrestamo) {
        this.montoPrestamo = montoPrestamo;
    }

    public int getCantidadMeses() {
        return cantidadMeses;
    }

    public void setCantidadMeses(int cantidadMeses) {
        this.cantidadMeses = cantidadMeses;
    }

    public String getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(String tasaInteres) {
        this.tasaInteres = tasaInteres;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noSolicitud != null ? noSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.noSolicitud == null && other.noSolicitud != null) || (this.noSolicitud != null && !this.noSolicitud.equals(other.noSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dase.gestortareas.entities.Solicitud[ noSolicitud=" + noSolicitud + " ]";
    }
    
}
