package com.arialyy.aria.core.task;

import android.os.Bundle;
import com.arialyy.aria.exception.AriaException;

/* JADX INFO: loaded from: classes2.dex */
public interface IThreadTaskObserver {
    long getThreadProgress();

    void updateCompleteState();

    void updateFailState(AriaException ariaException, boolean z10);

    void updateProgress(long j10);

    void updateState(int i10, Bundle bundle);
}
