let dea;
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
        registrarse: async function(){

            if(this.password != this.password2){ //TODO HAY QUE VER COMO ENTRAR A ESTAS VARIABLES XD
                alert("La contrasenia debe coincidir")
                return;
            }
            await this.crearUsuario()
            
            await this.crearDuenio()

            for(const notif of this.formasNotif){
                await agregarNotificacionPersona(this.idDuenio, notif);
             }

            await this.crearContacto()

            for(const notif of this.formasNotifCon){
                await agregarNotificacionContacto(this.idCont, notif);
             }

        },        
        crearDuenio: function() {
    return new Promise(resolve => {            
            var req = {
                "pers_nombre": this.nombre,
                "pers_apellido": this.apellido,
                "pers_fechaNacimiento": this.fechaDeNacimiento,
                "pers_documento": this.numero,
                "pers_tipoDocumento": this.documento,
                "pers_telefono": this.telefono,
                "pers_usuario":{
                    "usu_id": parseInt(this.usuId)
                },
                "due_organizacion":{
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
                resolve('se creo el duenio')
            })
            



            })
                    
        },
        crearContacto: function() {
            return new Promise(resolve => {
                var reqCon = {
                "cont_nombre": this.nombreCon,
                "cont_apellido": this.apellidoCon,
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
                resolve('se creo el contacto')
            } )
            


            })
            
            
        },
        crearUsuario: function() {
            return new Promise(resolve => { 
                var req = {
                "usu_email": this.email,
                "usu_contrasena": this.password,
                "usu_nombre": this.username,
                "usu_tipo": this.tipo
            }
            var status
            fetch("http://localhost:4567/patitas/user", {
                method: "POST",
                body: JSON.stringify(req)
            })
            .then(Response => {
                status = Response.status
                return Response.json()})
            .then(data => {
                error(status,data.mensaje)
                this.usuId = data.usuario.usu_id
                resolve('se creo el usuario')
            })})
           
            
        }
    }
})

function agregarNotificacionPersona(id, notif){
    return new Promise(resolve => {
        var reqNotifPers = {
        "fonop_persona":{
            "pers_id": parseInt(id)
        },
        "fonop_forma": notif 
    }

    fetch("http://localhost:4567/patitas/notifPers", {
        method: "POST",
        body: JSON.stringify(reqNotifPers)
    }).then(resp => {
        error(resp.status, "No se pudo agregar el tipo de notif")
        if(Response.status = 200){
            resolve('se agrego la notificacion al duenio')
        }
    });
})
    
}

function agregarNotificacionContacto(id, notif){

    return new Promise(resolve => {    
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
        if(Response.status = 200){
            resolve('se agrego la notificacion al contacto')
        }
    })})

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



const funcionRegistrarse = async () => {
            
    //primero se crea el usuario
    var vue = document.getElementById("app")
    if(vue.data.password != vue.data.password2){ //TODO HAY QUE VER COMO ENTRAR A ESTAS VARIABLES XD
        alert("La contrasenia debe coincidir")
        return;
    }
    
    await vue.methods.crearUsuario();
    await vue.methods.crearDuenio();
    await vue.methods.crearContacto();

}
