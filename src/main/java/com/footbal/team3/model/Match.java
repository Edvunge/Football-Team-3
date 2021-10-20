package com.footbal.team3.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Match {
    @Id
    String id;
    private String description;
    private Date matchDate;
}


















