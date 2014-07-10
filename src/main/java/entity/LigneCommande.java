package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by nicolas on 16/06/14.
 */
@Entity
@Table(name = "LIGNE_COMMANDE", schema = "TPECOMMERCE", catalog = "")
public class LigneCommande {
    private BigInteger licmdId;
    private BigInteger licmdQuantite;
    private BigDecimal licmdPrixHt;
    private BigDecimal licmdTvaTaux;
    private Vend licmdVend;


    @OneToOne
    @JoinColumn(name = "LICMD_PROD_ID", referencedColumnName = "VEND_ID")
    public Vend getLicmdVend() {
        return licmdVend;
    }

    public void setLicmdVend(Vend licmdVend) {
        this.licmdVend = licmdVend;
    }



    @Id
    @Column(name = "LICMD_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigInteger getLicmdId() {
        return licmdId;
    }

    public void setLicmdId(BigInteger licmdId) {
        this.licmdId = licmdId;
    }

    @Basic
    @Column(name = "LICMD_QUANTITE", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigInteger getLicmdQuantite() {
        return licmdQuantite;
    }

    public void setLicmdQuantite(BigInteger licmdQuantite) {
        this.licmdQuantite = licmdQuantite;
    }

    @Basic
    @Column(name = "LICMD_PRIX_HT", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getLicmdPrixHt() {
        return licmdPrixHt;
    }

    public void setLicmdPrixHt(BigDecimal licmdPrixHt) {
        this.licmdPrixHt = licmdPrixHt;
    }

    @Basic
    @Column(name = "LICMD_TVA_TAUX", nullable = true, insertable = true, updatable = true, precision = 2)
    public BigDecimal getLicmdTvaTaux() {
        return licmdTvaTaux;
    }

    public void setLicmdTvaTaux(BigDecimal licmdTvaTaux) {
        this.licmdTvaTaux = licmdTvaTaux;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LigneCommande that = (LigneCommande) o;

        if (licmdId != null ? !licmdId.equals(that.licmdId) : that.licmdId != null) return false;
        if (licmdPrixHt != null ? !licmdPrixHt.equals(that.licmdPrixHt) : that.licmdPrixHt != null) return false;
        if (licmdQuantite != null ? !licmdQuantite.equals(that.licmdQuantite) : that.licmdQuantite != null)
            return false;
        if (licmdTvaTaux != null ? !licmdTvaTaux.equals(that.licmdTvaTaux) : that.licmdTvaTaux != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = licmdId != null ? licmdId.hashCode() : 0;
        result = 31 * result + (licmdQuantite != null ? licmdQuantite.hashCode() : 0);
        result = 31 * result + (licmdPrixHt != null ? licmdPrixHt.hashCode() : 0);
        result = 31 * result + (licmdTvaTaux != null ? licmdTvaTaux.hashCode() : 0);
        return result;
    }
}
