import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.Assert.*;

public class TimelineUAMTest {

    TimelineUAM timelineUAM;

    @Before
    public void setUp() throws Exception {
        timelineUAM = TimelineUAM.getInstance();
    }

    @Test
    public void getCurrentTimelineItemType(){
        String timeStamp = "9:50";
        TimelineItemType timelineItemType = timelineUAM.getCurrentTimelineItemType(timeStamp);
        Assert.assertEquals(timelineItemType, TimelineItemType.BREAK);
    }

    @Test
    public void getCurrentTimelineItemType2(){
        String timeStamp2 = "10:50";
        TimelineItemType timelineItemType2 = timelineUAM.getCurrentTimelineItemType(timeStamp2);
        Assert.assertEquals(timelineItemType2, TimelineItemType.LESSON);
    }
}