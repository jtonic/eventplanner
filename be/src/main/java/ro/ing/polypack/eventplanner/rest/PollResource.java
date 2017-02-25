package ro.ing.polypack.eventplanner.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import ro.ing.polypack.eventplanner.entities.Poll;

@RepositoryRestResource(collectionResourceRel = "polls", path = "polls")
@CrossOrigin(origins = "http://localhost:8080")
public interface PollResource extends JpaRepository<Poll, Long> {

}