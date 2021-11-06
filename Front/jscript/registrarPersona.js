
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
        idDuenio: ""
    },
    methods:{
        registrarse: function(){
            
            //primero se crea el usuario

            if(this.password != this.password2){
                alert("La contrasenia debe coincidir")
                return;
            }
            
            var id = crearUsuario(this.username, this.email, this.password, this.tipo);

            var req = {
                "pers_nombre": this.nombre,
                "pers_apellido": this.apellido,
                "pers_fechaNacimiento": this.fechaDeNacimiento,
                "pers_documento": this.numero,
                "pers_tipoDocumento": this.documento,
                "pers_telefono": this.telefono,
                "pers_usuario":{
                    "usu_id": id
                },
                "resc_organizacion":{
                    "orga_id": 1
                } 
            }

            fetch("http://localhost:4567/patitas/duenio", {
                method: "POST",
                body: JSON.stringify(req)
            })
            .then(Response => {
                errorDuenio(Response.status)
                Response.json()})
            .then(data => {
                this.idDuenio = data.pers_id
            })
            
            fetch("http://localhost:4567/patitas/notifPers", {
                
            })

            var reqCon = {
                "cont_nombre": this.nombreCon,
                "cont_apellido": this.apellido,
                "cont_telefono": this.telefonoCon,
                "cont_email": this.emailCon,
                "cont_persona":{
                    "pers_id": this.idDuenio
                }
            }

            fetch("http://localhost:4567/patitas/contacto", {
                method: "POST",
                body: JSON.stringify(reqCon)
            })
            
            



        }
    }
})

function errorUser(status){
    error(status, "El usuario no fue creado")    
}

function errorDuenio(status){
    error(status, "El duenio no fue creado")
}

function error(status, mensaje){
    if(status == 400){
        alert(mensaje)
        return;
    }
}

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
    .then(Response => {
        errorUser(Response.status)
        Response.json()})
    .then(data => {
        return data.usuario.usu_id
    })
}

