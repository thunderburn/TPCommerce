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
public class Typeadresse {
    private BigInteger adrtypeId;
    private String adrtypeLibelle;

    @Id
    @Column(name = "ADRTYPE_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigInteger getAdrtypeId() {
        return adrtypeId;
    }

    public void setAdrtypeId(BigInteger adrtypeId) {
        this.adrtypeId = adrtypeId;
    }

    @Basic
    @Column(name = "ADRTYPE_LIBELLE", nullable = true, insertable = true, updatable = true)
    public String getAdrtypeLibelle() {
        return adrtypeLibelle;
    }

    public void setAdrtypeLibelle(String adrtypeLibelle) {
        this.adrtypeLibelle = adrtypeLibelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Typeadresse that = (Typeadresse) o;

        if (adrtypeId != null ? !adrtypeId.equals(that.adrtypeId) : that.adrtypeId != null) return false;
        if (adrtypeLibelle != null ? !adrtypeLibelle.equals(that.adrtypeLibelle) : that.adrtypeLibelle != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adrtypeId != null ? adrtypeId.hashCode() : 0;
        result = 31 * result + (adrtypeLibelle != null ? adrtypeLibelle.hashCode() : 0);
        return result;
    }
}
