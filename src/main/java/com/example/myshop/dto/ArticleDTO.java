package com.example.myshop.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ArticleDTO {

//    @JsonIgnore
    private Long id;

    @JsonProperty("nombre")
    private String name;

    @JsonProperty("precio")
    private Double price;

    private Long stock;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy hh:mm:ss")
    @JsonProperty("creacion")
    public Date createAt;

}
