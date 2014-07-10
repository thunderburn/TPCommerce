package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by nicolas on 16/06/14.
 */
@Entity
public class Cb {
    private int cbId;
    private Long cbNumero;
    private Integer cbSecu;
    private String cbDate;

    @Id
    @Column(name = "CB_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getCbId() {
        return cbId;
    }

    public void setCbId(int cbId) {
        this.cbId = cbId;
    }

    @Basic
    @Column(name = "CB_NUMERO", nullable = true, insertable = true, updatable = true, precision = 0)
    public long getCbNumero() {
        return cbNumero;
    }

    public void setCbNumero(long cbNumero) {
        this.cbNumero = cbNumero;
    }

    @Basic
    @Column(name = "CB_SECU", nullable = true, insertable = true, updatable = true, precision = 0)
    public Integer getCbSecu() {
        return cbSecu;
    }

    public void setCbSecu(Integer cbSecu) {
        this.cbSecu = cbSecu;
    }

    @Basic
    @Column(name = "CB_DATE", nullable = true, insertable = true, updatable = true)
    public String getCbDate() {
        return cbDate;
    }

    public void setCbDate(String cbDate) {
        this.cbDate = cbDate;
    }

}
