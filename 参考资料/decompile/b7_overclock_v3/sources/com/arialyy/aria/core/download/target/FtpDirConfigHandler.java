package com.arialyy.aria.core.download.target;

import com.arialyy.aria.core.download.DTaskWrapper;
import com.arialyy.aria.core.inf.AbsTarget;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class FtpDirConfigHandler<TARGET extends AbsTarget> extends AbsGroupConfigHandler<TARGET> {
    public FtpDirConfigHandler(TARGET target, long j10) {
        super(target, j10);
        init();
    }

    private void init() {
        getTaskWrapper().setRequestType(4);
        List<DTaskWrapper> subTaskWrapper = getTaskWrapper().getSubTaskWrapper();
        if (subTaskWrapper.isEmpty()) {
            return;
        }
        for (DTaskWrapper dTaskWrapper : subTaskWrapper) {
            dTaskWrapper.setRequestType(3);
            dTaskWrapper.getEntity().setTaskType(3);
        }
    }
}
