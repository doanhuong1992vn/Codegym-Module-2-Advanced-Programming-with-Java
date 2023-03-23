package lesson_04_class_object_in_java.class_stopWatch;

import java.util.Date;

public class StopWatch {
    private Date startTime, endTime;
    long millisStart, millisEnd;
    public StopWatch() {
        this.startTime = new Date();
    }
    public Date getStartTime() {
        return startTime;
    }
    public Date getEndTime() {
        return endTime;
    }
    public void start() {
        this.startTime = new Date();
        this.millisStart = System.currentTimeMillis();
    }
    public void stop() {
        this.endTime = new Date();
        this.millisEnd = System.currentTimeMillis();
    }
    public long getElapsedTime() {
        return this.millisEnd - this.millisStart;
    }
}
