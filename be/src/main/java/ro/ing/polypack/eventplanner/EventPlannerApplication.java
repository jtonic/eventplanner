package ro.ing.polypack.eventplanner;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ro.ing.polypack.eventplanner.entities.Attachment;
import ro.ing.polypack.eventplanner.entities.Event;
import ro.ing.polypack.eventplanner.entities.EventLocation;
import ro.ing.polypack.eventplanner.entities.Individual;
import ro.ing.polypack.eventplanner.entities.Poll;
import ro.ing.polypack.eventplanner.entities.Rating;
import ro.ing.polypack.eventplanner.repositories.EventRepository;
import ro.ing.polypack.eventplanner.repositories.LocationRepository;
import ro.ing.polypack.eventplanner.repositories.PollRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan("ro.ing.polypack.eventplanner.entities")
@EnableSwagger2
public class EventPlannerApplication extends SpringBootServletInitializer {

    private static Class<EventPlannerApplication> applicationClass = EventPlannerApplication.class;

    private EventRepository eventRepository;
    private PollRepository pollRepository;
    private LocationRepository locationRepository;

    public static void main(String[] args) {
        SpringApplication.run(EventPlannerApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(applicationClass);
    }

    @Autowired
    public void config(EventRepository eventRepository, PollRepository pollRepository, LocationRepository locationRepository
    ) {
        this.eventRepository = eventRepository;
        this.pollRepository = pollRepository;
        this.locationRepository = locationRepository;
    }

    @Bean
    public CommandLineRunner initialize() {
        return (String... strings) -> {
            final EventLocation galati = EventLocation.builder()
                                                         .name("Galati")
                                                         .latitude(45.4379371)
                                                         .longitude(27.9772833)
                                                         .build();
            locationRepository.save(galati);

            final Event event1 = Event.builder()
                                      .host("ING Services S.R.L.")
                                      .title("Event 1")
                                      .description("Event 1 description")
                                      .location(
                                              EventLocation.builder()
                                                           .name("Bucharest")
                                                           .latitude(44.4275073)
                                                           .longitude(26.0851619)
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
                                      .host("DB Technology S.R.L")
                                      .title("Event 2")
                                      .description("Event 2 description")
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
