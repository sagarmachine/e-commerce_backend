package space.highbrowape.ecommerce.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import space.highbrowape.ecommerce.dto.request.VariantDto;
import space.highbrowape.ecommerce.entity.Variant;

import java.util.List;

@Service
public class VariantServiceImpl implements IVariantService {

    @Override
    public Variant addVariantBody(VariantDto addVariantDto) {
        return null;
    }

    @Override
    public Variant addVariantImages(long id, MultipartFile[] files) {
        return null;
    }

    @Override
    public Variant updateVariantBody(VariantDto addVariantDto) {
        return null;
    }

    @Override
    public Variant updateVariantImages(long id, MultipartFile[] files) {
        return null;
    }

    @Override
    public String deleteVariant(Long id) {
        return null;
    }

    @Override
    public List<Variant> getAllProductVariants(Long id) {
        return null;
    }

    @Override
    public Variant getVariant(long id) {
        return null;
    }
}
