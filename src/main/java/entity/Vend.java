package entity;

import javax.persistence.*;

/**
 * Created by nicolas on 16/06/14.
 */
@Entity
public class Vend {
    private long vendId;
    private int vendPrix;
    private String vendDate;
    private Produit produit;
    private Vendeur vendeur;
    @OneToOne
    @JoinColumn(name = "VEND_ID", referencedColumnName = "VEND_ID")
    public Vendeur getVendeur() {
        return vendeur;
    }
    public void setVendeur(Vendeur vendeur) {
        this.vendeur = vendeur;
    }

    @Id
    @Column(name = "VEND_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public long getVendId() {
        return vendId;
    }

    public void setVendId(long vendId) {
        this.vendId = vendId;
    }

    @Basic
    @Column(name = "VEND_PRIX", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getVendPrix() {
        return vendPrix;
    }

    public void setVendPrix(int vendPrix) {
        this.vendPrix = vendPrix;
    }

    @Basic
    @Column(name = "VEND_DATE", nullable = true, insertable = true, updatable = true)
    public String getVendDate() {
        return vendDate;
    }

    public void setVendDate(String vendDate) {
        this.vendDate = vendDate;
    }

    @ManyToOne
    @JoinColumn(name = "PRODUIT_PROD_ID", referencedColumnName = "PROD_ID", nullable = false)
    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produitByProduitProdId) {
        this.produit = produitByProduitProdId;
    }
}
