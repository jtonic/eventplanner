####How to run the application:

        mvn clean spring-boot:run -P EMBEDDED
        
        
####Contracts:
1. Service REST API

    1. Get all events
    
            curl -v http://localhost:9090/calendar/events 

    1. Get all polls
            
            curl -v http://localhost:9090/calendar/polls 

    1. Get all individuals
            
            curl -v http://localhost:9090/calendar/individuals 
        
    1. Get the location
    
            curl -v http://localhost:9090/calendar/locations
            curl -v http://localhost:9090/calendar/locations?city=bucharest
    
            
##### POST operations
1. Create a location
            
            curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{"name": "Brasov", "latitude": 43.4275073,"longitude": 25.0851619}' "http://localhost:9090/calendar/locations"

1. Create an individual
                
        curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{
            "firstName": "Roxana",
            "lastName": "Adascalului"
        }' "http://localhost:9090/calendar/individuals"
        
1. Create a poll

        curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{
        	"title": "Spring Data REST",
        	"description": "Spring Data REST",
        	"noOfYes": 3,
        	"noOfNo": 99
        }' "http://localhost:9090/calendar/polls"
        
        curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{
        	"title": "Spring HATEOAS",
        	"description": "Spring HATEOAS"
        }' "http://localhost:9090/calendar/polls"
        
1. Create an event 

        curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{
        	"host": "ING Services S.R.L. 2",
        	"description": "Event 2 description",
        	"title": "Event 2"
        }' "http://localhost:9090/calendar/events"
        
        curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{ "host": "Cotroceni","description": "Event 5 description", "title": "Event 5", "location": { "name": "Timisoara", "latitude": 44.4379371, "longitude": 23.9772833}}' "http://localhost:9090/calendar/events"

        curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{ "host": "Cotroceni","description": "Event 6 description", "title": "Event 6", "location": { "name": "Iasi", "latitude": 46.4379371, "longitude": 25.9772833}}' "http://localhost:9090/calendar/events"

 1. Ratting
 
    curl -X PUT -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{"pollId": 1, "yes": true}' "http://localhost:9090/calendar/rating"

        
        
1. Actuator
        
            curl -v http://localhost:9091/management/mappings
            curl -v http://localhost:9091/management/info 
            curl -v http://localhost:9091/management/bean 
    
1. swagger 2

        curl -v http://localhost:9090/calendar/v2/api-docs
        
        
