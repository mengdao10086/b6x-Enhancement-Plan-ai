package a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class go implements sp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6225a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f1041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public mf<b> f1042a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final tp f1043a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Runnable f1044a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<b> f1045a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f1046a;
    public final ArrayList<b> b;

    public interface a {
        RecyclerView.d0 a(int i);

        void b(b bVar);

        void c(int i, int i2);

        void d(int i, int i2, Object obj);

        void e(int i, int i2);

        void f(b bVar);

        void g(int i, int i2);

        void h(int i, int i2);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6226a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f1047a;
        public int b;
        public int c;

        public b(int i, int i2, int i3, Object obj) {
            this.f6226a = i;
            this.b = i2;
            this.c = i3;
            this.f1047a = obj;
        }

        public String a() {
            int i = this.f6226a;
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i = this.f6226a;
            if (i != bVar.f6226a) {
                return false;
            }
            if (i == 8 && Math.abs(this.c - this.b) == 1 && this.c == bVar.b && this.b == bVar.c) {
                return true;
            }
            if (this.c != bVar.c || this.b != bVar.b) {
                return false;
            }
            Object obj2 = this.f1047a;
            Object obj3 = bVar.f1047a;
            if (obj2 != null) {
                if (!obj2.equals(obj3)) {
                    return false;
                }
            } else if (obj3 != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f6226a * 31) + this.b) * 31) + this.c;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.b + "c:" + this.c + ",p:" + this.f1047a + "]";
        }
    }

    public go(a aVar) {
        this(aVar, false);
    }

    public go(a aVar, boolean z) {
        this.f1042a = new nf(30);
        this.f1045a = new ArrayList<>();
        this.b = new ArrayList<>();
        this.f6225a = 0;
        this.f1041a = aVar;
        this.f1046a = z;
        this.f1043a = new tp(this);
    }

    @Override // a.sp
    public b a(int i, int i2, int i3, Object obj) {
        b bVarA = this.f1042a.a();
        if (bVarA == null) {
            return new b(i, i2, i3, obj);
        }
        bVarA.f6226a = i;
        bVarA.b = i2;
        bVarA.c = i3;
        bVarA.f1047a = obj;
        return bVarA;
    }

    @Override // a.sp
    public void b(b bVar) {
        if (this.f1046a) {
            return;
        }
        bVar.f1047a = null;
        this.f1042a.b(bVar);
    }

    public final void c(b bVar) {
        u(bVar);
    }

    public final void d(b bVar) {
        u(bVar);
    }

    public int e(int i) {
        int size = this.f1045a.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f1045a.get(i2);
            int i3 = bVar.f6226a;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = bVar.b;
                    if (i4 <= i) {
                        int i5 = bVar.c;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = bVar.b;
                    if (i6 == i) {
                        i = bVar.c;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (bVar.c <= i) {
                            i++;
                        }
                    }
                }
            } else if (bVar.b <= i) {
                i += bVar.c;
            }
        }
        return i;
    }

    public final void f(b bVar) {
        boolean z;
        byte b2;
        int i = bVar.b;
        int i2 = bVar.c + i;
        byte b3 = -1;
        int i3 = i;
        int i4 = 0;
        while (i3 < i2) {
            if (this.f1041a.a(i3) != null || h(i3)) {
                if (b3 == 0) {
                    k(a(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                b2 = 1;
            } else {
                if (b3 == 1) {
                    u(a(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                b2 = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            b3 = b2;
        }
        if (i4 != bVar.c) {
            b(bVar);
            bVar = a(2, i, i4, null);
        }
        if (b3 == 0) {
            k(bVar);
        } else {
            u(bVar);
        }
    }

    public final void g(b bVar) {
        int i = bVar.b;
        int i2 = bVar.c + i;
        int i3 = 0;
        byte b2 = -1;
        int i4 = i;
        while (i < i2) {
            if (this.f1041a.a(i) != null || h(i)) {
                if (b2 == 0) {
                    k(a(4, i4, i3, bVar.f1047a));
                    i4 = i;
                    i3 = 0;
                }
                b2 = 1;
            } else {
                if (b2 == 1) {
                    u(a(4, i4, i3, bVar.f1047a));
                    i4 = i;
                    i3 = 0;
                }
                b2 = 0;
            }
            i3++;
            i++;
        }
        if (i3 != bVar.c) {
            Object obj = bVar.f1047a;
            b(bVar);
            bVar = a(4, i4, i3, obj);
        }
        if (b2 == 0) {
            k(bVar);
        } else {
            u(bVar);
        }
    }

    public final boolean h(int i) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.b.get(i2);
            int i3 = bVar.f6226a;
            if (i3 == 8) {
                if (n(bVar.c, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = bVar.b;
                int i5 = bVar.c + i4;
                while (i4 < i5) {
                    if (n(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public void i() {
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            this.f1041a.f(this.b.get(i));
        }
        w(this.b);
        this.f6225a = 0;
    }

    public void j() {
        i();
        int size = this.f1045a.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f1045a.get(i);
            int i2 = bVar.f6226a;
            if (i2 == 1) {
                this.f1041a.f(bVar);
                this.f1041a.c(bVar.b, bVar.c);
            } else if (i2 == 2) {
                this.f1041a.f(bVar);
                this.f1041a.g(bVar.b, bVar.c);
            } else if (i2 == 4) {
                this.f1041a.f(bVar);
                this.f1041a.d(bVar.b, bVar.c, bVar.f1047a);
            } else if (i2 == 8) {
                this.f1041a.f(bVar);
                this.f1041a.e(bVar.b, bVar.c);
            }
            Runnable runnable = this.f1044a;
            if (runnable != null) {
                runnable.run();
            }
        }
        w(this.f1045a);
        this.f6225a = 0;
    }

    public final void k(b bVar) {
        int i;
        int i2 = bVar.f6226a;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iY = y(bVar.b, i2);
        int i3 = bVar.b;
        int i4 = bVar.f6226a;
        if (i4 == 2) {
            i = 0;
        } else {
            if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i = 1;
        }
        int i5 = 1;
        for (int i6 = 1; i6 < bVar.c; i6++) {
            int iY2 = y(bVar.b + (i * i6), bVar.f6226a);
            int i7 = bVar.f6226a;
            if (i7 == 2 ? iY2 == iY : i7 == 4 && iY2 == iY + 1) {
                i5++;
            } else {
                b bVarA = a(bVar.f6226a, iY, i5, bVar.f1047a);
                l(bVarA, i3);
                b(bVarA);
                if (bVar.f6226a == 4) {
                    i3 += i5;
                }
                i5 = 1;
                iY = iY2;
            }
        }
        Object obj = bVar.f1047a;
        b(bVar);
        if (i5 > 0) {
            b bVarA2 = a(bVar.f6226a, iY, i5, obj);
            l(bVarA2, i3);
            b(bVarA2);
        }
    }

    public void l(b bVar, int i) {
        this.f1041a.b(bVar);
        int i2 = bVar.f6226a;
        if (i2 == 2) {
            this.f1041a.g(i, bVar.c);
        } else {
            if (i2 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f1041a.d(i, bVar.c, bVar.f1047a);
        }
    }

    public int m(int i) {
        return n(i, 0);
    }

    public int n(int i, int i2) {
        int size = this.b.size();
        while (i2 < size) {
            b bVar = this.b.get(i2);
            int i3 = bVar.f6226a;
            if (i3 == 8) {
                int i4 = bVar.b;
                if (i4 == i) {
                    i = bVar.c;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (bVar.c <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = bVar.b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = bVar.c;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += bVar.c;
                }
            }
            i2++;
        }
        return i;
    }

    public boolean o(int i) {
        return (i & this.f6225a) != 0;
    }

    public boolean p() {
        return this.f1045a.size() > 0;
    }

    public boolean q() {
        return (this.b.isEmpty() || this.f1045a.isEmpty()) ? false : true;
    }

    public boolean r(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.f1045a.add(a(4, i, i2, obj));
        this.f6225a |= 4;
        return this.f1045a.size() == 1;
    }

    public boolean s(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f1045a.add(a(8, i, i2, null));
        this.f6225a |= 8;
        return this.f1045a.size() == 1;
    }

    public boolean t(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f1045a.add(a(2, i, i2, null));
        this.f6225a |= 2;
        return this.f1045a.size() == 1;
    }

    public final void u(b bVar) {
        this.b.add(bVar);
        int i = bVar.f6226a;
        if (i == 1) {
            this.f1041a.c(bVar.b, bVar.c);
            return;
        }
        if (i == 2) {
            this.f1041a.h(bVar.b, bVar.c);
            return;
        }
        if (i == 4) {
            this.f1041a.d(bVar.b, bVar.c, bVar.f1047a);
        } else {
            if (i == 8) {
                this.f1041a.e(bVar.b, bVar.c);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    public void v() {
        this.f1043a.b(this.f1045a);
        int size = this.f1045a.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f1045a.get(i);
            int i2 = bVar.f6226a;
            if (i2 == 1) {
                c(bVar);
            } else if (i2 == 2) {
                f(bVar);
            } else if (i2 == 4) {
                g(bVar);
            } else if (i2 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f1044a;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f1045a.clear();
    }

    public void w(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            b(list.get(i));
        }
        list.clear();
    }

    public void x() {
        w(this.f1045a);
        w(this.b);
        this.f6225a = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int y(int r8, int r9) {
        /*
            r7 = this;
            java.util.ArrayList<a.go$b> r0 = r7.b
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            r2 = 8
            if (r0 < 0) goto L84
            java.util.ArrayList<a.go$b> r3 = r7.b
            java.lang.Object r3 = r3.get(r0)
            a.go$b r3 = (a.go.b) r3
            int r4 = r3.f6226a
            r5 = 2
            if (r4 != r2) goto L65
            int r2 = r3.b
            int r4 = r3.c
            if (r2 >= r4) goto L20
            goto L23
        L20:
            r6 = r4
            r4 = r2
            r2 = r6
        L23:
            if (r8 < r2) goto L4b
            if (r8 > r4) goto L4b
            int r4 = r3.b
            if (r2 != r4) goto L3c
            if (r9 != r1) goto L33
            int r2 = r3.c
            int r2 = r2 + r1
        L30:
            r3.c = r2
            goto L39
        L33:
            if (r9 != r5) goto L39
            int r2 = r3.c
            int r2 = r2 - r1
            goto L30
        L39:
            int r8 = r8 + 1
            goto L81
        L3c:
            if (r9 != r1) goto L43
            int r4 = r4 + 1
        L40:
            r3.b = r4
            goto L48
        L43:
            if (r9 != r5) goto L48
            int r4 = r4 + (-1)
            goto L40
        L48:
            int r8 = r8 + (-1)
            goto L81
        L4b:
            int r2 = r3.b
            if (r8 >= r2) goto L81
            if (r9 != r1) goto L5b
            int r2 = r2 + 1
            r3.b = r2
            int r2 = r3.c
            int r2 = r2 + r1
        L58:
            r3.c = r2
            goto L81
        L5b:
            if (r9 != r5) goto L81
            int r2 = r2 + (-1)
            r3.b = r2
            int r2 = r3.c
            int r2 = r2 - r1
            goto L58
        L65:
            int r2 = r3.b
            if (r2 > r8) goto L75
            if (r4 != r1) goto L6f
            int r2 = r3.c
            int r8 = r8 - r2
            goto L81
        L6f:
            if (r4 != r5) goto L81
            int r2 = r3.c
            int r8 = r8 + r2
            goto L81
        L75:
            if (r9 != r1) goto L7c
            int r2 = r2 + 1
        L79:
            r3.b = r2
            goto L81
        L7c:
            if (r9 != r5) goto L81
            int r2 = r2 + (-1)
            goto L79
        L81:
            int r0 = r0 + (-1)
            goto L8
        L84:
            java.util.ArrayList<a.go$b> r9 = r7.b
            int r9 = r9.size()
            int r9 = r9 - r1
        L8b:
            if (r9 < 0) goto Lb1
            java.util.ArrayList<a.go$b> r0 = r7.b
            java.lang.Object r0 = r0.get(r9)
            a.go$b r0 = (a.go.b) r0
            int r1 = r0.f6226a
            if (r1 != r2) goto La2
            int r1 = r0.c
            int r3 = r0.b
            if (r1 == r3) goto La6
            if (r1 >= 0) goto Lae
            goto La6
        La2:
            int r1 = r0.c
            if (r1 > 0) goto Lae
        La6:
            java.util.ArrayList<a.go$b> r1 = r7.b
            r1.remove(r9)
            r7.b(r0)
        Lae:
            int r9 = r9 + (-1)
            goto L8b
        Lb1:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.go.y(int, int):int");
    }
}
