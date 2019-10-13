package com.yus.core.repo.impl;
           
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yus.core.entity.MRoleEntity;
import com.yus.core.dao.MRoleDao;
import com.yus.core.repo.MRoleRepo;

import java.io.Serializable;
/**
* Copyright (C),
* @author: CodeGenerator
* @date: 2019/10/13 23:27
* @description:
*/
//@Transactional
//@Service("mRoleRepo")
@Component
public class MRoleRepoImpl extends ServiceImpl<MRoleDao, MRoleEntity> implements MRoleRepo {

}
