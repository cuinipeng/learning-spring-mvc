package com.percy.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(path = "/register")
public class FileUploadController {
    private Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    private ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(method = RequestMethod.POST)
    // public String processRegister(@RequestPart("file") byte[] file, RedirectAttributes redirectAttributes) {
    /* StandardServletMultipartResolver + MultipartFile 必须对应 */
    // public String processRegister(@RequestPart("file") MultipartFile file, RedirectAttributes redirectAttributes) {
    public String processRegister(@RequestPart("file") String stringFile, RedirectAttributes redirectAttributes)
            throws JsonProcessingException {
        System.out.println(stringFile);
        redirectAttributes.addAttribute("key1", "value1");
        redirectAttributes.addAttribute("key2", "value2");
        redirectAttributes.addAttribute("key3", "value3");
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded");

        // JSON 输出
        String jsonString = mapper.writeValueAsString(redirectAttributes);
        System.out.println(jsonString);
        return "redirect:/";
    }
}
