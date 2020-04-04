package com.community.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.community.dao.FileInfoMapper;
import com.community.entity.PageResult;
import com.community.pojo.system.FileInfo;
import com.community.service.system.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class FileInfoServiceImpl implements FileInfoService {

    @Autowired
    private FileInfoMapper fileInfoMapper;

    /**
     * 返回全部记录
     * @return
     */
    public List<FileInfo> findAll() {
        return fileInfoMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page 页码
     * @param size 每页记录数
     * @return 分页结果
     */
    public PageResult<FileInfo> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        Page<FileInfo> fileInfos = (Page<FileInfo>) fileInfoMapper.selectAll();
        return new PageResult<FileInfo>(fileInfos.getTotal(),fileInfos.getResult());
    }

    /**
     * 条件查询
     * @param searchMap 查询条件
     * @return
     */
    public List<FileInfo> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return fileInfoMapper.selectByExample(example);
    }

    /**
     * 分页+条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public PageResult<FileInfo> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        Page<FileInfo> fileInfos = (Page<FileInfo>) fileInfoMapper.selectByExample(example);
        return new PageResult<FileInfo>(fileInfos.getTotal(),fileInfos.getResult());
    }

    /**
     * 根据Id查询
     * @param file_id
     * @return
     */
    public FileInfo findById(String fileId) {
        return fileInfoMapper.selectByPrimaryKey(fileId);
    }

    /**
     * 新增
     * @param fileInfo
     */
    public void add(FileInfo fileInfo) {
        fileInfoMapper.insert(fileInfo);
    }

    /**
     * 修改
     * @param fileInfo
     */
    public void update(FileInfo fileInfo) {
        fileInfoMapper.updateByPrimaryKeySelective(fileInfo);
    }

    /**
     *  删除
     * @param file_id
     */
    public void delete(String fileId) {
        fileInfoMapper.deleteByPrimaryKey(fileId);
    }

    /**
     * 构建查询条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap){
        Example example=new Example(FileInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 主键id
            if(searchMap.get("fileId")!=null && !"".equals(searchMap.get("fileId"))){
                criteria.andLike("fileId","%"+searchMap.get("fileId")+"%");
            }
            // 文件仓库（oss仓库）
            if(searchMap.get("fileBucket")!=null && !"".equals(searchMap.get("fileBucket"))){
                criteria.andLike("fileBucket","%"+searchMap.get("fileBucket")+"%");
            }
            // 文件名称
            if(searchMap.get("fileName")!=null && !"".equals(searchMap.get("fileName"))){
                criteria.andLike("fileName","%"+searchMap.get("fileName")+"%");
            }
            // 文件后缀
            if(searchMap.get("fileSuffix")!=null && !"".equals(searchMap.get("fileSuffix"))){
                criteria.andLike("fileSuffix","%"+searchMap.get("fileSuffix")+"%");
            }
            // 文件唯一标识id
            if(searchMap.get("finalName")!=null && !"".equals(searchMap.get("finalName"))){
                criteria.andLike("finalName","%"+searchMap.get("finalName")+"%");
            }
            // 存储路径
            if(searchMap.get("filePath")!=null && !"".equals(searchMap.get("filePath"))){
                criteria.andLike("filePath","%"+searchMap.get("filePath")+"%");
            }


        }
        return example;
    }

}
