package com.arialyy.aria.core.command;

import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.queue.DTaskQueue;
import com.arialyy.aria.core.task.DownloadTask;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.NetUtils;

/* JADX INFO: loaded from: classes2.dex */
final class HighestPriorityCmd<T extends AbsTaskWrapper> extends AbsNormalCmd<T> {
    public HighestPriorityCmd(T t10, int i10) {
        super(t10, i10);
    }

    @Override // com.arialyy.aria.core.command.ICmd
    public void executeCmd() {
        if (this.canExeCmd) {
            if (!NetUtils.isConnected(AriaConfig.getInstance().getAPP())) {
                ALog.e(this.TAG, "启动任务失败，网络未连接");
                return;
            }
            DownloadTask downloadTask = (DownloadTask) getTask();
            if (downloadTask == null) {
                downloadTask = (DownloadTask) createTask();
            }
            if (downloadTask != null) {
                ((DTaskQueue) this.mQueue).setTaskHighestPriority(downloadTask);
            }
        }
    }
}
