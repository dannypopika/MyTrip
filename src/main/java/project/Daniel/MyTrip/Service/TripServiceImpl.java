package project.Daniel.MyTrip.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.Daniel.MyTrip.Model.Trip;
import project.Daniel.MyTrip.Model.User;
import project.Daniel.MyTrip.Repository.TripRepository;
import java.util.List;

@Service("tripService")
public class TripServiceImpl implements TripService {
    @Autowired
    private TripRepository tripRepository;

    @Override
    public List<Trip> findTripsByUserId(User user) {
        return tripRepository.findByUser(user);
    }

    @Override
    public Trip findTripById(Integer id) {
        return tripRepository.findById(id).orElse(null);
    }

    @Override
    public void saveTrip(Trip trip) {
                tripRepository.save(trip);
    }

}
