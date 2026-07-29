package com.arialyy.aria.core.command;

import com.arialyy.aria.core.download.DGTaskWrapper;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.queue.DGroupTaskQueue;
import com.arialyy.aria.core.queue.DTaskQueue;
import com.arialyy.aria.core.queue.UTaskQueue;
import com.arialyy.aria.core.task.AbsTask;
import com.arialyy.aria.core.upload.UTaskWrapper;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsNormalCmd<T extends AbsTaskWrapper> extends AbsCmd<T> {
    public boolean canExeCmd = true;
    public int taskType;

    public AbsNormalCmd(T t10, int i10) {
        boolean z10 = true;
        this.taskType = i10;
        this.mTaskWrapper = t10;
        String className = CommonUtil.getClassName(this);
        this.TAG = className;
        if (i10 == 1) {
            if (!(t10 instanceof DTaskWrapper)) {
                ALog.e(className, "任务类型错误，任务类型应该为ICM.TASK_TYPE_DOWNLOAD");
                return;
            }
            this.mQueue = DTaskQueue.getInstance();
        } else if (i10 == 3) {
            if (!(t10 instanceof DGTaskWrapper)) {
                ALog.e(className, "任务类型错误，任务类型应该为ICM.TASK_TYPE_DOWNLOAD_GROUP");
                return;
            }
            this.mQueue = DGroupTaskQueue.getInstance();
        } else if (i10 != 2) {
            ALog.e(className, "任务类型错误，任务类型应该为ICM.TASK_TYPE_DOWNLOAD、TASK_TYPE_DOWNLOAD_GROUP、TASK_TYPE_UPLOAD");
            return;
        } else {
            if (!(t10 instanceof UTaskWrapper)) {
                ALog.e(className, "任务类型错误，任务类型应该为ICM.TASK_TYPE_UPLOAD");
                return;
            }
            this.mQueue = UTaskQueue.getInstance();
        }
        if (i10 != 1 && i10 != 3) {
            z10 = false;
        }
        this.isDownloadCmd = z10;
    }

    public AbsTask createTask() {
        return this.mQueue.createTask(this.mTaskWrapper);
    }

    public AbsTask getTask() {
        return this.mQueue.getTask(this.mTaskWrapper.getEntity().getKey());
    }

    public void removeTask() {
        AbsTask task = getTask();
        if (task == null) {
            task = createTask();
        }
        this.mQueue.cancelTask(task);
    }

    public void resumeTask() {
        AbsTask task = getTask();
        if (task == null) {
            task = createTask();
        }
        this.mQueue.resumeTask(task);
    }

    public void sendWaitState() {
        AbsTask task = getTask();
        if (task == null) {
            task = createTask();
        }
        sendWaitState(task);
    }

    public void startTask() {
        AbsTask task = getTask();
        if (task == null) {
            task = createTask();
        }
        this.mQueue.startTask(task);
    }

    public void stopAll() {
        this.mQueue.stopAllTask();
    }

    public void stopTask() {
        AbsTask task = getTask();
        if (task == null) {
            task = createTask();
        }
        this.mQueue.stopTask(task);
    }

    public AbsTask createTask(AbsTaskWrapper absTaskWrapper) {
        return this.mQueue.createTask(absTaskWrapper);
    }

    public AbsTask getTask(String str) {
        return this.mQueue.getTask(str);
    }

    public void removeTask(AbsTaskWrapper absTaskWrapper) {
        AbsTask task = getTask(absTaskWrapper.getKey());
        if (task == null) {
            task = createTask(absTaskWrapper);
        }
        this.mQueue.cancelTask(task);
    }

    public void sendWaitState(AbsTask absTask) {
        if (absTask != null) {
            absTask.getTaskWrapper().setState(3);
            absTask.getOutHandler().obtainMessage(10, absTask).sendToTarget();
        }
    }
}
