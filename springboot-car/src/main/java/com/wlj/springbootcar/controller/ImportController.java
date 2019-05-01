package com.wlj.springbootcar.controller;



import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.wlj.springbootcar.bean.Book;
import com.wlj.springbootcar.dao.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author LB
 * @create 2019-04-26 10:23
 */
@Controller
public class ImportController {
    @Autowired
    BookMapper bookMapper;

    @PostMapping("/import")
    public String importExc(@RequestParam("file") MultipartFile file, Model model) {
        ImportParams importParams = new ImportParams();
//        // 数据处理
        importParams.setHeadRows(1);
//        importParams.setTitleRows(1);
        // 需要验证
//        importParams.setNeedVerfiy(false);
        System.out.println(file.getName());
        try {
            ExcelImportResult<Book> result = ExcelImportUtil.importExcelMore(file.getInputStream(), Book.class, importParams);
            List<Book> userList = result.getList();
            for (Book book : userList) {
                bookMapper.addBook(book);
                System.out.println(book);
            }
            model.addAttribute("msg","导入成功" );
            return "admin/admin-book-import";
        } catch (Exception e) {
            model.addAttribute("msg","导入失败" );
            return "admin/admin-book-import";
        }
    }
}
