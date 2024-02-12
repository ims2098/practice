package ru.practice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="person")
@Data @NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Person implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @JsonProperty("id")
    private Integer id;
    
    @Column(name="fname")
    @JsonProperty("fname")
    private String fName;
    
    @Column(name="mname")
    @JsonProperty("mname")
    private String mName;
    
    @Column(name="lname")
    @JsonProperty("lname")
    private String lName;
    
    @Column(name="notes")
    @JsonProperty("notes")
    private String notes;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_department", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Department department;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_profession", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Profession profession;
}
