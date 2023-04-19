package com.example.warehouse.controller;

import com.example.warehouse.responce.Result;
import com.example.warehouse.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @PostMapping("/upload")
    public Result uploadPhoto(MultipartHttpServletRequest request) {
        Result result = attachmentService.uploadFile(request);
        return result;
    }

    @GetMapping("/getOneAttachment/{id}")
    public Result getOneAttachment(@PathVariable Integer id) {
        Result onFile = attachmentService.getOnFile(id);
        return onFile;
    }

    @GetMapping("/getAllAttachment")
    public Result getAllAttachment() {
        return attachmentService.getAllFile();
    }

    @PutMapping("/updateAttachment/{id}")
    public Result updateAttachment(@PathVariable Integer id, MultipartHttpServletRequest request){
        return attachmentService.updateFile(id, request);
    }

    @DeleteMapping("/deleteAttachment/{id}")
    public Result deleteAttachment(@PathVariable Integer id){
        return attachmentService.deleteFile(id);
    }

}
