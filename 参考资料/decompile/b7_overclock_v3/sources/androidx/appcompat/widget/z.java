package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f2761l = "ACTVAutoSizeHelper";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f2763n = 12;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f2764o = 112;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f2765p = 1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final float f2768s = -1.0f;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f2769t = 1048576;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2770a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2771b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f2772c = -1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f2773d = -1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f2774e = -1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f2775f = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2776g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextPaint f2777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.n0
    public final TextView f2778i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f2779j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f2780k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final RectF f2762m = new RectF();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    public static ConcurrentHashMap<String, Method> f2766q = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    public static ConcurrentHashMap<String, Field> f2767r = new ConcurrentHashMap<>();

    @g.v0(16)
    public static final class a {
        @g.u
        @g.n0
        public static StaticLayout a(@g.n0 CharSequence charSequence, @g.n0 Layout.Alignment alignment, int i10, @g.n0 TextView textView, @g.n0 TextPaint textPaint) {
            return new StaticLayout(charSequence, textPaint, i10, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
        }

        @g.u
        public static int b(@g.n0 TextView textView) {
            return textView.getMaxLines();
        }
    }

    @g.v0(18)
    public static final class b {
        @g.u
        public static boolean a(@g.n0 View view) {
            return view.isInLayout();
        }
    }

    @g.v0(23)
    public static final class c {
        @g.u
        @g.n0
        public static StaticLayout a(@g.n0 CharSequence charSequence, @g.n0 Layout.Alignment alignment, int i10, int i11, @g.n0 TextView textView, @g.n0 TextPaint textPaint, @g.n0 f fVar) {
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i10);
            StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i11 == -1) {
                i11 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i11);
            try {
                fVar.a(builderObtain, textView);
            } catch (ClassCastException unused) {
            }
            return builderObtain.build();
        }
    }

    @g.v0(23)
    public static class d extends f {
        @Override // androidx.appcompat.widget.z.f
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) z.p(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    @g.v0(29)
    public static class e extends d {
        @Override // androidx.appcompat.widget.z.d, androidx.appcompat.widget.z.f
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.z.f
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    public static class f {
        public void a(StaticLayout.Builder builder, TextView textView) {
        }

        public boolean b(TextView textView) {
            return ((Boolean) z.p(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    public z(@g.n0 TextView textView) {
        this.f2778i = textView;
        this.f2779j = textView.getContext();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            this.f2780k = new e();
        } else if (i10 >= 23) {
            this.f2780k = new d();
        } else {
            this.f2780k = new f();
        }
    }

    public static <T> T a(@g.n0 Object obj, @g.n0 String str, @g.n0 T t10) {
        try {
            Field fieldM = m(str);
            return fieldM == null ? t10 : (T) fieldM.get(obj);
        } catch (IllegalAccessException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to access TextView#");
            sb2.append(str);
            sb2.append(" member");
            return t10;
        }
    }

    @g.p0
    public static Field m(@g.n0 String str) {
        try {
            Field declaredField = f2767r.get(str);
            if (declaredField == null && (declaredField = TextView.class.getDeclaredField(str)) != null) {
                declaredField.setAccessible(true);
                f2767r.put(str, declaredField);
            }
            return declaredField;
        } catch (NoSuchFieldException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to access TextView#");
            sb2.append(str);
            sb2.append(" member");
            return null;
        }
    }

    @g.p0
    public static Method n(@g.n0 String str) {
        try {
            Method declaredMethod = f2766q.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                declaredMethod.setAccessible(true);
                f2766q.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to retrieve TextView#");
            sb2.append(str);
            sb2.append("() method");
            return null;
        }
    }

    public static <T> T p(@g.n0 Object obj, @g.n0 String str, @g.n0 T t10) {
        try {
            return (T) n(str).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to invoke TextView#");
            sb2.append(str);
            sb2.append("() method");
            return t10;
        }
    }

    public final boolean A(int i10, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f2778i.getText();
        TransformationMethod transformationMethod = this.f2778i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f2778i)) != null) {
            text = transformation;
        }
        int iB = a.b(this.f2778i);
        o(i10);
        StaticLayout staticLayoutE = e(text, (Layout.Alignment) p(this.f2778i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), iB);
        return (iB == -1 || (staticLayoutE.getLineCount() <= iB && staticLayoutE.getLineEnd(staticLayoutE.getLineCount() - 1) == text.length())) && ((float) staticLayoutE.getHeight()) <= rectF.bottom;
    }

    public final boolean B() {
        return !(this.f2778i instanceof j);
    }

    public final void C(float f10, float f11, float f12) throws IllegalArgumentException {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f10 + "px) is less or equal to (0px)");
        }
        if (f11 <= f10) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f11 + "px) is less or equal to minimum auto-size text size (" + f10 + "px)");
        }
        if (f12 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f12 + "px) is less or equal to (0px)");
        }
        this.f2770a = 1;
        this.f2773d = f10;
        this.f2774e = f11;
        this.f2772c = f12;
        this.f2776g = false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void b() {
        if (q()) {
            if (this.f2771b) {
                if (this.f2778i.getMeasuredHeight() <= 0 || this.f2778i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f2780k.b(this.f2778i) ? 1048576 : (this.f2778i.getMeasuredWidth() - this.f2778i.getTotalPaddingLeft()) - this.f2778i.getTotalPaddingRight();
                int height = (this.f2778i.getHeight() - this.f2778i.getCompoundPaddingBottom()) - this.f2778i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f2762m;
                synchronized (rectF) {
                    rectF.setEmpty();
                    rectF.right = measuredWidth;
                    rectF.bottom = height;
                    float fG = g(rectF);
                    if (fG != this.f2778i.getTextSize()) {
                        w(0, fG);
                    }
                }
            }
            this.f2771b = true;
        }
    }

    public final int[] c(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            if (i10 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i10)) < 0) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr2[i11] = ((Integer) arrayList.get(i11)).intValue();
        }
        return iArr2;
    }

    public final void d() {
        this.f2770a = 0;
        this.f2773d = -1.0f;
        this.f2774e = -1.0f;
        this.f2772c = -1.0f;
        this.f2775f = new int[0];
        this.f2771b = false;
    }

    @g.i1
    @g.n0
    public StaticLayout e(@g.n0 CharSequence charSequence, @g.n0 Layout.Alignment alignment, int i10, int i11) {
        return Build.VERSION.SDK_INT >= 23 ? c.a(charSequence, alignment, i10, i11, this.f2778i, this.f2777h, this.f2780k) : a.a(charSequence, alignment, i10, this.f2778i, this.f2777h);
    }

    public final StaticLayout f(CharSequence charSequence, Layout.Alignment alignment, int i10) {
        return new StaticLayout(charSequence, this.f2777h, i10, alignment, ((Float) a(this.f2778i, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) a(this.f2778i, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) a(this.f2778i, "mIncludePad", Boolean.TRUE)).booleanValue());
    }

    public final int g(RectF rectF) {
        int length = this.f2775f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i10 = length - 1;
        int i11 = 1;
        int i12 = 0;
        while (i11 <= i10) {
            int i13 = (i11 + i10) / 2;
            if (A(this.f2775f[i13], rectF)) {
                int i14 = i13 + 1;
                i12 = i11;
                i11 = i14;
            } else {
                i12 = i13 - 1;
                i10 = i12;
            }
        }
        return this.f2775f[i12];
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int h() {
        return Math.round(this.f2774e);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int i() {
        return Math.round(this.f2773d);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int j() {
        return Math.round(this.f2772c);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int[] k() {
        return this.f2775f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int l() {
        return this.f2770a;
    }

    @g.i1
    public void o(int i10) {
        TextPaint textPaint = this.f2777h;
        if (textPaint == null) {
            this.f2777h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f2777h.set(this.f2778i.getPaint());
        this.f2777h.setTextSize(i10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean q() {
        return B() && this.f2770a != 0;
    }

    public void r(@g.p0 AttributeSet attributeSet, int i10) {
        int resourceId;
        Context context = this.f2779j;
        int[] iArr = R.styleable.AppCompatTextView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        TextView textView = this.f2778i;
        androidx.core.view.u0.z1(textView, textView.getContext(), iArr, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        int i11 = R.styleable.AppCompatTextView_autoSizeTextType;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            this.f2770a = typedArrayObtainStyledAttributes.getInt(i11, 0);
        }
        int i12 = R.styleable.AppCompatTextView_autoSizeStepGranularity;
        float dimension = typedArrayObtainStyledAttributes.hasValue(i12) ? typedArrayObtainStyledAttributes.getDimension(i12, -1.0f) : -1.0f;
        int i13 = R.styleable.AppCompatTextView_autoSizeMinTextSize;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(i13) ? typedArrayObtainStyledAttributes.getDimension(i13, -1.0f) : -1.0f;
        int i14 = R.styleable.AppCompatTextView_autoSizeMaxTextSize;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(i14) ? typedArrayObtainStyledAttributes.getDimension(i14, -1.0f) : -1.0f;
        int i15 = R.styleable.AppCompatTextView_autoSizePresetSizes;
        if (typedArrayObtainStyledAttributes.hasValue(i15) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(i15, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            y(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!B()) {
            this.f2770a = 0;
            return;
        }
        if (this.f2770a == 1) {
            if (!this.f2776g) {
                DisplayMetrics displayMetrics = this.f2779j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                C(dimension2, dimension3, dimension);
            }
            x();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void s(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        if (B()) {
            DisplayMetrics displayMetrics = this.f2779j.getResources().getDisplayMetrics();
            C(TypedValue.applyDimension(i13, i10, displayMetrics), TypedValue.applyDimension(i13, i11, displayMetrics), TypedValue.applyDimension(i13, i12, displayMetrics));
            if (x()) {
                b();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void t(@g.n0 int[] iArr, int i10) throws IllegalArgumentException {
        if (B()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i10 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f2779j.getResources().getDisplayMetrics();
                    for (int i11 = 0; i11 < length; i11++) {
                        iArrCopyOf[i11] = Math.round(TypedValue.applyDimension(i10, iArr[i11], displayMetrics));
                    }
                }
                this.f2775f = c(iArrCopyOf);
                if (!z()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f2776g = false;
            }
            if (x()) {
                b();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void u(int i10) {
        if (B()) {
            if (i10 == 0) {
                d();
                return;
            }
            if (i10 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i10);
            }
            DisplayMetrics displayMetrics = this.f2779j.getResources().getDisplayMetrics();
            C(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (x()) {
                b();
            }
        }
    }

    public final void v(float f10) {
        if (f10 != this.f2778i.getPaint().getTextSize()) {
            this.f2778i.getPaint().setTextSize(f10);
            boolean zA = b.a(this.f2778i);
            if (this.f2778i.getLayout() != null) {
                this.f2771b = false;
                try {
                    Method methodN = n("nullLayouts");
                    if (methodN != null) {
                        methodN.invoke(this.f2778i, new Object[0]);
                    }
                } catch (Exception unused) {
                }
                if (zA) {
                    this.f2778i.forceLayout();
                } else {
                    this.f2778i.requestLayout();
                }
                this.f2778i.invalidate();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void w(int i10, float f10) {
        Context context = this.f2779j;
        v(TypedValue.applyDimension(i10, f10, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    public final boolean x() {
        if (B() && this.f2770a == 1) {
            if (!this.f2776g || this.f2775f.length == 0) {
                int iFloor = ((int) Math.floor((this.f2774e - this.f2773d) / this.f2772c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i10 = 0; i10 < iFloor; i10++) {
                    iArr[i10] = Math.round(this.f2773d + (i10 * this.f2772c));
                }
                this.f2775f = c(iArr);
            }
            this.f2771b = true;
        } else {
            this.f2771b = false;
        }
        return this.f2771b;
    }

    public final void y(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = typedArray.getDimensionPixelSize(i10, -1);
            }
            this.f2775f = c(iArr);
            z();
        }
    }

    public final boolean z() {
        boolean z10 = this.f2775f.length > 0;
        this.f2776g = z10;
        if (z10) {
            this.f2770a = 1;
            this.f2773d = r0[0];
            this.f2774e = r0[r1 - 1];
            this.f2772c = -1.0f;
        }
        return z10;
    }
}
