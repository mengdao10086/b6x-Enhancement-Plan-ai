package com.arialyy.aria.core.command;

import com.arialyy.aria.core.download.AbsGroupTaskWrapper;
import com.arialyy.aria.core.wrapper.AbsTaskWrapper;

/* JADX INFO: loaded from: classes2.dex */
public class CmdHelper {
    public static <T extends AbsGroupTaskWrapper> AbsGroupCmd createGroupCmd(T t10, int i10, String str) {
        return GroupCmdFactory.getInstance().createCmd(t10, i10, str);
    }

    public static <T extends AbsTaskWrapper> AbsNormalCmd createNormalCmd(T t10, int i10, int i11) {
        return NormalCmdFactory.getInstance().createCmd((AbsTaskWrapper) t10, i10, i11);
    }
}
