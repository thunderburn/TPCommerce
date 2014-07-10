package entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nicolas on 16/06/14.
 */
@Entity
public class Commande {
    private String commandeDate;
    private long commandeId;
    private int commandeNumero;
    private Cb cbByCbCbId;
    private Client clientByClientCliId;
    private List<LigneCommande> ligneCommandes;
    @OneToMany
    @JoinColumn(name = "LICMD_ID", referencedColumnName = "COMMANDE_ID")
    public List<LigneCommande> getLigneCommandes() {
        return ligneCommandes;
    }

    public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
        this.ligneCommandes = ligneCommandes;
    }

    @Basic
    @Column(name = "COMMANDE_DATE", nullable = true, insertable = true, updatable = true)
    public String getCommandeDate() {
        return commandeDate;
    }

    public void setCommandeDate(String commandeDate) {
        this.commandeDate = commandeDate;
    }

    @Id
    @Column(name = "COMMANDE_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public Long getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(Long commandeId) {
        this.commandeId = commandeId;
    }

    @Basic
    @Column(name = "COMMANDE_NUMERO", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getCommandeNumero() {
        return commandeNumero;
    }

    public void setCommandeNumero(int commandeNumero) {
        this.commandeNumero = commandeNumero;
    }


    @ManyToOne
    @JoinColumn(name = "CB_CB_ID", referencedColumnName = "CB_ID", nullable = false)
    public Cb getCbByCbCbId() {
        return cbByCbCbId;
    }

    public void setCbByCbCbId(Cb cbByCbCbId) {
        this.cbByCbCbId = cbByCbCbId;
    }

    @ManyToOne
    @JoinColumn(name = "CLIENT_CLI_ID", referencedColumnName = "CLI_ID", nullable = false)
    public Client getClientByClientCliId() {
        return clientByClientCliId;
    }

    public void setClientByClientCliId(Client clientByClientCliId) {
        this.clientByClientCliId = clientByClientCliId;
    }
}
