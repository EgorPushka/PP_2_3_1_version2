package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    private final List<Car> cars;

    public CarDaoImpl() {
        cars = new ArrayList<>();
        cars.add(new Car("DeLorean DMC-12", "silver", 1981));
        cars.add(new Car("Batmobile", "black", 1966));
        cars.add(new Car("Aston Martin DB5", "silver", 1964));
        cars.add(new Car("Star Destroyer", "black", 3981));
        cars.add(new Car("Millennium Falcon", "grey", 3981));
    }

    @Override
    public List<Car> indexCars() {
        return cars;
    }
}
