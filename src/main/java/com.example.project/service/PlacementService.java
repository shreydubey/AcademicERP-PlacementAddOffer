package com.example.project.service;

import com.example.project.bean.Placement;
import com.example.project.dao.PlacementDao;
import com.example.project.dao.PlacementDaoImpl;

public class PlacementService {
    PlacementDaoImpl placementDao = new PlacementDaoImpl();
    public boolean createOffer(Placement placement){
        System.out.println(placement.getDescription());
        return placementDao.createOffer(placement);
    }
}
