package space.highbrowape.ecommerce.service;

import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.highbrowape.ecommerce.entity.Gender;
import space.highbrowape.ecommerce.exception.AlreadyExistException;
import space.highbrowape.ecommerce.exception.NotFoundException;
import space.highbrowape.ecommerce.repository.GenderRepository;

import java.util.List;


@Service
@Slf4j
public class GenderServiceImpl implements IGenderService {


    @Autowired
    GenderRepository genderRepository;


    @Override
    public Gender createGender(String name) {

        try{
        return genderRepository.save(Gender.builder().value(name.toUpperCase()).build());
        }catch (Exception ex){
            log.info(ex.getMessage());
            throw new AlreadyExistException("gender "+name.toUpperCase()+" already exist");
        }
    }

    @Override
    public List<Gender> getGenders() {
        return genderRepository.findAll();
    }

    @Override
    public void deleteGender(long id) {
        try{
             genderRepository.deleteById(id);
        }catch (Exception ex){
            log.info(ex.getMessage());
            throw new NotFoundException("gender with "+id+" does not exist");
        }
    }
}
