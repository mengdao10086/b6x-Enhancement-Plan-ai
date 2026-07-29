package com.android.motionelf.work;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.blankj.utilcode.util.d;
import com.blankj.utilcode.util.q0;
import com.flydigi.base.common.n;
import com.flydigi.data.DBManager;
import com.flydigi.data.bean.InstalledGameBean;
import com.flydigi.data.bean.SupportedGameBean;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nFindSupportedGameFromInstalledAppsWorker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FindSupportedGameFromInstalledAppsWorker.kt\ncom/android/motionelf/work/FindSupportedGameFromInstalledAppsWorker\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,59:1\n1855#2,2:60\n*S KotlinDebug\n*F\n+ 1 FindSupportedGameFromInstalledAppsWorker.kt\ncom/android/motionelf/work/FindSupportedGameFromInstalledAppsWorker\n*L\n33#1:60,2\n*E\n"})
public final class FindSupportedGameFromInstalledAppsWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FindSupportedGameFromInstalledAppsWorker(@k Context appContext, @k WorkerParameters workerParams) {
        super(appContext, workerParams);
        f0.p(appContext, "appContext");
        f0.p(workerParams, "workerParams");
    }

    @Override // androidx.work.Worker
    @k
    public ListenableWorker.a y() {
        d.a appInfo;
        n.b("SyncGames FindSupportedGameFromInstalledAppsWorker inMainProcess:" + q0.g(), new Object[0]);
        List<PackageInfo> listM = u9.b.m(true);
        f0.o(listM, "getInstalledApp(true)");
        for (PackageInfo packageInfo : listM) {
            if (DBManager.getInstance().getLocalInstalledGame(packageInfo.packageName) == null && (appInfo = d.i(packageInfo.packageName)) != null) {
                f0.o(appInfo, "appInfo");
                SupportedGameBean supportedGame = DBManager.getSupportedGame(appInfo.c());
                if (supportedGame != null) {
                    z(appInfo, supportedGame);
                }
            }
        }
        ListenableWorker.a aVarE = ListenableWorker.a.e();
        f0.o(aVarE, "success()");
        return aVarE;
    }

    public final void z(d.a aVar, SupportedGameBean supportedGameBean) {
        InstalledGameBean installedGameBean = new InstalledGameBean();
        installedGameBean.setId(supportedGameBean.getId());
        installedGameBean.setTitle(aVar.b());
        installedGameBean.setThumb(supportedGameBean.getThumb());
        installedGameBean.setLocalPackageName(aVar.c());
        installedGameBean.setStandardPackageName(supportedGameBean.getPackageName());
        installedGameBean.setUpdateTime(System.currentTimeMillis());
        DBManager.getInstance().addInstalledGame(installedGameBean);
    }
}
