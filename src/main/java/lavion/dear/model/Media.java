package lavion.dear.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "medias")
@Getter
@Setter
public class Media {
    private String name;
}
