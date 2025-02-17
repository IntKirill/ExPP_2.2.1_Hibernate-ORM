package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   @Transactional
   public void add(User user, Car car) {
      user.setCar(car);
      car.setUser(user);
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public List<User> usersModelSeries(String model, int series) {
      Query query=sessionFactory.getCurrentSession().createQuery
              ("SELECT u FROM User u JOIN u.car c WHERE c.model = :model AND c.series = :series", User.class );
      query.setParameter("model", model);  // Передаем значение для параметра "model"
      query.setParameter("series", series);
      return query.getResultList();
   }



}
