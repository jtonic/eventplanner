package ro.ing.polypack.eventplanner.repositories;

/**
 * Created by Antonel Ernest Pazargic on 25/02/2017.
 *
 * @author Antonel Ernest Pazargic
 */
public interface CustomPollRepository {

    void saveRating(Long id, boolean yes);
}
