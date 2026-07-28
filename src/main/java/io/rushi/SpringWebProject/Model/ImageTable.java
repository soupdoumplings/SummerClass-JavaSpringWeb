package io.rushi.SpringWebProject.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class ImageTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob // Large text object; images are stored here as Base64 strings.
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;
}
