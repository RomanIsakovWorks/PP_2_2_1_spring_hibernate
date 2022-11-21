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

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

      Car car11 = new Car("model11", 11);
      Car car12 = new Car("model12", 12);
      Car car13 = new Car("model13", 13);

      User user11 = new User("User11", "Lastname11", "user11@mail.ru");
      user11.setCar(new Car("model11", 11));

      User user12 = new User("User12", "Lastname12", "user12@mail.ru");
      user12.setCar(new Car("model12", 12));

      User user13 = new User("User13", "Lastname13", "user13@mail.ru");
      user13.setCar(new Car("model13", 13));

      userService.add(user11);
      userService.add(user12);
      userService.add(user13);

      List<User> newUsers = userService.listUsers();

         for (User user : newUsers) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            if (user.getCar() != null) {
               System.out.println("Car model= " + user.getCar().getModel());
               System.out.println("Car series= " + user.getCar().getSeries());
            }
            System.out.println();
         }

         User userForCar = userService.getUserForCar("model11", 11);
         System.out.println("Id = " + userForCar.getId());
         System.out.println("First Name = " + userForCar.getFirstName());
         System.out.println("Last Name = " + userForCar.getLastName());
         System.out.println("Email = " + userForCar.getEmail());
         System.out.println("Car model= " + userForCar.getCar().getModel());
         System.out.println("Car series= " + userForCar.getCar().getSeries());
         System.out.println();

      context.close();
   }
}
