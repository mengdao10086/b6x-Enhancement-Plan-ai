package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.u0;
import com.google.android.flexbox.h;
import g.p0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FlexboxLayout extends ViewGroup implements d {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f19323r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f19324s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f19325t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f19326u = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f19328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f19329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f19330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f19331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f19332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public Drawable f19333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public Drawable f19334h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f19335i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f19336j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f19337k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f19338l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int[] f19339m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SparseIntArray f19340n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public h f19341o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List<f> f19342p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public h.b f19343q;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public final void A() {
        if (this.f19333g == null && this.f19334h == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    public final boolean a(int flexLineIndex) {
        for (int i10 = 0; i10 < flexLineIndex; i10++) {
            if (this.f19342p.get(i10).d() > 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (this.f19340n == null) {
            this.f19340n = new SparseIntArray(getChildCount());
        }
        this.f19339m = this.f19341o.n(child, index, params, this.f19340n);
        super.addView(child, index, params);
    }

    @Override // com.google.android.flexbox.d
    public void b(View view, int index, int indexInFlexLine, f flexLine) {
        if (s(index, indexInFlexLine)) {
            if (k()) {
                int i10 = flexLine.f19405e;
                int i11 = this.f19338l;
                flexLine.f19405e = i10 + i11;
                flexLine.f19406f += i11;
                return;
            }
            int i12 = flexLine.f19405e;
            int i13 = this.f19337k;
            flexLine.f19405e = i12 + i13;
            flexLine.f19406f += i13;
        }
    }

    @Override // com.google.android.flexbox.d
    public void c(f flexLine) {
        if (k()) {
            if ((this.f19336j & 4) > 0) {
                int i10 = flexLine.f19405e;
                int i11 = this.f19338l;
                flexLine.f19405e = i10 + i11;
                flexLine.f19406f += i11;
                return;
            }
            return;
        }
        if ((this.f19335i & 4) > 0) {
            int i12 = flexLine.f19405e;
            int i13 = this.f19337k;
            flexLine.f19405e = i12 + i13;
            flexLine.f19406f += i13;
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams p10) {
        return p10 instanceof LayoutParams;
    }

    @Override // com.google.android.flexbox.d
    public View d(int index) {
        return r(index);
    }

    @Override // com.google.android.flexbox.d
    public int e(int widthSpec, int padding, int childDimension) {
        return ViewGroup.getChildMeasureSpec(widthSpec, padding, childDimension);
    }

    @Override // com.google.android.flexbox.d
    public void f(int position, View view) {
    }

    public final boolean g(int index, int indexInFlexLine) {
        for (int i10 = 1; i10 <= indexInFlexLine; i10++) {
            View viewR = r(index - i10);
            if (viewR != null && viewR.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.flexbox.d
    public int getAlignContent() {
        return this.f19331e;
    }

    @Override // com.google.android.flexbox.d
    public int getAlignItems() {
        return this.f19330d;
    }

    @p0
    public Drawable getDividerDrawableHorizontal() {
        return this.f19333g;
    }

    @p0
    public Drawable getDividerDrawableVertical() {
        return this.f19334h;
    }

    @Override // com.google.android.flexbox.d
    public int getFlexDirection() {
        return this.f19327a;
    }

    @Override // com.google.android.flexbox.d
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.google.android.flexbox.d
    public List<f> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.f19342p.size());
        for (f fVar : this.f19342p) {
            if (fVar.d() != 0) {
                arrayList.add(fVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.d
    public List<f> getFlexLinesInternal() {
        return this.f19342p;
    }

    @Override // com.google.android.flexbox.d
    public int getFlexWrap() {
        return this.f19328b;
    }

    @Override // com.google.android.flexbox.d
    public int getJustifyContent() {
        return this.f19329c;
    }

    @Override // com.google.android.flexbox.d
    public int getLargestMainSize() {
        Iterator<f> it2 = this.f19342p.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it2.hasNext()) {
            iMax = Math.max(iMax, it2.next().f19405e);
        }
        return iMax;
    }

    @Override // com.google.android.flexbox.d
    public int getMaxLine() {
        return this.f19332f;
    }

    public int getShowDividerHorizontal() {
        return this.f19335i;
    }

    public int getShowDividerVertical() {
        return this.f19336j;
    }

    @Override // com.google.android.flexbox.d
    public int getSumOfCrossSize() {
        int size = this.f19342p.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            f fVar = this.f19342p.get(i11);
            if (t(i11)) {
                i10 += k() ? this.f19337k : this.f19338l;
            }
            if (u(i11)) {
                i10 += k() ? this.f19337k : this.f19338l;
            }
            i10 += fVar.f19407g;
        }
        return i10;
    }

    @Override // com.google.android.flexbox.d
    public View h(int index) {
        return getChildAt(index);
    }

    @Override // com.google.android.flexbox.d
    public int i(View view, int index, int indexInFlexLine) {
        int i10;
        int i11;
        if (k()) {
            i10 = s(index, indexInFlexLine) ? 0 + this.f19338l : 0;
            if ((this.f19336j & 4) <= 0) {
                return i10;
            }
            i11 = this.f19338l;
        } else {
            i10 = s(index, indexInFlexLine) ? 0 + this.f19337k : 0;
            if ((this.f19335i & 4) <= 0) {
                return i10;
            }
            i11 = this.f19337k;
        }
        return i10 + i11;
    }

    @Override // com.google.android.flexbox.d
    public int j(int heightSpec, int padding, int childDimension) {
        return ViewGroup.getChildMeasureSpec(heightSpec, padding, childDimension);
    }

    @Override // com.google.android.flexbox.d
    public boolean k() {
        int i10 = this.f19327a;
        return i10 == 0 || i10 == 1;
    }

    @Override // com.google.android.flexbox.d
    public int l(View view) {
        return 0;
    }

    public final void m(Canvas canvas, boolean isRtl, boolean fromBottomToTop) {
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.f19342p.size();
        for (int i10 = 0; i10 < size; i10++) {
            f fVar = this.f19342p.get(i10);
            for (int i11 = 0; i11 < fVar.f19408h; i11++) {
                int i12 = fVar.f19415o + i11;
                View viewR = r(i12);
                if (viewR != null && viewR.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) viewR.getLayoutParams();
                    if (s(i12, i11)) {
                        p(canvas, isRtl ? viewR.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : (viewR.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f19338l, fVar.f19402b, fVar.f19407g);
                    }
                    if (i11 == fVar.f19408h - 1 && (this.f19336j & 4) > 0) {
                        p(canvas, isRtl ? (viewR.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f19338l : viewR.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, fVar.f19402b, fVar.f19407g);
                    }
                }
            }
            if (t(i10)) {
                o(canvas, paddingLeft, fromBottomToTop ? fVar.f19404d : fVar.f19402b - this.f19337k, iMax);
            }
            if (u(i10) && (this.f19335i & 4) > 0) {
                o(canvas, paddingLeft, fromBottomToTop ? fVar.f19402b - this.f19337k : fVar.f19404d, iMax);
            }
        }
    }

    public final void n(Canvas canvas, boolean isRtl, boolean fromBottomToTop) {
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.f19342p.size();
        for (int i10 = 0; i10 < size; i10++) {
            f fVar = this.f19342p.get(i10);
            for (int i11 = 0; i11 < fVar.f19408h; i11++) {
                int i12 = fVar.f19415o + i11;
                View viewR = r(i12);
                if (viewR != null && viewR.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) viewR.getLayoutParams();
                    if (s(i12, i11)) {
                        o(canvas, fVar.f19401a, fromBottomToTop ? viewR.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : (viewR.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f19337k, fVar.f19407g);
                    }
                    if (i11 == fVar.f19408h - 1 && (this.f19335i & 4) > 0) {
                        o(canvas, fVar.f19401a, fromBottomToTop ? (viewR.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f19337k : viewR.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, fVar.f19407g);
                    }
                }
            }
            if (t(i10)) {
                p(canvas, isRtl ? fVar.f19403c : fVar.f19401a - this.f19338l, paddingTop, iMax);
            }
            if (u(i10) && (this.f19336j & 4) > 0) {
                p(canvas, isRtl ? fVar.f19401a - this.f19338l : fVar.f19403c, paddingTop, iMax);
            }
        }
    }

    public final void o(Canvas canvas, int left, int top2, int length) {
        Drawable drawable = this.f19333g;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(left, top2, length + left, this.f19337k + top2);
        this.f19333g.draw(canvas);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f19334h == null && this.f19333g == null) {
            return;
        }
        if (this.f19335i == 0 && this.f19336j == 0) {
            return;
        }
        int iZ = u0.Z(this);
        int i10 = this.f19327a;
        if (i10 == 0) {
            m(canvas, iZ == 1, this.f19328b == 2);
            return;
        }
        if (i10 == 1) {
            m(canvas, iZ != 1, this.f19328b == 2);
            return;
        }
        if (i10 == 2) {
            boolean z10 = iZ == 1;
            if (this.f19328b == 2) {
                z10 = !z10;
            }
            n(canvas, z10, false);
            return;
        }
        if (i10 != 3) {
            return;
        }
        boolean z11 = iZ == 1;
        if (this.f19328b == 2) {
            z11 = !z11;
        }
        n(canvas, z11, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top2, int right, int bottom) {
        boolean z10;
        int iZ = u0.Z(this);
        int i10 = this.f19327a;
        if (i10 == 0) {
            v(iZ == 1, left, top2, right, bottom);
            return;
        }
        if (i10 == 1) {
            v(iZ != 1, left, top2, right, bottom);
            return;
        }
        if (i10 == 2) {
            z10 = iZ == 1;
            w(this.f19328b == 2 ? !z10 : z10, false, left, top2, right, bottom);
        } else if (i10 == 3) {
            z10 = iZ == 1;
            w(this.f19328b == 2 ? !z10 : z10, true, left, top2, right, bottom);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.f19327a);
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.f19340n == null) {
            this.f19340n = new SparseIntArray(getChildCount());
        }
        if (this.f19341o.O(this.f19340n)) {
            this.f19339m = this.f19341o.m(this.f19340n);
        }
        int i10 = this.f19327a;
        if (i10 == 0 || i10 == 1) {
            x(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        if (i10 == 2 || i10 == 3) {
            y(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        throw new IllegalStateException("Invalid value for the flex direction is set: " + this.f19327a);
    }

    public final void p(Canvas canvas, int left, int top2, int length) {
        Drawable drawable = this.f19334h;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(left, top2, this.f19338l + left, length + top2);
        this.f19334h.draw(canvas);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    public View r(int index) {
        if (index < 0) {
            return null;
        }
        int[] iArr = this.f19339m;
        if (index >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[index]);
    }

    public final boolean s(int index, int indexInFlexLine) {
        return g(index, indexInFlexLine) ? k() ? (this.f19336j & 1) != 0 : (this.f19335i & 1) != 0 : k() ? (this.f19336j & 2) != 0 : (this.f19335i & 2) != 0;
    }

    @Override // com.google.android.flexbox.d
    public void setAlignContent(int alignContent) {
        if (this.f19331e != alignContent) {
            this.f19331e = alignContent;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.d
    public void setAlignItems(int alignItems) {
        if (this.f19330d != alignItems) {
            this.f19330d = alignItems;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable divider) {
        setDividerDrawableHorizontal(divider);
        setDividerDrawableVertical(divider);
    }

    public void setDividerDrawableHorizontal(@p0 Drawable divider) {
        if (divider == this.f19333g) {
            return;
        }
        this.f19333g = divider;
        if (divider != null) {
            this.f19337k = divider.getIntrinsicHeight();
        } else {
            this.f19337k = 0;
        }
        A();
        requestLayout();
    }

    public void setDividerDrawableVertical(@p0 Drawable divider) {
        if (divider == this.f19334h) {
            return;
        }
        this.f19334h = divider;
        if (divider != null) {
            this.f19338l = divider.getIntrinsicWidth();
        } else {
            this.f19338l = 0;
        }
        A();
        requestLayout();
    }

    @Override // com.google.android.flexbox.d
    public void setFlexDirection(int flexDirection) {
        if (this.f19327a != flexDirection) {
            this.f19327a = flexDirection;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.d
    public void setFlexLines(List<f> flexLines) {
        this.f19342p = flexLines;
    }

    @Override // com.google.android.flexbox.d
    public void setFlexWrap(int flexWrap) {
        if (this.f19328b != flexWrap) {
            this.f19328b = flexWrap;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.d
    public void setJustifyContent(int justifyContent) {
        if (this.f19329c != justifyContent) {
            this.f19329c = justifyContent;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.d
    public void setMaxLine(int maxLine) {
        if (this.f19332f != maxLine) {
            this.f19332f = maxLine;
            requestLayout();
        }
    }

    public void setShowDivider(int dividerMode) {
        setShowDividerVertical(dividerMode);
        setShowDividerHorizontal(dividerMode);
    }

    public void setShowDividerHorizontal(int dividerMode) {
        if (dividerMode != this.f19335i) {
            this.f19335i = dividerMode;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int dividerMode) {
        if (dividerMode != this.f19336j) {
            this.f19336j = dividerMode;
            requestLayout();
        }
    }

    public final boolean t(int flexLineIndex) {
        if (flexLineIndex < 0 || flexLineIndex >= this.f19342p.size()) {
            return false;
        }
        return a(flexLineIndex) ? k() ? (this.f19335i & 1) != 0 : (this.f19336j & 1) != 0 : k() ? (this.f19335i & 2) != 0 : (this.f19336j & 2) != 0;
    }

    public final boolean u(int flexLineIndex) {
        if (flexLineIndex < 0 || flexLineIndex >= this.f19342p.size()) {
            return false;
        }
        for (int i10 = flexLineIndex + 1; i10 < this.f19342p.size(); i10++) {
            if (this.f19342p.get(i10).d() > 0) {
                return false;
            }
        }
        return k() ? (this.f19335i & 4) != 0 : (this.f19336j & 4) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(boolean r29, int r30, int r31, int r32, int r33) {
        /*
            Method dump skipped, instruction units count: 544
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.v(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(boolean r30, boolean r31, int r32, int r33, int r34, int r35) {
        /*
            Method dump skipped, instruction units count: 532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.w(boolean, boolean, int, int, int, int):void");
    }

    public final void x(int widthMeasureSpec, int heightMeasureSpec) {
        this.f19342p.clear();
        this.f19343q.a();
        this.f19341o.c(this.f19343q, widthMeasureSpec, heightMeasureSpec);
        this.f19342p = this.f19343q.f19428a;
        this.f19341o.p(widthMeasureSpec, heightMeasureSpec);
        if (this.f19330d == 3) {
            for (f fVar : this.f19342p) {
                int iMax = Integer.MIN_VALUE;
                for (int i10 = 0; i10 < fVar.f19408h; i10++) {
                    View viewR = r(fVar.f19415o + i10);
                    if (viewR != null && viewR.getVisibility() != 8) {
                        LayoutParams layoutParams = (LayoutParams) viewR.getLayoutParams();
                        iMax = this.f19328b != 2 ? Math.max(iMax, viewR.getMeasuredHeight() + Math.max(fVar.f19412l - viewR.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) : Math.max(iMax, viewR.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + Math.max((fVar.f19412l - viewR.getMeasuredHeight()) + viewR.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
                    }
                }
                fVar.f19407g = iMax;
            }
        }
        this.f19341o.o(widthMeasureSpec, heightMeasureSpec, getPaddingTop() + getPaddingBottom());
        this.f19341o.X();
        z(this.f19327a, widthMeasureSpec, heightMeasureSpec, this.f19343q.f19429b);
    }

    public final void y(int widthMeasureSpec, int heightMeasureSpec) {
        this.f19342p.clear();
        this.f19343q.a();
        this.f19341o.f(this.f19343q, widthMeasureSpec, heightMeasureSpec);
        this.f19342p = this.f19343q.f19428a;
        this.f19341o.p(widthMeasureSpec, heightMeasureSpec);
        this.f19341o.o(widthMeasureSpec, heightMeasureSpec, getPaddingLeft() + getPaddingRight());
        this.f19341o.X();
        z(this.f19327a, widthMeasureSpec, heightMeasureSpec, this.f19343q.f19429b);
    }

    public final void z(int flexDirection, int widthMeasureSpec, int heightMeasureSpec, int childState) {
        int sumOfCrossSize;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (flexDirection == 0 || flexDirection == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                childState = View.combineMeasuredStates(childState, 16777216);
            } else {
                size = largestMainSize;
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, widthMeasureSpec, childState);
        } else if (mode == 0) {
            iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, widthMeasureSpec, childState);
        } else {
            if (mode != 1073741824) {
                throw new IllegalStateException("Unknown width mode is set: " + mode);
            }
            if (size < largestMainSize) {
                childState = View.combineMeasuredStates(childState, 16777216);
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, widthMeasureSpec, childState);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                childState = View.combineMeasuredStates(childState, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, heightMeasureSpec, childState);
        } else if (mode2 == 0) {
            iResolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, heightMeasureSpec, childState);
        } else {
            if (mode2 != 1073741824) {
                throw new IllegalStateException("Unknown height mode is set: " + mode2);
            }
            if (size2 < sumOfCrossSize) {
                childState = View.combineMeasuredStates(childState, 256);
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, heightMeasureSpec, childState);
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    public FlexboxLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp2) {
        return lp2 instanceof LayoutParams ? new LayoutParams((LayoutParams) lp2) : lp2 instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) lp2) : new LayoutParams(lp2);
    }

    public FlexboxLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f19332f = -1;
        this.f19341o = new h(this);
        this.f19342p = new ArrayList();
        this.f19343q = new h.b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.FlexboxLayout, defStyleAttr, 0);
        this.f19327a = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexDirection, 0);
        this.f19328b = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexWrap, 0);
        this.f19329c = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_justifyContent, 0);
        this.f19330d = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignItems, 0);
        this.f19331e = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignContent, 0);
        this.f19332f = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_maxLine, -1);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i10 = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDivider, 0);
        if (i10 != 0) {
            this.f19336j = i10;
            this.f19335i = i10;
        }
        int i11 = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerVertical, 0);
        if (i11 != 0) {
            this.f19336j = i11;
        }
        int i12 = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i12 != 0) {
            this.f19335i = i12;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f19345b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f19346c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f19347d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f19348e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f19349f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f19350g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f19351h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f19352i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f19353j;

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

        public LayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);
            this.f19344a = 1;
            this.f19345b = 0.0f;
            this.f19346c = 1.0f;
            this.f19347d = -1;
            this.f19348e = -1.0f;
            this.f19349f = -1;
            this.f19350g = -1;
            this.f19351h = 16777215;
            this.f19352i = 16777215;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.FlexboxLayout_Layout);
            this.f19344a = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_order, 1);
            this.f19345b = typedArrayObtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.f19346c = typedArrayObtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.f19347d = typedArrayObtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.f19348e = typedArrayObtainStyledAttributes.getFraction(R.styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.f19349f = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minWidth, -1);
            this.f19350g = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minHeight, -1);
            this.f19351h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxWidth, 16777215);
            this.f19352i = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxHeight, 16777215);
            this.f19353j = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // com.google.android.flexbox.FlexItem
        public float A() {
            return this.f19345b;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float E() {
            return this.f19348e;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int I() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int K() {
            return this.f19350g;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean L() {
            return this.f19353j;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int N() {
            return this.f19352i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void Q(int alignSelf) {
            this.f19347d = alignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int R() {
            return this.f19351h;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void c(float flexGrow) {
            this.f19345b = flexGrow;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void f(float flexBasisPercent) {
            this.f19348e = flexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return this.f19344a;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void k(int order) {
            this.f19344a = order;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int l() {
            return this.f19347d;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float m() {
            return this.f19346c;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void o(boolean wrapBefore) {
            this.f19353j = wrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int p() {
            return this.f19349f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void q(float flexShrink) {
            this.f19346c = flexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void r(int minWidth) {
            this.f19349f = minWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setHeight(int height) {
            ((ViewGroup.MarginLayoutParams) this).height = height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxHeight(int maxHeight) {
            this.f19352i = maxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxWidth(int maxWidth) {
            this.f19351h = maxWidth;
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
            parcel.writeInt(this.f19344a);
            parcel.writeFloat(this.f19345b);
            parcel.writeFloat(this.f19346c);
            parcel.writeInt(this.f19347d);
            parcel.writeFloat(this.f19348e);
            parcel.writeInt(this.f19349f);
            parcel.writeInt(this.f19350g);
            parcel.writeInt(this.f19351h);
            parcel.writeInt(this.f19352i);
            parcel.writeByte(this.f19353j ? (byte) 1 : (byte) 0);
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
            this.f19350g = minHeight;
        }

        public LayoutParams(LayoutParams source) {
            super((ViewGroup.MarginLayoutParams) source);
            this.f19344a = 1;
            this.f19345b = 0.0f;
            this.f19346c = 1.0f;
            this.f19347d = -1;
            this.f19348e = -1.0f;
            this.f19349f = -1;
            this.f19350g = -1;
            this.f19351h = 16777215;
            this.f19352i = 16777215;
            this.f19344a = source.f19344a;
            this.f19345b = source.f19345b;
            this.f19346c = source.f19346c;
            this.f19347d = source.f19347d;
            this.f19348e = source.f19348e;
            this.f19349f = source.f19349f;
            this.f19350g = source.f19350g;
            this.f19351h = source.f19351h;
            this.f19352i = source.f19352i;
            this.f19353j = source.f19353j;
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
            this.f19344a = 1;
            this.f19345b = 0.0f;
            this.f19346c = 1.0f;
            this.f19347d = -1;
            this.f19348e = -1.0f;
            this.f19349f = -1;
            this.f19350g = -1;
            this.f19351h = 16777215;
            this.f19352i = 16777215;
        }

        public LayoutParams(int width, int height) {
            super(new ViewGroup.LayoutParams(width, height));
            this.f19344a = 1;
            this.f19345b = 0.0f;
            this.f19346c = 1.0f;
            this.f19347d = -1;
            this.f19348e = -1.0f;
            this.f19349f = -1;
            this.f19350g = -1;
            this.f19351h = 16777215;
            this.f19352i = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
            this.f19344a = 1;
            this.f19345b = 0.0f;
            this.f19346c = 1.0f;
            this.f19347d = -1;
            this.f19348e = -1.0f;
            this.f19349f = -1;
            this.f19350g = -1;
            this.f19351h = 16777215;
            this.f19352i = 16777215;
        }

        public LayoutParams(Parcel in2) {
            super(0, 0);
            this.f19344a = 1;
            this.f19345b = 0.0f;
            this.f19346c = 1.0f;
            this.f19347d = -1;
            this.f19348e = -1.0f;
            this.f19349f = -1;
            this.f19350g = -1;
            this.f19351h = 16777215;
            this.f19352i = 16777215;
            this.f19344a = in2.readInt();
            this.f19345b = in2.readFloat();
            this.f19346c = in2.readFloat();
            this.f19347d = in2.readInt();
            this.f19348e = in2.readFloat();
            this.f19349f = in2.readInt();
            this.f19350g = in2.readInt();
            this.f19351h = in2.readInt();
            this.f19352i = in2.readInt();
            this.f19353j = in2.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = in2.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = in2.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = in2.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = in2.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = in2.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = in2.readInt();
        }
    }
}
