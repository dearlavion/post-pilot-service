package lavion.dear.controller;

import lavion.dear.dto.post.PostDTO;
import lavion.dear.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService service;

    @PostMapping
    public ResponseEntity<PostDTO.PostResponse> create(@Valid @RequestBody PostDTO.PostRequest postRequest) {
        PostDTO.PostResponse response = service.createPost(postRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();
        return ResponseEntity.created(location).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO.PostResponse> update(
            @PathVariable String id,
            @RequestBody @Valid PostDTO.PostRequest postRequest) {
        return service.updatePost(id, postRequest)
                .map(resp -> ResponseEntity.ok(resp))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<PostDTO.PostResponse>> get(@RequestParam String fieldName, @RequestParam String fieldValue) {
        List<PostDTO.PostResponse> responseList = service.getPost(fieldName, fieldValue);
        return ResponseEntity.ok(responseList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostDTO.PostResponse> delete(@PathVariable String id) {
        return service.deletePost(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
