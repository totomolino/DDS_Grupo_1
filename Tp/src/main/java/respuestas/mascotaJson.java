package respuestas;

import dominioBD.MascotaBD;

public class mascotaJson extends claseJSon{

    MascotaBD mascotaBD;

    public mascotaJson(MascotaBD mascotaBD) {
        this.mascotaBD = mascotaBD;
    }

    public MascotaBD getMascotaBD() {
        return mascotaBD;
    }

    public void setMascotaBD(MascotaBD mascotaBD) {
        this.mascotaBD = mascotaBD;
    }
}
