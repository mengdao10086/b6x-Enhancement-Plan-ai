package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.q;
import androidx.recyclerview.widget.w;
import com.google.android.flexbox.h;
import g.n0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FlexboxLayoutManager extends RecyclerView.o implements d, RecyclerView.a0.b {
    public static final String J7 = "FlexboxLayoutManager";
    public static final Rect K7 = new Rect();
    public static final boolean L7 = false;
    public static final /* synthetic */ boolean M7 = false;
    public final h A;
    public RecyclerView.w B;
    public RecyclerView.b0 C;
    public int C1;
    public int C2;
    public c D;
    public SparseArray<View> E7;
    public final Context F7;
    public View G7;
    public int H7;
    public h.b I7;
    public w K0;
    public int K1;
    public boolean K2;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public b f19354k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public w f19355k1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f19356s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f19357t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f19358u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f19359v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public SavedState f19360v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public int f19361v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f19362w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f19363x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f19364y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public List<f> f19365z;

    public class b {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ boolean f19377i = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19380c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f19381d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f19382e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f19383f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f19384g;

        public b() {
            this.f19381d = 0;
        }

        public static /* synthetic */ int l(b bVar, int i10) {
            int i11 = bVar.f19381d + i10;
            bVar.f19381d = i11;
            return i11;
        }

        public final void r() {
            if (FlexboxLayoutManager.this.k() || !FlexboxLayoutManager.this.f19363x) {
                this.f19380c = this.f19382e ? FlexboxLayoutManager.this.K0.i() : FlexboxLayoutManager.this.K0.n();
            } else {
                this.f19380c = this.f19382e ? FlexboxLayoutManager.this.K0.i() : FlexboxLayoutManager.this.B0() - FlexboxLayoutManager.this.K0.n();
            }
        }

        public final void s(View anchor) {
            w wVar = FlexboxLayoutManager.this.f19357t == 0 ? FlexboxLayoutManager.this.f19355k1 : FlexboxLayoutManager.this.K0;
            if (FlexboxLayoutManager.this.k() || !FlexboxLayoutManager.this.f19363x) {
                if (this.f19382e) {
                    this.f19380c = wVar.d(anchor) + wVar.p();
                } else {
                    this.f19380c = wVar.g(anchor);
                }
            } else if (this.f19382e) {
                this.f19380c = wVar.g(anchor) + wVar.p();
            } else {
                this.f19380c = wVar.d(anchor);
            }
            this.f19378a = FlexboxLayoutManager.this.u0(anchor);
            this.f19384g = false;
            int[] iArr = FlexboxLayoutManager.this.A.f19425c;
            int i10 = this.f19378a;
            if (i10 == -1) {
                i10 = 0;
            }
            int i11 = iArr[i10];
            this.f19379b = i11 != -1 ? i11 : 0;
            if (FlexboxLayoutManager.this.f19365z.size() > this.f19379b) {
                this.f19378a = ((f) FlexboxLayoutManager.this.f19365z.get(this.f19379b)).f19415o;
            }
        }

        public final void t() {
            this.f19378a = -1;
            this.f19379b = -1;
            this.f19380c = Integer.MIN_VALUE;
            this.f19383f = false;
            this.f19384g = false;
            if (FlexboxLayoutManager.this.k()) {
                if (FlexboxLayoutManager.this.f19357t == 0) {
                    this.f19382e = FlexboxLayoutManager.this.f19356s == 1;
                    return;
                } else {
                    this.f19382e = FlexboxLayoutManager.this.f19357t == 2;
                    return;
                }
            }
            if (FlexboxLayoutManager.this.f19357t == 0) {
                this.f19382e = FlexboxLayoutManager.this.f19356s == 3;
            } else {
                this.f19382e = FlexboxLayoutManager.this.f19357t == 2;
            }
        }

        @n0
        public String toString() {
            return "AnchorInfo{mPosition=" + this.f19378a + ", mFlexLinePosition=" + this.f19379b + ", mCoordinate=" + this.f19380c + ", mPerpendicularCoordinate=" + this.f19381d + ", mLayoutFromEnd=" + this.f19382e + ", mValid=" + this.f19383f + ", mAssignedFromSavedState=" + this.f19384g + '}';
        }
    }

    public static class c {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f19386k = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f19387l = -1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f19388m = 1;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f19389n = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f19391b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19392c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f19393d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f19394e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f19395f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f19396g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f19397h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f19398i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f19399j;

        public c() {
            this.f19397h = 1;
            this.f19398i = 1;
        }

        public static /* synthetic */ int c(c cVar, int i10) {
            int i11 = cVar.f19394e + i10;
            cVar.f19394e = i11;
            return i11;
        }

        public static /* synthetic */ int d(c cVar, int i10) {
            int i11 = cVar.f19394e - i10;
            cVar.f19394e = i11;
            return i11;
        }

        public static /* synthetic */ int i(c cVar, int i10) {
            int i11 = cVar.f19390a - i10;
            cVar.f19390a = i11;
            return i11;
        }

        public static /* synthetic */ int l(c cVar) {
            int i10 = cVar.f19392c;
            cVar.f19392c = i10 + 1;
            return i10;
        }

        public static /* synthetic */ int m(c cVar) {
            int i10 = cVar.f19392c;
            cVar.f19392c = i10 - 1;
            return i10;
        }

        public static /* synthetic */ int n(c cVar, int i10) {
            int i11 = cVar.f19392c + i10;
            cVar.f19392c = i11;
            return i11;
        }

        public static /* synthetic */ int q(c cVar, int i10) {
            int i11 = cVar.f19395f + i10;
            cVar.f19395f = i11;
            return i11;
        }

        public static /* synthetic */ int u(c cVar, int i10) {
            int i11 = cVar.f19393d + i10;
            cVar.f19393d = i11;
            return i11;
        }

        public static /* synthetic */ int v(c cVar, int i10) {
            int i11 = cVar.f19393d - i10;
            cVar.f19393d = i11;
            return i11;
        }

        public final boolean D(RecyclerView.b0 state, List<f> flexLines) {
            int i10;
            int i11 = this.f19393d;
            return i11 >= 0 && i11 < state.d() && (i10 = this.f19392c) >= 0 && i10 < flexLines.size();
        }

        @n0
        public String toString() {
            return "LayoutState{mAvailable=" + this.f19390a + ", mFlexLinePosition=" + this.f19392c + ", mPosition=" + this.f19393d + ", mOffset=" + this.f19394e + ", mScrollingOffset=" + this.f19395f + ", mLastScrollDelta=" + this.f19396g + ", mItemDirection=" + this.f19397h + ", mLayoutDirection=" + this.f19398i + '}';
        }
    }

    public FlexboxLayoutManager(Context context) {
        this(context, 0, 1);
    }

    public static boolean N0(int childSize, int spec, int dimension) {
        int mode = View.MeasureSpec.getMode(spec);
        int size = View.MeasureSpec.getSize(spec);
        if (dimension > 0 && childSize != dimension) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= childSize;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == childSize;
        }
        return true;
    }

    private boolean c2(View child, int widthSpec, int heightSpec, RecyclerView.p lp2) {
        return (!child.isLayoutRequested() && M0() && N0(child.getWidth(), widthSpec, ((ViewGroup.MarginLayoutParams) lp2).width) && N0(child.getHeight(), heightSpec, ((ViewGroup.MarginLayoutParams) lp2).height)) ? false : true;
    }

    public int A2() {
        View viewI2 = I2(0, Y(), true);
        if (viewI2 == null) {
            return -1;
        }
        return u0(viewI2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int B(@n0 RecyclerView.b0 state) {
        return u2(state);
    }

    public final View B2(int itemCount) {
        View viewJ2 = J2(0, Y(), itemCount);
        if (viewJ2 == null) {
            return null;
        }
        int i10 = this.A.f19425c[u0(viewJ2)];
        if (i10 == -1) {
            return null;
        }
        return C2(viewJ2, this.f19365z.get(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int C(@n0 RecyclerView.b0 state) {
        return v2(state);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View C2(android.view.View r6, com.google.android.flexbox.f r7) {
        /*
            r5 = this;
            boolean r0 = r5.k()
            int r7 = r7.f19408h
            r1 = 1
        L7:
            if (r1 >= r7) goto L3f
            android.view.View r2 = r5.X(r1)
            if (r2 == 0) goto L3c
            int r3 = r2.getVisibility()
            r4 = 8
            if (r3 != r4) goto L18
            goto L3c
        L18:
            boolean r3 = r5.f19363x
            if (r3 == 0) goto L2d
            if (r0 != 0) goto L2d
            androidx.recyclerview.widget.w r3 = r5.K0
            int r3 = r3.d(r6)
            androidx.recyclerview.widget.w r4 = r5.K0
            int r4 = r4.d(r2)
            if (r3 >= r4) goto L3c
            goto L3b
        L2d:
            androidx.recyclerview.widget.w r3 = r5.K0
            int r3 = r3.g(r6)
            androidx.recyclerview.widget.w r4 = r5.K0
            int r4 = r4.g(r2)
            if (r3 <= r4) goto L3c
        L3b:
            r6 = r2
        L3c:
            int r1 = r1 + 1
            goto L7
        L3f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.C2(android.view.View, com.google.android.flexbox.f):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int D(@n0 RecyclerView.b0 state) {
        return w2(state);
    }

    public int D2() {
        View viewI2 = I2(0, Y(), false);
        if (viewI2 == null) {
            return -1;
        }
        return u0(viewI2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int E(@n0 RecyclerView.b0 state) {
        return u2(state);
    }

    public int E2() {
        View viewI2 = I2(Y() - 1, -1, true);
        if (viewI2 == null) {
            return -1;
        }
        return u0(viewI2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int F(@n0 RecyclerView.b0 state) {
        return v2(state);
    }

    public final View F2(int itemCount) {
        View viewJ2 = J2(Y() - 1, -1, itemCount);
        if (viewJ2 == null) {
            return null;
        }
        return G2(viewJ2, this.f19365z.get(this.A.f19425c[u0(viewJ2)]));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int G(@n0 RecyclerView.b0 state) {
        return w2(state);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View G2(android.view.View r6, com.google.android.flexbox.f r7) {
        /*
            r5 = this;
            boolean r0 = r5.k()
            int r1 = r5.Y()
            int r1 = r1 + (-2)
            int r2 = r5.Y()
            int r7 = r7.f19408h
            int r2 = r2 - r7
            int r2 = r2 + (-1)
        L13:
            if (r1 <= r2) goto L4b
            android.view.View r7 = r5.X(r1)
            if (r7 == 0) goto L48
            int r3 = r7.getVisibility()
            r4 = 8
            if (r3 != r4) goto L24
            goto L48
        L24:
            boolean r3 = r5.f19363x
            if (r3 == 0) goto L39
            if (r0 != 0) goto L39
            androidx.recyclerview.widget.w r3 = r5.K0
            int r3 = r3.g(r6)
            androidx.recyclerview.widget.w r4 = r5.K0
            int r4 = r4.g(r7)
            if (r3 <= r4) goto L48
            goto L47
        L39:
            androidx.recyclerview.widget.w r3 = r5.K0
            int r3 = r3.d(r6)
            androidx.recyclerview.widget.w r4 = r5.K0
            int r4 = r4.d(r7)
            if (r3 >= r4) goto L48
        L47:
            r6 = r7
        L48:
            int r1 = r1 + (-1)
            goto L13
        L4b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.G2(android.view.View, com.google.android.flexbox.f):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean H0() {
        return true;
    }

    public int H2() {
        View viewI2 = I2(Y() - 1, -1, false);
        if (viewI2 == null) {
            return -1;
        }
        return u0(viewI2);
    }

    public final View I2(int fromIndex, int toIndex, boolean completelyVisible) {
        int i10 = toIndex > fromIndex ? 1 : -1;
        while (fromIndex != toIndex) {
            View viewX = X(fromIndex);
            if (W2(viewX, completelyVisible)) {
                return viewX;
            }
            fromIndex += i10;
        }
        return null;
    }

    public final View J2(int start, int end, int itemCount) {
        int iU0;
        y2();
        x2();
        int iN = this.K0.n();
        int i10 = this.K0.i();
        int i11 = end > start ? 1 : -1;
        View view = null;
        View view2 = null;
        while (start != end) {
            View viewX = X(start);
            if (viewX != null && (iU0 = u0(viewX)) >= 0 && iU0 < itemCount) {
                if (((RecyclerView.p) viewX.getLayoutParams()).j()) {
                    if (view2 == null) {
                        view2 = viewX;
                    }
                } else {
                    if (this.K0.g(viewX) >= iN && this.K0.d(viewX) <= i10) {
                        return viewX;
                    }
                    if (view == null) {
                        view = viewX;
                    }
                }
            }
            start += i11;
        }
        return view != null ? view : view2;
    }

    public final int K2(int endOffset, RecyclerView.w recycler, RecyclerView.b0 state, boolean canOffsetChildren) {
        int iT2;
        int i10;
        if (!k() && this.f19363x) {
            int iN = endOffset - this.K0.n();
            if (iN <= 0) {
                return 0;
            }
            iT2 = T2(iN, recycler, state);
        } else {
            int i11 = this.K0.i() - endOffset;
            if (i11 <= 0) {
                return 0;
            }
            iT2 = -T2(-i11, recycler, state);
        }
        int i12 = endOffset + iT2;
        if (!canOffsetChildren || (i10 = this.K0.i() - i12) <= 0) {
            return iT2;
        }
        this.K0.t(i10);
        return i10 + iT2;
    }

    public final int L2(int startOffset, RecyclerView.w recycler, RecyclerView.b0 state, boolean canOffsetChildren) {
        int iT2;
        int iN;
        if (k() || !this.f19363x) {
            int iN2 = startOffset - this.K0.n();
            if (iN2 <= 0) {
                return 0;
            }
            iT2 = -T2(iN2, recycler, state);
        } else {
            int i10 = this.K0.i() - startOffset;
            if (i10 <= 0) {
                return 0;
            }
            iT2 = T2(-i10, recycler, state);
        }
        int i11 = startOffset + iT2;
        if (!canOffsetChildren || (iN = i11 - this.K0.n()) <= 0) {
            return iT2;
        }
        this.K0.t(-iN);
        return iT2 - iN;
    }

    public final int M2(View view) {
        return e0(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
    }

    public final View N2() {
        return X(0);
    }

    public final int O2(View view) {
        return g0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
    }

    public final int P2(View view) {
        return j0(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int Q1(int dx, RecyclerView.w recycler, RecyclerView.b0 state) {
        if (!k() || this.f19357t == 0) {
            int iT2 = T2(dx, recycler, state);
            this.E7.clear();
            return iT2;
        }
        int iU2 = U2(dx);
        b.l(this.f19354k0, iU2);
        this.f19355k1.t(-iU2);
        return iU2;
    }

    public final int Q2(View view) {
        return k0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void R1(int position) {
        this.C1 = position;
        this.K1 = Integer.MIN_VALUE;
        SavedState savedState = this.f19360v1;
        if (savedState != null) {
            savedState.C();
        }
        N1();
    }

    public int R2(int position) {
        return this.A.f19425c[position];
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p S() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int S1(int dy, RecyclerView.w recycler, RecyclerView.b0 state) {
        if (k() || (this.f19357t == 0 && !k())) {
            int iT2 = T2(dy, recycler, state);
            this.E7.clear();
            return iT2;
        }
        int iU2 = U2(dy);
        b.l(this.f19354k0, iU2);
        this.f19355k1.t(-iU2);
        return iU2;
    }

    public boolean S2() {
        return this.K2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p T(Context c10, AttributeSet attrs) {
        return new LayoutParams(c10, attrs);
    }

    public final int T2(int delta, RecyclerView.w recycler, RecyclerView.b0 state) {
        if (Y() == 0 || delta == 0) {
            return 0;
        }
        y2();
        int i10 = 1;
        this.D.f19399j = true;
        boolean z10 = !k() && this.f19363x;
        if (!z10 ? delta <= 0 : delta >= 0) {
            i10 = -1;
        }
        int iAbs = Math.abs(delta);
        m3(i10, iAbs);
        int iZ2 = this.D.f19395f + z2(recycler, state, this.D);
        if (iZ2 < 0) {
            return 0;
        }
        if (z10) {
            if (iAbs > iZ2) {
                delta = (-i10) * iZ2;
            }
        } else if (iAbs > iZ2) {
            delta = i10 * iZ2;
        }
        this.K0.t(-delta);
        this.D.f19396g = delta;
        return delta;
    }

    public final int U2(int delta) {
        int iMin;
        if (Y() == 0 || delta == 0) {
            return 0;
        }
        y2();
        boolean zK = k();
        View view = this.G7;
        int width = zK ? view.getWidth() : view.getHeight();
        int iB0 = zK ? B0() : m0();
        if (q0() == 1) {
            int iAbs = Math.abs(delta);
            if (delta < 0) {
                iMin = Math.min((iB0 + this.f19354k0.f19381d) - width, iAbs);
            } else {
                if (this.f19354k0.f19381d + delta <= 0) {
                    return delta;
                }
                iMin = this.f19354k0.f19381d;
            }
        } else {
            if (delta > 0) {
                return Math.min((iB0 - this.f19354k0.f19381d) - width, delta);
            }
            if (this.f19354k0.f19381d + delta >= 0) {
                return delta;
            }
            iMin = this.f19354k0.f19381d;
        }
        return -iMin;
    }

    public boolean V2() {
        return this.f19363x;
    }

    public final boolean W2(View view, boolean completelyVisible) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int iB0 = B0() - getPaddingRight();
        int iM0 = m0() - getPaddingBottom();
        int iO2 = O2(view);
        int iQ2 = Q2(view);
        int iP2 = P2(view);
        int iM2 = M2(view);
        return completelyVisible ? (paddingLeft <= iO2 && iB0 >= iP2) && (paddingTop <= iQ2 && iM0 >= iM2) : (iO2 >= iB0 || iP2 >= paddingLeft) && (iQ2 >= iM0 || iM2 >= paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView.g oldAdapter, RecyclerView.g newAdapter) {
        removeAllViews();
    }

    public final int X2(f flexLine, c layoutState) {
        return k() ? Y2(flexLine, layoutState) : Z2(flexLine, layoutState);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int Y2(com.google.android.flexbox.f r22, com.google.android.flexbox.FlexboxLayoutManager.c r23) {
        /*
            Method dump skipped, instruction units count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.Y2(com.google.android.flexbox.f, com.google.android.flexbox.FlexboxLayoutManager$c):int");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Z0(RecyclerView recyclerView) {
        super.Z0(recyclerView);
        this.G7 = (View) recyclerView.getParent();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int Z2(com.google.android.flexbox.f r26, com.google.android.flexbox.FlexboxLayoutManager.c r27) {
        /*
            Method dump skipped, instruction units count: 539
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.Z2(com.google.android.flexbox.f, com.google.android.flexbox.FlexboxLayoutManager$c):int");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a0.b
    public PointF a(int targetPosition) {
        View viewX;
        if (Y() == 0 || (viewX = X(0)) == null) {
            return null;
        }
        int i10 = targetPosition < u0(viewX) ? -1 : 1;
        return k() ? new PointF(0.0f, i10) : new PointF(i10, 0.0f);
    }

    public final void a3(RecyclerView.w recycler, c layoutState) {
        if (layoutState.f19399j) {
            if (layoutState.f19398i == -1) {
                c3(recycler, layoutState);
            } else {
                d3(recycler, layoutState);
            }
        }
    }

    @Override // com.google.android.flexbox.d
    public void b(View view, int index, int indexInFlexLine, f flexLine) {
        u(view, K7);
        if (k()) {
            int iR0 = r0(view) + w0(view);
            flexLine.f19405e += iR0;
            flexLine.f19406f += iR0;
        } else {
            int iZ0 = z0(view) + W(view);
            flexLine.f19405e += iZ0;
            flexLine.f19406f += iZ0;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void b1(RecyclerView view, RecyclerView.w recycler) {
        super.b1(view, recycler);
        if (this.K2) {
            E1(recycler);
            recycler.d();
        }
    }

    public final void b3(RecyclerView.w recycler, int startIndex, int endIndex) {
        while (endIndex >= startIndex) {
            H1(endIndex, recycler);
            endIndex--;
        }
    }

    @Override // com.google.android.flexbox.d
    public void c(f flexLine) {
    }

    public final void c3(RecyclerView.w recycler, c layoutState) {
        int iY;
        int i10;
        View viewX;
        int i11;
        if (layoutState.f19395f < 0 || (iY = Y()) == 0 || (viewX = X(iY - 1)) == null || (i11 = this.A.f19425c[u0(viewX)]) == -1) {
            return;
        }
        f fVar = this.f19365z.get(i11);
        int i12 = i10;
        while (true) {
            if (i12 < 0) {
                break;
            }
            View viewX2 = X(i12);
            if (viewX2 != null) {
                if (!r2(viewX2, layoutState.f19395f)) {
                    break;
                }
                if (fVar.f19415o != u0(viewX2)) {
                    continue;
                } else if (i11 <= 0) {
                    iY = i12;
                    break;
                } else {
                    i11 += layoutState.f19398i;
                    fVar = this.f19365z.get(i11);
                    iY = i12;
                }
            }
            i12--;
        }
        b3(recycler, iY, i10);
    }

    @Override // com.google.android.flexbox.d
    public View d(int index) {
        return h(index);
    }

    public final void d3(RecyclerView.w recycler, c layoutState) {
        int iY;
        View viewX;
        if (layoutState.f19395f < 0 || (iY = Y()) == 0 || (viewX = X(0)) == null) {
            return;
        }
        int i10 = this.A.f19425c[u0(viewX)];
        int i11 = -1;
        if (i10 == -1) {
            return;
        }
        f fVar = this.f19365z.get(i10);
        int i12 = 0;
        while (true) {
            if (i12 >= iY) {
                break;
            }
            View viewX2 = X(i12);
            if (viewX2 != null) {
                if (!s2(viewX2, layoutState.f19395f)) {
                    break;
                }
                if (fVar.f19416p != u0(viewX2)) {
                    continue;
                } else if (i10 >= this.f19365z.size() - 1) {
                    i11 = i12;
                    break;
                } else {
                    i10 += layoutState.f19398i;
                    fVar = this.f19365z.get(i10);
                    i11 = i12;
                }
            }
            i12++;
        }
        b3(recycler, 0, i11);
    }

    @Override // com.google.android.flexbox.d
    public int e(int widthSpec, int padding, int childDimension) {
        return RecyclerView.o.Z(B0(), C0(), padding, childDimension, v());
    }

    public final void e3() {
        int iN0 = k() ? n0() : C0();
        this.D.f19391b = iN0 == 0 || iN0 == Integer.MIN_VALUE;
    }

    @Override // com.google.android.flexbox.d
    public void f(int position, View view) {
        this.E7.put(position, view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void f2(RecyclerView recyclerView, RecyclerView.b0 state, int position) {
        q qVar = new q(recyclerView.getContext());
        qVar.q(position);
        g2(qVar);
    }

    public final void f3() {
        int iQ0 = q0();
        int i10 = this.f19356s;
        if (i10 == 0) {
            this.f19363x = iQ0 == 1;
            this.f19364y = this.f19357t == 2;
            return;
        }
        if (i10 == 1) {
            this.f19363x = iQ0 != 1;
            this.f19364y = this.f19357t == 2;
            return;
        }
        if (i10 == 2) {
            boolean z10 = iQ0 == 1;
            this.f19363x = z10;
            if (this.f19357t == 2) {
                this.f19363x = !z10;
            }
            this.f19364y = false;
            return;
        }
        if (i10 != 3) {
            this.f19363x = false;
            this.f19364y = false;
            return;
        }
        boolean z11 = iQ0 == 1;
        this.f19363x = z11;
        if (this.f19357t == 2) {
            this.f19363x = !z11;
        }
        this.f19364y = true;
    }

    public void g3(boolean recycleChildrenOnDetach) {
        this.K2 = recycleChildrenOnDetach;
    }

    @Override // com.google.android.flexbox.d
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.d
    public int getAlignItems() {
        return this.f19359v;
    }

    @Override // com.google.android.flexbox.d
    public int getFlexDirection() {
        return this.f19356s;
    }

    @Override // com.google.android.flexbox.d
    public int getFlexItemCount() {
        return this.C.d();
    }

    @Override // com.google.android.flexbox.d
    @n0
    public List<f> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.f19365z.size());
        int size = this.f19365z.size();
        for (int i10 = 0; i10 < size; i10++) {
            f fVar = this.f19365z.get(i10);
            if (fVar.c() != 0) {
                arrayList.add(fVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.d
    public List<f> getFlexLinesInternal() {
        return this.f19365z;
    }

    @Override // com.google.android.flexbox.d
    public int getFlexWrap() {
        return this.f19357t;
    }

    @Override // com.google.android.flexbox.d
    public int getJustifyContent() {
        return this.f19358u;
    }

    @Override // com.google.android.flexbox.d
    public int getLargestMainSize() {
        if (this.f19365z.size() == 0) {
            return 0;
        }
        int iMax = Integer.MIN_VALUE;
        int size = this.f19365z.size();
        for (int i10 = 0; i10 < size; i10++) {
            iMax = Math.max(iMax, this.f19365z.get(i10).f19405e);
        }
        return iMax;
    }

    @Override // com.google.android.flexbox.d
    public int getMaxLine() {
        return this.f19362w;
    }

    @Override // com.google.android.flexbox.d
    public int getSumOfCrossSize() {
        int size = this.f19365z.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            i10 += this.f19365z.get(i11).f19407g;
        }
        return i10;
    }

    @Override // com.google.android.flexbox.d
    public View h(int index) {
        View view = this.E7.get(index);
        return view != null ? view : this.B.p(index);
    }

    public final boolean h3(RecyclerView.b0 state, b anchorInfo) {
        if (Y() == 0) {
            return false;
        }
        View viewF2 = anchorInfo.f19382e ? F2(state.d()) : B2(state.d());
        if (viewF2 == null) {
            return false;
        }
        anchorInfo.s(viewF2);
        if (!state.j() && j2()) {
            if (this.K0.g(viewF2) >= this.K0.i() || this.K0.d(viewF2) < this.K0.n()) {
                anchorInfo.f19380c = anchorInfo.f19382e ? this.K0.i() : this.K0.n();
            }
        }
        return true;
    }

    @Override // com.google.android.flexbox.d
    public int i(View view, int index, int indexInFlexLine) {
        int iZ0;
        int iW;
        if (k()) {
            iZ0 = r0(view);
            iW = w0(view);
        } else {
            iZ0 = z0(view);
            iW = W(view);
        }
        return iZ0 + iW;
    }

    public final boolean i3(RecyclerView.b0 state, b anchorInfo, SavedState savedState) {
        int i10;
        View viewX;
        if (!state.j() && (i10 = this.C1) != -1) {
            if (i10 >= 0 && i10 < state.d()) {
                anchorInfo.f19378a = this.C1;
                anchorInfo.f19379b = this.A.f19425c[anchorInfo.f19378a];
                SavedState savedState2 = this.f19360v1;
                if (savedState2 != null && savedState2.z(state.d())) {
                    anchorInfo.f19380c = this.K0.n() + savedState.f19376b;
                    anchorInfo.f19384g = true;
                    anchorInfo.f19379b = -1;
                    return true;
                }
                if (this.K1 != Integer.MIN_VALUE) {
                    if (k() || !this.f19363x) {
                        anchorInfo.f19380c = this.K0.n() + this.K1;
                    } else {
                        anchorInfo.f19380c = this.K1 - this.K0.j();
                    }
                    return true;
                }
                View viewR = R(this.C1);
                if (viewR == null) {
                    if (Y() > 0 && (viewX = X(0)) != null) {
                        anchorInfo.f19382e = this.C1 < u0(viewX);
                    }
                    anchorInfo.r();
                } else {
                    if (this.K0.e(viewR) > this.K0.o()) {
                        anchorInfo.r();
                        return true;
                    }
                    if (this.K0.g(viewR) - this.K0.n() < 0) {
                        anchorInfo.f19380c = this.K0.n();
                        anchorInfo.f19382e = false;
                        return true;
                    }
                    if (this.K0.i() - this.K0.d(viewR) < 0) {
                        anchorInfo.f19380c = this.K0.i();
                        anchorInfo.f19382e = true;
                        return true;
                    }
                    anchorInfo.f19380c = anchorInfo.f19382e ? this.K0.d(viewR) + this.K0.p() : this.K0.g(viewR);
                }
                return true;
            }
            this.C1 = -1;
            this.K1 = Integer.MIN_VALUE;
        }
        return false;
    }

    @Override // com.google.android.flexbox.d
    public int j(int heightSpec, int padding, int childDimension) {
        return RecyclerView.o.Z(m0(), n0(), padding, childDimension, w());
    }

    public final void j3(RecyclerView.b0 state, b anchorInfo) {
        if (i3(state, anchorInfo, this.f19360v1) || h3(state, anchorInfo)) {
            return;
        }
        anchorInfo.r();
        anchorInfo.f19378a = 0;
        anchorInfo.f19379b = 0;
    }

    @Override // com.google.android.flexbox.d
    public boolean k() {
        int i10 = this.f19356s;
        return i10 == 0 || i10 == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void k1(@n0 RecyclerView recyclerView, int positionStart, int itemCount) {
        super.k1(recyclerView, positionStart, itemCount);
        k3(positionStart);
    }

    public final void k3(int positionStart) {
        if (positionStart >= H2()) {
            return;
        }
        int iY = Y();
        this.A.t(iY);
        this.A.u(iY);
        this.A.s(iY);
        if (positionStart >= this.A.f19425c.length) {
            return;
        }
        this.H7 = positionStart;
        View viewN2 = N2();
        if (viewN2 == null) {
            return;
        }
        this.C1 = u0(viewN2);
        if (k() || !this.f19363x) {
            this.K1 = this.K0.g(viewN2) - this.K0.n();
        } else {
            this.K1 = this.K0.d(viewN2) + this.K0.j();
        }
    }

    @Override // com.google.android.flexbox.d
    public int l(View view) {
        int iR0;
        int iW0;
        if (k()) {
            iR0 = z0(view);
            iW0 = W(view);
        } else {
            iR0 = r0(view);
            iW0 = w0(view);
        }
        return iR0 + iW0;
    }

    public final void l3(int childCount) {
        boolean z10;
        int i10;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(B0(), C0());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(m0(), n0());
        int iB0 = B0();
        int iM0 = m0();
        if (k()) {
            int i11 = this.f19361v2;
            z10 = (i11 == Integer.MIN_VALUE || i11 == iB0) ? false : true;
            i10 = this.D.f19391b ? this.F7.getResources().getDisplayMetrics().heightPixels : this.D.f19390a;
        } else {
            int i12 = this.C2;
            z10 = (i12 == Integer.MIN_VALUE || i12 == iM0) ? false : true;
            i10 = this.D.f19391b ? this.F7.getResources().getDisplayMetrics().widthPixels : this.D.f19390a;
        }
        int i13 = i10;
        this.f19361v2 = iB0;
        this.C2 = iM0;
        int i14 = this.H7;
        if (i14 == -1 && (this.C1 != -1 || z10)) {
            if (this.f19354k0.f19382e) {
                return;
            }
            this.f19365z.clear();
            this.I7.a();
            if (k()) {
                this.A.e(this.I7, iMakeMeasureSpec, iMakeMeasureSpec2, i13, this.f19354k0.f19378a, this.f19365z);
            } else {
                this.A.h(this.I7, iMakeMeasureSpec, iMakeMeasureSpec2, i13, this.f19354k0.f19378a, this.f19365z);
            }
            this.f19365z = this.I7.f19428a;
            this.A.p(iMakeMeasureSpec, iMakeMeasureSpec2);
            this.A.X();
            b bVar = this.f19354k0;
            bVar.f19379b = this.A.f19425c[bVar.f19378a];
            this.D.f19392c = this.f19354k0.f19379b;
            return;
        }
        int iMin = i14 != -1 ? Math.min(i14, this.f19354k0.f19378a) : this.f19354k0.f19378a;
        this.I7.a();
        if (k()) {
            if (this.f19365z.size() > 0) {
                this.A.j(this.f19365z, iMin);
                this.A.b(this.I7, iMakeMeasureSpec, iMakeMeasureSpec2, i13, iMin, this.f19354k0.f19378a, this.f19365z);
            } else {
                this.A.s(childCount);
                this.A.d(this.I7, iMakeMeasureSpec, iMakeMeasureSpec2, i13, 0, this.f19365z);
            }
        } else if (this.f19365z.size() > 0) {
            this.A.j(this.f19365z, iMin);
            this.A.b(this.I7, iMakeMeasureSpec2, iMakeMeasureSpec, i13, iMin, this.f19354k0.f19378a, this.f19365z);
        } else {
            this.A.s(childCount);
            this.A.g(this.I7, iMakeMeasureSpec, iMakeMeasureSpec2, i13, 0, this.f19365z);
        }
        this.f19365z = this.I7.f19428a;
        this.A.q(iMakeMeasureSpec, iMakeMeasureSpec2, iMin);
        this.A.Y(iMin);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void m1(@n0 RecyclerView recyclerView, int from, int to2, int itemCount) {
        super.m1(recyclerView, from, to2, itemCount);
        k3(Math.min(from, to2));
    }

    public final void m3(int layoutDirection, int absDelta) {
        this.D.f19398i = layoutDirection;
        boolean zK = k();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(B0(), C0());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(m0(), n0());
        boolean z10 = !zK && this.f19363x;
        if (layoutDirection == 1) {
            View viewX = X(Y() - 1);
            if (viewX == null) {
                return;
            }
            this.D.f19394e = this.K0.d(viewX);
            int iU0 = u0(viewX);
            View viewG2 = G2(viewX, this.f19365z.get(this.A.f19425c[iU0]));
            this.D.f19397h = 1;
            c cVar = this.D;
            cVar.f19393d = iU0 + cVar.f19397h;
            if (this.A.f19425c.length <= this.D.f19393d) {
                this.D.f19392c = -1;
            } else {
                c cVar2 = this.D;
                cVar2.f19392c = this.A.f19425c[cVar2.f19393d];
            }
            if (z10) {
                this.D.f19394e = this.K0.g(viewG2);
                this.D.f19395f = (-this.K0.g(viewG2)) + this.K0.n();
                c cVar3 = this.D;
                cVar3.f19395f = Math.max(cVar3.f19395f, 0);
            } else {
                this.D.f19394e = this.K0.d(viewG2);
                this.D.f19395f = this.K0.d(viewG2) - this.K0.i();
            }
            if ((this.D.f19392c == -1 || this.D.f19392c > this.f19365z.size() - 1) && this.D.f19393d <= getFlexItemCount()) {
                int i10 = absDelta - this.D.f19395f;
                this.I7.a();
                if (i10 > 0) {
                    if (zK) {
                        this.A.d(this.I7, iMakeMeasureSpec, iMakeMeasureSpec2, i10, this.D.f19393d, this.f19365z);
                    } else {
                        this.A.g(this.I7, iMakeMeasureSpec, iMakeMeasureSpec2, i10, this.D.f19393d, this.f19365z);
                    }
                    this.A.q(iMakeMeasureSpec, iMakeMeasureSpec2, this.D.f19393d);
                    this.A.Y(this.D.f19393d);
                }
            }
        } else {
            View viewX2 = X(0);
            if (viewX2 == null) {
                return;
            }
            this.D.f19394e = this.K0.g(viewX2);
            int iU02 = u0(viewX2);
            View viewC2 = C2(viewX2, this.f19365z.get(this.A.f19425c[iU02]));
            this.D.f19397h = 1;
            int i11 = this.A.f19425c[iU02];
            if (i11 == -1) {
                i11 = 0;
            }
            if (i11 > 0) {
                this.D.f19393d = iU02 - this.f19365z.get(i11 - 1).c();
            } else {
                this.D.f19393d = -1;
            }
            this.D.f19392c = i11 > 0 ? i11 - 1 : 0;
            if (z10) {
                this.D.f19394e = this.K0.d(viewC2);
                this.D.f19395f = this.K0.d(viewC2) - this.K0.i();
                c cVar4 = this.D;
                cVar4.f19395f = Math.max(cVar4.f19395f, 0);
            } else {
                this.D.f19394e = this.K0.g(viewC2);
                this.D.f19395f = (-this.K0.g(viewC2)) + this.K0.n();
            }
        }
        c cVar5 = this.D;
        cVar5.f19390a = absDelta - cVar5.f19395f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void n1(@n0 RecyclerView recyclerView, int positionStart, int itemCount) {
        super.n1(recyclerView, positionStart, itemCount);
        k3(positionStart);
    }

    public final void n3(b anchorInfo, boolean fromNextLine, boolean considerInfinite) {
        if (considerInfinite) {
            e3();
        } else {
            this.D.f19391b = false;
        }
        if (k() || !this.f19363x) {
            this.D.f19390a = this.K0.i() - anchorInfo.f19380c;
        } else {
            this.D.f19390a = anchorInfo.f19380c - getPaddingRight();
        }
        this.D.f19393d = anchorInfo.f19378a;
        this.D.f19397h = 1;
        this.D.f19398i = 1;
        this.D.f19394e = anchorInfo.f19380c;
        this.D.f19395f = Integer.MIN_VALUE;
        this.D.f19392c = anchorInfo.f19379b;
        if (!fromNextLine || this.f19365z.size() <= 1 || anchorInfo.f19379b < 0 || anchorInfo.f19379b >= this.f19365z.size() - 1) {
            return;
        }
        f fVar = this.f19365z.get(anchorInfo.f19379b);
        c.l(this.D);
        c.u(this.D, fVar.c());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void o1(@n0 RecyclerView recyclerView, int positionStart, int itemCount) {
        super.o1(recyclerView, positionStart, itemCount);
        k3(positionStart);
    }

    public final void o3(b anchorInfo, boolean fromPreviousLine, boolean considerInfinite) {
        if (considerInfinite) {
            e3();
        } else {
            this.D.f19391b = false;
        }
        if (k() || !this.f19363x) {
            this.D.f19390a = anchorInfo.f19380c - this.K0.n();
        } else {
            this.D.f19390a = (this.G7.getWidth() - anchorInfo.f19380c) - this.K0.n();
        }
        this.D.f19393d = anchorInfo.f19378a;
        this.D.f19397h = 1;
        this.D.f19398i = -1;
        this.D.f19394e = anchorInfo.f19380c;
        this.D.f19395f = Integer.MIN_VALUE;
        this.D.f19392c = anchorInfo.f19379b;
        if (!fromPreviousLine || anchorInfo.f19379b <= 0 || this.f19365z.size() <= anchorInfo.f19379b) {
            return;
        }
        f fVar = this.f19365z.get(anchorInfo.f19379b);
        c.m(this.D);
        c.v(this.D, fVar.c());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void p1(@n0 RecyclerView recyclerView, int positionStart, int itemCount, Object payload) {
        super.p1(recyclerView, positionStart, itemCount, payload);
        k3(positionStart);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void q1(RecyclerView.w recycler, RecyclerView.b0 state) {
        int i10;
        int i11;
        this.B = recycler;
        this.C = state;
        int iD = state.d();
        if (iD == 0 && state.j()) {
            return;
        }
        f3();
        y2();
        x2();
        this.A.t(iD);
        this.A.u(iD);
        this.A.s(iD);
        this.D.f19399j = false;
        SavedState savedState = this.f19360v1;
        if (savedState != null && savedState.z(iD)) {
            this.C1 = this.f19360v1.f19375a;
        }
        if (!this.f19354k0.f19383f || this.C1 != -1 || this.f19360v1 != null) {
            this.f19354k0.t();
            j3(state, this.f19354k0);
            this.f19354k0.f19383f = true;
        }
        H(recycler);
        if (this.f19354k0.f19382e) {
            o3(this.f19354k0, false, true);
        } else {
            n3(this.f19354k0, false, true);
        }
        l3(iD);
        z2(recycler, state, this.D);
        if (this.f19354k0.f19382e) {
            i11 = this.D.f19394e;
            n3(this.f19354k0, true, false);
            z2(recycler, state, this.D);
            i10 = this.D.f19394e;
        } else {
            i10 = this.D.f19394e;
            o3(this.f19354k0, true, false);
            z2(recycler, state, this.D);
            i11 = this.D.f19394e;
        }
        if (Y() > 0) {
            if (this.f19354k0.f19382e) {
                L2(i11 + K2(i10, recycler, state, true), recycler, state, false);
            } else {
                K2(i10 + L2(i11, recycler, state, true), recycler, state, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void r1(RecyclerView.b0 state) {
        super.r1(state);
        this.f19360v1 = null;
        this.C1 = -1;
        this.K1 = Integer.MIN_VALUE;
        this.H7 = -1;
        this.f19354k0.t();
        this.E7.clear();
    }

    public final boolean r2(View view, int scrollingOffset) {
        return (k() || !this.f19363x) ? this.K0.g(view) >= this.K0.h() - scrollingOffset : this.K0.d(view) <= scrollingOffset;
    }

    public final boolean s2(View view, int scrollingOffset) {
        return (k() || !this.f19363x) ? this.K0.d(view) <= scrollingOffset : this.K0.h() - this.K0.g(view) <= scrollingOffset;
    }

    @Override // com.google.android.flexbox.d
    public void setAlignContent(int alignContent) {
        throw new UnsupportedOperationException("Setting the alignContent in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to use this attribute.");
    }

    @Override // com.google.android.flexbox.d
    public void setAlignItems(int alignItems) {
        int i10 = this.f19359v;
        if (i10 != alignItems) {
            if (i10 == 4 || alignItems == 4) {
                removeAllViews();
                t2();
            }
            this.f19359v = alignItems;
            N1();
        }
    }

    @Override // com.google.android.flexbox.d
    public void setFlexDirection(int flexDirection) {
        if (this.f19356s != flexDirection) {
            removeAllViews();
            this.f19356s = flexDirection;
            this.K0 = null;
            this.f19355k1 = null;
            t2();
            N1();
        }
    }

    @Override // com.google.android.flexbox.d
    public void setFlexLines(List<f> flexLines) {
        this.f19365z = flexLines;
    }

    @Override // com.google.android.flexbox.d
    public void setFlexWrap(int flexWrap) {
        if (flexWrap == 2) {
            throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
        }
        int i10 = this.f19357t;
        if (i10 != flexWrap) {
            if (i10 == 0 || flexWrap == 0) {
                removeAllViews();
                t2();
            }
            this.f19357t = flexWrap;
            this.K0 = null;
            this.f19355k1 = null;
            N1();
        }
    }

    @Override // com.google.android.flexbox.d
    public void setJustifyContent(int justifyContent) {
        if (this.f19358u != justifyContent) {
            this.f19358u = justifyContent;
            N1();
        }
    }

    @Override // com.google.android.flexbox.d
    public void setMaxLine(int maxLine) {
        if (this.f19362w != maxLine) {
            this.f19362w = maxLine;
            N1();
        }
    }

    public final void t2() {
        this.f19365z.clear();
        this.f19354k0.t();
        this.f19354k0.f19381d = 0;
    }

    public final int u2(RecyclerView.b0 state) {
        if (Y() == 0) {
            return 0;
        }
        int iD = state.d();
        y2();
        View viewB2 = B2(iD);
        View viewF2 = F2(iD);
        if (state.d() == 0 || viewB2 == null || viewF2 == null) {
            return 0;
        }
        return Math.min(this.K0.o(), this.K0.d(viewF2) - this.K0.g(viewB2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean v() {
        if (this.f19357t == 0) {
            return k();
        }
        if (k()) {
            int iB0 = B0();
            View view = this.G7;
            if (iB0 <= (view != null ? view.getWidth() : 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void v1(Parcelable state) {
        if (state instanceof SavedState) {
            this.f19360v1 = (SavedState) state;
            N1();
        }
    }

    public final int v2(RecyclerView.b0 state) {
        if (Y() == 0) {
            return 0;
        }
        int iD = state.d();
        View viewB2 = B2(iD);
        View viewF2 = F2(iD);
        if (state.d() != 0 && viewB2 != null && viewF2 != null) {
            int iU0 = u0(viewB2);
            int iU02 = u0(viewF2);
            int iAbs = Math.abs(this.K0.d(viewF2) - this.K0.g(viewB2));
            int i10 = this.A.f19425c[iU0];
            if (i10 != 0 && i10 != -1) {
                return Math.round((i10 * (iAbs / ((r4[iU02] - i10) + 1))) + (this.K0.n() - this.K0.g(viewB2)));
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean w() {
        if (this.f19357t == 0) {
            return !k();
        }
        if (k()) {
            return true;
        }
        int iM0 = m0();
        View view = this.G7;
        return iM0 > (view != null ? view.getHeight() : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable w1() {
        if (this.f19360v1 != null) {
            return new SavedState(this.f19360v1);
        }
        SavedState savedState = new SavedState();
        if (Y() > 0) {
            View viewN2 = N2();
            savedState.f19375a = u0(viewN2);
            savedState.f19376b = this.K0.g(viewN2) - this.K0.n();
        } else {
            savedState.C();
        }
        return savedState;
    }

    public final int w2(RecyclerView.b0 state) {
        if (Y() == 0) {
            return 0;
        }
        int iD = state.d();
        View viewB2 = B2(iD);
        View viewF2 = F2(iD);
        if (state.d() == 0 || viewB2 == null || viewF2 == null) {
            return 0;
        }
        int iD2 = D2();
        return (int) ((Math.abs(this.K0.d(viewF2) - this.K0.g(viewB2)) / ((H2() - iD2) + 1)) * state.d());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean x(RecyclerView.p lp2) {
        return lp2 instanceof LayoutParams;
    }

    public final void x2() {
        if (this.D == null) {
            this.D = new c();
        }
    }

    public final void y2() {
        if (this.K0 != null) {
            return;
        }
        if (k()) {
            if (this.f19357t == 0) {
                this.K0 = w.a(this);
                this.f19355k1 = w.c(this);
                return;
            } else {
                this.K0 = w.c(this);
                this.f19355k1 = w.a(this);
                return;
            }
        }
        if (this.f19357t == 0) {
            this.K0 = w.c(this);
            this.f19355k1 = w.a(this);
        } else {
            this.K0 = w.a(this);
            this.f19355k1 = w.c(this);
        }
    }

    public final int z2(RecyclerView.w recycler, RecyclerView.b0 state, c layoutState) {
        if (layoutState.f19395f != Integer.MIN_VALUE) {
            if (layoutState.f19390a < 0) {
                c.q(layoutState, layoutState.f19390a);
            }
            a3(recycler, layoutState);
        }
        int i10 = layoutState.f19390a;
        int iA = layoutState.f19390a;
        int iX2 = 0;
        boolean zK = k();
        while (true) {
            if ((iA <= 0 && !this.D.f19391b) || !layoutState.D(state, this.f19365z)) {
                break;
            }
            f fVar = this.f19365z.get(layoutState.f19392c);
            layoutState.f19393d = fVar.f19415o;
            iX2 += X2(fVar, layoutState);
            if (zK || !this.f19363x) {
                c.c(layoutState, fVar.a() * layoutState.f19398i);
            } else {
                c.d(layoutState, fVar.a() * layoutState.f19398i);
            }
            iA -= fVar.a();
        }
        c.i(layoutState, iX2);
        if (layoutState.f19395f != Integer.MIN_VALUE) {
            c.q(layoutState, iX2);
            if (layoutState.f19390a < 0) {
                c.q(layoutState, layoutState.f19390a);
            }
            a3(recycler, layoutState);
        }
        return i10 - layoutState.f19390a;
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19376b;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel source) {
                return new SavedState(source);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        }

        public final void C() {
            this.f19375a = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @n0
        public String toString() {
            return "SavedState{mAnchorPosition=" + this.f19375a + ", mAnchorOffset=" + this.f19376b + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.f19375a);
            dest.writeInt(this.f19376b);
        }

        public final boolean z(int itemCount) {
            int i10 = this.f19375a;
            return i10 >= 0 && i10 < itemCount;
        }

        public SavedState() {
        }

        public SavedState(Parcel in2) {
            this.f19375a = in2.readInt();
            this.f19376b = in2.readInt();
        }

        public SavedState(SavedState savedState) {
            this.f19375a = savedState.f19375a;
            this.f19376b = savedState.f19376b;
        }
    }

    public FlexboxLayoutManager(Context context, int flexDirection) {
        this(context, flexDirection, 1);
    }

    public FlexboxLayoutManager(Context context, int flexDirection, int flexWrap) {
        this.f19362w = -1;
        this.f19365z = new ArrayList();
        this.A = new h(this);
        this.f19354k0 = new b();
        this.C1 = -1;
        this.K1 = Integer.MIN_VALUE;
        this.f19361v2 = Integer.MIN_VALUE;
        this.C2 = Integer.MIN_VALUE;
        this.E7 = new SparseArray<>();
        this.H7 = -1;
        this.I7 = new h.b();
        setFlexDirection(flexDirection);
        setFlexWrap(flexWrap);
        setAlignItems(4);
        this.F7 = context;
    }

    public static class LayoutParams extends RecyclerView.p implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f19366e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f19367f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f19368g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f19369h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f19370i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f19371j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f19372k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f19373l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f19374m;

        public class a implements Parcelable.Creator<LayoutParams> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public LayoutParams createFromParcel(Parcel source) {
                return new LayoutParams(source);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public LayoutParams[] newArray(int size) {
                return new LayoutParams[size];
            }
        }

        public LayoutParams(Context c10, AttributeSet attrs) {
            super(c10, attrs);
            this.f19366e = 0.0f;
            this.f19367f = 1.0f;
            this.f19368g = -1;
            this.f19369h = -1.0f;
            this.f19372k = 16777215;
            this.f19373l = 16777215;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float A() {
            return this.f19366e;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float E() {
            return this.f19369h;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int I() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int K() {
            return this.f19371j;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean L() {
            return this.f19374m;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int N() {
            return this.f19373l;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void Q(int alignSelf) {
            this.f19368g = alignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int R() {
            return this.f19372k;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void c(float flexGrow) {
            this.f19366e = flexGrow;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void f(float flexBasisPercent) {
            this.f19369h = flexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return 1;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void k(int order) {
            throw new UnsupportedOperationException("Setting the order in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to reorder using the attribute.");
        }

        @Override // com.google.android.flexbox.FlexItem
        public int l() {
            return this.f19368g;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float m() {
            return this.f19367f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void o(boolean wrapBefore) {
            this.f19374m = wrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int p() {
            return this.f19370i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void q(float flexShrink) {
            this.f19367f = flexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void r(int minWidth) {
            this.f19370i = minWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setHeight(int height) {
            ((ViewGroup.MarginLayoutParams) this).height = height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxHeight(int maxHeight) {
            this.f19373l = maxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxWidth(int maxWidth) {
            this.f19372k = maxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWidth(int width) {
            ((ViewGroup.MarginLayoutParams) this).width = width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int t() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int u() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeFloat(this.f19366e);
            parcel.writeFloat(this.f19367f);
            parcel.writeInt(this.f19368g);
            parcel.writeFloat(this.f19369h);
            parcel.writeInt(this.f19370i);
            parcel.writeInt(this.f19371j);
            parcel.writeInt(this.f19372k);
            parcel.writeInt(this.f19373l);
            parcel.writeByte(this.f19374m ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.google.android.flexbox.FlexItem
        public int x() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void y(int minHeight) {
            this.f19371j = minHeight;
        }

        public LayoutParams(int width, int height) {
            super(width, height);
            this.f19366e = 0.0f;
            this.f19367f = 1.0f;
            this.f19368g = -1;
            this.f19369h = -1.0f;
            this.f19372k = 16777215;
            this.f19373l = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
            this.f19366e = 0.0f;
            this.f19367f = 1.0f;
            this.f19368g = -1;
            this.f19369h = -1.0f;
            this.f19372k = 16777215;
            this.f19373l = 16777215;
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            this.f19366e = 0.0f;
            this.f19367f = 1.0f;
            this.f19368g = -1;
            this.f19369h = -1.0f;
            this.f19372k = 16777215;
            this.f19373l = 16777215;
        }

        public LayoutParams(RecyclerView.p source) {
            super(source);
            this.f19366e = 0.0f;
            this.f19367f = 1.0f;
            this.f19368g = -1;
            this.f19369h = -1.0f;
            this.f19372k = 16777215;
            this.f19373l = 16777215;
        }

        public LayoutParams(LayoutParams source) {
            super((RecyclerView.p) source);
            this.f19366e = 0.0f;
            this.f19367f = 1.0f;
            this.f19368g = -1;
            this.f19369h = -1.0f;
            this.f19372k = 16777215;
            this.f19373l = 16777215;
            this.f19366e = source.f19366e;
            this.f19367f = source.f19367f;
            this.f19368g = source.f19368g;
            this.f19369h = source.f19369h;
            this.f19370i = source.f19370i;
            this.f19371j = source.f19371j;
            this.f19372k = source.f19372k;
            this.f19373l = source.f19373l;
            this.f19374m = source.f19374m;
        }

        public LayoutParams(Parcel in2) {
            super(-2, -2);
            this.f19366e = 0.0f;
            this.f19367f = 1.0f;
            this.f19368g = -1;
            this.f19369h = -1.0f;
            this.f19372k = 16777215;
            this.f19373l = 16777215;
            this.f19366e = in2.readFloat();
            this.f19367f = in2.readFloat();
            this.f19368g = in2.readInt();
            this.f19369h = in2.readFloat();
            this.f19370i = in2.readInt();
            this.f19371j = in2.readInt();
            this.f19372k = in2.readInt();
            this.f19373l = in2.readInt();
            this.f19374m = in2.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = in2.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = in2.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = in2.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = in2.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = in2.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = in2.readInt();
        }
    }

    public FlexboxLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.f19362w = -1;
        this.f19365z = new ArrayList();
        this.A = new h(this);
        this.f19354k0 = new b();
        this.C1 = -1;
        this.K1 = Integer.MIN_VALUE;
        this.f19361v2 = Integer.MIN_VALUE;
        this.C2 = Integer.MIN_VALUE;
        this.E7 = new SparseArray<>();
        this.H7 = -1;
        this.I7 = new h.b();
        RecyclerView.o.d dVarV0 = RecyclerView.o.v0(context, attrs, defStyleAttr, defStyleRes);
        int i10 = dVarV0.f6731a;
        if (i10 != 0) {
            if (i10 == 1) {
                if (dVarV0.f6733c) {
                    setFlexDirection(3);
                } else {
                    setFlexDirection(2);
                }
            }
        } else if (dVarV0.f6733c) {
            setFlexDirection(1);
        } else {
            setFlexDirection(0);
        }
        setFlexWrap(1);
        setAlignItems(4);
        this.F7 = context;
    }
}
