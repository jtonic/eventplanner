package ro.ing.polypack.eventplanner.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ro.ing.polypack.eventplanner.model.LocationDto;

/**
 * Created by Antonel Ernest Pazargic on 24/02/2017.
 *
 * @author Antonel Ernest Pazargic
 */
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class LocationResource {

    @RequestMapping("/location")
    public LocationDto getLocation(@RequestParam(value = "city", required = false) String city) {
        String cty = city != null ? city : "Bucharest";
        System.out.println("city = " + cty);
        return LocationDto.builder().latitude(44.4275073).longitude(26.0851619).build();
    }

}
