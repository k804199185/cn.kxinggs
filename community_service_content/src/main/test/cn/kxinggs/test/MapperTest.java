package cn.kxinggs.test;

import com.community.dao.ArticleMapper;
import com.community.dao.ArticleTypeMapper;
import com.community.pojo.content.Article;
import com.community.pojo.content.ArticleType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MapperTest {

    @Autowired
    private ArticleTypeMapper articleTypeMapper;

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 查询
     */
    @Test
    public void demo1(){
        List<ArticleType> list = articleTypeMapper.selectAll();
        if(list==null || list.size()==0){
            System.out.println("list为空");
        }
        for (ArticleType type : list) {
            System.out.println(type);

        }
    }
    @Test
    public void demo2(){
        List<Article> list = articleMapper.selectAll();
        for (Article art : list) {
            System.out.println(art);
        }
    }
}
