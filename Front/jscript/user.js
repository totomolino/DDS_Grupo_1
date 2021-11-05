
var app = new Vue({
    el: "#appVue",
    data: {
        nombre:""
    },
    methods: {
    },
    created(){
        var idSesion = localStorage.getItem("IDSESION") //recupera ID
            fetch("http://localhost:4567/patitas/misDatos", {
                headers: {
                    "Authorization": idSesion //se envia el IDSESION para identificar al usuario en backend
                }
            }) //~(°-°~) ~(°-°)~ (~°-°)~
                .then(response => response.json())
                .then(objeto => {
                    
                    this.nombre = objeto.nombre})
        }  
})


function agarrarStatus(status){
    if(status == 400){    
        alert("Debes iniciar sesion");
        document.getElementById("volver").click();
    }
}