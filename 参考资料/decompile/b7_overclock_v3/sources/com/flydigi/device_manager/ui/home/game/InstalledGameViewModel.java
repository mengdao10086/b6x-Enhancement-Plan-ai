package com.flydigi.device_manager.ui.home.game;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.x0;
import com.flydigi.data.DBManager;
import com.flydigi.data.bean.InstalledGameBean;
import com.flydigi.data.bean.LocalGameBean;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class InstalledGameViewModel extends x0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final LiveData<List<InstalledGameBean>> f15218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final LiveData<List<LocalGameBean>> f15219e;

    public InstalledGameViewModel() {
        LiveData<List<InstalledGameBean>> liveDataObservableInstalledGames = DBManager.getInstance().observableInstalledGames();
        kotlin.jvm.internal.f0.o(liveDataObservableInstalledGames, "getInstance().observableInstalledGames()");
        this.f15218d = liveDataObservableInstalledGames;
        this.f15219e = Transformations.b(liveDataObservableInstalledGames, new ik.l<List<InstalledGameBean>, List<LocalGameBean>>() { // from class: com.flydigi.device_manager.ui.home.game.InstalledGameViewModel$installedGames$1
            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final List<LocalGameBean> i(@yt.k List<InstalledGameBean> it2) {
                kotlin.jvm.internal.f0.p(it2, "it");
                ArrayList<InstalledGameBean> arrayList = new ArrayList();
                for (Object obj : it2) {
                    if (o5.p.c(((InstalledGameBean) obj).getLocalPackageName())) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(kotlin.collections.t.Y(arrayList, 10));
                for (InstalledGameBean installedGameBean : arrayList) {
                    LocalGameBean localGameBean = new LocalGameBean();
                    localGameBean.f14331id = installedGameBean.getId();
                    localGameBean.name = com.blankj.utilcode.util.n0.x(installedGameBean.getLocalPackageName()) ? com.blankj.utilcode.util.d.k(installedGameBean.getLocalPackageName()) : installedGameBean.getTitle();
                    localGameBean.localPackageName = installedGameBean.getLocalPackageName();
                    localGameBean.standardPackageName = installedGameBean.getStandardPackageName();
                    localGameBean.thumb = installedGameBean.getThumb();
                    localGameBean.gameMode = installedGameBean.getGameMode();
                    arrayList2.add(localGameBean);
                }
                return arrayList2;
            }
        });
    }

    @yt.k
    public final LiveData<List<LocalGameBean>> g() {
        return this.f15219e;
    }
}
