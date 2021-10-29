import Business.TipoDeUsuario;
import Business.Usuario;
import Sistema.Sistema;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import respuestas.devolverObjeto;
import spark.Request;
import spark.Response;
import spark.Spark;
import views.menuPruebas;

import java.io.IOException;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static spark.Spark.before;
import static spark.Spark.options;

public class main {

    private static menuPruebas menu = new menuPruebas();

    public static void main(String[] args) throws IOException, SchedulerException {

        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        scheduler.start();

        JobDetail job = newJob(RecomendarAdopcion.class)
                .withIdentity("recomendar")
                .build();

        CronTrigger trigger =  newTrigger().withIdentity("trigger1")
                .startNow()
                .withSchedule(cronSchedule("0 0 10 ? * WED *"))
                .build();

        scheduler.scheduleJob(job, trigger);

        Spark.path("/patitas", Sistema::definePaths);
        Spark.get("/prueba", main::devolverAlgo);

        options("/*",
                (request, response) -> {

                    String accessControlRequestHeaders = request
                            .headers("Access-Control-Request-Headers");
                    if (accessControlRequestHeaders != null) {
                        response.header("Access-Control-Allow-Headers",
                                accessControlRequestHeaders);
                    }

                    String accessControlRequestMethod = request
                            .headers("Access-Control-Request-Method");
                    if (accessControlRequestMethod != null) {
                        response.header("Access-Control-Allow-Methods",
                                accessControlRequestMethod);
                    }

                    return "OK";
                });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));





        //menu.iniciarMenu();


    }
    private static String devolverAlgo(Request request, Response response) {

        response.type("application/json");
        return new devolverObjeto(new Usuario(13, TipoDeUsuario.DUENIO, "tomas","deaaa","deaaa"),"este es un mensaje").transformar();
    }

    public static class RecomendarAdopcion implements Job {

        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            Sistema sistema = Sistema.getInstancia();
            sistema.recomendarAdoptar();
        }
    }


}
