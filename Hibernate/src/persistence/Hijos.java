/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hangtu
 */
@Entity
@Table(name = "hijos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hijos.findAll", query = "SELECT h FROM Hijos h"),
    @NamedQuery(name = "Hijos.findByIdHijos", query = "SELECT h FROM Hijos h WHERE h.hijosPK.idHijos = :idHijos"),
    @NamedQuery(name = "Hijos.findByNombre", query = "SELECT h FROM Hijos h WHERE h.nombre = :nombre"),
    @NamedQuery(name = "Hijos.findByEdad", query = "SELECT h FROM Hijos h WHERE h.edad = :edad"),
    @NamedQuery(name = "Hijos.findByNumero", query = "SELECT h FROM Hijos h WHERE h.numero = :numero"),
    @NamedQuery(name = "Hijos.findByPadresidPadres", query = "SELECT h FROM Hijos h WHERE h.hijosPK.padresidPadres = :padresidPadres")})
public class Hijos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HijosPK hijosPK;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "edad")
    private String edad;
    @Column(name = "numero")
    private String numero;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @JoinColumn(name = "Padres_idPadres", referencedColumnName = "idPadres", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Padres padres;

    public Hijos() {
    }

    public Hijos(HijosPK hijosPK) {
        this.hijosPK = hijosPK;
    }

    public Hijos(HijosPK hijosPK, String nombre) {
        this.hijosPK = hijosPK;
        this.nombre = nombre;
    }

    public Hijos(int idHijos, int padresidPadres) {
        this.hijosPK = new HijosPK(idHijos, padresidPadres);
    }

    public HijosPK getHijosPK() {
        return hijosPK;
    }

    public void setHijosPK(HijosPK hijosPK) {
        this.hijosPK = hijosPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Padres getPadres() {
        return padres;
    }

    public void setPadres(Padres padres) {
        this.padres = padres;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hijosPK != null ? hijosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hijos)) {
            return false;
        }
        Hijos other = (Hijos) object;
        if ((this.hijosPK == null && other.hijosPK != null) || (this.hijosPK != null && !this.hijosPK.equals(other.hijosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.Hijos[ hijosPK=" + hijosPK + " ]";
    }
    
}
