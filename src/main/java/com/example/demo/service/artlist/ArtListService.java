package com.example.demo.service.artlist;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.bean.artListBean;
import com.example.demo.repository.JpaArtListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtListService implements IArtListService {

    @Autowired
    JpaArtListRepository jpaArtListRepository;

    /**
     * 添加数据到得数据根据id
     *
     * @param artListBean
     * @return
     */
    @Override
    public String addArtList(artListBean artListBean) {
        if (artListBean != null) {
            jpaArtListRepository.save(artListBean);

        }
        return "数据保存成功";
    }
}
