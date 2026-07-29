package com.arialyy.aria.core.listener;

import android.os.Handler;
import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.task.AbsTask;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.exception.AriaException;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import com.arialyy.aria.util.ErrorHelp;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseListener implements IEventListener {
    public static final int RUN_SAVE_INTERVAL = 5000;
    private boolean isConvertSpeed;
    public AbsEntity mEntity;
    private long mLastLen;
    public long mLastSaveTime;
    private AbsTask mTask;
    public AbsTaskWrapper mTaskWrapper;
    private long mUpdateInterval;
    public SoftReference<Handler> outHandler;
    public String TAG = getClass().getSimpleName();
    private boolean isFirst = true;

    private void handleComplete() {
        this.mEntity.setComplete(true);
        this.mEntity.setCompleteTime(System.currentTimeMillis());
        AbsEntity absEntity = this.mEntity;
        absEntity.setCurrentProgress(absEntity.getFileSize());
        this.mEntity.setPercent(100);
        handleSpeed(0L);
    }

    private void handleSpeed(long j10) {
        long j11 = this.mUpdateInterval;
        if (j11 != 1000) {
            j10 = (j10 * 1000) / j11;
        }
        if (this.isConvertSpeed) {
            AbsEntity absEntity = this.mEntity;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(CommonUtil.formatFileSize(j10 < 0 ? 0.0d : j10));
            sb2.append("/s");
            absEntity.setConvertSpeed(sb2.toString());
        }
        this.mEntity.setSpeed(j10 < 0 ? 0L : j10);
        int requestType = this.mTaskWrapper.getRequestType();
        if (requestType != 7 && requestType != 8) {
            AbsEntity absEntity2 = this.mEntity;
            absEntity2.setPercent((int) (absEntity2.getFileSize() <= 0 ? 0L : (this.mEntity.getCurrentProgress() * 100) / this.mEntity.getFileSize()));
        }
        if (this.mEntity.getFileSize() != 0) {
            if (j10 == 0) {
                this.mEntity.setTimeLeft(Integer.MAX_VALUE);
            } else {
                AbsEntity absEntity3 = this.mEntity;
                absEntity3.setTimeLeft((int) ((absEntity3.getFileSize() - this.mEntity.getCurrentProgress()) / j10));
            }
        }
    }

    public <TASK extends AbsTask> TASK getTask(Class<TASK> cls) {
        return (TASK) this.mTask;
    }

    public abstract void handleCancel();

    @Override // com.arialyy.aria.core.listener.IEventListener
    public void onCancel() {
        saveData(7, -1L);
        handleSpeed(0L);
        if (this.mTask.getSchedulerType() != 4) {
            ALog.d(this.TAG, "删除任务完成");
            sendInState2Target(5);
        }
    }

    @Override // com.arialyy.aria.core.listener.IEventListener
    public void onComplete() {
        saveData(1, this.mEntity.getFileSize());
        handleSpeed(0L);
        sendInState2Target(6);
    }

    @Override // com.arialyy.aria.core.listener.IEventListener
    public void onFail(boolean z10, AriaException ariaException) throws Throwable {
        AbsEntity absEntity = this.mEntity;
        absEntity.setFailNum(absEntity.getFailNum() + 1);
        saveData(0, this.mEntity.getCurrentProgress());
        handleSpeed(0L);
        this.mTask.setNeedRetry(z10);
        this.mTask.putExpand(AbsTask.ERROR_INFO_KEY, ariaException);
        sendInState2Target(4);
        if (ariaException != null) {
            String exceptionString = ALog.getExceptionString(ariaException);
            ALog.e(this.TAG, exceptionString);
            ErrorHelp.saveError(ariaException.getMessage(), exceptionString);
        }
    }

    @Override // com.arialyy.aria.core.listener.IEventListener
    public void onPre() {
        saveData(5, -1L);
        sendInState2Target(0);
    }

    @Override // com.arialyy.aria.core.listener.IEventListener
    public void onProgress(long j10) {
        this.mEntity.setCurrentProgress(j10);
        long j11 = j10 - this.mLastLen;
        if (this.isFirst) {
            j11 = 0;
            this.isFirst = false;
        }
        handleSpeed(j11);
        sendInState2Target(7);
        if (System.currentTimeMillis() - this.mLastSaveTime >= 5000) {
            saveData(4, j10);
            this.mLastSaveTime = System.currentTimeMillis();
        }
        this.mLastLen = j10;
    }

    @Override // com.arialyy.aria.core.listener.IEventListener
    public void onResume(long j10) {
        saveData(4, j10);
        sendInState2Target(8);
    }

    @Override // com.arialyy.aria.core.listener.IEventListener
    public void onStart(long j10) {
        saveData(4, j10);
        sendInState2Target(2);
    }

    @Override // com.arialyy.aria.core.listener.IEventListener
    public void onStop(long j10) {
        saveData(this.mTask.getSchedulerType() == 3 ? 3 : 2, j10);
        handleSpeed(0L);
        sendInState2Target(3);
    }

    public void saveData(int i10, long j10) {
        this.mEntity.setState(i10);
        if (i10 == 7) {
            handleCancel();
            return;
        }
        if (i10 == 2) {
            this.mEntity.setStopTime(System.currentTimeMillis());
        } else if (i10 == 1) {
            handleComplete();
        }
        if (j10 > 0) {
            this.mEntity.setCurrentProgress(j10);
        }
        this.mEntity.update();
    }

    public void sendInState2Target(int i10) {
        if (this.outHandler.get() != null) {
            this.outHandler.get().obtainMessage(i10, this.mTask).sendToTarget();
        }
    }

    @Override // com.arialyy.aria.core.listener.IEventListener
    public IEventListener setParams(AbsTask absTask, Handler handler) {
        this.outHandler = new SoftReference<>(handler);
        AbsTask absTask2 = (AbsTask) new WeakReference(absTask).get();
        this.mTask = absTask2;
        this.mEntity = absTask2.getTaskWrapper().getEntity();
        AbsTaskWrapper taskWrapper = this.mTask.getTaskWrapper();
        this.mTaskWrapper = taskWrapper;
        this.isConvertSpeed = taskWrapper.getConfig().isConvertSpeed();
        this.mUpdateInterval = this.mTaskWrapper.getConfig().getUpdateInterval();
        this.mLastLen = this.mEntity.getCurrentProgress();
        this.mLastSaveTime = System.currentTimeMillis();
        this.TAG = CommonUtil.getClassName((Class) getClass());
        return this;
    }
}
