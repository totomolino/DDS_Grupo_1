var app = new Vue({
    el: "#vueAdop",
    data: {                
        mascotas:[]
    },
    methods: {
        getFoto: function(index){

            var mascota = this.mascotas[index]

            var foto = mascota.fotoAnimales[0]


            if(foto == null){
                return "../fotos/caraPerrito.jpeg"
            }else
            return 'background-image: url("' + foto.direccion + '")'

        }
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