public class TimelineItem {

    private Time timeFrom;
    private Time timeTo;

    private TimelineItemType timelineItemType;

    public TimelineItem(int hourFrom, int hourTo, int minuteFrom, int minuteTo, TimelineItemType timelineItemType) {
        timeFrom = new Time(hourFrom, minuteFrom);
        timeTo = new Time(hourTo, minuteTo);
        this.timelineItemType = timelineItemType;
    }

    public TimelineItem(Time timeFrom, Time timeTo, TimelineItemType timelineItemType) {
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        this.timelineItemType = timelineItemType;
    }

    //Time in format like this: 15:00
    public TimelineItem(String stringTimeFrom, String stringTimeTo, TimelineItemType timelineItemType) {
        this.timeFrom = new Time(Integer.parseInt(stringTimeFrom.split(":")[0]), Integer.parseInt(stringTimeFrom.split(":")[1]));
        this.timeTo = new Time(Integer.parseInt(stringTimeTo.split(":")[0]), Integer.parseInt(stringTimeTo.split(":")[1]));
        this.timelineItemType = timelineItemType;
    }

    public Time getTimeFrom() {
        return timeFrom;
    }

    public Time getTimeTo() {
        return timeTo;
    }

    public TimelineItemType getTimelineItemType() {
        return timelineItemType;
    }
}
