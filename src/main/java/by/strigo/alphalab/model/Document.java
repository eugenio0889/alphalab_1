package by.strigo.alphalab.model;

import by.strigo.alphalab.model.constant.DocumentType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;

@Entity
@Table(name = "DOCUMENT")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long id;

    @Column(name = "NUMBER")
    String number;

    @Enumerated(EnumType.STRING)
    @Column(name = "DOCUMENT_TYPE")
    DocumentType documentType;

    @Column(name = "SCANNED_DOC_URL")
    String scannedDocUrl;

    @Column(name = "CREATED")
    @CreationTimestamp
    Date created;

    @Column(name = "UPDATED")
    @UpdateTimestamp
    Date updated;

    @Column(name = "IS_ACTIVE")
    boolean active;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    Person person;

}
