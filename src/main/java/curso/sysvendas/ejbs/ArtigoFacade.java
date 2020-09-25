/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.sysvendas.ejbs;

import curso.sysvendas.entidades.Artigo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author DGTALE
 */
@Stateless
public class ArtigoFacade extends AbstractFacade<Artigo> {

    @PersistenceContext(unitName = "sysvendasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArtigoFacade() {
        super(Artigo.class);
    }

    public List<Artigo> pesquisaPorNome(String nomeArtigo) {
        List<Artigo> lista = null;
        Query qry;
        qry = em.createQuery("SELECT a FROM Artigo a WHERE a.nomeArtigo LIKE: nomeArtigo");
        qry.setParameter("nomeArtigo", "nomeArtigo");
        lista = qry.getResultList();
        return lista;
    }
    
     public List<Artigo> todosArtigos() {
        List<Artigo> lista = null;
        Query qry;
        qry = em.createQuery("SELECT a FROM Artigo a");
        lista = qry.getResultList();
        return lista;
    }

}
