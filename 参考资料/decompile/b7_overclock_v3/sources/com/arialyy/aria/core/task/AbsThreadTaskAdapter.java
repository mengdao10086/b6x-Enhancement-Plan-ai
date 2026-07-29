package com.arialyy.aria.core.task;

import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.common.SubThreadConfig;
import com.arialyy.aria.core.config.BaseTaskConfig;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.exception.AriaException;
import com.arialyy.aria.util.BandwidthLimiter;
import com.arialyy.aria.util.CommonUtil;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsThreadTaskAdapter implements IThreadTaskAdapter {
    public String TAG = CommonUtil.getClassName((Class) getClass());
    private IThreadTaskObserver mObserver;
    public BandwidthLimiter mSpeedBandUtil;
    private SubThreadConfig mThreadConfig;
    private ThreadRecord mThreadRecord;
    private IThreadTask mThreadTask;
    private AbsTaskWrapper mWrapper;

    public AbsThreadTaskAdapter(SubThreadConfig subThreadConfig) {
        this.mThreadRecord = subThreadConfig.record;
        this.mWrapper = subThreadConfig.taskWrapper;
        this.mThreadConfig = subThreadConfig;
        if (getTaskConfig().getMaxSpeed() > 0) {
            this.mSpeedBandUtil = new BandwidthLimiter(getTaskConfig().getMaxSpeed(), subThreadConfig.startThreadNum);
        }
    }

    @Override // com.arialyy.aria.core.task.IThreadTaskAdapter
    public void attach(IThreadTaskObserver iThreadTaskObserver) {
        this.mObserver = iThreadTaskObserver;
    }

    @Override // com.arialyy.aria.core.task.IThreadTaskAdapter
    public void call(IThreadTask iThreadTask) throws Exception {
        this.mThreadTask = iThreadTask;
        handlerThreadTask();
    }

    public void complete() {
        IThreadTaskObserver iThreadTaskObserver = this.mObserver;
        if (iThreadTaskObserver != null) {
            iThreadTaskObserver.updateCompleteState();
        }
    }

    public void fail(AriaException ariaException, boolean z10) {
        IThreadTaskObserver iThreadTaskObserver = this.mObserver;
        if (iThreadTaskObserver != null) {
            iThreadTaskObserver.updateFailState(ariaException, z10);
        }
    }

    public long getRangeProgress() {
        return this.mObserver.getThreadProgress();
    }

    public BaseTaskConfig getTaskConfig() {
        return getTaskWrapper().getConfig();
    }

    public AbsTaskWrapper getTaskWrapper() {
        return this.mWrapper;
    }

    public SubThreadConfig getThreadConfig() {
        return this.mThreadConfig;
    }

    public ThreadRecord getThreadRecord() {
        return this.mThreadRecord;
    }

    public IThreadTask getThreadTask() {
        return this.mThreadTask;
    }

    public abstract void handlerThreadTask();

    public void progress(long j10) {
        IThreadTaskObserver iThreadTaskObserver = this.mObserver;
        if (iThreadTaskObserver != null) {
            iThreadTaskObserver.updateProgress(j10);
        }
    }

    @Override // com.arialyy.aria.core.task.IThreadTaskAdapter
    public void setMaxSpeed(int i10) {
        if (this.mSpeedBandUtil == null) {
            this.mSpeedBandUtil = new BandwidthLimiter(getTaskConfig().getMaxSpeed(), getThreadConfig().startThreadNum);
        }
        this.mSpeedBandUtil.setMaxRate(i10);
    }
}
