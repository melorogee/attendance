package org.jeecg.modules.attendance.service;

import java.util.List;
import java.util.Map;

/**
 * 企业接口
 */
public interface EnterpriseService {
    /**
     * 查询企业列表
     * @param paramMap
     * @return
     */
    List<Map<String,Object>> queryEnterpriseList(Map<String, Object> paramMap);

    /**
     * 查询企业列表（Total）
     * @param paramMap
     * @return
     */
    Long queryEnterpriseListTotal(Map<String, Object> paramMap);
}
