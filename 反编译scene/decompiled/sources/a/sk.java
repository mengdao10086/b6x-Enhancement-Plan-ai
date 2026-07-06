package a;

import a.hn;
import android.util.Log;
import androidx.fragment.app.Fragment;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class sk extends hm implements vl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final yl f7407a;
    public boolean c;
    public int i = -1;

    public sk(yl ylVar) {
        this.f7407a = ylVar;
    }

    public static boolean z(gm gmVar) {
        Fragment fragment = gmVar.f1037a;
        return (fragment == null || !fragment.f4274b || fragment.f4263a == null || fragment.i || fragment.h || !fragment.V()) ? false : true;
    }

    public boolean A() {
        for (int i = 0; i < ((hm) this).f1187a.size(); i++) {
            if (z(((hm) this).f1187a.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void B() {
        if (((hm) this).f1193d != null) {
            for (int i = 0; i < ((hm) this).f1193d.size(); i++) {
                ((hm) this).f1193d.get(i).run();
            }
            ((hm) this).f1193d = null;
        }
    }

    public void C(bl blVar) {
        for (int i = 0; i < ((hm) this).f1187a.size(); i++) {
            gm gmVar = ((hm) this).f1187a.get(i);
            if (z(gmVar)) {
                gmVar.f1037a.p1(blVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.fragment.app.Fragment D(java.util.ArrayList<androidx.fragment.app.Fragment> r6, androidx.fragment.app.Fragment r7) {
        /*
            r5 = this;
            java.util.ArrayList<a.gm> r0 = r5.f1187a
            int r0 = r0.size()
            r1 = 1
            int r0 = r0 - r1
        L8:
            if (r0 < 0) goto L35
            java.util.ArrayList<a.gm> r2 = r5.f1187a
            java.lang.Object r2 = r2.get(r0)
            a.gm r2 = (a.gm) r2
            int r3 = r2.f6220a
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
            a.hn$b r3 = r2.f1036a
            r2.f1038b = r3
            goto L32
        L22:
            androidx.fragment.app.Fragment r7 = r2.f1037a
            goto L32
        L25:
            r7 = 0
            goto L32
        L27:
            androidx.fragment.app.Fragment r2 = r2.f1037a
            r6.add(r2)
            goto L32
        L2d:
            androidx.fragment.app.Fragment r2 = r2.f1037a
            r6.remove(r2)
        L32:
            int r0 = r0 + (-1)
            goto L8
        L35:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a.sk.D(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    @Override // a.vl
    public boolean a(ArrayList<sk> arrayList, ArrayList<Boolean> arrayList2) {
        if (yl.h) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!((hm) this).f1188a) {
            return true;
        }
        this.f7407a.l(this);
        return true;
    }

    @Override // a.hm
    public int f() {
        return q(false);
    }

    @Override // a.hm
    public int g() {
        return q(true);
    }

    @Override // a.hm
    public void h() {
        j();
        this.f7407a.n0(this, true);
    }

    @Override // a.hm
    public hm i(Fragment fragment) {
        yl ylVar = fragment.f4258a;
        if (ylVar == null || ylVar == this.f7407a) {
            super.i(fragment);
            return this;
        }
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // a.hm
    public void k(int i, Fragment fragment, String str, int i2) {
        super.k(i, fragment, str, i2);
        fragment.f4258a = this.f7407a;
    }

    @Override // a.hm
    public hm l(Fragment fragment) {
        yl ylVar = fragment.f4258a;
        if (ylVar == null || ylVar == this.f7407a) {
            super.l(fragment);
            return this;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    @Override // a.hm
    public hm o(Fragment fragment, hn.b bVar) {
        if (fragment.f4258a != this.f7407a) {
            throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.f7407a);
        }
        if (bVar.a(hn.b.CREATED)) {
            super.o(fragment, bVar);
            return this;
        }
        throw new IllegalArgumentException("Cannot set maximum Lifecycle below " + hn.b.CREATED);
    }

    public void p(int i) {
        if (((hm) this).f1188a) {
            if (yl.h) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = ((hm) this).f1187a.size();
            for (int i2 = 0; i2 < size; i2++) {
                gm gmVar = ((hm) this).f1187a.get(i2);
                Fragment fragment = gmVar.f1037a;
                if (fragment != null) {
                    fragment.c += i;
                    if (yl.h) {
                        Log.v("FragmentManager", "Bump nesting of " + gmVar.f1037a + " to " + gmVar.f1037a.c);
                    }
                }
            }
        }
    }

    public int q(boolean z) {
        if (this.c) {
            throw new IllegalStateException("commit already called");
        }
        if (yl.h) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new jf("FragmentManager"));
            r("  ", printWriter);
            printWriter.close();
        }
        this.c = true;
        this.i = ((hm) this).f1188a ? this.f7407a.o(this) : -1;
        this.f7407a.j0(this, z);
        return this.i;
    }

    public void r(String str, PrintWriter printWriter) {
        s(str, printWriter, true);
    }

    public void s(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(((hm) this).f1186a);
            printWriter.print(" mIndex=");
            printWriter.print(this.i);
            printWriter.print(" mCommitted=");
            printWriter.println(this.c);
            if (this.e != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.e));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f));
            }
            if (((hm) this).f6323a != 0 || ((hm) this).b != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(((hm) this).f6323a));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(((hm) this).b));
            }
            if (((hm) this).c != 0 || ((hm) this).d != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(((hm) this).c));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(((hm) this).d));
            }
            if (this.g != 0 || ((hm) this).f1185a != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.g));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(((hm) this).f1185a);
            }
            if (this.h != 0 || ((hm) this).f1189b != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.h));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(((hm) this).f1189b);
            }
        }
        if (((hm) this).f1187a.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = ((hm) this).f1187a.size();
        for (int i = 0; i < size; i++) {
            gm gmVar = ((hm) this).f1187a.get(i);
            switch (gmVar.f6220a) {
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
                    str2 = "REMOVE";
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
                    str2 = "cmd=" + gmVar.f6220a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(gmVar.f1037a);
            if (z) {
                if (gmVar.b != 0 || gmVar.c != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(gmVar.b));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(gmVar.c));
                }
                if (gmVar.d != 0 || gmVar.e != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(gmVar.d));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(gmVar.e));
                }
            }
        }
    }

    public void t() {
        int size = ((hm) this).f1187a.size();
        for (int i = 0; i < size; i++) {
            gm gmVar = ((hm) this).f1187a.get(i);
            Fragment fragment = gmVar.f1037a;
            if (fragment != null) {
                fragment.o1(this.e, this.f);
            }
            switch (gmVar.f6220a) {
                case 1:
                    fragment.n1(gmVar.b);
                    this.f7407a.m(fragment, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + gmVar.f6220a);
                case 3:
                    fragment.n1(gmVar.c);
                    this.f7407a.Z0(fragment);
                    break;
                case 4:
                    fragment.n1(gmVar.c);
                    this.f7407a.D0(fragment);
                    break;
                case 5:
                    fragment.n1(gmVar.b);
                    this.f7407a.m1(fragment);
                    break;
                case 6:
                    fragment.n1(gmVar.c);
                    this.f7407a.y(fragment);
                    break;
                case 7:
                    fragment.n1(gmVar.b);
                    this.f7407a.r(fragment);
                    break;
                case 8:
                    this.f7407a.l1(fragment);
                    break;
                case 9:
                    this.f7407a.l1(null);
                    break;
                case 10:
                    this.f7407a.k1(fragment, gmVar.f1038b);
                    break;
            }
            if (!((hm) this).f1191b && gmVar.f6220a != 1 && fragment != null) {
                this.f7407a.P0(fragment);
            }
        }
        if (((hm) this).f1191b) {
            return;
        }
        yl ylVar = this.f7407a;
        ylVar.Q0(ylVar.f3734b, true);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.i >= 0) {
            sb.append(" #");
            sb.append(this.i);
        }
        if (((hm) this).f1186a != null) {
            sb.append(" ");
            sb.append(((hm) this).f1186a);
        }
        sb.append("}");
        return sb.toString();
    }

    public void u(boolean z) {
        for (int size = ((hm) this).f1187a.size() - 1; size >= 0; size--) {
            gm gmVar = ((hm) this).f1187a.get(size);
            Fragment fragment = gmVar.f1037a;
            if (fragment != null) {
                fragment.o1(yl.e1(this.e), this.f);
            }
            switch (gmVar.f6220a) {
                case 1:
                    fragment.n1(gmVar.e);
                    this.f7407a.Z0(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + gmVar.f6220a);
                case 3:
                    fragment.n1(gmVar.d);
                    this.f7407a.m(fragment, false);
                    break;
                case 4:
                    fragment.n1(gmVar.d);
                    this.f7407a.m1(fragment);
                    break;
                case 5:
                    fragment.n1(gmVar.e);
                    this.f7407a.D0(fragment);
                    break;
                case 6:
                    fragment.n1(gmVar.d);
                    this.f7407a.r(fragment);
                    break;
                case 7:
                    fragment.n1(gmVar.e);
                    this.f7407a.y(fragment);
                    break;
                case 8:
                    this.f7407a.l1(null);
                    break;
                case 9:
                    this.f7407a.l1(fragment);
                    break;
                case 10:
                    this.f7407a.k1(fragment, gmVar.f1036a);
                    break;
            }
            if (!((hm) this).f1191b && gmVar.f6220a != 3 && fragment != null) {
                this.f7407a.P0(fragment);
            }
        }
        if (((hm) this).f1191b || !z) {
            return;
        }
        yl ylVar = this.f7407a;
        ylVar.Q0(ylVar.f3734b, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.fragment.app.Fragment v(java.util.ArrayList<androidx.fragment.app.Fragment> r17, androidx.fragment.app.Fragment r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = 0
        L7:
            java.util.ArrayList<a.gm> r5 = r0.f1187a
            int r5 = r5.size()
            if (r4 >= r5) goto Lba
            java.util.ArrayList<a.gm> r5 = r0.f1187a
            java.lang.Object r5 = r5.get(r4)
            a.gm r5 = (a.gm) r5
            int r6 = r5.f6220a
            r7 = 0
            r8 = 1
            if (r6 == r8) goto Lb2
            r9 = 2
            r10 = 3
            r11 = 9
            if (r6 == r9) goto L58
            if (r6 == r10) goto L41
            r9 = 6
            if (r6 == r9) goto L41
            r7 = 7
            if (r6 == r7) goto Lb2
            r7 = 8
            if (r6 == r7) goto L31
            goto Lb7
        L31:
            java.util.ArrayList<a.gm> r6 = r0.f1187a
            a.gm r7 = new a.gm
            r7.<init>(r11, r3)
            r6.add(r4, r7)
            int r4 = r4 + 1
            androidx.fragment.app.Fragment r3 = r5.f1037a
            goto Lb7
        L41:
            androidx.fragment.app.Fragment r6 = r5.f1037a
            r1.remove(r6)
            androidx.fragment.app.Fragment r5 = r5.f1037a
            if (r5 != r3) goto Lb7
            java.util.ArrayList<a.gm> r3 = r0.f1187a
            a.gm r6 = new a.gm
            r6.<init>(r11, r5)
            r3.add(r4, r6)
            int r4 = r4 + 1
            r3 = r7
            goto Lb7
        L58:
            androidx.fragment.app.Fragment r6 = r5.f1037a
            int r9 = r6.e
            int r12 = r17.size()
            int r12 = r12 - r8
            r13 = 0
        L62:
            if (r12 < 0) goto La2
            java.lang.Object r14 = r1.get(r12)
            androidx.fragment.app.Fragment r14 = (androidx.fragment.app.Fragment) r14
            int r15 = r14.e
            if (r15 != r9) goto L9f
            if (r14 != r6) goto L72
            r13 = r8
            goto L9f
        L72:
            if (r14 != r3) goto L81
            java.util.ArrayList<a.gm> r3 = r0.f1187a
            a.gm r15 = new a.gm
            r15.<init>(r11, r14)
            r3.add(r4, r15)
            int r4 = r4 + 1
            r3 = r7
        L81:
            a.gm r15 = new a.gm
            r15.<init>(r10, r14)
            int r2 = r5.b
            r15.b = r2
            int r2 = r5.d
            r15.d = r2
            int r2 = r5.c
            r15.c = r2
            int r2 = r5.e
            r15.e = r2
            java.util.ArrayList<a.gm> r2 = r0.f1187a
            r2.add(r4, r15)
            r1.remove(r14)
            int r4 = r4 + r8
        L9f:
            int r12 = r12 + (-1)
            goto L62
        La2:
            if (r13 == 0) goto Lac
            java.util.ArrayList<a.gm> r2 = r0.f1187a
            r2.remove(r4)
            int r4 = r4 + (-1)
            goto Lb7
        Lac:
            r5.f6220a = r8
            r1.add(r6)
            goto Lb7
        Lb2:
            androidx.fragment.app.Fragment r2 = r5.f1037a
            r1.add(r2)
        Lb7:
            int r4 = r4 + r8
            goto L7
        Lba:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: a.sk.v(java.util.ArrayList, androidx.fragment.app.Fragment):androidx.fragment.app.Fragment");
    }

    public String w() {
        return ((hm) this).f1186a;
    }

    public boolean x(int i) {
        int size = ((hm) this).f1187a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = ((hm) this).f1187a.get(i2).f1037a;
            int i3 = fragment != null ? fragment.e : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    public boolean y(ArrayList<sk> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = ((hm) this).f1187a.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = ((hm) this).f1187a.get(i4).f1037a;
            int i5 = fragment != null ? fragment.e : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    sk skVar = arrayList.get(i6);
                    int size2 = ((hm) skVar).f1187a.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = ((hm) skVar).f1187a.get(i7).f1037a;
                        if ((fragment2 != null ? fragment2.e : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }
}
