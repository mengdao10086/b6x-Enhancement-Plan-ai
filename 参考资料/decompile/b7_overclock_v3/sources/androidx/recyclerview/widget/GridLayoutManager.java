package androidx.recyclerview.widget;

import a1.d;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public static final boolean O7 = false;
    public static final String P7 = "GridLayoutManager";
    public static final int Q7 = -1;
    public boolean F7;
    public int G7;
    public int[] H7;
    public View[] I7;
    public final SparseIntArray J7;
    public final SparseIntArray K7;
    public c L7;
    public final Rect M7;
    public boolean N7;

    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanIndex(int i10, int i11) {
            return i10 % i11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i10) {
            return 1;
        }
    }

    public static abstract class c {
        public final SparseIntArray mSpanIndexCache = new SparseIntArray();
        public final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        private boolean mCacheSpanIndices = false;
        private boolean mCacheSpanGroupIndices = false;

        public static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i10) {
            int size = sparseIntArray.size() - 1;
            int i11 = 0;
            while (i11 <= size) {
                int i12 = (i11 + size) >>> 1;
                if (sparseIntArray.keyAt(i12) < i10) {
                    i11 = i12 + 1;
                } else {
                    size = i12 - 1;
                }
            }
            int i13 = i11 - 1;
            if (i13 < 0 || i13 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i13);
        }

        public int getCachedSpanGroupIndex(int i10, int i11) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i10, i11);
            }
            int i12 = this.mSpanGroupIndexCache.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int spanGroupIndex = getSpanGroupIndex(i10, i11);
            this.mSpanGroupIndexCache.put(i10, spanGroupIndex);
            return spanGroupIndex;
        }

        public int getCachedSpanIndex(int i10, int i11) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i10, i11);
            }
            int i12 = this.mSpanIndexCache.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int spanIndex = getSpanIndex(i10, i11);
            this.mSpanIndexCache.put(i10, spanIndex);
            return spanIndex;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int getSpanGroupIndex(int r7, int r8) {
            /*
                r6 = this;
                boolean r0 = r6.mCacheSpanGroupIndices
                r1 = 0
                if (r0 == 0) goto L24
                android.util.SparseIntArray r0 = r6.mSpanGroupIndexCache
                int r0 = findFirstKeyLessThan(r0, r7)
                r2 = -1
                if (r0 == r2) goto L24
                android.util.SparseIntArray r2 = r6.mSpanGroupIndexCache
                int r2 = r2.get(r0)
                int r3 = r0 + 1
                int r4 = r6.getCachedSpanIndex(r0, r8)
                int r0 = r6.getSpanSize(r0)
                int r4 = r4 + r0
                if (r4 != r8) goto L27
                int r2 = r2 + 1
                goto L26
            L24:
                r2 = 0
                r3 = 0
            L26:
                r4 = 0
            L27:
                int r0 = r6.getSpanSize(r7)
            L2b:
                if (r3 >= r7) goto L40
                int r5 = r6.getSpanSize(r3)
                int r4 = r4 + r5
                if (r4 != r8) goto L38
                int r2 = r2 + 1
                r4 = 0
                goto L3d
            L38:
                if (r4 <= r8) goto L3d
                int r2 = r2 + 1
                r4 = r5
            L3d:
                int r3 = r3 + 1
                goto L2b
            L40:
                int r4 = r4 + r0
                if (r4 <= r8) goto L45
                int r2 = r2 + 1
            L45:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c.getSpanGroupIndex(int, int):int");
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:17:0x0030). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int getSpanIndex(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.getSpanSize(r6)
                r1 = 0
                if (r0 != r7) goto L8
                return r1
            L8:
                boolean r2 = r5.mCacheSpanIndices
                if (r2 == 0) goto L20
                android.util.SparseIntArray r2 = r5.mSpanIndexCache
                int r2 = findFirstKeyLessThan(r2, r6)
                if (r2 < 0) goto L20
                android.util.SparseIntArray r3 = r5.mSpanIndexCache
                int r3 = r3.get(r2)
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                goto L30
            L20:
                r2 = 0
                r3 = 0
            L22:
                if (r2 >= r6) goto L33
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L2d
                r3 = 0
                goto L30
            L2d:
                if (r3 <= r7) goto L30
                r3 = r4
            L30:
                int r2 = r2 + 1
                goto L22
            L33:
                int r0 = r0 + r3
                if (r0 > r7) goto L37
                return r3
            L37:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c.getSpanIndex(int, int):int");
        }

        public abstract int getSpanSize(int i10);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z10) {
            if (!z10) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z10;
        }

        public void setSpanIndexCacheEnabled(boolean z10) {
            if (!z10) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z10;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.F7 = false;
        this.G7 = -1;
        this.J7 = new SparseIntArray();
        this.K7 = new SparseIntArray();
        this.L7 = new a();
        this.M7 = new Rect();
        Q3(RecyclerView.o.v0(context, attributeSet, i10, i11).f6732b);
    }

    public static int[] A3(int[] iArr, int i10, int i11) {
        int i12;
        if (iArr == null || iArr.length != i10 + 1 || iArr[iArr.length - 1] != i11) {
            iArr = new int[i10 + 1];
        }
        int i13 = 0;
        iArr[0] = 0;
        int i14 = i11 / i10;
        int i15 = i11 % i10;
        int i16 = 0;
        for (int i17 = 1; i17 <= i10; i17++) {
            i13 += i15;
            if (i13 <= 0 || i10 - i13 >= i15) {
                i12 = i14;
            } else {
                i12 = i14 + 1;
                i13 -= i10;
            }
            i16 += i12;
            iArr[i17] = i16;
        }
        return iArr;
    }

    public final void B3() {
        this.J7.clear();
        this.K7.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int C(RecyclerView.b0 b0Var) {
        return this.N7 ? C3(b0Var) : super.C(b0Var);
    }

    public final int C3(RecyclerView.b0 b0Var) {
        if (Y() != 0 && b0Var.d() != 0) {
            r2();
            boolean zV2 = V2();
            View viewX2 = x2(!zV2, true);
            View viewW2 = w2(!zV2, true);
            if (viewX2 != null && viewW2 != null) {
                int cachedSpanGroupIndex = this.L7.getCachedSpanGroupIndex(u0(viewX2), this.G7);
                int cachedSpanGroupIndex2 = this.L7.getCachedSpanGroupIndex(u0(viewW2), this.G7);
                int iMax = this.f6550x ? Math.max(0, ((this.L7.getCachedSpanGroupIndex(b0Var.d() - 1, this.G7) + 1) - Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2)) - 1) : Math.max(0, Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2));
                if (zV2) {
                    return Math.round((iMax * (Math.abs(this.f6546u.d(viewW2) - this.f6546u.g(viewX2)) / ((this.L7.getCachedSpanGroupIndex(u0(viewW2), this.G7) - this.L7.getCachedSpanGroupIndex(u0(viewX2), this.G7)) + 1))) + (this.f6546u.n() - this.f6546u.g(viewX2)));
                }
                return iMax;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int D(RecyclerView.b0 b0Var) {
        return this.N7 ? D3(b0Var) : super.D(b0Var);
    }

    public final int D3(RecyclerView.b0 b0Var) {
        if (Y() != 0 && b0Var.d() != 0) {
            r2();
            View viewX2 = x2(!V2(), true);
            View viewW2 = w2(!V2(), true);
            if (viewX2 != null && viewW2 != null) {
                if (!V2()) {
                    return this.L7.getCachedSpanGroupIndex(b0Var.d() - 1, this.G7) + 1;
                }
                int iD = this.f6546u.d(viewW2) - this.f6546u.g(viewX2);
                int cachedSpanGroupIndex = this.L7.getCachedSpanGroupIndex(u0(viewX2), this.G7);
                return (int) ((iD / ((this.L7.getCachedSpanGroupIndex(u0(viewW2), this.G7) - cachedSpanGroupIndex) + 1)) * (this.L7.getCachedSpanGroupIndex(b0Var.d() - 1, this.G7) + 1));
            }
        }
        return 0;
    }

    public final void E3(RecyclerView.w wVar, RecyclerView.b0 b0Var, LinearLayoutManager.a aVar, int i10) {
        boolean z10 = i10 == 1;
        int iJ3 = J3(wVar, b0Var, aVar.f6557b);
        if (z10) {
            while (iJ3 > 0) {
                int i11 = aVar.f6557b;
                if (i11 <= 0) {
                    return;
                }
                int i12 = i11 - 1;
                aVar.f6557b = i12;
                iJ3 = J3(wVar, b0Var, i12);
            }
            return;
        }
        int iD = b0Var.d() - 1;
        int i13 = aVar.f6557b;
        while (i13 < iD) {
            int i14 = i13 + 1;
            int iJ32 = J3(wVar, b0Var, i14);
            if (iJ32 <= iJ3) {
                break;
            }
            i13 = i14;
            iJ3 = iJ32;
        }
        aVar.f6557b = i13;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int F(RecyclerView.b0 b0Var) {
        return this.N7 ? C3(b0Var) : super.F(b0Var);
    }

    public final void F3() {
        View[] viewArr = this.I7;
        if (viewArr == null || viewArr.length != this.G7) {
            this.I7 = new View[this.G7];
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int G(RecyclerView.b0 b0Var) {
        return this.N7 ? D3(b0Var) : super.G(b0Var);
    }

    public int G3(int i10, int i11) {
        if (this.f6544s != 1 || !U2()) {
            int[] iArr = this.H7;
            return iArr[i11 + i10] - iArr[i10];
        }
        int[] iArr2 = this.H7;
        int i12 = this.G7;
        return iArr2[i12 - i10] - iArr2[(i12 - i10) - i11];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View H2(RecyclerView.w wVar, RecyclerView.b0 b0Var, int i10, int i11, int i12) {
        r2();
        int iN = this.f6546u.n();
        int i13 = this.f6546u.i();
        int i14 = i11 > i10 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i10 != i11) {
            View viewX = X(i10);
            int iU0 = u0(viewX);
            if (iU0 >= 0 && iU0 < i12 && J3(wVar, b0Var, iU0) == 0) {
                if (((RecyclerView.p) viewX.getLayoutParams()).j()) {
                    if (view2 == null) {
                        view2 = viewX;
                    }
                } else {
                    if (this.f6546u.g(viewX) < i13 && this.f6546u.d(viewX) >= iN) {
                        return viewX;
                    }
                    if (view == null) {
                        view = viewX;
                    }
                }
            }
            i10 += i14;
        }
        return view != null ? view : view2;
    }

    public int H3() {
        return this.G7;
    }

    public final int I3(RecyclerView.w wVar, RecyclerView.b0 b0Var, int i10) {
        if (!b0Var.j()) {
            return this.L7.getCachedSpanGroupIndex(i10, this.G7);
        }
        int iG = wVar.g(i10);
        if (iG != -1) {
            return this.L7.getCachedSpanGroupIndex(iG, this.G7);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot find span size for pre layout position. ");
        sb2.append(i10);
        return 0;
    }

    public final int J3(RecyclerView.w wVar, RecyclerView.b0 b0Var, int i10) {
        if (!b0Var.j()) {
            return this.L7.getCachedSpanIndex(i10, this.G7);
        }
        int i11 = this.K7.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int iG = wVar.g(i10);
        if (iG != -1) {
            return this.L7.getCachedSpanIndex(iG, this.G7);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        sb2.append(i10);
        return 0;
    }

    public final int K3(RecyclerView.w wVar, RecyclerView.b0 b0Var, int i10) {
        if (!b0Var.j()) {
            return this.L7.getSpanSize(i10);
        }
        int i11 = this.J7.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int iG = wVar.g(i10);
        if (iG != -1) {
            return this.L7.getSpanSize(iG);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
        sb2.append(i10);
        return 1;
    }

    public c L3() {
        return this.L7;
    }

    public final void M3(float f10, int i10) {
        z3(Math.max(Math.round(f10 * this.G7), i10));
    }

    public boolean N3() {
        return this.N7;
    }

    public final void O3(View view, int i10, boolean z10) {
        int iZ;
        int iZ2;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f6736b;
        int i11 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i12 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int iG3 = G3(bVar.f6539e, bVar.f6540f);
        if (this.f6544s == 1) {
            iZ2 = RecyclerView.o.Z(iG3, i10, i12, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            iZ = RecyclerView.o.Z(this.f6546u.o(), n0(), i11, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int iZ3 = RecyclerView.o.Z(iG3, i10, i11, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int iZ4 = RecyclerView.o.Z(this.f6546u.o(), C0(), i12, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            iZ = iZ3;
            iZ2 = iZ4;
        }
        P3(view, iZ2, iZ, z10);
    }

    public final void P3(View view, int i10, int i11, boolean z10) {
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z10 ? e2(view, i10, i11, pVar) : c2(view, i10, i11, pVar)) {
            view.measure(i10, i11);
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int Q1(int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        T3();
        F3();
        return super.Q1(i10, wVar, b0Var);
    }

    public void Q3(int i10) {
        if (i10 == this.G7) {
            return;
        }
        this.F7 = true;
        if (i10 >= 1) {
            this.G7 = i10;
            this.L7.invalidateSpanIndexCache();
            N1();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i10);
        }
    }

    public void R3(c cVar) {
        this.L7 = cVar;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p S() {
        return this.f6544s == 0 ? new b(-2, -1) : new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int S1(int i10, RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        T3();
        F3();
        return super.S1(i10, wVar, b0Var);
    }

    public void S3(boolean z10) {
        this.N7 = z10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p T(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    public final void T3() {
        int iM0;
        int paddingTop;
        if (Q2() == 1) {
            iM0 = B0() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            iM0 = m0() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        z3(iM0 - paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p U(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b((ViewGroup.MarginLayoutParams) layoutParams) : new b(layoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0219  */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v19 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void W2(androidx.recyclerview.widget.RecyclerView.w r18, androidx.recyclerview.widget.RecyclerView.b0 r19, androidx.recyclerview.widget.LinearLayoutManager.c r20, androidx.recyclerview.widget.LinearLayoutManager.b r21) {
        /*
            Method dump skipped, instruction units count: 564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.W2(androidx.recyclerview.widget.RecyclerView$w, androidx.recyclerview.widget.RecyclerView$b0, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y1(Rect rect, int i10, int i11) {
        int iY;
        int iY2;
        if (this.H7 == null) {
            super.Y1(rect, i10, i11);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.f6544s == 1) {
            iY2 = RecyclerView.o.y(i11, rect.height() + paddingTop, s0());
            int[] iArr = this.H7;
            iY = RecyclerView.o.y(i10, iArr[iArr.length - 1] + paddingLeft, t0());
        } else {
            iY = RecyclerView.o.y(i10, rect.width() + paddingLeft, t0());
            int[] iArr2 = this.H7;
            iY2 = RecyclerView.o.y(i11, iArr2[iArr2.length - 1] + paddingTop, s0());
        }
        X1(iY, iY2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void Z2(RecyclerView.w wVar, RecyclerView.b0 b0Var, LinearLayoutManager.a aVar, int i10) {
        super.Z2(wVar, b0Var, aVar, i10);
        T3();
        if (b0Var.d() > 0 && !b0Var.j()) {
            E3(wVar, b0Var, aVar, i10);
        }
        F3();
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d6, code lost:
    
        if (r13 == (r2 > r15)) goto L49;
     */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0107  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View c1(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.w r26, androidx.recyclerview.widget.RecyclerView.b0 r27) {
        /*
            Method dump skipped, instruction units count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.c1(android.view.View, int, androidx.recyclerview.widget.RecyclerView$w, androidx.recyclerview.widget.RecyclerView$b0):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int d0(RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        if (this.f6544s == 1) {
            return this.G7;
        }
        if (b0Var.d() < 1) {
            return 0;
        }
        return I3(wVar, b0Var, b0Var.d() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void i1(RecyclerView.w wVar, RecyclerView.b0 b0Var, View view, a1.d dVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.h1(view, dVar);
            return;
        }
        b bVar = (b) layoutParams;
        int iI3 = I3(wVar, b0Var, bVar.b());
        if (this.f6544s == 0) {
            dVar.e1(d.e.h(bVar.C(), bVar.F(), iI3, 1, false, false));
        } else {
            dVar.e1(d.e.h(iI3, 1, bVar.C(), bVar.F(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean j2() {
        return this.D == null && !this.F7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void k1(RecyclerView recyclerView, int i10, int i11) {
        this.L7.invalidateSpanIndexCache();
        this.L7.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void l1(RecyclerView recyclerView) {
        this.L7.invalidateSpanIndexCache();
        this.L7.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void l2(RecyclerView.b0 b0Var, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int spanSize = this.G7;
        for (int i10 = 0; i10 < this.G7 && cVar.c(b0Var) && spanSize > 0; i10++) {
            int i11 = cVar.f6575d;
            cVar2.a(i11, Math.max(0, cVar.f6578g));
            spanSize -= this.L7.getSpanSize(i11);
            cVar.f6575d += cVar.f6576e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void m1(RecyclerView recyclerView, int i10, int i11, int i12) {
        this.L7.invalidateSpanIndexCache();
        this.L7.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void n1(RecyclerView recyclerView, int i10, int i11) {
        this.L7.invalidateSpanIndexCache();
        this.L7.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void n3(boolean z10) {
        if (z10) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.n3(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p1(RecyclerView recyclerView, int i10, int i11, Object obj) {
        this.L7.invalidateSpanIndexCache();
        this.L7.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void q1(RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        if (b0Var.j()) {
            y3();
        }
        super.q1(wVar, b0Var);
        B3();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void r1(RecyclerView.b0 b0Var) {
        super.r1(b0Var);
        this.F7 = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean x(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int x0(RecyclerView.w wVar, RecyclerView.b0 b0Var) {
        if (this.f6544s == 0) {
            return this.G7;
        }
        if (b0Var.d() < 1) {
            return 0;
        }
        return I3(wVar, b0Var, b0Var.d() - 1) + 1;
    }

    public final void x3(RecyclerView.w wVar, RecyclerView.b0 b0Var, int i10, boolean z10) {
        int i11;
        int i12;
        int i13 = 0;
        int i14 = -1;
        if (z10) {
            i14 = i10;
            i11 = 0;
            i12 = 1;
        } else {
            i11 = i10 - 1;
            i12 = -1;
        }
        while (i11 != i14) {
            View view = this.I7[i11];
            b bVar = (b) view.getLayoutParams();
            int iK3 = K3(wVar, b0Var, u0(view));
            bVar.f6540f = iK3;
            bVar.f6539e = i13;
            i13 += iK3;
            i11 += i12;
        }
    }

    public final void y3() {
        int iY = Y();
        for (int i10 = 0; i10 < iY; i10++) {
            b bVar = (b) X(i10).getLayoutParams();
            int iB = bVar.b();
            this.J7.put(iB, bVar.F());
            this.K7.put(iB, bVar.C());
        }
    }

    public final void z3(int i10) {
        this.H7 = A3(this.H7, this.G7, i10);
    }

    public static class b extends RecyclerView.p {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f6538g = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6539e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f6540f;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f6539e = -1;
            this.f6540f = 0;
        }

        public int C() {
            return this.f6539e;
        }

        public int F() {
            return this.f6540f;
        }

        public b(int i10, int i11) {
            super(i10, i11);
            this.f6539e = -1;
            this.f6540f = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f6539e = -1;
            this.f6540f = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f6539e = -1;
            this.f6540f = 0;
        }

        public b(RecyclerView.p pVar) {
            super(pVar);
            this.f6539e = -1;
            this.f6540f = 0;
        }
    }

    public GridLayoutManager(Context context, int i10) {
        super(context);
        this.F7 = false;
        this.G7 = -1;
        this.J7 = new SparseIntArray();
        this.K7 = new SparseIntArray();
        this.L7 = new a();
        this.M7 = new Rect();
        Q3(i10);
    }

    public GridLayoutManager(Context context, int i10, int i11, boolean z10) {
        super(context, i11, z10);
        this.F7 = false;
        this.G7 = -1;
        this.J7 = new SparseIntArray();
        this.K7 = new SparseIntArray();
        this.L7 = new a();
        this.M7 = new Rect();
        Q3(i10);
    }
}
