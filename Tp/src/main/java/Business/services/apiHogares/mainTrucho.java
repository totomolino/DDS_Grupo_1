package Business.services.apiHogares;

import Business.services.apiHogares.entities.Hogar;
import Business.services.apiHogares.entities.hogaresDeTransito;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class mainTrucho {


    public static void main(String[] args) throws IOException {

        apiHogares api = apiHogares.getInstancia();

        //List<Hogar> hogares = api.listadoDeHogaresPorOffset(1);
        Response<hogaresDeTransito> hogares = api.pagina(1);

        /*for(Hogar hogar : hogares){
            System.out.println(hogar.id + ")" + hogar.telefono);
        }*/











    }











}
