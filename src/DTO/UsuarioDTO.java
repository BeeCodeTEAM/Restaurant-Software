package DTO;

public class UsuarioDTO {
    private int Id_usuario;
    private String Nome_usuario;
    private String Senha_usuario;

    // Métodos getters e setters
    public int getId_usuario() {
        return Id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        Id_usuario = id_usuario;
    }

    public String getNome_usuario() {
        return Nome_usuario;
    }
    public void setNome_usuario(String nome_usuario) {
        Nome_usuario = nome_usuario;
    }

    public String getSenha_usuario() {
        return Senha_usuario;
    }
    public void setSenha_usuario(String senha_usuario) {
        Senha_usuario = senha_usuario;
    }
}
