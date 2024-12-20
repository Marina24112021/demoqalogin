package api.models;

import lombok.Data;

@Data
public class BooksModel {
    String isbn,
            title,
            subTitle,
            author,
            publish_date,
            publisher,
            description,
            website;
    int pages;
}
