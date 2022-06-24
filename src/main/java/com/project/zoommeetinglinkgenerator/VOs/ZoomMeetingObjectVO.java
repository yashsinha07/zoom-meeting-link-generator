package com.project.zoommeetinglinkgenerator.VOs;

import lombok.Data;

@Data
public class ZoomMeetingObjectVO {

    private String hostEmail;

    private Long id;

    private String createdAt;

    private String join_url;

    private String password;

    private String start_url;
}
