package web.services;

import org.springframework.stereotype.Service;
import web.dao.CarDao;

import web.models.Car;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> indexCarsByCount(int count) {

        if (count == 0) {
            return carDao.indexCars();
        } else {
            return carDao
                    .indexCars()
                    .stream()
                    .limit(Math.abs(count))
                    .collect(Collectors.toList());
        }
    }
}

