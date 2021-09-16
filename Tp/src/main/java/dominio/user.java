package dominio;

import javax.persistence.*;



@Entity
public class user {
        @Id
        @GeneratedValue
        private Long usu_codigo;

        private Long usu_tipo;

        private String usu_nombre;

        private String usu_contrasena;

        private String usu_mail;

        public user(Long usu_tipo, String usu_nombre, String usu_contrasena, String usu_mail) {
                this.usu_tipo = usu_tipo;
                this.usu_nombre = usu_nombre;
                this.usu_contrasena = usu_contrasena;
                this.usu_mail = usu_mail;
        }

        public user() {

        }

        // getters, setters

        public Long getUsu_codigo() {
                return usu_codigo;
        }

        public void setUsu_codigo(Long usu_codigo) {
                this.usu_codigo = usu_codigo;
        }

        public Long getUsu_tipo() {
                return usu_tipo;
        }

        public void setUsu_tipo(Long usu_tipo) {
                this.usu_tipo = usu_tipo;
        }

        public String getUsu_nombre() {
                return usu_nombre;
        }

        public void setUsu_nombre(String usu_nombre) {
                this.usu_nombre = usu_nombre;
        }

        public String getUsu_contrasena() {
                return usu_contrasena;
        }

        public void setUsu_contrasena(String usu_contrasena) {
                this.usu_contrasena = usu_contrasena;
        }

        public String getUsu_mail() {
                return usu_mail;
        }

        public void setUsu_mail(String usu_mail) {
                this.usu_mail = usu_mail;
        }
}


