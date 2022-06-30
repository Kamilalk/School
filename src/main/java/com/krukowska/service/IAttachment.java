package com.krukowska.service;


import com.krukowska.domain.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface IAttachment {
    public Attachment saveAttachment(MultipartFile file) throws Exception;

    Attachment getAttachment(String fileId) throws Exception;
}
