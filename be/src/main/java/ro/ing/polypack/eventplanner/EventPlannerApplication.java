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
import org.springframework.transaction.annotation.EnableTransactionManagement;
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
@EnableTransactionManagement
@EntityScan("ro.ing.polypack.eventplanner.entities")
@EnableSwagger2
public class EventPlannerApplication extends SpringBootServletInitializer {

    private static Class<EventPlannerApplication> applicationClass = EventPlannerApplication.class;

    public static void main(String[] args) {
        SpringApplication.run(EventPlannerApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(applicationClass);
    }
}
