package com.example.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * 定时任务的练习
 * <p>
 * Created by user on 2017/4/20.
 */
@Component
public class ScheduledTasks {


    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm");


    /**
     * 具体的使用规则:
     *
     * @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
     * @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
     * @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
     * @Scheduled(cron="") ：通过cron表达式定义规则
     */

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {


        System.out.println("现在的时间:" + dateFormat.format(new Date()));
    }


}
