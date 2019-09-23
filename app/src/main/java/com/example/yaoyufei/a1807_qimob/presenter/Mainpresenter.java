package com.example.yaoyufei.a1807_qimob.presenter;

import com.example.yaoyufei.a1807_qimob.ArtBean;
import com.example.yaoyufei.a1807_qimob.model.MainModel;
import com.example.yaoyufei.a1807_qimob.view.MainView;

public class Mainpresenter {
    private final MainModel mainModel;
    private MainView mainView;

    public Mainpresenter(MainView mainView) {
        this.mainView = mainView;
        mainModel = new MainModel();
    }

    public void getInfo(){
        mainModel.initData(new MainModel.MainCallback() {
            @Override
            public void onSuccess(ArtBean artBean) {
                if (mainModel!=null){
                    mainView.onSuccess(artBean);
                }
            }

            @Override
            public void onField(String s) {
                mainView.onField(s);
            }
        });
    }
}
