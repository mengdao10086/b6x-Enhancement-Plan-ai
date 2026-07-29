package com.arialyy.aria.core.event;

/* JADX INFO: loaded from: classes2.dex */
public class ErrorEvent {
    public String errorMsg;
    public long taskId;

    public ErrorEvent(long j10, String str) {
        this.taskId = j10;
        this.errorMsg = str;
    }
}
