package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jooq.codegen.maven.example.enums.MpaaRating;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FilmList {
    private Integer fid;
    private String title;
    private String description;
    private String category;
    private Float price;
    private Short length;
    private MpaaRating rating;
    private String actors;
}
