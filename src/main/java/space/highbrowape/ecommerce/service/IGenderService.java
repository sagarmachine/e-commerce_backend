package space.highbrowape.ecommerce.service;

import space.highbrowape.ecommerce.entity.Gender;

import java.util.List;

public interface IGenderService {

    Gender createGender(String name);

    List<Gender> getGenders();

    void deleteGender(long id);

}
