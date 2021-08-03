import Sistema.Sistema;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import views.menuPruebas;

import java.io.IOException;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

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

        // TODO SOS UN OMOFOBO
        // TODO SOS UN OMNIFERO
        // TODO SOS UN SOMNIFERO
        // TODO SOS UN SUENIO
        // TODO SOS UN DORMIR
        // TODO SOS UN CAMA
        // TODO SOS UN CUARTO
        // TODO SOS UN QUINTO
        // TODO SOS UN QUINTERO
        // TODO SOS UN RIVER
        // TODO SOS UN PLATE
        // TODO SOS UN PLATO
        // TODO SOS UN PATO
        // TODO SOS UN AVE
        // TODO SOS UN VOLAR
        // TODO SOS UN VIENTO
        // TODO SOS UN VENTILADOR
        //TODO SOS UN VENTILADOR

        menu.iniciarMenu();


    }


    public static class RecomendarAdopcion implements Job {

        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            Sistema sistema = Sistema.getInstancia();
            sistema.recomendarAdoptar();
        }
    }


}
