package com.pcs.service.impl;

import com.alibaba.fastjson.JSONException;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.pcs.service.IMessageService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("messageService")
public class MessageService implements IMessageService {

    @Override
    public void sendMessage(String telephone, String checkCode) {
        int appid = 1400510684; // 1400开头
        // 短信应用SDK AppKey
        String appkey = "f53f4290fc7c5671497b77f3da12dff0";
        //签名参数
        String smsSign = "你需要一个情绪垃圾桶";
        // 短信模板ID，需要在短信应用中申请
        int templateId = 932844; // NOTE: 真实的模板ID需要在短信控制台中申请

        try {
            String[] params = {checkCode};
            SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult result = ssender.sendWithParam("86", telephone,
                    templateId, params,smsSign, "", "");
            System.out.println(result);
        } catch (HTTPException e) {
            // HTTP 响应码错误
            e.printStackTrace();

        } catch (JSONException e) {
            // JSON 解析错误
            e.printStackTrace();
        } catch (IOException e) {
            // 网络 IO 错误
            e.printStackTrace();
        }
    }
}
