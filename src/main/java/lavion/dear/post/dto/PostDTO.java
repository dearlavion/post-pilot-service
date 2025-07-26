package lavion.dear.post.dto;

import lavion.dear.media.model.Media;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class PostDTO {
    private String id;
    private String title;
    private String description;
    private String imageLink;
    private List<Media> socialMedias;
    private boolean isPostSuccess;
    private String postOwner;
    private LocalDateTime dateTimePosted;
}
