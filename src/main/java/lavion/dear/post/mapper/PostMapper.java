package lavion.dear.post.mapper;

import lavion.dear.common.EntityMapper;
import lavion.dear.post.dto.PostDTO;
import lavion.dear.post.model.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper extends EntityMapper<PostDTO, Post> {
}
