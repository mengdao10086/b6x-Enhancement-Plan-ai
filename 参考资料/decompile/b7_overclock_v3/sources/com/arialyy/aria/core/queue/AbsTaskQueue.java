package com.arialyy.aria.core.queue;

import android.text.TextUtils;
import com.arialyy.aria.core.common.AbsEntity;
import com.arialyy.aria.core.manager.TaskWrapperManager;
import com.arialyy.aria.core.manager.ThreadTaskManager;
import com.arialyy.aria.core.queue.pool.BaseCachePool;
import com.arialyy.aria.core.queue.pool.BaseExecutePool;
import com.arialyy.aria.core.queue.pool.DGLoadSharePool;
import com.arialyy.aria.core.queue.pool.DLoadSharePool;
import com.arialyy.aria.core.queue.pool.UploadSharePool;
import com.arialyy.aria.core.task.AbsTask;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbsTaskQueue<TASK extends AbsTask, TASK_WRAPPER extends AbsTaskWrapper> implements ITaskQueue<TASK, TASK_WRAPPER> {
    public BaseCachePool<TASK> mCachePool;
    public BaseExecutePool<TASK> mExecutePool;
    public final int TYPE_D_QUEUE = 1;
    public final int TYPE_DG_QUEUE = 2;
    public final int TYPE_U_QUEUE = 3;
    private final String TAG = CommonUtil.getClassName(this);

    public AbsTaskQueue() {
        int queueType = getQueueType();
        if (queueType == 1) {
            this.mCachePool = DLoadSharePool.getInstance().cachePool;
            this.mExecutePool = DLoadSharePool.getInstance().executePool;
        } else if (queueType == 2) {
            this.mCachePool = DGLoadSharePool.getInstance().cachePool;
            this.mExecutePool = DGLoadSharePool.getInstance().executePool;
        } else {
            if (queueType != 3) {
                return;
            }
            this.mCachePool = UploadSharePool.getInstance().cachePool;
            this.mExecutePool = UploadSharePool.getInstance().executePool;
        }
    }

    public void addTask(TASK task) {
        if (task == null) {
            ALog.w(this.TAG, "add task fail, task is null");
        } else {
            if (this.mCachePool.taskExits(task.getKey())) {
                return;
            }
            this.mCachePool.putTask(task);
        }
    }

    public BaseCachePool getCachePool() {
        return this.mCachePool;
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public int getCurrentCachePoolNum() {
        return this.mCachePool.size();
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public int getCurrentExePoolNum() {
        return this.mExecutePool.size();
    }

    public BaseExecutePool getExecutePool() {
        return this.mExecutePool;
    }

    public abstract int getOldMaxNum();

    public abstract int getQueueType();

    public <T extends AbsEntity> List<T> getRunningTask(Class<T> cls) {
        List<TASK> allTask = this.mExecutePool.getAllTask();
        List<TASK> allTask2 = this.mCachePool.getAllTask();
        ArrayList arrayList = new ArrayList();
        if (allTask != null && !allTask.isEmpty()) {
            Iterator<TASK> it2 = allTask.iterator();
            while (it2.hasNext()) {
                arrayList.add(it2.next().getTaskWrapper().getEntity());
            }
        }
        if (allTask2 != null && !allTask2.isEmpty()) {
            Iterator<TASK> it3 = allTask2.iterator();
            while (it3.hasNext()) {
                arrayList.add(it3.next().getTaskWrapper().getEntity());
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public void removeTaskFormQueue(String str) {
        AbsTask task = this.mExecutePool.getTask(str);
        if (task != null) {
            String str2 = this.TAG;
            Object[] objArr = new Object[2];
            objArr[0] = task.getTaskName();
            objArr[1] = this.mExecutePool.removeTask(task) ? "成功" : "失败";
            ALog.d(str2, String.format("从执行池删除任务【%s】%s", objArr));
        }
        AbsTask task2 = this.mCachePool.getTask(str);
        if (task2 != null) {
            String str3 = this.TAG;
            Object[] objArr2 = new Object[2];
            objArr2[0] = task2.getTaskName();
            objArr2[1] = this.mCachePool.removeTask(task2) ? "成功" : "失败";
            ALog.d(str3, String.format("从缓存池删除任务【%s】%s", objArr2));
        }
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public void setMaxTaskNum(int i10) {
        int oldMaxNum = getOldMaxNum();
        int i11 = i10 - oldMaxNum;
        if (oldMaxNum == i10) {
            ALog.w(this.TAG, "设置的下载任务数和配置文件的下载任务数一直，跳过");
            return;
        }
        if (i11 <= -1 && this.mExecutePool.size() >= oldMaxNum) {
            int iAbs = Math.abs(i11);
            for (int i12 = 0; i12 < iAbs; i12++) {
                AbsTask absTaskPollTask = this.mExecutePool.pollTask();
                if (absTaskPollTask != null) {
                    stopTask(absTaskPollTask);
                }
            }
        }
        this.mExecutePool.setMaxNum(i10);
        if (i11 >= 1) {
            for (int i13 = 0; i13 < i11; i13++) {
                AbsTask nextTask = getNextTask();
                if (nextTask != null && nextTask.getState() == 3) {
                    startTask(nextTask);
                }
            }
        }
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public void stopAllTask() {
        for (TASK task : this.mExecutePool.getAllTask()) {
            if (task != null) {
                int state = task.getState();
                if (task.isRunning() || (state != 1 && state != 7)) {
                    task.stop(2);
                }
            }
        }
        for (TASK task2 : this.mCachePool.getAllTask()) {
            if (task2 != null) {
                task2.stop(2);
            }
        }
        ThreadTaskManager.getInstance().removeAllThreadTask();
        this.mCachePool.clear();
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public boolean taskExists(String str) {
        return getTask(str) != null;
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public boolean taskIsRunning(String str) {
        if (TextUtils.isEmpty(str)) {
            ALog.w(this.TAG, "key为空，无法确认任务是否执行");
            return false;
        }
        AbsTask task = this.mExecutePool.getTask(str);
        if (task == null && ThreadTaskManager.getInstance().taskIsRunning(str)) {
            ThreadTaskManager.getInstance().removeTaskThread(str);
        }
        return task != null && task.isRunning() && taskExists(str);
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public TASK createTask(TASK_WRAPPER task_wrapper) {
        TaskWrapperManager.getInstance().putTaskWrapper(task_wrapper);
        return null;
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public TASK getNextTask() {
        return (TASK) this.mCachePool.pollTask();
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public TASK getTask(String str) {
        TASK task = (TASK) this.mExecutePool.getTask(str);
        if (task == null) {
            task = (TASK) this.mCachePool.getTask(str);
        }
        ALog.i(this.TAG, "获取任务，key：" + str);
        return task;
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public void reTryStart(TASK task) {
        if (task == null) {
            ALog.e(this.TAG, "reTry fail, task is null");
        }
        switch (task.getState()) {
            case -1:
            case 0:
            case 2:
            case 3:
                task.start();
                break;
            case 1:
                ALog.e(this.TAG, String.format("任务【%s】重试失败，原因：已完成", task.getTaskName()));
                break;
            case 4:
            case 5:
            case 6:
                ALog.w(this.TAG, String.format("任务【%s】没有停止，即将重新下载", task.getTaskName()));
                task.stop(2);
                task.start();
                break;
            case 7:
                ALog.e(this.TAG, String.format("任务【%s】重试失败，原因：任务已删除", task.getTaskName()));
                break;
        }
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public void resumeTask(TASK task) {
        if (task == null) {
            ALog.w(this.TAG, "resume task fail, task is null");
            return;
        }
        if (this.mExecutePool.taskExits(task.getKey())) {
            ALog.w(this.TAG, String.format("task【%s】running", task.getKey()));
        } else {
            if (this.mExecutePool.size() < getMaxTaskNum()) {
                startTask((AbsTask) task);
                return;
            }
            task.getTaskWrapper().getEntity().setState(3);
            this.mCachePool.putTaskToFirst(task);
            stopTask(this.mExecutePool.pollTask());
        }
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public void stopTask(TASK task) {
        if (task == null) {
            ALog.w(this.TAG, "stop fail, task is null");
            return;
        }
        boolean z10 = false;
        switch (task.getState()) {
            case -1:
            case 0:
            case 2:
                ALog.w(this.TAG, String.format("停止任务【%s】失败，原因：已停止", task.getTaskName()));
                if (taskIsRunning(task.getKey())) {
                    removeTaskFormQueue(task.getKey());
                    if (ThreadTaskManager.getInstance().taskIsRunning(task.getKey())) {
                        ThreadTaskManager.getInstance().removeTaskThread(task.getKey());
                    }
                }
                break;
            case 1:
                ALog.w(this.TAG, String.format("停止任务【%s】失败，原因：已完成", task.getTaskName()));
                break;
            case 3:
                this.mCachePool.removeTask(task);
                z10 = true;
                break;
            case 4:
            case 5:
            case 6:
                this.mExecutePool.removeTask(task);
                z10 = true;
                break;
            case 7:
                ALog.w(this.TAG, String.format("停止任务【%s】失败，原因：任务已删除", task.getTaskName()));
                break;
        }
        if (z10) {
            task.stop();
        }
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public void cancelTask(TASK task) {
        cancelTask((AbsTask) task, 1);
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public void startTask(TASK task) {
        startTask((AbsTask) task, 1);
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public void cancelTask(TASK task, int i10) {
        task.cancel(i10);
    }

    @Override // com.arialyy.aria.core.queue.ITaskQueue
    public void startTask(TASK task, int i10) {
        if (task == null) {
            ALog.w(this.TAG, "create fail, task is null");
        }
        if (this.mExecutePool.taskExits(task.getKey())) {
            ALog.w(this.TAG, String.format("任务【%s】执行中", task.getKey()));
            return;
        }
        ALog.i(this.TAG, "添加任务，key：" + task.getKey());
        this.mCachePool.removeTask(task);
        this.mExecutePool.putTask(task);
        task.getTaskWrapper().getEntity().setFailNum(0);
        task.start(i10);
    }
}
