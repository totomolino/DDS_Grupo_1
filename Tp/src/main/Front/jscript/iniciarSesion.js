



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