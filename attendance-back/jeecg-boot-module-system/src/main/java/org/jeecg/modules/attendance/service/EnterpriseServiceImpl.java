package org.jeecg.modules.attendance.service;

import org.jeecg.modules.attendance.mapper.EnterpriseMapper;
import org.jeecg.modules.system.mapper.SysAnnouncementSendMapper;
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
