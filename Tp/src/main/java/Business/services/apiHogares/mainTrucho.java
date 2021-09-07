package Business.services.apiHogares;

import Business.services.apiHogares.entities.Hogar;
import Business.services.apiHogares.entities.hogaresDeTransito;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class mainTrucho {


    public static void main(String[] args) throws IOException {

        apiHogares api = apiHogares.getInstancia();

        List<Hogar> hogares = api.listadoDeHogares();


        for(Hogar hogar : hogares){
            System.out.println(hogar.nombre + ")" + hogar.telefono);
        }


    }











}
