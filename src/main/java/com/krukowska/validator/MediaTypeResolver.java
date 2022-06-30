package com.krukowska.validator;

import org.springframework.http.MediaType;

public class MediaTypeResolver {

    private MediaTypeResolver() {
    }

    public static String mediaType(String mType){
        return switch (mType) {
            case "pdf" -> MediaType.APPLICATION_PDF_VALUE;
            case "xml" -> MediaType.TEXT_XML_VALUE;
            case "gif" -> MediaType.IMAGE_GIF_VALUE;
            case "jpeg" -> MediaType.IMAGE_JPEG_VALUE;
            case "html" -> MediaType.TEXT_HTML_VALUE;
            case "markdown" -> MediaType.TEXT_MARKDOWN_VALUE;
            case "png" -> MediaType.IMAGE_PNG_VALUE;
            case "plain" -> MediaType.TEXT_PLAIN_VALUE;
            default ->  null;
        };
    }
}

