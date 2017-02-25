package ro.ing.polypack.eventplanner.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Antonel Ernest Pazargic on 25/02/2017.
 *
 * @author Antonel Ernest Pazargic
 */
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class RatingDto {

    private Long pollId;
    private Boolean yes;

}
