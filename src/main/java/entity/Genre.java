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
public class Genre {
    private BigInteger genreId;
    private String genreLibelle;

    @Id
    @Column(name = "GENRE_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public BigInteger getGenreId() {
        return genreId;
    }

    public void setGenreId(BigInteger genreId) {
        this.genreId = genreId;
    }

    @Basic
    @Column(name = "GENRE_LIBELLE", nullable = true, insertable = true, updatable = true)
    public String getGenreLibelle() {
        return genreLibelle;
    }

    public void setGenreLibelle(String genreLibelle) {
        this.genreLibelle = genreLibelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (genreId != null ? !genreId.equals(genre.genreId) : genre.genreId != null) return false;
        if (genreLibelle != null ? !genreLibelle.equals(genre.genreLibelle) : genre.genreLibelle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = genreId != null ? genreId.hashCode() : 0;
        result = 31 * result + (genreLibelle != null ? genreLibelle.hashCode() : 0);
        return result;
    }
}
