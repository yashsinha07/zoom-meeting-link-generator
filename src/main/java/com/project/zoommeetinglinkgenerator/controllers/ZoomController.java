package com.project.zoommeetinglinkgenerator.controllers;

import com.project.zoommeetinglinkgenerator.DTOs.MeetingFormDTO;
import com.project.zoommeetinglinkgenerator.services.GenerateMeetingLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZoomController {

    @Autowired
    private GenerateMeetingLinkService generateMeetingLinkService;

    @PostMapping("/generateMeetingLink")
    public ResponseEntity generateMeetingLink(@RequestBody MeetingFormDTO meetingFormDTO){

        if (!meetingFormDTO.getPlatform().equals("Zoom") || meetingFormDTO.getMedium().equals("Offline"))
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);

        String meetingLink = generateMeetingLinkService.generateMeetingLink();

        return ResponseEntity.ok(meetingLink);
    }
}
