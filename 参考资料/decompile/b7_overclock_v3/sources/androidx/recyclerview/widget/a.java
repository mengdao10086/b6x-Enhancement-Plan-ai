package androidx.recyclerview.widget;

import androidx.core.util.n;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.v;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements v.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f6804i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f6805j = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final boolean f6806k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f6807l = "AHT";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n.a<b> f6808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f6809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<b> f6810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC0062a f6811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Runnable f6812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f6813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final v f6814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6815h;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC0062a {
        void a(int i10, int i11);

        void b(b bVar);

        void c(int i10, int i11, Object obj);

        void d(b bVar);

        RecyclerView.e0 e(int i10);

        void f(int i10, int i11);

        void g(int i10, int i11);

        void h(int i10, int i11);
    }

    public static class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f6816e = 1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f6817f = 2;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f6818g = 4;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f6819h = 8;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f6820i = 30;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6822b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f6823c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f6824d;

        public b(int i10, int i11, int i12, Object obj) {
            this.f6821a = i10;
            this.f6822b = i11;
            this.f6824d = i12;
            this.f6823c = obj;
        }

        public String a() {
            int i10 = this.f6821a;
            return i10 != 1 ? i10 != 2 ? i10 != 4 ? i10 != 8 ? "??" : "mv" : CommonNetImpl.UP : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i10 = this.f6821a;
            if (i10 != bVar.f6821a) {
                return false;
            }
            if (i10 == 8 && Math.abs(this.f6824d - this.f6822b) == 1 && this.f6824d == bVar.f6822b && this.f6822b == bVar.f6824d) {
                return true;
            }
            if (this.f6824d != bVar.f6824d || this.f6822b != bVar.f6822b) {
                return false;
            }
            Object obj2 = this.f6823c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f6823c)) {
                    return false;
                }
            } else if (bVar.f6823c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f6821a * 31) + this.f6822b) * 31) + this.f6824d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f6822b + "c:" + this.f6824d + ",p:" + this.f6823c + "]";
        }
    }

    public a(InterfaceC0062a interfaceC0062a) {
        this(interfaceC0062a, false);
    }

    public final int A(int i10, int i11) {
        int i12;
        int i13;
        for (int size = this.f6810c.size() - 1; size >= 0; size--) {
            b bVar = this.f6810c.get(size);
            int i14 = bVar.f6821a;
            if (i14 == 8) {
                int i15 = bVar.f6822b;
                int i16 = bVar.f6824d;
                if (i15 < i16) {
                    i13 = i15;
                    i12 = i16;
                } else {
                    i12 = i15;
                    i13 = i16;
                }
                if (i10 < i13 || i10 > i12) {
                    if (i10 < i15) {
                        if (i11 == 1) {
                            bVar.f6822b = i15 + 1;
                            bVar.f6824d = i16 + 1;
                        } else if (i11 == 2) {
                            bVar.f6822b = i15 - 1;
                            bVar.f6824d = i16 - 1;
                        }
                    }
                } else if (i13 == i15) {
                    if (i11 == 1) {
                        bVar.f6824d = i16 + 1;
                    } else if (i11 == 2) {
                        bVar.f6824d = i16 - 1;
                    }
                    i10++;
                } else {
                    if (i11 == 1) {
                        bVar.f6822b = i15 + 1;
                    } else if (i11 == 2) {
                        bVar.f6822b = i15 - 1;
                    }
                    i10--;
                }
            } else {
                int i17 = bVar.f6822b;
                if (i17 <= i10) {
                    if (i14 == 1) {
                        i10 -= bVar.f6824d;
                    } else if (i14 == 2) {
                        i10 += bVar.f6824d;
                    }
                } else if (i11 == 1) {
                    bVar.f6822b = i17 + 1;
                } else if (i11 == 2) {
                    bVar.f6822b = i17 - 1;
                }
            }
        }
        for (int size2 = this.f6810c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f6810c.get(size2);
            if (bVar2.f6821a == 8) {
                int i18 = bVar2.f6824d;
                if (i18 == bVar2.f6822b || i18 < 0) {
                    this.f6810c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f6824d <= 0) {
                this.f6810c.remove(size2);
                a(bVar2);
            }
        }
        return i10;
    }

    @Override // androidx.recyclerview.widget.v.a
    public void a(b bVar) {
        if (this.f6813f) {
            return;
        }
        bVar.f6823c = null;
        this.f6808a.b(bVar);
    }

    @Override // androidx.recyclerview.widget.v.a
    public b b(int i10, int i11, int i12, Object obj) {
        b bVarA = this.f6808a.a();
        if (bVarA == null) {
            return new b(i10, i11, i12, obj);
        }
        bVarA.f6821a = i10;
        bVarA.f6822b = i11;
        bVarA.f6824d = i12;
        bVarA.f6823c = obj;
        return bVarA;
    }

    public a c(b... bVarArr) {
        Collections.addAll(this.f6809b, bVarArr);
        return this;
    }

    public final void d(b bVar) {
        w(bVar);
    }

    public final void e(b bVar) {
        w(bVar);
    }

    public int f(int i10) {
        int size = this.f6809b.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f6809b.get(i11);
            int i12 = bVar.f6821a;
            if (i12 != 1) {
                if (i12 == 2) {
                    int i13 = bVar.f6822b;
                    if (i13 <= i10) {
                        int i14 = bVar.f6824d;
                        if (i13 + i14 > i10) {
                            return -1;
                        }
                        i10 -= i14;
                    } else {
                        continue;
                    }
                } else if (i12 == 8) {
                    int i15 = bVar.f6822b;
                    if (i15 == i10) {
                        i10 = bVar.f6824d;
                    } else {
                        if (i15 < i10) {
                            i10--;
                        }
                        if (bVar.f6824d <= i10) {
                            i10++;
                        }
                    }
                }
            } else if (bVar.f6822b <= i10) {
                i10 += bVar.f6824d;
            }
        }
        return i10;
    }

    public final void g(b bVar) {
        boolean z10;
        byte b10;
        int i10 = bVar.f6822b;
        int i11 = bVar.f6824d + i10;
        byte b11 = -1;
        int i12 = i10;
        int i13 = 0;
        while (i12 < i11) {
            if (this.f6811d.e(i12) != null || i(i12)) {
                if (b11 == 0) {
                    l(b(2, i10, i13, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                b10 = 1;
            } else {
                if (b11 == 1) {
                    w(b(2, i10, i13, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                b10 = 0;
            }
            if (z10) {
                i12 -= i13;
                i11 -= i13;
                i13 = 1;
            } else {
                i13++;
            }
            i12++;
            b11 = b10;
        }
        if (i13 != bVar.f6824d) {
            a(bVar);
            bVar = b(2, i10, i13, null);
        }
        if (b11 == 0) {
            l(bVar);
        } else {
            w(bVar);
        }
    }

    public final void h(b bVar) {
        int i10 = bVar.f6822b;
        int i11 = bVar.f6824d + i10;
        int i12 = i10;
        byte b10 = -1;
        int i13 = 0;
        while (i10 < i11) {
            if (this.f6811d.e(i10) != null || i(i10)) {
                if (b10 == 0) {
                    l(b(4, i12, i13, bVar.f6823c));
                    i12 = i10;
                    i13 = 0;
                }
                b10 = 1;
            } else {
                if (b10 == 1) {
                    w(b(4, i12, i13, bVar.f6823c));
                    i12 = i10;
                    i13 = 0;
                }
                b10 = 0;
            }
            i13++;
            i10++;
        }
        if (i13 != bVar.f6824d) {
            Object obj = bVar.f6823c;
            a(bVar);
            bVar = b(4, i12, i13, obj);
        }
        if (b10 == 0) {
            l(bVar);
        } else {
            w(bVar);
        }
    }

    public final boolean i(int i10) {
        int size = this.f6810c.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = this.f6810c.get(i11);
            int i12 = bVar.f6821a;
            if (i12 == 8) {
                if (o(bVar.f6824d, i11 + 1) == i10) {
                    return true;
                }
            } else if (i12 == 1) {
                int i13 = bVar.f6822b;
                int i14 = bVar.f6824d + i13;
                while (i13 < i14) {
                    if (o(i13, i11 + 1) == i10) {
                        return true;
                    }
                    i13++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public void j() {
        int size = this.f6810c.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f6811d.d(this.f6810c.get(i10));
        }
        y(this.f6810c);
        this.f6815h = 0;
    }

    public void k() {
        j();
        int size = this.f6809b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = this.f6809b.get(i10);
            int i11 = bVar.f6821a;
            if (i11 == 1) {
                this.f6811d.d(bVar);
                this.f6811d.g(bVar.f6822b, bVar.f6824d);
            } else if (i11 == 2) {
                this.f6811d.d(bVar);
                this.f6811d.h(bVar.f6822b, bVar.f6824d);
            } else if (i11 == 4) {
                this.f6811d.d(bVar);
                this.f6811d.c(bVar.f6822b, bVar.f6824d, bVar.f6823c);
            } else if (i11 == 8) {
                this.f6811d.d(bVar);
                this.f6811d.a(bVar.f6822b, bVar.f6824d);
            }
            Runnable runnable = this.f6812e;
            if (runnable != null) {
                runnable.run();
            }
        }
        y(this.f6809b);
        this.f6815h = 0;
    }

    public final void l(b bVar) {
        int i10;
        int i11 = bVar.f6821a;
        if (i11 == 1 || i11 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iA = A(bVar.f6822b, i11);
        int i12 = bVar.f6822b;
        int i13 = bVar.f6821a;
        if (i13 == 2) {
            i10 = 0;
        } else {
            if (i13 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i10 = 1;
        }
        int i14 = 1;
        for (int i15 = 1; i15 < bVar.f6824d; i15++) {
            int iA2 = A(bVar.f6822b + (i10 * i15), bVar.f6821a);
            int i16 = bVar.f6821a;
            if (i16 == 2 ? iA2 == iA : i16 == 4 && iA2 == iA + 1) {
                i14++;
            } else {
                b bVarB = b(i16, iA, i14, bVar.f6823c);
                m(bVarB, i12);
                a(bVarB);
                if (bVar.f6821a == 4) {
                    i12 += i14;
                }
                iA = iA2;
                i14 = 1;
            }
        }
        Object obj = bVar.f6823c;
        a(bVar);
        if (i14 > 0) {
            b bVarB2 = b(bVar.f6821a, iA, i14, obj);
            m(bVarB2, i12);
            a(bVarB2);
        }
    }

    public void m(b bVar, int i10) {
        this.f6811d.b(bVar);
        int i11 = bVar.f6821a;
        if (i11 == 2) {
            this.f6811d.h(i10, bVar.f6824d);
        } else {
            if (i11 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f6811d.c(i10, bVar.f6824d, bVar.f6823c);
        }
    }

    public int n(int i10) {
        return o(i10, 0);
    }

    public int o(int i10, int i11) {
        int size = this.f6810c.size();
        while (i11 < size) {
            b bVar = this.f6810c.get(i11);
            int i12 = bVar.f6821a;
            if (i12 == 8) {
                int i13 = bVar.f6822b;
                if (i13 == i10) {
                    i10 = bVar.f6824d;
                } else {
                    if (i13 < i10) {
                        i10--;
                    }
                    if (bVar.f6824d <= i10) {
                        i10++;
                    }
                }
            } else {
                int i14 = bVar.f6822b;
                if (i14 > i10) {
                    continue;
                } else if (i12 == 2) {
                    int i15 = bVar.f6824d;
                    if (i10 < i14 + i15) {
                        return -1;
                    }
                    i10 -= i15;
                } else if (i12 == 1) {
                    i10 += bVar.f6824d;
                }
            }
            i11++;
        }
        return i10;
    }

    public boolean p(int i10) {
        return (i10 & this.f6815h) != 0;
    }

    public boolean q() {
        return this.f6809b.size() > 0;
    }

    public boolean r() {
        return (this.f6810c.isEmpty() || this.f6809b.isEmpty()) ? false : true;
    }

    public boolean s(int i10, int i11, Object obj) {
        if (i11 < 1) {
            return false;
        }
        this.f6809b.add(b(4, i10, i11, obj));
        this.f6815h |= 4;
        return this.f6809b.size() == 1;
    }

    public boolean t(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f6809b.add(b(1, i10, i11, null));
        this.f6815h |= 1;
        return this.f6809b.size() == 1;
    }

    public boolean u(int i10, int i11, int i12) {
        if (i10 == i11) {
            return false;
        }
        if (i12 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f6809b.add(b(8, i10, i11, null));
        this.f6815h |= 8;
        return this.f6809b.size() == 1;
    }

    public boolean v(int i10, int i11) {
        if (i11 < 1) {
            return false;
        }
        this.f6809b.add(b(2, i10, i11, null));
        this.f6815h |= 2;
        return this.f6809b.size() == 1;
    }

    public final void w(b bVar) {
        this.f6810c.add(bVar);
        int i10 = bVar.f6821a;
        if (i10 == 1) {
            this.f6811d.g(bVar.f6822b, bVar.f6824d);
            return;
        }
        if (i10 == 2) {
            this.f6811d.f(bVar.f6822b, bVar.f6824d);
            return;
        }
        if (i10 == 4) {
            this.f6811d.c(bVar.f6822b, bVar.f6824d, bVar.f6823c);
        } else {
            if (i10 == 8) {
                this.f6811d.a(bVar.f6822b, bVar.f6824d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    public void x() {
        this.f6814g.b(this.f6809b);
        int size = this.f6809b.size();
        for (int i10 = 0; i10 < size; i10++) {
            b bVar = this.f6809b.get(i10);
            int i11 = bVar.f6821a;
            if (i11 == 1) {
                d(bVar);
            } else if (i11 == 2) {
                g(bVar);
            } else if (i11 == 4) {
                h(bVar);
            } else if (i11 == 8) {
                e(bVar);
            }
            Runnable runnable = this.f6812e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f6809b.clear();
    }

    public void y(List<b> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            a(list.get(i10));
        }
        list.clear();
    }

    public void z() {
        y(this.f6809b);
        y(this.f6810c);
        this.f6815h = 0;
    }

    public a(InterfaceC0062a interfaceC0062a, boolean z10) {
        this.f6808a = new n.b(30);
        this.f6809b = new ArrayList<>();
        this.f6810c = new ArrayList<>();
        this.f6815h = 0;
        this.f6811d = interfaceC0062a;
        this.f6813f = z10;
        this.f6814g = new v(this);
    }
}
