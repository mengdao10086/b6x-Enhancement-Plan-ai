package a;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class su {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ou f7433a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f2926a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long[] f2927a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean[] f2928a;
    public long[] b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7434a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public List<qu> f2929a;

        public void a() {
            this.f2929a = null;
            this.f7434a = 0;
        }
    }

    public su(ou ouVar) {
        this.f7433a = ouVar;
    }

    public final int A(int i, pu puVar, int i2) {
        int iL;
        ou ouVar = this.f7433a;
        int iC = ouVar.c(i, ouVar.getPaddingLeft() + this.f7433a.getPaddingRight() + puVar.g() + puVar.i() + i2, puVar.getWidth());
        int size = View.MeasureSpec.getSize(iC);
        if (size > puVar.a()) {
            iL = puVar.a();
        } else {
            if (size >= puVar.l()) {
                return iC;
            }
            iL = puVar.l();
        }
        return View.MeasureSpec.makeMeasureSpec(iL, View.MeasureSpec.getMode(iC));
    }

    public final int B(pu puVar, boolean z) {
        return z ? puVar.p() : puVar.i();
    }

    public final int C(pu puVar, boolean z) {
        return z ? puVar.i() : puVar.p();
    }

    public final int D(pu puVar, boolean z) {
        return z ? puVar.f() : puVar.g();
    }

    public final int E(pu puVar, boolean z) {
        return z ? puVar.g() : puVar.f();
    }

    public final int F(pu puVar, boolean z) {
        return z ? puVar.getHeight() : puVar.getWidth();
    }

    public final int G(pu puVar, boolean z) {
        return z ? puVar.getWidth() : puVar.getHeight();
    }

    public final int H(boolean z) {
        return z ? this.f7433a.getPaddingBottom() : this.f7433a.getPaddingEnd();
    }

    public final int I(boolean z) {
        return z ? this.f7433a.getPaddingEnd() : this.f7433a.getPaddingBottom();
    }

    public final int J(boolean z) {
        return z ? this.f7433a.getPaddingTop() : this.f7433a.getPaddingStart();
    }

    public final int K(boolean z) {
        return z ? this.f7433a.getPaddingStart() : this.f7433a.getPaddingTop();
    }

    public final int L(View view, boolean z) {
        return z ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    public final int M(View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    public final boolean N(int i, int i2, qu quVar) {
        return i == i2 - 1 && quVar.c() != 0;
    }

    public boolean O(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f7433a.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View viewK = this.f7433a.k(i);
            if (viewK != null && ((pu) viewK.getLayoutParams()).getOrder() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }

    public final boolean P(View view, int i, int i2, int i3, int i4, pu puVar, int i5, int i6, int i7) {
        if (this.f7433a.getFlexWrap() == 0) {
            return false;
        }
        if (puVar.k()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int maxLine = this.f7433a.getMaxLine();
        if (maxLine != -1 && maxLine <= i7 + 1) {
            return false;
        }
        int iF = this.f7433a.f(view, i5, i6);
        if (iF > 0) {
            i4 += iF;
        }
        return i2 < i3 + i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Q(android.view.View r6, a.qu r7, int r8, int r9, int r10, int r11) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.su.Q(android.view.View, a.qu, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0077  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void R(android.view.View r5, a.qu r6, boolean r7, int r8, int r9, int r10, int r11) {
        /*
            r4 = this;
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            a.pu r0 = (a.pu) r0
            a.ou r1 = r4.f7433a
            int r1 = r1.getAlignItems()
            int r2 = r0.c()
            r3 = -1
            if (r2 == r3) goto L17
            int r1 = r0.c()
        L17:
            int r6 = r6.g
            if (r1 == 0) goto L6a
            r2 = 1
            if (r1 == r2) goto L44
            r2 = 2
            if (r1 == r2) goto L28
            r6 = 3
            if (r1 == r6) goto L6a
            r6 = 4
            if (r1 == r6) goto L6a
            goto L84
        L28:
            android.view.ViewGroup$LayoutParams r0 = r5.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r0 = (android.view.ViewGroup.MarginLayoutParams) r0
            int r1 = r5.getMeasuredWidth()
            int r6 = r6 - r1
            int r1 = a.eg.b(r0)
            int r6 = r6 + r1
            int r0 = a.eg.a(r0)
            int r6 = r6 - r0
            int r6 = r6 / r2
            if (r7 != 0) goto L42
            int r8 = r8 + r6
            goto L75
        L42:
            int r8 = r8 - r6
            goto L80
        L44:
            if (r7 != 0) goto L58
            int r8 = r8 + r6
            int r7 = r5.getMeasuredWidth()
            int r8 = r8 - r7
            int r7 = r0.i()
            int r8 = r8 - r7
            int r10 = r10 + r6
            int r6 = r5.getMeasuredWidth()
            int r10 = r10 - r6
            goto L7c
        L58:
            int r8 = r8 - r6
            int r7 = r5.getMeasuredWidth()
            int r8 = r8 + r7
            int r7 = r0.g()
            int r8 = r8 + r7
            int r10 = r10 - r6
            int r6 = r5.getMeasuredWidth()
            int r10 = r10 + r6
            goto L71
        L6a:
            if (r7 != 0) goto L77
            int r6 = r0.g()
            int r8 = r8 + r6
        L71:
            int r6 = r0.g()
        L75:
            int r10 = r10 + r6
            goto L81
        L77:
            int r6 = r0.i()
            int r8 = r8 - r6
        L7c:
            int r6 = r0.i()
        L80:
            int r10 = r10 - r6
        L81:
            r5.layout(r8, r9, r10, r11)
        L84:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.su.R(android.view.View, a.qu, boolean, int, int, int, int):void");
    }

    public long S(int i, int i2) {
        return (((long) i) & 4294967295L) | (((long) i2) << 32);
    }

    public final void T(int i, int i2, qu quVar, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int iMax;
        int i7 = quVar.e;
        float f = quVar.b;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 > i7) {
            return;
        }
        float f3 = (i7 - i3) / f;
        quVar.e = i4 + quVar.f;
        if (!z) {
            quVar.g = Integer.MIN_VALUE;
        }
        int i8 = 0;
        boolean z2 = false;
        int i9 = 0;
        float f4 = 0.0f;
        while (i8 < quVar.h) {
            int i10 = quVar.l + i8;
            View viewE = this.f7433a.e(i10);
            if (viewE == null || viewE.getVisibility() == 8) {
                i5 = i7;
                i6 = i8;
            } else {
                pu puVar = (pu) viewE.getLayoutParams();
                int flexDirection = this.f7433a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i5 = i7;
                    int i11 = i8;
                    int measuredWidth = viewE.getMeasuredWidth();
                    long[] jArr = this.b;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i10]);
                    }
                    int measuredHeight = viewE.getMeasuredHeight();
                    long[] jArr2 = this.b;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i10]);
                    }
                    if (this.f2928a[i10] || puVar.b() <= 0.0f) {
                        i6 = i11;
                    } else {
                        float fB = measuredWidth - (puVar.b() * f3);
                        i6 = i11;
                        if (i6 == quVar.h - 1) {
                            fB += f4;
                            f4 = 0.0f;
                        }
                        int iRound = Math.round(fB);
                        if (iRound < puVar.l()) {
                            iRound = puVar.l();
                            this.f2928a[i10] = true;
                            quVar.b -= puVar.b();
                            z2 = true;
                        } else {
                            f4 += fB - iRound;
                            double d = f4;
                            if (d > 1.0d) {
                                iRound++;
                                f4 -= 1.0f;
                            } else if (d < -1.0d) {
                                iRound--;
                                f4 += 1.0f;
                            }
                        }
                        int iZ = z(i2, puVar, quVar.k);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewE.measure(iMakeMeasureSpec, iZ);
                        int measuredWidth2 = viewE.getMeasuredWidth();
                        int measuredHeight2 = viewE.getMeasuredHeight();
                        Z(i10, iMakeMeasureSpec, iZ, viewE);
                        this.f7433a.d(i10, viewE);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i9, measuredHeight + puVar.f() + puVar.p() + this.f7433a.j(viewE));
                    quVar.e += measuredWidth + puVar.g() + puVar.i();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewE.getMeasuredHeight();
                    long[] jArr3 = this.b;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i10]);
                    }
                    int measuredWidth3 = viewE.getMeasuredWidth();
                    long[] jArr4 = this.b;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i10]);
                    }
                    if (this.f2928a[i10] || puVar.b() <= f2) {
                        i5 = i7;
                        i6 = i8;
                    } else {
                        float fB2 = measuredHeight3 - (puVar.b() * f3);
                        if (i8 == quVar.h - 1) {
                            fB2 += f4;
                            f4 = f2;
                        }
                        int iRound2 = Math.round(fB2);
                        if (iRound2 < puVar.h()) {
                            iRound2 = puVar.h();
                            this.f2928a[i10] = true;
                            quVar.b -= puVar.b();
                            i5 = i7;
                            i6 = i8;
                            z2 = true;
                        } else {
                            f4 += fB2 - iRound2;
                            i5 = i7;
                            i6 = i8;
                            double d2 = f4;
                            if (d2 > 1.0d) {
                                iRound2++;
                                f4 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                iRound2--;
                                f4 += 1.0f;
                            }
                        }
                        int iA = A(i, puVar, quVar.k);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewE.measure(iA, iMakeMeasureSpec2);
                        measuredWidth3 = viewE.getMeasuredWidth();
                        int measuredHeight4 = viewE.getMeasuredHeight();
                        Z(i10, iA, iMakeMeasureSpec2, viewE);
                        this.f7433a.d(i10, viewE);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i9, measuredWidth3 + puVar.g() + puVar.i() + this.f7433a.j(viewE));
                    quVar.e += measuredHeight3 + puVar.f() + puVar.p();
                }
                quVar.g = Math.max(quVar.g, iMax);
                i9 = iMax;
            }
            i8 = i6 + 1;
            i7 = i5;
            f2 = 0.0f;
        }
        int i12 = i7;
        if (!z2 || i12 == quVar.e) {
            return;
        }
        T(i, i2, quVar, i3, i4, true);
    }

    public final int[] U(int i, List<tu> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (tu tuVar : list) {
            int i3 = tuVar.f7533a;
            iArr[i2] = i3;
            sparseIntArray.append(i3, tuVar.b);
            i2++;
        }
        return iArr;
    }

    public final void V(View view, int i, int i2) {
        pu puVar = (pu) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - puVar.g()) - puVar.i()) - this.f7433a.j(view), puVar.l()), puVar.a());
        long[] jArr = this.b;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? x(jArr[i2]) : view.getMeasuredHeight(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        Z(i2, iMakeMeasureSpec2, iMakeMeasureSpec, view);
        this.f7433a.d(i2, view);
    }

    public final void W(View view, int i, int i2) {
        pu puVar = (pu) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - puVar.f()) - puVar.p()) - this.f7433a.j(view), puVar.h()), puVar.d());
        long[] jArr = this.b;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? y(jArr[i2]) : view.getMeasuredWidth(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        Z(i2, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        this.f7433a.d(i2, view);
    }

    public void X() {
        Y(0);
    }

    public void Y(int i) {
        View viewE;
        if (i >= this.f7433a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f7433a.getFlexDirection();
        if (this.f7433a.getAlignItems() != 4) {
            for (qu quVar : this.f7433a.getFlexLinesInternal()) {
                for (Integer num : quVar.f2605a) {
                    View viewE2 = this.f7433a.e(num.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        W(viewE2, quVar.g, num.intValue());
                    } else {
                        if (flexDirection != 2 && flexDirection != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                        }
                        V(viewE2, quVar.g, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.f2926a;
        List<qu> flexLinesInternal = this.f7433a.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
            qu quVar2 = flexLinesInternal.get(i2);
            int i3 = quVar2.h;
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = quVar2.l + i4;
                if (i4 < this.f7433a.getFlexItemCount() && (viewE = this.f7433a.e(i5)) != null && viewE.getVisibility() != 8) {
                    pu puVar = (pu) viewE.getLayoutParams();
                    if (puVar.c() == -1 || puVar.c() == 4) {
                        if (flexDirection == 0 || flexDirection == 1) {
                            W(viewE, quVar2.g, i5);
                        } else {
                            if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                            }
                            V(viewE, quVar2.g, i5);
                        }
                    }
                }
            }
        }
    }

    public final void Z(int i, int i2, int i3, View view) {
        long[] jArr = this.f2927a;
        if (jArr != null) {
            jArr[i] = S(i2, i3);
        }
        long[] jArr2 = this.b;
        if (jArr2 != null) {
            jArr2[i] = S(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public final void a(List<qu> list, qu quVar, int i, int i2) {
        quVar.k = i2;
        this.f7433a.h(quVar);
        quVar.m = i;
        list.add(quVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(a.su.a r32, int r33, int r34, int r35, int r36, int r37, java.util.List<a.qu> r38) {
        /*
            Method dump skipped, instruction units count: 845
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.su.b(a.su$a, int, int, int, int, int, java.util.List):void");
    }

    public void c(a aVar, int i, int i2) {
        b(aVar, i, i2, Integer.MAX_VALUE, 0, -1, null);
    }

    public void d(a aVar, int i, int i2, int i3, int i4, List<qu> list) {
        b(aVar, i, i2, i3, i4, -1, list);
    }

    public void e(a aVar, int i, int i2, int i3, int i4, List<qu> list) {
        b(aVar, i, i2, i3, 0, i4, list);
    }

    public void f(a aVar, int i, int i2) {
        b(aVar, i2, i, Integer.MAX_VALUE, 0, -1, null);
    }

    public void g(a aVar, int i, int i2, int i3, int i4, List<qu> list) {
        b(aVar, i2, i, i3, i4, -1, list);
    }

    public void h(a aVar, int i, int i2, int i3, int i4, List<qu> list) {
        b(aVar, i2, i, i3, 0, i4, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            a.pu r0 = (a.pu) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.l()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.l()
        L19:
            r3 = r4
            goto L27
        L1b:
            int r3 = r0.a()
            if (r1 <= r3) goto L26
            int r1 = r0.a()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.h()
            if (r2 >= r5) goto L32
            int r2 = r0.h()
            goto L3e
        L32:
            int r5 = r0.d()
            if (r2 <= r5) goto L3d
            int r2 = r0.d()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L55
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.Z(r8, r1, r0, r7)
            a.ou r0 = r6.f7433a
            r0.d(r8, r7)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.su.i(android.view.View, int):void");
    }

    public void j(List<qu> list, int i) {
        int i2 = this.f2926a[i];
        if (i2 == -1) {
            i2 = 0;
        }
        if (list.size() > i2) {
            list.subList(i2, list.size()).clear();
        }
        int[] iArr = this.f2926a;
        int length = iArr.length - 1;
        if (i > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i, length, -1);
        }
        long[] jArr = this.f2927a;
        int length2 = jArr.length - 1;
        if (i > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i, length2, 0L);
        }
    }

    public final List<qu> k(List<qu> list, int i, int i2) {
        int i3 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        qu quVar = new qu();
        quVar.g = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(quVar);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(quVar);
            }
        }
        return arrayList;
    }

    public final List<tu> l(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            pu puVar = (pu) this.f7433a.k(i2).getLayoutParams();
            tu tuVar = new tu();
            tuVar.b = puVar.getOrder();
            tuVar.f7533a = i2;
            arrayList.add(tuVar);
        }
        return arrayList;
    }

    public int[] m(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f7433a.getFlexItemCount();
        return U(flexItemCount, l(flexItemCount), sparseIntArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int[] n(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.f7433a.getFlexItemCount();
        List<tu> listL = l(flexItemCount);
        tu tuVar = new tu();
        if (view == null || !(layoutParams instanceof pu)) {
            tuVar.b = 1;
        } else {
            tuVar.b = ((pu) layoutParams).getOrder();
        }
        if (i == -1 || i == flexItemCount || i >= this.f7433a.getFlexItemCount()) {
            tuVar.f7533a = flexItemCount;
        } else {
            tuVar.f7533a = i;
            while (i < flexItemCount) {
                listL.get(i).f7533a++;
                i++;
            }
        }
        listL.add(tuVar);
        return U(flexItemCount + 1, listL, sparseIntArray);
    }

    public void o(int i, int i2, int i3) {
        int mode;
        int size;
        ArrayList arrayList;
        int flexDirection = this.f7433a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            mode = mode2;
            size = size2;
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
        }
        List<qu> flexLinesInternal = this.f7433a.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.f7433a.getSumOfCrossSize() + i3;
            int i4 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).g = size - i3;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.f7433a.getAlignContent();
                if (alignContent == 1) {
                    int i5 = size - sumOfCrossSize;
                    qu quVar = new qu();
                    quVar.g = i5;
                    flexLinesInternal.add(0, quVar);
                    return;
                }
                if (alignContent != 2) {
                    if (alignContent != 3) {
                        if (alignContent != 4) {
                            if (alignContent == 5 && sumOfCrossSize < size) {
                                float size3 = (size - sumOfCrossSize) / flexLinesInternal.size();
                                int size4 = flexLinesInternal.size();
                                float f = 0.0f;
                                while (i4 < size4) {
                                    qu quVar2 = flexLinesInternal.get(i4);
                                    float f2 = quVar2.g + size3;
                                    if (i4 == flexLinesInternal.size() - 1) {
                                        f2 += f;
                                        f = 0.0f;
                                    }
                                    int iRound = Math.round(f2);
                                    f += f2 - iRound;
                                    if (f > 1.0f) {
                                        iRound++;
                                        f -= 1.0f;
                                    } else if (f < -1.0f) {
                                        iRound--;
                                        f += 1.0f;
                                    }
                                    quVar2.g = iRound;
                                    i4++;
                                }
                                return;
                            }
                            return;
                        }
                        if (sumOfCrossSize < size) {
                            int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                            arrayList = new ArrayList();
                            qu quVar3 = new qu();
                            quVar3.g = size5;
                            for (qu quVar4 : flexLinesInternal) {
                                arrayList.add(quVar3);
                                arrayList.add(quVar4);
                                arrayList.add(quVar3);
                            }
                        }
                    } else {
                        if (sumOfCrossSize >= size) {
                            return;
                        }
                        float size6 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                        arrayList = new ArrayList();
                        int size7 = flexLinesInternal.size();
                        float f3 = 0.0f;
                        while (i4 < size7) {
                            arrayList.add(flexLinesInternal.get(i4));
                            if (i4 != flexLinesInternal.size() - 1) {
                                qu quVar5 = new qu();
                                if (i4 == flexLinesInternal.size() - 2) {
                                    quVar5.g = Math.round(f3 + size6);
                                    f3 = 0.0f;
                                } else {
                                    quVar5.g = Math.round(size6);
                                }
                                int i6 = quVar5.g;
                                f3 += size6 - i6;
                                if (f3 > 1.0f) {
                                    quVar5.g = i6 + 1;
                                    f3 -= 1.0f;
                                } else if (f3 < -1.0f) {
                                    quVar5.g = i6 - 1;
                                    f3 += 1.0f;
                                }
                                arrayList.add(quVar5);
                            }
                            i4++;
                        }
                    }
                    this.f7433a.setFlexLines(arrayList);
                    return;
                }
                this.f7433a.setFlexLines(k(flexLinesInternal, size, sumOfCrossSize));
            }
        }
    }

    public void p(int i, int i2) {
        q(i, i2, 0);
    }

    public void q(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int paddingRight;
        r(this.f7433a.getFlexItemCount());
        if (i3 >= this.f7433a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f7433a.getFlexDirection();
        int flexDirection2 = this.f7433a.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int largestMainSize = this.f7433a.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.f7433a.getPaddingLeft();
            paddingRight = this.f7433a.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                size = this.f7433a.getLargestMainSize();
            }
            paddingLeft = this.f7433a.getPaddingTop();
            paddingRight = this.f7433a.getPaddingBottom();
        }
        int i4 = paddingLeft + paddingRight;
        int[] iArr = this.f2926a;
        int i5 = iArr != null ? iArr[i3] : 0;
        List<qu> flexLinesInternal = this.f7433a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i6 = i5; i6 < size2; i6++) {
            qu quVar = flexLinesInternal.get(i6);
            if (quVar.e < size && quVar.f2606a) {
                w(i, i2, quVar, size, i4, false);
            } else if (quVar.e > size && quVar.f2608b) {
                T(i, i2, quVar, size, i4, false);
            }
        }
    }

    public final void r(int i) {
        boolean[] zArr = this.f2928a;
        if (zArr == null) {
            this.f2928a = new boolean[Math.max(i, 10)];
        } else if (zArr.length < i) {
            this.f2928a = new boolean[Math.max(zArr.length * 2, i)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    public void s(int i) {
        int[] iArr = this.f2926a;
        if (iArr == null) {
            this.f2926a = new int[Math.max(i, 10)];
        } else if (iArr.length < i) {
            this.f2926a = Arrays.copyOf(this.f2926a, Math.max(iArr.length * 2, i));
        }
    }

    public void t(int i) {
        long[] jArr = this.f2927a;
        if (jArr == null) {
            this.f2927a = new long[Math.max(i, 10)];
        } else if (jArr.length < i) {
            this.f2927a = Arrays.copyOf(this.f2927a, Math.max(jArr.length * 2, i));
        }
    }

    public void u(int i) {
        long[] jArr = this.b;
        if (jArr == null) {
            this.b = new long[Math.max(i, 10)];
        } else if (jArr.length < i) {
            this.b = Arrays.copyOf(this.b, Math.max(jArr.length * 2, i));
        }
    }

    public final void v(CompoundButton compoundButton) {
        pu puVar = (pu) compoundButton.getLayoutParams();
        int iL = puVar.l();
        int iH = puVar.h();
        Drawable drawableA = gj.a(compoundButton);
        int minimumWidth = drawableA == null ? 0 : drawableA.getMinimumWidth();
        int minimumHeight = drawableA != null ? drawableA.getMinimumHeight() : 0;
        if (iL == -1) {
            iL = minimumWidth;
        }
        puVar.e(iL);
        if (iH == -1) {
            iH = minimumHeight;
        }
        puVar.n(iH);
    }

    public final void w(int i, int i2, qu quVar, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int iMax;
        double d;
        int i7;
        double d2;
        float f = quVar.f7239a;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 < (i5 = quVar.e)) {
            return;
        }
        float f3 = (i3 - i5) / f;
        quVar.e = i4 + quVar.f;
        if (!z) {
            quVar.g = Integer.MIN_VALUE;
        }
        int i8 = 0;
        boolean z2 = false;
        int i9 = 0;
        float f4 = 0.0f;
        while (i8 < quVar.h) {
            int i10 = quVar.l + i8;
            View viewE = this.f7433a.e(i10);
            if (viewE == null || viewE.getVisibility() == 8) {
                i6 = i5;
            } else {
                pu puVar = (pu) viewE.getLayoutParams();
                int flexDirection = this.f7433a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i11 = i5;
                    int measuredWidth = viewE.getMeasuredWidth();
                    long[] jArr = this.b;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i10]);
                    }
                    int measuredHeight = viewE.getMeasuredHeight();
                    long[] jArr2 = this.b;
                    i6 = i11;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i10]);
                    }
                    if (!this.f2928a[i10] && puVar.j() > 0.0f) {
                        float fJ = measuredWidth + (puVar.j() * f3);
                        if (i8 == quVar.h - 1) {
                            fJ += f4;
                            f4 = 0.0f;
                        }
                        int iRound = Math.round(fJ);
                        if (iRound > puVar.a()) {
                            iRound = puVar.a();
                            this.f2928a[i10] = true;
                            quVar.f7239a -= puVar.j();
                            z2 = true;
                        } else {
                            f4 += fJ - iRound;
                            double d3 = f4;
                            if (d3 > 1.0d) {
                                iRound++;
                                d = d3 - 1.0d;
                            } else if (d3 < -1.0d) {
                                iRound--;
                                d = d3 + 1.0d;
                            }
                            f4 = (float) d;
                        }
                        int iZ = z(i2, puVar, quVar.k);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewE.measure(iMakeMeasureSpec, iZ);
                        int measuredWidth2 = viewE.getMeasuredWidth();
                        int measuredHeight2 = viewE.getMeasuredHeight();
                        Z(i10, iMakeMeasureSpec, iZ, viewE);
                        this.f7433a.d(i10, viewE);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i9, measuredHeight + puVar.f() + puVar.p() + this.f7433a.j(viewE));
                    quVar.e += measuredWidth + puVar.g() + puVar.i();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewE.getMeasuredHeight();
                    long[] jArr3 = this.b;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i10]);
                    }
                    int measuredWidth3 = viewE.getMeasuredWidth();
                    long[] jArr4 = this.b;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i10]);
                    }
                    if (this.f2928a[i10] || puVar.j() <= f2) {
                        i7 = i5;
                    } else {
                        float fJ2 = measuredHeight3 + (puVar.j() * f3);
                        if (i8 == quVar.h - 1) {
                            fJ2 += f4;
                            f4 = f2;
                        }
                        int iRound2 = Math.round(fJ2);
                        if (iRound2 > puVar.d()) {
                            iRound2 = puVar.d();
                            this.f2928a[i10] = true;
                            quVar.f7239a -= puVar.j();
                            i7 = i5;
                            z2 = true;
                        } else {
                            f4 += fJ2 - iRound2;
                            i7 = i5;
                            double d4 = f4;
                            if (d4 > 1.0d) {
                                iRound2++;
                                d2 = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                iRound2--;
                                d2 = d4 + 1.0d;
                            }
                            f4 = (float) d2;
                        }
                        int iA = A(i, puVar, quVar.k);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewE.measure(iA, iMakeMeasureSpec2);
                        measuredWidth3 = viewE.getMeasuredWidth();
                        int measuredHeight4 = viewE.getMeasuredHeight();
                        Z(i10, iA, iMakeMeasureSpec2, viewE);
                        this.f7433a.d(i10, viewE);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i9, measuredWidth3 + puVar.g() + puVar.i() + this.f7433a.j(viewE));
                    quVar.e += measuredHeight3 + puVar.f() + puVar.p();
                    i6 = i7;
                }
                quVar.g = Math.max(quVar.g, iMax);
                i9 = iMax;
            }
            i8++;
            i5 = i6;
            f2 = 0.0f;
        }
        int i12 = i5;
        if (!z2 || i12 == quVar.e) {
            return;
        }
        w(i, i2, quVar, i3, i4, true);
    }

    public int x(long j) {
        return (int) (j >> 32);
    }

    public int y(long j) {
        return (int) j;
    }

    public final int z(int i, pu puVar, int i2) {
        int iH;
        ou ouVar = this.f7433a;
        int iB = ouVar.b(i, ouVar.getPaddingTop() + this.f7433a.getPaddingBottom() + puVar.f() + puVar.p() + i2, puVar.getHeight());
        int size = View.MeasureSpec.getSize(iB);
        if (size > puVar.d()) {
            iH = puVar.d();
        } else {
            if (size >= puVar.h()) {
                return iB;
            }
            iH = puVar.h();
        }
        return View.MeasureSpec.makeMeasureSpec(iH, View.MeasureSpec.getMode(iB));
    }
}
