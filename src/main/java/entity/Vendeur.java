package entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nicolas on 16/06/14.
 */
@Entity
public class Vendeur {
    private long vendId;
    private String vendNom;
    private List<Vend> vend;

    @OneToMany
    @JoinColumn(name = "VENDEUR_VEND_ID", referencedColumnName = "VEND_ID")
    public List<Notevendeur> getNotevendeurs() {
        return notevendeurs;
    }

    public void setNotevendeurs(List<Notevendeur> notevendeurs) {
        this.notevendeurs = notevendeurs;
    }

    private List<Notevendeur> notevendeurs;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="VEND_ID")
    @SequenceGenerator(name="VEND_ID", sequenceName="SEQ_VENDEUR")
    @Column(name = "VEND_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public long getVendId() {
        return vendId;
    }

    public void setVendId(long vendId) {
        this.vendId = vendId;
    }

    @Basic
    @Column(name = "VEND_NOM", nullable = true, insertable = true, updatable = true)
    public String getVendNom() {
        return vendNom;
    }

    public void setVendNom(String vendNom) {
        this.vendNom = vendNom;
    }

    @OneToMany
    @JoinColumn(name = "VENDEUR_VEND_ID", referencedColumnName = "VEND_ID")
    public List<Vend> getProduitVendeur(){ return vend;}

    public void setProduitVendeur(List<Vend> vend){ this.vend = vend;}
}
