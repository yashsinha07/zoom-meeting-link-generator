package com.project.zoommeetinglinkgenerator.services;

import com.project.zoommeetinglinkgenerator.DTOs.ZoomMeetingObjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class GenerateMeetingLinkService {

    @Value("${zoom.base.url}")
    private String baseUrl;

    @Value("${zoom.jwt.token}")
    private String jwtToken;

    public ZoomMeetingObjectDTO generateMeetingLink(ZoomMeetingObjectDTO zoomMeetingObjectDTO){

        String meetingLink = baseUrl + "users/me/meetings";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + jwtToken);
        headers.add("content-type", "application/json");
        HttpEntity<ZoomMeetingObjectDTO> httpEntity = new HttpEntity<>(zoomMeetingObjectDTO, headers);
        ResponseEntity<ZoomMeetingObjectDTO> zEntity = restTemplate.exchange(meetingLink, HttpMethod.POST, httpEntity, ZoomMeetingObjectDTO.class);
        if(zEntity.getStatusCodeValue() == 201) {
            log.debug("Zooom meeeting response {}",zEntity);
            return zEntity.getBody();
        } else {
            log.debug("Error while creating zoom meeting {}", zEntity.getStatusCode());
        }

        return zoomMeetingObjectDTO;

    }
}
