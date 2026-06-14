package a;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Object f8104a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Constructor<StaticLayout> f3893a;
    public static boolean c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f3894a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextPaint f3896a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f3898a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3900b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f3901c;
    public int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Layout.Alignment f3895a = Layout.Alignment.ALIGN_NORMAL;
    public int d = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3899a = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextUtils.TruncateAt f3897a = null;

    public zx(CharSequence charSequence, TextPaint textPaint, int i) {
        this.f3898a = charSequence;
        this.f3896a = textPaint;
        this.f3894a = i;
        this.f3901c = charSequence.length();
    }

    public static zx c(CharSequence charSequence, TextPaint textPaint, int i) {
        return new zx(charSequence, textPaint, i);
    }

    public StaticLayout a() throws yx {
        if (this.f3898a == null) {
            this.f3898a = "";
        }
        int iMax = Math.max(0, this.f3894a);
        CharSequence charSequenceEllipsize = this.f3898a;
        if (this.d == 1) {
            charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f3896a, iMax, this.f3897a);
        }
        this.f3901c = Math.min(charSequenceEllipsize.length(), this.f3901c);
        if (Build.VERSION.SDK_INT < 23) {
            b();
            try {
                Constructor<StaticLayout> constructor = f3893a;
                pf.b(constructor);
                Object obj = f8104a;
                pf.b(obj);
                return constructor.newInstance(charSequenceEllipsize, Integer.valueOf(this.b), Integer.valueOf(this.f3901c), this.f3896a, Integer.valueOf(iMax), this.f3895a, obj, Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f3899a), null, Integer.valueOf(iMax), Integer.valueOf(this.d));
            } catch (Exception e) {
                throw new yx(e);
            }
        }
        if (this.f3900b) {
            this.f3895a = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequenceEllipsize, this.b, this.f3901c, this.f3896a, iMax);
        builderObtain.setAlignment(this.f3895a);
        builderObtain.setIncludePad(this.f3899a);
        builderObtain.setTextDirection(this.f3900b ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f3897a;
        if (truncateAt != null) {
            builderObtain.setEllipsize(truncateAt);
        }
        builderObtain.setMaxLines(this.d);
        return builderObtain.build();
    }

    public final void b() throws yx {
        Class<?> cls;
        if (c) {
            return;
        }
        try {
            boolean z = this.f3900b && Build.VERSION.SDK_INT >= 23;
            if (Build.VERSION.SDK_INT >= 18) {
                cls = TextDirectionHeuristic.class;
                f8104a = z ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            } else {
                ClassLoader classLoader = zx.class.getClassLoader();
                String str = this.f3900b ? "RTL" : "LTR";
                Class<?> clsLoadClass = classLoader.loadClass("android.text.TextDirectionHeuristic");
                Class<?> clsLoadClass2 = classLoader.loadClass("android.text.TextDirectionHeuristics");
                f8104a = clsLoadClass2.getField(str).get(clsLoadClass2);
                cls = clsLoadClass;
            }
            Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, cls, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE);
            f3893a = declaredConstructor;
            declaredConstructor.setAccessible(true);
            c = true;
        } catch (Exception e) {
            throw new yx(e);
        }
    }

    public zx d(Layout.Alignment alignment) {
        this.f3895a = alignment;
        return this;
    }

    public zx e(TextUtils.TruncateAt truncateAt) {
        this.f3897a = truncateAt;
        return this;
    }

    public zx f(boolean z) {
        this.f3899a = z;
        return this;
    }

    public zx g(boolean z) {
        this.f3900b = z;
        return this;
    }

    public zx h(int i) {
        this.d = i;
        return this;
    }
}
