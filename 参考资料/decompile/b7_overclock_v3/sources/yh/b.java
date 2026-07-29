package yh;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes5.dex */
public class b extends RecyclerView.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f57353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f57354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f57355c;

    public b(int i10, int i11, boolean z10) {
        this.f57353a = i10;
        this.f57354b = i11;
        this.f57355c = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.b0 b0Var) {
        int iP0 = recyclerView.p0(view);
        int i10 = this.f57353a;
        int i11 = iP0 % i10;
        if (this.f57355c) {
            int i12 = this.f57354b;
            rect.left = i12 - ((i11 * i12) / i10);
            rect.right = ((i11 + 1) * i12) / i10;
            if (iP0 < i10) {
                rect.top = i12;
            }
            rect.bottom = i12;
            return;
        }
        int i13 = this.f57354b;
        rect.left = (i11 * i13) / i10;
        rect.right = i13 - (((i11 + 1) * i13) / i10);
        if (iP0 >= i10) {
            rect.top = i13;
        }
    }
}
