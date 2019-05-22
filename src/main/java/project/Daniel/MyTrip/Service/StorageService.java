package project.Daniel.MyTrip.Service;

import org.springframework.web.multipart.MultipartFile;
import project.Daniel.MyTrip.Model.Trip;
import project.Daniel.MyTrip.Model.User;

public interface StorageService {
    void createDirectory();
    public void store(MultipartFile file, User user, Trip trip);
}
