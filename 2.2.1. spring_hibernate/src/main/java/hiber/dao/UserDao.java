package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user, Car car);
   List<User> listUsers();
   List <User> usersModelSeries (String model, int series);
}
