package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.ArtList;
import com.example.demo.bean.artListBean;
import com.example.demo.service.artlist.IArtListService;
import com.example.demo.utils.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//  /six_h/artlist
@RestController
@RequestMapping(value = "/six_h")
public class otherController {

    @Autowired
    IArtListService iArtListService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String doPostSixHData() {
        String jsonObject;
        int count = 0;
        while (true) {
            count++;
            jsonObject = HttpClient.doPost("http://47.75.251.38/index/History/kj");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(jsonObject);
            System.out.print(count);
            return jsonObject;
        }

    }

    /**
     * 抓取api数据
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/artlist", method = RequestMethod.GET)
    public String doPostArtlist() throws Exception {
        String artListStr;
        int mLimit = 1;
        while (true) {
            mLimit = (mLimit++) * 10;
            artListStr = HttpClient.doPost("http://47.75.251.38/index/Index/artlist?sort=time&typeid=1&limit=" + mLimit);
            System.out.print(artListStr);
            ArtList artList1 = JSON.parseObject(artListStr, ArtList.class);
            try {
                if (artList1.getData().getData() == null) {
                    return "数据抓取完成";
                } else {
                    for (int i = 0; i < artList1.getData().getData().size(); i++) {
                        artListBean artListBean = new artListBean();
                        artListBean.setAddtime(artList1.getData().getData().get(i).getAddtime());
                        artListBean.setColor(artList1.getData().getData().get(i).getColor());
                        artListBean.setDeacript(artList1.getData().getData().get(i).getDescript());
                        artListBean.setDianji(String.valueOf(artList1.getData().getData().get(i).getDianji()));
                        artListBean.setDianzan(String.valueOf(artList1.getData().getData().get(i).getDianzan()));
                        artListBean.setId(String.valueOf(artList1.getData().getData().get(i).getId()));
                        artListBean.setIs_dz(String.valueOf(artList1.getData().getData().get(i).getIs_dz()));
                        artListBean.setIs_gl(String.valueOf(artList1.getData().getData().get(i).getIs_gl()));
                        artListBean.setIs_yd(String.valueOf(artList1.getData().getData().get(i).getIs_yd()));
                        artListBean.setNikename(String.valueOf(artList1.getData().getData().get(i).getNikename()));
                        artListBean.setPlnum(String.valueOf(artList1.getData().getData().get(i).getPlnum()));
                        artListBean.setQishu(String.valueOf(artList1.getData().getData().get(i).getQishu()));
                        artListBean.setTitle(String.valueOf(artList1.getData().getData().get(i).getTitle()));
                        artListBean.setTopid(String.valueOf(artList1.getData().getData().get(i).getTopid()));
                        artListBean.setTximg(String.valueOf(artList1.getData().getData().get(i).getTximg()));
                        artListBean.setUid(String.valueOf(artList1.getData().getData().get(i).getUid()));
                        artListBean.setUrl(String.valueOf(artList1.getData().getGuanggao().getUrl()));
                        artListBean.setDeacripts(String.valueOf(artList1.getData().getGuanggao().getDeacript()));
                        iArtListService.addArtList(artListBean);
                        Thread.sleep(300);
                    }
                }
            } catch (Exception e) {
                return "数据抓取完成";
            }

        }
    }
}
