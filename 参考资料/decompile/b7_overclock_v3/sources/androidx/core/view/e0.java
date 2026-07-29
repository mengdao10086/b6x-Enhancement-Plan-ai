package androidx.core.view;

/* JADX INFO: loaded from: classes2.dex */
public interface e0 {
    boolean dispatchNestedFling(float f10, float f11, boolean z10);

    boolean dispatchNestedPreFling(float f10, float f11);

    boolean dispatchNestedPreScroll(int i10, int i11, @g.p0 int[] iArr, @g.p0 int[] iArr2);

    boolean dispatchNestedScroll(int i10, int i11, int i12, int i13, @g.p0 int[] iArr);

    boolean hasNestedScrollingParent();

    boolean isNestedScrollingEnabled();

    void setNestedScrollingEnabled(boolean z10);

    boolean startNestedScroll(int i10);

    void stopNestedScroll();
}
