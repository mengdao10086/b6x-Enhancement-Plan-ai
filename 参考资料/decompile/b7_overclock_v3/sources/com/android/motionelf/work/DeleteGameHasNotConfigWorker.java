package com.android.motionelf.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.blankj.utilcode.util.q0;
import com.flydigi.base.common.n;
import com.flydigi.data.DBManager;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes2.dex */
public final class DeleteGameHasNotConfigWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeleteGameHasNotConfigWorker(@k Context appContext, @k WorkerParameters workerParams) {
        super(appContext, workerParams);
        f0.p(appContext, "appContext");
        f0.p(workerParams, "workerParams");
    }

    @Override // androidx.work.Worker
    @k
    public ListenableWorker.a y() {
        if (g().n("key_cleanup", false)) {
            n.b("SyncGames DeleteGameHasNotConfigWorker removeAllInstalledGame inMainProcess:" + q0.g(), new Object[0]);
            DBManager.getInstance().removeAllInstalledGame();
        } else {
            n.b("SyncGames DeleteGameHasNotConfigWorker removeUninstalledGame inMainProcess:" + q0.g(), new Object[0]);
            DBManager.getInstance().removeUninstalledGame();
        }
        ListenableWorker.a aVarE = ListenableWorker.a.e();
        f0.o(aVarE, "success()");
        return aVarE;
    }
}
