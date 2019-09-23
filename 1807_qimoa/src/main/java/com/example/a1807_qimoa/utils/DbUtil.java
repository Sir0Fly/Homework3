package com.example.a1807_qimoa.utils;

public class DbUtil {
/*
    private static DbUtil dbUtil;
    private final DailyNewsDbBeanDao dailyNewsDbBeanDao;

    public static DbUtil getDbUtil() {
        if (dbUtil == null) {
            synchronized (DbUtil.class) {
                if (dbUtil == null) {
                    dbUtil = new DbUtil();
                }
            }
        }
        return dbUtil;
    }

    private DbUtil() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(BaseApplication.getApplication(), "news.db");

        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());

        DaoSession daoSession = daoMaster.newSession();

        dailyNewsDbBeanDao = daoSession.getDailyNewsDbBeanDao();
    }

    *//**
     * 查询全部数据
     *
     * @return
     *//*
    public List<DailyNewsDbBean> query() {
        return dailyNewsDbBeanDao.queryBuilder().list();
    }

    *//**
     * 插入一条数据
     *
     * @param dailyNewsDbBean
     * @return
     *//*
    public long insert(DailyNewsDbBean dailyNewsDbBean) {
        if (!isHash(dailyNewsDbBean)) {
            long l = dailyNewsDbBeanDao.insertOrReplace(dailyNewsDbBean);
            return l;
        }
        return -1;
    }

    *//**
     * 删除一条数据
     *
     * @param dailyNewsDbBean
     * @return
     *//*
    public boolean delete(DailyNewsDbBean dailyNewsDbBean) {
        if (isHash(dailyNewsDbBean)) {
            dailyNewsDbBeanDao.delete(dailyNewsDbBean);
            return true;
        }
        return false;
    }

    *//**
     * 修改一条数据
     *
     * @param dailyNewsDbBean
     * @return
     *//*
    public boolean updata(DailyNewsDbBean dailyNewsDbBean) {
        if (isHash(dailyNewsDbBean)) {
            dailyNewsDbBeanDao.update(dailyNewsDbBean);
            return true;
        }
        return false;
    }

    *//**
     * 判断是否存在
     *
     * @param dailyNewsDbBean
     * @return
     *//*
    public boolean isHash(DailyNewsDbBean dailyNewsDbBean) {
        List<DailyNewsDbBean> list = dailyNewsDbBeanDao.queryBuilder().where(DailyNewsDbBeanDao.Properties.Id.eq(dailyNewsDbBean.getId())).list();
        if (list != null && list.size() > 0) {
            return true;
        }
        return false;
    }*/
}
