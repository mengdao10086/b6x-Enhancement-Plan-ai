package com.arialyy.aria.core.command;

import com.arialyy.aria.core.download.DGTaskWrapper;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.DownloadGroupEntity;
import com.arialyy.aria.core.manager.TaskWrapperManager;
import com.arialyy.aria.core.queue.DGroupTaskQueue;
import com.arialyy.aria.core.queue.DTaskQueue;
import com.arialyy.aria.core.queue.UTaskQueue;
import com.arialyy.aria.core.upload.UTaskWrapper;
import com.arialyy.aria.core.upload.UploadEntity;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;
import com.arialyy.aria.orm.DbEntity;
import com.arialyy.aria.util.ALog;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class CancelAllCmd<T extends AbsTaskWrapper> extends AbsNormalCmd<T> {
    public boolean removeFile;

    public CancelAllCmd(T t10, int i10) {
        super(t10, i10);
        this.removeFile = false;
    }

    private void remove(AbsTaskWrapper absTaskWrapper) {
        if (absTaskWrapper == null) {
            ALog.w(this.TAG, "取消任务失败，任务为空");
            return;
        }
        if (absTaskWrapper instanceof DTaskWrapper) {
            this.mQueue = DTaskQueue.getInstance();
        } else if (absTaskWrapper instanceof UTaskWrapper) {
            this.mQueue = UTaskQueue.getInstance();
        } else if (absTaskWrapper instanceof DGTaskWrapper) {
            this.mQueue = DGroupTaskQueue.getInstance();
        }
        absTaskWrapper.setRemoveFile(this.removeFile);
        removeTask(absTaskWrapper);
    }

    private void removeAllDGTask() {
        List listFindDatas = DbEntity.findDatas(DownloadGroupEntity.class, "state!=?", "-1");
        if (listFindDatas == null || listFindDatas.isEmpty()) {
            return;
        }
        Iterator it2 = listFindDatas.iterator();
        while (it2.hasNext()) {
            remove(TaskWrapperManager.getInstance().getGroupWrapper(DGTaskWrapper.class, ((DownloadGroupEntity) it2.next()).getId()));
        }
    }

    private void removeAllDTask() {
        List listFindDatas = DbEntity.findDatas(DownloadEntity.class, "isGroupChild=?", "false");
        if (listFindDatas == null || listFindDatas.isEmpty()) {
            return;
        }
        Iterator it2 = listFindDatas.iterator();
        while (it2.hasNext()) {
            remove(TaskWrapperManager.getInstance().getNormalTaskWrapper(DTaskWrapper.class, ((DownloadEntity) it2.next()).getId()));
        }
    }

    private void removeUTask() {
        List listFindDatas = DbEntity.findDatas(UploadEntity.class, "isGroupChild=?", "false");
        if (listFindDatas == null || listFindDatas.isEmpty()) {
            return;
        }
        Iterator it2 = listFindDatas.iterator();
        while (it2.hasNext()) {
            remove(TaskWrapperManager.getInstance().getNormalTaskWrapper(UTaskWrapper.class, ((UploadEntity) it2.next()).getId()));
        }
    }

    @Override // com.arialyy.aria.core.command.ICmd
    public void executeCmd() {
        if (this.canExeCmd) {
            if (!this.isDownloadCmd) {
                removeUTask();
            } else {
                removeAllDTask();
                removeAllDGTask();
            }
        }
    }
}
