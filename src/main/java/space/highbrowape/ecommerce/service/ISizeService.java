package space.highbrowape.ecommerce.service;

import space.highbrowape.ecommerce.entity.Gender;
import space.highbrowape.ecommerce.entity.Size;

import java.util.List;

public interface ISizeService {


    Size createSize(String name);

    List<Size> getSizes();

    void deleteSize(long id);

}
