
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
        idDuenio: "",
        idCont: "",
        usuId:""
    },
    methods:{
        registrarse: function(){
            
            //primero se crea el usuario

            if(this.password != this.password2){
                alert("La contrasenia debe coincidir")
                return;
            }
            
            
            crearUsuario(this.username, this.email, this.password, this.tipo);

            this.crearDuenio
            
            this.crearContacto          



        },
        crearDuenio: async function(){
            var req = {
                "pers_nombre": this.nombre,
                "pers_apellido": this.apellido,
                "pers_fechaNacimiento": this.fechaDeNacimiento,
                "pers_documento": this.numero,
                "pers_tipoDocumento": this.documento,
                "pers_telefono": this.telefono,
                "pers_usuario":{
                    "usu_id": parseInt(usuId)
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
                return Response.json()})
            .then(data => {
                this.idDuenio = data.pers_id
            })

            this.formasNotif.forEach(function(notif) {
                agregarNotificacionPersona(this.idDuenio, notif)
            })

        },
        crearContacto: async function(){
            var reqCon = {
                "cont_nombre": this.nombreCon,
                "cont_apellido": this.apellido,
                "cont_telefono": this.telefonoCon,
                "cont_email": this.emailCon,
                "cont_persona":{
                    "pers_id": parseInt(this.idDuenio)
                }
            }

            fetch("http://localhost:4567/patitas/contacto", {
                method: "POST",
                body: JSON.stringify(reqCon)
            })
            .then(Response => {
                error(Response.status, "No se pudo crear el contacto")
                return Response.json()
            })
            .then(data => {
                this.idCont = data.cont_id
            } )
            
            this.formasNotifCon.forEach(function(notif) {
                agregarNotificacionContacto(this.idCont, notif)
            })
        }
    }
})

async function agregarNotificacionPersona(id, notif){

    var reqNotifPers = {
        "fonop_persona":{
            "pers_id": parseInt(id)
        },
        "fonop_forma": notif 
    }

    fetch("http://localhost:4567/patitas/notifPers", {
        method: "POST",
        body: JSON.stringify(reqNotifPers)
    }).then(Response => {
        error(Response.status, "No se pudo agregar el tipo de notif")
    })

}

async function agregarNotificacionContacto(id, notif){

    var reqNotifCon = {
        "fonoc_contacto":{
            "cont_id": parseInt(id)
        },
        "fonoc_forma":notif
    }

    fetch("http://localhost:4567/patitas/notifCont", {
        method: "POST",
        body: JSON.stringify(reqNotifCon)
    }).then(Response => {
        error(Response.status, "No se pudo agregar el tipo de notif")
    })

}


function errorUser(status){
    error(status, "El usuario no fue creado")    
}

function errorDuenio(status){
    error(status, "El duenio no fue creado")
}

function error(status, mensaje){
    if(status == 400 || status == 500){
        alert(mensaje)
        return;
    }
}

async function crearUsuario(usuario, email, contrasenia, tipo){
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
        error(Response.status,Response.json().mensaje)
        return Response.json()})
    .then(data => {
        this.usuId = data.usuario.usu_id
    })
 
}

