package a;

import androidx.appcompat.widget.ContentFrameLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class c1 implements ContentFrameLayout.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w1 f5748a;

    public c1(w1 w1Var) {
        this.f5748a = w1Var;
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.a
    public void a() {
    }

    @Override // androidx.appcompat.widget.ContentFrameLayout.a
    public void onDetachedFromWindow() {
        this.f5748a.Y();
    }
}
