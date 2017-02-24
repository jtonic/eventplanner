package ro.ing.polypack.eventplanner.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;

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
@Embeddable
public class EventLocation {
    private String name;
    private Double latitude;
    private Double longitude;
}
