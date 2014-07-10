package entity;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by nicolas on 16/06/14.
 */
@Entity
public class Noteproduit {
    private int noteId;
    private BigInteger noteValeur;
    private Client clientByClientCliId;

    @Id
    @Column(name = "NOTE_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    @Basic
    @Column(name = "NOTE_VALEUR", nullable = true, insertable = true, updatable = true, precision = 0)
    public BigInteger getNoteValeur() {
        return noteValeur;
    }

    public void setNoteValeur(BigInteger noteValeur) {
        this.noteValeur = noteValeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Noteproduit that = (Noteproduit) o;

        if (noteId != that.noteId) return false;
        if (noteValeur != null ? !noteValeur.equals(that.noteValeur) : that.noteValeur != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noteId;
        result = 31 * result + (noteValeur != null ? noteValeur.hashCode() : 0);
        return result;
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
