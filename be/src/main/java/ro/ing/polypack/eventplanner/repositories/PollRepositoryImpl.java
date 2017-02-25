package ro.ing.polypack.eventplanner.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import ro.ing.polypack.eventplanner.entities.Poll;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * Created by Antonel Ernest Pazargic on 25/02/2017.
 *
 * @author Antonel Ernest Pazargic
 */
public class PollRepositoryImpl implements CustomPollRepository {

    private EntityManager entityManager;

    @Autowired
    public void config(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveRating(Long id, boolean yes) {
        final Poll poll = entityManager.find(Poll.class, id);
        if(yes) {
            poll.setNoOfYes(poll.getNoOfYes() + 1);
        } else {
            poll.setNoOfYes(poll.getNoOfYes() + 1);
        }
    }
}
