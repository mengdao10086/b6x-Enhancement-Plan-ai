package com.arialyy.aria.core.listener;

import android.os.Handler;
import com.arialyy.aria.core.task.AbsTask;
import com.arialyy.aria.exception.AriaException;

/* JADX INFO: loaded from: classes2.dex */
public interface IEventListener {
    void onCancel();

    void onComplete();

    void onFail(boolean z10, AriaException ariaException);

    void onPre();

    void onProgress(long j10);

    void onResume(long j10);

    void onStart(long j10);

    void onStop(long j10);

    IEventListener setParams(AbsTask absTask, Handler handler);
}
