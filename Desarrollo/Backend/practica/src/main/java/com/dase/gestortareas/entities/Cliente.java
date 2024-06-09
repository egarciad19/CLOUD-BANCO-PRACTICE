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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "cliente", catalog = "postgres", schema = "banco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cliente.findByApellido", query = "SELECT c FROM Cliente c WHERE c.apellido = :apellido"),
    @NamedQuery(name = "Cliente.findByNumeroIdentificacion", query = "SELECT c FROM Cliente c WHERE c.numeroIdentificacion = :numeroIdentificacion"),
    @NamedQuery(name = "Cliente.findByFechaNacimiento", query = "SELECT c FROM Cliente c WHERE c.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Cliente.findByCorreoElectronico", query = "SELECT c FROM Cliente c WHERE c.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Cliente.findByUsuarioAdiciono", query = "SELECT c FROM Cliente c WHERE c.usuarioAdiciono = :usuarioAdiciono"),
    @NamedQuery(name = "Cliente.findByFechaAdiciono", query = "SELECT c FROM Cliente c WHERE c.fechaAdiciono = :fechaAdiciono"),
    @NamedQuery(name = "Cliente.findByUsuarioModifico", query = "SELECT c FROM Cliente c WHERE c.usuarioModifico = :usuarioModifico"),
    @NamedQuery(name = "Cliente.findByFechaModifico", query = "SELECT c FROM Cliente c WHERE c.fechaModifico = :fechaModifico")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Integer idCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "numero_identificacion")
    private String numeroIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Size(max = 100)
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Size(max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 20)
    @Column(name = "usuario_adiciono")
    private String usuarioAdiciono;
    @Column(name = "fecha_adiciono")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAdiciono;
    @Size(max = 20)
    @Column(name = "usuario_modifico")
    private String usuarioModifico;
    @Column(name = "fecha_modifico")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModifico;
    @Column(name = "estado", nullable = false)
    private Integer estado;
    @Size(min = 1, max = 100)
    @Column(name = "direccion")
    private String direccion;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String nombre, String apellido, String numeroIdentificacion, Date fechaNacimiento, Integer estado) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroIdentificacion = numeroIdentificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dase.gestortareas.entities.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
