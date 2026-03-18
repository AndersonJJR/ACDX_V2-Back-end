package com.anderson.meu_projeto.service;

import org.springframework.http.HttpHeaders;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.anderson.meu_projeto.controller.FileUploadController;
import com.anderson.meu_projeto.storage.StorageService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImageService {
    
    private final StorageService storageService;

    public String uploadFile(Model model){
        model.addAttribute("files", storageService.loadAll().map(
            path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                "serveFile" , path.getFileName().toString())
                .build()
                .toUri()
                .toString())
                .toList());

        return "uploadForm";
    }

    public ResponseEntity<Resource> serveFile(String filename){

        Resource file = storageService.loadAsResource(filename);

        if (file == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" 
        + file.getFilename() + "\"").body(file);
    }

    public String handleFileUpload(MultipartFile file, RedirectAttributes redirectAttributes){

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message ",
            "You successfully uploaded" + file.getOriginalFilename() + "!"
         );

        return "redirect:/";
    }
}
