package com.google.android.flexbox;

import a.ou;
import a.pu;
import a.qu;
import a.su;
import a.uu;
import a.xu;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class FlexboxLayout extends ViewGroup implements ou {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8264a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public su.a f4500a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public su f4501a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f4502a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SparseIntArray f4503a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<qu> f4504a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f4505a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Drawable f4506b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;

    public static class a extends ViewGroup.MarginLayoutParams implements pu {
        public static final Parcelable.Creator<a> CREATOR = new uu();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f8265a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f4507a;
        public float b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public int f4508b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f4509b;
        public float c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public int f4510c;
        public int d;
        public int e;
        public int f;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4507a = 1;
            this.f8265a = 0.0f;
            this.b = 1.0f;
            this.f4508b = -1;
            this.c = -1.0f;
            this.f4510c = -1;
            this.d = -1;
            this.e = 16777215;
            this.f = 16777215;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, xu.FlexboxLayout_Layout);
            this.f4507a = typedArrayObtainStyledAttributes.getInt(xu.FlexboxLayout_Layout_layout_order, 1);
            this.f8265a = typedArrayObtainStyledAttributes.getFloat(xu.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.b = typedArrayObtainStyledAttributes.getFloat(xu.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.f4508b = typedArrayObtainStyledAttributes.getInt(xu.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.c = typedArrayObtainStyledAttributes.getFraction(xu.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.f4510c = typedArrayObtainStyledAttributes.getDimensionPixelSize(xu.FlexboxLayout_Layout_layout_minWidth, -1);
            this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(xu.FlexboxLayout_Layout_layout_minHeight, -1);
            this.e = typedArrayObtainStyledAttributes.getDimensionPixelSize(xu.FlexboxLayout_Layout_layout_maxWidth, 16777215);
            this.f = typedArrayObtainStyledAttributes.getDimensionPixelSize(xu.FlexboxLayout_Layout_layout_maxHeight, 16777215);
            this.f4509b = typedArrayObtainStyledAttributes.getBoolean(xu.FlexboxLayout_Layout_layout_wrapBefore, false);
            typedArrayObtainStyledAttributes.recycle();
        }

        public a(Parcel parcel) {
            super(0, 0);
            this.f4507a = 1;
            this.f8265a = 0.0f;
            this.b = 1.0f;
            this.f4508b = -1;
            this.c = -1.0f;
            this.f4510c = -1;
            this.d = -1;
            this.e = 16777215;
            this.f = 16777215;
            this.f4507a = parcel.readInt();
            this.f8265a = parcel.readFloat();
            this.b = parcel.readFloat();
            this.f4508b = parcel.readInt();
            this.c = parcel.readFloat();
            this.f4510c = parcel.readInt();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
            this.f = parcel.readInt();
            this.f4509b = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f4507a = 1;
            this.f8265a = 0.0f;
            this.b = 1.0f;
            this.f4508b = -1;
            this.c = -1.0f;
            this.f4510c = -1;
            this.d = -1;
            this.e = 16777215;
            this.f = 16777215;
        }

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f4507a = 1;
            this.f8265a = 0.0f;
            this.b = 1.0f;
            this.f4508b = -1;
            this.c = -1.0f;
            this.f4510c = -1;
            this.d = -1;
            this.e = 16777215;
            this.f = 16777215;
        }

        public a(a aVar) {
            super((ViewGroup.MarginLayoutParams) aVar);
            this.f4507a = 1;
            this.f8265a = 0.0f;
            this.b = 1.0f;
            this.f4508b = -1;
            this.c = -1.0f;
            this.f4510c = -1;
            this.d = -1;
            this.e = 16777215;
            this.f = 16777215;
            this.f4507a = aVar.f4507a;
            this.f8265a = aVar.f8265a;
            this.b = aVar.b;
            this.f4508b = aVar.f4508b;
            this.c = aVar.c;
            this.f4510c = aVar.f4510c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.f = aVar.f;
            this.f4509b = aVar.f4509b;
        }

        @Override // a.pu
        public int a() {
            return this.e;
        }

        @Override // a.pu
        public float b() {
            return this.b;
        }

        @Override // a.pu
        public int c() {
            return this.f4508b;
        }

        @Override // a.pu
        public int d() {
            return this.f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // a.pu
        public void e(int i) {
            this.f4510c = i;
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
            return this.f4507a;
        }

        @Override // a.pu
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // a.pu
        public int h() {
            return this.d;
        }

        @Override // a.pu
        public int i() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // a.pu
        public float j() {
            return this.f8265a;
        }

        @Override // a.pu
        public boolean k() {
            return this.f4509b;
        }

        @Override // a.pu
        public int l() {
            return this.f4510c;
        }

        @Override // a.pu
        public float m() {
            return this.c;
        }

        @Override // a.pu
        public void n(int i) {
            this.d = i;
        }

        @Override // a.pu
        public int p() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f4507a);
            parcel.writeFloat(this.f8265a);
            parcel.writeFloat(this.b);
            parcel.writeInt(this.f4508b);
            parcel.writeFloat(this.c);
            parcel.writeInt(this.f4510c);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
            parcel.writeInt(this.f);
            parcel.writeByte(this.f4509b ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = -1;
        this.f4501a = new su(this);
        this.f4504a = new ArrayList();
        this.f4500a = new su.a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, xu.FlexboxLayout, i, 0);
        this.f8264a = typedArrayObtainStyledAttributes.getInt(xu.FlexboxLayout_flexDirection, 0);
        this.b = typedArrayObtainStyledAttributes.getInt(xu.FlexboxLayout_flexWrap, 0);
        this.c = typedArrayObtainStyledAttributes.getInt(xu.FlexboxLayout_justifyContent, 0);
        this.d = typedArrayObtainStyledAttributes.getInt(xu.FlexboxLayout_alignItems, 0);
        this.e = typedArrayObtainStyledAttributes.getInt(xu.FlexboxLayout_alignContent, 0);
        this.f = typedArrayObtainStyledAttributes.getInt(xu.FlexboxLayout_maxLine, -1);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(xu.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(xu.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(xu.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i2 = typedArrayObtainStyledAttributes.getInt(xu.FlexboxLayout_showDivider, 0);
        if (i2 != 0) {
            this.h = i2;
            this.g = i2;
        }
        int i3 = typedArrayObtainStyledAttributes.getInt(xu.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.h = i3;
        }
        int i4 = typedArrayObtainStyledAttributes.getInt(xu.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.g = i4;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void A() {
        setWillNotDraw(this.f4502a == null && this.f4506b == null);
    }

    @Override // a.ou
    public void a(View view, int i, int i2, qu quVar) {
        int i3;
        int i4;
        if (s(i, i2)) {
            if (i()) {
                i3 = quVar.e;
                i4 = this.j;
            } else {
                i3 = quVar.e;
                i4 = this.i;
            }
            quVar.e = i3 + i4;
            quVar.f += i4;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.f4503a == null) {
            this.f4503a = new SparseIntArray(getChildCount());
        }
        this.f4505a = this.f4501a.n(view, i, layoutParams, this.f4503a);
        super.addView(view, i, layoutParams);
    }

    @Override // a.ou
    public int b(int i, int i2, int i3) {
        return ViewGroup.getChildMeasureSpec(i, i2, i3);
    }

    @Override // a.ou
    public int c(int i, int i2, int i3) {
        return ViewGroup.getChildMeasureSpec(i, i2, i3);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    @Override // a.ou
    public void d(int i, View view) {
    }

    @Override // a.ou
    public View e(int i) {
        return r(i);
    }

    @Override // a.ou
    public int f(View view, int i, int i2) {
        int i3;
        int i4;
        if (i()) {
            i3 = s(i, i2) ? 0 + this.j : 0;
            if ((this.h & 4) <= 0) {
                return i3;
            }
            i4 = this.j;
        } else {
            i3 = s(i, i2) ? 0 + this.i : 0;
            if ((this.g & 4) <= 0) {
                return i3;
            }
            i4 = this.i;
        }
        return i3 + i4;
    }

    public final boolean g(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.f4504a.get(i2).c() > 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a ? new a((a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new a((ViewGroup.MarginLayoutParams) layoutParams) : new a(layoutParams);
    }

    @Override // a.ou
    public int getAlignContent() {
        return this.e;
    }

    @Override // a.ou
    public int getAlignItems() {
        return this.d;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.f4502a;
    }

    public Drawable getDividerDrawableVertical() {
        return this.f4506b;
    }

    @Override // a.ou
    public int getFlexDirection() {
        return this.f8264a;
    }

    @Override // a.ou
    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<qu> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.f4504a.size());
        for (qu quVar : this.f4504a) {
            if (quVar.c() != 0) {
                arrayList.add(quVar);
            }
        }
        return arrayList;
    }

    @Override // a.ou
    public List<qu> getFlexLinesInternal() {
        return this.f4504a;
    }

    @Override // a.ou
    public int getFlexWrap() {
        return this.b;
    }

    public int getJustifyContent() {
        return this.c;
    }

    @Override // a.ou
    public int getLargestMainSize() {
        Iterator<qu> it = this.f4504a.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().e);
        }
        return iMax;
    }

    @Override // a.ou
    public int getMaxLine() {
        return this.f;
    }

    public int getShowDividerHorizontal() {
        return this.g;
    }

    public int getShowDividerVertical() {
        return this.h;
    }

    @Override // a.ou
    public int getSumOfCrossSize() {
        int size = this.f4504a.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            qu quVar = this.f4504a.get(i2);
            if (t(i2)) {
                i += i() ? this.i : this.j;
            }
            if (u(i2)) {
                i += i() ? this.i : this.j;
            }
            i += quVar.g;
        }
        return i;
    }

    @Override // a.ou
    public void h(qu quVar) {
        int i;
        int i2;
        if (i()) {
            if ((this.h & 4) <= 0) {
                return;
            }
            i = quVar.e;
            i2 = this.j;
        } else {
            if ((this.g & 4) <= 0) {
                return;
            }
            i = quVar.e;
            i2 = this.i;
        }
        quVar.e = i + i2;
        quVar.f += i2;
    }

    @Override // a.ou
    public boolean i() {
        int i = this.f8264a;
        return i == 0 || i == 1;
    }

    @Override // a.ou
    public int j(View view) {
        return 0;
    }

    @Override // a.ou
    public View k(int i) {
        return getChildAt(i);
    }

    public final boolean l(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View viewR = r(i - i3);
            if (viewR != null && viewR.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    public final void m(Canvas canvas, boolean z, boolean z2) {
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.f4504a.size();
        for (int i = 0; i < size; i++) {
            qu quVar = this.f4504a.get(i);
            for (int i2 = 0; i2 < quVar.h; i2++) {
                int i3 = quVar.l + i2;
                View viewR = r(i3);
                if (viewR != null && viewR.getVisibility() != 8) {
                    a aVar = (a) viewR.getLayoutParams();
                    if (s(i3, i2)) {
                        p(canvas, z ? viewR.getRight() + ((ViewGroup.MarginLayoutParams) aVar).rightMargin : (viewR.getLeft() - ((ViewGroup.MarginLayoutParams) aVar).leftMargin) - this.j, quVar.f2607b, quVar.g);
                    }
                    if (i2 == quVar.h - 1 && (this.h & 4) > 0) {
                        p(canvas, z ? (viewR.getLeft() - ((ViewGroup.MarginLayoutParams) aVar).leftMargin) - this.j : viewR.getRight() + ((ViewGroup.MarginLayoutParams) aVar).rightMargin, quVar.f2607b, quVar.g);
                    }
                }
            }
            if (t(i)) {
                o(canvas, paddingLeft, z2 ? quVar.d : quVar.f2607b - this.i, iMax);
            }
            if (u(i) && (this.g & 4) > 0) {
                o(canvas, paddingLeft, z2 ? quVar.f2607b - this.i : quVar.d, iMax);
            }
        }
    }

    public final void n(Canvas canvas, boolean z, boolean z2) {
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.f4504a.size();
        for (int i = 0; i < size; i++) {
            qu quVar = this.f4504a.get(i);
            for (int i2 = 0; i2 < quVar.h; i2++) {
                int i3 = quVar.l + i2;
                View viewR = r(i3);
                if (viewR != null && viewR.getVisibility() != 8) {
                    a aVar = (a) viewR.getLayoutParams();
                    if (s(i3, i2)) {
                        o(canvas, quVar.f2604a, z2 ? viewR.getBottom() + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin : (viewR.getTop() - ((ViewGroup.MarginLayoutParams) aVar).topMargin) - this.i, quVar.g);
                    }
                    if (i2 == quVar.h - 1 && (this.g & 4) > 0) {
                        o(canvas, quVar.f2604a, z2 ? (viewR.getTop() - ((ViewGroup.MarginLayoutParams) aVar).topMargin) - this.i : viewR.getBottom() + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin, quVar.g);
                    }
                }
            }
            if (t(i)) {
                p(canvas, z ? quVar.c : quVar.f2604a - this.j, paddingTop, iMax);
            }
            if (u(i) && (this.h & 4) > 0) {
                p(canvas, z ? quVar.f2604a - this.j : quVar.c, paddingTop, iMax);
            }
        }
    }

    public final void o(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.f4502a;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, i3 + i, this.i + i2);
        this.f4502a.draw(canvas);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0053 A[PHI: r0
  0x0053: PHI (r0v6 boolean) = (r0v4 boolean), (r0v9 boolean) binds: [B:42:0x0051, B:36:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onDraw(android.graphics.Canvas r7) {
        /*
            r6 = this;
            android.graphics.drawable.Drawable r0 = r6.f4506b
            if (r0 != 0) goto L9
            android.graphics.drawable.Drawable r0 = r6.f4502a
            if (r0 != 0) goto L9
            return
        L9:
            int r0 = r6.g
            if (r0 != 0) goto L12
            int r0 = r6.h
            if (r0 != 0) goto L12
            return
        L12:
            int r0 = a.eh.y(r6)
            int r1 = r6.f8264a
            r2 = 2
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L4a
            if (r1 == r4) goto L40
            if (r1 == r2) goto L32
            r5 = 3
            if (r1 == r5) goto L25
            goto L57
        L25:
            if (r0 != r4) goto L28
            r3 = r4
        L28:
            int r0 = r6.b
            if (r0 != r2) goto L2e
            r3 = r3 ^ 1
        L2e:
            r6.n(r7, r3, r4)
            goto L57
        L32:
            if (r0 != r4) goto L35
            goto L36
        L35:
            r4 = r3
        L36:
            int r0 = r6.b
            if (r0 != r2) goto L3c
            r4 = r4 ^ 1
        L3c:
            r6.n(r7, r4, r3)
            goto L57
        L40:
            if (r0 == r4) goto L44
            r0 = r4
            goto L45
        L44:
            r0 = r3
        L45:
            int r1 = r6.b
            if (r1 != r2) goto L54
            goto L53
        L4a:
            if (r0 != r4) goto L4e
            r0 = r4
            goto L4f
        L4e:
            r0 = r3
        L4f:
            int r1 = r6.b
            if (r1 != r2) goto L54
        L53:
            r3 = r4
        L54:
            r6.m(r7, r0, r3)
        L57:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.onDraw(android.graphics.Canvas):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r8, int r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            int r0 = a.eh.y(r7)
            int r1 = r7.f8264a
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L52
            if (r1 == r3) goto L4f
            r4 = 2
            if (r1 == r4) goto L39
            r5 = 3
            if (r1 != r5) goto L20
            if (r0 != r3) goto L15
            r2 = r3
        L15:
            int r0 = r7.b
            if (r0 != r4) goto L1d
            r0 = r2 ^ 1
            r1 = r0
            goto L1e
        L1d:
            r1 = r2
        L1e:
            r2 = 1
            goto L46
        L20:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid flex direction is set: "
            r1.append(r2)
            int r2 = r7.f8264a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L39:
            if (r0 != r3) goto L3c
            r2 = r3
        L3c:
            int r0 = r7.b
            if (r0 != r4) goto L44
            r0 = r2 ^ 1
            r1 = r0
            goto L45
        L44:
            r1 = r2
        L45:
            r2 = 0
        L46:
            r0 = r7
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r0.w(r1, r2, r3, r4, r5, r6)
            goto L5f
        L4f:
            if (r0 == r3) goto L56
            goto L54
        L52:
            if (r0 != r3) goto L56
        L54:
            r1 = r3
            goto L57
        L56:
            r1 = r2
        L57:
            r0 = r7
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r0.v(r1, r2, r3, r4, r5)
        L5f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f4503a == null) {
            this.f4503a = new SparseIntArray(getChildCount());
        }
        if (this.f4501a.O(this.f4503a)) {
            this.f4505a = this.f4501a.m(this.f4503a);
        }
        int i3 = this.f8264a;
        if (i3 == 0 || i3 == 1) {
            x(i, i2);
            return;
        }
        if (i3 == 2 || i3 == 3) {
            y(i, i2);
            return;
        }
        throw new IllegalStateException("Invalid value for the flex direction is set: " + this.f8264a);
    }

    public final void p(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.f4506b;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, this.j + i, i3 + i2);
        this.f4506b.draw(canvas);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public View r(int i) {
        if (i < 0) {
            return null;
        }
        int[] iArr = this.f4505a;
        if (i >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i]);
    }

    public final boolean s(int i, int i2) {
        return l(i, i2) ? i() ? (this.h & 1) != 0 : (this.g & 1) != 0 : i() ? (this.h & 2) != 0 : (this.g & 2) != 0;
    }

    public void setAlignContent(int i) {
        if (this.e != i) {
            this.e = i;
            requestLayout();
        }
    }

    public void setAlignItems(int i) {
        if (this.d != i) {
            this.d = i;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.f4502a) {
            return;
        }
        this.f4502a = drawable;
        this.i = drawable != null ? drawable.getIntrinsicHeight() : 0;
        A();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.f4506b) {
            return;
        }
        this.f4506b = drawable;
        this.j = drawable != null ? drawable.getIntrinsicWidth() : 0;
        A();
        requestLayout();
    }

    public void setFlexDirection(int i) {
        if (this.f8264a != i) {
            this.f8264a = i;
            requestLayout();
        }
    }

    @Override // a.ou
    public void setFlexLines(List<qu> list) {
        this.f4504a = list;
    }

    public void setFlexWrap(int i) {
        if (this.b != i) {
            this.b = i;
            requestLayout();
        }
    }

    public void setJustifyContent(int i) {
        if (this.c != i) {
            this.c = i;
            requestLayout();
        }
    }

    public void setMaxLine(int i) {
        if (this.f != i) {
            this.f = i;
            requestLayout();
        }
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.g) {
            this.g = i;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i) {
        if (i != this.h) {
            this.h = i;
            requestLayout();
        }
    }

    public final boolean t(int i) {
        if (i < 0 || i >= this.f4504a.size()) {
            return false;
        }
        return g(i) ? i() ? (this.g & 1) != 0 : (this.h & 1) != 0 : i() ? (this.g & 2) != 0 : (this.h & 2) != 0;
    }

    public final boolean u(int i) {
        if (i < 0 || i >= this.f4504a.size()) {
            return false;
        }
        for (int i2 = i + 1; i2 < this.f4504a.size(); i2++) {
            if (this.f4504a.get(i2).c() > 0) {
                return false;
            }
        }
        return i() ? (this.g & 4) != 0 : (this.h & 4) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(boolean r29, int r30, int r31, int r32, int r33) {
        /*
            Method dump skipped, instruction units count: 525
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.v(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01e1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(boolean r30, boolean r31, int r32, int r33, int r34, int r35) {
        /*
            Method dump skipped, instruction units count: 516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.w(boolean, boolean, int, int, int, int):void");
    }

    public final void x(int i, int i2) {
        this.f4504a.clear();
        this.f4500a.a();
        this.f4501a.c(this.f4500a, i, i2);
        this.f4504a = this.f4500a.f2929a;
        this.f4501a.p(i, i2);
        if (this.d == 3) {
            for (qu quVar : this.f4504a) {
                int iMax = Integer.MIN_VALUE;
                for (int i3 = 0; i3 < quVar.h; i3++) {
                    View viewR = r(quVar.l + i3);
                    if (viewR != null && viewR.getVisibility() != 8) {
                        a aVar = (a) viewR.getLayoutParams();
                        iMax = Math.max(iMax, this.b != 2 ? viewR.getMeasuredHeight() + Math.max(quVar.j - viewR.getBaseline(), ((ViewGroup.MarginLayoutParams) aVar).topMargin) + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin : viewR.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) aVar).topMargin + Math.max((quVar.j - viewR.getMeasuredHeight()) + viewR.getBaseline(), ((ViewGroup.MarginLayoutParams) aVar).bottomMargin));
                    }
                }
                quVar.g = iMax;
            }
        }
        this.f4501a.o(i, i2, getPaddingTop() + getPaddingBottom());
        this.f4501a.X();
        z(this.f8264a, i, i2, this.f4500a.f7434a);
    }

    public final void y(int i, int i2) {
        this.f4504a.clear();
        this.f4500a.a();
        this.f4501a.f(this.f4500a, i, i2);
        this.f4504a = this.f4500a.f2929a;
        this.f4501a.p(i, i2);
        this.f4501a.o(i, i2, getPaddingLeft() + getPaddingRight());
        this.f4501a.X();
        z(this.f8264a, i, i2, this.f4500a.f7434a);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z(int r9, int r10, int r11, int r12) {
        /*
            r8 = this;
            int r0 = android.view.View.MeasureSpec.getMode(r10)
            int r1 = android.view.View.MeasureSpec.getSize(r10)
            int r2 = android.view.View.MeasureSpec.getMode(r11)
            int r3 = android.view.View.MeasureSpec.getSize(r11)
            if (r9 == 0) goto L46
            r4 = 1
            if (r9 == r4) goto L46
            r4 = 2
            if (r9 == r4) goto L33
            r4 = 3
            if (r9 != r4) goto L1c
            goto L33
        L1c:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "Invalid flex direction: "
            r11.append(r12)
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            r10.<init>(r9)
            throw r10
        L33:
            int r9 = r8.getLargestMainSize()
            int r4 = r8.getSumOfCrossSize()
            int r5 = r8.getPaddingLeft()
            int r4 = r4 + r5
            int r5 = r8.getPaddingRight()
            int r4 = r4 + r5
            goto L58
        L46:
            int r9 = r8.getSumOfCrossSize()
            int r4 = r8.getPaddingTop()
            int r9 = r9 + r4
            int r4 = r8.getPaddingBottom()
            int r9 = r9 + r4
            int r4 = r8.getLargestMainSize()
        L58:
            r5 = 16777216(0x1000000, float:2.3509887E-38)
            r6 = 1073741824(0x40000000, float:2.0)
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r7) goto L8b
            if (r0 == 0) goto L86
            if (r0 != r6) goto L6f
            if (r1 >= r4) goto L6a
        L66:
            int r12 = android.view.View.combineMeasuredStates(r12, r5)
        L6a:
            int r10 = android.view.View.resolveSizeAndState(r1, r10, r12)
            goto L90
        L6f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Unknown width mode is set: "
            r10.append(r11)
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L86:
            int r10 = android.view.View.resolveSizeAndState(r4, r10, r12)
            goto L90
        L8b:
            if (r1 >= r4) goto L8e
            goto L66
        L8e:
            r1 = r4
            goto L6a
        L90:
            r0 = 256(0x100, float:3.59E-43)
            if (r2 == r7) goto Lbf
            if (r2 == 0) goto Lba
            if (r2 != r6) goto La3
            if (r3 >= r9) goto L9e
        L9a:
            int r12 = android.view.View.combineMeasuredStates(r12, r0)
        L9e:
            int r9 = android.view.View.resolveSizeAndState(r3, r11, r12)
            goto Lc4
        La3:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Unknown height mode is set: "
            r10.append(r11)
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        Lba:
            int r9 = android.view.View.resolveSizeAndState(r9, r11, r12)
            goto Lc4
        Lbf:
            if (r3 >= r9) goto Lc2
            goto L9a
        Lc2:
            r3 = r9
            goto L9e
        Lc4:
            r8.setMeasuredDimension(r10, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.z(int, int, int, int):void");
    }
}
