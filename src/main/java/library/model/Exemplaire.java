package library.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("exemplaire")
//@EqualsAndHashCode(exclude = "article")
public class Exemplaire extends Article{

    @ManyToOne
    private Article article;
    private boolean possible = false;


}
