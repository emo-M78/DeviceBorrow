package com.ruoyi.device.api;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.device.domain.DeviceUserRegister;
import com.ruoyi.device.service.IDeviceUserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//标记为控制器
@RequestMapping("/wechart")//访问路径
@Anonymous//匿名访问
public class WxUserController {
    @Autowired
    private IDeviceUserRegisterService service;
    /**
     * 小程序用户注册
     * 请求方法：POST
     * 请求路径：http://localhost:8080/wechat/register
     * @param deviceUserRegister 注册信息：部门/班级 工号/学号 姓名 手机号 登陆密码
     * @return
     */
    @PostMapping("register")
    public AjaxResult register(@RequestBody DeviceUserRegister deviceUserRegister){
//        1、验证号/学号是否已经被注册
        List<DeviceUserRegister> registerList = service.selectDeviceUserRegisterByCode(deviceUserRegister.getRegCode());
//        2、判断是否已经注册
        if (registerList != null && registerList.size()>0){
//            3、被注册
            return AjaxResult.warn("该工号/学号已被注册！");
        }else {
//            4、完成注册：新增，给密码加密
            String password = SecurityUtils.encryptPassword(deviceUserRegister.getRegPassword());
            System.out.println("密码加密:"+password);
//            修改未加密的密码
            deviceUserRegister.setRegPassword(password);
//            调用业务成，新增
            int result = service.insertDeviceUserRegister(deviceUserRegister);
            return result == 1?AjaxResult.success("注册成功"):AjaxResult.warn("注册失败，请联系管理员！");
        }
    }

    /**
     * 小程序用户登录
     * @param code
     * @param userName
     * @param password
     * @return
     */
    @PostMapping("login")
    public AjaxResult login(String code,String userName,String password){
//        1、根据工号/学号查询
        List<DeviceUserRegister> registers = service.selectDeviceUserRegisterByCode(userName);
//        2、判断数据
        if (registers == null || registers.size()!=1){//没数据、多条数据
            return AjaxResult.warn("登录失败，工号/学号输入错误！");
        }else {//查询到1条数据
            //去除登录的小程序数据
            DeviceUserRegister loginUser = registers.get(0);
//           未审核，不能登录
            if (loginUser.getRegStatus()==0){
                return AjaxResult.warn("登录失败，账号未审核，请联系管理员！");
            }
//           审核不通过，不能登录
            else if (loginUser.getRegStatus()==2){
                return AjaxResult.warn("登录失败，账号未通过审核，请联系管理员！");
            }
//            判断密码、是否正确
            else if (loginUser.getRegPassword()!=null && SecurityUtils.matchesPassword(password,loginUser.getRegPassword())){
//                清空数据，数据脱敏
                loginUser.setRegPassword("");
                return AjaxResult.success("登录成功",loginUser);
            }else {
                return AjaxResult.warn("登录失败，密码错误！");
            }
        }
    }
}
