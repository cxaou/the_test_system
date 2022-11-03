package com.cxaou.thetestsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxaou.thetestsystem.common.R;
import com.cxaou.thetestsystem.dto.TestQuestionsDto;
import com.cxaou.thetestsystem.pojo.ExaminationPaper;
import com.cxaou.thetestsystem.service.ExaminationPaperService;
import com.cxaou.thetestsystem.service.UserService;
import com.cxaou.thetestsystem.utils.VerifyExaminationPaperUtils;
import com.cxaou.thetestsystem.vo.ExaminationPaperVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/examination_paper")
@Api(tags = "试卷管理")
public class ExaminationPaperController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private ExaminationPaperService examinationPaperService;


    @PostMapping()
    @ApiOperation(value = "添加试卷", notes = "参数示例： \n{\n" +
            "    \"duration\":\"04:00:00\",\n" +
            "    \"introduction\":\"点击开始评测即计时开始，中途关闭页面再进入不会重新计时，本评测共有3个部分，共55道题目，限时240分钟\",\n" +
            "    \"testQuestionsDtoList\":[\n" +
            "        {\n" +
            "            \"answer\":\"D\",\n" +
            "            \"data\":\"项目部署与测试阶段中，不需要参与的角色是\",\n" +
            "            \"optionsMap\":{\n" +
            "                \"A\":\"系统运维人员\",\n" +
            "                \"B\":\"测试人员\",\n" +
            "                \"C\":\"项目经理\",\n" +
            "                \"D\":\"开发人员\"\n" +
            "            },\n" +
            "            \"score\":10,\n" +
            "            \"testQuestionsType\":0\n" +
            "        },\n" +
            "\t\t\t{\n" +
            "\t\t\t\t\"answer\":\"ABCD\",\n" +
            "\t\t\t\t\"data\":\"下面关于隧道方案中，叙述正确的是\",\n" +
            "\t\t\t\t\"optionsMap\":{\n" +
            "\t\t\t\t\t\"A\":\"隧道方案是借助容器宿主机网络，构建出一个对于容器来说三层路由可达虚拟网络\",\n" +
            "\t\t\t\t\t\"B\":\"隧道方案的好处是没有NAT方案的端口冲突问题、不消耗额外的骨干网络IP\",\n" +
            "\t\t\t\t\t\"C\":\"隧道方案的实施、定制化、维护的成本比较低\",\n" +
            "\t\t\t\t\t\"D\":\"如果容器平台中运行业务与其它平台上运行业务需要通信，则需要配置从容器外部访问容器的路由，否则容器的地址从容器平台外部不能直接路由访问\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"score\":10,\n" +
            "\t\t\t\t\"testQuestionsType\":1\n" +
            "\t\t\t},\n" +
            "        {\n" +
            "            \"answer\":\"\\n[SW1]vlan batch 101 102\\n[SW1]interface Vlanif 100\\n[SW1-Vlanif100]ip address 172.16.100.254 24\\n[SW1]interface Vlanif 101\\n[SW1-Vlanif101]ip address 172.16.101.254 24\\n[SW1]interface GigabitEthernet 0/0/1\\n[SW1-GigabitEthernet0/0/1]port link-type trunk\\n[SW1-GigabitEthernet0/0/1]port trunk allow-pass vlan 100\\n[SW1-GigabitEthernet0/0/1]quit\\n[SW1]interface GigabitEthernet 0/0/2\\n[SW1-GigabitEthernet0/0/2]port link-type access\\n[SW1-GigabitEthernet0/0/2]port default vlan 101\\n[SW1-GigabitEthernet0/0/2]quit\",\n" +
            "            \"data\":\"网络管理 通过一条命令在S1交换机上创建vlan100、vlan101，配置vlan100网关为：172.16.100.254/24。配置vlan101网关为：172.16.101.254/24。配置g0/0/1端口为trunk模式，放行vlan100。配置g0/0/2端口为access模式，所属vlan101。将上述操作命令及返回结果以文本形式提交到答题框。\",\n" +
            "            \"score\":40,\n" +
            "            \"testQuestionsType\":2,\n" +
            "            \"minSimilarity\":100,\n" +
            "            \"maxSimilarity\":100\n" +
            "        }\n" +
            "    ],\n" +
            "    \"title\":\"1+X云计算平台运维与开发认证（中级）样卷A\",\n" +
            "    \"type\":\"1+x\"\n" +
            "}")
    public R<String> addExaminationPaper(@RequestBody ExaminationPaperVo examinationPaperVo, HttpServletRequest request) {
        if (!VerifyExaminationPaperUtils.verifyExaminationVoPaper(examinationPaperVo)) {
            return R.error("参数不合法");
        }
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        // 判断合法 拆分参数
        List<TestQuestionsDto> testQuestionsDtoList = examinationPaperVo.getTestQuestionsDtoList();

        ExaminationPaper examinationPaper = new ExaminationPaper();

        BeanUtils.copyProperties(examinationPaperVo, examinationPaper);

        if (!examinationPaperService.addExaminationPaper(currentUserId, examinationPaper, testQuestionsDtoList)) {
            return R.error("权限不够");
        }
        return R.success("成功");
    }


    @ApiOperation(value = "修改试卷信息", notes = "参数示例： \n{\n" +
            "\t\"duration\": \"04:00:00\",\n" +
            "\t\"id\": 1587604117206880258,\n" +
            "\t\"introduction\": \"点击开始评测即计时开始，中途关闭页面再进入不会重新计时，本评测共有3个部分，共55道题目，限时240分钟\",\n" +
            "\t\"title\": \"1+X云计算平台运维与开发认证（中级）样卷A\",\n" +
            "\t\"type\": \"1+x测试\"\n" +
            "}")
    @PutMapping
    public R<String> updateExaminationPaper(@RequestBody ExaminationPaper examinationPaper, HttpServletRequest request) {
        if (VerifyExaminationPaperUtils.isNullCoreExaminationPaper(examinationPaper)) {
            return R.error("参数不合法");
        }
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        boolean isUpdate = examinationPaperService.updateExaminationPaper(currentUserId, examinationPaper);

        return isUpdate ? R.success("修改成功") : R.error("没有权限");
    }

    @DeleteMapping
    @ApiOperation(value = "删除试卷", notes = "参数示例： \n\"id\": 1")
    public R<String> deleteExaminationPaper(@RequestBody ExaminationPaper examinationPaper, HttpServletRequest request) {
        if (examinationPaper.getId() == null) {
            return R.error("参数不合法");
        }
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        boolean isDelete = examinationPaperService.deleteExaminationPaper(currentUserId, examinationPaper);
        return isDelete ? R.success("删除成功") : R.error("删除失败");
    }


    @GetMapping("/all")
    @ApiOperation(value = "获取所有的试卷列表")
    public R<Page<ExaminationPaper>> getAllExaminationPaper(Integer page, Integer pageSize, String title, HttpServletRequest request) {
        Page<ExaminationPaper> pageInfo = new Page<>(page, pageSize);
        LambdaQueryWrapper<ExaminationPaper> examinationPaperLambdaQueryWrapper = new LambdaQueryWrapper<>();
        examinationPaperLambdaQueryWrapper.like(title != null, ExaminationPaper::getTitle, title);
        examinationPaperService.page(pageInfo, examinationPaperLambdaQueryWrapper);
        return R.success(pageInfo);
    }


    @GetMapping("/own_all")
    @ApiOperation("获取到自己发布的所有试卷列表")
    public R<Page<ExaminationPaper>> getOwnAllExaminationPaper(Integer page, Integer pageSize, String title, HttpServletRequest request) {
        String token = request.getHeader("token");
        Long currentUserId = (Long) redisTemplate.opsForValue().get(token);
        Page<ExaminationPaper> pageInfo = new Page<>(page, pageSize);

        boolean ownAllExaminationPaper = examinationPaperService.getOwnAllExaminationPaper(pageInfo, title, currentUserId);
        return ownAllExaminationPaper ? R.success(pageInfo) : R.error("权限不够");


    }

}
