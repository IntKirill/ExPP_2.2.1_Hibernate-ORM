package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user, Car car);
    List<User> listUsers();
    public List<User> usersModelSeries(String model, int series);

}
