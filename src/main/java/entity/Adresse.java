package entity;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.math.BigInteger;

/**
 * Created by nicolas on 16/06/14.
 */
@Entity
public class Adresse {
    private BigInteger adrId;
    private String adrAdresse1;
    private String adrAdresse2;
    private int adrCp;
    private String adrVille;
    private Typeadresse type;

    @OneToOne
    @JoinColumn(name = "TYPEADRESSE_ADRTYPE_ID", referencedColumnName = "ADRTYPE_ID")
    public Typeadresse getType() {
        return type;
    }

    public void setType(Typeadresse type) {
        this.type = type;
    }




    @Id
    @Column(name = "ADR_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigInteger getAdrId() {
        return adrId;
    }

    public void setAdrId(BigInteger adrId) {
        this.adrId = adrId;
    }

    @Basic
    @Column(name = "ADR_ADRESSE1", nullable = true, insertable = true, updatable = true)
    public String getAdrAdresse1() {
        return adrAdresse1;
    }

    public void setAdrAdresse1(String adrAdresse1) {
        this.adrAdresse1 = adrAdresse1;
    }

    @Basic
    @Column(name = "ADR_ADRESSE2", nullable = true, insertable = true, updatable = true)
    public String getAdrAdresse2() {
        return adrAdresse2;
    }

    public void setAdrAdresse2(String adrAdresse2) {
        this.adrAdresse2 = adrAdresse2;
    }

    @Basic
    @Column(name = "ADR_CP", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getAdrCp() {
        return adrCp;
    }

    public void setAdrCp(int adrCp) {
        this.adrCp = adrCp;
    }

    @Basic
    @Column(name = "ADR_VILLE", nullable = true, insertable = true, updatable = true)
    public String getAdrVille() {
        return adrVille;
    }

    public void setAdrVille(String adrVille) {
        this.adrVille = adrVille;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adresse adresse = (Adresse) o;

        if (adrCp != adresse.adrCp) return false;
        if (adrAdresse1 != null ? !adrAdresse1.equals(adresse.adrAdresse1) : adresse.adrAdresse1 != null) return false;
        if (adrAdresse2 != null ? !adrAdresse2.equals(adresse.adrAdresse2) : adresse.adrAdresse2 != null) return false;
        if (adrId != null ? !adrId.equals(adresse.adrId) : adresse.adrId != null) return false;
        if (adrVille != null ? !adrVille.equals(adresse.adrVille) : adresse.adrVille != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adrId != null ? adrId.hashCode() : 0;
        result = 31 * result + (adrAdresse1 != null ? adrAdresse1.hashCode() : 0);
        result = 31 * result + (adrAdresse2 != null ? adrAdresse2.hashCode() : 0);
        result = 31 * result + adrCp;
        result = 31 * result + (adrVille != null ? adrVille.hashCode() : 0);
        return result;
    }
}
