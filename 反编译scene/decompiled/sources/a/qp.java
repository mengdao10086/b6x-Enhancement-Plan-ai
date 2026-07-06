package a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class qp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7227a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2591b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f2592c;
    public int d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2590a = true;
    public int e = 0;
    public int f = 0;

    public boolean a(RecyclerView.a0 a0Var) {
        int i = this.b;
        return i >= 0 && i < a0Var.b();
    }

    public View b(RecyclerView.v vVar) {
        View viewO = vVar.o(this.b);
        this.b += this.c;
        return viewO;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f7227a + ", mCurrentPosition=" + this.b + ", mItemDirection=" + this.c + ", mLayoutDirection=" + this.d + ", mStartLine=" + this.e + ", mEndLine=" + this.f + '}';
    }
}
