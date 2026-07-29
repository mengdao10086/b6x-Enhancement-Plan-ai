package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.r;
import g.i1;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f19420f = 10;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f19421g = 4294967295L;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ boolean f19422h = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f19423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean[] f19424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public int[] f19425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public long[] f19426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public long[] f19427e;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<f> f19428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19429b;

        public void a() {
            this.f19428a = null;
            this.f19429b = 0;
        }
    }

    public static class c implements Comparable<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19430a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19431b;

        public c() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(@n0 c another) {
            int i10 = this.f19431b;
            int i11 = another.f19431b;
            return i10 != i11 ? i10 - i11 : this.f19430a - another.f19430a;
        }

        @n0
        public String toString() {
            return "Order{order=" + this.f19431b + ", index=" + this.f19430a + '}';
        }
    }

    public h(d flexContainer) {
        this.f19423a = flexContainer;
    }

    public final int A(int widthMeasureSpec, FlexItem flexItem, int padding) {
        d dVar = this.f19423a;
        int iE = dVar.e(widthMeasureSpec, dVar.getPaddingLeft() + this.f19423a.getPaddingRight() + flexItem.u() + flexItem.I() + padding, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(iE);
        return size > flexItem.R() ? View.MeasureSpec.makeMeasureSpec(flexItem.R(), View.MeasureSpec.getMode(iE)) : size < flexItem.p() ? View.MeasureSpec.makeMeasureSpec(flexItem.p(), View.MeasureSpec.getMode(iE)) : iE;
    }

    public final int B(FlexItem flexItem, boolean isMainHorizontal) {
        return isMainHorizontal ? flexItem.t() : flexItem.I();
    }

    public final int C(FlexItem flexItem, boolean isMainHorizontal) {
        return isMainHorizontal ? flexItem.I() : flexItem.t();
    }

    public final int D(FlexItem flexItem, boolean isMainHorizontal) {
        return isMainHorizontal ? flexItem.x() : flexItem.u();
    }

    public final int E(FlexItem flexItem, boolean isMainHorizontal) {
        return isMainHorizontal ? flexItem.u() : flexItem.x();
    }

    public final int F(FlexItem flexItem, boolean isMainHorizontal) {
        return isMainHorizontal ? flexItem.getHeight() : flexItem.getWidth();
    }

    public final int G(FlexItem flexItem, boolean isMainHorizontal) {
        return isMainHorizontal ? flexItem.getWidth() : flexItem.getHeight();
    }

    public final int H(boolean isMainHorizontal) {
        return isMainHorizontal ? this.f19423a.getPaddingBottom() : this.f19423a.getPaddingEnd();
    }

    public final int I(boolean isMainHorizontal) {
        return isMainHorizontal ? this.f19423a.getPaddingEnd() : this.f19423a.getPaddingBottom();
    }

    public final int J(boolean isMainHorizontal) {
        return isMainHorizontal ? this.f19423a.getPaddingTop() : this.f19423a.getPaddingStart();
    }

    public final int K(boolean isMainHorizontal) {
        return isMainHorizontal ? this.f19423a.getPaddingStart() : this.f19423a.getPaddingTop();
    }

    public final int L(View view, boolean isMainHorizontal) {
        return isMainHorizontal ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    public final int M(View view, boolean isMainHorizontal) {
        return isMainHorizontal ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    public final boolean N(int childIndex, int childCount, f flexLine) {
        return childIndex == childCount - 1 && flexLine.d() != 0;
    }

    public boolean O(SparseIntArray orderCache) {
        int flexItemCount = this.f19423a.getFlexItemCount();
        if (orderCache.size() != flexItemCount) {
            return true;
        }
        for (int i10 = 0; i10 < flexItemCount; i10++) {
            View viewH = this.f19423a.h(i10);
            if (viewH != null && ((FlexItem) viewH.getLayoutParams()).getOrder() != orderCache.get(i10)) {
                return true;
            }
        }
        return false;
    }

    public final boolean P(View view, int mode, int maxSize, int currentLength, int childLength, FlexItem flexItem, int index, int indexInFlexLine, int flexLinesSize) {
        if (this.f19423a.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.L()) {
            return true;
        }
        if (mode == 0) {
            return false;
        }
        int maxLine = this.f19423a.getMaxLine();
        if (maxLine != -1 && maxLine <= flexLinesSize + 1) {
            return false;
        }
        int i10 = this.f19423a.i(view, index, indexInFlexLine);
        if (i10 > 0) {
            childLength += i10;
        }
        return maxSize < currentLength + childLength;
    }

    public void Q(View view, f flexLine, int left, int top2, int right, int bottom) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f19423a.getAlignItems();
        if (flexItem.l() != -1) {
            alignItems = flexItem.l();
        }
        int i10 = flexLine.f19407g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.f19423a.getFlexWrap() == 2) {
                    view.layout(left, (top2 - i10) + view.getMeasuredHeight() + flexItem.x(), right, (bottom - i10) + view.getMeasuredHeight() + flexItem.x());
                    return;
                } else {
                    int i11 = top2 + i10;
                    view.layout(left, (i11 - view.getMeasuredHeight()) - flexItem.t(), right, i11 - flexItem.t());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i10 - view.getMeasuredHeight()) + flexItem.x()) - flexItem.t()) / 2;
                if (this.f19423a.getFlexWrap() != 2) {
                    int i12 = top2 + measuredHeight;
                    view.layout(left, i12, right, view.getMeasuredHeight() + i12);
                    return;
                } else {
                    int i13 = top2 - measuredHeight;
                    view.layout(left, i13, right, view.getMeasuredHeight() + i13);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.f19423a.getFlexWrap() != 2) {
                    int iMax = Math.max(flexLine.f19412l - view.getBaseline(), flexItem.x());
                    view.layout(left, top2 + iMax, right, bottom + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((flexLine.f19412l - view.getMeasuredHeight()) + view.getBaseline(), flexItem.t());
                    view.layout(left, top2 - iMax2, right, bottom - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.f19423a.getFlexWrap() != 2) {
            view.layout(left, top2 + flexItem.x(), right, bottom + flexItem.x());
        } else {
            view.layout(left, top2 - flexItem.t(), right, bottom - flexItem.t());
        }
    }

    public void R(View view, f flexLine, boolean isRtl, int left, int top2, int right, int bottom) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f19423a.getAlignItems();
        if (flexItem.l() != -1) {
            alignItems = flexItem.l();
        }
        int i10 = flexLine.f19407g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (isRtl) {
                    view.layout((left - i10) + view.getMeasuredWidth() + flexItem.u(), top2, (right - i10) + view.getMeasuredWidth() + flexItem.u(), bottom);
                    return;
                } else {
                    view.layout(((left + i10) - view.getMeasuredWidth()) - flexItem.I(), top2, ((right + i10) - view.getMeasuredWidth()) - flexItem.I(), bottom);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i10 - view.getMeasuredWidth()) + r.c(marginLayoutParams)) - r.b(marginLayoutParams)) / 2;
                if (isRtl) {
                    view.layout(left - measuredWidth, top2, right - measuredWidth, bottom);
                    return;
                } else {
                    view.layout(left + measuredWidth, top2, right + measuredWidth, bottom);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (isRtl) {
            view.layout(left - flexItem.I(), top2, right - flexItem.I(), bottom);
        } else {
            view.layout(left + flexItem.u(), top2, right + flexItem.u(), bottom);
        }
    }

    @i1
    public long S(int widthMeasureSpec, int heightMeasureSpec) {
        return (((long) widthMeasureSpec) & 4294967295L) | (((long) heightMeasureSpec) << 32);
    }

    public final void T(int widthMeasureSpec, int heightMeasureSpec, f flexLine, int maxMainSize, int paddingAlongMainAxis, boolean calledRecursively) {
        int i10;
        int i11;
        int iMax;
        int i12 = flexLine.f19405e;
        float f10 = flexLine.f19411k;
        float f11 = 0.0f;
        if (f10 <= 0.0f || maxMainSize > i12) {
            return;
        }
        float f12 = (i12 - maxMainSize) / f10;
        flexLine.f19405e = paddingAlongMainAxis + flexLine.f19406f;
        if (!calledRecursively) {
            flexLine.f19407g = Integer.MIN_VALUE;
        }
        int i13 = 0;
        boolean z10 = false;
        int i14 = 0;
        float f13 = 0.0f;
        while (i13 < flexLine.f19408h) {
            int i15 = flexLine.f19415o + i13;
            View viewD = this.f19423a.d(i15);
            if (viewD == null || viewD.getVisibility() == 8) {
                i10 = i12;
                i11 = i13;
            } else {
                FlexItem flexItem = (FlexItem) viewD.getLayoutParams();
                int flexDirection = this.f19423a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i10 = i12;
                    int i16 = i13;
                    int measuredWidth = viewD.getMeasuredWidth();
                    long[] jArr = this.f19427e;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i15]);
                    }
                    int measuredHeight = viewD.getMeasuredHeight();
                    long[] jArr2 = this.f19427e;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i15]);
                    }
                    if (this.f19424b[i15] || flexItem.m() <= 0.0f) {
                        i11 = i16;
                    } else {
                        float fM = measuredWidth - (flexItem.m() * f12);
                        i11 = i16;
                        if (i11 == flexLine.f19408h - 1) {
                            fM += f13;
                            f13 = 0.0f;
                        }
                        int iRound = Math.round(fM);
                        if (iRound < flexItem.p()) {
                            iRound = flexItem.p();
                            this.f19424b[i15] = true;
                            flexLine.f19411k -= flexItem.m();
                            z10 = true;
                        } else {
                            f13 += fM - iRound;
                            double d10 = f13;
                            if (d10 > 1.0d) {
                                iRound++;
                                f13 -= 1.0f;
                            } else if (d10 < -1.0d) {
                                iRound--;
                                f13 += 1.0f;
                            }
                        }
                        int iZ = z(heightMeasureSpec, flexItem, flexLine.f19413m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewD.measure(iMakeMeasureSpec, iZ);
                        int measuredWidth2 = viewD.getMeasuredWidth();
                        int measuredHeight2 = viewD.getMeasuredHeight();
                        Z(i15, iMakeMeasureSpec, iZ, viewD);
                        this.f19423a.f(i15, viewD);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i14, measuredHeight + flexItem.x() + flexItem.t() + this.f19423a.l(viewD));
                    flexLine.f19405e += measuredWidth + flexItem.u() + flexItem.I();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewD.getMeasuredHeight();
                    long[] jArr3 = this.f19427e;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i15]);
                    }
                    int measuredWidth3 = viewD.getMeasuredWidth();
                    long[] jArr4 = this.f19427e;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i15]);
                    }
                    if (this.f19424b[i15] || flexItem.m() <= f11) {
                        i10 = i12;
                        i11 = i13;
                    } else {
                        float fM2 = measuredHeight3 - (flexItem.m() * f12);
                        if (i13 == flexLine.f19408h - 1) {
                            fM2 += f13;
                            f13 = 0.0f;
                        }
                        int iRound2 = Math.round(fM2);
                        if (iRound2 < flexItem.K()) {
                            iRound2 = flexItem.K();
                            this.f19424b[i15] = true;
                            flexLine.f19411k -= flexItem.m();
                            i10 = i12;
                            i11 = i13;
                            z10 = true;
                        } else {
                            f13 += fM2 - iRound2;
                            i10 = i12;
                            i11 = i13;
                            double d11 = f13;
                            if (d11 > 1.0d) {
                                iRound2++;
                                f13 -= 1.0f;
                            } else if (d11 < -1.0d) {
                                iRound2--;
                                f13 += 1.0f;
                            }
                        }
                        int iA = A(widthMeasureSpec, flexItem, flexLine.f19413m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewD.measure(iA, iMakeMeasureSpec2);
                        measuredWidth3 = viewD.getMeasuredWidth();
                        int measuredHeight4 = viewD.getMeasuredHeight();
                        Z(i15, iA, iMakeMeasureSpec2, viewD);
                        this.f19423a.f(i15, viewD);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i14, measuredWidth3 + flexItem.u() + flexItem.I() + this.f19423a.l(viewD));
                    flexLine.f19405e += measuredHeight3 + flexItem.x() + flexItem.t();
                }
                flexLine.f19407g = Math.max(flexLine.f19407g, iMax);
                i14 = iMax;
            }
            i13 = i11 + 1;
            i12 = i10;
            f11 = 0.0f;
        }
        int i17 = i12;
        if (!z10 || i17 == flexLine.f19405e) {
            return;
        }
        T(widthMeasureSpec, heightMeasureSpec, flexLine, maxMainSize, paddingAlongMainAxis, true);
    }

    public final int[] U(int childCount, List<c> orders, SparseIntArray orderCache) {
        Collections.sort(orders);
        orderCache.clear();
        int[] iArr = new int[childCount];
        int i10 = 0;
        for (c cVar : orders) {
            int i11 = cVar.f19430a;
            iArr[i10] = i11;
            orderCache.append(i11, cVar.f19431b);
            i10++;
        }
        return iArr;
    }

    public final void V(View view, int crossSize, int index) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((crossSize - flexItem.u()) - flexItem.I()) - this.f19423a.l(view), flexItem.p()), flexItem.R());
        long[] jArr = this.f19427e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? x(jArr[index]) : view.getMeasuredHeight(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        Z(index, iMakeMeasureSpec2, iMakeMeasureSpec, view);
        this.f19423a.f(index, view);
    }

    public final void W(View view, int crossSize, int index) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((crossSize - flexItem.x()) - flexItem.t()) - this.f19423a.l(view), flexItem.K()), flexItem.N());
        long[] jArr = this.f19427e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? y(jArr[index]) : view.getMeasuredWidth(), 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, 1073741824);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        Z(index, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        this.f19423a.f(index, view);
    }

    public void X() {
        Y(0);
    }

    public void Y(int fromIndex) {
        View viewD;
        if (fromIndex >= this.f19423a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f19423a.getFlexDirection();
        if (this.f19423a.getAlignItems() != 4) {
            for (f fVar : this.f19423a.getFlexLinesInternal()) {
                for (Integer num : fVar.f19414n) {
                    View viewD2 = this.f19423a.d(num.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        W(viewD2, fVar.f19407g, num.intValue());
                    } else {
                        if (flexDirection != 2 && flexDirection != 3) {
                            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                        }
                        V(viewD2, fVar.f19407g, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.f19425c;
        List<f> flexLinesInternal = this.f19423a.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i10 = iArr != null ? iArr[fromIndex] : 0; i10 < size; i10++) {
            f fVar2 = flexLinesInternal.get(i10);
            int i11 = fVar2.f19408h;
            for (int i12 = 0; i12 < i11; i12++) {
                int i13 = fVar2.f19415o + i12;
                if (i12 < this.f19423a.getFlexItemCount() && (viewD = this.f19423a.d(i13)) != null && viewD.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) viewD.getLayoutParams();
                    if (flexItem.l() == -1 || flexItem.l() == 4) {
                        if (flexDirection == 0 || flexDirection == 1) {
                            W(viewD, fVar2.f19407g, i13);
                        } else {
                            if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                            }
                            V(viewD, fVar2.f19407g, i13);
                        }
                    }
                }
            }
        }
    }

    public final void Z(int index, int widthMeasureSpec, int heightMeasureSpec, View view) {
        long[] jArr = this.f19426d;
        if (jArr != null) {
            jArr[index] = S(widthMeasureSpec, heightMeasureSpec);
        }
        long[] jArr2 = this.f19427e;
        if (jArr2 != null) {
            jArr2[index] = S(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    public final void a(List<f> flexLines, f flexLine, int viewIndex, int usedCrossSizeSoFar) {
        flexLine.f19413m = usedCrossSizeSoFar;
        this.f19423a.c(flexLine);
        flexLine.f19416p = viewIndex;
        flexLines.add(flexLine);
    }

    public void b(b result, int mainMeasureSpec, int crossMeasureSpec, int needsCalcAmount, int fromIndex, int toIndex, @p0 List<f> existingLines) {
        int i10;
        b bVar;
        int i11;
        int i12;
        int i13;
        List<f> list;
        int i14;
        View view;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        f fVar;
        int i21;
        int i22 = mainMeasureSpec;
        int i23 = crossMeasureSpec;
        int i24 = toIndex;
        boolean zK = this.f19423a.k();
        int mode = View.MeasureSpec.getMode(mainMeasureSpec);
        int size = View.MeasureSpec.getSize(mainMeasureSpec);
        List<f> arrayList = existingLines == null ? new ArrayList() : existingLines;
        result.f19428a = arrayList;
        boolean z10 = i24 == -1;
        int iK = K(zK);
        int I = I(zK);
        int iJ = J(zK);
        int iH = H(zK);
        f fVar2 = new f();
        int i25 = fromIndex;
        fVar2.f19415o = i25;
        int i26 = I + iK;
        fVar2.f19405e = i26;
        int flexItemCount = this.f19423a.getFlexItemCount();
        boolean z11 = z10;
        int i27 = 0;
        int iCombineMeasuredStates = 0;
        int i28 = 0;
        int i29 = Integer.MIN_VALUE;
        while (true) {
            if (i25 >= flexItemCount) {
                i10 = iCombineMeasuredStates;
                bVar = result;
                break;
            }
            View viewD = this.f19423a.d(i25);
            if (viewD == null) {
                if (N(i25, flexItemCount, fVar2)) {
                    a(arrayList, fVar2, i25, i27);
                }
            } else if (viewD.getVisibility() == 8) {
                fVar2.f19409i++;
                fVar2.f19408h++;
                if (N(i25, flexItemCount, fVar2)) {
                    a(arrayList, fVar2, i25, i27);
                }
            } else {
                if (viewD instanceof CompoundButton) {
                    v((CompoundButton) viewD);
                }
                FlexItem flexItem = (FlexItem) viewD.getLayoutParams();
                int i30 = flexItemCount;
                if (flexItem.l() == 4) {
                    fVar2.f19414n.add(Integer.valueOf(i25));
                }
                int iG = G(flexItem, zK);
                if (flexItem.E() != -1.0f && mode == 1073741824) {
                    iG = Math.round(size * flexItem.E());
                }
                if (zK) {
                    int iE = this.f19423a.e(i22, i26 + E(flexItem, true) + C(flexItem, true), iG);
                    i11 = size;
                    i12 = mode;
                    int iJ2 = this.f19423a.j(i23, iJ + iH + D(flexItem, true) + B(flexItem, true) + i27, F(flexItem, true));
                    viewD.measure(iE, iJ2);
                    Z(i25, iE, iJ2, viewD);
                    i13 = iE;
                } else {
                    i11 = size;
                    i12 = mode;
                    int iE2 = this.f19423a.e(i23, iJ + iH + D(flexItem, false) + B(flexItem, false) + i27, F(flexItem, false));
                    int iJ3 = this.f19423a.j(i22, E(flexItem, false) + i26 + C(flexItem, false), iG);
                    viewD.measure(iE2, iJ3);
                    Z(i25, iE2, iJ3, viewD);
                    i13 = iJ3;
                }
                this.f19423a.f(i25, viewD);
                i(viewD, i25);
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewD.getMeasuredState());
                int i31 = i27;
                int i32 = i26;
                f fVar3 = fVar2;
                int i33 = i25;
                list = arrayList;
                int i34 = i13;
                if (P(viewD, i12, i11, fVar2.f19405e, C(flexItem, zK) + M(viewD, zK) + E(flexItem, zK), flexItem, i33, i28, arrayList.size())) {
                    if (fVar3.d() > 0) {
                        if (i33 > 0) {
                            i21 = i33 - 1;
                            fVar = fVar3;
                        } else {
                            fVar = fVar3;
                            i21 = 0;
                        }
                        a(list, fVar, i21, i31);
                        i27 = fVar.f19407g + i31;
                    } else {
                        i27 = i31;
                    }
                    if (!zK) {
                        i14 = crossMeasureSpec;
                        view = viewD;
                        i25 = i33;
                        if (flexItem.getWidth() == -1) {
                            d dVar = this.f19423a;
                            view.measure(dVar.e(i14, dVar.getPaddingLeft() + this.f19423a.getPaddingRight() + flexItem.u() + flexItem.I() + i27, flexItem.getWidth()), i34);
                            i(view, i25);
                        }
                    } else if (flexItem.getHeight() == -1) {
                        d dVar2 = this.f19423a;
                        i14 = crossMeasureSpec;
                        i25 = i33;
                        view = viewD;
                        view.measure(i34, dVar2.j(i14, dVar2.getPaddingTop() + this.f19423a.getPaddingBottom() + flexItem.x() + flexItem.t() + i27, flexItem.getHeight()));
                        i(view, i25);
                    } else {
                        i14 = crossMeasureSpec;
                        view = viewD;
                        i25 = i33;
                    }
                    fVar2 = new f();
                    fVar2.f19408h = 1;
                    i15 = i32;
                    fVar2.f19405e = i15;
                    fVar2.f19415o = i25;
                    i16 = 0;
                    i17 = Integer.MIN_VALUE;
                } else {
                    i14 = crossMeasureSpec;
                    view = viewD;
                    i25 = i33;
                    fVar2 = fVar3;
                    i15 = i32;
                    fVar2.f19408h++;
                    i16 = i28 + 1;
                    i27 = i31;
                    i17 = i29;
                }
                fVar2.f19417q |= flexItem.A() != 0.0f;
                fVar2.f19418r |= flexItem.m() != 0.0f;
                int[] iArr = this.f19425c;
                if (iArr != null) {
                    iArr[i25] = list.size();
                }
                fVar2.f19405e += M(view, zK) + E(flexItem, zK) + C(flexItem, zK);
                fVar2.f19410j += flexItem.A();
                fVar2.f19411k += flexItem.m();
                this.f19423a.b(view, i25, i16, fVar2);
                int iMax = Math.max(i17, L(view, zK) + D(flexItem, zK) + B(flexItem, zK) + this.f19423a.l(view));
                fVar2.f19407g = Math.max(fVar2.f19407g, iMax);
                if (zK) {
                    if (this.f19423a.getFlexWrap() != 2) {
                        fVar2.f19412l = Math.max(fVar2.f19412l, view.getBaseline() + flexItem.x());
                    } else {
                        fVar2.f19412l = Math.max(fVar2.f19412l, (view.getMeasuredHeight() - view.getBaseline()) + flexItem.t());
                    }
                }
                i18 = i30;
                if (N(i25, i18, fVar2)) {
                    a(list, fVar2, i25, i27);
                    i27 += fVar2.f19407g;
                }
                i19 = toIndex;
                if (i19 != -1 && list.size() > 0) {
                    if (list.get(list.size() - 1).f19416p >= i19 && i25 >= i19 && !z11) {
                        i27 = -fVar2.a();
                        i20 = needsCalcAmount;
                        z11 = true;
                    }
                    if (i27 <= i20 && z11) {
                        bVar = result;
                        i10 = iCombineMeasuredStates;
                        break;
                    }
                    i28 = i16;
                    i29 = iMax;
                    i25++;
                    i22 = mainMeasureSpec;
                    flexItemCount = i18;
                    i23 = i14;
                    i26 = i15;
                    arrayList = list;
                    mode = i12;
                    i24 = i19;
                    size = i11;
                }
                i20 = needsCalcAmount;
                if (i27 <= i20) {
                }
                i28 = i16;
                i29 = iMax;
                i25++;
                i22 = mainMeasureSpec;
                flexItemCount = i18;
                i23 = i14;
                i26 = i15;
                arrayList = list;
                mode = i12;
                i24 = i19;
                size = i11;
            }
            i11 = size;
            i12 = mode;
            i14 = i23;
            i19 = i24;
            list = arrayList;
            i15 = i26;
            i18 = flexItemCount;
            i25++;
            i22 = mainMeasureSpec;
            flexItemCount = i18;
            i23 = i14;
            i26 = i15;
            arrayList = list;
            mode = i12;
            i24 = i19;
            size = i11;
        }
        bVar.f19429b = i10;
    }

    public void c(b result, int widthMeasureSpec, int heightMeasureSpec) {
        b(result, widthMeasureSpec, heightMeasureSpec, Integer.MAX_VALUE, 0, -1, null);
    }

    public void d(b result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int fromIndex, @p0 List<f> existingLines) {
        b(result, widthMeasureSpec, heightMeasureSpec, needsCalcAmount, fromIndex, -1, existingLines);
    }

    public void e(b result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int toIndex, List<f> existingLines) {
        b(result, widthMeasureSpec, heightMeasureSpec, needsCalcAmount, 0, toIndex, existingLines);
    }

    public void f(b result, int widthMeasureSpec, int heightMeasureSpec) {
        b(result, heightMeasureSpec, widthMeasureSpec, Integer.MAX_VALUE, 0, -1, null);
    }

    public void g(b result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int fromIndex, @p0 List<f> existingLines) {
        b(result, heightMeasureSpec, widthMeasureSpec, needsCalcAmount, fromIndex, -1, existingLines);
    }

    public void h(b result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int toIndex, List<f> existingLines) {
        b(result, heightMeasureSpec, widthMeasureSpec, needsCalcAmount, 0, toIndex, existingLines);
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
            com.google.android.flexbox.FlexItem r0 = (com.google.android.flexbox.FlexItem) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.p()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.p()
        L19:
            r3 = 1
            goto L27
        L1b:
            int r3 = r0.R()
            if (r1 <= r3) goto L26
            int r1 = r0.R()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.K()
            if (r2 >= r5) goto L32
            int r2 = r0.K()
            goto L3e
        L32:
            int r5 = r0.N()
            if (r2 <= r5) goto L3d
            int r2 = r0.N()
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
            com.google.android.flexbox.d r0 = r6.f19423a
            r0.f(r8, r7)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.h.i(android.view.View, int):void");
    }

    public void j(List<f> flexLines, int fromFlexItem) {
        int i10 = this.f19425c[fromFlexItem];
        if (i10 == -1) {
            i10 = 0;
        }
        if (flexLines.size() > i10) {
            flexLines.subList(i10, flexLines.size()).clear();
        }
        int[] iArr = this.f19425c;
        int length = iArr.length - 1;
        if (fromFlexItem > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, fromFlexItem, length, -1);
        }
        long[] jArr = this.f19426d;
        int length2 = jArr.length - 1;
        if (fromFlexItem > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, fromFlexItem, length2, 0L);
        }
    }

    public final List<f> k(List<f> flexLines, int size, int totalCrossSize) {
        int i10 = (size - totalCrossSize) / 2;
        ArrayList arrayList = new ArrayList();
        f fVar = new f();
        fVar.f19407g = i10;
        int size2 = flexLines.size();
        for (int i11 = 0; i11 < size2; i11++) {
            if (i11 == 0) {
                arrayList.add(fVar);
            }
            arrayList.add(flexLines.get(i11));
            if (i11 == flexLines.size() - 1) {
                arrayList.add(fVar);
            }
        }
        return arrayList;
    }

    @n0
    public final List<c> l(int childCount) {
        ArrayList arrayList = new ArrayList(childCount);
        for (int i10 = 0; i10 < childCount; i10++) {
            FlexItem flexItem = (FlexItem) this.f19423a.h(i10).getLayoutParams();
            c cVar = new c();
            cVar.f19431b = flexItem.getOrder();
            cVar.f19430a = i10;
            arrayList.add(cVar);
        }
        return arrayList;
    }

    public int[] m(SparseIntArray orderCache) {
        int flexItemCount = this.f19423a.getFlexItemCount();
        return U(flexItemCount, l(flexItemCount), orderCache);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int[] n(View viewBeforeAdded, int indexForViewBeforeAdded, ViewGroup.LayoutParams paramsForViewBeforeAdded, SparseIntArray orderCache) {
        int flexItemCount = this.f19423a.getFlexItemCount();
        List<c> listL = l(flexItemCount);
        c cVar = new c();
        if (viewBeforeAdded == null || !(paramsForViewBeforeAdded instanceof FlexItem)) {
            cVar.f19431b = 1;
        } else {
            cVar.f19431b = ((FlexItem) paramsForViewBeforeAdded).getOrder();
        }
        if (indexForViewBeforeAdded == -1 || indexForViewBeforeAdded == flexItemCount || indexForViewBeforeAdded >= this.f19423a.getFlexItemCount()) {
            cVar.f19430a = flexItemCount;
        } else {
            cVar.f19430a = indexForViewBeforeAdded;
            while (indexForViewBeforeAdded < flexItemCount) {
                listL.get(indexForViewBeforeAdded).f19430a++;
                indexForViewBeforeAdded++;
            }
        }
        listL.add(cVar);
        return U(flexItemCount + 1, listL, orderCache);
    }

    public void o(int widthMeasureSpec, int heightMeasureSpec, int paddingAlongCrossAxis) {
        int mode;
        int size;
        int flexDirection = this.f19423a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
            int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
            mode = mode2;
            size = size2;
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            mode = View.MeasureSpec.getMode(widthMeasureSpec);
            size = View.MeasureSpec.getSize(widthMeasureSpec);
        }
        List<f> flexLinesInternal = this.f19423a.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.f19423a.getSumOfCrossSize() + paddingAlongCrossAxis;
            int i10 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).f19407g = size - paddingAlongCrossAxis;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.f19423a.getAlignContent();
                if (alignContent == 1) {
                    int i11 = size - sumOfCrossSize;
                    f fVar = new f();
                    fVar.f19407g = i11;
                    flexLinesInternal.add(0, fVar);
                    return;
                }
                if (alignContent == 2) {
                    this.f19423a.setFlexLines(k(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize >= size) {
                        return;
                    }
                    float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size4 = flexLinesInternal.size();
                    float f10 = 0.0f;
                    while (i10 < size4) {
                        arrayList.add(flexLinesInternal.get(i10));
                        if (i10 != flexLinesInternal.size() - 1) {
                            f fVar2 = new f();
                            if (i10 == flexLinesInternal.size() - 2) {
                                fVar2.f19407g = Math.round(f10 + size3);
                                f10 = 0.0f;
                            } else {
                                fVar2.f19407g = Math.round(size3);
                            }
                            int i12 = fVar2.f19407g;
                            f10 += size3 - i12;
                            if (f10 > 1.0f) {
                                fVar2.f19407g = i12 + 1;
                                f10 -= 1.0f;
                            } else if (f10 < -1.0f) {
                                fVar2.f19407g = i12 - 1;
                                f10 += 1.0f;
                            }
                            arrayList.add(fVar2);
                        }
                        i10++;
                    }
                    this.f19423a.setFlexLines(arrayList);
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.f19423a.setFlexLines(k(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    f fVar3 = new f();
                    fVar3.f19407g = size5;
                    for (f fVar4 : flexLinesInternal) {
                        arrayList2.add(fVar3);
                        arrayList2.add(fVar4);
                        arrayList2.add(fVar3);
                    }
                    this.f19423a.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f11 = 0.0f;
                    while (i10 < size7) {
                        f fVar5 = flexLinesInternal.get(i10);
                        float f12 = fVar5.f19407g + size6;
                        if (i10 == flexLinesInternal.size() - 1) {
                            f12 += f11;
                            f11 = 0.0f;
                        }
                        int iRound = Math.round(f12);
                        f11 += f12 - iRound;
                        if (f11 > 1.0f) {
                            iRound++;
                            f11 -= 1.0f;
                        } else if (f11 < -1.0f) {
                            iRound--;
                            f11 += 1.0f;
                        }
                        fVar5.f19407g = iRound;
                        i10++;
                    }
                }
            }
        }
    }

    public void p(int widthMeasureSpec, int heightMeasureSpec) {
        q(widthMeasureSpec, heightMeasureSpec, 0);
    }

    public void q(int widthMeasureSpec, int heightMeasureSpec, int fromIndex) {
        int size;
        int paddingLeft;
        int paddingRight;
        r(this.f19423a.getFlexItemCount());
        if (fromIndex >= this.f19423a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f19423a.getFlexDirection();
        int flexDirection2 = this.f19423a.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(widthMeasureSpec);
            size = View.MeasureSpec.getSize(widthMeasureSpec);
            int largestMainSize = this.f19423a.getLargestMainSize();
            if (mode != 1073741824) {
                size = Math.min(largestMainSize, size);
            }
            paddingLeft = this.f19423a.getPaddingLeft();
            paddingRight = this.f19423a.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
            size = View.MeasureSpec.getSize(heightMeasureSpec);
            if (mode2 != 1073741824) {
                size = this.f19423a.getLargestMainSize();
            }
            paddingLeft = this.f19423a.getPaddingTop();
            paddingRight = this.f19423a.getPaddingBottom();
        }
        int i10 = paddingLeft + paddingRight;
        int[] iArr = this.f19425c;
        int i11 = iArr != null ? iArr[fromIndex] : 0;
        List<f> flexLinesInternal = this.f19423a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i12 = i11; i12 < size2; i12++) {
            f fVar = flexLinesInternal.get(i12);
            int i13 = fVar.f19405e;
            if (i13 < size && fVar.f19417q) {
                w(widthMeasureSpec, heightMeasureSpec, fVar, size, i10, false);
            } else if (i13 > size && fVar.f19418r) {
                T(widthMeasureSpec, heightMeasureSpec, fVar, size, i10, false);
            }
        }
    }

    public final void r(int size) {
        boolean[] zArr = this.f19424b;
        if (zArr == null) {
            this.f19424b = new boolean[Math.max(size, 10)];
        } else if (zArr.length < size) {
            this.f19424b = new boolean[Math.max(zArr.length * 2, size)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    public void s(int size) {
        int[] iArr = this.f19425c;
        if (iArr == null) {
            this.f19425c = new int[Math.max(size, 10)];
        } else if (iArr.length < size) {
            this.f19425c = Arrays.copyOf(this.f19425c, Math.max(iArr.length * 2, size));
        }
    }

    public void t(int size) {
        long[] jArr = this.f19426d;
        if (jArr == null) {
            this.f19426d = new long[Math.max(size, 10)];
        } else if (jArr.length < size) {
            this.f19426d = Arrays.copyOf(this.f19426d, Math.max(jArr.length * 2, size));
        }
    }

    public void u(int size) {
        long[] jArr = this.f19427e;
        if (jArr == null) {
            this.f19427e = new long[Math.max(size, 10)];
        } else if (jArr.length < size) {
            this.f19427e = Arrays.copyOf(this.f19427e, Math.max(jArr.length * 2, size));
        }
    }

    public final void v(CompoundButton compoundButton) {
        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
        int iP = flexItem.p();
        int iK = flexItem.K();
        Drawable drawableA = androidx.core.widget.d.a(compoundButton);
        int minimumWidth = drawableA == null ? 0 : drawableA.getMinimumWidth();
        int minimumHeight = drawableA != null ? drawableA.getMinimumHeight() : 0;
        if (iP == -1) {
            iP = minimumWidth;
        }
        flexItem.r(iP);
        if (iK == -1) {
            iK = minimumHeight;
        }
        flexItem.y(iK);
    }

    public final void w(int widthMeasureSpec, int heightMeasureSpec, f flexLine, int maxMainSize, int paddingAlongMainAxis, boolean calledRecursively) {
        int i10;
        int i11;
        int iMax;
        double d10;
        int i12;
        double d11;
        float f10 = flexLine.f19410j;
        float f11 = 0.0f;
        if (f10 <= 0.0f || maxMainSize < (i10 = flexLine.f19405e)) {
            return;
        }
        float f12 = (maxMainSize - i10) / f10;
        flexLine.f19405e = paddingAlongMainAxis + flexLine.f19406f;
        if (!calledRecursively) {
            flexLine.f19407g = Integer.MIN_VALUE;
        }
        int i13 = 0;
        boolean z10 = false;
        int i14 = 0;
        float f13 = 0.0f;
        while (i13 < flexLine.f19408h) {
            int i15 = flexLine.f19415o + i13;
            View viewD = this.f19423a.d(i15);
            if (viewD == null || viewD.getVisibility() == 8) {
                i11 = i10;
            } else {
                FlexItem flexItem = (FlexItem) viewD.getLayoutParams();
                int flexDirection = this.f19423a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i16 = i10;
                    int measuredWidth = viewD.getMeasuredWidth();
                    long[] jArr = this.f19427e;
                    if (jArr != null) {
                        measuredWidth = y(jArr[i15]);
                    }
                    int measuredHeight = viewD.getMeasuredHeight();
                    long[] jArr2 = this.f19427e;
                    i11 = i16;
                    if (jArr2 != null) {
                        measuredHeight = x(jArr2[i15]);
                    }
                    if (!this.f19424b[i15] && flexItem.A() > 0.0f) {
                        float fA = measuredWidth + (flexItem.A() * f12);
                        if (i13 == flexLine.f19408h - 1) {
                            fA += f13;
                            f13 = 0.0f;
                        }
                        int iRound = Math.round(fA);
                        if (iRound > flexItem.R()) {
                            iRound = flexItem.R();
                            this.f19424b[i15] = true;
                            flexLine.f19410j -= flexItem.A();
                            z10 = true;
                        } else {
                            f13 += fA - iRound;
                            double d12 = f13;
                            if (d12 > 1.0d) {
                                iRound++;
                                d10 = d12 - 1.0d;
                            } else if (d12 < -1.0d) {
                                iRound--;
                                d10 = d12 + 1.0d;
                            }
                            f13 = (float) d10;
                        }
                        int iZ = z(heightMeasureSpec, flexItem, flexLine.f19413m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, 1073741824);
                        viewD.measure(iMakeMeasureSpec, iZ);
                        int measuredWidth2 = viewD.getMeasuredWidth();
                        int measuredHeight2 = viewD.getMeasuredHeight();
                        Z(i15, iMakeMeasureSpec, iZ, viewD);
                        this.f19423a.f(i15, viewD);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i14, measuredHeight + flexItem.x() + flexItem.t() + this.f19423a.l(viewD));
                    flexLine.f19405e += measuredWidth + flexItem.u() + flexItem.I();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewD.getMeasuredHeight();
                    long[] jArr3 = this.f19427e;
                    if (jArr3 != null) {
                        measuredHeight3 = x(jArr3[i15]);
                    }
                    int measuredWidth3 = viewD.getMeasuredWidth();
                    long[] jArr4 = this.f19427e;
                    if (jArr4 != null) {
                        measuredWidth3 = y(jArr4[i15]);
                    }
                    if (this.f19424b[i15] || flexItem.A() <= f11) {
                        i12 = i10;
                    } else {
                        float fA2 = measuredHeight3 + (flexItem.A() * f12);
                        if (i13 == flexLine.f19408h - 1) {
                            fA2 += f13;
                            f13 = 0.0f;
                        }
                        int iRound2 = Math.round(fA2);
                        if (iRound2 > flexItem.N()) {
                            iRound2 = flexItem.N();
                            this.f19424b[i15] = true;
                            flexLine.f19410j -= flexItem.A();
                            i12 = i10;
                            z10 = true;
                        } else {
                            f13 += fA2 - iRound2;
                            i12 = i10;
                            double d13 = f13;
                            if (d13 > 1.0d) {
                                iRound2++;
                                d11 = d13 - 1.0d;
                            } else if (d13 < -1.0d) {
                                iRound2--;
                                d11 = d13 + 1.0d;
                            }
                            f13 = (float) d11;
                        }
                        int iA = A(widthMeasureSpec, flexItem, flexLine.f19413m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, 1073741824);
                        viewD.measure(iA, iMakeMeasureSpec2);
                        measuredWidth3 = viewD.getMeasuredWidth();
                        int measuredHeight4 = viewD.getMeasuredHeight();
                        Z(i15, iA, iMakeMeasureSpec2, viewD);
                        this.f19423a.f(i15, viewD);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i14, measuredWidth3 + flexItem.u() + flexItem.I() + this.f19423a.l(viewD));
                    flexLine.f19405e += measuredHeight3 + flexItem.x() + flexItem.t();
                    i11 = i12;
                }
                flexLine.f19407g = Math.max(flexLine.f19407g, iMax);
                i14 = iMax;
            }
            i13++;
            i10 = i11;
            f11 = 0.0f;
        }
        int i17 = i10;
        if (!z10 || i17 == flexLine.f19405e) {
            return;
        }
        w(widthMeasureSpec, heightMeasureSpec, flexLine, maxMainSize, paddingAlongMainAxis, true);
    }

    public int x(long longValue) {
        return (int) (longValue >> 32);
    }

    public int y(long longValue) {
        return (int) longValue;
    }

    public final int z(int heightMeasureSpec, FlexItem flexItem, int padding) {
        d dVar = this.f19423a;
        int iJ = dVar.j(heightMeasureSpec, dVar.getPaddingTop() + this.f19423a.getPaddingBottom() + flexItem.x() + flexItem.t() + padding, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(iJ);
        return size > flexItem.N() ? View.MeasureSpec.makeMeasureSpec(flexItem.N(), View.MeasureSpec.getMode(iJ)) : size < flexItem.K() ? View.MeasureSpec.makeMeasureSpec(flexItem.K(), View.MeasureSpec.getMode(iJ)) : iJ;
    }
}
