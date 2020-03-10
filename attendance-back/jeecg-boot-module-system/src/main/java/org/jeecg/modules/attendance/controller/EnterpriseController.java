package org.jeecg.modules.attendance.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.attendance.service.EnterpriseService;
import org.jeecg.modules.monitor.domain.RedisInfo;
import org.jeecg.modules.monitor.service.RedisService;
import org.jeecg.modules.system.entity.SysUserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/attendance/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

	/**
	 * 分页列表查询
	 * @param sysUserAgent
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */

	/**
	 * 分页列表查询(课件)
	 *
	 * @return
	 */
	@GetMapping(value = "/list")
	public Result<IPage<Map<String, Object>>> queryEnterpriseList(@RequestParam Map<String, Object> param) {

		Result<IPage<Map<String, Object>>> result = new Result<IPage<Map<String, Object>>>();
		Page<Map<String, Object>> page = new Page<Map<String, Object>>(Integer.parseInt(param.get("pageNo").toString()),
				Integer.parseInt(param.get("pageSize").toString()));
		param.put("start", (Integer.parseInt(param.get("pageNo").toString()) - 1) * 10);
		List<Map<String, Object>> resultList = enterpriseService.queryEnterpriseList(param);
		page.setRecords(resultList);
		page.setTotal(enterpriseService.queryEnterpriseListTotal(param));
		result.setSuccess(true);
		result.setResult(page);
		return result;
	}


}
