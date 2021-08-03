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
