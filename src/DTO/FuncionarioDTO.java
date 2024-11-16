package DTO;

public class FuncionarioDTO{
    private int id_funcionario;
    private String nome_funcionario;
    private String senha_funcionario;


    public String getNome_funcionario() {
        return nome_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    public String getSenha_funcionario() {
        return senha_funcionario;
    }

    public void setSenha_funcionario(String senha_funcionario) {
        this.senha_funcionario = senha_funcionario;
    }

    private String NomeRegistro_funcionario;
    private String SenhaRegistro_funcionario;

}


