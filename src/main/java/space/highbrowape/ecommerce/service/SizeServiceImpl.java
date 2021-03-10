package space.highbrowape.ecommerce.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.highbrowape.ecommerce.entity.Size;
import space.highbrowape.ecommerce.entity.Size;
import space.highbrowape.ecommerce.exception.AlreadyExistException;
import space.highbrowape.ecommerce.exception.NotFoundException;
import space.highbrowape.ecommerce.repository.SizeRepository;

import java.util.List;

@Service
@Slf4j
public class SizeServiceImpl implements ISizeService {
    @Autowired
    SizeRepository sizeRepository;


    @Override
    public Size createSize(String name) {

        try{
            return sizeRepository.save(Size.builder().value(name.toUpperCase()).build());
        }catch (Exception ex){
            log.info(ex.getMessage());
            throw new AlreadyExistException("size "+name.toUpperCase()+" already exist");
        }
    }

    @Override
    public List<Size> getSizes() {
        return sizeRepository.findAll();
    }

    @Override
    public void deleteSize(long id) {
        try{
            sizeRepository.deleteById(id);
        }catch (Exception ex){
            log.info(ex.getMessage());
            throw new NotFoundException("size with "+id+" does not exist");
        }
    }
}
