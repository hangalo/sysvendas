/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.sysvendas.ejbs;

import curso.sysvendas.entidades.Cliente;
import curso.sysvendas.entidades.Municipio;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author DGTALE
 */
@Stateless
public class ClienteFacade extends AbstractFacade<Cliente> {

    String CLIENTES_POR_NOME_SOBRENOME = "SELECT c FROM Cliente c WHERE c.nomeCliente LIKE : nomeCliente OR c.sobrenomeCliente LIKE : sobrenomeCliente";
    String CLIENTES_REGISTADOS_ENTRE_DATAS = "SELECT c FROM Cliente c WHERE c.dataCadastro BETWEEN :dataInicio AND :dataFim";

    @PersistenceContext(unitName = "sysvendasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClienteFacade() {
        super(Cliente.class);
    }

    public List<Cliente> buscarClientesPorNomeSobrenome(String nomeCliente, String sobrenomeCliente) {

        Query qry = em.createQuery(CLIENTES_POR_NOME_SOBRENOME);
        qry.setParameter("nomeCliente", "%" + nomeCliente + "%");
        qry.setParameter("sobrenomeCliente", "%" + sobrenomeCliente + "%");

        qry.setMaxResults(500);

        return qry.getResultList();
    }

    public List<Cliente> buscarClientesRegistadosEntreDatas(Date inicio, Date fim) {
        Query qry = em.createQuery(CLIENTES_REGISTADOS_ENTRE_DATAS);
        qry.setParameter("dataInicio", inicio, TemporalType.DATE);
        qry.setParameter("dataFim", fim, TemporalType.DATE);
        qry.setMaxResults(500);

        return qry.getResultList();
    }

    public List<Cliente> buscarClientesPorMunicipio(Municipio municipio) {
        Query qry = em.createQuery("SELECT c FROM Cliente c WHERE c.idMunicipio = :municipio");
        qry.setParameter("municipio", municipio);
        qry.setMaxResults(500);

        return qry.getResultList();
    }

    public List<Cliente> buscarClientesPorMunicipioRegistoEntreDatas(Municipio municipio, Date inicio, Date fim) {
        Query qry = em.createQuery("SELECT c FROM Cliente c WHERE c.idMunicipio = :municipio AND c.dataCadastro BETWEEN :dataInicio AND :dataFim");
        qry.setParameter("municipio", municipio);
        qry.setParameter("dataInicio", inicio, TemporalType.DATE);
        qry.setParameter("dataFim", fim, TemporalType.DATE);
        qry.setMaxResults(500);

        return qry.getResultList();
    }

}
