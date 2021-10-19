package com.footbal.team3.model;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Column;

@Document
@Builder
public class Player {
    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    private String id;
    private int playerNumber;
    private String playerPosition;

    public Player(String id, int playerNumber, String playerPosition) {
        this.id = id;
        this.playerNumber = playerNumber;
        this.playerPosition = playerPosition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }
}
