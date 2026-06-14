package a;

import com.omarea.krscript.model.PickerNode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xd0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fe0 f7878a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ PickerNode f3573a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f3574a;

    public xd0(fe0 fe0Var, PickerNode pickerNode, Runnable runnable) {
        this.f7878a = fe0Var;
        this.f3573a = pickerNode;
        this.f3574a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7878a.N1(this.f3573a, this.f3574a);
    }
}
