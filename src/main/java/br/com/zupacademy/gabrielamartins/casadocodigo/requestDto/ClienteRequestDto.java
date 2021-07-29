package br.com.zupacademy.gabrielamartins.casadocodigo.requestDto;

import br.com.zupacademy.gabrielamartins.casadocodigo.config.validation.CpfOuCnpj;
import br.com.zupacademy.gabrielamartins.casadocodigo.config.validation.ExistsId;
import br.com.zupacademy.gabrielamartins.casadocodigo.config.validation.UniqueValue;
import br.com.zupacademy.gabrielamartins.casadocodigo.model.Cliente;
import br.com.zupacademy.gabrielamartins.casadocodigo.model.Estado;
import br.com.zupacademy.gabrielamartins.casadocodigo.model.Pais;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.gabrielamartins.casadocodigo.repository.PaisRepository;
import org.springframework.util.Assert;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class ClienteRequestDto {


    @NotBlank
    @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @CpfOuCnpj
    @NotBlank
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long idPais;
    private Long idEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public ClienteRequestDto(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
                       @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
                       @NotBlank String cidade, @NotNull Long idPais, @NotBlank String telefone,
                       @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.telefone = telefone;
        this.cep = cep;
    }


    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public Long getIdPais() {
        return idPais;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public Cliente converteParaCliente(PaisRepository paisRepository, EstadoRepository estadoRepository){
        @NotNull Optional<Pais> pais = paisRepository.findById(idPais);

        Assert.state(pais.isPresent(), "Não existe um país com esse id: " + idPais);

        Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, cep, pais.get());

        if (estadoIdPresente()){
            Optional<Estado> estado = estadoRepository.findById(idEstado);
            Assert.state(estado.isPresent(), "Não existe um estado com esse id: " + idEstado);
            cliente.setEstado(estado.get());
        }

        return cliente;
    }

    public boolean estadoIdPresente() {
        return idEstado!=null;
    }

    public boolean estadoIdAusente(){
        return !estadoIdPresente();
    }


    public boolean estadoIdEstaVazio() {
            return !estadoIdPresente();
        }

}
