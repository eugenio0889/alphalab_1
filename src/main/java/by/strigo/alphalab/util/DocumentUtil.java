package by.strigo.alphalab.util;

import by.strigo.alphalab.model.Document;
import by.strigo.alphalab.model.constant.DocumentType;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

import static by.strigo.alphalab.util.RandomUtil.generateRandomString;

@UtilityClass
public class DocumentUtil {

    private static final String MATCHING_STRING = "abc777def";

    public static List<Document> generateSomeRandomDocsWhereOneHasMatchingNumberAndActiveStatus() {
        List<Document> documents = new ArrayList<>();

        documents.add(buildWithNumberAndActiveFlag(generateRandomString(), true));
        documents.add(buildWithNumberAndActiveFlag(generateRandomString(), true));
        documents.add(buildWithNumberAndActiveFlag(generateRandomString(), true));
        documents.add(buildWithNumberAndActiveFlag(generateRandomString() + MATCHING_STRING, false));
        documents.add(buildWithNumberAndActiveFlag(generateRandomString() + MATCHING_STRING, true));

        return documents;
    }

    public static List<Document> generateSomeRandomDocsWithoutMatching() {
        List<Document> documents = new ArrayList<>();

        documents.add(buildWithNumberAndActiveFlag(generateRandomString(), true));
        documents.add(buildWithNumberAndActiveFlag(generateRandomString(), true));
        documents.add(buildWithNumberAndActiveFlag(generateRandomString(), true));
        documents.add(buildWithNumberAndActiveFlag(generateRandomString(), false));
        documents.add(buildWithNumberAndActiveFlag(generateRandomString(), true));

        return documents;
    }

    private static Document buildWithNumberAndActiveFlag(String number, boolean active) {
        Document document = new Document();
        document.setNumber(number);
        document.setDocumentType(DocumentType.INSURANCE_CONTRACT);
        document.setScannedDocUrl(generateRandomString());
        document.setActive(active);

        return document;
    }

}
