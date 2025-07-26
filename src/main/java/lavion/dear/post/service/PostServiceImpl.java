package lavion.dear.post.service;

import lavion.dear.post.dto.PostRequest;
import lavion.dear.post.dto.PostResponse;
import lavion.dear.post.mapper.PostMapper;
import lavion.dear.post.model.Post;
import lavion.dear.post.repository.PostRepository;
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


    public void post() {
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
        return (PostResponse) mapper.toDtoResponse(saved);

    }

    @Override
    public Optional<PostResponse> updatePost(String id, PostRequest postRequest) {
        return repository.findById(id).map(post -> {
            mapper.updateEntityFromDtoRequest(postRequest, post);
            Post saved = repository.save(post);
            return (PostResponse) mapper.toDtoResponse(saved);
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
                    return (PostResponse) mapper.toDtoResponse(post);
                });
    }
}
