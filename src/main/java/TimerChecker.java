import org.quartz.*;

public class TimerChecker implements Job {

    public TimerChecker() {
    }

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(">> Czasosprawdzacz   <<");

        TimelineUAM timelineUAM = TimelineUAM.getInstance();

        System.out.println("Obecnie: " + timelineUAM.getCurrentTimelineItemType().toString());
        System.out.println("Do konca minut: " + timelineUAM.getMinutesToNextTypeFromNow());
        System.out.println("-----------------------");
    }

}
