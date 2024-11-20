package models;

import lombok.Data;

import java.util.List;
@Data
public class GetCollectionOfAllBooksModel {
    String userId,
            username;
    List<BooksModel> books;
}
