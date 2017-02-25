####How to run the application:

        
        
####Contracts:
1. Service REST API

    1. Get all events
    
            curl -v http://localhost:9090/calendar/events 

    1. Get all polls
            
            curl -v http://localhost:9090/calendar/polls 
        
    1. Get the location
    
            curl -v http://localhost:9090/calendar/locations
            curl -v http://localhost:9090/calendar/locations?city=bucharest
            
    1. Create a location
            
            curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{
            	"name": "Brasov",
            	"latitude": 44.4275073,
            	"longitude": 26.0851619
            }' "http://localhost:9090/calendar/locations"
                    
        
1. Actuator
    info
        curl -v http://localhost:9090/calendar/info 
        
    mapping
    
    beans
    
1. swagger 2

        curl -v http://localhost:9090/calendar/v2/api-docs
        
        
####How to run the application:

        mvn clean spring-boot:run -P EMBEDDED