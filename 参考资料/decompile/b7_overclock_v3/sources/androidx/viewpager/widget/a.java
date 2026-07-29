package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.widget.r;
import androidx.viewpager.widget.ViewPager;
import com.google.common.collect.LinkedHashMultimap;
import g.l;
import g.n0;
import g.p0;
import g.x;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
@ViewPager.e
public class a extends ViewGroup {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f8135o = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int[] f8136p = {R.attr.textAllCaps};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final float f8137q = 0.6f;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f8138r = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager f8139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f8140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f8141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f8142d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8143e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f8144f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8145g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8146h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f8147i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8148j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final C0077a f8149k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public WeakReference<k2.a> f8150l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f8151m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f8152n;

    /* JADX INFO: renamed from: androidx.viewpager.widget.a$a, reason: collision with other inner class name */
    public class C0077a extends DataSetObserver implements ViewPager.j, ViewPager.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8153a;

        public C0077a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(ViewPager viewPager, k2.a aVar, k2.a aVar2) {
            a.this.b(aVar, aVar2);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a aVar = a.this;
            aVar.c(aVar.f8139a.getCurrentItem(), a.this.f8139a.getAdapter());
            a aVar2 = a.this;
            float f10 = aVar2.f8144f;
            if (f10 < 0.0f) {
                f10 = 0.0f;
            }
            aVar2.d(aVar2.f8139a.getCurrentItem(), f10, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i10) {
            this.f8153a = i10;
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i10, float f10, int i11) {
            if (f10 > 0.5f) {
                i10++;
            }
            a.this.d(i10, f10, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i10) {
            if (this.f8153a == 0) {
                a aVar = a.this;
                aVar.c(aVar.f8139a.getCurrentItem(), a.this.f8139a.getAdapter());
                a aVar2 = a.this;
                float f10 = aVar2.f8144f;
                if (f10 < 0.0f) {
                    f10 = 0.0f;
                }
                aVar2.d(aVar2.f8139a.getCurrentItem(), f10, true);
            }
        }
    }

    public static class b extends SingleLineTransformationMethod {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Locale f8155a;

        public b(Context context) {
            this.f8155a = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f8155a);
            }
            return null;
        }
    }

    public a(@n0 Context context) {
        this(context, null);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    public void a(int i10, float f10) {
        this.f8140b.setTextSize(i10, f10);
        this.f8141c.setTextSize(i10, f10);
        this.f8142d.setTextSize(i10, f10);
    }

    public void b(k2.a aVar, k2.a aVar2) {
        if (aVar != null) {
            aVar.unregisterDataSetObserver(this.f8149k);
            this.f8150l = null;
        }
        if (aVar2 != null) {
            aVar2.registerDataSetObserver(this.f8149k);
            this.f8150l = new WeakReference<>(aVar2);
        }
        ViewPager viewPager = this.f8139a;
        if (viewPager != null) {
            this.f8143e = -1;
            this.f8144f = -1.0f;
            c(viewPager.getCurrentItem(), aVar2);
            requestLayout();
        }
    }

    public void c(int i10, k2.a aVar) {
        int count = aVar != null ? aVar.getCount() : 0;
        this.f8147i = true;
        CharSequence pageTitle = null;
        this.f8140b.setText((i10 < 1 || aVar == null) ? null : aVar.getPageTitle(i10 - 1));
        this.f8141c.setText((aVar == null || i10 >= count) ? null : aVar.getPageTitle(i10));
        int i11 = i10 + 1;
        if (i11 < count && aVar != null) {
            pageTitle = aVar.getPageTitle(i11);
        }
        this.f8142d.setText(pageTitle);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f8140b.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f8141c.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f8142d.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        this.f8143e = i10;
        if (!this.f8148j) {
            d(i10, this.f8144f, false);
        }
        this.f8147i = false;
    }

    public void d(int i10, float f10, boolean z10) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (i10 != this.f8143e) {
            c(i10, this.f8139a.getAdapter());
        } else if (!z10 && f10 == this.f8144f) {
            return;
        }
        this.f8148j = true;
        int measuredWidth = this.f8140b.getMeasuredWidth();
        int measuredWidth2 = this.f8141c.getMeasuredWidth();
        int measuredWidth3 = this.f8142d.getMeasuredWidth();
        int i15 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i16 = paddingRight + i15;
        int i17 = (width - (paddingLeft + i15)) - i16;
        float f11 = 0.5f + f10;
        if (f11 > 1.0f) {
            f11 -= 1.0f;
        }
        int i18 = ((width - i16) - ((int) (i17 * f11))) - i15;
        int i19 = measuredWidth2 + i18;
        int baseline = this.f8140b.getBaseline();
        int baseline2 = this.f8141c.getBaseline();
        int baseline3 = this.f8142d.getBaseline();
        int iMax = Math.max(Math.max(baseline, baseline2), baseline3);
        int i20 = iMax - baseline;
        int i21 = iMax - baseline2;
        int i22 = iMax - baseline3;
        int iMax2 = Math.max(Math.max(this.f8140b.getMeasuredHeight() + i20, this.f8141c.getMeasuredHeight() + i21), this.f8142d.getMeasuredHeight() + i22);
        int i23 = this.f8146h & 112;
        if (i23 == 16) {
            i11 = (((height - paddingTop) - paddingBottom) - iMax2) / 2;
        } else {
            if (i23 != 80) {
                i12 = i20 + paddingTop;
                i13 = i21 + paddingTop;
                i14 = paddingTop + i22;
                TextView textView = this.f8141c;
                textView.layout(i18, i13, i19, textView.getMeasuredHeight() + i13);
                int iMin = Math.min(paddingLeft, (i18 - this.f8145g) - measuredWidth);
                TextView textView2 = this.f8140b;
                textView2.layout(iMin, i12, measuredWidth + iMin, textView2.getMeasuredHeight() + i12);
                int iMax3 = Math.max((width - paddingRight) - measuredWidth3, i19 + this.f8145g);
                TextView textView3 = this.f8142d;
                textView3.layout(iMax3, i14, iMax3 + measuredWidth3, textView3.getMeasuredHeight() + i14);
                this.f8144f = f10;
                this.f8148j = false;
            }
            i11 = (height - paddingBottom) - iMax2;
        }
        i12 = i20 + i11;
        i13 = i21 + i11;
        i14 = i11 + i22;
        TextView textView4 = this.f8141c;
        textView4.layout(i18, i13, i19, textView4.getMeasuredHeight() + i13);
        int iMin2 = Math.min(paddingLeft, (i18 - this.f8145g) - measuredWidth);
        TextView textView22 = this.f8140b;
        textView22.layout(iMin2, i12, measuredWidth + iMin2, textView22.getMeasuredHeight() + i12);
        int iMax32 = Math.max((width - paddingRight) - measuredWidth3, i19 + this.f8145g);
        TextView textView32 = this.f8142d;
        textView32.layout(iMax32, i14, iMax32 + measuredWidth3, textView32.getMeasuredHeight() + i14);
        this.f8144f = f10;
        this.f8148j = false;
    }

    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f8145g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewPager = (ViewPager) parent;
        k2.a adapter = viewPager.getAdapter();
        viewPager.X(this.f8149k);
        viewPager.d(this.f8149k);
        this.f8139a = viewPager;
        WeakReference<k2.a> weakReference = this.f8150l;
        b(weakReference != null ? weakReference.get() : null, adapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f8139a;
        if (viewPager != null) {
            b(viewPager.getAdapter(), null);
            this.f8139a.X(null);
            this.f8139a.P(this.f8149k);
            this.f8139a = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        if (this.f8139a != null) {
            float f10 = this.f8144f;
            if (f10 < 0.0f) {
                f10 = 0.0f;
            }
            d(this.f8143e, f10, true);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int iMax;
        if (View.MeasureSpec.getMode(i10) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingTop, -2);
        int size = View.MeasureSpec.getSize(i10);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i10, (int) (size * 0.2f), -2);
        this.f8140b.measure(childMeasureSpec2, childMeasureSpec);
        this.f8141c.measure(childMeasureSpec2, childMeasureSpec);
        this.f8142d.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i11) == 1073741824) {
            iMax = View.MeasureSpec.getSize(i11);
        } else {
            iMax = Math.max(getMinHeight(), this.f8141c.getMeasuredHeight() + paddingTop);
        }
        setMeasuredDimension(size, View.resolveSizeAndState(iMax, i11, this.f8141c.getMeasuredState() << 16));
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f8147i) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i10) {
        this.f8146h = i10;
        requestLayout();
    }

    public void setNonPrimaryAlpha(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        int i10 = ((int) (f10 * 255.0f)) & 255;
        this.f8151m = i10;
        int i11 = (i10 << 24) | (this.f8152n & 16777215);
        this.f8140b.setTextColor(i11);
        this.f8142d.setTextColor(i11);
    }

    public void setTextColor(@l int i10) {
        this.f8152n = i10;
        this.f8141c.setTextColor(i10);
        int i11 = (this.f8151m << 24) | (this.f8152n & 16777215);
        this.f8140b.setTextColor(i11);
        this.f8142d.setTextColor(i11);
    }

    public void setTextSpacing(int i10) {
        this.f8145g = i10;
        requestLayout();
    }

    public a(@n0 Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8143e = -1;
        this.f8144f = -1.0f;
        this.f8149k = new C0077a();
        TextView textView = new TextView(context);
        this.f8140b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f8141c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f8142d = textView3;
        addView(textView3);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f8135o);
        boolean z10 = false;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            r.E(this.f8140b, resourceId);
            r.E(this.f8141c, resourceId);
            r.E(this.f8142d, resourceId);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            a(0, dimensionPixelSize);
        }
        if (typedArrayObtainStyledAttributes.hasValue(2)) {
            int color = typedArrayObtainStyledAttributes.getColor(2, 0);
            this.f8140b.setTextColor(color);
            this.f8141c.setTextColor(color);
            this.f8142d.setTextColor(color);
        }
        this.f8146h = typedArrayObtainStyledAttributes.getInteger(3, 80);
        typedArrayObtainStyledAttributes.recycle();
        this.f8152n = this.f8141c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.f8140b.setEllipsize(TextUtils.TruncateAt.END);
        this.f8141c.setEllipsize(TextUtils.TruncateAt.END);
        this.f8142d.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f8136p);
            z10 = typedArrayObtainStyledAttributes2.getBoolean(0, false);
            typedArrayObtainStyledAttributes2.recycle();
        }
        if (z10) {
            setSingleLineAllCaps(this.f8140b);
            setSingleLineAllCaps(this.f8141c);
            setSingleLineAllCaps(this.f8142d);
        } else {
            this.f8140b.setSingleLine();
            this.f8141c.setSingleLine();
            this.f8142d.setSingleLine();
        }
        this.f8145g = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }
}
