package ma.enset.patientsmvc.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String code;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat (pattern ="yyyy-MM-dd")
    private Date dateNaissance;
    private boolean malade;
    private int score;



}
