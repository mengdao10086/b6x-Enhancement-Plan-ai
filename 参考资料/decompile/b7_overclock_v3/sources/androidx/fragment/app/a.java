package androidx.fragment.app;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.g0;
import androidx.lifecycle.Lifecycle;
import com.bumptech.glide.load.engine.GlideException;
import g.p0;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends g0 implements FragmentManager.j, FragmentManager.p {
    public static final String R = "FragmentManager";
    public final FragmentManager N;
    public boolean O;
    public int P;
    public boolean Q;

    public a(@g.n0 FragmentManager fragmentManager) {
        super(fragmentManager.G0(), fragmentManager.J0() != null ? fragmentManager.J0().g().getClassLoader() : null);
        this.P = -1;
        this.Q = false;
        this.N = fragmentManager;
    }

    @Override // androidx.fragment.app.g0
    public boolean A() {
        return this.f5947c.isEmpty();
    }

    @Override // androidx.fragment.app.g0
    @g.n0
    public g0 B(@g.n0 Fragment fragment) {
        FragmentManager fragmentManager = fragment.f5662t;
        if (fragmentManager == null || fragmentManager == this.N) {
            return super.B(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.g0
    @g.n0
    public g0 O(@g.n0 Fragment fragment, @g.n0 Lifecycle.State state) {
        if (fragment.f5662t != this.N) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.N);
        }
        if (state == Lifecycle.State.INITIALIZED && fragment.f5641a > -1) {
            throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + " after the Fragment has been created");
        }
        if (state != Lifecycle.State.DESTROYED) {
            return super.O(fragment, state);
        }
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + state + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    }

    @Override // androidx.fragment.app.g0
    @g.n0
    public g0 P(@p0 Fragment fragment) {
        FragmentManager fragmentManager;
        if (fragment == null || (fragmentManager = fragment.f5662t) == null || fragmentManager == this.N) {
            return super.P(fragment);
        }
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.g0
    @g.n0
    public g0 T(@g.n0 Fragment fragment) {
        FragmentManager fragmentManager = fragment.f5662t;
        if (fragmentManager == null || fragmentManager == this.N) {
            return super.T(fragment);
        }
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public void U(int i10) {
        if (this.f5953i) {
            if (FragmentManager.W0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Bump nesting in ");
                sb2.append(this);
                sb2.append(" by ");
                sb2.append(i10);
            }
            int size = this.f5947c.size();
            for (int i11 = 0; i11 < size; i11++) {
                g0.a aVar = this.f5947c.get(i11);
                Fragment fragment = aVar.f5965b;
                if (fragment != null) {
                    fragment.f5661s += i10;
                    if (FragmentManager.W0(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Bump nesting of ");
                        sb3.append(aVar.f5965b);
                        sb3.append(" to ");
                        sb3.append(aVar.f5965b.f5661s);
                    }
                }
            }
        }
    }

    public void V() {
        int size = this.f5947c.size() - 1;
        while (size >= 0) {
            g0.a aVar = this.f5947c.get(size);
            if (aVar.f5966c) {
                if (aVar.f5964a == 8) {
                    aVar.f5966c = false;
                    this.f5947c.remove(size - 1);
                    size--;
                } else {
                    int i10 = aVar.f5965b.f5669y;
                    aVar.f5964a = 2;
                    aVar.f5966c = false;
                    for (int i11 = size - 1; i11 >= 0; i11--) {
                        g0.a aVar2 = this.f5947c.get(i11);
                        if (aVar2.f5966c && aVar2.f5965b.f5669y == i10) {
                            this.f5947c.remove(i11);
                            size--;
                        }
                    }
                }
            }
            size--;
        }
    }

    public int W(boolean z10) {
        if (this.O) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManager.W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Commit: ");
            sb2.append(this);
            PrintWriter printWriter = new PrintWriter(new m0("FragmentManager"));
            X(GlideException.a.f12263d, printWriter);
            printWriter.close();
        }
        this.O = true;
        if (this.f5953i) {
            this.P = this.N.r();
        } else {
            this.P = -1;
        }
        this.N.h0(this, z10);
        return this.P;
    }

    public void X(String str, PrintWriter printWriter) {
        Y(str, printWriter, true);
    }

    public void Y(String str, PrintWriter printWriter, boolean z10) {
        String str2;
        if (z10) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f5955k);
            printWriter.print(" mIndex=");
            printWriter.print(this.P);
            printWriter.print(" mCommitted=");
            printWriter.println(this.O);
            if (this.f5952h != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f5952h));
            }
            if (this.f5948d != 0 || this.f5949e != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f5948d));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f5949e));
            }
            if (this.f5950f != 0 || this.f5951g != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f5950f));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f5951g));
            }
            if (this.f5956l != 0 || this.f5957m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f5956l));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f5957m);
            }
            if (this.f5958n != 0 || this.f5959o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f5958n));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f5959o);
            }
        }
        if (this.f5947c.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f5947c.size();
        for (int i10 = 0; i10 < size; i10++) {
            g0.a aVar = this.f5947c.get(i10);
            switch (aVar.f5964a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = z3.a.f57685w;
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + aVar.f5964a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i10);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(com.blankj.utilcode.util.i0.f11861z);
            printWriter.println(aVar.f5965b);
            if (z10) {
                if (aVar.f5967d != 0 || aVar.f5968e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f5967d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f5968e));
                }
                if (aVar.f5969f != 0 || aVar.f5970g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f5969f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f5970g));
                }
            }
        }
    }

    public void Z() {
        int size = this.f5947c.size();
        for (int i10 = 0; i10 < size; i10++) {
            g0.a aVar = this.f5947c.get(i10);
            Fragment fragment = aVar.f5965b;
            if (fragment != null) {
                fragment.f5656n = this.Q;
                fragment.m5(false);
                fragment.l5(this.f5952h);
                fragment.s5(this.f5960p, this.f5961q);
            }
            switch (aVar.f5964a) {
                case 1:
                    fragment.b5(aVar.f5967d, aVar.f5968e, aVar.f5969f, aVar.f5970g);
                    this.N.V1(fragment, false);
                    this.N.n(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f5964a);
                case 3:
                    fragment.b5(aVar.f5967d, aVar.f5968e, aVar.f5969f, aVar.f5970g);
                    this.N.C1(fragment);
                    break;
                case 4:
                    fragment.b5(aVar.f5967d, aVar.f5968e, aVar.f5969f, aVar.f5970g);
                    this.N.T0(fragment);
                    break;
                case 5:
                    fragment.b5(aVar.f5967d, aVar.f5968e, aVar.f5969f, aVar.f5970g);
                    this.N.V1(fragment, false);
                    this.N.c2(fragment);
                    break;
                case 6:
                    fragment.b5(aVar.f5967d, aVar.f5968e, aVar.f5969f, aVar.f5970g);
                    this.N.E(fragment);
                    break;
                case 7:
                    fragment.b5(aVar.f5967d, aVar.f5968e, aVar.f5969f, aVar.f5970g);
                    this.N.V1(fragment, false);
                    this.N.t(fragment);
                    break;
                case 8:
                    this.N.Y1(fragment);
                    break;
                case 9:
                    this.N.Y1(null);
                    break;
                case 10:
                    this.N.X1(fragment, aVar.f5972i);
                    break;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.j
    @p0
    public CharSequence a() {
        return this.f5956l != 0 ? this.N.J0().g().getText(this.f5956l) : this.f5957m;
    }

    public void a0() {
        for (int size = this.f5947c.size() - 1; size >= 0; size--) {
            g0.a aVar = this.f5947c.get(size);
            Fragment fragment = aVar.f5965b;
            if (fragment != null) {
                fragment.f5656n = this.Q;
                fragment.m5(true);
                fragment.l5(FragmentManager.O1(this.f5952h));
                fragment.s5(this.f5961q, this.f5960p);
            }
            switch (aVar.f5964a) {
                case 1:
                    fragment.b5(aVar.f5967d, aVar.f5968e, aVar.f5969f, aVar.f5970g);
                    this.N.V1(fragment, true);
                    this.N.C1(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.f5964a);
                case 3:
                    fragment.b5(aVar.f5967d, aVar.f5968e, aVar.f5969f, aVar.f5970g);
                    this.N.n(fragment);
                    break;
                case 4:
                    fragment.b5(aVar.f5967d, aVar.f5968e, aVar.f5969f, aVar.f5970g);
                    this.N.c2(fragment);
                    break;
                case 5:
                    fragment.b5(aVar.f5967d, aVar.f5968e, aVar.f5969f, aVar.f5970g);
                    this.N.V1(fragment, true);
                    this.N.T0(fragment);
                    break;
                case 6:
                    fragment.b5(aVar.f5967d, aVar.f5968e, aVar.f5969f, aVar.f5970g);
                    this.N.t(fragment);
                    break;
                case 7:
                    fragment.b5(aVar.f5967d, aVar.f5968e, aVar.f5969f, aVar.f5970g);
                    this.N.V1(fragment, true);
                    this.N.E(fragment);
                    break;
                case 8:
                    this.N.Y1(null);
                    break;
                case 9:
                    this.N.Y1(fragment);
                    break;
                case 10:
                    this.N.X1(fragment, aVar.f5971h);
                    break;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentManager.p
    public boolean b(@g.n0 ArrayList<a> arrayList, @g.n0 ArrayList<Boolean> arrayList2) {
        if (FragmentManager.W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Run: ");
            sb2.append(this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f5953i) {
            return true;
        }
        this.N.m(this);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.fragment.app.Fragment b0(java.util.ArrayList<androidx.fragment.app.Fragment> r17, androidx.fragment.app.Fragment r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = 0
        L7:
            java.util.ArrayList<androidx.fragment.app.g0$a> r5 = r0.f5947c
            int r5 = r5.size()
            if (r4 >= r5) goto Lbe
            java.util.ArrayList<androidx.fragment.app.g0$a> r5 = r0.f5947c
            java.lang.Object r5 = r5.get(r4)
            androidx.fragment.app.g0$a r5 = (androidx.fragment.app.g0.a) r5
            int r6 = r5.f5964a
            r7 = 0
            r8 = 1
            if (r6 == r8) goto Lb6
            r9 = 2
            r10 = 3
            r11 = 9
            if (r6 == r9) goto L5a
            if (r6 == r10) goto L43
            r9 = 6
            if (r6 == r9) goto L43
            r7 = 7
            if (r6 == r7) goto Lb6
            r7 = 8
            if (r6 == r7) goto L31
            goto Lbb
        L31:
            java.util.ArrayList<androidx.fragment.app.g0$a> r6 = r0.f5947c
            androidx.fragment.app.g0$a r7 = new androidx.fragment.app.g0$a
            r7.<init>(r11, r3, r8)
            r6.add(r4, r7)
            r5.f5966c = r8
            int r4 = r4 + 1
            androidx.fragment.app.Fragment r3 = r5.f5965b
            goto Lbb
        L43:
            androidx.fragment.app.Fragment r6 = r5.f5965b
            r1.remove(r6)
            androidx.fragment.app.Fragment r5 = r5.f5965b
            if (r5 != r3) goto Lbb
            java.util.ArrayList<androidx.fragment.app.g0$a> r3 = r0.f5947c
            androidx.fragment.app.g0$a r6 = new androidx.fragment.app.g0$a
            r6.<init>(r11, r5)
            r3.add(r4, r6)
            int r4 = r4 + 1
            r3 = r7
            goto Lbb
        L5a:
            androidx.fragment.app.Fragment r6 = r5.f5965b
            int r9 = r6.f5669y
            int r12 = r17.size()
            int r12 = r12 - r8
            r13 = 0
        L64:
            if (r12 < 0) goto La4
            java.lang.Object r14 = r1.get(r12)
            androidx.fragment.app.Fragment r14 = (androidx.fragment.app.Fragment) r14
            int r15 = r14.f5669y
            if (r15 != r9) goto La1
            if (r14 != r6) goto L74
            r13 = 1
            goto La1
        L74:
            if (r14 != r3) goto L83
            java.util.ArrayList<androidx.fragment.app.g0$a> r3 = r0.f5947c
            androidx.fragment.app.g0$a r15 = new androidx.fragment.app.g0$a
            r15.<init>(r11, r14, r8)
            r3.add(r4, r15)
            int r4 = r4 + 1
            r3 = r7
        L83:
            androidx.fragment.app.g0$a r15 = new androidx.fragment.app.g0$a
            r15.<init>(r10, r14, r8)
            int r2 = r5.f5967d
            r15.f5967d = r2
            int r2 = r5.f5969f
            r15.f5969f = r2
            int r2 = r5.f5968e
            r15.f5968e = r2
            int r2 = r5.f5970g
            r15.f5970g = r2
            java.util.ArrayList<androidx.fragment.app.g0$a> r2 = r0.f5947c
            r2.add(r4, r15)
            r1.remove(r14)
            int r4 = r4 + r8
        La1:
            int r12 = r12 + (-1)
            goto L64
        La4:
            if (r13 == 0) goto Lae
            java.util.ArrayList<androidx.fragment.app.g0$a> r2 = r0.f5947c
            r2.remove(r4)
            int r4 = r4 + (-1)
            goto Lbb
        Lae:
            r5.f5964a = r8
            r5.f5966c = r8
            r1.add(r6)
            goto Lbb
        Lb6:
            androidx.fragment.app.Fragment r2 = r5.f5965b
            r1.add(r2)
        Lbb:
            int r4 = r4 + r8
            goto L7
        Lbe:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.a.b0(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    @Override // androidx.fragment.app.FragmentManager.j
    public int c() {
        return this.f5958n;
    }

    public void c0() {
        if (this.f5963s != null) {
            for (int i10 = 0; i10 < this.f5963s.size(); i10++) {
                this.f5963s.get(i10).run();
            }
            this.f5963s = null;
        }
    }

    @Override // androidx.fragment.app.FragmentManager.j
    public int d() {
        return this.f5956l;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.fragment.app.Fragment d0(java.util.ArrayList<androidx.fragment.app.Fragment> r6, androidx.fragment.app.Fragment r7) {
        /*
            r5 = this;
            java.util.ArrayList<androidx.fragment.app.g0$a> r0 = r5.f5947c
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            if (r0 < 0) goto L35
            java.util.ArrayList<androidx.fragment.app.g0$a> r2 = r5.f5947c
            java.lang.Object r2 = r2.get(r0)
            androidx.fragment.app.g0$a r2 = (androidx.fragment.app.g0.a) r2
            int r3 = r2.f5964a
            if (r3 == r1) goto L2d
            r4 = 3
            if (r3 == r4) goto L27
            switch(r3) {
                case 6: goto L27;
                case 7: goto L2d;
                case 8: goto L25;
                case 9: goto L22;
                case 10: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L32
        L1d:
            androidx.lifecycle.Lifecycle$State r3 = r2.f5971h
            r2.f5972i = r3
            goto L32
        L22:
            androidx.fragment.app.Fragment r7 = r2.f5965b
            goto L32
        L25:
            r7 = 0
            goto L32
        L27:
            androidx.fragment.app.Fragment r2 = r2.f5965b
            r6.add(r2)
            goto L32
        L2d:
            androidx.fragment.app.Fragment r2 = r2.f5965b
            r6.remove(r2)
        L32:
            int r0 = r0 + (-1)
            goto L8
        L35:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.a.d0(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    @Override // androidx.fragment.app.FragmentManager.j
    @p0
    public CharSequence e() {
        return this.f5958n != 0 ? this.N.J0().g().getText(this.f5958n) : this.f5959o;
    }

    @Override // androidx.fragment.app.FragmentManager.j
    public int getId() {
        return this.P;
    }

    @Override // androidx.fragment.app.FragmentManager.j
    @p0
    public String getName() {
        return this.f5955k;
    }

    @Override // androidx.fragment.app.g0
    public int q() {
        return W(false);
    }

    @Override // androidx.fragment.app.g0
    public int r() {
        return W(true);
    }

    @Override // androidx.fragment.app.g0
    public void s() {
        w();
        this.N.k0(this, false);
    }

    @Override // androidx.fragment.app.g0
    public void t() {
        w();
        this.N.k0(this, true);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.P >= 0) {
            sb2.append(" #");
            sb2.append(this.P);
        }
        if (this.f5955k != null) {
            sb2.append(com.blankj.utilcode.util.i0.f11861z);
            sb2.append(this.f5955k);
        }
        sb2.append(zc.a.f58317e);
        return sb2.toString();
    }

    @Override // androidx.fragment.app.g0
    @g.n0
    public g0 v(@g.n0 Fragment fragment) {
        FragmentManager fragmentManager = fragment.f5662t;
        if (fragmentManager == null || fragmentManager == this.N) {
            return super.v(fragment);
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // androidx.fragment.app.g0
    public void x(int i10, Fragment fragment, @p0 String str, int i11) {
        super.x(i10, fragment, str, i11);
        fragment.f5662t = this.N;
    }

    @Override // androidx.fragment.app.g0
    @g.n0
    public g0 y(@g.n0 Fragment fragment) {
        FragmentManager fragmentManager = fragment.f5662t;
        if (fragmentManager == null || fragmentManager == this.N) {
            return super.y(fragment);
        }
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    public a(@g.n0 a aVar) {
        super(aVar.N.G0(), aVar.N.J0() != null ? aVar.N.J0().g().getClassLoader() : null, aVar);
        this.P = -1;
        this.Q = false;
        this.N = aVar.N;
        this.O = aVar.O;
        this.P = aVar.P;
        this.Q = aVar.Q;
    }
}
