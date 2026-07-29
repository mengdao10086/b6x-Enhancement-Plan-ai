package com.arialyy.aria.core.command;

import com.arialyy.aria.core.download.AbsGroupTaskWrapper;

/* JADX INFO: loaded from: classes2.dex */
final class DGSubStartCmd<T extends AbsGroupTaskWrapper> extends AbsGroupCmd<T> {
    public DGSubStartCmd(T t10) {
        super(t10);
    }

    @Override // com.arialyy.aria.core.command.ICmd
    public void executeCmd() {
        if (checkTask()) {
            this.tempTask.startSubTask(this.childUrl);
        }
    }
}
