package DTO;

public class UsuarioDTO {
        private int Id_usuario;
        private String Nome_usuario;
        private String Senha_usuario;


        
        public String getNomeRegistro_usuario() {

            return NomeRegistro_usuario;
        }
        public void setNomeRegistro_usuario(String nomeRegistro_usuario) {
            NomeRegistro_usuario = nomeRegistro_usuario;
        }

        public String getSenhaRegistro_usuario() {
            return SenhaRegistro_usuario;
        }
        public void setSenhaRegistro_usuario(String senhaRegistro_usuario) {
            SenhaRegistro_usuario = senhaRegistro_usuario;
        }

        private String NomeRegistro_usuario;
        private String SenhaRegistro_usuario;
        
        
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
