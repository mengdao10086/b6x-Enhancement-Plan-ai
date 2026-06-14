package com.omarea.krscript.model;

import a.b92;
import a.f92;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class RunnableNode extends ClickableNode {
    public boolean autoFinish;
    public boolean autoOff;
    public boolean confirm;
    public boolean interruptable;
    public boolean reloadPage;
    public String setState;
    public String shell;
    public String[] updateBlocks;
    public String warning;
    public static final Companion Companion = new Companion(null);
    public static final String shellModeDefault = "default";
    public static final String shellModeBgTask = "bg-task";
    public static final String shellModeHidden = "hidden";

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(b92 b92Var) {
            this();
        }

        public final String getShellModeBgTask() {
            return RunnableNode.shellModeBgTask;
        }

        public final String getShellModeDefault() {
            return RunnableNode.shellModeDefault;
        }

        public final String getShellModeHidden() {
            return RunnableNode.shellModeHidden;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RunnableNode(String str) {
        super(str);
        f92.d(str, "currentConfigXml");
        this.warning = "";
        this.interruptable = true;
        this.shell = shellModeDefault;
    }

    public final boolean getAutoFinish() {
        return this.autoFinish;
    }

    public final boolean getAutoOff() {
        return this.autoOff;
    }

    public final boolean getConfirm() {
        return this.confirm;
    }

    public final boolean getInterruptable() {
        return this.interruptable;
    }

    public final boolean getReloadPage() {
        return this.reloadPage;
    }

    public final String getSetState() {
        return this.setState;
    }

    public final String getShell() {
        return this.shell;
    }

    public final String[] getUpdateBlocks() {
        return this.updateBlocks;
    }

    public final String getWarning() {
        return this.warning;
    }

    public final void setAutoFinish(boolean z) {
        this.autoFinish = z;
    }

    public final void setAutoOff(boolean z) {
        this.autoOff = z;
    }

    public final void setConfirm(boolean z) {
        this.confirm = z;
    }

    public final void setInterruptable(boolean z) {
        this.interruptable = z;
    }

    public final void setReloadPage(boolean z) {
        this.reloadPage = z;
    }

    public final void setSetState(String str) {
        this.setState = str;
    }

    public final void setShell(String str) {
        f92.d(str, "<set-?>");
        this.shell = str;
    }

    public final void setUpdateBlocks(String[] strArr) {
        this.updateBlocks = strArr;
    }

    public final void setWarning(String str) {
        f92.d(str, "<set-?>");
        this.warning = str;
    }
}
