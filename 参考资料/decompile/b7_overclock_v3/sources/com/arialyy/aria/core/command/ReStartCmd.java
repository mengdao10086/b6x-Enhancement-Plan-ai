package com.arialyy.aria.core.command;

import com.arialyy.aria.core.task.AbsTask;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;

/* JADX INFO: loaded from: classes2.dex */
final class ReStartCmd<T extends AbsTaskWrapper> extends AbsNormalCmd<T> {
    public ReStartCmd(T t10, int i10) {
        super(t10, i10);
    }

    @Override // com.arialyy.aria.core.command.ICmd
    public void executeCmd() {
        AbsTask task = getTask();
        if (task == null) {
            task = createTask();
        }
        if (task != null) {
            this.mQueue.cancelTask(task, 4);
            this.mQueue.startTask(task, 5);
        }
    }
}
