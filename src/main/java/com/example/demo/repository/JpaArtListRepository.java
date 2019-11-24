package com.example.demo.repository;

import com.example.demo.bean.artListBean;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaArtListRepository extends JpaRepository<artListBean, String> {

}
