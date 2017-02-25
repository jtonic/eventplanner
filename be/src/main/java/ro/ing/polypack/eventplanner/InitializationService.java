package ro.ing.polypack.eventplanner;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ro.ing.polypack.eventplanner.entities.Attachment;
import ro.ing.polypack.eventplanner.entities.Event;
import ro.ing.polypack.eventplanner.entities.EventLocation;
import ro.ing.polypack.eventplanner.entities.Individual;
import ro.ing.polypack.eventplanner.entities.Poll;
import ro.ing.polypack.eventplanner.repositories.EventRepository;
import ro.ing.polypack.eventplanner.repositories.IndividualRepository;
import ro.ing.polypack.eventplanner.repositories.LocationRepository;
import ro.ing.polypack.eventplanner.repositories.PollRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by Antonel Ernest Pazargic on 25/02/2017.
 *
 * @author Antonel Ernest Pazargic
 */
@Service
public class InitializationService implements CommandLineRunner {

    private EventRepository eventRepository;
    private PollRepository pollRepository;
    private LocationRepository locationRepository;
    private IndividualRepository individualRepository;

    @Autowired
    public void config(EventRepository eventRepository, PollRepository pollRepository, LocationRepository locationRepository, IndividualRepository individualRepository
    ) {
        this.eventRepository = eventRepository;
        this.pollRepository = pollRepository;
        this.locationRepository = locationRepository;
        this.individualRepository = individualRepository;
    }

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        final List<EventLocation> locations = saveLocations();
        final List<Individual> individuals = saveIndividuals();
        saveEvents(locations, individuals);
        savePolls();
    }

    private void saveEvents(List<EventLocation> locations, List<Individual> individuals) {
        final Event event1 = Event.builder()
                                  .host("ING Services S.R.L.")
                                  .title("Event 1")
                                  .description("Event 1 description")
                                  .attachments(Sets.newHashSet(
                                          Attachment.builder().name("file11.txt").mime("text/plain").build(),
                                          Attachment.builder().name("file12.txt").mime("text/plain").build()
                                  ))
                                  .location(locations.get(0))
                                  .participants(Sets.newHashSet(individuals.get(0), individuals.get(1)))
                                  .build();
        final Event event2 = Event.builder()
                                  .host("DB Technology S.R.L")
                                  .title("Event 2")
                                  .description("Event 2 description")
                                  .attachments(Sets.newHashSet(
                                          Attachment.builder().name("file21.txt").mime("text/plain").build(),
                                          Attachment.builder().name("file22.txt").mime("text/plain").build()
                                  ))
                                  .location(locations.get(1))
                                  .participants(Sets.newHashSet(individuals.get(2), individuals.get(3)))
                                  .build();
        final List<Event> events = Arrays.asList(event1, event2);
        this.eventRepository.save(events);
    }

    private void savePolls() {
        final Poll poll1 = Poll.builder()
                               .title("Building microservices with Spring boot and Kotlin")
                               .description("Building microservices with Spring boot and Kotlin")
                               .noOfYes(100)
                               .noOfNo(2)
                               .build();

        final Poll poll2 = Poll.builder()
                               .title("Building microservices with Scala and Spray")
                               .description("Building microservices with Scala and Spray")
                               .noOfYes(3)
                               .noOfNo(99)
                               .build();
        Set<Poll> polls = Sets.newHashSet(poll1, poll2);
        this.pollRepository.save(polls);
    }

    private List<EventLocation> saveLocations() {
        final EventLocation galati = EventLocation.builder()
                                                  .name("Galati")
                                                  .latitude(45.4379371)
                                                  .longitude(27.9772833)
                                                  .build();
        final EventLocation bucharest = EventLocation.builder()
                                                     .name("Bucharest")
                                                     .latitude(44.4275073)
                                                     .longitude(26.0851619)
                                                     .build();
        locationRepository.save(Lists.newArrayList(galati, bucharest));
        return Lists.newArrayList(galati, bucharest);
    }

    private List<Individual> saveIndividuals() {
        final Individual antonel = Individual.builder().firstName("Antonel").lastName("Pazargic").build();
        final Individual irina = Individual.builder().firstName("Irina").lastName("Pazargic").build();
        final Individual liviu = Individual.builder().firstName("Liviu").lastName("Pazargic").build();
        final Individual magda = Individual.builder().firstName("Magdalena").lastName("Jipa").build();
        final Set<Individual> individuals = Sets.newHashSet(antonel, irina, liviu, magda);
        individualRepository.save(individuals);
        return Lists.newArrayList(antonel, irina, liviu, magda);
    }
}
