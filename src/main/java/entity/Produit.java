package entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nicolas on 16/06/14.
 */
@Entity
public class Produit {
    private Long prodId;
    private String prodNom;
    private String prodDescription;
    private String prodAuteur;
    private Integer prodNbpage;
    private Editeur prodEditeur;
    private Genre prodGenre;
    private Tva tva;
    private List<Vend> vendeurs;
    @OneToMany
    @JoinColumn(name="PRODUIT_PROD_ID")
    public List<Vend> getVendeurs() {
        return vendeurs;
    }

    public void setVendeurs(List<Vend> vendeurs) {
        this.vendeurs = vendeurs;
    }

    @OneToOne
    @JoinColumn(name = "TVA_TVA_CODE", referencedColumnName = "TVA_CODE")
    public Tva getTva() {
        return tva;
    }

    public void setTva(Tva tva) {
        this.tva = tva;
    }


    @Id
    @Column(name = "PROD_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public Long getProdId() {
        return prodId;
    }

    public void setProdId(Long prodId) {
        this.prodId = prodId;
    }

    @Basic
    @Column(name = "PROD_NOM", nullable = true, insertable = true, updatable = true)
    public String getProdNom() {
        return prodNom;
    }

    public void setProdNom(String prodNom) {
        this.prodNom = prodNom;
    }

    @Basic
    @Column(name = "PROD_DESCRIPTION", nullable = true, insertable = true, updatable = true)
    public String getProdDescription() {
        return prodDescription;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    @Basic
    @Column(name = "PROD_AUTEUR", nullable = true, insertable = true, updatable = true)
    public String getProdAuteur() {
        return prodAuteur;
    }

    public void setProdAuteur(String prodAuteur) {
        this.prodAuteur = prodAuteur;
    }

    @Basic
    @Column(name = "PROD_NBPAGE", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getProdNbpage() {
        return prodNbpage;
    }

    public void setProdNbpage(Integer prodNbpage) {
        this.prodNbpage = prodNbpage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produit produit = (Produit) o;

        if (prodAuteur != null ? !prodAuteur.equals(produit.prodAuteur) : produit.prodAuteur != null) return false;
        if (prodDescription != null ? !prodDescription.equals(produit.prodDescription) : produit.prodDescription != null)
            return false;
        if (prodId != null ? !prodId.equals(produit.prodId) : produit.prodId != null) return false;
        if (prodNbpage != null ? !prodNbpage.equals(produit.prodNbpage) : produit.prodNbpage != null) return false;
        if (prodNom != null ? !prodNom.equals(produit.prodNom) : produit.prodNom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prodId != null ? prodId.hashCode() : 0;
        result = 31 * result + (prodNom != null ? prodNom.hashCode() : 0);
        result = 31 * result + (prodDescription != null ? prodDescription.hashCode() : 0);
        result = 31 * result + (prodAuteur != null ? prodAuteur.hashCode() : 0);
        result = 31 * result + (prodNbpage != null ? prodNbpage.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "PROD_IDEDITEUR", referencedColumnName = "EDIT_ID")
    public Editeur getProdEditeur() {
        return prodEditeur;
    }

    public void setProdEditeur(Editeur editeurByProdIdediteur) {
        this.prodEditeur = editeurByProdIdediteur;
    }

    @ManyToOne
    @JoinColumn(name = "PROD_IDGENRE", referencedColumnName = "GENRE_ID")
    public Genre getProdGenre() {
        return prodGenre;
    }

    public void setProdGenre(Genre genreByProdIdgenre) {
        this.prodGenre = genreByProdIdgenre;
    }
}
