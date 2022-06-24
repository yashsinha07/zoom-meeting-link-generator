package com.project.zoommeetinglinkgenerator.DTOs;

import lombok.Data;

@Data
public class ZoomMeetingObjectDTO {

    private String title;

    private String medium;

    private String fromDate;

    private String fromTime;

    private String toDate;

    private String toTime;

    private String emailAddress;

    private String platform;

    private String description;
}
