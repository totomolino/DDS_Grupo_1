let dea;
var app = new Vue({
    el: "#appVueAgregar",
    data: {
        nombreCon : "",
        apellidoCon : "",
        telefonoCon: "",
        emailCon:"",
        formasNotifCon: [],
        idDuenio: "",
    },
    methods:{
        agregar: async function(){
            
            if (validateNotNullImput(this)) {
                await this.crearContacto()

                for(const notif of this.formasNotifCon){
                    await agregarNotificacionContacto(this.idCont, notif);
                }
                
                
                var val = confirm("Queres agregar otro contacto?")

                if(val == true){ //APRETA OKAY                
                    document.getElementById("agregarContacto").click();
                }else{
                    document.getElementById("index").click();
                }
            } else {
                alert("TENES QUE COMPLETAR TODOS LOS CAMPOS")
            };
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
            
            
        }
    },

    created(){
        this.idDuenio  = localStorage.getItem("personaID")
        
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

const validateNotNullImput = data => {
    const {formasNotifCon, idDuenio, ...elResto} = data._data;
  
    return Object.values(elResto).every( e => e != "") && (formasNotifCon.length > 0)
}
