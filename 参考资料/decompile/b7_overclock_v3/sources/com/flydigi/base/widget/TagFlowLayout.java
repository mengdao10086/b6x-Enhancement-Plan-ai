package com.flydigi.base.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.flydigi.base.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TagFlowLayout<T> extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<List<View>> f13526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f13527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Integer> f13529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13530e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13531f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f13532g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f13533h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13534i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f13535j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f13536k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<View> f13537l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f13538m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public a<T> f13539n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f13540o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f13541p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f13542q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f13543r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f13544s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f13545t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f13546u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f13547v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f13548w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public c f13549x;

    public static abstract class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<T> f13550a;

        public a(List<T> list) {
            this.f13550a = list;
        }

        public int a() {
            List<T> list = this.f13550a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public T b(int i10) {
            return this.f13550a.get(i10);
        }

        public abstract View c(int i10);
    }

    public interface b {
        void a(int i10, View view);
    }

    public interface c {
        void a(int i10, View view);
    }

    public TagFlowLayout(Context context) {
        super(context);
        this.f13526a = new ArrayList();
        this.f13527b = new ArrayList();
        this.f13529d = new ArrayList();
        this.f13534i = -1;
        this.f13537l = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean m(Integer num, View view) {
        c cVar = this.f13549x;
        if (cVar == null) {
            return false;
        }
        int iIntValue = num.intValue();
        Object tag = num;
        if (iIntValue == -1) {
            tag = view.getTag();
        }
        cVar.a(((Integer) tag).intValue(), view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(Integer num, View view) {
        if (this.f13535j) {
            if (this.f13537l.contains(view)) {
                this.f13537l.remove(view);
                view.setSelected(false);
            } else {
                view.setSelected(true);
                this.f13537l.add(view);
                this.f13536k = view;
            }
        } else if (view.isSelected()) {
            view.setSelected(false);
        } else {
            View view2 = this.f13536k;
            if (view2 != null) {
                view2.setSelected(false);
            }
            view.setSelected(true);
            this.f13536k = view;
        }
        b bVar = this.f13533h;
        if (bVar != null) {
            int iIntValue = num.intValue();
            Object tag = num;
            if (iIntValue == -1) {
                tag = view.getTag();
            }
            bVar.a(((Integer) tag).intValue(), view);
        }
    }

    public boolean c() {
        if (getChildCount() <= 0) {
            return false;
        }
        removeAllViews();
        return true;
    }

    public boolean d() {
        int i10 = this.f13534i;
        if (i10 == 0) {
            return false;
        }
        this.f13538m = i10;
        removeViewAt(i10);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f13544s && this.f13545t) {
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(this.f13546u);
            paint.setColor(this.f13547v);
            for (int i10 = 0; i10 < this.f13543r; i10++) {
                int i11 = 0;
                while (true) {
                    int i12 = this.f13542q;
                    if (i11 < i12) {
                        View childAt = getChildAt((i12 * i10) + i11);
                        if (i11 == this.f13542q - 1) {
                            if (i10 != this.f13543r - 1) {
                                canvas.drawLine(childAt.getLeft() - (this.f13540o / 2.0f), (this.f13541p / 2.0f) + childAt.getBottom(), childAt.getRight(), (this.f13541p / 2.0f) + childAt.getBottom(), paint);
                            }
                        } else if (i10 == this.f13543r - 1) {
                            canvas.drawLine((this.f13540o / 2.0f) + childAt.getRight(), childAt.getTop() - (this.f13541p / 2.0f), (this.f13540o / 2.0f) + childAt.getRight(), childAt.getBottom(), paint);
                        } else {
                            if (i11 == 0) {
                                canvas.drawLine(childAt.getLeft(), (this.f13541p / 2.0f) + childAt.getBottom(), (this.f13540o / 2.0f) + childAt.getRight(), (this.f13541p / 2.0f) + childAt.getBottom(), paint);
                            } else {
                                canvas.drawLine(childAt.getLeft() - (this.f13540o / 2.0f), (this.f13541p / 2.0f) + childAt.getBottom(), (this.f13540o / 2.0f) + childAt.getRight(), (this.f13541p / 2.0f) + childAt.getBottom(), paint);
                            }
                            if (i10 == 0) {
                                canvas.drawLine((this.f13540o / 2.0f) + childAt.getRight(), childAt.getTop(), (this.f13540o / 2.0f) + childAt.getRight(), (this.f13541p / 2.0f) + childAt.getBottom(), paint);
                            } else {
                                canvas.drawLine((this.f13540o / 2.0f) + childAt.getRight(), childAt.getTop() - (this.f13541p / 2.0f), (this.f13540o / 2.0f) + childAt.getRight(), (this.f13541p / 2.0f) + childAt.getBottom(), paint);
                            }
                        }
                        i11++;
                    }
                }
            }
        }
    }

    public boolean e(int i10) {
        int i11 = this.f13534i;
        if (i11 == 0) {
            return false;
        }
        this.f13538m = i11;
        if (i10 > i11) {
            return false;
        }
        removeViewAt(i10);
        return true;
    }

    public boolean f(int i10, int i11) {
        int i12 = this.f13534i;
        if (i12 == 0) {
            return false;
        }
        this.f13538m = i12;
        if (i10 < 0) {
            i10 = 0;
        }
        if (i11 > i12) {
            i11 = i12;
        }
        removeViews(i10, (i11 - i10) + 1);
        return true;
    }

    public boolean g() {
        return this.f13545t;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(super.generateDefaultLayoutParams());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public List<View> getCheckedViews() {
        if (this.f13535j) {
            return this.f13537l;
        }
        this.f13537l.add(this.f13536k);
        return this.f13537l;
    }

    public int getColumnNumbers() {
        return this.f13542q;
    }

    public int getCutLineColor() {
        return this.f13547v;
    }

    public float getCutLineWidth() {
        return this.f13546u;
    }

    public float getHorizontalSpace() {
        return this.f13540o;
    }

    public int getMaxLineNumbers() {
        return this.f13530e;
    }

    public int getRowNumbers() {
        return this.f13543r;
    }

    public View getSelectedView() {
        return this.f13536k;
    }

    public float getVerticalSpace() {
        return this.f13541p;
    }

    public boolean h() {
        return this.f13532g;
    }

    public final void i(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TagFlowLayout);
        this.f13528c = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TagFlowLayout_isSingleLine, false);
        this.f13530e = typedArrayObtainStyledAttributes.getInteger(R.styleable.TagFlowLayout_maxLines, Integer.MAX_VALUE);
        this.f13535j = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TagFlowLayout_multiChecked, false);
        this.f13540o = typedArrayObtainStyledAttributes.getDimension(R.styleable.TagFlowLayout_horizontalSpace, 0.0f);
        this.f13541p = typedArrayObtainStyledAttributes.getDimension(R.styleable.TagFlowLayout_verticalSpace, 0.0f);
        this.f13542q = typedArrayObtainStyledAttributes.getInteger(R.styleable.TagFlowLayout_columnNumbers, 0);
        this.f13543r = typedArrayObtainStyledAttributes.getInteger(R.styleable.TagFlowLayout_rowNumbers, 0);
        this.f13547v = typedArrayObtainStyledAttributes.getColor(R.styleable.TagFlowLayout_cutLineColor, getResources().getColor(android.R.color.darker_gray));
        this.f13546u = typedArrayObtainStyledAttributes.getDimension(R.styleable.TagFlowLayout_cutLineWidth, 1.0f);
        this.f13545t = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TagFlowLayout_cutLine, false);
        this.f13548w = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TagFlowLayout_lineCenter, false);
        if (this.f13542q != 0) {
            this.f13544s = true;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public boolean j() {
        return this.f13548w;
    }

    public boolean k() {
        return this.f13535j;
    }

    public boolean l() {
        return this.f13528c;
    }

    public final void o(View view, final Integer num) {
        if (view.getTag() == null) {
            view.setTag(Integer.valueOf(this.f13534i));
        }
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: p5.v
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return this.f46440a.m(num, view2);
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: p5.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f46438a.n(num, view2);
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.f13544s) {
            r();
        } else {
            p();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f13544s) {
            s(i10, i11);
        } else {
            q(i10, i11);
        }
    }

    public final void p() {
        this.f13534i = -1;
        this.f13531f = 0;
        this.f13526a.clear();
        this.f13529d.clear();
        this.f13527b.clear();
        this.f13537l.clear();
        int width = getWidth();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (marginLayoutParams.leftMargin + measuredWidth + marginLayoutParams.rightMargin + getPaddingRight() + paddingLeft > width) {
                this.f13529d.add(Integer.valueOf(paddingTop));
                this.f13526a.add(arrayList);
                this.f13527b.add(Integer.valueOf(marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + getPaddingRight() + paddingLeft));
                arrayList = new ArrayList();
                int i11 = this.f13531f + 1;
                this.f13531f = i11;
                if (i11 >= this.f13530e) {
                    t(i10 + 1, childCount);
                } else if (this.f13528c) {
                    t(i10 + 1, childCount);
                } else {
                    paddingLeft = 0;
                }
                paddingLeft = 0;
                break;
            }
            paddingLeft += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            paddingTop = Math.max(paddingTop, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
            arrayList.add(childAt);
        }
        this.f13529d.add(Integer.valueOf(paddingTop));
        this.f13526a.add(arrayList);
        this.f13527b.add(Integer.valueOf(paddingLeft));
        int paddingLeft2 = getPaddingLeft();
        int paddingTop2 = getPaddingTop();
        int size = this.f13526a.size();
        if (this.f13526a.get(r5.size() - 1).size() == 0) {
            size = this.f13526a.size() - 1;
        }
        int i12 = 0;
        while (i12 < size) {
            List<View> list = this.f13526a.get(i12);
            int iIntValue = this.f13529d.get(i12).intValue();
            if (this.f13548w && this.f13527b.get(i12).intValue() < getWidth()) {
                paddingLeft2 += (getWidth() - this.f13527b.get(i12).intValue()) / 2;
            }
            for (int i13 = 0; i13 < list.size(); i13++) {
                View view = list.get(i13);
                this.f13534i++;
                if (view.getVisibility() != 8) {
                    o(view, -1);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i14 = marginLayoutParams2.leftMargin + paddingLeft2;
                    int i15 = marginLayoutParams2.topMargin + paddingTop2;
                    view.layout(i14, i15, view.getMeasuredWidth() + i14, view.getMeasuredHeight() + i15);
                    paddingLeft2 += view.getMeasuredWidth() + marginLayoutParams2.rightMargin + marginLayoutParams2.leftMargin;
                }
            }
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) getChildAt(0).getLayoutParams();
            int paddingLeft3 = getPaddingLeft();
            paddingTop2 += iIntValue + marginLayoutParams3.topMargin + marginLayoutParams3.bottomMargin;
            i12++;
            paddingLeft2 = paddingLeft3;
        }
    }

    public final void q(int i10, int i11) {
        int i12;
        int i13 = 0;
        this.f13531f = 0;
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int childCount = getChildCount();
        int i14 = paddingTop;
        int i15 = paddingLeft;
        int iMax = 0;
        int iMax2 = 0;
        while (true) {
            if (i13 >= childCount) {
                i12 = size2;
                break;
            }
            View childAt = getChildAt(i13);
            measureChild(childAt, i10, i11);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            i12 = size2;
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            int i16 = i15 + measuredWidth;
            if (i16 > size) {
                iMax2 = Math.max(i15, measuredWidth);
                i14 += iMax;
                int i17 = this.f13531f + 1;
                this.f13531f = i17;
                if (i17 >= this.f13530e) {
                    t(i13 + 1, childCount);
                    break;
                } else if (this.f13528c) {
                    t(i13 + 1, childCount);
                    break;
                } else {
                    iMax = measuredHeight;
                    i15 = measuredWidth;
                }
            } else {
                iMax = Math.max(iMax, measuredHeight);
                i15 = i16;
            }
            if (i13 == childCount - 1) {
                i14 += iMax;
                iMax2 = Math.max(iMax2, i15);
            }
            i13++;
            size2 = i12;
        }
        if (mode != 1073741824) {
            size = iMax2;
        }
        setMeasuredDimension(size, mode2 == 1073741824 ? i12 : i14);
    }

    public final void r() {
        this.f13537l.clear();
        this.f13534i = -1;
        int width = getWidth();
        int height = getHeight();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getChildAt(0).getLayoutParams();
        float paddingLeft = (width - getPaddingLeft()) - getPaddingRight();
        float f10 = this.f13540o;
        int i10 = (((int) ((paddingLeft - (f10 * (r6 - 1))) / this.f13542q)) - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        float paddingTop = (height - getPaddingTop()) - getPaddingBottom();
        float f11 = this.f13541p;
        int i11 = (((int) ((paddingTop - (f11 * (r6 - 1))) / this.f13543r)) - marginLayoutParams.topMargin) - marginLayoutParams.bottomMargin;
        for (int i12 = 0; i12 < this.f13543r; i12++) {
            int i13 = 0;
            while (true) {
                int i14 = this.f13542q;
                if (i13 < i14) {
                    View childAt = getChildAt((i14 * i12) + i13);
                    if (childAt != null) {
                        this.f13534i++;
                        if (childAt.getVisibility() != 8) {
                            o(childAt, -1);
                            int paddingLeft2 = (int) (getPaddingLeft() + (i13 * (i10 + this.f13540o)));
                            int i15 = marginLayoutParams.leftMargin;
                            int i16 = paddingLeft2 + ((marginLayoutParams.rightMargin + i15) * i13) + i15;
                            int paddingTop2 = (int) (getPaddingTop() + (i12 * (i11 + this.f13541p)));
                            int i17 = marginLayoutParams.topMargin;
                            int i18 = paddingTop2 + ((marginLayoutParams.bottomMargin + i17) * i12) + i17;
                            childAt.layout(i16, i18, i16 + i10, i11 + i18);
                        }
                    }
                    i13++;
                }
            }
        }
    }

    public final void s(int i10, int i11) {
        int i12;
        int i13;
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        if (this.f13543r == 0) {
            this.f13543r = getChildCount() % this.f13542q == 0 ? getChildCount() / this.f13542q : (getChildCount() / this.f13542q) + 1;
        }
        int i14 = 0;
        int iMax = 0;
        int i15 = 0;
        while (true) {
            if (i14 >= this.f13543r) {
                break;
            }
            int i16 = 0;
            int measuredWidth = 0;
            int iMax2 = 0;
            while (true) {
                int i17 = this.f13542q;
                if (i16 < i17) {
                    View childAt = getChildAt((i17 * i14) + i16);
                    if (childAt != null) {
                        i13 = mode2;
                        i12 = mode;
                        if (childAt.getVisibility() != 8) {
                            measureChild(childAt, i10, i11);
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                            measuredWidth += childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                            iMax2 = Math.max(iMax2, childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                        }
                    } else {
                        i12 = mode;
                        i13 = mode2;
                    }
                    i16++;
                    mode2 = i13;
                    mode = i12;
                }
            }
            iMax = Math.max(measuredWidth, iMax);
            i15 += iMax2;
            i14++;
        }
        int i18 = mode;
        int i19 = mode2;
        int i20 = (int) (iMax + (this.f13540o * (this.f13542q - 1)) + paddingLeft + paddingRight);
        int i21 = (int) (i15 + (this.f13541p * (r13 - 1)) + paddingBottom + paddingTop);
        if (i20 > size) {
            i20 = size;
        }
        if (i21 > size2) {
            i21 = size2;
        }
        if (i18 != 1073741824) {
            size = i20;
        }
        if (i19 != 1073741824) {
            size2 = i21;
        }
        setMeasuredDimension(size, size2);
    }

    public void setAdapter(a<T> aVar) {
        this.f13539n = aVar;
        c();
        if (this.f13539n.a() != 0) {
            for (int i10 = 0; i10 < this.f13539n.a(); i10++) {
                addView(this.f13539n.c(i10));
            }
            requestLayout();
        }
    }

    public void setAllViews(List<View> list) {
        removeAllViews();
        if (list == null || list.size() == 0) {
            return;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            addView(list.get(i10));
        }
        requestLayout();
    }

    public void setColumnNumbers(int i10) {
        this.f13542q = i10;
        requestLayout();
    }

    public void setCutLine(boolean z10) {
        this.f13545t = z10;
        invalidate();
    }

    public void setCutLineColor(int i10) {
        this.f13547v = i10;
        invalidate();
    }

    public void setCutLineWidth(float f10) {
        this.f13546u = f10;
        invalidate();
    }

    public void setHorizontalSpace(int i10) {
        this.f13540o = i10;
        requestLayout();
    }

    public void setLineCenter(boolean z10) {
        this.f13548w = z10;
        requestLayout();
    }

    public void setMaxLines(int i10) {
        this.f13530e = i10;
        requestLayout();
    }

    public void setMultiChecked(boolean z10) {
        this.f13535j = z10;
    }

    public void setOnItemClickListener(b bVar) {
        this.f13533h = bVar;
    }

    public void setOnLongItemClickListener(c cVar) {
        this.f13549x = cVar;
    }

    public void setRowNumbers(int i10) {
        this.f13543r = i10;
        requestLayout();
    }

    public void setSingleLine(boolean z10) {
        this.f13528c = z10;
        requestLayout();
    }

    public void setVerticalSpace(int i10) {
        this.f13541p = i10;
        requestLayout();
    }

    public final void t(int i10, int i11) {
        if (i10 < i11) {
            this.f13532g = true;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13526a = new ArrayList();
        this.f13527b = new ArrayList();
        this.f13529d = new ArrayList();
        this.f13534i = -1;
        this.f13537l = new ArrayList();
        i(context, attributeSet);
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f13526a = new ArrayList();
        this.f13527b = new ArrayList();
        this.f13529d = new ArrayList();
        this.f13534i = -1;
        this.f13537l = new ArrayList();
        i(context, attributeSet);
    }
}
