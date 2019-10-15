package controller;



import entity.FileInfo;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class FileOperateController {
    @RequestMapping("upload")
    public String upload(HttpServletRequest request, @ModelAttribute FileInfo fileInfo, Model model)throws Exception{
        if(fileInfo.getFile().isEmpty()){
            return "failure";
        }else {
            String path = request.getServletContext().getRealPath("/images/");
            String fileName = fileInfo.getFile().getOriginalFilename();
            File filepath = new File(path,fileName);
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }
            System.out.println("文件路径:"+path+File.separator+fileName);
            fileInfo.getFile().transferTo(new File(path+File.separator+fileName));
            model.addAttribute("fileInfo",fileInfo);
            return "download";
        }
    }

    @RequestMapping("download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,@RequestParam("filename") String filename)throws Exception{
        String path = request.getServletContext().getRealPath("/images/");
        File file = new File(path+File.separator+filename);
        HttpHeaders headers = new HttpHeaders();
        String downloadFile = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment",downloadFile);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }
}
