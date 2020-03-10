package org.jeecg.modules.attendance.mapper;

import java.util.List;
import java.util.Map;

/**
 * 企业持久层
 */
public interface EnterpriseMapper {
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
