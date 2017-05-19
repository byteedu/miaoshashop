package cn.shop.biz.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.shop.biz.IFileService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by geely
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService {

    private Logger logger = Logger.getLogger(FileServiceImpl.class);


    public String upload(MultipartFile file,String path){
        String fileName = file.getOriginalFilename();
        //扩展名
        //abc.jpg
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".")+1);
        String uploadFileName = UUID.randomUUID().toString()+"."+fileExtensionName;
       
        File fileDir = new File(path);
        if(!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path,uploadFileName);

        try {
            file.transferTo(targetFile);
            //文件已经上传成功了

            targetFile.delete();
        } catch (IOException e) {
            logger.error("上传文件异常",e);
            return null;
        }

        return targetFile.getName();
    }

}
