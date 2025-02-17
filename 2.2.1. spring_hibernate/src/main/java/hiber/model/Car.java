package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long car_id;


    public void setUser(User user) {
        this.user = user;
    }

    @OneToOne
    @JoinColumn (name = "user_id")
    private User user;

    public Car() {}

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public long getCar_id() {
        return car_id;
    }

    public void setCar_id(long car_id) {
        this.car_id = car_id;
    }


}
