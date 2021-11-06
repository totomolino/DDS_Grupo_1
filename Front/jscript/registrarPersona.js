
var app = new Vue({
    el: "#appVueRegistro",
    data: {
        nombre : "",
        apellido : "",
        fechaDeNacimiento : "",
        documento: "",
        numero: "",
        telefono: "",
        email:"",
        formasNotif: [],
        username:"",
        password:"",
        password2:"",
        tipo:"",
        nombreCon : "",
        apellidoCon : "",
        fechaDeNacimientoCon : "",
        documentoCon: "",
        numeroCon: "",
        telefonoCon: "",
        emailCon:"",
        formasNotifCon: [],             
    },
    methods:{
        registrarse: function(){
            
            //primero se crea el usuario
            
            crearUsuario(this.username, this.email, this.contrasenia, this.tipo);






        }
    }
})


function crearUsuario(usuario, email, contrasenia, tipo){

    var req = {
        "usu_email": email,
        "usu_contrasena":contrasenia,
        "usu_nombre": usuario,
        "usu_tipo": tipo   
    }

    fetch("http://localhost:4567/patitas/user", {

        method: "POST",
        body: JSON.stringify(req)
    })

}