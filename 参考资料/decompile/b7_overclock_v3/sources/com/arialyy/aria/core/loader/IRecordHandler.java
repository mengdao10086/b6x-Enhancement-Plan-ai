package com.arialyy.aria.core.loader;

import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.ThreadRecord;

/* JADX INFO: loaded from: classes2.dex */
public interface IRecordHandler extends ILoaderComponent {
    public static final String RECORD = "_record_";
    public static final String STATE = "_state_";
    public static final long SUB_LEN = 1048576;
    public static final String SUB_PATH = "%s.%s.part";
    public static final int TYPE_DOWNLOAD = 1;
    public static final int TYPE_M3U8_LIVE = 4;
    public static final int TYPE_M3U8_VOD = 3;
    public static final int TYPE_UPLOAD = 2;

    boolean checkTaskCompleted();

    TaskRecord createTaskRecord(int i10);

    ThreadRecord createThreadRecord(TaskRecord taskRecord, int i10, long j10, long j11);

    TaskRecord getRecord(long j10);

    void handlerTaskRecord(TaskRecord taskRecord);

    int initTaskThreadNum();

    void onPre();
}
