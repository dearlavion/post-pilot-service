package lavion.dear.mapper;

import lavion.dear.common.EntityMapper;
import lavion.dear.dto.post.PostDTO;
import lavion.dear.dto.post.PostResponse;
import lavion.dear.model.Post;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper extends EntityMapper<PostDTO, Post> {
    List<PostResponse> toPostResponseList(List<Post> posts);
    PostResponse toPostResponse(Post post);
}
