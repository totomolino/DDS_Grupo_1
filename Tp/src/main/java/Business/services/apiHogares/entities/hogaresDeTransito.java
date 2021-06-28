package Business.services.apiHogares.entities;

import java.util.List;

public class hogaresDeTransito {


    public int total;

    public int offset;

    public List<Hogar> hogares;


    public int getTotal() {
        return total;
    }

    public List<Hogar> getHogares() {
        return hogares;
    }
}
