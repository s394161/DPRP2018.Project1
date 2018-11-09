import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Timeline {

    private ArrayList<TimelineItem> timelineItemArrayList;

    public Timeline(ArrayList<TimelineItem> timelineItemArrayList) {
        this.timelineItemArrayList = timelineItemArrayList;
    }

    public Timeline() {
        timelineItemArrayList = new ArrayList<TimelineItem>();
    }

    void addTimelineItem(TimelineItem timelineItem) {
        if (timelineItemArrayList != null) {
            timelineItemArrayList.add(timelineItem);
        }
    }

    public TimelineItemType getCurrentTimelineItemType() {
        String timeStamp = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
        return getCurrentTimelineItemType(timeStamp);
    }

    public TimelineItemType getCurrentTimelineItemType(String currentTimestamp) {
        if (timelineItemArrayList != null) {
            return getCurrentTimelineItem(currentTimestamp).getTimelineItemType();
        }
        return TimelineItemType.UNDEFINED;
    }

    public TimelineItem getCurrentTimelineItem(String currentTimestamp) {
        Date currentTime = null;
        SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
        try {
            currentTime = parser.parse(currentTimestamp);
            for (TimelineItem timelineItem : timelineItemArrayList) {
                if (currentTime.after(parser.parse(timelineItem.getTimeFrom().toString()))
                        && currentTime.before(parser.parse(timelineItem.getTimeTo().toString()))) {
                    return timelineItem;
                }
            }
        } catch (ParseException e) {
            // Invalid date was entered
        }
        return null;
    }

    public int getMinutesToNextTypeFromNow() {
        String currentTime = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
        int currentMinutes = Integer.parseInt(currentTime.split(":")[0]) * 60 + Integer.parseInt(currentTime.split(":")[1]);

        String timeStamp = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
        TimelineItem timelineItem = getCurrentTimelineItem(timeStamp);
        int toMinutes = timelineItem.getTimeTo().getHour() * 60 + timelineItem.getTimeTo().getMinute();

        return toMinutes - currentMinutes;
    }
}
