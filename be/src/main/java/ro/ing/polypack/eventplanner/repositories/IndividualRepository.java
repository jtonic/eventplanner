package ro.ing.polypack.eventplanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.ing.polypack.eventplanner.entities.Individual;

/**
 * Created by Antonel Ernest Pazargic on 24/02/2017.
 *
 * @author Antonel Ernest Pazargic
 */
public interface IndividualRepository extends JpaRepository<Individual, Long> {

}
