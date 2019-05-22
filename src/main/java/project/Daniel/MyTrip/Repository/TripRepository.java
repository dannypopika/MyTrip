package project.Daniel.MyTrip.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.Daniel.MyTrip.Model.Trip;
import project.Daniel.MyTrip.Model.User;

import java.util.List;

@Repository("TripRepository")
public interface TripRepository extends JpaRepository<Trip, Integer> {
   List<Trip> findByUser(@Param("user_id")User user);
}
