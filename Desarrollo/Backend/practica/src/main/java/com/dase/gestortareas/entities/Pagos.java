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
@Table(name = "pagos", catalog = "postgres", schema = "banco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagos.findAll", query = "SELECT p FROM Pagos p"),
    @NamedQuery(name = "Pagos.findByCodigoPago", query = "SELECT p FROM Pagos p WHERE p.codigoPago = :codigoPago"),
    @NamedQuery(name = "Pagos.findByFechaPago", query = "SELECT p FROM Pagos p WHERE p.fechaPago = :fechaPago"),
    @NamedQuery(name = "Pagos.findByMontoPago", query = "SELECT p FROM Pagos p WHERE p.montoPago = :montoPago"),
    @NamedQuery(name = "Pagos.findByUsuarioAdiciono", query = "SELECT p FROM Pagos p WHERE p.usuarioAdiciono = :usuarioAdiciono"),
    @NamedQuery(name = "Pagos.findByFechaAdiciono", query = "SELECT p FROM Pagos p WHERE p.fechaAdiciono = :fechaAdiciono"),
    @NamedQuery(name = "Pagos.findByUsuarioModifico", query = "SELECT p FROM Pagos p WHERE p.usuarioModifico = :usuarioModifico"),
    @NamedQuery(name = "Pagos.findByFechaModifico", query = "SELECT p FROM Pagos p WHERE p.fechaModifico = :fechaModifico")})
public class Pagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_pago", nullable = false)
    private Integer codigoPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_pago", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_pago", nullable = false, precision = 10, scale = 2)
    private BigDecimal montoPago;
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
    @JoinColumn(name = "id_prestamo", referencedColumnName = "id_prestamo", nullable = false)
    @ManyToOne(optional = false)
    private Prestamo idPrestamo;

    public Pagos() {
    }

    public Pagos(Integer codigoPago) {
        this.codigoPago = codigoPago;
    }

    public Pagos(Integer codigoPago, Date fechaPago, BigDecimal montoPago) {
        this.codigoPago = codigoPago;
        this.fechaPago = fechaPago;
        this.montoPago = montoPago;
    }

    public Integer getCodigoPago() {
        return codigoPago;
    }

    public void setCodigoPago(Integer codigoPago) {
        this.codigoPago = codigoPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public BigDecimal getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(BigDecimal montoPago) {
        this.montoPago = montoPago;
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

    public Prestamo getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Prestamo idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPago != null ? codigoPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.codigoPago == null && other.codigoPago != null) || (this.codigoPago != null && !this.codigoPago.equals(other.codigoPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dase.gestortareas.entities.Pagos[ codigoPago=" + codigoPago + " ]";
    }
    
}
