package a;

import android.view.View;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xz1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l02 f7934a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n92 f3640a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f3641a;
    public final /* synthetic */ Runnable b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ boolean f3642b;

    public xz1(l02 l02Var, boolean z, Runnable runnable, n92 n92Var, Runnable runnable2) {
        this.f7934a = l02Var;
        this.f3642b = z;
        this.f3641a = runnable;
        this.f3640a = n92Var;
        this.b = runnable2;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [T, java.lang.String] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f7934a.n()) {
            hz0.f1282a.J0(false);
        }
        if (this.f3642b) {
            Scene.c.p(Scene.f4798a, "Unknown App!", 0, 2, null);
            return;
        }
        this.f3641a.run();
        n92 n92Var = this.f3640a;
        f92.c(view, "self");
        n92Var.f6891a = view.getTag().toString();
        this.b.run();
    }
}
