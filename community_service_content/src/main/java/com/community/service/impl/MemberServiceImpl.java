package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.MemberMapper;
import com.community.entity.PageResult;
import com.community.pojo.content.Member;
import com.community.service.content.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<Member> findAll() {
        return memberMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<Member> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<Member> members = (Page<Member>) memberMapper.selectAll();
        return new PageResult<Member>(members.getTotal(),members.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<Member> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return memberMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<Member> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<Member> members = (Page<Member>) memberMapper.selectByExample(example);
        return new PageResult<Member>(members.getTotal(),members.getResult());
    }

    /**
     * 根据Id查询
     * @param member_id
     * @return
     */
    public Member findById(Long memberId) {
        return memberMapper.selectByPrimaryKey(memberId);
    }

    /**
     * 新增
     * @param member
     */
    public void add(Member member) {
        memberMapper.insert(member);
    }

    /**
     * 修改
     * @param member
     */
    public void update(Member member) {
        memberMapper.updateByPrimaryKeySelective(member);
    }

    /**
     *  删除
     * @param member_id
     */
    public void delete(Long memberId) {
        memberMapper.deleteByPrimaryKey(memberId);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(Member.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 用户名
            if(searchMap.get("menberName")!=null && !"".equals(searchMap.get("menberName"))){
                criteria.andLike("menberName","%"+searchMap.get("menberName")+"%");
            }
            // 昵称
            if(searchMap.get("nickname")!=null && !"".equals(searchMap.get("nickname"))){
                criteria.andLike("nickname","%"+searchMap.get("nickname")+"%");
            }
            // 密码
            if(searchMap.get("password")!=null && !"".equals(searchMap.get("password"))){
                criteria.andLike("password","%"+searchMap.get("password")+"%");
            }
            // 电子邮件
            if(searchMap.get("email")!=null && !"".equals(searchMap.get("email"))){
                criteria.andLike("email","%"+searchMap.get("email")+"%");
            }
            // 电话
            if(searchMap.get("phone")!=null && !"".equals(searchMap.get("phone"))){
                criteria.andLike("phone","%"+searchMap.get("phone")+"%");
            }
            // 头像路径
            if(searchMap.get("avatar")!=null && !"".equals(searchMap.get("avatar"))){
                criteria.andLike("avatar","%"+searchMap.get("avatar")+"%");
            }
            // 性别 1男 0女
            if(searchMap.get("sex")!=null && !"".equals(searchMap.get("sex"))){
                criteria.andLike("sex","%"+searchMap.get("sex")+"%");
            }
            // 籍贯 广东汕头市
            if(searchMap.get("city")!=null && !"".equals(searchMap.get("city"))){
                criteria.andLike("city","%"+searchMap.get("city")+"%");
            }
            // 学校
            if(searchMap.get("school")!=null && !"".equals(searchMap.get("school"))){
                criteria.andLike("school","%"+searchMap.get("school")+"%");
            }
            // 教育 本科,专科等
            if(searchMap.get("education")!=null && !"".equals(searchMap.get("education"))){
                criteria.andLike("education","%"+searchMap.get("education")+"%");
            }
            // 系
            if(searchMap.get("dept")!=null && !"".equals(searchMap.get("dept"))){
                criteria.andLike("dept","%"+searchMap.get("dept")+"%");
            }
            // 账号状态 0正常 1注销
            if(searchMap.get("status")!=null && !"".equals(searchMap.get("status"))){
                criteria.andLike("status","%"+searchMap.get("status")+"%");
            }
            // 情感状态 单身，热恋,保密等
            if(searchMap.get("sign")!=null && !"".equals(searchMap.get("sign"))){
                criteria.andLike("sign","%"+searchMap.get("sign")+"%");
            }
            // ip地址
            if(searchMap.get("ip")!=null && !"".equals(searchMap.get("ip"))){
                criteria.andLike("ip","%"+searchMap.get("ip")+"%");
            }

            // 点赞数
            if(searchMap.get("likeCount")!=null ){
                criteria.andEqualTo("likeCount",searchMap.get("likeCount"));
            }
            // 收藏数
            if(searchMap.get("scanCount")!=null ){
                criteria.andEqualTo("scanCount",searchMap.get("scanCount"));
            }
            // 关注数
            if(searchMap.get("followCount")!=null ){
                criteria.andEqualTo("followCount",searchMap.get("followCount"));
            }

        }
        return example;
    }

}
