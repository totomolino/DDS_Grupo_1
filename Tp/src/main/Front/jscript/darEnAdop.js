var app = new Vue({
    el: "#vueAdop",
    data: {                
        mascotas:[]
    },
    methods: {
    },
    created(){
        fetch("http://localhost:4567/duenio/mascotas", {
            headers: {
                "Authorization": idSesion //se envia el IDSESION para identificar al usuario en backend
            }
        }) //~(°-°~) ~(°-°)~ (~°-°)~
            .then(response => response.json())
            .then(data => this.mascotas = data)
    }     
})