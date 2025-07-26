package lavion.dear.common;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

//@Mapper(componentModel = "spring")
public interface EntityMapper<D, E> {
    E toEntity(D dto);
    D toDtoResponse(E entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDtoRequest(D dtoRequest, @MappingTarget E entity);
    List<E> toEntity(List<D> dtoRequestList);
    List<D> toDtoResponse(List<E> entityList);

}