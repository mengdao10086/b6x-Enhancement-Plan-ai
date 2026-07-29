package com.arialyy.aria.core.command;

import com.arialyy.aria.core.wrapper.AbsTaskWrapper;

/* JADX INFO: loaded from: classes2.dex */
public class NormalCmdFactory extends AbsCmdFactory<AbsTaskWrapper, AbsNormalCmd> {
    private static volatile NormalCmdFactory INSTANCE = null;
    public static final int TASK_CANCEL = 180;
    public static final int TASK_CANCEL_ALL = 185;
    public static final int TASK_CREATE = 177;
    public static final int TASK_HIGHEST_PRIORITY = 182;
    public static final int TASK_RESTART = 186;
    public static final int TASK_RESUME = 179;
    public static final int TASK_RESUME_ALL = 184;
    public static final int TASK_START = 178;
    public static final int TASK_STOP = 181;
    public static final int TASK_STOP_ALL = 183;

    private NormalCmdFactory() {
    }

    public static NormalCmdFactory getInstance() {
        if (INSTANCE == null) {
            synchronized (NormalCmdFactory.class) {
                INSTANCE = new NormalCmdFactory();
            }
        }
        return INSTANCE;
    }

    @Override // com.arialyy.aria.core.command.AbsCmdFactory
    public AbsNormalCmd createCmd(AbsTaskWrapper absTaskWrapper, int i10, int i11) {
        switch (i10) {
            case 177:
                return new AddCmd(absTaskWrapper, i11);
            case 178:
            case 179:
                return new StartCmd(absTaskWrapper, i11);
            case 180:
                return new CancelCmd(absTaskWrapper, i11);
            case 181:
                return new StopCmd(absTaskWrapper, i11);
            case 182:
                return new HighestPriorityCmd(absTaskWrapper, i11);
            case 183:
                return new StopAllCmd(absTaskWrapper, i11);
            case 184:
                return new ResumeAllCmd(absTaskWrapper, i11);
            case TASK_CANCEL_ALL /* 185 */:
                return new CancelAllCmd(absTaskWrapper, i11);
            case 186:
                return new ReStartCmd(absTaskWrapper, i11);
            default:
                return null;
        }
    }
}
