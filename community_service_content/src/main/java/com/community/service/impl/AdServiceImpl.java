package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.AdMapper;
import com.community.entity.PageResult;
import com.community.pojo.content.Ad;
import com.community.service.content.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    private AdMapper adMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Ad> findAll() {
        return adMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Ad> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Ad> ads = (Page<Ad>) adMapper.selectAll();
        return new PageResult<Ad>(ads.getTotal(),ads.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Ad> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return adMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Ad> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Ad> ads = (Page<Ad>) adMapper.selectByExample(example);
        return new PageResult<Ad>(ads.getTotal(),ads.getResult());
    }

    /**
     * 根据Id查询
     * @param ad_id
     * @return
     */
    public Ad findById(Long adId) {
        return adMapper.selectByPrimaryKey(adId);
    }

    /**
     * 新增
     * @param ad
     */
    public void add(Ad ad) {
        adMapper.insert(ad);
    }

    /**
     * 修改
     * @param ad
     */
    public void update(Ad ad) {
        adMapper.updateByPrimaryKeySelective(ad);
    }

    /**
     *  删除
     * @param ad_id
     */
    public void delete(Long adId) {
        adMapper.deleteByPrimaryKey(adId);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Ad.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 名称
            if(searchMap.get("adName")!=null && !"".equals(searchMap.get("adName"))){
                criteria.andLike("adName","%"+searchMap.get("adName")+"%");
            }
            // 广告图片
            if(searchMap.get("picUrl")!=null && !"".equals(searchMap.get("picUrl"))){
                criteria.andLike("picUrl","%"+searchMap.get("picUrl")+"%");
            }
            // 备注
            if(searchMap.get("remark")!=null && !"".equals(searchMap.get("remark"))){
                criteria.andLike("remark","%"+searchMap.get("remark")+"%");
            }
            // 广告跳转链接
            if(searchMap.get("adHref")!=null && !"".equals(searchMap.get("adHref"))){
                criteria.andLike("adHref","%"+searchMap.get("adHref")+"%");
            }

            // 广告位置 0 首页banner 1 列表页 2 详情页
            if(searchMap.get("postion")!=null ){
                criteria.andEqualTo("postion",searchMap.get("postion"));
            }

        }
        return example;
    }

}
