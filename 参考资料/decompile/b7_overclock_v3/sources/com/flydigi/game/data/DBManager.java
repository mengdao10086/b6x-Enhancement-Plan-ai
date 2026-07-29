package com.flydigi.game.data;

import com.blankj.utilcode.util.d1;
import com.blankj.utilcode.util.j1;
import com.flydigi.data.DataConstant;
import com.flydigi.game.data.bean.GameBean;
import com.flydigi.game.data.bean.MyObjectBox;
import io.objectbox.BoxStore;
import io.objectbox.query.k0;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class DBManager {
    private BoxStore mBoxStore;

    public static class DBManagerHolder {
        private static final DBManager sInstance = new DBManager();

        private DBManagerHolder() {
        }
    }

    public static GameBean getInstalledGameBean(String str) {
        List<GameBean> installedGameBeans = getInstalledGameBeans(str);
        if (installedGameBeans.size() > 0) {
            return installedGameBeans.get(0);
        }
        return null;
    }

    public static List<GameBean> getInstalledGameBeans(String str) {
        final String strL = d1.l(str);
        return getInstance().getBoxStore().i(GameBean.class).L().w(new k0() { // from class: com.flydigi.game.data.a
            @Override // io.objectbox.query.k0
            public final boolean a(Object obj) {
                return DBManager.lambda$getInstalledGameBeans$0(strL, (GameBean) obj);
            }
        }).g().W();
    }

    public static DBManager getInstance() {
        return DBManagerHolder.sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getInstalledGameBeans$0(String str, GameBean gameBean) {
        return (str.equals(DataConstant.PACKAGE_NAME_COMMON_CJZC) || str.equals("com.tencent.tmgp.pubgmhd")) ? str.equals(gameBean.packageName) : str.startsWith(gameBean.packageName) || (str.length() > 0 && gameBean.packageName.startsWith(str));
    }

    public BoxStore getBoxStore() {
        if (this.mBoxStore == null) {
            synchronized (BoxStore.class) {
                if (this.mBoxStore == null) {
                    this.mBoxStore = MyObjectBox.builder().b(j1.a()).e();
                }
            }
        }
        return this.mBoxStore;
    }

    public void init() {
        getBoxStore();
    }

    private DBManager() {
    }
}
