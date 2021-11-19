var app = new Vue({
    el: "#vueAdop",
    data: {                
        mascotas:[]
    },
    methods: {
    },
    created(){
        var idSesion = localStorage.getItem("IDSESION") //recupera ID
        fetch("http://localhost:4567/patitas/duenio/mascotas", {
            headers: {
                "Authorization": idSesion //se envia el IDSESION para identificar al usuario en backend
            }
        }) //~(°-°~) ~(°-°)~ (~°-°)~
            .then(response => response.json())
            .then(data => {
                this.mascotas = data.mascotas
                console.log(this.mascotas)
            })
            
    }     
})