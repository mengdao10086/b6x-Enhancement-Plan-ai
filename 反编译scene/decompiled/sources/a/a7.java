package a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class a7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RectF f5575a = new RectF();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static ConcurrentHashMap<String, Method> f35a = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, Field> b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z6 f38a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f39a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextPaint f40a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextView f41a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f37a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f42a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f36a = -1.0f;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public float f44b = -1.0f;
    public float c = -1.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f43a = new int[0];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f45b = false;

    public a7(TextView textView) {
        this.f41a = textView;
        this.f39a = textView.getContext();
        int i = Build.VERSION.SDK_INT;
        this.f38a = i >= 29 ? new y6() : i >= 23 ? new x6() : new z6();
    }

    public static <T> T a(Object obj, String str, T t) {
        try {
            Field fieldO = o(str);
            return fieldO == null ? t : (T) fieldO.get(obj);
        } catch (IllegalAccessException e) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e);
            return t;
        }
    }

    public static Field o(String str) {
        try {
            Field declaredField = b.get(str);
            if (declaredField == null && (declaredField = TextView.class.getDeclaredField(str)) != null) {
                declaredField.setAccessible(true);
                b.put(str, declaredField);
            }
            return declaredField;
        } catch (NoSuchFieldException e) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e);
            return null;
        }
    }

    public static Method p(String str) {
        try {
            Method declaredMethod = f35a.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                declaredMethod.setAccessible(true);
                f35a.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    public static <T> T r(Object obj, String str, T t) {
        try {
            return (T) p(str).invoke(obj, new Object[0]);
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return t;
        }
    }

    public final void A(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.f43a = c(iArr);
            B();
        }
    }

    public final boolean B() {
        boolean z = this.f43a.length > 0;
        this.f45b = z;
        if (z) {
            this.f37a = 1;
            int[] iArr = this.f43a;
            this.f44b = iArr[0];
            this.c = iArr[r0 - 1];
            this.f36a = -1.0f;
        }
        return this.f45b;
    }

    public final boolean C(int i, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f41a.getText();
        TransformationMethod transformationMethod = this.f41a.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f41a)) != null) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.f41a.getMaxLines() : -1;
        q(i);
        StaticLayout staticLayoutE = e(text, (Layout.Alignment) r(this.f41a, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (staticLayoutE.getLineCount() <= maxLines && staticLayoutE.getLineEnd(staticLayoutE.getLineCount() - 1) == text.length())) && ((float) staticLayoutE.getHeight()) <= rectF.bottom;
    }

    public final boolean D() {
        return !(this.f41a instanceof w5);
    }

    public final void E(float f, float f2, float f3) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        }
        if (f2 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        }
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        }
        this.f37a = 1;
        this.f44b = f;
        this.c = f2;
        this.f36a = f3;
        this.f45b = false;
    }

    public void b() {
        if (s()) {
            if (this.f42a) {
                if (this.f41a.getMeasuredHeight() <= 0 || this.f41a.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f38a.b(this.f41a) ? 1048576 : (this.f41a.getMeasuredWidth() - this.f41a.getTotalPaddingLeft()) - this.f41a.getTotalPaddingRight();
                int height = (this.f41a.getHeight() - this.f41a.getCompoundPaddingBottom()) - this.f41a.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                synchronized (f5575a) {
                    f5575a.setEmpty();
                    f5575a.right = measuredWidth;
                    f5575a.bottom = height;
                    float fI = i(f5575a);
                    if (fI != this.f41a.getTextSize()) {
                        y(0, fI);
                    }
                }
            }
            this.f42a = true;
        }
    }

    public final int[] c(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    public final void d() {
        this.f37a = 0;
        this.f44b = -1.0f;
        this.c = -1.0f;
        this.f36a = -1.0f;
        this.f43a = new int[0];
        this.f42a = false;
    }

    public StaticLayout e(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        return i3 >= 23 ? f(charSequence, alignment, i, i2) : i3 >= 16 ? h(charSequence, alignment, i) : g(charSequence, alignment, i);
    }

    public final StaticLayout f(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f40a, i);
        StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(this.f41a.getLineSpacingExtra(), this.f41a.getLineSpacingMultiplier()).setIncludePad(this.f41a.getIncludeFontPadding()).setBreakStrategy(this.f41a.getBreakStrategy()).setHyphenationFrequency(this.f41a.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i2);
        try {
            this.f38a.a(builderObtain, this.f41a);
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return builderObtain.build();
    }

    public final StaticLayout g(CharSequence charSequence, Layout.Alignment alignment, int i) {
        return new StaticLayout(charSequence, this.f40a, i, alignment, ((Float) a(this.f41a, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) a(this.f41a, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) a(this.f41a, "mIncludePad", Boolean.TRUE)).booleanValue());
    }

    public final StaticLayout h(CharSequence charSequence, Layout.Alignment alignment, int i) {
        return new StaticLayout(charSequence, this.f40a, i, alignment, this.f41a.getLineSpacingMultiplier(), this.f41a.getLineSpacingExtra(), this.f41a.getIncludeFontPadding());
    }

    public final int i(RectF rectF) {
        int i;
        int length = this.f43a.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i2 = 0;
        int i3 = 1;
        int i4 = length - 1;
        while (true) {
            int i5 = i3;
            int i6 = i2;
            i2 = i5;
            while (i2 <= i4) {
                i = (i2 + i4) / 2;
                if (C(this.f43a[i], rectF)) {
                    break;
                }
                i6 = i - 1;
                i4 = i6;
            }
            return this.f43a[i6];
            i3 = i + 1;
        }
    }

    public int j() {
        return Math.round(this.c);
    }

    public int k() {
        return Math.round(this.f44b);
    }

    public int l() {
        return Math.round(this.f36a);
    }

    public int[] m() {
        return this.f43a;
    }

    public int n() {
        return this.f37a;
    }

    public void q(int i) {
        TextPaint textPaint = this.f40a;
        if (textPaint == null) {
            this.f40a = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f40a.set(this.f41a.getPaint());
        this.f40a.setTextSize(i);
    }

    public boolean s() {
        return D() && this.f37a != 0;
    }

    public void t(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.f39a.obtainStyledAttributes(attributeSet, c0.AppCompatTextView, i, 0);
        TextView textView = this.f41a;
        eh.i0(textView, textView.getContext(), c0.AppCompatTextView, attributeSet, typedArrayObtainStyledAttributes, i, 0);
        if (typedArrayObtainStyledAttributes.hasValue(c0.AppCompatTextView_autoSizeTextType)) {
            this.f37a = typedArrayObtainStyledAttributes.getInt(c0.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = typedArrayObtainStyledAttributes.hasValue(c0.AppCompatTextView_autoSizeStepGranularity) ? typedArrayObtainStyledAttributes.getDimension(c0.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(c0.AppCompatTextView_autoSizeMinTextSize) ? typedArrayObtainStyledAttributes.getDimension(c0.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(c0.AppCompatTextView_autoSizeMaxTextSize) ? typedArrayObtainStyledAttributes.getDimension(c0.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes.hasValue(c0.AppCompatTextView_autoSizePresetSizes) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(c0.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            A(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!D()) {
            this.f37a = 0;
            return;
        }
        if (this.f37a == 1) {
            if (!this.f45b) {
                DisplayMetrics displayMetrics = this.f39a.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                E(dimension2, dimension3, dimension);
            }
            z();
        }
    }

    public void u(int i, int i2, int i3, int i4) {
        if (D()) {
            DisplayMetrics displayMetrics = this.f39a.getResources().getDisplayMetrics();
            E(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (z()) {
                b();
            }
        }
    }

    public void v(int[] iArr, int i) {
        if (D()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f39a.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArrCopyOf[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                this.f43a = c(iArrCopyOf);
                if (!B()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f45b = false;
            }
            if (z()) {
                b();
            }
        }
    }

    public void w(int i) {
        if (D()) {
            if (i == 0) {
                d();
                return;
            }
            if (i != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i);
            }
            DisplayMetrics displayMetrics = this.f39a.getResources().getDisplayMetrics();
            E(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (z()) {
                b();
            }
        }
    }

    public final void x(float f) {
        if (f != this.f41a.getPaint().getTextSize()) {
            this.f41a.getPaint().setTextSize(f);
            boolean zIsInLayout = Build.VERSION.SDK_INT >= 18 ? this.f41a.isInLayout() : false;
            if (this.f41a.getLayout() != null) {
                this.f42a = false;
                try {
                    Method methodP = p("nullLayouts");
                    if (methodP != null) {
                        methodP.invoke(this.f41a, new Object[0]);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (zIsInLayout) {
                    this.f41a.forceLayout();
                } else {
                    this.f41a.requestLayout();
                }
                this.f41a.invalidate();
            }
        }
    }

    public void y(int i, float f) {
        Context context = this.f39a;
        x(TypedValue.applyDimension(i, f, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    public final boolean z() {
        if (D() && this.f37a == 1) {
            if (!this.f45b || this.f43a.length == 0) {
                int iFloor = ((int) Math.floor((this.c - this.f44b) / this.f36a)) + 1;
                int[] iArr = new int[iFloor];
                for (int i = 0; i < iFloor; i++) {
                    iArr[i] = Math.round(this.f44b + (i * this.f36a));
                }
                this.f43a = c(iArr);
            }
            this.f42a = true;
        } else {
            this.f42a = false;
        }
        return this.f42a;
    }
}
