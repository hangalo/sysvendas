/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.sysvendas.cdibean;

import curso.sysvendas.ejbs.ArtigoFacade;
import curso.sysvendas.entidades.Artigo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "artigoBean")
@RequestScoped
public class ArtigoBean {

    @Inject
    Artigo artigo;
    @Inject
    ArtigoFacade artigoFacade;

    List<Artigo> artigos;

    @PostConstruct
    public void init() {
        artigos = artigoFacade.todosArtigos();
    }

    public List<Artigo> getArtigos() {
        return artigos;
    }

    public void setArtigos(List<Artigo> artigos) {
        this.artigos = artigos;
    }

    public Artigo getArtigo() {
        return artigo;
    }

    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }

    public String save() {
        artigoFacade.create(artigo);
        artigo = new Artigo();
        return "novo-artigo";
    }
}
