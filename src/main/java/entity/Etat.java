package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

/**
 * Created by nicolas on 16/06/14.
 */
@Entity
public class Etat {
    private BigInteger etatId;
    private String etatLibelle;

    @Id
    @Column(name = "ETAT_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigInteger getEtatId() {
        return etatId;
    }

    public void setEtatId(BigInteger etatId) {
        this.etatId = etatId;
    }

    @Basic
    @Column(name = "ETAT_LIBELLE", nullable = true, insertable = true, updatable = true)
    public String getEtatLibelle() {
        return etatLibelle;
    }

    public void setEtatLibelle(String etatLibelle) {
        this.etatLibelle = etatLibelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Etat etat = (Etat) o;

        if (etatId != null ? !etatId.equals(etat.etatId) : etat.etatId != null) return false;
        if (etatLibelle != null ? !etatLibelle.equals(etat.etatLibelle) : etat.etatLibelle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = etatId != null ? etatId.hashCode() : 0;
        result = 31 * result + (etatLibelle != null ? etatLibelle.hashCode() : 0);
        return result;
    }
}
