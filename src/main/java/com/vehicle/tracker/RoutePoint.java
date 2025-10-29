package com.vehicle.tracker;




// data-only class. This is perfect for a DTO (Data Transfer Object).
public record RoutePoint(
        double latitude,
        double longitude,
        String timestamp
) {}