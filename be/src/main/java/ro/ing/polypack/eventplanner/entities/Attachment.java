package ro.ing.polypack.eventplanner.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Antonel Ernest Pazargic on 24/02/2017.
 *
 * @author Antonel Ernest Pazargic
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
public class Attachment {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String mime;
}
