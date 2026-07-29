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
import e6.z;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.text.StringsKt__StringsKt;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public final class FindGameHasConfigWorker extends Worker {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public final Context f11399g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FindGameHasConfigWorker(@k Context appContext, @k WorkerParameters workerParams) {
        super(appContext, workerParams);
        f0.p(appContext, "appContext");
        f0.p(workerParams, "workerParams");
        this.f11399g = appContext;
    }

    public final void A(d.a aVar) {
        InstalledGameBean installedGameBean = new InstalledGameBean();
        installedGameBean.setId(0L);
        installedGameBean.setTitle(aVar.b());
        installedGameBean.setLocalPackageName(aVar.c());
        installedGameBean.setStandardPackageName(aVar.c());
        installedGameBean.setUpdateTime(System.currentTimeMillis());
        DBManager.getInstance().addInstalledGame(installedGameBean);
        n.b("SyncGames FindGameHasConfigWorker " + aVar.c(), new Object[0]);
    }

    @Override // androidx.work.Worker
    @k
    public ListenableWorker.a y() {
        d.a aVarI;
        n.b("SyncGames FindGameHasConfigWorker inMainProcess:" + q0.g(), new Object[0]);
        List<PackageInfo> listM = u9.b.m(true);
        z.i0();
        List<String> listI = z.I();
        for (PackageInfo packageInfo : listM) {
            if (DBManager.getInstance().getLocalInstalledGame(packageInfo.packageName) == null && (aVarI = d.i(packageInfo.packageName)) != null && DBManager.getSupportedGame(aVarI.c()) == null) {
                Iterator<String> it2 = listI.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        String localCfgFileName = it2.next();
                        f0.o(localCfgFileName, "localCfgFileName");
                        String strC = aVarI.c();
                        f0.o(strC, "it.packageName");
                        if (StringsKt__StringsKt.W2(localCfgFileName, strC, false, 2, null)) {
                            A(aVarI);
                            break;
                        }
                    }
                }
            }
        }
        ListenableWorker.a aVarE = ListenableWorker.a.e();
        f0.o(aVarE, "success()");
        return aVarE;
    }

    @k
    public final Context z() {
        return this.f11399g;
    }
}
