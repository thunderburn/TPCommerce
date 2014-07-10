package entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

/**
 * Created by nicolas on 16/06/14.
 */
@Entity
public class Etatcommande {
    private BigInteger etacomId;
    private Timestamp etacomDatedebut;
    private Timestamp etacomDatefin;
    private Commande commandeByCommandeCommandeNumero;
    private Etat etatByEtatEtatId;

    @Id
    @Column(name = "ETACOM_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigInteger getEtacomId() {
        return etacomId;
    }

    public void setEtacomId(BigInteger etacomId) {
        this.etacomId = etacomId;
    }

    @Basic
    @Column(name = "ETACOM_DATEDEBUT", nullable = true, insertable = true, updatable = true)
    public Timestamp getEtacomDatedebut() {
        return etacomDatedebut;
    }

    public void setEtacomDatedebut(Timestamp etacomDatedebut) {
        this.etacomDatedebut = etacomDatedebut;
    }

    @Basic
    @Column(name = "ETACOM_DATEFIN", nullable = true, insertable = true, updatable = true)
    public Timestamp getEtacomDatefin() {
        return etacomDatefin;
    }

    public void setEtacomDatefin(Timestamp etacomDatefin) {
        this.etacomDatefin = etacomDatefin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Etatcommande that = (Etatcommande) o;

        if (etacomDatedebut != null ? !etacomDatedebut.equals(that.etacomDatedebut) : that.etacomDatedebut != null)
            return false;
        if (etacomDatefin != null ? !etacomDatefin.equals(that.etacomDatefin) : that.etacomDatefin != null)
            return false;
        if (etacomId != null ? !etacomId.equals(that.etacomId) : that.etacomId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = etacomId != null ? etacomId.hashCode() : 0;
        result = 31 * result + (etacomDatedebut != null ? etacomDatedebut.hashCode() : 0);
        result = 31 * result + (etacomDatefin != null ? etacomDatefin.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "COMMANDE_COMMANDE_NUMERO", referencedColumnName = "COMMANDE_ID", nullable = false)
    public Commande getCommandeByCommandeCommandeNumero() {
        return commandeByCommandeCommandeNumero;
    }

    public void setCommandeByCommandeCommandeNumero(Commande commandeByCommandeCommandeNumero) {
        this.commandeByCommandeCommandeNumero = commandeByCommandeCommandeNumero;
    }

    @ManyToOne
    @JoinColumn(name = "ETAT_ETAT_ID", referencedColumnName = "ETAT_ID", nullable = false)
    public Etat getEtatByEtatEtatId() {
        return etatByEtatEtatId;
    }

    public void setEtatByEtatEtatId(Etat etatByEtatEtatId) {
        this.etatByEtatEtatId = etatByEtatEtatId;
    }
}
