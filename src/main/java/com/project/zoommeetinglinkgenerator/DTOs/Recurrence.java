package com.project.zoommeetinglinkgenerator.DTOs;

import lombok.Data;

@Data
public class Recurrence {

    private String type;

    private String repeat_interval;

    private String weekly_days;

    private String monthly_day;

    private String monthly_week;

    private String monthly_week_day;

    private String end_times;

    private String end_date_time;
}
