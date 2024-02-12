package ru.practice.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class PersonDto {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("fName")
    private String fName;
    
    @JsonProperty("mName")
    private String mName;
    
    @JsonProperty("lName")
    private String lName;
    
    @JsonProperty("department")
    private String department;
    
    @JsonProperty("departmentId")
    private Integer departmentId;
    
    @JsonProperty("profession")
    private String profession;
    
    @JsonProperty("professionId")
    private Integer professionId;
    
    @JsonProperty("notes")
    private String notes;
    
}
