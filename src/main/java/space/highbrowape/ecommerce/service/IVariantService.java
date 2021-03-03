package space.highbrowape.ecommerce.service;

import org.springframework.web.multipart.MultipartFile;
import space.highbrowape.ecommerce.dto.request.VariantDto;
import space.highbrowape.ecommerce.entity.Image;
import space.highbrowape.ecommerce.entity.Variant;

import java.util.List;

public interface IVariantService {
    Variant addVariantBody(VariantDto addVariantDto);

    Variant addVariantImages(long id, MultipartFile[] files);

    Variant updateVariantBody(VariantDto addVariantDto);

    Variant  updateVariantImages(long id, MultipartFile[] files);

    String deleteVariant(Long id);

    List<Variant> getAllProductVariants(Long id);

    Variant getVariant(long id);
}
