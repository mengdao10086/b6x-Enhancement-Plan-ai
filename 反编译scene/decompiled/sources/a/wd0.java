package a;

import com.omarea.krscript.model.PickerNode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class wd0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fe0 f7777a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ PickerNode f3425a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f3426a;

    public wd0(fe0 fe0Var, PickerNode pickerNode, Runnable runnable) {
        this.f7777a = fe0Var;
        this.f3425a = pickerNode;
        this.f3426a = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7777a.N1(this.f3425a, this.f3426a);
    }
}
