package ro.ing.polypack.eventplanner.rest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ro.ing.polypack.eventplanner.entities.Event;
import ro.ing.polypack.eventplanner.entities.Poll;

@RepositoryRestResource(collectionResourceRel = "polls", path = "polls")
public interface PollResource extends PagingAndSortingRepository<Poll, Long> {

}