/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.sysvendas.ejbs;

import curso.sysvendas.entidades.Estoque;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DGTALE
 */
@Stateless
public class EstoqueFacade extends AbstractFacade<Estoque> {

    @PersistenceContext(unitName = "sysvendasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstoqueFacade() {
        super(Estoque.class);
    }
    
}
