package lavion.dear.model;

import lavion.dear.model.Media;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Document(collection = "posts")
@Getter
@Setter
public class Post {
    @Id
    private String id = UUID.randomUUID().toString();
    private String title;
    private String description;
    private String imageLink;
    private List<Media> socialMedias;
    private boolean isPostSuccess;
    private String postOwner;
    private LocalDateTime dateTimePosted;
}
