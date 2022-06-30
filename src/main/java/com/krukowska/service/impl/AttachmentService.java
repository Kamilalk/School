package com.krukowska.service.impl;

import com.krukowska.domain.Attachment;
import com.krukowska.repository.AttachmentRepository;
import com.krukowska.service.IAttachment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentService implements IAttachment {
    private AttachmentRepository attachmentRepository;

    public AttachmentService(AttachmentRepository attachmentRepository) {
        this.attachmentRepository= attachmentRepository;
    }

    @Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try{
            if(fileName.contains("..")){
                throw new Exception("FileName contains invalid path sequence" + fileName);
            }
            Attachment attachment
                    = new Attachment(fileName,
                    file.getContentType(),
                    file.getBytes());

            return attachmentRepository.save(attachment);
        }catch(Exception e){
            throw new Exception("Cold not save File:" + fileName );

        }
    }

    @Override
    public Attachment getAttachment(String fileId) throws Exception {
        return attachmentRepository
                .findById(fileId)
                .orElseThrow(() -> new Exception("File not found with Id" + fileId));
    }


}
