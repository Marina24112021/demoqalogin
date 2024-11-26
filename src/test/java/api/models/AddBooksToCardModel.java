package api.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AddBooksToCardModel {
    String userId;
    List<IsbnModel> collectionOfIsbns;
}
