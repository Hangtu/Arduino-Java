/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Hangtu
 */
@Entity
@Table(name = "padres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Padres.findAll", query = "SELECT p FROM Padres p"),
    @NamedQuery(name = "Padres.findByIdPadres", query = "SELECT p FROM Padres p WHERE p.idPadres = :idPadres"),
    @NamedQuery(name = "Padres.findByNombre", query = "SELECT p FROM Padres p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Padres.findByEdad", query = "SELECT p FROM Padres p WHERE p.edad = :edad"),
    @NamedQuery(name = "Padres.findByTelefono", query = "SELECT p FROM Padres p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Padres.findByFecha", query = "SELECT p FROM Padres p WHERE p.fecha = :fecha")})
public class Padres implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPadres")
    private Integer idPadres;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "padres")
    private Collection<Hijos> hijosCollection;

    public Padres() {
    }

    public Padres(Integer idPadres) {
        this.idPadres = idPadres;
    }

    public Padres(Integer idPadres, String nombre) {
        this.idPadres = idPadres;
        this.nombre = nombre;
    }

    public Integer getIdPadres() {
        return idPadres;
    }

    public void setIdPadres(Integer idPadres) {
        this.idPadres = idPadres;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public Collection<Hijos> getHijosCollection() {
        return hijosCollection;
    }

    public void setHijosCollection(Collection<Hijos> hijosCollection) {
        this.hijosCollection = hijosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPadres != null ? idPadres.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Padres)) {
            return false;
        }
        Padres other = (Padres) object;
        if ((this.idPadres == null && other.idPadres != null) || (this.idPadres != null && !this.idPadres.equals(other.idPadres))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.Padres[ idPadres=" + idPadres + " ]";
    }
    
}
