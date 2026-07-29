package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f7163j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f7164k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f7165l = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f7166m = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f7167n = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7172e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7175h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7176i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f7168a = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7173f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7174g = 0;

    public boolean a(RecyclerView.b0 b0Var) {
        int i10 = this.f7170c;
        return i10 >= 0 && i10 < b0Var.d();
    }

    public View b(RecyclerView.w wVar) {
        View viewP = wVar.p(this.f7170c);
        this.f7170c += this.f7171d;
        return viewP;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f7169b + ", mCurrentPosition=" + this.f7170c + ", mItemDirection=" + this.f7171d + ", mLayoutDirection=" + this.f7172e + ", mStartLine=" + this.f7173f + ", mEndLine=" + this.f7174g + '}';
    }
}
