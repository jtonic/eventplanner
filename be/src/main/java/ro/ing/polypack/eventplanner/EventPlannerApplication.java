package ro.ing.polypack.eventplanner;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ro.ing.polypack.eventplanner.entities.Attachment;
import ro.ing.polypack.eventplanner.entities.Event;
import ro.ing.polypack.eventplanner.entities.EventLocation;
import ro.ing.polypack.eventplanner.entities.Individual;
import ro.ing.polypack.eventplanner.entities.Poll;
import ro.ing.polypack.eventplanner.entities.Rating;
import ro.ing.polypack.eventplanner.repositories.EventRepository;
import ro.ing.polypack.eventplanner.repositories.PollRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan("ro.ing.polypack.eventplanner.entities")
public class EventPlannerApplication {

    private EventRepository eventRepository;
    private PollRepository pollRepository;

    public static void main(String[] args) {
        SpringApplication.run(EventPlannerApplication.class, args);
    }

    @Autowired
    public void config(EventRepository eventRepository, PollRepository pollRepository) {
        this.eventRepository = eventRepository;
        this.pollRepository = pollRepository;
    }

    @Bean
    public CommandLineRunner initialize() {
        return (String... strings) -> {
            final Event event1 = Event.builder()
                                      .title("Event 1")
                                      .description("Event 1 description")
                                      .location(
                                              EventLocation.builder()
                                                           .name("Bucharest")
                                                           .latitude(111111111111d)
                                                           .longitude(22222222222d)
                                                           .build()
                                      )
                                      .build();
            event1.setAttachments(Sets.newHashSet(
                    Attachment.builder().name("file11.txt").mime("text/plain").build(),
                    Attachment.builder().name("file12.txt").mime("text/plain").build()
            ));
            event1.setParticipants(Sets.newHashSet(
                    Individual.builder().firstName("Antonel").lastName("Pazargic").build(),
                    Individual.builder().firstName("Irina").lastName("Pazargic").build()
            ));
            event1.setRatings(Sets.newHashSet(
                    Rating.builder()
                          .author(Individual.builder().firstName("Antonel").lastName("Pazargic").build())
                          .stars((byte) 3)
                          .build(),
                    Rating.builder()
                          .author(Individual.builder().firstName("Irina").lastName("Pazargic").build())
                          .stars((byte) 4)
                          .build()
            ));
            final Event event2 = Event.builder()
                                      .title("Event 2")
                                      .description("Event 2 description")
                                      .location(
                                              EventLocation.builder()
                                                           .name("Bucharest")
                                                           .latitude(3333333333333d)
                                                           .longitude(444444444444d)
                                                           .build()
                                      )
                                      .build();

            event2.setAttachments(Sets.newHashSet(
                    Attachment.builder().name("file21.txt").mime("text/plain").build(),
                    Attachment.builder().name("file22.txt").mime("text/plain").build()
            ));
            event2.setParticipants(Sets.newHashSet(
                    Individual.builder().firstName("Liviu").lastName("Pazargic").build(),
                    Individual.builder().firstName("Magdalena").lastName("Jipa").build()
            ));
            event2.setRatings(Sets.newHashSet(
                    Rating.builder()
                          .author(Individual.builder().firstName("Liviu").lastName("Pazargic").build())
                          .stars((byte) 3)
                          .build(),
                    Rating.builder()
                          .author(Individual.builder().firstName("Magdalena").lastName("Jipa").build())
                          .stars((byte) 4)
                          .build()
            ));
            final List<Event> events = Arrays.asList(event1, event2);
            this.eventRepository.save(events);

            final Poll poll1 = Poll.builder()
                                   .title("Building microservices with Spring boot and Kotlin")
                                   .description("Building microservices with Spring boot and Kotlin")
                                   .noOfYes(100)
                                   .noOfNo(2)
                                   .build()
            ;

            final Poll poll2 = Poll.builder()
                                   .title("Building microservices with Scala and Spray")
                                   .description("Building microservices with Scala and Spray")
                                   .noOfYes(3)
                                   .noOfNo(99)
                                   .build()
            ;
            Set<Poll> polls = Sets.newHashSet(poll1, poll2);
            this.pollRepository.save(polls);
        };
    }

}
