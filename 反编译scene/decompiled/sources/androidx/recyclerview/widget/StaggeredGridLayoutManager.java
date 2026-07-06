package androidx.recyclerview.widget;

import a.eq;
import a.gq;
import a.hq;
import a.ni;
import a.qp;
import a.wp;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qp f8241a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wp f4420a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f4424a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BitSet f4426a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f4427a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f[] f4428a;
    public wp b;
    public int g;
    public int h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public boolean f4431i;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public boolean f4432j;
    public int l;
    public int f = -1;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f4429g = false;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public boolean f4430h = false;
    public int i = -1;
    public int j = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f4423a = new d();
    public int k = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f4421a = new Rect();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f4422a = new b();

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public boolean f4433k = false;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public boolean f4434l = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f4425a = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.W1();
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8243a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4436a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int[] f4437a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f4438b;
        public boolean c;

        public b() {
            c();
        }

        public void a() {
            this.b = this.f4436a ? StaggeredGridLayoutManager.this.f4420a.i() : StaggeredGridLayoutManager.this.f4420a.m();
        }

        public void b(int i) {
            this.b = this.f4436a ? StaggeredGridLayoutManager.this.f4420a.i() - i : StaggeredGridLayoutManager.this.f4420a.m() + i;
        }

        public void c() {
            this.f8243a = -1;
            this.b = Integer.MIN_VALUE;
            this.f4436a = false;
            this.f4438b = false;
            this.c = false;
            int[] iArr = this.f4437a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        public void d(f[] fVarArr) {
            int length = fVarArr.length;
            int[] iArr = this.f4437a;
            if (iArr == null || iArr.length < length) {
                this.f4437a = new int[StaggeredGridLayoutManager.this.f4428a.length];
            }
            for (int i = 0; i < length; i++) {
                this.f4437a[i] = fVarArr[i].p(Integer.MIN_VALUE);
            }
        }
    }

    public static class c extends RecyclerView.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f f8244a;
        public boolean d;

        public c(int i, int i2) {
            super(i, i2);
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public final int u() {
            f fVar = this.f8244a;
            if (fVar == null) {
                return -1;
            }
            return fVar.d;
        }

        public boolean v() {
            return this.d;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<a> f8245a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int[] f4439a;

        @SuppressLint({"BanParcelableUsage"})
        public static class a implements Parcelable {
            public static final Parcelable.Creator<a> CREATOR = new gq();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f8246a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public int[] f4440a;
            public int b;

            /* JADX INFO: renamed from: b, reason: collision with other field name */
            public boolean f4441b;

            public a() {
            }

            public a(Parcel parcel) {
                this.f8246a = parcel.readInt();
                this.b = parcel.readInt();
                this.f4441b = parcel.readInt() == 1;
                int i = parcel.readInt();
                if (i > 0) {
                    int[] iArr = new int[i];
                    this.f4440a = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public int q(int i) {
                int[] iArr = this.f4440a;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i];
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f8246a + ", mGapDir=" + this.b + ", mHasUnwantedGapAfter=" + this.f4441b + ", mGapPerSpan=" + Arrays.toString(this.f4440a) + '}';
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f8246a);
                parcel.writeInt(this.b);
                parcel.writeInt(this.f4441b ? 1 : 0);
                int[] iArr = this.f4440a;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f4440a);
                }
            }
        }

        public void a(a aVar) {
            if (this.f8245a == null) {
                this.f8245a = new ArrayList();
            }
            int size = this.f8245a.size();
            for (int i = 0; i < size; i++) {
                a aVar2 = this.f8245a.get(i);
                if (aVar2.f8246a == aVar.f8246a) {
                    this.f8245a.remove(i);
                }
                if (aVar2.f8246a >= aVar.f8246a) {
                    this.f8245a.add(i, aVar);
                    return;
                }
            }
            this.f8245a.add(aVar);
        }

        public void b() {
            int[] iArr = this.f4439a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f8245a = null;
        }

        public void c(int i) {
            int[] iArr = this.f4439a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i, 10) + 1];
                this.f4439a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int[] iArr3 = new int[o(i)];
                this.f4439a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f4439a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public int d(int i) {
            List<a> list = this.f8245a;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f8245a.get(size).f8246a >= i) {
                        this.f8245a.remove(size);
                    }
                }
            }
            return h(i);
        }

        public a e(int i, int i2, int i3, boolean z) {
            List<a> list = this.f8245a;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                a aVar = this.f8245a.get(i4);
                int i5 = aVar.f8246a;
                if (i5 >= i2) {
                    return null;
                }
                if (i5 >= i && (i3 == 0 || aVar.b == i3 || (z && aVar.f4441b))) {
                    return aVar;
                }
            }
            return null;
        }

        public a f(int i) {
            List<a> list = this.f8245a;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f8245a.get(size);
                if (aVar.f8246a == i) {
                    return aVar;
                }
            }
            return null;
        }

        public int g(int i) {
            int[] iArr = this.f4439a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            return iArr[i];
        }

        public int h(int i) {
            int[] iArr = this.f4439a;
            if (iArr == null || i >= iArr.length) {
                return -1;
            }
            int i2 = i(i);
            if (i2 == -1) {
                int[] iArr2 = this.f4439a;
                Arrays.fill(iArr2, i, iArr2.length, -1);
                return this.f4439a.length;
            }
            int i3 = i2 + 1;
            Arrays.fill(this.f4439a, i, i3, -1);
            return i3;
        }

        public final int i(int i) {
            if (this.f8245a == null) {
                return -1;
            }
            a aVarF = f(i);
            if (aVarF != null) {
                this.f8245a.remove(aVarF);
            }
            int size = this.f8245a.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                if (this.f8245a.get(i2).f8246a >= i) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return -1;
            }
            a aVar = this.f8245a.get(i2);
            this.f8245a.remove(i2);
            return aVar.f8246a;
        }

        public void j(int i, int i2) {
            int[] iArr = this.f4439a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            c(i3);
            int[] iArr2 = this.f4439a;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.f4439a, i, i3, -1);
            l(i, i2);
        }

        public void k(int i, int i2) {
            int[] iArr = this.f4439a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            c(i3);
            int[] iArr2 = this.f4439a;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.f4439a;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            m(i, i2);
        }

        public final void l(int i, int i2) {
            List<a> list = this.f8245a;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f8245a.get(size);
                int i3 = aVar.f8246a;
                if (i3 >= i) {
                    aVar.f8246a = i3 + i2;
                }
            }
        }

        public final void m(int i, int i2) {
            List<a> list = this.f8245a;
            if (list == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = list.size() - 1; size >= 0; size--) {
                a aVar = this.f8245a.get(size);
                int i4 = aVar.f8246a;
                if (i4 >= i) {
                    if (i4 < i3) {
                        this.f8245a.remove(size);
                    } else {
                        aVar.f8246a = i4 - i2;
                    }
                }
            }
        }

        public void n(int i, f fVar) {
            c(i);
            this.f4439a[i] = fVar.d;
        }

        public int o(int i) {
            int length = this.f4439a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class e implements Parcelable {
        public static final Parcelable.Creator<e> CREATOR = new hq();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8247a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public List<d.a> f4442a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int[] f4443a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f4444b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public int[] f4445b;
        public int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public boolean f4446c;
        public int d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public boolean f4447d;

        public e() {
        }

        public e(Parcel parcel) {
            this.f8247a = parcel.readInt();
            this.b = parcel.readInt();
            int i = parcel.readInt();
            this.c = i;
            if (i > 0) {
                int[] iArr = new int[i];
                this.f4443a = iArr;
                parcel.readIntArray(iArr);
            }
            int i2 = parcel.readInt();
            this.d = i2;
            if (i2 > 0) {
                int[] iArr2 = new int[i2];
                this.f4445b = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f4444b = parcel.readInt() == 1;
            this.f4446c = parcel.readInt() == 1;
            this.f4447d = parcel.readInt() == 1;
            this.f4442a = parcel.readArrayList(d.a.class.getClassLoader());
        }

        public e(e eVar) {
            this.c = eVar.c;
            this.f8247a = eVar.f8247a;
            this.b = eVar.b;
            this.f4443a = eVar.f4443a;
            this.d = eVar.d;
            this.f4445b = eVar.f4445b;
            this.f4444b = eVar.f4444b;
            this.f4446c = eVar.f4446c;
            this.f4447d = eVar.f4447d;
            this.f4442a = eVar.f4442a;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void q() {
            this.f4443a = null;
            this.c = 0;
            this.f8247a = -1;
            this.b = -1;
        }

        public void r() {
            this.f4443a = null;
            this.c = 0;
            this.d = 0;
            this.f4445b = null;
            this.f4442a = null;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f8247a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            if (this.c > 0) {
                parcel.writeIntArray(this.f4443a);
            }
            parcel.writeInt(this.d);
            if (this.d > 0) {
                parcel.writeIntArray(this.f4445b);
            }
            parcel.writeInt(this.f4444b ? 1 : 0);
            parcel.writeInt(this.f4446c ? 1 : 0);
            parcel.writeInt(this.f4447d ? 1 : 0);
            parcel.writeList(this.f4442a);
        }
    }

    public class f {
        public final int d;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ArrayList<View> f4449a = new ArrayList<>();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8248a = Integer.MIN_VALUE;
        public int b = Integer.MIN_VALUE;
        public int c = 0;

        public f(int i) {
            this.d = i;
        }

        public void a(View view) {
            c cVarN = n(view);
            cVarN.f8244a = this;
            this.f4449a.add(view);
            this.b = Integer.MIN_VALUE;
            if (this.f4449a.size() == 1) {
                this.f8248a = Integer.MIN_VALUE;
            }
            if (cVarN.s() || cVarN.r()) {
                this.c += StaggeredGridLayoutManager.this.f4420a.e(view);
            }
        }

        public void b(boolean z, int i) {
            int iL = z ? l(Integer.MIN_VALUE) : p(Integer.MIN_VALUE);
            e();
            if (iL == Integer.MIN_VALUE) {
                return;
            }
            if (!z || iL >= StaggeredGridLayoutManager.this.f4420a.i()) {
                if (z || iL <= StaggeredGridLayoutManager.this.f4420a.m()) {
                    if (i != Integer.MIN_VALUE) {
                        iL += i;
                    }
                    this.b = iL;
                    this.f8248a = iL;
                }
            }
        }

        public void c() {
            d.a aVarF;
            ArrayList<View> arrayList = this.f4449a;
            View view = arrayList.get(arrayList.size() - 1);
            c cVarN = n(view);
            this.b = StaggeredGridLayoutManager.this.f4420a.d(view);
            if (cVarN.d && (aVarF = StaggeredGridLayoutManager.this.f4423a.f(cVarN.q())) != null && aVarF.b == 1) {
                this.b += aVarF.q(this.d);
            }
        }

        public void d() {
            d.a aVarF;
            View view = this.f4449a.get(0);
            c cVarN = n(view);
            this.f8248a = StaggeredGridLayoutManager.this.f4420a.g(view);
            if (cVarN.d && (aVarF = StaggeredGridLayoutManager.this.f4423a.f(cVarN.q())) != null && aVarF.b == -1) {
                this.f8248a -= aVarF.q(this.d);
            }
        }

        public void e() {
            this.f4449a.clear();
            q();
            this.c = 0;
        }

        public int f() {
            int size;
            int size2;
            if (StaggeredGridLayoutManager.this.f4429g) {
                size = this.f4449a.size() - 1;
                size2 = -1;
            } else {
                size = 0;
                size2 = this.f4449a.size();
            }
            return i(size, size2, true);
        }

        public int g() {
            int size;
            int size2;
            if (StaggeredGridLayoutManager.this.f4429g) {
                size = 0;
                size2 = this.f4449a.size();
            } else {
                size = this.f4449a.size() - 1;
                size2 = -1;
            }
            return i(size, size2, true);
        }

        public int h(int i, int i2, boolean z, boolean z2, boolean z3) {
            int iM = StaggeredGridLayoutManager.this.f4420a.m();
            int i3 = StaggeredGridLayoutManager.this.f4420a.i();
            int i4 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f4449a.get(i);
                int iG = StaggeredGridLayoutManager.this.f4420a.g(view);
                int iD = StaggeredGridLayoutManager.this.f4420a.d(view);
                boolean z4 = false;
                boolean z5 = !z3 ? iG >= i3 : iG > i3;
                if (!z3 ? iD > iM : iD >= iM) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (iG >= iM && iD <= i3) {
                            return StaggeredGridLayoutManager.this.m0(view);
                        }
                    } else if (z2 || iG < iM || iD > i3) {
                        return StaggeredGridLayoutManager.this.m0(view);
                    }
                }
                i += i4;
            }
            return -1;
        }

        public int i(int i, int i2, boolean z) {
            return h(i, i2, false, false, z);
        }

        public int j() {
            return this.c;
        }

        public int k() {
            int i = this.b;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            c();
            return this.b;
        }

        public int l(int i) {
            int i2 = this.b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f4449a.size() == 0) {
                return i;
            }
            c();
            return this.b;
        }

        public View m(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                int size = this.f4449a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f4449a.get(size);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f4429g && staggeredGridLayoutManager.m0(view2) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f4429g && staggeredGridLayoutManager2.m0(view2) <= i) || !view2.hasFocusable()) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f4449a.size();
                int i3 = 0;
                while (i3 < size2) {
                    View view3 = this.f4449a.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f4429g && staggeredGridLayoutManager3.m0(view3) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f4429g && staggeredGridLayoutManager4.m0(view3) >= i) || !view3.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }

        public c n(View view) {
            return (c) view.getLayoutParams();
        }

        public int o() {
            int i = this.f8248a;
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            d();
            return this.f8248a;
        }

        public int p(int i) {
            int i2 = this.f8248a;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f4449a.size() == 0) {
                return i;
            }
            d();
            return this.f8248a;
        }

        public void q() {
            this.f8248a = Integer.MIN_VALUE;
            this.b = Integer.MIN_VALUE;
        }

        public void r(int i) {
            int i2 = this.f8248a;
            if (i2 != Integer.MIN_VALUE) {
                this.f8248a = i2 + i;
            }
            int i3 = this.b;
            if (i3 != Integer.MIN_VALUE) {
                this.b = i3 + i;
            }
        }

        public void s() {
            int size = this.f4449a.size();
            View viewRemove = this.f4449a.remove(size - 1);
            c cVarN = n(viewRemove);
            cVarN.f8244a = null;
            if (cVarN.s() || cVarN.r()) {
                this.c -= StaggeredGridLayoutManager.this.f4420a.e(viewRemove);
            }
            if (size == 1) {
                this.f8248a = Integer.MIN_VALUE;
            }
            this.b = Integer.MIN_VALUE;
        }

        public void t() {
            View viewRemove = this.f4449a.remove(0);
            c cVarN = n(viewRemove);
            cVarN.f8244a = null;
            if (this.f4449a.size() == 0) {
                this.b = Integer.MIN_VALUE;
            }
            if (cVarN.s() || cVarN.r()) {
                this.c -= StaggeredGridLayoutManager.this.f4420a.e(viewRemove);
            }
            this.f8248a = Integer.MIN_VALUE;
        }

        public void u(View view) {
            c cVarN = n(view);
            cVarN.f8244a = this;
            this.f4449a.add(0, view);
            this.f8248a = Integer.MIN_VALUE;
            if (this.f4449a.size() == 1) {
                this.b = Integer.MIN_VALUE;
            }
            if (cVarN.s() || cVarN.r()) {
                this.c += StaggeredGridLayoutManager.this.f4420a.e(view);
            }
        }

        public void v(int i) {
            this.f8248a = i;
            this.b = i;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.o.b bVarN0 = RecyclerView.o.n0(context, attributeSet, i, i2);
        L2(bVarN0.f8236a);
        N2(bVarN0.b);
        M2(bVarN0.f4410a);
        this.f8241a = new qp();
        e2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int A(RecyclerView.a0 a0Var) {
        return Y1(a0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A2(androidx.recyclerview.widget.RecyclerView.v r9, androidx.recyclerview.widget.RecyclerView.a0 r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.A2(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0, boolean):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int B(RecyclerView.a0 a0Var) {
        return Z1(a0Var);
    }

    public final boolean B2(int i) {
        if (this.g == 0) {
            return (i == -1) != this.f4430h;
        }
        return ((i == -1) == this.f4430h) == x2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int C(RecyclerView.a0 a0Var) {
        return a2(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int C1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return J2(i, vVar, a0Var);
    }

    public void C2(int i, RecyclerView.a0 a0Var) {
        int i2;
        int iN2;
        if (i > 0) {
            iN2 = o2();
            i2 = 1;
        } else {
            i2 = -1;
            iN2 = n2();
        }
        this.f8241a.f2590a = true;
        S2(iN2, a0Var);
        K2(i2);
        qp qpVar = this.f8241a;
        qpVar.b = iN2 + qpVar.c;
        qpVar.f7227a = Math.abs(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int D(RecyclerView.a0 a0Var) {
        return Y1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void D1(int i) {
        e eVar = this.f4424a;
        if (eVar != null && eVar.f8247a != i) {
            eVar.q();
        }
        this.i = i;
        this.j = Integer.MIN_VALUE;
        z1();
    }

    public final void D2(View view) {
        for (int i = this.f - 1; i >= 0; i--) {
            this.f4428a[i].u(view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int E(RecyclerView.a0 a0Var) {
        return Z1(a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int E1(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return J2(i, vVar, a0Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0010, code lost:
    
        if (r4.d == (-1)) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E2(androidx.recyclerview.widget.RecyclerView.v r3, a.qp r4) {
        /*
            r2 = this;
            boolean r0 = r4.f2590a
            if (r0 == 0) goto L4d
            boolean r0 = r4.f2592c
            if (r0 == 0) goto L9
            goto L4d
        L9:
            int r0 = r4.f7227a
            r1 = -1
            if (r0 != 0) goto L1e
            int r0 = r4.d
            if (r0 != r1) goto L18
        L12:
            int r4 = r4.f
        L14:
            r2.F2(r3, r4)
            goto L4d
        L18:
            int r4 = r4.e
        L1a:
            r2.G2(r3, r4)
            goto L4d
        L1e:
            int r0 = r4.d
            if (r0 != r1) goto L37
            int r0 = r4.e
            int r1 = r2.q2(r0)
            int r0 = r0 - r1
            if (r0 >= 0) goto L2c
            goto L12
        L2c:
            int r1 = r4.f
            int r4 = r4.f7227a
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r1 - r4
            goto L14
        L37:
            int r0 = r4.f
            int r0 = r2.r2(r0)
            int r1 = r4.f
            int r0 = r0 - r1
            if (r0 >= 0) goto L43
            goto L18
        L43:
            int r1 = r4.e
            int r4 = r4.f7227a
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r4 + r1
            goto L1a
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.E2(androidx.recyclerview.widget.RecyclerView$v, a.qp):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int F(RecyclerView.a0 a0Var) {
        return a2(a0Var);
    }

    public final void F2(RecyclerView.v vVar, int i) {
        for (int iT = T() - 1; iT >= 0; iT--) {
            View viewS = S(iT);
            if (this.f4420a.g(viewS) < i || this.f4420a.q(viewS) < i) {
                return;
            }
            c cVar = (c) viewS.getLayoutParams();
            if (cVar.d) {
                for (int i2 = 0; i2 < this.f; i2++) {
                    if (this.f4428a[i2].f4449a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.f; i3++) {
                    this.f4428a[i3].s();
                }
            } else if (cVar.f8244a.f4449a.size() == 1) {
                return;
            } else {
                cVar.f8244a.s();
            }
            s1(viewS, vVar);
        }
    }

    public final void G2(RecyclerView.v vVar, int i) {
        while (T() > 0) {
            View viewS = S(0);
            if (this.f4420a.d(viewS) > i || this.f4420a.p(viewS) > i) {
                return;
            }
            c cVar = (c) viewS.getLayoutParams();
            if (cVar.d) {
                for (int i2 = 0; i2 < this.f; i2++) {
                    if (this.f4428a[i2].f4449a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.f; i3++) {
                    this.f4428a[i3].t();
                }
            } else if (cVar.f8244a.f4449a.size() == 1) {
                return;
            } else {
                cVar.f8244a.t();
            }
            s1(viewS, vVar);
        }
    }

    public final void H2() {
        if (this.b.k() == 1073741824) {
            return;
        }
        float fMax = 0.0f;
        int iT = T();
        for (int i = 0; i < iT; i++) {
            View viewS = S(i);
            float fE = this.b.e(viewS);
            if (fE >= fMax) {
                if (((c) viewS.getLayoutParams()).v()) {
                    fE = (fE * 1.0f) / this.f;
                }
                fMax = Math.max(fMax, fE);
            }
        }
        int i2 = this.h;
        int iRound = Math.round(fMax * this.f);
        if (this.b.k() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.b.n());
        }
        T2(iRound);
        if (this.h == i2) {
            return;
        }
        for (int i3 = 0; i3 < iT; i3++) {
            View viewS2 = S(i3);
            c cVar = (c) viewS2.getLayoutParams();
            if (!cVar.d) {
                if (x2() && this.g == 1) {
                    int i4 = this.f;
                    int i5 = cVar.f8244a.d;
                    viewS2.offsetLeftAndRight(((-((i4 - 1) - i5)) * this.h) - ((-((i4 - 1) - i5)) * i2));
                } else {
                    int i6 = cVar.f8244a.d;
                    int i7 = this.g;
                    int i8 = (this.h * i6) - (i6 * i2);
                    if (i7 == 1) {
                        viewS2.offsetLeftAndRight(i8);
                    } else {
                        viewS2.offsetTopAndBottom(i8);
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I0(int i) {
        super.I0(i);
        for (int i2 = 0; i2 < this.f; i2++) {
            this.f4428a[i2].r(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void I1(Rect rect, int i, int i2) {
        int iX;
        int iX2;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.g == 1) {
            iX2 = RecyclerView.o.x(i2, rect.height() + paddingTop, k0());
            iX = RecyclerView.o.x(i, (this.h * this.f) + paddingLeft, l0());
        } else {
            iX = RecyclerView.o.x(i, rect.width() + paddingLeft, l0());
            iX2 = RecyclerView.o.x(i2, (this.h * this.f) + paddingTop, k0());
        }
        H1(iX, iX2);
    }

    public final void I2() {
        this.f4430h = (this.g == 1 || !x2()) ? this.f4429g : !this.f4429g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void J0(int i) {
        super.J0(i);
        for (int i2 = 0; i2 < this.f; i2++) {
            this.f4428a[i2].r(i);
        }
    }

    public int J2(int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        if (T() == 0 || i == 0) {
            return 0;
        }
        C2(i, a0Var);
        int iF2 = f2(vVar, this.f8241a, a0Var);
        if (this.f8241a.f7227a >= iF2) {
            i = i < 0 ? -iF2 : iF2;
        }
        this.f4420a.r(-i);
        this.f4431i = this.f4430h;
        qp qpVar = this.f8241a;
        qpVar.f7227a = 0;
        E2(vVar, qpVar);
        return i;
    }

    public final void K2(int i) {
        qp qpVar = this.f8241a;
        qpVar.d = i;
        qpVar.c = this.f4430h != (i == -1) ? -1 : 1;
    }

    public void L2(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        q(null);
        if (i == this.g) {
            return;
        }
        this.g = i;
        wp wpVar = this.f4420a;
        this.f4420a = this.b;
        this.b = wpVar;
        z1();
    }

    public void M2(boolean z) {
        q(null);
        e eVar = this.f4424a;
        if (eVar != null && eVar.f4444b != z) {
            eVar.f4444b = z;
        }
        this.f4429g = z;
        z1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p N() {
        return this.g == 0 ? new c(-2, -1) : new c(-1, -2);
    }

    public void N2(int i) {
        q(null);
        if (i != this.f) {
            w2();
            this.f = i;
            this.f4426a = new BitSet(this.f);
            this.f4428a = new f[this.f];
            for (int i2 = 0; i2 < this.f; i2++) {
                this.f4428a[i2] = new f(i2);
            }
            z1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p O(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void O0(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.O0(recyclerView, vVar);
        u1(this.f4425a);
        for (int i = 0; i < this.f; i++) {
            this.f4428a[i].e();
        }
        recyclerView.requestLayout();
    }

    public final void O2(int i, int i2) {
        for (int i3 = 0; i3 < this.f; i3++) {
            if (!this.f4428a[i3].f4449a.isEmpty()) {
                U2(this.f4428a[i3], i, i2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p P(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new c((ViewGroup.MarginLayoutParams) layoutParams) : new c(layoutParams);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View P0(View view, int i, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        View viewL;
        View viewM;
        if (T() == 0 || (viewL = L(view)) == null) {
            return null;
        }
        I2();
        int iB2 = b2(i);
        if (iB2 == Integer.MIN_VALUE) {
            return null;
        }
        c cVar = (c) viewL.getLayoutParams();
        boolean z = cVar.d;
        f fVar = cVar.f8244a;
        int iO2 = iB2 == 1 ? o2() : n2();
        S2(iO2, a0Var);
        K2(iB2);
        qp qpVar = this.f8241a;
        qpVar.b = qpVar.c + iO2;
        qpVar.f7227a = (int) (this.f4420a.n() * 0.33333334f);
        qp qpVar2 = this.f8241a;
        qpVar2.f2591b = true;
        qpVar2.f2590a = false;
        f2(vVar, qpVar2, a0Var);
        this.f4431i = this.f4430h;
        if (!z && (viewM = fVar.m(iO2, iB2)) != null && viewM != viewL) {
            return viewM;
        }
        if (B2(iB2)) {
            for (int i2 = this.f - 1; i2 >= 0; i2--) {
                View viewM2 = this.f4428a[i2].m(iO2, iB2);
                if (viewM2 != null && viewM2 != viewL) {
                    return viewM2;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.f; i3++) {
                View viewM3 = this.f4428a[i3].m(iO2, iB2);
                if (viewM3 != null && viewM3 != viewL) {
                    return viewM3;
                }
            }
        }
        boolean z2 = (this.f4429g ^ true) == (iB2 == -1);
        if (!z) {
            View viewM4 = M(z2 ? fVar.f() : fVar.g());
            if (viewM4 != null && viewM4 != viewL) {
                return viewM4;
            }
        }
        if (B2(iB2)) {
            for (int i4 = this.f - 1; i4 >= 0; i4--) {
                if (i4 != fVar.d) {
                    f[] fVarArr = this.f4428a;
                    View viewM5 = M(z2 ? fVarArr[i4].f() : fVarArr[i4].g());
                    if (viewM5 != null && viewM5 != viewL) {
                        return viewM5;
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < this.f; i5++) {
                f[] fVarArr2 = this.f4428a;
                View viewM6 = M(z2 ? fVarArr2[i5].f() : fVarArr2[i5].g());
                if (viewM6 != null && viewM6 != viewL) {
                    return viewM6;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean P1() {
        return this.f4424a == null;
    }

    public final boolean P2(RecyclerView.a0 a0Var, b bVar) {
        boolean z = this.f4431i;
        int iB = a0Var.b();
        bVar.f8243a = z ? k2(iB) : g2(iB);
        bVar.b = Integer.MIN_VALUE;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Q0(AccessibilityEvent accessibilityEvent) {
        super.Q0(accessibilityEvent);
        if (T() > 0) {
            View viewI2 = i2(false);
            View viewH2 = h2(false);
            if (viewI2 == null || viewH2 == null) {
                return;
            }
            int iM0 = m0(viewI2);
            int iM02 = m0(viewH2);
            if (iM0 < iM02) {
                accessibilityEvent.setFromIndex(iM0);
                accessibilityEvent.setToIndex(iM02);
            } else {
                accessibilityEvent.setFromIndex(iM02);
                accessibilityEvent.setToIndex(iM0);
            }
        }
    }

    public final void Q1(View view) {
        for (int i = this.f - 1; i >= 0; i--) {
            this.f4428a[i].a(view);
        }
    }

    public boolean Q2(RecyclerView.a0 a0Var, b bVar) {
        int i;
        int iM;
        int iG;
        if (!a0Var.e() && (i = this.i) != -1) {
            if (i >= 0 && i < a0Var.b()) {
                e eVar = this.f4424a;
                if (eVar == null || eVar.f8247a == -1 || eVar.c < 1) {
                    View viewM = M(this.i);
                    if (viewM != null) {
                        bVar.f8243a = this.f4430h ? o2() : n2();
                        if (this.j != Integer.MIN_VALUE) {
                            if (bVar.f4436a) {
                                iM = this.f4420a.i() - this.j;
                                iG = this.f4420a.d(viewM);
                            } else {
                                iM = this.f4420a.m() + this.j;
                                iG = this.f4420a.g(viewM);
                            }
                            bVar.b = iM - iG;
                            return true;
                        }
                        if (this.f4420a.e(viewM) > this.f4420a.n()) {
                            bVar.b = bVar.f4436a ? this.f4420a.i() : this.f4420a.m();
                            return true;
                        }
                        int iG2 = this.f4420a.g(viewM) - this.f4420a.m();
                        if (iG2 < 0) {
                            bVar.b = -iG2;
                            return true;
                        }
                        int i2 = this.f4420a.i() - this.f4420a.d(viewM);
                        if (i2 < 0) {
                            bVar.b = i2;
                            return true;
                        }
                        bVar.b = Integer.MIN_VALUE;
                    } else {
                        int i3 = this.i;
                        bVar.f8243a = i3;
                        int i4 = this.j;
                        if (i4 == Integer.MIN_VALUE) {
                            bVar.f4436a = V1(i3) == 1;
                            bVar.a();
                        } else {
                            bVar.b(i4);
                        }
                        bVar.f4438b = true;
                    }
                } else {
                    bVar.b = Integer.MIN_VALUE;
                    bVar.f8243a = this.i;
                }
                return true;
            }
            this.i = -1;
            this.j = Integer.MIN_VALUE;
        }
        return false;
    }

    public final void R1(b bVar) {
        boolean z;
        e eVar = this.f4424a;
        int i = eVar.c;
        if (i > 0) {
            if (i == this.f) {
                for (int i2 = 0; i2 < this.f; i2++) {
                    this.f4428a[i2].e();
                    e eVar2 = this.f4424a;
                    int i3 = eVar2.f4443a[i2];
                    if (i3 != Integer.MIN_VALUE) {
                        i3 += eVar2.f4446c ? this.f4420a.i() : this.f4420a.m();
                    }
                    this.f4428a[i2].v(i3);
                }
            } else {
                eVar.r();
                e eVar3 = this.f4424a;
                eVar3.f8247a = eVar3.b;
            }
        }
        e eVar4 = this.f4424a;
        this.f4432j = eVar4.f4447d;
        M2(eVar4.f4444b);
        I2();
        e eVar5 = this.f4424a;
        int i4 = eVar5.f8247a;
        if (i4 != -1) {
            this.i = i4;
            z = eVar5.f4446c;
        } else {
            z = this.f4430h;
        }
        bVar.f4436a = z;
        e eVar6 = this.f4424a;
        if (eVar6.d > 1) {
            d dVar = this.f4423a;
            dVar.f4439a = eVar6.f4445b;
            dVar.f8245a = eVar6.f4442a;
        }
    }

    public void R2(RecyclerView.a0 a0Var, b bVar) {
        if (Q2(a0Var, bVar) || P2(a0Var, bVar)) {
            return;
        }
        bVar.a();
        bVar.f8243a = 0;
    }

    public boolean S1() {
        int iL = this.f4428a[0].l(Integer.MIN_VALUE);
        for (int i = 1; i < this.f; i++) {
            if (this.f4428a[i].l(Integer.MIN_VALUE) != iL) {
                return false;
            }
        }
        return true;
    }

    public final void S2(int i, RecyclerView.a0 a0Var) {
        int iN;
        int iN2;
        int iC;
        qp qpVar = this.f8241a;
        boolean z = false;
        qpVar.f7227a = 0;
        qpVar.b = i;
        if (!D0() || (iC = a0Var.c()) == -1) {
            iN = 0;
            iN2 = 0;
        } else {
            if (this.f4430h == (iC < i)) {
                iN = this.f4420a.n();
                iN2 = 0;
            } else {
                iN2 = this.f4420a.n();
                iN = 0;
            }
        }
        if (W()) {
            this.f8241a.e = this.f4420a.m() - iN2;
            this.f8241a.f = this.f4420a.i() + iN;
        } else {
            this.f8241a.f = this.f4420a.h() + iN;
            this.f8241a.e = -iN2;
        }
        qp qpVar2 = this.f8241a;
        qpVar2.f2591b = false;
        qpVar2.f2590a = true;
        if (this.f4420a.k() == 0 && this.f4420a.h() == 0) {
            z = true;
        }
        qpVar2.f2592c = z;
    }

    public boolean T1() {
        int iP = this.f4428a[0].p(Integer.MIN_VALUE);
        for (int i = 1; i < this.f; i++) {
            if (this.f4428a[i].p(Integer.MIN_VALUE) != iP) {
                return false;
            }
        }
        return true;
    }

    public void T2(int i) {
        this.h = i / this.f;
        this.l = View.MeasureSpec.makeMeasureSpec(i, this.b.k());
    }

    public final void U1(View view, c cVar, qp qpVar) {
        if (qpVar.d == 1) {
            if (cVar.d) {
                Q1(view);
                return;
            } else {
                cVar.f8244a.a(view);
                return;
            }
        }
        if (cVar.d) {
            D2(view);
        } else {
            cVar.f8244a.u(view);
        }
    }

    public final void U2(f fVar, int i, int i2) {
        int iJ = fVar.j();
        if (i == -1) {
            if (fVar.o() + iJ > i2) {
                return;
            }
        } else if (fVar.k() - iJ < i2) {
            return;
        }
        this.f4426a.set(fVar.d, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void V0(RecyclerView.v vVar, RecyclerView.a0 a0Var, View view, ni niVar) {
        int iU;
        int i;
        int iU2;
        int i2;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof c)) {
            super.U0(view, niVar);
            return;
        }
        c cVar = (c) layoutParams;
        if (this.g == 0) {
            iU = cVar.u();
            i = cVar.d ? this.f : 1;
            iU2 = -1;
            i2 = -1;
        } else {
            iU = -1;
            i = -1;
            iU2 = cVar.u();
            i2 = cVar.d ? this.f : 1;
        }
        niVar.d0(ni.c.a(iU, i, iU2, i2, false, false));
    }

    public final int V1(int i) {
        if (T() == 0) {
            return this.f4430h ? 1 : -1;
        }
        return (i < n2()) != this.f4430h ? -1 : 1;
    }

    public final int V2(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    public boolean W1() {
        int iN2;
        int iO2;
        if (T() == 0 || this.k == 0 || !w0()) {
            return false;
        }
        if (this.f4430h) {
            iN2 = o2();
            iO2 = n2();
        } else {
            iN2 = n2();
            iO2 = o2();
        }
        if (iN2 == 0 && v2() != null) {
            this.f4423a.b();
        } else {
            if (!this.f4433k) {
                return false;
            }
            int i = this.f4430h ? -1 : 1;
            int i2 = iO2 + 1;
            d.a aVarE = this.f4423a.e(iN2, i2, i, true);
            if (aVarE == null) {
                this.f4433k = false;
                this.f4423a.d(i2);
                return false;
            }
            d.a aVarE2 = this.f4423a.e(iN2, aVarE.f8246a, i * (-1), true);
            if (aVarE2 == null) {
                this.f4423a.d(aVarE.f8246a);
            } else {
                this.f4423a.d(aVarE2.f8246a + 1);
            }
        }
        A1();
        z1();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int X(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.g == 1 ? this.f : super.X(vVar, a0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void X0(RecyclerView recyclerView, int i, int i2) {
        u2(i, i2, 1);
    }

    public final boolean X1(f fVar) {
        if (this.f4430h) {
            if (fVar.k() < this.f4420a.i()) {
                ArrayList<View> arrayList = fVar.f4449a;
                return !fVar.n(arrayList.get(arrayList.size() - 1)).d;
            }
        } else if (fVar.o() > this.f4420a.m()) {
            return !fVar.n(fVar.f4449a.get(0)).d;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Y0(RecyclerView recyclerView) {
        this.f4423a.b();
        z1();
    }

    public final int Y1(RecyclerView.a0 a0Var) {
        if (T() == 0) {
            return 0;
        }
        return eq.a(a0Var, this.f4420a, i2(!this.f4434l), h2(!this.f4434l), this, this.f4434l);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void Z0(RecyclerView recyclerView, int i, int i2, int i3) {
        u2(i, i2, 8);
    }

    public final int Z1(RecyclerView.a0 a0Var) {
        if (T() == 0) {
            return 0;
        }
        return eq.b(a0Var, this.f4420a, i2(!this.f4434l), h2(!this.f4434l), this, this.f4434l, this.f4430h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a1(RecyclerView recyclerView, int i, int i2) {
        u2(i, i2, 2);
    }

    public final int a2(RecyclerView.a0 a0Var) {
        if (T() == 0) {
            return 0;
        }
        return eq.c(a0Var, this.f4420a, i2(!this.f4434l), h2(!this.f4434l), this, this.f4434l);
    }

    public final int b2(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.g == 1) ? 1 : Integer.MIN_VALUE : this.g == 0 ? 1 : Integer.MIN_VALUE : this.g == 1 ? -1 : Integer.MIN_VALUE : this.g == 0 ? -1 : Integer.MIN_VALUE : (this.g != 1 && x2()) ? -1 : 1 : (this.g != 1 && x2()) ? 1 : -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void c1(RecyclerView recyclerView, int i, int i2, Object obj) {
        u2(i, i2, 4);
    }

    public final d.a c2(int i) {
        d.a aVar = new d.a();
        aVar.f4440a = new int[this.f];
        for (int i2 = 0; i2 < this.f; i2++) {
            aVar.f4440a[i2] = i - this.f4428a[i2].l(i);
        }
        return aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void d1(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        A2(vVar, a0Var, true);
    }

    public final d.a d2(int i) {
        d.a aVar = new d.a();
        aVar.f4440a = new int[this.f];
        for (int i2 = 0; i2 < this.f; i2++) {
            aVar.f4440a[i2] = this.f4428a[i2].p(i) - i;
        }
        return aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void e1(RecyclerView.a0 a0Var) {
        super.e1(a0Var);
        this.i = -1;
        this.j = Integer.MIN_VALUE;
        this.f4424a = null;
        this.f4422a.c();
    }

    public final void e2() {
        this.f4420a = wp.b(this, this.g);
        this.b = wp.b(this, 1 - this.g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v38, types: [androidx.recyclerview.widget.RecyclerView$o] */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r16v0, types: [androidx.recyclerview.widget.RecyclerView$o, androidx.recyclerview.widget.StaggeredGridLayoutManager] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    public final int f2(RecyclerView.v vVar, qp qpVar, RecyclerView.a0 a0Var) {
        f fVarT2;
        int iE;
        int i;
        int iE2;
        int iE3;
        ?? r0;
        View view;
        int i2;
        int i3;
        boolean z;
        ?? r9 = 0;
        this.f4426a.set(0, this.f, true);
        int i4 = this.f8241a.f2592c ? qpVar.d == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : qpVar.d == 1 ? qpVar.f + qpVar.f7227a : qpVar.e - qpVar.f7227a;
        O2(qpVar.d, i4);
        int i5 = this.f4430h ? this.f4420a.i() : this.f4420a.m();
        ?? r02 = false;
        while (qpVar.a(a0Var) && (this.f8241a.f2592c || !this.f4426a.isEmpty())) {
            View viewB = qpVar.b(vVar);
            c cVar = (c) viewB.getLayoutParams();
            int iQ = cVar.q();
            int iG = this.f4423a.g(iQ);
            ?? r3 = iG == -1 ? 1 : r9;
            if (r3 != 0) {
                fVarT2 = cVar.d ? this.f4428a[r9] : t2(qpVar);
                this.f4423a.n(iQ, fVarT2);
            } else {
                fVarT2 = this.f4428a[iG];
            }
            f fVar = fVarT2;
            cVar.f8244a = fVar;
            if (qpVar.d == 1) {
                n(viewB);
            } else {
                o(viewB, r9);
            }
            z2(viewB, cVar, r9);
            if (qpVar.d == 1) {
                int iP2 = cVar.d ? p2(i5) : fVar.l(i5);
                int iE4 = this.f4420a.e(viewB) + iP2;
                if (r3 != 0 && cVar.d) {
                    d.a aVarC2 = c2(iP2);
                    aVarC2.b = -1;
                    aVarC2.f8246a = iQ;
                    this.f4423a.a(aVarC2);
                }
                i = iE4;
                iE = iP2;
            } else {
                int iS2 = cVar.d ? s2(i5) : fVar.p(i5);
                iE = iS2 - this.f4420a.e(viewB);
                if (r3 != 0 && cVar.d) {
                    d.a aVarD2 = d2(iS2);
                    aVarD2.b = 1;
                    aVarD2.f8246a = iQ;
                    this.f4423a.a(aVarD2);
                }
                i = iS2;
            }
            if (cVar.d && qpVar.c == -1) {
                if (r3 == 0) {
                    if (!(qpVar.d == 1 ? S1() : T1())) {
                        d.a aVarF = this.f4423a.f(iQ);
                        if (aVarF != null) {
                            aVarF.f4441b = true;
                        }
                        this.f4433k = true;
                    }
                } else {
                    this.f4433k = true;
                }
            }
            U1(viewB, cVar, qpVar);
            if (x2() && this.g == 1) {
                int i6 = cVar.d ? this.b.i() : this.b.i() - (((this.f - 1) - fVar.d) * this.h);
                iE3 = i6;
                iE2 = i6 - this.b.e(viewB);
            } else {
                int iM = cVar.d ? this.b.m() : (fVar.d * this.h) + this.b.m();
                iE2 = iM;
                iE3 = this.b.e(viewB) + iM;
            }
            if (this.g == 1) {
                r0 = this;
                view = viewB;
                i2 = iE2;
                iE2 = iE;
                i3 = iE3;
            } else {
                r0 = this;
                view = viewB;
                i2 = iE;
                i3 = i;
                i = iE3;
            }
            r0.F0(view, i2, iE2, i3, i);
            if (cVar.d) {
                O2(this.f8241a.d, i4);
            } else {
                U2(fVar, this.f8241a.d, i4);
            }
            E2(vVar, this.f8241a);
            if (!this.f8241a.f2591b || !viewB.hasFocusable()) {
                z = false;
            } else if (cVar.d) {
                this.f4426a.clear();
                z = false;
            } else {
                z = false;
                this.f4426a.set(fVar.d, false);
            }
            r9 = z;
            r02 = true;
        }
        ?? r32 = r9;
        if (r02 == false) {
            E2(vVar, this.f8241a);
        }
        int iM2 = this.f8241a.d == -1 ? this.f4420a.m() - s2(this.f4420a.m()) : p2(this.f4420a.i()) - this.f4420a.i();
        return iM2 > 0 ? Math.min(qpVar.f7227a, iM2) : r32 == true ? 1 : 0;
    }

    public final int g2(int i) {
        int iT = T();
        for (int i2 = 0; i2 < iT; i2++) {
            int iM0 = m0(S(i2));
            if (iM0 >= 0 && iM0 < i) {
                return iM0;
            }
        }
        return 0;
    }

    public View h2(boolean z) {
        int iM = this.f4420a.m();
        int i = this.f4420a.i();
        View view = null;
        for (int iT = T() - 1; iT >= 0; iT--) {
            View viewS = S(iT);
            int iG = this.f4420a.g(viewS);
            int iD = this.f4420a.d(viewS);
            if (iD > iM && iG < i) {
                if (iD <= i || !z) {
                    return viewS;
                }
                if (view == null) {
                    view = viewS;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void i1(Parcelable parcelable) {
        if (parcelable instanceof e) {
            this.f4424a = (e) parcelable;
            z1();
        }
    }

    public View i2(boolean z) {
        int iM = this.f4420a.m();
        int i = this.f4420a.i();
        int iT = T();
        View view = null;
        for (int i2 = 0; i2 < iT; i2++) {
            View viewS = S(i2);
            int iG = this.f4420a.g(viewS);
            if (this.f4420a.d(viewS) > iM && iG < i) {
                if (iG >= iM || !z) {
                    return viewS;
                }
                if (view == null) {
                    view = viewS;
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable j1() {
        int iP;
        int iM;
        int[] iArr;
        if (this.f4424a != null) {
            return new e(this.f4424a);
        }
        e eVar = new e();
        eVar.f4444b = this.f4429g;
        eVar.f4446c = this.f4431i;
        eVar.f4447d = this.f4432j;
        d dVar = this.f4423a;
        if (dVar == null || (iArr = dVar.f4439a) == null) {
            eVar.d = 0;
        } else {
            eVar.f4445b = iArr;
            eVar.d = iArr.length;
            eVar.f4442a = dVar.f8245a;
        }
        if (T() > 0) {
            eVar.f8247a = this.f4431i ? o2() : n2();
            eVar.b = j2();
            int i = this.f;
            eVar.c = i;
            eVar.f4443a = new int[i];
            for (int i2 = 0; i2 < this.f; i2++) {
                if (this.f4431i) {
                    iP = this.f4428a[i2].l(Integer.MIN_VALUE);
                    if (iP != Integer.MIN_VALUE) {
                        iM = this.f4420a.i();
                        iP -= iM;
                    }
                } else {
                    iP = this.f4428a[i2].p(Integer.MIN_VALUE);
                    if (iP != Integer.MIN_VALUE) {
                        iM = this.f4420a.m();
                        iP -= iM;
                    }
                }
                eVar.f4443a[i2] = iP;
            }
        } else {
            eVar.f8247a = -1;
            eVar.b = -1;
            eVar.c = 0;
        }
        return eVar;
    }

    public int j2() {
        View viewH2 = this.f4430h ? h2(true) : i2(true);
        if (viewH2 == null) {
            return -1;
        }
        return m0(viewH2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void k1(int i) {
        if (i == 0) {
            W1();
        }
    }

    public final int k2(int i) {
        for (int iT = T() - 1; iT >= 0; iT--) {
            int iM0 = m0(S(iT));
            if (iM0 >= 0 && iM0 < i) {
                return iM0;
            }
        }
        return 0;
    }

    public final void l2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int i;
        int iP2 = p2(Integer.MIN_VALUE);
        if (iP2 != Integer.MIN_VALUE && (i = this.f4420a.i() - iP2) > 0) {
            int i2 = i - (-J2(-i, vVar, a0Var));
            if (!z || i2 <= 0) {
                return;
            }
            this.f4420a.r(i2);
        }
    }

    public final void m2(RecyclerView.v vVar, RecyclerView.a0 a0Var, boolean z) {
        int iM;
        int iS2 = s2(Integer.MAX_VALUE);
        if (iS2 != Integer.MAX_VALUE && (iM = iS2 - this.f4420a.m()) > 0) {
            int iJ2 = iM - J2(iM, vVar, a0Var);
            if (!z || iJ2 <= 0) {
                return;
            }
            this.f4420a.r(-iJ2);
        }
    }

    public int n2() {
        if (T() == 0) {
            return 0;
        }
        return m0(S(0));
    }

    public int o2() {
        int iT = T();
        if (iT == 0) {
            return 0;
        }
        return m0(S(iT - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int p0(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        return this.g == 0 ? this.f : super.p0(vVar, a0Var);
    }

    public final int p2(int i) {
        int iL = this.f4428a[0].l(i);
        for (int i2 = 1; i2 < this.f; i2++) {
            int iL2 = this.f4428a[i2].l(i);
            if (iL2 > iL) {
                iL = iL2;
            }
        }
        return iL;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void q(String str) {
        if (this.f4424a == null) {
            super.q(str);
        }
    }

    public final int q2(int i) {
        int iP = this.f4428a[0].p(i);
        for (int i2 = 1; i2 < this.f; i2++) {
            int iP2 = this.f4428a[i2].p(i);
            if (iP2 > iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    public final int r2(int i) {
        int iL = this.f4428a[0].l(i);
        for (int i2 = 1; i2 < this.f; i2++) {
            int iL2 = this.f4428a[i2].l(i);
            if (iL2 < iL) {
                iL = iL2;
            }
        }
        return iL;
    }

    public final int s2(int i) {
        int iP = this.f4428a[0].p(i);
        for (int i2 = 1; i2 < this.f; i2++) {
            int iP2 = this.f4428a[i2].p(i);
            if (iP2 < iP) {
                iP = iP2;
            }
        }
        return iP;
    }

    public final f t2(qp qpVar) {
        int i;
        int i2;
        int i3 = -1;
        if (B2(qpVar.d)) {
            i = this.f - 1;
            i2 = -1;
        } else {
            i = 0;
            i3 = this.f;
            i2 = 1;
        }
        f fVar = null;
        if (qpVar.d == 1) {
            int i4 = Integer.MAX_VALUE;
            int iM = this.f4420a.m();
            while (i != i3) {
                f fVar2 = this.f4428a[i];
                int iL = fVar2.l(iM);
                if (iL < i4) {
                    fVar = fVar2;
                    i4 = iL;
                }
                i += i2;
            }
            return fVar;
        }
        int i5 = Integer.MIN_VALUE;
        int i6 = this.f4420a.i();
        while (i != i3) {
            f fVar3 = this.f4428a[i];
            int iP = fVar3.p(i6);
            if (iP > i5) {
                fVar = fVar3;
                i5 = iP;
            }
            i += i2;
        }
        return fVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean u() {
        return this.g == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void u2(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f4430h
            if (r0 == 0) goto L9
            int r0 = r6.o2()
            goto Ld
        L9:
            int r0 = r6.n2()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1a
            if (r7 >= r8) goto L16
            int r2 = r8 + 1
            goto L1c
        L16:
            int r2 = r7 + 1
            r3 = r8
            goto L1d
        L1a:
            int r2 = r7 + r8
        L1c:
            r3 = r7
        L1d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r4 = r6.f4423a
            r4.h(r3)
            r4 = 1
            if (r9 == r4) goto L3c
            r5 = 2
            if (r9 == r5) goto L36
            if (r9 == r1) goto L2b
            goto L41
        L2b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.f4423a
            r9.k(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r7 = r6.f4423a
            r7.j(r8, r4)
            goto L41
        L36:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.f4423a
            r9.k(r7, r8)
            goto L41
        L3c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$d r9 = r6.f4423a
            r9.j(r7, r8)
        L41:
            if (r2 > r0) goto L44
            return
        L44:
            boolean r7 = r6.f4430h
            if (r7 == 0) goto L4d
            int r7 = r6.n2()
            goto L51
        L4d:
            int r7 = r6.o2()
        L51:
            if (r3 > r7) goto L56
            r6.z1()
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.u2(int, int, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean v() {
        return this.g == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View v2() {
        /*
            r12 = this;
            int r0 = r12.T()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f
            r2.<init>(r3)
            int r3 = r12.f
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.g
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.x2()
            if (r3 == 0) goto L20
            r3 = r1
            goto L21
        L20:
            r3 = r5
        L21:
            boolean r6 = r12.f4430h
            if (r6 == 0) goto L27
            r6 = r5
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = r4
        L2b:
            if (r0 >= r6) goto L2e
            r5 = r1
        L2e:
            if (r0 == r6) goto Lab
            android.view.View r7 = r12.S(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f8244a
            int r9 = r9.d
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f8244a
            boolean r9 = r12.X1(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r8.f8244a
            int r9 = r9.d
            r2.clear(r9)
        L54:
            boolean r9 = r8.d
            if (r9 == 0) goto L59
            goto La9
        L59:
            int r9 = r0 + r5
            if (r9 == r6) goto La9
            android.view.View r9 = r12.S(r9)
            boolean r10 = r12.f4430h
            if (r10 == 0) goto L77
            a.wp r10 = r12.f4420a
            int r10 = r10.d(r7)
            a.wp r11 = r12.f4420a
            int r11 = r11.d(r9)
            if (r10 >= r11) goto L74
            return r7
        L74:
            if (r10 != r11) goto L8a
            goto L88
        L77:
            a.wp r10 = r12.f4420a
            int r10 = r10.g(r7)
            a.wp r11 = r12.f4420a
            int r11 = r11.g(r9)
            if (r10 <= r11) goto L86
            return r7
        L86:
            if (r10 != r11) goto L8a
        L88:
            r10 = r1
            goto L8b
        L8a:
            r10 = r4
        L8b:
            if (r10 == 0) goto La9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$c r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.c) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r8 = r8.f8244a
            int r8 = r8.d
            androidx.recyclerview.widget.StaggeredGridLayoutManager$f r9 = r9.f8244a
            int r9 = r9.d
            int r8 = r8 - r9
            if (r8 >= 0) goto La0
            r8 = r1
            goto La1
        La0:
            r8 = r4
        La1:
            if (r3 >= 0) goto La5
            r9 = r1
            goto La6
        La5:
            r9 = r4
        La6:
            if (r8 == r9) goto La9
            return r7
        La9:
            int r0 = r0 + r5
            goto L2e
        Lab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.v2():android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean w(RecyclerView.p pVar) {
        return pVar instanceof c;
    }

    public void w2() {
        this.f4423a.b();
        z1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean x0() {
        return this.k != 0;
    }

    public boolean x2() {
        return i0() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void y(int i, int i2, RecyclerView.a0 a0Var, RecyclerView.o.a aVar) {
        int iL;
        int iP;
        if (this.g != 0) {
            i = i2;
        }
        if (T() == 0 || i == 0) {
            return;
        }
        C2(i, a0Var);
        int[] iArr = this.f4427a;
        if (iArr == null || iArr.length < this.f) {
            this.f4427a = new int[this.f];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f; i4++) {
            qp qpVar = this.f8241a;
            if (qpVar.c == -1) {
                iL = qpVar.e;
                iP = this.f4428a[i4].p(iL);
            } else {
                iL = this.f4428a[i4].l(qpVar.f);
                iP = this.f8241a.f;
            }
            int i5 = iL - iP;
            if (i5 >= 0) {
                this.f4427a[i3] = i5;
                i3++;
            }
        }
        Arrays.sort(this.f4427a, 0, i3);
        for (int i6 = 0; i6 < i3 && this.f8241a.a(a0Var); i6++) {
            aVar.a(this.f8241a.b, this.f4427a[i6]);
            qp qpVar2 = this.f8241a;
            qpVar2.b += qpVar2.c;
        }
    }

    public final void y2(View view, int i, int i2, boolean z) {
        t(view, this.f4421a);
        c cVar = (c) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
        Rect rect = this.f4421a;
        int iV2 = V2(i, i3 + rect.left, ((ViewGroup.MarginLayoutParams) cVar).rightMargin + rect.right);
        int i4 = ((ViewGroup.MarginLayoutParams) cVar).topMargin;
        Rect rect2 = this.f4421a;
        int iV22 = V2(i2, i4 + rect2.top, ((ViewGroup.MarginLayoutParams) cVar).bottomMargin + rect2.bottom);
        if (z ? N1(view, iV2, iV22, cVar) : L1(view, iV2, iV22, cVar)) {
            view.measure(iV2, iV22);
        }
    }

    public final void z2(View view, c cVar, boolean z) {
        int iU;
        int iU2;
        if (cVar.d) {
            if (this.g != 1) {
                y2(view, RecyclerView.o.U(t0(), u0(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) cVar).width, true), this.l, z);
                return;
            }
            iU = this.l;
        } else {
            if (this.g != 1) {
                iU = RecyclerView.o.U(t0(), u0(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) cVar).width, true);
                iU2 = RecyclerView.o.U(this.h, h0(), 0, ((ViewGroup.MarginLayoutParams) cVar).height, false);
                y2(view, iU, iU2, z);
            }
            iU = RecyclerView.o.U(this.h, u0(), 0, ((ViewGroup.MarginLayoutParams) cVar).width, false);
        }
        iU2 = RecyclerView.o.U(g0(), h0(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) cVar).height, true);
        y2(view, iU, iU2, z);
    }
}
