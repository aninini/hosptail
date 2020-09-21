package com.bjblkj.check.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bjblkj.check.entities.SysDictionary;
import com.bjblkj.check.mapper.SysDictionaryMapper;
import com.bjblkj.check.service.ISysDictionaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author generate by L
 * @since 2020-09-18
 */
@Service
public class SysDictionaryServiceImpl extends ServiceImpl<SysDictionaryMapper, SysDictionary> implements ISysDictionaryService {

    @Override
    public List<SysDictionary> selectChildrenDictByParentNum(String num) {
        QueryWrapper<SysDictionary> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("id");
        queryWrapper.eq("num",num);
        queryWrapper.eq("isvalid",true);
        queryWrapper.last("limit 1");
        SysDictionary one = getOne(queryWrapper);
        if(one==null){
            throw  new RuntimeException("该分类不存在,或已失效");
        }
        queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("pid",one.getId());
        queryWrapper.eq("isvalid",true);
        List<SysDictionary> list_res = list(queryWrapper);
        return list_res;
    }

    @Override
    public boolean isExitsDict(String parentnum, String current_num) {
        QueryWrapper<SysDictionary> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("id");
        queryWrapper.eq("num",parentnum);
        queryWrapper.eq("isvalid",true);
        queryWrapper.last("limit 1");
        SysDictionary one = getOne(queryWrapper);
        if(one==null){
            throw  new RuntimeException("父类不存在,或已失效");
        }
        queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("pid",one.getId());
        queryWrapper.eq("isvalid",true);
        queryWrapper.last("limit 1");
        one=getOne(queryWrapper);
        if(one==null){
            return  false;
        }else {
            return  true;
        }
    }


    @Override
    public SysDictionary getDictByParentnumAndnum(String parentnum, String current_num) {
        QueryWrapper<SysDictionary> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("id");
        queryWrapper.eq("num",parentnum);
        queryWrapper.eq("isvalid",true);
        queryWrapper.last("limit 1");
        SysDictionary one = getOne(queryWrapper);
        if(one==null){
            throw  new RuntimeException("父类不存在,或已失效");
        }
        queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("pid",one.getId());
        queryWrapper.eq("num",current_num);
        queryWrapper.eq("isvalid",true);
        queryWrapper.last("limit 1");
        one=getOne(queryWrapper);
        return  one;
    }
}
