package com.example.demo.result;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据处理工具类
 */
public class ResultModelTool {
    public static ResultModel handlerResultMode(ResultModel resultModel) {
        ResultModel handlerMode = new ResultModel();
        Map hashMap = new HashMap();
        if (resultModel != null) {
            int error = resultModel.getCode();
            handlerMode.setCode(error);
            switch (error) {
                case 10000:
                    handlerMode.setMsg("网络繁忙");
                    handlerMode.setData(hashMap);
                    break;
                case 10001:
                    handlerMode.setMsg("无此用户");
                    handlerMode.setData(hashMap);
                    break;
                case 10002:
                    handlerMode.setMsg("添加成功");
                    handlerMode.setData(resultModel.getData());
                    break;
                case 10003:
                    handlerMode.setMsg("删除成功");
                    handlerMode.setData(resultModel.getData());
                    break;
                case 10004:
                    handlerMode.setMsg("更新成功");
                    handlerMode.setData(resultModel.getData());
                    break;
                case 10005:
                    handlerMode.setMsg("此用户已存在");
                    handlerMode.setData(resultModel.getData());
                    break;
                case 10006:
                    handlerMode.setMsg("添加失败");
                    handlerMode.setData(resultModel.getData());
                    break;
                case 10007:
                    handlerMode.setMsg("删除失败");
                    handlerMode.setData(resultModel.getData());
                    break;
                case 10008:
                    handlerMode.setMsg("更新失败");
                    handlerMode.setData(resultModel.getData());
                    break;
                case -1:
                    handlerMode.setMsg("请求失败");
                    handlerMode.setData(hashMap);
                    break;
                case 0:
                    handlerMode.setMsg("请求成功");
                    handlerMode.setData(resultModel.getData());
                    break;
            }

        }
        return handlerMode;
    }
}
