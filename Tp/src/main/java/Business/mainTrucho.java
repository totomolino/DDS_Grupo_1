package Business;


import Sistema.Sistema;
import spark.Spark;

public class mainTrucho {

    public static void main(String[] args) {
        Spark.path("/sistema", Sistema::definePaths);
    }


}
