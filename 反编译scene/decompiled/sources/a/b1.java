package a;

import a.i7;
import android.graphics.Rect;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class b1 implements i7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w1 f5661a;

    public b1(w1 w1Var) {
        this.f5661a = w1Var;
    }

    @Override // a.i7.a
    public void a(Rect rect) {
        rect.top = this.f5661a.Q0(null, rect);
    }
}
