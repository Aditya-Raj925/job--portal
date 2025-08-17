
package com.example.jobportal.model;
import jakarta.persistence.*;

@Entity
public class Job {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String company;
    private String location;
    @Column(length=2000)
    private String description;
    private String type;

    public Job() {}

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getTitle(){return title;}
    public void setTitle(String t){this.title=t;}
    public String getCompany(){return company;}
    public void setCompany(String c){this.company=c;}
    public String getLocation(){return location;}
    public void setLocation(String l){this.location=l;}
    public String getDescription(){return description;}
    public void setDescription(String d){this.description=d;}
    public String getType(){return type;}
    public void setType(String t){this.type=t;}
}
