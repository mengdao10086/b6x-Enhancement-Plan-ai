package com.flydigi.game.utils;

import android.content.Context;
import android.os.Environment;
import com.arialyy.aria.core.Aria;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.task.DownloadTask;
import com.blankj.utilcode.util.b0;
import com.blankj.utilcode.util.j1;
import com.blankj.utilcode.util.n0;
import com.flydigi.game.data.DBManager;
import com.flydigi.game.data.DownloadTaskEvent;
import com.flydigi.game.data.bean.GameBean;
import com.flydigi.game.data.bean.GameBean_;
import io.objectbox.BoxStore;
import io.objectbox.query.QueryBuilder;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import tt.c;
import u3.b;

/* JADX INFO: loaded from: classes7.dex */
public class FZGameDownloadHandler {
    public String TAG;
    private File mGameFolder;

    public static class FZDownloadHandlerHolder {
        private static final FZGameDownloadHandler sInstance = new FZGameDownloadHandler();

        private FZDownloadHandlerHolder() {
        }
    }

    public static FZGameDownloadHandler getInstance() {
        return FZDownloadHandlerHolder.sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addGameDownloadInfoToDB$1(BoxStore boxStore, GameBean gameBean) {
        ii.a aVarI = boxStore.i(GameBean.class);
        GameBean gameBean2 = (GameBean) aVarI.L().s(GameBean_.packageName, gameBean.packageName, QueryBuilder.StringOrder.CASE_INSENSITIVE).g().h1();
        if (gameBean2 != null) {
            gameBean2.progress = gameBean.progress;
            gameBean2.localPath = this.mGameFolder.getAbsolutePath() + File.separator + gameBean.packageName + ".apk";
            aVarI.G(gameBean2);
            return;
        }
        gameBean.progress = 0.0f;
        gameBean.localPath = this.mGameFolder.getAbsolutePath() + File.separator + gameBean.packageName + ".apk";
        aVarI.G(gameBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancel$0(BoxStore boxStore, GameBean gameBean) {
        ii.a aVarI = boxStore.i(GameBean.class);
        aVarI.Q(aVarI.L().s(GameBean_.packageName, gameBean.packageName, QueryBuilder.StringOrder.CASE_INSENSITIVE).g().W());
        b0.o(new File(this.mGameFolder.getAbsolutePath() + File.separator + gameBean.packageName + ".apk"));
    }

    public void addGameDownloadInfoToDB(final GameBean gameBean) {
        final BoxStore boxStore = DBManager.getInstance().getBoxStore();
        boxStore.E2(new Runnable() { // from class: com.flydigi.game.utils.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f15919a.lambda$addGameDownloadInfoToDB$1(boxStore, gameBean);
            }
        }, null);
    }

    public void cancel(final GameBean gameBean) {
        List<DownloadEntity> downloadEntity = Aria.download(this).getDownloadEntity(gameBean.link);
        if (n0.z(downloadEntity)) {
            Iterator<DownloadEntity> it2 = downloadEntity.iterator();
            while (it2.hasNext()) {
                Aria.download(this).load(it2.next().getId()).ignoreCheckPermissions().cancel();
            }
        }
        final BoxStore boxStore = DBManager.getInstance().getBoxStore();
        boxStore.E2(new Runnable() { // from class: com.flydigi.game.utils.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f15916a.lambda$cancel$0(boxStore, gameBean);
            }
        }, null);
    }

    public void init(Context context) {
        Aria.init(context);
        Aria.download(this).register();
        this.mGameFolder = j1.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
    }

    @b.InterfaceC0596b
    public void onPre(DownloadTask downloadTask) {
        c.f().q(new DownloadTaskEvent(downloadTask, 2));
    }

    @b.k
    public void onWait(DownloadTask downloadTask) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("wait ==> ");
        sb2.append(downloadTask.getDownloadEntity().getFileName());
        c.f().q(new DownloadTaskEvent(downloadTask, 1));
    }

    @b.h
    public void running(DownloadTask downloadTask) {
        c.f().q(new DownloadTaskEvent(downloadTask, 9));
    }

    public void start(String str, String str2) {
        if (n0.m(str)) {
            return;
        }
        Aria.download(this).load(str).setFilePath(this.mGameFolder.getAbsolutePath() + File.separator + str2 + ".apk").ignoreCheckPermissions().create();
    }

    public void stop(String str) {
        List<DownloadEntity> downloadEntity = Aria.download(this).getDownloadEntity(str);
        if (n0.z(downloadEntity)) {
            Iterator<DownloadEntity> it2 = downloadEntity.iterator();
            while (it2.hasNext()) {
                Aria.download(this).load(it2.next().getId()).ignoreCheckPermissions().stop();
            }
        }
    }

    @b.c
    public void taskCancel(DownloadTask downloadTask) {
        c.f().q(new DownloadTaskEvent(downloadTask, 6));
    }

    @b.d
    public void taskComplete(DownloadTask downloadTask) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("path ==> ");
        sb2.append(downloadTask.getDownloadEntity().getFilePath());
        c.f().q(new DownloadTaskEvent(downloadTask, 8));
    }

    @b.e
    public void taskFail(DownloadTask downloadTask) {
        c.f().q(new DownloadTaskEvent(downloadTask, 7));
    }

    @b.a
    public void taskNoSupportBreakPoint(DownloadTask downloadTask) {
        c.f().q(new DownloadTaskEvent(downloadTask, 10));
    }

    @b.g
    public void taskResume(DownloadTask downloadTask) {
        c.f().q(new DownloadTaskEvent(downloadTask, 3));
    }

    @b.i
    public void taskStart(DownloadTask downloadTask) {
        c.f().q(new DownloadTaskEvent(downloadTask, 4));
    }

    @b.j
    public void taskStop(DownloadTask downloadTask) {
        c.f().q(new DownloadTaskEvent(downloadTask, 5));
    }

    public void unRegister() {
        Aria.download(this).unRegister();
    }

    private FZGameDownloadHandler() {
        this.TAG = "FZGameDownloadHandler";
    }
}
