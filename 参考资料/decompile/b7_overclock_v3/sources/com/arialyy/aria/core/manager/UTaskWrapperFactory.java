package com.arialyy.aria.core.manager;

import com.arialyy.aria.core.upload.UTaskWrapper;
import com.arialyy.aria.core.upload.UploadEntity;
import com.arialyy.aria.orm.DbEntity;

/* JADX INFO: loaded from: classes2.dex */
class UTaskWrapperFactory implements INormalTEFactory<UploadEntity, UTaskWrapper> {
    private static volatile UTaskWrapperFactory INSTANCE = null;
    private static final String TAG = "UTaskWrapperFactory";

    private UTaskWrapperFactory() {
    }

    public static UTaskWrapperFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (UTaskWrapperFactory.class) {
                INSTANCE = new UTaskWrapperFactory();
            }
        }
        return INSTANCE;
    }

    private UploadEntity getUploadEntity(long j10) {
        UploadEntity uploadEntity = (UploadEntity) DbEntity.findFirst(UploadEntity.class, "rowid=?", String.valueOf(j10));
        return uploadEntity == null ? new UploadEntity() : uploadEntity;
    }

    @Override // com.arialyy.aria.core.manager.INormalTEFactory
    public UTaskWrapper create(long j10) {
        UTaskWrapper uTaskWrapper = j10 == -1 ? new UTaskWrapper(new UploadEntity()) : new UTaskWrapper(getUploadEntity(j10));
        uTaskWrapper.setRequestType(uTaskWrapper.getEntity().getTaskType());
        return uTaskWrapper;
    }
}
