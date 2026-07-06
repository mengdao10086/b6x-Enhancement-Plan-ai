package a;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ks1 implements ck0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ls1 f6637a;

    public ks1(ls1 ls1Var) {
        this.f6637a = ls1Var;
    }

    @Override // a.ck0
    public final void a(gk0 gk0Var) {
        try {
            this.f6637a.f1849a.d = gk0Var.b + ' ' + gk0Var.c + '\n' + gk0Var.f6215a;
            Scene.f4798a.m("gpu_info", this.f6637a.f1849a.d);
            ((LinearLayout) this.f6637a.f1849a.w1(t61.home_gpu)).removeView((FrameLayout) this.f6637a.f1849a.w1(t61.home_gpu_info));
        } catch (Exception unused) {
        }
    }
}
