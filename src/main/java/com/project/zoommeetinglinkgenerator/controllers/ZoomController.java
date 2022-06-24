package com.project.zoommeetinglinkgenerator.controllers;

import com.project.zoommeetinglinkgenerator.DTOs.ZoomMeetingObjectDTO;
import com.project.zoommeetinglinkgenerator.VOs.ZoomMeetingObjectVO;
import com.project.zoommeetinglinkgenerator.services.ZoomMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ZoomController {

    @Autowired
    private ZoomMeetingService zoomMeetingService;

    @PostMapping("/generateMeetingLink")
    public ResponseEntity generateMeetingLink(@RequestBody ZoomMeetingObjectDTO zoomMeetingObjectDTO){

//        if (!zoomMeetingObjectDTO.getPlatform().equals("Zoom") || zoomMeetingObjectDTO.getMedium().equals("Offline"))
//            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);

        ZoomMeetingObjectVO response = zoomMeetingService.createMeeting(zoomMeetingObjectDTO);
        response.setHostEmail(zoomMeetingObjectDTO.getEmailAddress());
        response.setCreatedAt(LocalDateTime.now().toString());
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}
