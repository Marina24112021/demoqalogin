package models;

import lombok.Data;

import java.util.List;

@Data
public class AddBooksToCardModel {
    String userId;
    List<Isbn_Model> collectionOfIsbns;
}
