/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Hangtu
 */
@Embeddable
public class HijosPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idHijos")
    private int idHijos;
    @Basic(optional = false)
    @Column(name = "Padres_idPadres")
    private int padresidPadres;

    public HijosPK() {
    }

    public HijosPK(int idHijos, int padresidPadres) {
        this.idHijos = idHijos;
        this.padresidPadres = padresidPadres;
    }

    public int getIdHijos() {
        return idHijos;
    }

    public void setIdHijos(int idHijos) {
        this.idHijos = idHijos;
    }

    public int getPadresidPadres() {
        return padresidPadres;
    }

    public void setPadresidPadres(int padresidPadres) {
        this.padresidPadres = padresidPadres;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idHijos;
        hash += (int) padresidPadres;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HijosPK)) {
            return false;
        }
        HijosPK other = (HijosPK) object;
        if (this.idHijos != other.idHijos) {
            return false;
        }
        if (this.padresidPadres != other.padresidPadres) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "persistence.HijosPK[ idHijos=" + idHijos + ", padresidPadres=" + padresidPadres + " ]";
    }
    
}
