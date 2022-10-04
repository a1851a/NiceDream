package fju.project.nicedream.data.eventbus;

public class StringEvent {

    public static final int SHOW_HOME_PAGE = 100000;
    public static final int SHOW_ALARM_PAGE = 100001;
    public static final int SHOW_RECORD_PAGE = 100002;
    public static final int SHOW_SETTING_PAGE = 100003;


    int eventCode;
    String eventContent;

    public int getEventCode() {
        return eventCode;
    }

    public void setEventCode(int eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventContent() {
        return eventContent;
    }

    public void setEventContent(String eventContent) {
        this.eventContent = eventContent;
    }
}
