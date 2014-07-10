package entity;

import javax.persistence.*;

/**
 * Created by nicolas on 16/06/14.
 */
@Entity
public class Adressescommandes {
    private int adressescommandesId;
    private Adresse adresseByAdresseAdrId;

    @Id
    @Column(name = "ADRESSESCOMMANDES_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getAdressescommandesId() {
        return adressescommandesId;
    }

    public void setAdressescommandesId(int adressescommandesId) {
        this.adressescommandesId = adressescommandesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adressescommandes that = (Adressescommandes) o;

        if (adressescommandesId != that.adressescommandesId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return adressescommandesId;
    }

    @ManyToOne
    @JoinColumn(name = "ADRESSE_ADR_ID", referencedColumnName = "ADR_ID", nullable = false)
    public Adresse getAdresseByAdresseAdrId() {
        return adresseByAdresseAdrId;
    }

    public void setAdresseByAdresseAdrId(Adresse adresseByAdresseAdrId) {
        this.adresseByAdresseAdrId = adresseByAdresseAdrId;
    }
}
