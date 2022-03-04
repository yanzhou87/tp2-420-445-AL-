package library.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("exemplaireBook")
public class ExemplaireBook extends Exemplaire {

    @ManyToOne
    private Book book;

}
