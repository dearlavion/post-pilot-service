package lavion.dear.service;

import lavion.dear.dto.post.PostDTO;
import lavion.dear.dto.post.PostRequest;
import lavion.dear.dto.post.PostResponse;

import java.util.List;
import java.util.Optional;

public interface PostService {
    PostResponse createPost(PostRequest postRequest);

    Optional<PostResponse> updatePost(String id, PostRequest postRequest);

    List<PostResponse> getPost(String fieldName, String fieldValue);

    Optional<PostResponse> deletePost(String id);
}
