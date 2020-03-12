package com.community.modules.attendance.service;

import com.community.modules.attendance.mapper.EnterpriseMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 企业实现
 */
@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Resource
    private EnterpriseMapper enterpriseMapper;

    @Override
    public List<Map<String, Object>> queryEnterpriseList(Map<String, Object> paramMap) {
        return enterpriseMapper.queryEnterpriseList(paramMap);
    }

    @Override
    public Long queryEnterpriseListTotal(Map<String, Object> paramMap) {
        return enterpriseMapper.queryEnterpriseListTotal(paramMap);
    }
}
