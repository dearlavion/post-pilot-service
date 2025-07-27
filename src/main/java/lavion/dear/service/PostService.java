package lavion.dear.service;

import lavion.dear.dto.post.PostDTO;

import java.util.List;
import java.util.Optional;

public interface PostService {
    PostDTO.PostResponse createPost(PostDTO.PostRequest postRequest);

    Optional<PostDTO.PostResponse> updatePost(String id, PostDTO.PostRequest postRequest);

    List<PostDTO.PostResponse> getPost(String fieldName, String fieldValue);

    Optional<PostDTO.PostResponse> deletePost(String id);
}
