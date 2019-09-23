package com.example.a1807_qimoa.mvp;

import com.example.a1807_qimoa.bean.ArtBean;

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
            public void onField(String a) {

                mainView.onField(a);
            }
        });
    }
}
