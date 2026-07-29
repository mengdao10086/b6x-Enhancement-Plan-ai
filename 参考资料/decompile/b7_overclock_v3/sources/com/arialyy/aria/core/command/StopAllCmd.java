package com.arialyy.aria.core.command;

import com.arialyy.aria.core.wrapper.AbsTaskWrapper;

/* JADX INFO: loaded from: classes2.dex */
final class StopAllCmd<T extends AbsTaskWrapper> extends AbsNormalCmd<T> {
    public StopAllCmd(T t10, int i10) {
        super(t10, i10);
    }

    @Override // com.arialyy.aria.core.command.ICmd
    public void executeCmd() {
        stopAll();
    }
}
