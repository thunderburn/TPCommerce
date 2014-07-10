package dao;

import entity.Adresse;

import java.util.List;

/**
 * Created by nicolas on 05/06/14.
 */
public class AdresseDao extends AbstractDao<Adresse, Integer> {

    public AdresseDao()
    {
        super();
    }

    public List<Adresse> getAll()
    {
        return this.list(Adresse.class);
    }
}
