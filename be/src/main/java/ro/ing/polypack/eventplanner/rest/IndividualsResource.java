package ro.ing.polypack.eventplanner.rest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import ro.ing.polypack.eventplanner.entities.Individual;
import ro.ing.polypack.eventplanner.entities.Poll;

@RepositoryRestResource(collectionResourceRel = "individuals", path = "individuals")
@CrossOrigin(origins = "http://localhost:8080")
public interface IndividualsResource extends JpaRepository<Individual, Long> {

}