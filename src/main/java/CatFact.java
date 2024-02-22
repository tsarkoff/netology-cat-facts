import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CatFact {
    private final String id; // - уникальный идентификатор записи
    private final String text; // - сообщение
    private final String type; // - тип животного
    private final String user; // - имя пользователя
    private final Integer upvotes; // - голоса

    public CatFact(
            @JsonProperty("id") String id,
            @JsonProperty("text") String text,
            @JsonProperty("type") String type,
            @JsonProperty("user") String user,
            @JsonProperty("upvotes") Integer upvotes)
    {
        this.id = id;
        this.text = text.substring(0, Math.min(text.length(), 25)) + "...";
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }
}
