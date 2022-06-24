package com.project.zoommeetinglinkgenerator.DTOs;

import com.project.zoommeetinglinkgenerator.enums.Medium;
import com.project.zoommeetinglinkgenerator.enums.Platform;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class MeetingFormDTO {

    private String title;

    private Medium medium;

    private LocalDate fromDate;

    private LocalTime fromTime;

    private LocalDate toDate;

    private LocalTime toTime;

    private String emailAddress;

    private Platform platform;

    private String description;

}
