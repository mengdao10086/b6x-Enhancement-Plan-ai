package androidx.core.view;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public interface i0 {
    int getNestedScrollAxes();

    boolean onNestedFling(@g.n0 View view, float f10, float f11, boolean z10);

    boolean onNestedPreFling(@g.n0 View view, float f10, float f11);

    void onNestedPreScroll(@g.n0 View view, int i10, int i11, @g.n0 int[] iArr);

    void onNestedScroll(@g.n0 View view, int i10, int i11, int i12, int i13);

    void onNestedScrollAccepted(@g.n0 View view, @g.n0 View view2, int i10);

    boolean onStartNestedScroll(@g.n0 View view, @g.n0 View view2, int i10);

    void onStopNestedScroll(@g.n0 View view);
}
