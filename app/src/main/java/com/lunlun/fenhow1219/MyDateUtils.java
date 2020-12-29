package com.lunlun.fenhow1219;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDateUtils {
    public static final SimpleDateFormat DATE_FORMAT_CHINESE = new SimpleDateFormat("yyyy年MM月dd日");
    public static final SimpleDateFormat DATE_FORMAT_CHINESE_MD = new SimpleDateFormat("MM月dd日");
    public static final SimpleDateFormat DATE_FORMAT_CHINESE_MD_SLASH = new SimpleDateFormat("MM/dd");
    public static final SimpleDateFormat DATE_FORMAT_DASH = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat DATE_FORMAT_DAY_TO_SEC = new SimpleDateFormat("ddHHmmss");
    public static final SimpleDateFormat DATE_FORMAT_NON = new SimpleDateFormat("yyyyMMddHHmmss");
    public static final SimpleDateFormat DATE_FORMAT_ORIGINAL = new SimpleDateFormat("yyyyMMdd");
    public static final SimpleDateFormat DATE_FORMAT_SLASH = new SimpleDateFormat("yyyy/MM/dd");
    public static final SimpleDateFormat DATE_TIME_FORMAT_SLASH = new SimpleDateFormat("yyyy/MM/dd HH:mm");

    public static String formatDash(Calendar calendar) {
        return DATE_FORMAT_DASH.format(calendar.getTime());
    }

    public static String formatOriginal(Calendar calendar) {
        return DATE_FORMAT_ORIGINAL.format(calendar.getTime());
    }

    public static String formatNon(Calendar calendar) {
        return DATE_FORMAT_NON.format(calendar.getTime());
    }

    public static String formatDefault(Calendar calendar) {
        return DATE_FORMAT_SLASH.format(calendar.getTime());
    }

    public static String formatDefaultWithDayOfWeek(Calendar calendar) {
        return formatWithDayOfWeek(calendar, DATE_FORMAT_SLASH);
    }

    public static String formatChineseMDWithDayOfWeek(Calendar calendar) {
        return formatWithDayOfWeek(calendar, DATE_FORMAT_CHINESE_MD);
    }

    public static String formatWithDayOfWeek(Calendar calendar, SimpleDateFormat simpleDateFormat) {
        return String.format("%1$s (%2$s)", new Object[]{simpleDateFormat.format(calendar.getTime()), getDayOfWeekText(calendar.get(7))});
    }

    public static String getDayOfWeekText(int i) {
        switch (i) {
            case 0:
                return "六";
            case 1:
                return "日";
            case 2:
                return "一";
            case 3:
                return "二";
            case 4:
                return "三";
            case 5:
                return "四";
            case 6:
                return "五";
            case 7:
                return "六";
            default:
                return Integer.toString(i);
        }
    }

    public static String parserDateFormat(String str) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MM/dd");
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
        return simpleDateFormat2.format(date);
    }

    public static String parserDateFormatSlash(String str) {
        Date date;
        try {
            date = new SimpleDateFormat("yyyyMMdd").parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
        return DATE_FORMAT_SLASH.format(date);
    }

    public static String parserStartSeeTimeFormat(String str) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmm");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm");
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
        return simpleDateFormat2.format(date);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String parserWeek(String r6) {
        /*
            int r0 = r6.hashCode()
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case 49: goto L_0x003f;
                case 50: goto L_0x0035;
                case 51: goto L_0x002b;
                case 52: goto L_0x0021;
                case 53: goto L_0x0017;
                case 54: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0049
        L_0x000d:
            java.lang.String r0 = "6"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 5
            goto L_0x004a
        L_0x0017:
            java.lang.String r0 = "5"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 4
            goto L_0x004a
        L_0x0021:
            java.lang.String r0 = "4"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 3
            goto L_0x004a
        L_0x002b:
            java.lang.String r0 = "3"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 2
            goto L_0x004a
        L_0x0035:
            java.lang.String r0 = "2"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 1
            goto L_0x004a
        L_0x003f:
            java.lang.String r0 = "1"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x0049
            r6 = 0
            goto L_0x004a
        L_0x0049:
            r6 = -1
        L_0x004a:
            if (r6 == 0) goto L_0x0068
            if (r6 == r5) goto L_0x0065
            if (r6 == r4) goto L_0x0062
            if (r6 == r3) goto L_0x005f
            if (r6 == r2) goto L_0x005c
            if (r6 == r1) goto L_0x0059
            java.lang.String r6 = ""
            return r6
        L_0x0059:
            java.lang.String r6 = "六"
            return r6
        L_0x005c:
            java.lang.String r6 = "五"
            return r6
        L_0x005f:
            java.lang.String r6 = "四"
            return r6
        L_0x0062:
            java.lang.String r6 = "三"
            return r6
        L_0x0065:
            java.lang.String r6 = "二"
            return r6
        L_0x0068:
            java.lang.String r6 = "一"
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.cgh.app.util.DateUtils.parserWeek(java.lang.String):java.lang.String");
    }

    public static String parserDayOfWeekText(String str) {
        Calendar instance = Calendar.getInstance();
        try {
            instance.setTime(DATE_FORMAT_ORIGINAL.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return getDayOfWeekText(instance.get(7));
    }

    public static String parserSlashDateFormat(String str) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd");
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            date = null;
        }
        return simpleDateFormat2.format(date);
    }
}

