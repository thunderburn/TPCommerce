package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

/**
 * Created by nicolas on 16/06/14.
 */
@Entity
public class Editeur {
    private String editNom;
    private BigInteger editId;

    @Basic
    @Column(name = "EDIT_NOM", nullable = true, insertable = true, updatable = true)
    public String getEditNom() {
        return editNom;
    }

    public void setEditNom(String editNom) {
        this.editNom = editNom;
    }

    @Id
    @Column(name = "EDIT_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigInteger getEditId() {
        return editId;
    }

    public void setEditId(BigInteger editId) {
        this.editId = editId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Editeur editeur = (Editeur) o;

        if (editId != null ? !editId.equals(editeur.editId) : editeur.editId != null) return false;
        if (editNom != null ? !editNom.equals(editeur.editNom) : editeur.editNom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = editNom != null ? editNom.hashCode() : 0;
        result = 31 * result + (editId != null ? editId.hashCode() : 0);
        return result;
    }
}
