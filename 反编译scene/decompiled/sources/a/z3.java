package a;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class z3 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e4 f8031a;

    public z3(e4 e4Var) {
        this.f8031a = e4Var;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (!this.f8031a.a() || this.f8031a.f663b.size() <= 0 || this.f8031a.f663b.get(0).f477a.B()) {
            return;
        }
        View view = this.f8031a.f662b;
        if (view == null || !view.isShown()) {
            this.f8031a.dismiss();
            return;
        }
        Iterator<d4> it = this.f8031a.f663b.iterator();
        while (it.hasNext()) {
            it.next().f477a.c();
        }
    }
}
