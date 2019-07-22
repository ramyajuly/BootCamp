package com.company.videogamestore.service;

import com.company.videogamestore.dao.TShirtDao;
import com.company.videogamestore.model.TShirt;
import com.company.videogamestore.viewmodel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Service for Tshirt
 */
@Component
public class TShirtInventoryService {
    @Autowired
    TShirtDao tshirtDao;

    @Autowired
    public TShirtInventoryService(TShirtDao tshirtDao) {
        this.tshirtDao = tshirtDao;
    }

    /**
     * To add a new Tshirt
     * @param tShirtViewModel
     * @return TShirtViewModel
     */
    public TShirtViewModel addTShirt(TShirtViewModel tShirtViewModel) {
        TShirt tShirt = new TShirt();
        tShirt.setQuantity(tShirtViewModel.getQuantity());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setSize(tShirtViewModel.getSize());
        tShirt = tshirtDao.addTShirt(tShirt);
        tShirtViewModel.settShirtId(tShirt.gettShirtId());
        return tShirtViewModel;
    }

    /**
     * To get a TShirt
     * @param tShirtId
     * @return TShirtViewModel
     */
    public TShirtViewModel getTShirt(int tShirtId) {
        TShirt tShirt = new TShirt();
        tShirt = tshirtDao.getTShirt(tShirtId);
        TShirtViewModel tShirtViewModel = new TShirtViewModel();
        if(tShirt !=null) {
            tShirtViewModel.settShirtId(tShirt.gettShirtId());
            tShirtViewModel.setColor(tShirt.getColor());
            tShirtViewModel.setDescription(tShirt.getDescription());
            tShirtViewModel.setPrice(tShirt.getPrice());
            tShirtViewModel.setQuantity(tShirt.getQuantity());
            tShirtViewModel.setSize(tShirt.getSize());
            return tShirtViewModel;
        }else
            return null;

    }

    /**
     * To get all TShirts
     * @return List<TShirtViewModel>
     */
    public List<TShirtViewModel> getAllTShirt() {
        TShirtViewModel tShirtViewModel;
        List<TShirtViewModel> tShirtViewModelList = new ArrayList<>();
        List<TShirt> tShirtList = new ArrayList<>();
        tShirtList = tshirtDao.getAllTShirt();
        if (tShirtList != null) {
            for (TShirt tShirt : tShirtList) {
                tShirtViewModel = new TShirtViewModel();
                tShirtViewModel.settShirtId(tShirt.gettShirtId());
                tShirtViewModel.setColor(tShirt.getColor());
                tShirtViewModel.setDescription(tShirt.getDescription());
                tShirtViewModel.setPrice(tShirt.getPrice());
                tShirtViewModel.setQuantity(tShirt.getQuantity());
                tShirtViewModel.setSize(tShirt.getSize());
                tShirtViewModelList.add(tShirtViewModel);
            }
        }
        return tShirtViewModelList;


    }

    /**
     * To update a existing TShirt
     * @param tShirtViewModel
     * @return TShirtViewModel
     */
    public TShirtViewModel updateTShirt(TShirtViewModel tShirtViewModel) {
        TShirt tShirt = new TShirt();
        tShirt.setQuantity(tShirtViewModel.getQuantity());
        tShirt.setPrice(tShirtViewModel.getPrice());
        tShirt.setDescription(tShirtViewModel.getDescription());
        tShirt.setColor(tShirtViewModel.getColor());
        tShirt.setSize(tShirtViewModel.getSize());
        tShirt.settShirtId(tShirtViewModel.gettShirtId());
        tshirtDao.updateTShirt(tShirt);
        return tShirtViewModel;

    }

    /**
     * To delete a TShirt
     * @param tshirtId
     * @return
     */
    public int deleteTShirt(int tshirtId) {
        return tshirtDao.deleteTShirt(tshirtId);
    }

    /**
     * To get a TShirt by color
     * @param color
     * @return
     */
    public List<TShirtViewModel> getTShirtsByColor(String color) {

        TShirtViewModel tShirtViewModel;
        List<TShirtViewModel> tShirtViewModelList = new ArrayList<>();
        List<TShirt> tShirtList = new ArrayList<>();
        tShirtList = tshirtDao.getTShirtsByColor(color);
        if (tShirtList != null) {
            for (TShirt tShirt : tShirtList) {
                tShirtViewModel = new TShirtViewModel();
                tShirtViewModel.settShirtId(tShirt.gettShirtId());
                tShirtViewModel.setColor(tShirt.getColor());
                tShirtViewModel.setDescription(tShirt.getDescription());
                tShirtViewModel.setPrice(tShirt.getPrice());
                tShirtViewModel.setQuantity(tShirt.getQuantity());
                tShirtViewModel.setSize(tShirt.getSize());
                tShirtViewModelList.add(tShirtViewModel);
            }
        }
        return tShirtViewModelList;


    }

    /**
     * To get TShirt by Size
     * @param size
     * @return
     */
    public List<TShirtViewModel> getTShirtsBySize(String size) {

        TShirtViewModel tShirtViewModel;
        List<TShirtViewModel> tShirtViewModelList = new ArrayList<>();
        List<TShirt> tShirtList = new ArrayList<>();
        tShirtList = tshirtDao.getTShirtsBySize(size);
        if (tShirtList != null) {
            for (TShirt tShirt : tShirtList) {
                tShirtViewModel = new TShirtViewModel();
                tShirtViewModel.settShirtId(tShirt.gettShirtId());
                tShirtViewModel.setColor(tShirt.getColor());
                tShirtViewModel.setDescription(tShirt.getDescription());
                tShirtViewModel.setPrice(tShirt.getPrice());
                tShirtViewModel.setQuantity(tShirt.getQuantity());
                tShirtViewModel.setSize(tShirt.getSize());
                tShirtViewModelList.add(tShirtViewModel);
            }
        }
        return tShirtViewModelList;

    }
}
