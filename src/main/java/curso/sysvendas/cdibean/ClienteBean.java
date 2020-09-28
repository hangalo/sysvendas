/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.sysvendas.cdibean;

import curso.sysvendas.ejbs.ClienteFacade;
import curso.sysvendas.entidades.Cliente;
import curso.sysvendas.entidades.Municipio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author DGTALE
 */
@Named(value = "clienteBean")
@RequestScoped
public class ClienteBean {

    @Inject
    Cliente cliente;
    @Inject
    ClienteFacade clienteFacade;
    @Inject
    Municipio municipio;

    String nome, sobrenome;
    Date inicio, fim;
    List<Cliente> listaClientes = new ArrayList<>();

    public List<Cliente> listaPorNomeSobrenome() {
        listaClientes = clienteFacade.buscarClientesPorNomeSobrenome(nome, sobrenome);
        return listaClientes;
    }
    
     public List<Cliente> listaEntreDataPorMunicipio() {
        listaClientes = clienteFacade.buscarClientesPorMunicipioRegistoEntreDatas(municipio, inicio, fim);
        return listaClientes;
    }

}
