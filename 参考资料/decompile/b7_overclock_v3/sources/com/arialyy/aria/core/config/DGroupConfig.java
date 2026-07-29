package com.arialyy.aria.core.config;

import com.arialyy.aria.core.AriaConfig;
import com.arialyy.aria.core.event.DGMaxNumEvent;
import com.arialyy.aria.core.event.DSpeedEvent;
import com.arialyy.aria.core.event.EventMsgUtil;
import com.arialyy.aria.util.ALog;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class DGroupConfig extends BaseTaskConfig implements Serializable {
    private DownloadConfig subConfig;
    public int subMaxTaskNum = 3;
    private boolean subFailAsStop = true;
    public int subReTryNum = 5;
    public int subReTryInterval = 2000;

    public DGroupConfig() {
        getSubConfig();
    }

    public DownloadConfig getSubConfig() {
        DownloadConfig dConfig = AriaConfig.getInstance().getDConfig();
        this.subConfig = dConfig;
        return dConfig;
    }

    public int getSubMaxTaskNum() {
        return this.subMaxTaskNum;
    }

    public int getSubReTryInterval() {
        return this.subReTryInterval;
    }

    public int getSubReTryNum() {
        return this.subReTryNum;
    }

    @Override // com.arialyy.aria.core.config.BaseConfig
    public int getType() {
        return 4;
    }

    public boolean isSubFailAsStop() {
        return this.subFailAsStop;
    }

    public DGroupConfig setSubFailAsStop(boolean z10) throws Throwable {
        this.subFailAsStop = z10;
        save();
        return this;
    }

    public DGroupConfig setSubMaxTaskNum(int i10) throws Throwable {
        this.subMaxTaskNum = i10;
        save();
        return this;
    }

    public DGroupConfig setSubReTryInterval(int i10) throws Throwable {
        this.subReTryInterval = i10;
        this.subConfig.reTryInterval = i10;
        save();
        return this;
    }

    public DGroupConfig setSubReTryNum(int i10) throws Throwable {
        this.subReTryNum = i10;
        this.subConfig.reTryNum = i10;
        save();
        return this;
    }

    @Override // com.arialyy.aria.core.config.BaseTaskConfig
    public DGroupConfig setMaxSpeed(int i10) throws Throwable {
        super.setMaxSpeed(i10);
        EventMsgUtil.getDefault().post(new DSpeedEvent(i10));
        return this;
    }

    @Override // com.arialyy.aria.core.config.BaseTaskConfig
    public DGroupConfig setMaxTaskNum(int i10) throws Throwable {
        if (i10 <= 0) {
            ALog.e(this.TAG, "组合任务最大任务数不能小于0");
            return this;
        }
        super.setMaxTaskNum(i10);
        EventMsgUtil.getDefault().post(new DGMaxNumEvent(i10));
        return this;
    }
}
