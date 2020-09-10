package com.dayup.seckill.util;

import com.dayup.seckill.entities.Course;

/**
 * Author: 董成杰
 * Date: 2020-09-10 21:42
 * Description:日期工具类
 */
public class DateUtil {
    public static boolean ifBetween(long date, long start, long end) {
        return date >= start && date <= end;
    }

    public static int courseSort(Course o1, Course o2) {
        long now = System.currentTimeMillis();
        long o1Start = o1.getStartTime().getTime();
        long o1End = o1.getEndTime().getTime();
        long o2Start = o2.getStartTime().getTime();
        long o2End = o2.getEndTime().getTime();
        if (ifBetween(now, o1Start, o1End) && DateUtil.ifBetween(now, o2Start, o2End)) {
            return o1End > o2End ? 1 : -1;//两个课程都开始，结束时间早的排在前面
        } else if (DateUtil.ifBetween(now, o2Start, o2End)) {
            return 1;//已开始的课程排在未开始和已结束的前面
        } else if (o1Start > now && o2Start > now) {
            return o1Start > o2Start ? 1 : -1;//都未开始的课程，开始时间早的排在前面
        } else if (o1Start > now) {
            return -1;//已结束的课程排在未开始的后面
        } else {
            return o1End < o2End ? 1 : -1;//两个课程都已结束，结束时间晚的排在前面
        }
    }
}
