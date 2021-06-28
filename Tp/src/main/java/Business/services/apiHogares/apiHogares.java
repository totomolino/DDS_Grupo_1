package Business.services.apiHogares;

import Business.services.apiHogares.entities.Hogar;
import Business.services.apiHogares.entities.hogaresDeTransito;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class apiHogares {

    private static apiHogares instancia = null;
    private static final String urlAPI = "https://api.refugiosdds.com.ar/api/";
    private Retrofit retrofit;
    private String bearer = "Bearer GGiskO98Hf6oSNEYMUWHDpvcc5kl4B9ZdgtMnLhEqotpVd8FXafMp7YF5gYi";


    public apiHogares() {



        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static apiHogares getInstancia() {
        if(instancia == null){
            instancia = new apiHogares();
        }

        return instancia;
    }

    public List<Hogar> listadoDeHogares() throws IOException {
        ApiHogaresService hogaresService = this.retrofit.create(ApiHogaresService.class);
        Call<hogaresDeTransito> requestHogares = hogaresService.hogares(1, bearer);
        Response<hogaresDeTransito> responseHogares = requestHogares.execute();
        hogaresDeTransito aux = responseHogares.body();
        int cantidad = aux.getTotal();
        List<Hogar> hogaresAux = new ArrayList<>();
        int cantidadPaginas = (int) Math.ceil((double) cantidad/10.0);//HAY 10 PO

        for(int i = 1; i <= cantidadPaginas; i++) {
            hogaresAux.addAll(listadoDeHogaresPorOffset(i));
        }
        return hogaresAux;
    }

    public List<Hogar> listadoDeHogaresPorOffset(int offset) throws IOException {
        ApiHogaresService hogaresService = this.retrofit.create(ApiHogaresService.class);
        Call<hogaresDeTransito> requestHogares = hogaresService.hogares(offset, bearer);
        Response<hogaresDeTransito> responseHogares = requestHogares.execute();
        return responseHogares.body().getHogares();
    }
    public Response<hogaresDeTransito> pagina(int offset) throws IOException {
        ApiHogaresService hogaresService = this.retrofit.create(ApiHogaresService.class);
        Call<hogaresDeTransito> requestHogares = hogaresService.hogares(offset, bearer);
        Response<hogaresDeTransito> responseHogares = requestHogares.execute();
        return responseHogares;
    }


}
