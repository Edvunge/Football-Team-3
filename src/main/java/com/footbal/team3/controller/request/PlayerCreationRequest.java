package com.footbal.team3.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerCreationRequest {
    private int playerNumber;
    private String playerPosition;
    private String name;
}
