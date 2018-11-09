public class TimelineUAM extends Timeline {
    private static TimelineUAM instance;

    private TimelineUAM() {
        generateStandardTimelineUAM();
    }

    public static synchronized TimelineUAM getInstance() {
        if (instance == null) {
            instance = new TimelineUAM();
        }
        return instance;
    }

    private void generateStandardTimelineUAM() {

        addTimelineItem(new TimelineItem("0:00",  "8:14", TimelineItemType.BREAK));
        addTimelineItem(new TimelineItem("8:15",  "9:44", TimelineItemType.LESSON));
        addTimelineItem(new TimelineItem("9:45",  "9:59", TimelineItemType.BREAK));
        addTimelineItem(new TimelineItem("10:00", "11:30", TimelineItemType.LESSON));
        addTimelineItem(new TimelineItem("11:30", "11:44", TimelineItemType.BREAK));
        addTimelineItem(new TimelineItem("11:45", "13:14", TimelineItemType.LESSON));
        addTimelineItem(new TimelineItem("13:15", "13:44", TimelineItemType.BREAK));
        addTimelineItem(new TimelineItem("13:45", "15:14", TimelineItemType.LESSON));
        addTimelineItem(new TimelineItem("15:15", "15:29", TimelineItemType.BREAK));
        addTimelineItem(new TimelineItem("15:30", "16:59", TimelineItemType.LESSON));
        addTimelineItem(new TimelineItem("17:00", "17:14", TimelineItemType.BREAK));
        addTimelineItem(new TimelineItem("17:15", "18:44", TimelineItemType.LESSON));
        addTimelineItem(new TimelineItem("18:45", "23:59", TimelineItemType.BREAK));
    }
}

