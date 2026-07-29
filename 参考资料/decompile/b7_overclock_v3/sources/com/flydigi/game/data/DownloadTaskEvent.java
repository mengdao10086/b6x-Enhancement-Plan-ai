package com.flydigi.game.data;

import com.arialyy.aria.core.task.DownloadTask;

/* JADX INFO: loaded from: classes7.dex */
public class DownloadTaskEvent {
    public static final int STATUS_CANCEL = 6;
    public static final int STATUS_COMPLETED = 8;
    public static final int STATUS_FAILED = 7;
    public static final int STATUS_NO_SUPPORT_BREAK_POINT = 10;
    public static final int STATUS_PRE = 2;
    public static final int STATUS_PROGRESS = 9;
    public static final int STATUS_RESUME = 3;
    public static final int STATUS_START = 4;
    public static final int STATUS_STOP = 5;
    public static final int STATUS_WAIT = 1;
    public DownloadTask mDownloadTask;
    public int mStatus;

    public DownloadTaskEvent(DownloadTask downloadTask, int i10) {
        this.mDownloadTask = downloadTask;
        this.mStatus = i10;
    }
}
