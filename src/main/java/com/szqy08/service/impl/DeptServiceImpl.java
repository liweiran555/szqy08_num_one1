package com.szqy08.service.impl;

import com.szqy08.entity.Dept;
import com.szqy08.dao.DeptDao;
import com.szqy08.service.DeptService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author szqy08
 * @since 2020-07-17
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptDao, Dept> implements DeptService {

}
