
var app = new Vue({
    el: "#appVueRegistroMasc",
    data: {
        nombre:"",
        apodo:"",
        sexo:"",
        especie:"",
        edad:"",
        descripcion:"",
        fotos:[],
        idPers:"",
        idMasc:""
    },
    methods:{
        registrar: async function(){
            this.idPers = localStorage.getItem("IDPERSONA")
            await this.crearMascota()
            await this.agregarFotos()

            alert("SE CREO LA MASCOTA GIL")

        },
        guardarFotos: function (event){
            
            // Array.from(event.target.files).forEach(foto => this.getBase64(foto))
            // this.fotos = event.target.files
            for(var i = 0; i < event.target.files.length; i++)
            {           
                var file = event.target.files[i]
                this.getBase64(file)
                .then(img => {
                    this.fotos.push(img)
                })
            }
            console.log(this)

        },
        getBase64: function (file) {
            return new Promise((resolve, reject) => {
                var reader = new FileReader();
                reader.readAsDataURL(file);
                reader.onload = function () {
                    resolve(reader.result)
                };
                reader.onerror = function (error) {
                    reject('Error: ', error);
                }
            })
        },
        crearMascota: function () {
            return new Promise(resolve => {  

                var req = {
                    "masc_nombre":this.nombre,
                    "masc_apodo":this.apodo,
                    "masc_edad":parseInt(this.edad),
                    "masc_sexo":this.sexo,
                    "masc_especie":this.especie,
                    "masc_descripcion":this.descripcion,
                    "masc_tieneChapita":true,
                    "masc_organizacion":{
                        "orga_id":1
                    },
                    "masc_duenio":{
                        "pers_id":parseInt(this.idPers)
                    }    
                }
    
                fetch("http://localhost:4567/patitas/mascotas", {
                    method: "POST",
                    body: JSON.stringify(req)
                })
                .then(Response => {
                    errorMascota(Response.status)
                    return Response.json()})
                .then(data => {
                    this.idMasc = data.masc_id
                    resolve('se creo la mascota')
                })
                
    
    
    
                })
        },
        agregarFotos: function () {
            return new Promise(resolve => {  
                const lista = this.transformarFotos()
                var req = {
                    "fotos": lista
                }
    
                fetch("http://localhost:4567/patitas/mascotas/fotos", {
                    method: "POST",
                    body: JSON.stringify(req)
                })
                .then(Response => {
                    errorFotos(Response.status)
                    return Response.json()})
                .then(data => {                    
                    resolve('se agregaron las fotos')
                })
                })
        },
        transformarFotos: function(){            
            const lista = this.fotos.map(foto => 
                ({
                    fani_direccion: foto,
                    fani_masc:
                    {
                        masc_id: parseInt(this.idMasc)
                    } 
                })
            )
            return lista
        }
    }
    
})

function errorMascota(status){
    error(status, "La mascota no fue creada")
}
function errorFotos(status){
    error(status, "Las fotos no fueron cargadas")
}
function error(status, mensaje){
    if(status == 400 || status == 500){
        alert(mensaje)
        return;
    }
}