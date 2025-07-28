package lavion.dear.common;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

public interface EntityMapper<D, E> {
    E toEntity(D dtoRequest);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDtoRequest(D dtoRequest, @MappingTarget E entity);
    List<E> toEntity(List<D> dtoRequestList);

}