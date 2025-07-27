package lavion.dear.mapper;

import lavion.dear.common.EntityMapper;
import lavion.dear.dto.post.PostDTO;
import lavion.dear.model.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper extends EntityMapper<PostDTO, Post> {
}
