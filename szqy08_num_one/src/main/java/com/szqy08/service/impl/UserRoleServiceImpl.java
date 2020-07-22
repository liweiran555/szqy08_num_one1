package com.szqy08.service.impl;

import com.szqy08.entity.UserRole;
import com.szqy08.dao.UserRoleDao;
import com.szqy08.service.UserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author szqy08
 * @since 2020-07-17
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRole> implements UserRoleService {

}
