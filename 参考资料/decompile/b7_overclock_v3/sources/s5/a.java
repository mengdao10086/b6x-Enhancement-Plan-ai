package s5;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class a extends RecyclerView.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f49516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f49517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f49518c;

    public a(int i10, int i11, boolean z10) {
        this.f49516a = i10;
        this.f49517b = i11;
        this.f49518c = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.b0 b0Var) {
        int iP0 = recyclerView.p0(view);
        int i10 = this.f49516a;
        int i11 = iP0 % i10;
        if (this.f49518c) {
            int i12 = this.f49517b;
            rect.left = i12 - ((i11 * i12) / i10);
            rect.right = ((i11 + 1) * i12) / i10;
            if (iP0 < i10) {
                rect.top = i12;
            }
            rect.bottom = i12;
            return;
        }
        int i13 = this.f49517b;
        rect.left = (i11 * i13) / i10;
        rect.right = i13 - (((i11 + 1) * i13) / i10);
        if (iP0 >= i10) {
            rect.top = i13;
        }
    }
}
