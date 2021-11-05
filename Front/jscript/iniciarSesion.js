var status 



function iniciarSesion(usuarioOemail, contrasenia){

    fetch("http://localhost:4567/patitas/iniciarSesion", {

        method: "POST",
        body: JSON.stringify({
            "usuario_Email":usuarioOemail,
            "contrasenia":contrasenia
        })

    })
    .then(Response => agarrarStatus(Response.status))

}

function agarrarStatus(status){
    if(status == 200){
        document.getElementById("anchorID").click();
    }
    else{
        alert("Usuario o contrasenia incorrecto");
    }
}



    var app = new Vue({
        el: "#appVue",
        data: {
            username: "",
            password: ""
        },
        methods: {
            login: function () {

                var status;
                
                var req = {
                    "usuario_Email": this.username,
                    "contrasenia":this.password
                }
                if(req.usuario_Email == "" || req.contrasenia == ""){
                    alert("Debes ingresar los campos")
                    return;
                }
                fetch("http://localhost:4567/patitas/iniciarSesion", {

                method: "POST",
                body: JSON.stringify(req)
            })
            .then(Response =>{
                status = Response.status;
                return Response.json()
            })
            .then(datos => {
                localStorage.setItem("IDSESION", datos.idSesion)
                agarrarStatus(status)                
            })
            
            }
        }
    })

    
function curtite(){
    
    alert("Bueno curtite gat@");
    
}
