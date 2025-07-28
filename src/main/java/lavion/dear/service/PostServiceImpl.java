package lavion.dear.service;

import lavion.dear.dto.post.PostRequest;
import lavion.dear.dto.post.PostResponse;
import lavion.dear.mapper.PostMapper;
import lavion.dear.model.Post;
import lavion.dear.repository.PostRepository;
import lavion.dear.dto.user.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository repository;
    private final PostMapper mapper;
    @Autowired
    private MongoTemplate mongoTemplate;


    public void post(UserRequest userRequest) {
        //authenticate user
        //retrieve files to post
        //retrieve social media channels
        //trigger post
        //retrieve notification channels
        //notify user AND admin
    }

    @Override
    public PostResponse createPost(PostRequest postRequest) {
        Post post = mapper.toEntity(postRequest);
        Post saved = repository.save(post);
        return  mapper.toPostResponse(saved);

    }

    @Override
    public Optional<PostResponse> updatePost(String id, PostRequest postRequest) {
        return repository.findById(id).map(post -> {
            mapper.updateEntityFromDtoRequest(postRequest, post);
            Post saved = repository.save(post);
            return mapper.toPostResponse(saved);
        });
    }

    @Override
    public List<PostResponse> getPost(String fieldName, String fieldValue) {
        Query query = new Query();
        query.addCriteria(Criteria.where(fieldName).is(fieldValue));
        return mongoTemplate.find(query, PostResponse.class);
    }

    @Override
    public Optional<PostResponse> deletePost(String id) {
        return repository.findById(id)
                .map(post -> {
                    repository.deleteById(id);
                    return mapper.toPostResponse(post);
                });
    }
}
