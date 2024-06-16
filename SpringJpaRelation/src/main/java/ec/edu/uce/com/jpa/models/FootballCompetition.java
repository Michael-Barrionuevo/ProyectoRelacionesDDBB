package ec.edu.uce.com.jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FootballCompetition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",columnDefinition = "VARCHAR(300)")
    private String name;

    @Column(name = "cuantity_price")
    private Integer cuantityPrize;

    @Column(name = "start_date",columnDefinition = "DATE")
    private LocalDate starDate;

    @Column(name = "end_time",columnDefinition = "DATE")
    private LocalDate endDate;

    //@ManyToMany(targetEntity = Club.class, fetch = FetchType.LAZY)
    //private List<Club>clubs;

    public FootballCompetition( long id,String name, Integer cuantityPrize, LocalDate starDate, LocalDate endDate) {
        this.name = name;
        this.id = id;
        this.cuantityPrize=cuantityPrize;
        this.starDate=starDate;
        this.endDate=endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCuantityPrize() {
        return cuantityPrize;
    }

    public void setCuantityPrize(Integer cuantityPrize) {
        this.cuantityPrize = cuantityPrize;
    }

    public LocalDate getStarDate() {
        return starDate;
    }

    public void setStarDate(LocalDate starDate) {
        this.starDate = starDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "FootballCompetition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cuantityPrize=" + cuantityPrize +
                ", starDate=" + starDate +
                ", endDate=" + endDate +
                '}';
    }
}
