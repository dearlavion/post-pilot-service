package lavion.dear.post.service;

import lavion.dear.post.dto.PostRequest;
import lavion.dear.post.dto.PostResponse;

import java.util.List;
import java.util.Optional;

public interface PostService {
    PostResponse createPost(PostRequest postRequest);

    Optional<PostResponse> updatePost(String id, PostRequest postRequest);

    List<PostResponse> getPost(String fieldName, String fieldValue);

    Optional<PostResponse> deletePost(String id);
}
