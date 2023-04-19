package com.example.warehouse.service;

import com.example.warehouse.entity.Attachment;
import com.example.warehouse.entity.AttachmentContent;
import com.example.warehouse.repository.AttachmentContentRepository;
import com.example.warehouse.repository.AttachmentRepository;
import com.example.warehouse.responce.Result;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    @SneakyThrows
    public Result uploadFile(MultipartHttpServletRequest request) {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        Attachment attachment = new Attachment();

        attachment.setName(file.getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());

        Attachment savedAttachment = attachmentRepository.save(attachment);
        AttachmentContent attachmentContent = new AttachmentContent();
        attachmentContent.setBytes(file.getBytes());
        attachmentContent.setAttachment(savedAttachment);

        attachmentContentRepository.save(attachmentContent);

        return new Result("Fayl saqalandi", true, savedAttachment.getId());
    }

    public Result getOnFile(Integer id) {
        Optional<AttachmentContent> optionalAttachmentContent = attachmentContentRepository.findById(id);
        if (!optionalAttachmentContent.isPresent())
            return new Result("Bunday attachment mavjud emas", false);

        AttachmentContent attachmentContent = optionalAttachmentContent.get();
        return new Result("One attachment", true, attachmentContent);

    }

    public Result getAllFile() {
        List<Attachment> attachmentList = attachmentRepository.findAll();
        return new Result("attachment list", true, attachmentList);
    }

    @SneakyThrows
    public Result updateFile(Integer id, MultipartHttpServletRequest request) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (!optionalAttachment.isPresent())
            return new Result("Bunday attachment mavjud emas", false);
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        Attachment attachment = optionalAttachment.get();
        attachment.setName(file.getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());

        Attachment savedAttachment = attachmentRepository.save(attachment);

        Optional<AttachmentContent> optionalAttachmentContent = attachmentContentRepository.findById(id);
        if (!optionalAttachmentContent.isPresent())
            return new Result("Bunday attachment mavjud emas", false);

        AttachmentContent attachmentContent = optionalAttachmentContent.get();
        attachmentContent.setBytes(file.getBytes());
        attachmentContent.setAttachment(savedAttachment);
        attachmentContentRepository.save(attachmentContent);

        return new Result("Fayl update qilindi", true, savedAttachment.getId());

    }

    public Result deleteFile(Integer id){
        attachmentRepository.deleteById(id);
        return new Result("attachment deleted", true);
    }

}
