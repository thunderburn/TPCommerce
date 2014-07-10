package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by nicolas on 16/06/14.
 */
@Entity
public class Tva {
    private BigInteger tvaCode;
    private BigDecimal tvaTaux;
    private String tvaDatedebut;
    private String tvaDatefin;

    @Id
    @Column(name = "TVA_CODE", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigInteger getTvaCode() {
        return tvaCode;
    }

    public void setTvaCode(BigInteger tvaCode) {
        this.tvaCode = tvaCode;
    }

    @Basic
    @Column(name = "TVA_TAUX", nullable = false, insertable = true, updatable = true, precision = 2)
    public BigDecimal getTvaTaux() {
        return tvaTaux;
    }

    public void setTvaTaux(BigDecimal tvaTaux) {
        this.tvaTaux = tvaTaux;
    }

    @Basic
    @Column(name = "TVA_DATEDEBUT", nullable = true, insertable = true, updatable = true)
    public String getTvaDatedebut() {
        return tvaDatedebut;
    }

    public void setTvaDatedebut(String tvaDatedebut) {
        this.tvaDatedebut = tvaDatedebut;
    }

    @Basic
    @Column(name = "TVA_DATEFIN", nullable = true, insertable = true, updatable = true)
    public String getTvaDatefin() {
        return tvaDatefin;
    }

    public void setTvaDatefin(String tvaDatefin) {
        this.tvaDatefin = tvaDatefin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tva tva = (Tva) o;

        if (tvaCode != null ? !tvaCode.equals(tva.tvaCode) : tva.tvaCode != null) return false;
        if (tvaDatedebut != null ? !tvaDatedebut.equals(tva.tvaDatedebut) : tva.tvaDatedebut != null) return false;
        if (tvaDatefin != null ? !tvaDatefin.equals(tva.tvaDatefin) : tva.tvaDatefin != null) return false;
        if (tvaTaux != null ? !tvaTaux.equals(tva.tvaTaux) : tva.tvaTaux != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tvaCode != null ? tvaCode.hashCode() : 0;
        result = 31 * result + (tvaTaux != null ? tvaTaux.hashCode() : 0);
        result = 31 * result + (tvaDatedebut != null ? tvaDatedebut.hashCode() : 0);
        result = 31 * result + (tvaDatefin != null ? tvaDatefin.hashCode() : 0);
        return result;
    }
}
