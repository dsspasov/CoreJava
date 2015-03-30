package problem2;

import java.util.Calendar;

class Time {

    
    private int second;
    private int minute;
    private int hour;
    private int day;
    private int month;
    private int year;
    
    private Calendar calendar = Calendar.getInstance();

    Time() {

        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);

        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.month = calendar.get(Calendar.MONTH);
        this.year = calendar.get(Calendar.YEAR);

    }

    Time(int second, int minute, int hour, int day, int month, int year) {
        if (isValidSecond(second)) {
            this.second = second;
        } else {
            this.second = 0;
        }
        if (isValidMinute(minute)) {
            this.minute = minute;
        } else {
            this.minute = 0;
        }
        if (isValidHour(hour)) {
            this.hour = hour;
        } else {
            this.hour = 0;
        }
        if (isValidDay(day)) {
            this.day = day;
        } else {
            this.day = 0;
        }
        if (isValidMonth(month)) {
            this.month = month;
        } else {
            this.month = 0;
        }

        this.year = year;

    }

    private boolean isValidSecond(int second) {
        if (second < 0 || second > 60)
            return false;
        return true;
    }

    private boolean isValidMinute(int minute) {
        if (minute < 0 || minute > 60)
            return false;
        return true;
    }

    private boolean isValidHour(int hour) {
        if (hour < 0 || hour > 23)
            return false;
        return true;
    }

    private boolean isValidDay(int day) {
        if (day < 1 || day > 31)
            return false;
        return true;
    }

    private boolean isValidMonth(int month) {
        if (month < 0 || month > 12)
            return false;
        return true;
    }
    
    @Override
    public String toString(){
        String date = String.format("%d:%d:%d  %d-%d-%d", hour, minute, second, day, month, year);
        return date;       
    }
    
    public static Time now(){
        return new Time();
    }
    
}
