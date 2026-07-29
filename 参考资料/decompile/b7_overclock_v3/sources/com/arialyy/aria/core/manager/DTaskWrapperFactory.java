package com.arialyy.aria.core.manager;

import com.arialyy.aria.core.TaskRecord;
import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.loader.IRecordHandler;
import com.arialyy.aria.orm.DbEntity;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
class DTaskWrapperFactory implements INormalTEFactory<DownloadEntity, DTaskWrapper> {
    private static volatile DTaskWrapperFactory INSTANCE;
    private final String TAG = "DTaskWrapperFactory";

    private DTaskWrapperFactory() {
    }

    private DownloadEntity getEntity(long j10) {
        DownloadEntity downloadEntity = (DownloadEntity) DbEntity.findFirst(DownloadEntity.class, "rowid=? and isGroupChild='false'", String.valueOf(j10));
        if (downloadEntity == null) {
            return new DownloadEntity();
        }
        File file = new File(downloadEntity.getFilePath());
        if (!downloadEntity.isComplete()) {
            TaskRecord taskRecord = (TaskRecord) DbEntity.findFirst(TaskRecord.class, "filePath=?", downloadEntity.getFilePath());
            if (taskRecord == null) {
                resetEntity(downloadEntity);
            } else if (taskRecord.isBlock) {
                int i10 = taskRecord.threadNum;
                int i11 = 0;
                for (int i12 = 0; i12 < i10; i12++) {
                    if (!new File(String.format(IRecordHandler.SUB_PATH, taskRecord.filePath, Integer.valueOf(i12))).exists()) {
                        i11++;
                    }
                }
                if (i11 == taskRecord.threadNum) {
                    resetEntity(downloadEntity);
                }
            } else if (!file.exists() && taskRecord.taskType != 7) {
                resetEntity(downloadEntity);
            }
        }
        return downloadEntity;
    }

    public static DTaskWrapperFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (DTaskWrapperFactory.class) {
                INSTANCE = new DTaskWrapperFactory();
            }
        }
        return INSTANCE;
    }

    private void resetEntity(DownloadEntity downloadEntity) {
        downloadEntity.setPercent(0);
        downloadEntity.setCompleteTime(0L);
        downloadEntity.setComplete(false);
        downloadEntity.setCurrentProgress(0L);
        downloadEntity.setState(3);
    }

    @Override // com.arialyy.aria.core.manager.INormalTEFactory
    public DTaskWrapper create(long j10) {
        DTaskWrapper dTaskWrapper = j10 == -1 ? new DTaskWrapper(new DownloadEntity()) : new DTaskWrapper(getEntity(j10));
        dTaskWrapper.setRequestType(dTaskWrapper.getEntity().getTaskType());
        return dTaskWrapper;
    }
}
