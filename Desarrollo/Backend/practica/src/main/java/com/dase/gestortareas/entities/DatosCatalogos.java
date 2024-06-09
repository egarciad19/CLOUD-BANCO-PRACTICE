/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dase.gestortareas.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "datos_catalogos", catalog = "postgres", schema = "banco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DatosCatalogos.findAll", query = "SELECT d FROM DatosCatalogos d"),
    @NamedQuery(name = "DatosCatalogos.findByCodigoDatoCatalogo", query = "SELECT d FROM DatosCatalogos d WHERE d.codigoDatoCatalogo = :codigoDatoCatalogo"),
    @NamedQuery(name = "DatosCatalogos.findByNombre", query = "SELECT d FROM DatosCatalogos d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DatosCatalogos.findByDescripcion", query = "SELECT d FROM DatosCatalogos d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "DatosCatalogos.findByFechaCreacion", query = "SELECT d FROM DatosCatalogos d WHERE d.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "DatosCatalogos.findByUsuarioCreacion", query = "SELECT d FROM DatosCatalogos d WHERE d.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "DatosCatalogos.findByIpUsuarioCreacion", query = "SELECT d FROM DatosCatalogos d WHERE d.ipUsuarioCreacion = :ipUsuarioCreacion"),
    @NamedQuery(name = "DatosCatalogos.findByFechaModificacion", query = "SELECT d FROM DatosCatalogos d WHERE d.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "DatosCatalogos.findByUsuarioModificacion", query = "SELECT d FROM DatosCatalogos d WHERE d.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "DatosCatalogos.findByIpUsuarioModificacion", query = "SELECT d FROM DatosCatalogos d WHERE d.ipUsuarioModificacion = :ipUsuarioModificacion")})
public class DatosCatalogos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_dato_catalogo", nullable = false)
    private Integer codigoDatoCatalogo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "nombre", nullable = false, length = 250)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "descripcion", nullable = false, length = 250)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "usuario_creacion", nullable = false, length = 50)
    private String usuarioCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ip_usuario_creacion", nullable = false, length = 20)
    private String ipUsuarioCreacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Size(max = 50)
    @Column(name = "usuario_modificacion", length = 50)
    private String usuarioModificacion;
    @Size(max = 20)
    @Column(name = "ip_usuario_modificacion", length = 20)
    private String ipUsuarioModificacion;

    public DatosCatalogos() {
    }

    public DatosCatalogos(Integer codigoDatoCatalogo) {
        this.codigoDatoCatalogo = codigoDatoCatalogo;
    }

    public DatosCatalogos(Integer codigoDatoCatalogo, String nombre, String descripcion, Date fechaCreacion, String usuarioCreacion, String ipUsuarioCreacion) {
        this.codigoDatoCatalogo = codigoDatoCatalogo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.usuarioCreacion = usuarioCreacion;
        this.ipUsuarioCreacion = ipUsuarioCreacion;
    }

    public Integer getCodigoDatoCatalogo() {
        return codigoDatoCatalogo;
    }

    public void setCodigoDatoCatalogo(Integer codigoDatoCatalogo) {
        this.codigoDatoCatalogo = codigoDatoCatalogo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getIpUsuarioCreacion() {
        return ipUsuarioCreacion;
    }

    public void setIpUsuarioCreacion(String ipUsuarioCreacion) {
        this.ipUsuarioCreacion = ipUsuarioCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public String getIpUsuarioModificacion() {
        return ipUsuarioModificacion;
    }

    public void setIpUsuarioModificacion(String ipUsuarioModificacion) {
        this.ipUsuarioModificacion = ipUsuarioModificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDatoCatalogo != null ? codigoDatoCatalogo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosCatalogos)) {
            return false;
        }
        DatosCatalogos other = (DatosCatalogos) object;
        if ((this.codigoDatoCatalogo == null && other.codigoDatoCatalogo != null) || (this.codigoDatoCatalogo != null && !this.codigoDatoCatalogo.equals(other.codigoDatoCatalogo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dase.gestortareas.entities.DatosCatalogos[ codigoDatoCatalogo=" + codigoDatoCatalogo + " ]";
    }
    
}
