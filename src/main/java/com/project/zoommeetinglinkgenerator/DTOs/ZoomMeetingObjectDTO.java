package com.project.zoommeetinglinkgenerator.DTOs;

import com.project.zoommeetinglinkgenerator.enums.Medium;
import com.project.zoommeetinglinkgenerator.enums.Platform;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class ZoomMeetingObjectDTO {

    private String startTime;

    private int duration;

    private String scheduledFor;

    private String timezone;

    private String password;

    private String agenda;

    private Recurrence recurrence;
}
