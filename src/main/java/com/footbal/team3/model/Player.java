package com.footbal.team3.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Column;
import javax.persistence.Id;


@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Player {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private int playerNumber;
    private String playerPosition;
    private String playerName;
}
