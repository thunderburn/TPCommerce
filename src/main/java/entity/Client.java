package entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by nicolas on 16/06/14.
 */
@Entity
public class Client {
    private long cliId;
    private String cliNom;
    private String cliPrenom;
    private String cliMail;
    private String cliMotdepasse;
    private String cliType;
    private List<Cb> cbList;
    private List<Commande> commandes;
    private List<Adresse> adresses;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_CLI_ID")
    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }



    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_CLI_ID")
    public List<Cb> getCbList() {
        return cbList;
    }

    public void setCbList(List<Cb> cbList) {
        this.cbList = cbList;
    }


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_CLI_ID")
    public List<Adresse> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
    }


    @Id
    @GeneratedValue(strategy=GenerationType.AUTO, generator="CLI_ID")
    @SequenceGenerator(name="CLI_ID", sequenceName="SEQ_CLIENT")
    @Column(name = "CLI_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public long getCliId() {
        return cliId;
    }

    public void setCliId(long cliId) {
        this.cliId = cliId;
    }

    @Basic
    @Column(name = "CLI_NOM", nullable = true, insertable = true, updatable = true)
    public String getCliNom() {
        return cliNom;
    }

    public void setCliNom(String cliNom) {
        this.cliNom = cliNom;
    }

    @Basic
    @Column(name = "CLI_PRENOM", nullable = true, insertable = true, updatable = true)
    public String getCliPrenom() {
        return cliPrenom;
    }

    public void setCliPrenom(String cliPrenom) {
        this.cliPrenom = cliPrenom;
    }

    @Basic
    @Column(name = "CLI_MAIL", nullable = true, insertable = true, updatable = true)
    public String getCliMail() {
        return cliMail;
    }

    public void setCliMail(String cliMail) {
        this.cliMail = cliMail;
    }

    @Basic
    @Column(name = "CLI_MOTDEPASSE", nullable = false, insertable = true, updatable = true)
    public String getCliMotdepasse() {
        return cliMotdepasse;
    }

    public void setCliMotdepasse(String cliMotdepasse) {
        this.cliMotdepasse = cliMotdepasse;
    }

    @Basic
    @Column(name = "CLI_TYPE", nullable = true, insertable = true, updatable = true)
    public String getCliType() {
        return cliType;
    }

    public void setCliType(String cliType) {
        this.cliType = cliType;
    }

}
