package Business.services.apiHogares;

import Business.services.apiHogares.entities.hogaresDeTransito;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiHogaresService {


    @GET("hogares")
    Call<hogaresDeTransito> hogares(@Query("offset") int offset, @Header("Authorization") String authBearer);



}
