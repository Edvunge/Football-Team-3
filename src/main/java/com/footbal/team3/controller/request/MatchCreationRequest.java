package com.footbal.team3.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MatchCreationRequest {
    private String description;
    private Date matchDate;
}
