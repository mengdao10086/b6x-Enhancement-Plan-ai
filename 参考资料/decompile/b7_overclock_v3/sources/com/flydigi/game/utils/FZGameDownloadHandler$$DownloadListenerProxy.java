package com.flydigi.game.utils;

import com.arialyy.aria.core.scheduler.AptNormalTaskListener;
import com.arialyy.aria.core.task.DownloadTask;

/* JADX INFO: loaded from: classes7.dex */
public final class FZGameDownloadHandler$$DownloadListenerProxy extends AptNormalTaskListener<DownloadTask> {
    private FZGameDownloadHandler obj;

    @Override // com.arialyy.aria.core.scheduler.AptNormalTaskListener, com.arialyy.aria.core.scheduler.ISchedulerListener
    public void setListener(Object obj) {
        this.obj = (FZGameDownloadHandler) obj;
    }

    @Override // com.arialyy.aria.core.scheduler.AptNormalTaskListener, com.arialyy.aria.core.scheduler.NormalTaskListenerInterface
    public void onNoSupportBreakPoint(DownloadTask downloadTask) {
        this.obj.taskNoSupportBreakPoint(downloadTask);
    }

    @Override // com.arialyy.aria.core.scheduler.AptNormalTaskListener, com.arialyy.aria.core.scheduler.NormalTaskListenerInterface
    public void onPre(DownloadTask downloadTask) {
        this.obj.onPre(downloadTask);
    }

    @Override // com.arialyy.aria.core.scheduler.AptNormalTaskListener, com.arialyy.aria.core.scheduler.NormalTaskListenerInterface
    public void onTaskCancel(DownloadTask downloadTask) {
        this.obj.taskCancel(downloadTask);
    }

    @Override // com.arialyy.aria.core.scheduler.AptNormalTaskListener, com.arialyy.aria.core.scheduler.NormalTaskListenerInterface
    public void onTaskComplete(DownloadTask downloadTask) {
        this.obj.taskComplete(downloadTask);
    }

    @Override // com.arialyy.aria.core.scheduler.AptNormalTaskListener, com.arialyy.aria.core.scheduler.NormalTaskListenerInterface
    public void onTaskFail(DownloadTask downloadTask, Exception exc) {
        this.obj.taskFail(downloadTask);
    }

    @Override // com.arialyy.aria.core.scheduler.AptNormalTaskListener, com.arialyy.aria.core.scheduler.NormalTaskListenerInterface
    public void onTaskResume(DownloadTask downloadTask) {
        this.obj.taskResume(downloadTask);
    }

    @Override // com.arialyy.aria.core.scheduler.AptNormalTaskListener, com.arialyy.aria.core.scheduler.NormalTaskListenerInterface
    public void onTaskRunning(DownloadTask downloadTask) {
        this.obj.running(downloadTask);
    }

    @Override // com.arialyy.aria.core.scheduler.AptNormalTaskListener, com.arialyy.aria.core.scheduler.NormalTaskListenerInterface
    public void onTaskStart(DownloadTask downloadTask) {
        this.obj.taskStart(downloadTask);
    }

    @Override // com.arialyy.aria.core.scheduler.AptNormalTaskListener, com.arialyy.aria.core.scheduler.NormalTaskListenerInterface
    public void onTaskStop(DownloadTask downloadTask) {
        this.obj.taskStop(downloadTask);
    }

    @Override // com.arialyy.aria.core.scheduler.AptNormalTaskListener, com.arialyy.aria.core.scheduler.NormalTaskListenerInterface
    public void onWait(DownloadTask downloadTask) {
        this.obj.onWait(downloadTask);
    }
}
