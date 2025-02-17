package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru")
              , new Car("BMW", 6));

      userService.add(new User("User2", "Lastname2", "user2@mail.ru")
      ,new Car ("Mercedes", 11));

      userService.add(new User("User3", "Lastname3", "user3@mail.ru")
      ,new Car ("Volkswagen", 16));

      userService.add(new User("User4", "Lastname4", "user4@mail.ru")
      , new Car ("Honda", 8));



      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("CarModel = " + user.getCar().getModel());
         System.out.println("CarSeries = " + user.getCar().getSeries());
         System.out.println();
      }

      List <User> usersListCar = userService.usersModelSeries("Mercedes", 11);
      for (User user : usersListCar) {
         System.out.println("Пользователь c автомомбилем Mercedes  " +user.getFirstName());
      }





      context.close();
   }
}
