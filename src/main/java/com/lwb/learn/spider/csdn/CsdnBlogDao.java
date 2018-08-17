package com.lwb.learn.spider.csdn;

import java.util.ArrayList;
import java.util.List;

public class CsdnBlogDao {

    public int add(CsdnBlog csdnBlog) {
        DBHelper dbHelper = new DBHelper();
        String sql = "INSERT INTO `webmagic`.`csdnblog` (`id`, `title`, `date`, `tags`, `category`, `view`, `comments`, `copyright`, `content`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";

        //构造模板填充序列
        List<String> sqlValues = new ArrayList<String>();
        sqlValues.add(csdnBlog.getId() + "");
        sqlValues.add(csdnBlog.getTitle());
        sqlValues.add(csdnBlog.getDate());
        sqlValues.add(csdnBlog.getTags());
        sqlValues.add(csdnBlog.getCategory());
        sqlValues.add(csdnBlog.getView() + "");
        sqlValues.add(csdnBlog.getComments() + "");
        sqlValues.add(csdnBlog.getCopyright() + "");
        sqlValues.add(csdnBlog.getContent());

        int result = dbHelper.executeUpdate(sql, sqlValues);
        return result;
    }
}
