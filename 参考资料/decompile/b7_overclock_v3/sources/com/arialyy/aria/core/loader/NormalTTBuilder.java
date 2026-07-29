package com.arialyy.aria.core.loader;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.ThreadRecord;
import com.arialyy.aria.core.common.AbsNormalEntity;
import com.arialyy.aria.core.common.SubThreadConfig;
import com.arialyy.aria.core.download.DGTaskWrapper;
import com.arialyy.aria.core.inf.IThreadStateManager;
import com.arialyy.aria.core.task.IThreadTask;
import com.arialyy.aria.core.task.ThreadTask;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CommonUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class NormalTTBuilder implements IThreadTaskBuilder {
    public String TAG = CommonUtil.getClassName(this);
    private AbsNormalTTBuilderAdapter mAdapter;
    private TaskRecord mRecord;
    private int mStartThreadNum;
    private Handler mStateHandler;
    private int mTotalThreadNum;
    private AbsTaskWrapper mWrapper;

    public NormalTTBuilder(AbsTaskWrapper absTaskWrapper, AbsNormalTTBuilderAdapter absNormalTTBuilderAdapter) {
        if (absTaskWrapper instanceof DGTaskWrapper) {
            throw new AssertionError("NormalTTBuilder 不适用于组合任务");
        }
        this.mWrapper = absTaskWrapper;
        this.mAdapter = absNormalTTBuilderAdapter;
        absNormalTTBuilderAdapter.setWrapper(absTaskWrapper);
    }

    private IThreadTask createSingThreadTask(ThreadRecord threadRecord, int i10) {
        return createThreadTask(this.mAdapter.getSubThreadConfig(this.mStateHandler, threadRecord, this.mRecord.isBlock, i10));
    }

    private IThreadTask createThreadTask(SubThreadConfig subThreadConfig) {
        ThreadTask threadTask = new ThreadTask(subThreadConfig);
        threadTask.setAdapter(this.mAdapter.getAdapter(subThreadConfig));
        return threadTask;
    }

    private List<IThreadTask> handleBreakpoint() {
        Object obj;
        long fileSize = getEntity().getFileSize();
        long j10 = fileSize / ((long) this.mTotalThreadNum);
        ArrayList arrayList = new ArrayList(this.mTotalThreadNum);
        this.mRecord.fileLength = fileSize;
        if (this.mWrapper.isNewTask() && !this.mAdapter.handleNewTask(this.mRecord, this.mTotalThreadNum)) {
            ALog.e(this.TAG, "初始化线程任务失败");
            return null;
        }
        Iterator<ThreadRecord> it2 = this.mRecord.threadRecords.iterator();
        while (it2.hasNext()) {
            if (!it2.next().isComplete) {
                this.mStartThreadNum++;
            }
        }
        long j11 = 0;
        int i10 = 0;
        while (i10 < this.mTotalThreadNum) {
            long j12 = ((long) i10) * j10;
            int i11 = i10 + 1;
            long j13 = ((long) i11) * j10;
            ThreadRecord threadRecord = this.mRecord.threadRecords.get(i10);
            long j14 = fileSize;
            if (threadRecord.isComplete) {
                j11 += j13 - j12;
                ALog.d(this.TAG, String.format("任务【%s】线程__%s__已完成", this.mWrapper.getKey(), Integer.valueOf(i10)));
                Message messageObtainMessage = this.mStateHandler.obtainMessage();
                messageObtainMessage.what = 4;
                Bundle data = messageObtainMessage.getData();
                if (data == null) {
                    data = new Bundle();
                }
                data.putString(IThreadStateManager.DATA_THREAD_NAME, CommonUtil.getThreadName(getEntity().getKey(), threadRecord.threadId));
                messageObtainMessage.setData(data);
                messageObtainMessage.sendToTarget();
                obj = null;
            } else {
                long j15 = threadRecord.startLocation;
                if (j12 < j15) {
                    if (i10 == this.mTotalThreadNum - 1) {
                        j13 = j14;
                    }
                    if (j15 <= j13) {
                        j11 += j15 - j12;
                    }
                }
                ALog.d(this.TAG, String.format("任务【%s】线程__%s__恢复任务", getEntity().getFileName(), Integer.valueOf(i10)));
                IThreadTask iThreadTaskCreateSingThreadTask = createSingThreadTask(threadRecord, this.mStartThreadNum);
                if (iThreadTaskCreateSingThreadTask == null) {
                    ALog.e(this.TAG, "创建线程任务失败");
                    return null;
                }
                obj = null;
                arrayList.add(iThreadTaskCreateSingThreadTask);
            }
            i10 = i11;
            fileSize = j14;
        }
        if (j11 != getEntity().getCurrentProgress()) {
            ALog.d(this.TAG, String.format("进度修正，当前进度：%s", Long.valueOf(j11)));
            getEntity().setCurrentProgress(j11);
        }
        return arrayList;
    }

    private List<IThreadTask> handleNoSupportBP() {
        ArrayList arrayList = new ArrayList();
        this.mStartThreadNum = 1;
        TaskRecord taskRecord = this.mRecord;
        taskRecord.isBlock = false;
        taskRecord.update();
        arrayList.add(createSingThreadTask(this.mRecord.threadRecords.get(0), 1));
        return arrayList;
    }

    private List<IThreadTask> handleTask() {
        return this.mWrapper.isSupportBP() ? handleBreakpoint() : handleNoSupportBP();
    }

    @Override // com.arialyy.aria.core.loader.ILoaderComponent
    public void accept(ILoaderVisitor iLoaderVisitor) {
        iLoaderVisitor.addComponent(this);
    }

    @Override // com.arialyy.aria.core.loader.IThreadTaskBuilder
    public List<IThreadTask> buildThreadTask(TaskRecord taskRecord, Handler handler) {
        this.mRecord = taskRecord;
        this.mStateHandler = handler;
        this.mTotalThreadNum = taskRecord.threadNum;
        return handleTask();
    }

    public AbsNormalTTBuilderAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // com.arialyy.aria.core.loader.IThreadTaskBuilder
    public int getCreatedThreadNum() {
        return this.mStartThreadNum;
    }

    public AbsNormalEntity getEntity() {
        return (AbsNormalEntity) this.mWrapper.getEntity();
    }
}
