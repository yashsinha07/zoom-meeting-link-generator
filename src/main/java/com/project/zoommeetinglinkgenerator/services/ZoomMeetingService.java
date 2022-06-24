package com.project.zoommeetinglinkgenerator.services;

import com.project.zoommeetinglinkgenerator.DTOs.ZoomMeetingObjectDTO;
import com.project.zoommeetinglinkgenerator.VOs.ZoomMeetingObjectVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ZoomMeetingService {

    @Value("${zoom.base.url}")
    private String baseUrl;

    @Value("${zoom.jwt.token}")
    private String jwtToken;

    public ZoomMeetingObjectVO createMeeting(ZoomMeetingObjectDTO zoomMeetingObjectDTO){

        String meetingLink = baseUrl + "users/me/meetings";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + jwtToken);
        headers.add("content-type", "application/json");
        HttpEntity<ZoomMeetingObjectDTO> httpEntity = new HttpEntity<>(zoomMeetingObjectDTO, headers);

        ResponseEntity<ZoomMeetingObjectVO> zEntity = restTemplate.exchange(meetingLink, HttpMethod.POST, httpEntity, ZoomMeetingObjectVO.class);
        if(zEntity.getStatusCodeValue() != 201)
            log.debug("Error while creating zoom meeting {}", zEntity.getStatusCode());

        log.debug("Zoom meeting response {}",zEntity);
        return zEntity.getBody();
    }
}
