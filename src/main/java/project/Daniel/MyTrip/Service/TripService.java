package project.Daniel.MyTrip.Service;

import project.Daniel.MyTrip.Model.Trip;
import project.Daniel.MyTrip.Model.User;
import java.util.List;


public interface TripService {
    List<Trip> findTripsByUserId(User user);
    public void saveTrip (Trip trip);
    Trip findTripById(Integer id);
       }
