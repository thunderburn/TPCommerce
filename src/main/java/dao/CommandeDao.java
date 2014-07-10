package dao;

import entity.Commande;

/**
 * Created by nicolas on 16/06/14.
 */
public class CommandeDao extends AbstractDao<Commande, Long> {

    public Commande getOne(Commande commande)
    {
        return this.get(Commande.class, commande.getCommandeId());
    }
}
