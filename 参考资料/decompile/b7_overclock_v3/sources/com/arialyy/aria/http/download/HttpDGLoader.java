package com.arialyy.aria.http.download;

import android.os.Looper;
import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.common.CompleteInfo;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.group.AbsGroupLoader;
import com.arialyy.aria.core.group.AbsSubDLoadUtil;
import com.arialyy.aria.core.listener.DownloadGroupListener;
import com.arialyy.aria.core.loader.IInfoTask;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.exception.AriaException;
import com.arialyy.aria.exception.AriaHTTPException;
import com.arialyy.aria.http.download.HttpDGInfoTask;

/* JADX INFO: loaded from: classes2.dex */
final class HttpDGLoader extends AbsGroupLoader {
    public HttpDGLoader(AbsTaskWrapper absTaskWrapper, DownloadGroupListener downloadGroupListener) {
        super(absTaskWrapper, downloadGroupListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSub() {
        if (isBreak()) {
            return;
        }
        onPostStart();
        for (DTaskWrapper dTaskWrapper : getWrapper().getSubTaskWrapper()) {
            startSubLoader(createSubLoader(dTaskWrapper, dTaskWrapper.getEntity().getFileSize() < 0));
        }
    }

    @Override // com.arialyy.aria.core.loader.ILoaderVisitor
    public void addComponent(IInfoTask iInfoTask) {
        this.mInfoTask = iInfoTask;
        iInfoTask.setCallback(new HttpDGInfoTask.DGInfoCallback() { // from class: com.arialyy.aria.http.download.HttpDGLoader.1
            @Override // com.arialyy.aria.core.loader.IInfoTask.Callback
            public void onFail(AbsEntity absEntity, AriaException ariaException, boolean z10) {
                HttpDGLoader.this.fail(ariaException, z10);
            }

            @Override // com.arialyy.aria.http.download.HttpDGInfoTask.DGInfoCallback
            public void onStop(long j10) {
                HttpDGLoader.this.getListener().onStop(j10);
            }

            @Override // com.arialyy.aria.http.download.HttpDGInfoTask.DGInfoCallback
            public void onSubFail(DownloadEntity downloadEntity, AriaHTTPException ariaHTTPException, boolean z10) {
                HttpDGLoader.this.getState().countFailNum(downloadEntity.getKey());
            }

            @Override // com.arialyy.aria.core.loader.IInfoTask.Callback
            public void onSucceed(String str, CompleteInfo completeInfo) {
                HttpDGLoader.this.startSub();
            }
        });
    }

    @Override // com.arialyy.aria.core.group.AbsGroupLoader
    public AbsSubDLoadUtil createSubLoader(DTaskWrapper dTaskWrapper, boolean z10) {
        HttpSubDLoaderUtil httpSubDLoaderUtil = new HttpSubDLoaderUtil(getScheduler(), z10, getKey());
        httpSubDLoaderUtil.setParams(dTaskWrapper, null);
        return httpSubDLoaderUtil;
    }

    @Override // com.arialyy.aria.core.group.AbsGroupLoader
    public void handlerTask(Looper looper) {
        if (isBreak()) {
            return;
        }
        this.mInfoTask.run();
    }
}
