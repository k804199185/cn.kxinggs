package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.NoticeMapper;
import com.community.entity.PageResult;
import com.community.pojo.system.Notice;
import com.community.service.system.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Notice> findAll() {
        return noticeMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Notice> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Notice> notices = (Page<Notice>) noticeMapper.selectAll();
        return new PageResult<Notice>(notices.getTotal(),notices.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Notice> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return noticeMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Notice> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Notice> notices = (Page<Notice>) noticeMapper.selectByExample(example);
        return new PageResult<Notice>(notices.getTotal(),notices.getResult());
    }

    /**
     * 根据Id查询
     * @param notice_id
     * @return
     */
    public Notice findById(Long noticeId) {
        return noticeMapper.selectByPrimaryKey(noticeId);
    }

    /**
     * 新增
     * @param notice
     */
    public void add(Notice notice) {
        noticeMapper.insert(notice);
    }

    /**
     * 修改
     * @param notice
     */
    public void update(Notice notice) {
        noticeMapper.updateByPrimaryKeySelective(notice);
    }

    /**
     *  删除
     * @param notice_id
     */
    public void delete(Long noticeId) {
        noticeMapper.deleteByPrimaryKey(noticeId);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Notice.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 标题
            if(searchMap.get("title")!=null && !"".equals(searchMap.get("title"))){
                criteria.andLike("title","%"+searchMap.get("title")+"%");
            }
            // 内容
            if(searchMap.get("content")!=null && !"".equals(searchMap.get("content"))){
                criteria.andLike("content","%"+searchMap.get("content")+"%");
            }


        }
        return example;
    }

}
