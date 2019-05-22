package project.Daniel.MyTrip.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.Daniel.MyTrip.Model.User;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);
}
