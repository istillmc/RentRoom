package org.atgalway.lease.web.admin.controller.apartment;


import io.minio.errors.*;
import org.atgalway.lease.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.atgalway.lease.web.admin.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


@Tag(name = "File Management")
@RequestMapping("/admin/file")
@RestController
public class FileUploadController {
    @Autowired
    private FileService fileService;
    @Operation(summary = "Upload Files")
    @PostMapping("upload")
    public Result<String> upload(@RequestParam MultipartFile file) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

        String url = fileService.upload(file);
        return Result.ok(url);
    }

}
