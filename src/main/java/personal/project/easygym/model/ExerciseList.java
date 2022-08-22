package personal.project.easygym.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "tbl_exercise_list")
public class ExerciseList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="exercise_list_id")
    private Long ID;

    @OneToOne
    @JoinColumn(name = "client_id")
    Client client;

    @ManyToMany
    @JoinTable(name = "tbl_client_exercises", 
    joinColumns = @JoinColumn(name="exercise_list_id"), 
    inverseJoinColumns = @JoinColumn(name="exercise_id"))
    private List<Exercise> exercises = new ArrayList<Exercise>();

    private LocalDate created;
    
    private boolean isValid;
}
