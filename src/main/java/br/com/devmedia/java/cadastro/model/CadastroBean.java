package br.com.devmedia.java.cadastro.model;

import br.com.devmedia.java.cadastro.model.dao.CadastroDao;
import br.com.devmedia.java.cadastro.model.entities.Cadastro;
import br.com.devmedia.java.cadastro.model.entities.utils.Estado;
import br.com.devmedia.java.cadastro.model.entities.utils.EstadoCivil;
import br.com.devmedia.java.cadastro.model.entities.utils.Sexo;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import org.hibernate.tool.schema.extract.spi.ExtractionContext;

@ManagedBean
public class CadastroBean {

    private Cadastro cadastro = new Cadastro();
    private CadastroDao cadastroDao = new CadastroDao();
    
    private List<Cadastro> cadastros = new ArrayList<Cadastro>();
    public List<Cadastro> getCadastros() {
              cadastros = cadastroDao.findAll();
              return cadastros;       
        }

    public Cadastro getCadastro() {
       
        return  cadastro;
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }

    public Estado[] getEstado() {
        return Estado.values();
    }

    public EstadoCivil[] getEstadoCivil() {
        return EstadoCivil.values();
    }

    public Sexo[] getSexo() {
        return Sexo.values();
    }

    public String cadastrar() {
        cadastroDao.save(cadastro);
        cadastro = new Cadastro();

        return "sucesso";
    }
}
