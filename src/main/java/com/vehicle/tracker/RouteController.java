package com.vehicle.tracker;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RouteController {

    @GetMapping("/route")
    // @CrossOrigin is CRITICAL. It allows our React app (on port 5173)
    // to request data from this Spring Boot server (on port 8080).
    @CrossOrigin(origins = "*")
    public List<RoutePoint> getVehicleRoute() {
        // We are hard-coding the dummy route data here,
        // just like in the 'dummy-route.json' example.
        return List.of(
                new RoutePoint(17.385044, 78.486671, "2024-07-20T10:00:00Z"),
                new RoutePoint(17.385200, 78.486800, "2024-07-20T10:00:10Z"),
                new RoutePoint(17.385450, 78.487100, "2024-07-20T10:00:20Z"),
                new RoutePoint(17.385700, 78.487400, "2024-07-20T10:00:30Z"),
                new RoutePoint(17.386000, 78.488000, "2024-07-20T10:00:40Z"),
                new RoutePoint(17.386300, 78.488600, "2024-07-20T10:00:50Z"),
                new RoutePoint(17.386600, 78.489200, "2024-07-20T10:01:00Z"),
                new RoutePoint(17.386900, 78.489800, "2024-07-20T10:01:10Z"),
                new RoutePoint(17.387200, 78.490400, "2024-07-20T10:01:20Z"),
                new RoutePoint(17.387500, 78.491000, "2024-07-20T10:01:30Z"),
                new RoutePoint(17.387800, 78.491600, "2024-07-20T10:01:40Z"),
                new RoutePoint(17.388100, 78.492200, "2024-07-20T10:01:50Z"),
                new RoutePoint(17.388400, 78.492800, "2024-07-20T10:02:00Z")
        );
    }
}