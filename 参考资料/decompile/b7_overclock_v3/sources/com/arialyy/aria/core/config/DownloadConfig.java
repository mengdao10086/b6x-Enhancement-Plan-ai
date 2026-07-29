package com.arialyy.aria.core.config;

import com.arialyy.aria.core.event.DMaxNumEvent;
import com.arialyy.aria.core.event.DSpeedEvent;
import com.arialyy.aria.core.event.EventMsgUtil;
import com.arialyy.aria.util.ALog;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadConfig extends BaseTaskConfig implements Serializable {
    public int threadNum = 3;
    public boolean useBlock = true;
    public boolean useHeadRequest = false;

    public int getThreadNum() {
        return this.threadNum;
    }

    @Override // com.arialyy.aria.core.config.BaseConfig
    public int getType() {
        return 1;
    }

    public boolean isUseBlock() {
        return this.useBlock;
    }

    public boolean isUseHeadRequest() {
        return this.useHeadRequest;
    }

    public DownloadConfig setThreadNum(int i10) throws Throwable {
        this.threadNum = i10;
        save();
        return this;
    }

    public DownloadConfig setUseBlock(boolean z10) throws Throwable {
        this.useBlock = z10;
        save();
        return this;
    }

    public DownloadConfig setUseHeadRequest(boolean z10) throws Throwable {
        this.useHeadRequest = z10;
        save();
        return this;
    }

    @Override // com.arialyy.aria.core.config.BaseTaskConfig
    public DownloadConfig setMaxSpeed(int i10) throws Throwable {
        super.setMaxSpeed(i10);
        EventMsgUtil.getDefault().post(new DSpeedEvent(i10));
        return this;
    }

    @Override // com.arialyy.aria.core.config.BaseTaskConfig
    public DownloadConfig setMaxTaskNum(int i10) throws Throwable {
        if (i10 <= 0) {
            ALog.e(this.TAG, "下载任务最大任务数不能小于0");
            return this;
        }
        super.setMaxTaskNum(i10);
        EventMsgUtil.getDefault().post(new DMaxNumEvent(i10));
        return this;
    }
}
