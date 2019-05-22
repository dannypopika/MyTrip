package project.Daniel.MyTrip.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import project.Daniel.MyTrip.Model.Trip;
import project.Daniel.MyTrip.Model.TripWrapper;
import project.Daniel.MyTrip.Model.User;
import project.Daniel.MyTrip.Service.StorageService;
import project.Daniel.MyTrip.Service.TripService;
import project.Daniel.MyTrip.Service.UserService;
import javax.validation.Valid;


@Controller
@RequestMapping("home/trip")
public class TripController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private UserService userService;

    @Autowired
    private TripService tripService;

    @RequestMapping(value = {"/add_trip"}, method = RequestMethod.GET)
    public ModelAndView trip() {
        ModelAndView model = new ModelAndView();
        Trip trip = new Trip();
        model.addObject("trip", trip);
        model.setViewName("trip/add_trip");
        return model;
    }

    @RequestMapping(value = {"/add_trip"}, method = RequestMethod.POST)
    public ModelAndView createTrip(@Valid TripWrapper tripWrapper) {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByUserName(auth.getName());
        Trip trip = new Trip();
        trip.setUser(user);
        trip.setTripName(tripWrapper.getTitle());
        trip.setPicture("/temp/"+ user.getId() + trip.getTripName()+ ".jpg");
        trip.setEndDate(tripWrapper.getEndDate());
        trip.setStartDate(tripWrapper.getStartDate());
        trip.setPictureDetails(tripWrapper.getPictureDetails());
        trip.setImpressions(tripWrapper.getImpressions());
        storageService.store(tripWrapper.getPicture(),user,trip);
        tripService.saveTrip(trip);
        return new ModelAndView("redirect:http://localhost:8080/home");
    }

    @RequestMapping(value = {"/trip{id}"}, method = RequestMethod.GET)
    public ModelAndView getTrip(@RequestParam(value = "id") int id) {
        ModelAndView model = new ModelAndView();
        Trip trip = tripService.findTripById(id);
        model.addObject("trip", trip);
        model.setViewName("trip/trip");
        return model;
    }
}
