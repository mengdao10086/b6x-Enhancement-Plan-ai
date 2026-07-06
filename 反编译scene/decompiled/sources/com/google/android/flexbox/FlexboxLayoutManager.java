package com.google.android.flexbox;

import a.ou;
import a.pu;
import a.qu;
import a.su;
import a.vu;
import a.wp;
import a.wu;
import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class FlexboxLayoutManager extends RecyclerView.o implements ou {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Rect f8266a = new Rect();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wp f4513a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f4514a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f4516a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RecyclerView.a0 f4517a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RecyclerView.v f4518a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f4520a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f4521a;
    public wp b;
    public int f;
    public int g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f4523g;
    public int h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public boolean f4524h;
    public int i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public boolean f4525i;
    public int j = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<qu> f4522a = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final su f4512a = new su(this);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f4519a = new b();
    public int k = -1;
    public int l = Integer.MIN_VALUE;
    public int m = Integer.MIN_VALUE;
    public int n = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SparseArray<View> f4515a = new SparseArray<>();
    public int o = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public su.a f4511a = new su.a();

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8267a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4527a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f4528b;
        public int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f4529c;
        public int d;

        public b() {
            this.d = 0;
        }

        public static /* synthetic */ int l(b bVar, int i) {
            int i2 = bVar.d + i;
            bVar.d = i2;
            return i2;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void r() {
            /*
                r2 = this;
                com.google.android.flexbox.FlexboxLayoutManager r0 = com.google.android.flexbox.FlexboxLayoutManager.this
                boolean r0 = r0.i()
                if (r0 != 0) goto L27
                com.google.android.flexbox.FlexboxLayoutManager r0 = com.google.android.flexbox.FlexboxLayoutManager.this
                boolean r0 = com.google.android.flexbox.FlexboxLayoutManager.S1(r0)
                if (r0 == 0) goto L27
                boolean r0 = r2.f4527a
                if (r0 == 0) goto L15
                goto L2b
            L15:
                com.google.android.flexbox.FlexboxLayoutManager r0 = com.google.android.flexbox.FlexboxLayoutManager.this
                int r0 = r0.t0()
                com.google.android.flexbox.FlexboxLayoutManager r1 = com.google.android.flexbox.FlexboxLayoutManager.this
                a.wp r1 = com.google.android.flexbox.FlexboxLayoutManager.T1(r1)
                int r1 = r1.m()
                int r0 = r0 - r1
                goto L40
            L27:
                boolean r0 = r2.f4527a
                if (r0 == 0) goto L36
            L2b:
                com.google.android.flexbox.FlexboxLayoutManager r0 = com.google.android.flexbox.FlexboxLayoutManager.this
                a.wp r0 = com.google.android.flexbox.FlexboxLayoutManager.T1(r0)
                int r0 = r0.i()
                goto L40
            L36:
                com.google.android.flexbox.FlexboxLayoutManager r0 = com.google.android.flexbox.FlexboxLayoutManager.this
                a.wp r0 = com.google.android.flexbox.FlexboxLayoutManager.T1(r0)
                int r0 = r0.m()
            L40:
                r2.c = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.b.r():void");
        }

        public final void s(View view) {
            int iG;
            int iD;
            wp wpVar = FlexboxLayoutManager.this.g == 0 ? FlexboxLayoutManager.this.b : FlexboxLayoutManager.this.f4513a;
            if (FlexboxLayoutManager.this.i() || !FlexboxLayoutManager.this.f4523g) {
                if (this.f4527a) {
                    iD = wpVar.d(view);
                    this.c = iD + wpVar.o();
                } else {
                    iG = wpVar.g(view);
                    this.c = iG;
                }
            } else if (this.f4527a) {
                iD = wpVar.g(view);
                this.c = iD + wpVar.o();
            } else {
                iG = wpVar.d(view);
                this.c = iG;
            }
            this.f8267a = FlexboxLayoutManager.this.m0(view);
            this.f4529c = false;
            int[] iArr = FlexboxLayoutManager.this.f4512a.f2926a;
            int i = this.f8267a;
            if (i == -1) {
                i = 0;
            }
            int i2 = iArr[i];
            this.b = i2 != -1 ? i2 : 0;
            if (FlexboxLayoutManager.this.f4522a.size() > this.b) {
                this.f8267a = ((qu) FlexboxLayoutManager.this.f4522a.get(this.b)).l;
            }
        }

        public final void t() {
            this.f8267a = -1;
            this.b = -1;
            this.c = Integer.MIN_VALUE;
            boolean z = false;
            this.f4528b = false;
            this.f4529c = false;
            if (!FlexboxLayoutManager.this.i() ? !(FlexboxLayoutManager.this.g != 0 ? FlexboxLayoutManager.this.g != 2 : FlexboxLayoutManager.this.f != 3) : !(FlexboxLayoutManager.this.g != 0 ? FlexboxLayoutManager.this.g != 2 : FlexboxLayoutManager.this.f != 1)) {
                z = true;
            }
            this.f4527a = z;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f8267a + ", mFlexLinePosition=" + this.b + ", mCoordinate=" + this.c + ", mPerpendicularCoordinate=" + this.d + ", mLayoutFromEnd=" + this.f4527a + ", mValid=" + this.f4528b + ", mAssignedFromSavedState=" + this.f4529c + '}';
        }
    }

    public static class c extends RecyclerView.p implements pu {
        public static final Parcelable.Creator<c> CREATOR = new vu();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f8268a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f4530a;
        public float b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public int f4531b;
        public float c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public int f4532c;
        public int d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public boolean f4533d;
        public int e;

        public c(int i, int i2) {
            super(i, i2);
            this.f8268a = 0.0f;
            this.b = 1.0f;
            this.f4530a = -1;
            this.c = -1.0f;
            this.d = 16777215;
            this.e = 16777215;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f8268a = 0.0f;
            this.b = 1.0f;
            this.f4530a = -1;
            this.c = -1.0f;
            this.d = 16777215;
            this.e = 16777215;
        }

        public c(Parcel parcel) {
            super(-2, -2);
            this.f8268a = 0.0f;
            this.b = 1.0f;
            this.f4530a = -1;
            this.c = -1.0f;
            this.d = 16777215;
            this.e = 16777215;
            this.f8268a = parcel.readFloat();
            this.b = parcel.readFloat();
            this.f4530a = parcel.readInt();
            this.c = parcel.readFloat();
            this.f4531b = parcel.readInt();
            this.f4532c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            this.f4533d = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }

        @Override // a.pu
        public int a() {
            return this.d;
        }

        @Override // a.pu
        public float b() {
            return this.b;
        }

        @Override // a.pu
        public int c() {
            return this.f4530a;
        }

        @Override // a.pu
        public int d() {
            return this.e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // a.pu
        public void e(int i) {
            this.f4531b = i;
        }

        @Override // a.pu
        public int f() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // a.pu
        public int g() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // a.pu
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // a.pu
        public int getOrder() {
            return 1;
        }

        @Override // a.pu
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // a.pu
        public int h() {
            return this.f4532c;
        }

        @Override // a.pu
        public int i() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // a.pu
        public float j() {
            return this.f8268a;
        }

        @Override // a.pu
        public boolean k() {
            return this.f4533d;
        }

        @Override // a.pu
        public int l() {
            return this.f4531b;
        }

        @Override // a.pu
        public float m() {
            return this.c;
        }

        @Override // a.pu
        public void n(int i) {
            this.f4532c = i;
        }

        @Override // a.pu
        public int p() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeFloat(this.f8268a);
            parcel.writeFloat(this.b);
            parcel.writeInt(this.f4530a);
            parcel.writeFloat(this.c);
            parcel.writeInt(this.f4531b);
            parcel.writeInt(this.f4532c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeByte(this.f4533d ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8269a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4534a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f4535b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;

        public d() {
            this.g = 1;
            this.h = 1;
        }

        public static /* synthetic */ int c(d dVar, int i) {
            int i2 = dVar.d + i;
            dVar.d = i2;
            return i2;
        }

        public static /* synthetic */ int d(d dVar, int i) {
            int i2 = dVar.d - i;
            dVar.d = i2;
            return i2;
        }

        public static /* synthetic */ int i(d dVar, int i) {
            int i2 = dVar.f8269a - i;
            dVar.f8269a = i2;
            return i2;
        }

        public static /* synthetic */ int l(d dVar) {
            int i = dVar.b;
            dVar.b = i + 1;
            return i;
        }

        public static /* synthetic */ int m(d dVar) {
            int i = dVar.b;
            dVar.b = i - 1;
            return i;
        }

        public static /* synthetic */ int n(d dVar, int i) {
            int i2 = dVar.b + i;
            dVar.b = i2;
            return i2;
        }

        public static /* synthetic */ int q(d dVar, int i) {
            int i2 = dVar.e + i;
            dVar.e = i2;
            return i2;
        }

        public static /* synthetic */ int u(d dVar, int i) {
            int i2 = dVar.c + i;
            dVar.c = i2;
            return i2;
        }

        public static /* synthetic */ int v(d dVar, int i) {
            int i2 = dVar.c - i;
            dVar.c = i2;
            return i2;
        }

        public final boolean D(RecyclerView.a0 a0Var, List<qu> list) {
            int i;
            int i2 = this.c;
            return i2 >= 0 && i2 < a0Var.b() && (i = this.b) >= 0 && i < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.f8269a + ", mFlexLinePosition=" + this.b + ", mPosition=" + this.c + ", mOffset=" + this.d + ", mScrollingOffset=" + this.e + ", mLastScrollDelta=" + this.f + ", mItemDirection=" + this.g + ", mLayoutDirection=" + this.h + '}';
        }
    }

    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new wu();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8270a;
        public int b;

        public e() {
        }

        public e(Parcel parcel) {
            this.f8270a = parcel.readInt();
            this.b = parcel.readInt();
        }

        public e(e eVar) {
            this.f8270a = eVar.f8270a;
            this.b = eVar.b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.f8270a + ", mAnchorOffset=" + this.b + '}';
        }

        public final boolean w(int i) {
            int i2 = this.f8270a;
            return i2 >= 0 && i2 < i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f8270a);
            parcel.writeInt(this.b);
        }

        public final void x() {
            this.f8270a = -1;
        }
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        int i3;
        RecyclerView.o.b bVarN0 = RecyclerView.o.n0(context, attributeSet, i, i2);
        int i4 = bVarN0.f8236a;
        if (i4 != 0) {
            if (i4 == 1) {
                i3 = bVarN0.f4410a ? 3 : 2;
                I2(i3);
            }
        } else if (bVarN0.f4410a) {
            I2(1);
        } else {
            i3 = 0;
            I2(i3);
        }
        J2(1);
        H2(4);
        this.f4514a = context;
    }

    public static boolean C0(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (i3 > 0 && i != i3) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i;
        }
        return true;
    }

    private boolean L1(View view, int i, int i2, RecyclerView.p pVar) {
        return (!view.isLayoutRequested() && B0() && C0(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) pVar).width) && C0(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) pVar).height)) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int A(RecyclerView.a0 a0Var) {
        return a2(a0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int A2(a.qu r26, com.google.android.flexbox.FlexboxLayoutManager.d r27) {
        /*
            Method dump skipped, instruction units count: 527
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.A2(a.qu, com.google.android.flexbox.FlexboxLayoutManager$d):int");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int B(RecyclerView.a0 a0Var) {
        return b2(a0Var);
    }

    public final void B2(RecyclerView.v vVar, d dVar) {
        if (dVar.f4535b) {
            if (dVar.h == -1) {
                D2(vVar, dVar);
            } else {
                E2(vVar, dVar);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int C(RecyclerView.a0 a0Var) {
        return c2(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int C1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (!i() || this.g == 0) {
            int iV2 = v2(i, vVar, a0Var);
            this.f4515a.clear();
            return iV2;
        }
        int iW2 = w2(i);
        b.l(this.f4519a, iW2);
        this.b.r(-iW2);
        return iW2;
    }

    public final void C2(RecyclerView.v vVar, int i, int i2) {
        while (i2 >= i) {
            t1(i2, vVar);
            i2--;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int D(RecyclerView.a0 a0Var) {
        return a2(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void D1(int i) {
        this.k = i;
        this.l = Integer.MIN_VALUE;
        e eVar = this.f4521a;
        if (eVar != null) {
            eVar.x();
        }
        z1();
    }

    public final void D2(RecyclerView.v vVar, d dVar) {
        int iT;
        int i;
        View viewS;
        int i2;
        if (dVar.e < 0 || (iT = T()) == 0 || (viewS = S(iT - 1)) == null || (i2 = this.f4512a.f2926a[m0(viewS)]) == -1) {
            return;
        }
        qu quVar = this.f4522a.get(i2);
        int i3 = i;
        while (true) {
            if (i3 < 0) {
                break;
            }
            View viewS2 = S(i3);
            if (viewS2 != null) {
                if (!X1(viewS2, dVar.e)) {
                    break;
                }
                if (quVar.l != m0(viewS2)) {
                    continue;
                } else if (i2 <= 0) {
                    iT = i3;
                    break;
                } else {
                    i2 += dVar.h;
                    quVar = this.f4522a.get(i2);
                    iT = i3;
                }
            }
            i3--;
        }
        C2(vVar, iT, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int E(RecyclerView.a0 a0Var) {
        return b2(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int E1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (i() || (this.g == 0 && !i())) {
            int iV2 = v2(i, vVar, a0Var);
            this.f4515a.clear();
            return iV2;
        }
        int iW2 = w2(i);
        b.l(this.f4519a, iW2);
        this.b.r(-iW2);
        return iW2;
    }

    public final void E2(RecyclerView.v vVar, d dVar) {
        int iT;
        View viewS;
        if (dVar.e < 0 || (iT = T()) == 0 || (viewS = S(0)) == null) {
            return;
        }
        int i = this.f4512a.f2926a[m0(viewS)];
        int i2 = -1;
        if (i == -1) {
            return;
        }
        qu quVar = this.f4522a.get(i);
        int i3 = 0;
        while (true) {
            if (i3 >= iT) {
                break;
            }
            View viewS2 = S(i3);
            if (viewS2 != null) {
                if (!Y1(viewS2, dVar.e)) {
                    break;
                }
                if (quVar.m != m0(viewS2)) {
                    continue;
                } else if (i >= this.f4522a.size() - 1) {
                    i2 = i3;
                    break;
                } else {
                    i += dVar.h;
                    quVar = this.f4522a.get(i);
                    i2 = i3;
                }
            }
            i3++;
        }
        C2(vVar, 0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int F(RecyclerView.a0 a0Var) {
        return c2(a0Var);
    }

    public final void F2() {
        int iH0 = i() ? h0() : u0();
        this.f4520a.f4534a = iH0 == 0 || iH0 == Integer.MIN_VALUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G2() {
        /*
            r6 = this;
            int r0 = r6.i0()
            int r1 = r6.f
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L43
            if (r1 == r4) goto L36
            if (r1 == r2) goto L27
            r5 = 3
            if (r1 == r5) goto L17
            r6.f4523g = r3
        L14:
            r6.f4524h = r3
            goto L4f
        L17:
            if (r0 != r4) goto L1a
            r3 = r4
        L1a:
            r6.f4523g = r3
            int r0 = r6.g
            if (r0 != r2) goto L24
            r0 = r3 ^ 1
            r6.f4523g = r0
        L24:
            r6.f4524h = r4
            goto L4f
        L27:
            if (r0 != r4) goto L2b
            r0 = r4
            goto L2c
        L2b:
            r0 = r3
        L2c:
            r6.f4523g = r0
            int r1 = r6.g
            if (r1 != r2) goto L14
            r0 = r0 ^ r4
            r6.f4523g = r0
            goto L14
        L36:
            if (r0 == r4) goto L3a
            r0 = r4
            goto L3b
        L3a:
            r0 = r3
        L3b:
            r6.f4523g = r0
            int r0 = r6.g
            if (r0 != r2) goto L14
        L41:
            r3 = r4
            goto L14
        L43:
            if (r0 != r4) goto L47
            r0 = r4
            goto L48
        L47:
            r0 = r3
        L48:
            r6.f4523g = r0
            int r0 = r6.g
            if (r0 != r2) goto L14
            goto L41
        L4f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.G2():void");
    }

    public void H2(int i) {
        int i2 = this.i;
        if (i2 != i) {
            if (i2 == 4 || i == 4) {
                p1();
                Z1();
            }
            this.i = i;
            z1();
        }
    }

    public void I2(int i) {
        if (this.f != i) {
            p1();
            this.f = i;
            this.f4513a = null;
            this.b = null;
            Z1();
            z1();
        }
    }

    public void J2(int i) {
        if (i == 2) {
            throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
        }
        int i2 = this.g;
        if (i2 != i) {
            if (i2 == 0 || i == 0) {
                p1();
                Z1();
            }
            this.g = i;
            this.f4513a = null;
            this.b = null;
            z1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void K0(RecyclerView.g gVar, RecyclerView.g gVar2) {
        p1();
    }

    public final boolean K2(RecyclerView.a0 a0Var, b bVar) {
        if (T() == 0) {
            return false;
        }
        View viewJ2 = bVar.f4527a ? j2(a0Var.b()) : g2(a0Var.b());
        if (viewJ2 == null) {
            return false;
        }
        bVar.s(viewJ2);
        if (!a0Var.e() && P1()) {
            if (this.f4513a.g(viewJ2) >= this.f4513a.i() || this.f4513a.d(viewJ2) < this.f4513a.m()) {
                bVar.c = bVar.f4527a ? this.f4513a.i() : this.f4513a.m();
            }
        }
        return true;
    }

    public final boolean L2(RecyclerView.a0 a0Var, b bVar, e eVar) {
        int i;
        View viewS;
        if (!a0Var.e() && (i = this.k) != -1) {
            if (i >= 0 && i < a0Var.b()) {
                bVar.f8267a = this.k;
                bVar.b = this.f4512a.f2926a[bVar.f8267a];
                e eVar2 = this.f4521a;
                if (eVar2 != null && eVar2.w(a0Var.b())) {
                    bVar.c = this.f4513a.m() + eVar.b;
                    bVar.f4529c = true;
                    bVar.b = -1;
                    return true;
                }
                if (this.l != Integer.MIN_VALUE) {
                    bVar.c = (i() || !this.f4523g) ? this.f4513a.m() + this.l : this.l - this.f4513a.j();
                    return true;
                }
                View viewM = M(this.k);
                if (viewM == null) {
                    if (T() > 0 && (viewS = S(0)) != null) {
                        bVar.f4527a = this.k < m0(viewS);
                    }
                    bVar.r();
                } else {
                    if (this.f4513a.e(viewM) > this.f4513a.n()) {
                        bVar.r();
                        return true;
                    }
                    if (this.f4513a.g(viewM) - this.f4513a.m() < 0) {
                        bVar.c = this.f4513a.m();
                        bVar.f4527a = false;
                        return true;
                    }
                    if (this.f4513a.i() - this.f4513a.d(viewM) < 0) {
                        bVar.c = this.f4513a.i();
                        bVar.f4527a = true;
                        return true;
                    }
                    bVar.c = bVar.f4527a ? this.f4513a.d(viewM) + this.f4513a.o() : this.f4513a.g(viewM);
                }
                return true;
            }
            this.k = -1;
            this.l = Integer.MIN_VALUE;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void M0(RecyclerView recyclerView) {
        super.M0(recyclerView);
        this.f4516a = (View) recyclerView.getParent();
    }

    public final void M2(RecyclerView.a0 a0Var, b bVar) {
        if (L2(a0Var, bVar, this.f4521a) || K2(a0Var, bVar)) {
            return;
        }
        bVar.r();
        bVar.f8267a = 0;
        bVar.b = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p N() {
        return new c(-2, -2);
    }

    public final void N2(int i) {
        if (i >= l2()) {
            return;
        }
        int iT = T();
        this.f4512a.t(iT);
        this.f4512a.u(iT);
        this.f4512a.s(iT);
        if (i >= this.f4512a.f2926a.length) {
            return;
        }
        this.o = i;
        View viewR2 = r2();
        if (viewR2 == null) {
            return;
        }
        this.k = m0(viewR2);
        this.l = (i() || !this.f4523g) ? this.f4513a.g(viewR2) - this.f4513a.m() : this.f4513a.d(viewR2) + this.f4513a.j();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p O(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void O0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.O0(recyclerView, vVar);
        if (this.f4525i) {
            q1(vVar);
            vVar.c();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0064 A[PHI: r5
  0x0064: PHI (r5v3 boolean) = (r5v2 boolean), (r5v13 boolean) binds: [B:18:0x0055, B:10:0x0038] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O2(int r12) {
        /*
            Method dump skipped, instruction units count: 371
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.O2(int):void");
    }

    public final void P2(int i, int i2) {
        this.f4520a.h = i;
        boolean zI = i();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(t0(), u0());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(g0(), h0());
        boolean z = !zI && this.f4523g;
        if (i == 1) {
            View viewS = S(T() - 1);
            if (viewS == null) {
                return;
            }
            this.f4520a.d = this.f4513a.d(viewS);
            int iM0 = m0(viewS);
            View viewK2 = k2(viewS, this.f4522a.get(this.f4512a.f2926a[iM0]));
            this.f4520a.g = 1;
            d dVar = this.f4520a;
            dVar.c = iM0 + dVar.g;
            if (this.f4512a.f2926a.length <= this.f4520a.c) {
                this.f4520a.b = -1;
            } else {
                d dVar2 = this.f4520a;
                dVar2.b = this.f4512a.f2926a[dVar2.c];
            }
            if (z) {
                this.f4520a.d = this.f4513a.g(viewK2);
                this.f4520a.e = (-this.f4513a.g(viewK2)) + this.f4513a.m();
                d dVar3 = this.f4520a;
                dVar3.e = Math.max(dVar3.e, 0);
            } else {
                this.f4520a.d = this.f4513a.d(viewK2);
                this.f4520a.e = this.f4513a.d(viewK2) - this.f4513a.i();
            }
            if ((this.f4520a.b == -1 || this.f4520a.b > this.f4522a.size() - 1) && this.f4520a.c <= getFlexItemCount()) {
                int i3 = i2 - this.f4520a.e;
                this.f4511a.a();
                if (i3 > 0) {
                    su suVar = this.f4512a;
                    su.a aVar = this.f4511a;
                    int i4 = this.f4520a.c;
                    List<qu> list = this.f4522a;
                    if (zI) {
                        suVar.d(aVar, iMakeMeasureSpec, iMakeMeasureSpec2, i3, i4, list);
                    } else {
                        suVar.g(aVar, iMakeMeasureSpec, iMakeMeasureSpec2, i3, i4, list);
                    }
                    this.f4512a.q(iMakeMeasureSpec, iMakeMeasureSpec2, this.f4520a.c);
                    this.f4512a.Y(this.f4520a.c);
                }
            }
        } else {
            View viewS2 = S(0);
            if (viewS2 == null) {
                return;
            }
            this.f4520a.d = this.f4513a.g(viewS2);
            int iM02 = m0(viewS2);
            View viewH2 = h2(viewS2, this.f4522a.get(this.f4512a.f2926a[iM02]));
            this.f4520a.g = 1;
            int i5 = this.f4512a.f2926a[iM02];
            if (i5 == -1) {
                i5 = 0;
            }
            if (i5 > 0) {
                this.f4520a.c = iM02 - this.f4522a.get(i5 - 1).b();
            } else {
                this.f4520a.c = -1;
            }
            this.f4520a.b = i5 > 0 ? i5 - 1 : 0;
            d dVar4 = this.f4520a;
            wp wpVar = this.f4513a;
            if (z) {
                dVar4.d = wpVar.d(viewH2);
                this.f4520a.e = this.f4513a.d(viewH2) - this.f4513a.i();
                d dVar5 = this.f4520a;
                dVar5.e = Math.max(dVar5.e, 0);
            } else {
                dVar4.d = wpVar.g(viewH2);
                this.f4520a.e = (-this.f4513a.g(viewH2)) + this.f4513a.m();
            }
        }
        d dVar6 = this.f4520a;
        dVar6.f8269a = i2 - dVar6.e;
    }

    public final void Q2(b bVar, boolean z, boolean z2) {
        d dVar;
        int i;
        int paddingRight;
        if (z2) {
            F2();
        } else {
            this.f4520a.f4534a = false;
        }
        if (i() || !this.f4523g) {
            dVar = this.f4520a;
            i = this.f4513a.i();
            paddingRight = bVar.c;
        } else {
            dVar = this.f4520a;
            i = bVar.c;
            paddingRight = getPaddingRight();
        }
        dVar.f8269a = i - paddingRight;
        this.f4520a.c = bVar.f8267a;
        this.f4520a.g = 1;
        this.f4520a.h = 1;
        this.f4520a.d = bVar.c;
        this.f4520a.e = Integer.MIN_VALUE;
        this.f4520a.b = bVar.b;
        if (!z || this.f4522a.size() <= 1 || bVar.b < 0 || bVar.b >= this.f4522a.size() - 1) {
            return;
        }
        qu quVar = this.f4522a.get(bVar.b);
        d.l(this.f4520a);
        d.u(this.f4520a, quVar.b());
    }

    public final void R2(b bVar, boolean z, boolean z2) {
        d dVar;
        int width;
        if (z2) {
            F2();
        } else {
            this.f4520a.f4534a = false;
        }
        if (i() || !this.f4523g) {
            dVar = this.f4520a;
            width = bVar.c;
        } else {
            dVar = this.f4520a;
            width = this.f4516a.getWidth() - bVar.c;
        }
        dVar.f8269a = width - this.f4513a.m();
        this.f4520a.c = bVar.f8267a;
        this.f4520a.g = 1;
        this.f4520a.h = -1;
        this.f4520a.d = bVar.c;
        this.f4520a.e = Integer.MIN_VALUE;
        this.f4520a.b = bVar.b;
        if (!z || bVar.b <= 0 || this.f4522a.size() <= bVar.b) {
            return;
        }
        qu quVar = this.f4522a.get(bVar.b);
        d.m(this.f4520a);
        d.v(this.f4520a, quVar.b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView recyclerView, int i, int i2) {
        super.X0(recyclerView, i, i2);
        N2(i);
    }

    public final boolean X1(View view, int i) {
        return (i() || !this.f4523g) ? this.f4513a.g(view) >= this.f4513a.h() - i : this.f4513a.d(view) <= i;
    }

    public final boolean Y1(View view, int i) {
        return (i() || !this.f4523g) ? this.f4513a.d(view) <= i : this.f4513a.h() - this.f4513a.g(view) <= i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Z0(RecyclerView recyclerView, int i, int i2, int i3) {
        super.Z0(recyclerView, i, i2, i3);
        N2(Math.min(i, i2));
    }

    public final void Z1() {
        this.f4522a.clear();
        this.f4519a.t();
        this.f4519a.d = 0;
    }

    @Override // a.ou
    public void a(View view, int i, int i2, qu quVar) {
        int iR0;
        int iR;
        t(view, f8266a);
        if (i()) {
            iR0 = j0(view);
            iR = o0(view);
        } else {
            iR0 = r0(view);
            iR = R(view);
        }
        int i3 = iR0 + iR;
        quVar.e += i3;
        quVar.f += i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a1(RecyclerView recyclerView, int i, int i2) {
        super.a1(recyclerView, i, i2);
        N2(i);
    }

    public final int a2(RecyclerView.a0 a0Var) {
        if (T() == 0) {
            return 0;
        }
        int iB = a0Var.b();
        e2();
        View viewG2 = g2(iB);
        View viewJ2 = j2(iB);
        if (a0Var.b() == 0 || viewG2 == null || viewJ2 == null) {
            return 0;
        }
        return Math.min(this.f4513a.n(), this.f4513a.d(viewJ2) - this.f4513a.g(viewG2));
    }

    @Override // a.ou
    public int b(int i, int i2, int i3) {
        return RecyclerView.o.U(g0(), h0(), i2, i3, v());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void b1(RecyclerView recyclerView, int i, int i2) {
        super.b1(recyclerView, i, i2);
        N2(i);
    }

    public final int b2(RecyclerView.a0 a0Var) {
        if (T() == 0) {
            return 0;
        }
        int iB = a0Var.b();
        View viewG2 = g2(iB);
        View viewJ2 = j2(iB);
        if (a0Var.b() != 0 && viewG2 != null && viewJ2 != null) {
            int iM0 = m0(viewG2);
            int iM02 = m0(viewJ2);
            int iAbs = Math.abs(this.f4513a.d(viewJ2) - this.f4513a.g(viewG2));
            int i = this.f4512a.f2926a[iM0];
            if (i != 0 && i != -1) {
                return Math.round((i * (iAbs / ((r4[iM02] - i) + 1))) + (this.f4513a.m() - this.f4513a.g(viewG2)));
            }
        }
        return 0;
    }

    @Override // a.ou
    public int c(int i, int i2, int i3) {
        return RecyclerView.o.U(t0(), u0(), i2, i3, u());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(RecyclerView recyclerView, int i, int i2, Object obj) {
        super.c1(recyclerView, i, i2, obj);
        N2(i);
    }

    public final int c2(RecyclerView.a0 a0Var) {
        if (T() == 0) {
            return 0;
        }
        int iB = a0Var.b();
        View viewG2 = g2(iB);
        View viewJ2 = j2(iB);
        if (a0Var.b() == 0 || viewG2 == null || viewJ2 == null) {
            return 0;
        }
        int iI2 = i2();
        return (int) ((Math.abs(this.f4513a.d(viewJ2) - this.f4513a.g(viewG2)) / ((l2() - iI2) + 1)) * a0Var.b());
    }

    @Override // a.ou
    public void d(int i, View view) {
        this.f4515a.put(i, view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void d1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int i;
        int i2;
        this.f4518a = vVar;
        this.f4517a = a0Var;
        int iB = a0Var.b();
        if (iB == 0 && a0Var.e()) {
            return;
        }
        G2();
        e2();
        d2();
        this.f4512a.t(iB);
        this.f4512a.u(iB);
        this.f4512a.s(iB);
        this.f4520a.f4535b = false;
        e eVar = this.f4521a;
        if (eVar != null && eVar.w(iB)) {
            this.k = this.f4521a.f8270a;
        }
        if (!this.f4519a.f4528b || this.k != -1 || this.f4521a != null) {
            this.f4519a.t();
            M2(a0Var, this.f4519a);
            this.f4519a.f4528b = true;
        }
        G(vVar);
        if (this.f4519a.f4527a) {
            R2(this.f4519a, false, true);
        } else {
            Q2(this.f4519a, false, true);
        }
        O2(iB);
        f2(vVar, a0Var, this.f4520a);
        if (this.f4519a.f4527a) {
            i2 = this.f4520a.d;
            Q2(this.f4519a, true, false);
            f2(vVar, a0Var, this.f4520a);
            i = this.f4520a.d;
        } else {
            i = this.f4520a.d;
            R2(this.f4519a, true, false);
            f2(vVar, a0Var, this.f4520a);
            i2 = this.f4520a.d;
        }
        if (T() > 0) {
            if (this.f4519a.f4527a) {
                p2(i2 + o2(i, vVar, a0Var, true), vVar, a0Var, false);
            } else {
                o2(i + p2(i2, vVar, a0Var, true), vVar, a0Var, false);
            }
        }
    }

    public final void d2() {
        if (this.f4520a == null) {
            this.f4520a = new d();
        }
    }

    @Override // a.ou
    public View e(int i) {
        return k(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void e1(RecyclerView.a0 a0Var) {
        super.e1(a0Var);
        this.f4521a = null;
        this.k = -1;
        this.l = Integer.MIN_VALUE;
        this.o = -1;
        this.f4519a.t();
        this.f4515a.clear();
    }

    public final void e2() {
        wp wpVarC;
        if (this.f4513a != null) {
            return;
        }
        if (!i() ? this.g == 0 : this.g != 0) {
            this.f4513a = wp.a(this);
            wpVarC = wp.c(this);
        } else {
            this.f4513a = wp.c(this);
            wpVarC = wp.a(this);
        }
        this.b = wpVarC;
    }

    @Override // a.ou
    public int f(View view, int i, int i2) {
        int iR0;
        int iR;
        if (i()) {
            iR0 = j0(view);
            iR = o0(view);
        } else {
            iR0 = r0(view);
            iR = R(view);
        }
        return iR0 + iR;
    }

    public final int f2(RecyclerView.v vVar, RecyclerView.a0 a0Var, d dVar) {
        if (dVar.e != Integer.MIN_VALUE) {
            if (dVar.f8269a < 0) {
                d.q(dVar, dVar.f8269a);
            }
            B2(vVar, dVar);
        }
        int i = dVar.f8269a;
        int iA = dVar.f8269a;
        int iY2 = 0;
        boolean zI = i();
        while (true) {
            if ((iA <= 0 && !this.f4520a.f4534a) || !dVar.D(a0Var, this.f4522a)) {
                break;
            }
            qu quVar = this.f4522a.get(dVar.b);
            dVar.c = quVar.l;
            iY2 += y2(quVar, dVar);
            if (zI || !this.f4523g) {
                d.c(dVar, quVar.a() * dVar.h);
            } else {
                d.d(dVar, quVar.a() * dVar.h);
            }
            iA -= quVar.a();
        }
        d.i(dVar, iY2);
        if (dVar.e != Integer.MIN_VALUE) {
            d.q(dVar, iY2);
            if (dVar.f8269a < 0) {
                d.q(dVar, dVar.f8269a);
            }
            B2(vVar, dVar);
        }
        return i - dVar.f8269a;
    }

    public final View g2(int i) {
        View viewN2 = n2(0, T(), i);
        if (viewN2 == null) {
            return null;
        }
        int i2 = this.f4512a.f2926a[m0(viewN2)];
        if (i2 == -1) {
            return null;
        }
        return h2(viewN2, this.f4522a.get(i2));
    }

    @Override // a.ou
    public int getAlignContent() {
        return 5;
    }

    @Override // a.ou
    public int getAlignItems() {
        return this.i;
    }

    @Override // a.ou
    public int getFlexDirection() {
        return this.f;
    }

    @Override // a.ou
    public int getFlexItemCount() {
        return this.f4517a.b();
    }

    @Override // a.ou
    public List<qu> getFlexLinesInternal() {
        return this.f4522a;
    }

    @Override // a.ou
    public int getFlexWrap() {
        return this.g;
    }

    @Override // a.ou
    public int getLargestMainSize() {
        if (this.f4522a.size() == 0) {
            return 0;
        }
        int iMax = Integer.MIN_VALUE;
        int size = this.f4522a.size();
        for (int i = 0; i < size; i++) {
            iMax = Math.max(iMax, this.f4522a.get(i).e);
        }
        return iMax;
    }

    @Override // a.ou
    public int getMaxLine() {
        return this.j;
    }

    @Override // a.ou
    public int getSumOfCrossSize() {
        int size = this.f4522a.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.f4522a.get(i2).g;
        }
        return i;
    }

    @Override // a.ou
    public void h(qu quVar) {
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View h2(android.view.View r6, a.qu r7) {
        /*
            r5 = this;
            boolean r0 = r5.i()
            int r7 = r7.h
            r1 = 1
        L7:
            if (r1 >= r7) goto L3f
            android.view.View r2 = r5.S(r1)
            if (r2 == 0) goto L3c
            int r3 = r2.getVisibility()
            r4 = 8
            if (r3 != r4) goto L18
            goto L3c
        L18:
            boolean r3 = r5.f4523g
            if (r3 == 0) goto L2d
            if (r0 != 0) goto L2d
            a.wp r3 = r5.f4513a
            int r3 = r3.d(r6)
            a.wp r4 = r5.f4513a
            int r4 = r4.d(r2)
            if (r3 >= r4) goto L3c
            goto L3b
        L2d:
            a.wp r3 = r5.f4513a
            int r3 = r3.g(r6)
            a.wp r4 = r5.f4513a
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.h2(android.view.View, a.qu):android.view.View");
    }

    @Override // a.ou
    public boolean i() {
        int i = this.f;
        return i == 0 || i == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void i1(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.f4521a = (e) parcelable;
            z1();
        }
    }

    public int i2() {
        View viewM2 = m2(0, T(), false);
        if (viewM2 == null) {
            return -1;
        }
        return m0(viewM2);
    }

    @Override // a.ou
    public int j(View view) {
        int iJ0;
        int iO0;
        if (i()) {
            iJ0 = r0(view);
            iO0 = R(view);
        } else {
            iJ0 = j0(view);
            iO0 = o0(view);
        }
        return iJ0 + iO0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable j1() {
        if (this.f4521a != null) {
            return new e(this.f4521a);
        }
        e eVar = new e();
        if (T() > 0) {
            View viewR2 = r2();
            eVar.f8270a = m0(viewR2);
            eVar.b = this.f4513a.g(viewR2) - this.f4513a.m();
        } else {
            eVar.x();
        }
        return eVar;
    }

    public final View j2(int i) {
        View viewN2 = n2(T() - 1, -1, i);
        if (viewN2 == null) {
            return null;
        }
        return k2(viewN2, this.f4522a.get(this.f4512a.f2926a[m0(viewN2)]));
    }

    @Override // a.ou
    public View k(int i) {
        View view = this.f4515a.get(i);
        return view != null ? view : this.f4518a.o(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View k2(android.view.View r6, a.qu r7) {
        /*
            r5 = this;
            boolean r0 = r5.i()
            int r1 = r5.T()
            int r1 = r1 + (-2)
            int r2 = r5.T()
            int r7 = r7.h
            int r2 = r2 - r7
            int r2 = r2 + (-1)
        L13:
            if (r1 <= r2) goto L4b
            android.view.View r7 = r5.S(r1)
            if (r7 == 0) goto L48
            int r3 = r7.getVisibility()
            r4 = 8
            if (r3 != r4) goto L24
            goto L48
        L24:
            boolean r3 = r5.f4523g
            if (r3 == 0) goto L39
            if (r0 != 0) goto L39
            a.wp r3 = r5.f4513a
            int r3 = r3.g(r6)
            a.wp r4 = r5.f4513a
            int r4 = r4.g(r7)
            if (r3 <= r4) goto L48
            goto L47
        L39:
            a.wp r3 = r5.f4513a
            int r3 = r3.d(r6)
            a.wp r4 = r5.f4513a
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.k2(android.view.View, a.qu):android.view.View");
    }

    public int l2() {
        View viewM2 = m2(T() - 1, -1, false);
        if (viewM2 == null) {
            return -1;
        }
        return m0(viewM2);
    }

    public final View m2(int i, int i2, boolean z) {
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View viewS = S(i);
            if (x2(viewS, z)) {
                return viewS;
            }
            i += i3;
        }
        return null;
    }

    public final View n2(int i, int i2, int i3) {
        int iM0;
        e2();
        d2();
        int iM = this.f4513a.m();
        int i4 = this.f4513a.i();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View viewS = S(i);
            if (viewS != null && (iM0 = m0(viewS)) >= 0 && iM0 < i3) {
                if (((RecyclerView.p) viewS.getLayoutParams()).s()) {
                    if (view2 == null) {
                        view2 = viewS;
                    }
                } else {
                    if (this.f4513a.g(viewS) >= iM && this.f4513a.d(viewS) <= i4) {
                        return viewS;
                    }
                    if (view == null) {
                        view = viewS;
                    }
                }
            }
            i += i5;
        }
        return view != null ? view : view2;
    }

    public final int o2(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int iV2;
        int i2;
        if (!i() && this.f4523g) {
            int iM = i - this.f4513a.m();
            if (iM <= 0) {
                return 0;
            }
            iV2 = v2(iM, vVar, a0Var);
        } else {
            int i3 = this.f4513a.i() - i;
            if (i3 <= 0) {
                return 0;
            }
            iV2 = -v2(-i3, vVar, a0Var);
        }
        int i4 = i + iV2;
        if (!z || (i2 = this.f4513a.i() - i4) <= 0) {
            return iV2;
        }
        this.f4513a.r(i2);
        return i2 + iV2;
    }

    public final int p2(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int iV2;
        int iM;
        if (i() || !this.f4523g) {
            int iM2 = i - this.f4513a.m();
            if (iM2 <= 0) {
                return 0;
            }
            iV2 = -v2(iM2, vVar, a0Var);
        } else {
            int i2 = this.f4513a.i() - i;
            if (i2 <= 0) {
                return 0;
            }
            iV2 = v2(-i2, vVar, a0Var);
        }
        int i3 = i + iV2;
        if (!z || (iM = i3 - this.f4513a.m()) <= 0) {
            return iV2;
        }
        this.f4513a.r(-iM);
        return iV2 - iM;
    }

    public final int q2(View view) {
        return Y(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
    }

    public final View r2() {
        return S(0);
    }

    public final int s2(View view) {
        return a0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
    }

    @Override // a.ou
    public void setFlexLines(List<qu> list) {
        this.f4522a = list;
    }

    public final int t2(View view) {
        return d0(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean u() {
        if (this.g == 0) {
            return i();
        }
        if (i()) {
            int iT0 = t0();
            View view = this.f4516a;
            if (iT0 <= (view != null ? view.getWidth() : 0)) {
                return false;
            }
        }
        return true;
    }

    public final int u2(View view) {
        return e0(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean v() {
        if (this.g == 0) {
            return !i();
        }
        if (i()) {
            return true;
        }
        int iG0 = g0();
        View view = this.f4516a;
        return iG0 > (view != null ? view.getHeight() : 0);
    }

    public final int v2(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (T() == 0 || i == 0) {
            return 0;
        }
        e2();
        int i2 = 1;
        this.f4520a.f4535b = true;
        boolean z = !i() && this.f4523g;
        if (!z ? i <= 0 : i >= 0) {
            i2 = -1;
        }
        int iAbs = Math.abs(i);
        P2(i2, iAbs);
        int iF2 = this.f4520a.e + f2(vVar, a0Var, this.f4520a);
        if (iF2 < 0) {
            return 0;
        }
        if (z) {
            if (iAbs > iF2) {
                i = (-i2) * iF2;
            }
        } else if (iAbs > iF2) {
            i = i2 * iF2;
        }
        this.f4513a.r(-i);
        this.f4520a.f = i;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean w(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    public final int w2(int i) {
        int iMin;
        if (T() == 0 || i == 0) {
            return 0;
        }
        e2();
        boolean zI = i();
        View view = this.f4516a;
        int width = zI ? view.getWidth() : view.getHeight();
        int iT0 = zI ? t0() : g0();
        if (i0() == 1) {
            int iAbs = Math.abs(i);
            if (i < 0) {
                iMin = Math.min((iT0 + this.f4519a.d) - width, iAbs);
                return -iMin;
            }
            if (this.f4519a.d + i <= 0) {
                return i;
            }
        } else {
            if (i > 0) {
                return Math.min((iT0 - this.f4519a.d) - width, i);
            }
            if (this.f4519a.d + i >= 0) {
                return i;
            }
        }
        iMin = this.f4519a.d;
        return -iMin;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean x0() {
        return true;
    }

    public final boolean x2(View view, boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int iT0 = t0() - getPaddingRight();
        int iG0 = g0() - getPaddingBottom();
        int iS2 = s2(view);
        int iU2 = u2(view);
        int iT2 = t2(view);
        int iQ2 = q2(view);
        return z ? (paddingLeft <= iS2 && iT0 >= iT2) && (paddingTop <= iU2 && iG0 >= iQ2) : (iS2 >= iT0 || iT2 >= paddingLeft) && (iU2 >= iG0 || iQ2 >= paddingTop);
    }

    public final int y2(qu quVar, d dVar) {
        return i() ? z2(quVar, dVar) : A2(quVar, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int z2(a.qu r22, com.google.android.flexbox.FlexboxLayoutManager.d r23) {
        /*
            Method dump skipped, instruction units count: 420
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.z2(a.qu, com.google.android.flexbox.FlexboxLayoutManager$d):int");
    }
}
