package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import g.d1;
import g.f0;
import g.n0;
import g.p0;
import g.t0;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import y0.g;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5262a = "TextViewCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5263b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5264c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Field f5265d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f5266e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Field f5267f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f5268g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Field f5269h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f5270i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Field f5271j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f5272k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f5273l = 1;

    @v0(16)
    public static class a {
        @g.u
        public static boolean a(TextView textView) {
            return textView.getIncludeFontPadding();
        }

        @g.u
        public static int b(TextView textView) {
            return textView.getMaxLines();
        }

        @g.u
        public static int c(TextView textView) {
            return textView.getMinLines();
        }
    }

    @v0(17)
    public static class b {
        @g.u
        public static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        @g.u
        public static int b(View view) {
            return view.getLayoutDirection();
        }

        @g.u
        public static int c(View view) {
            return view.getTextDirection();
        }

        @g.u
        public static Locale d(TextView textView) {
            return textView.getTextLocale();
        }

        @g.u
        public static void e(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        }

        @g.u
        public static void f(TextView textView, int i10, int i11, int i12, int i13) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i10, i11, i12, i13);
        }

        @g.u
        public static void g(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        @g.u
        public static void h(View view, int i10) {
            view.setTextDirection(i10);
        }
    }

    @v0(23)
    public static class c {
        @g.u
        public static int a(TextView textView) {
            return textView.getBreakStrategy();
        }

        @g.u
        public static ColorStateList b(TextView textView) {
            return textView.getCompoundDrawableTintList();
        }

        @g.u
        public static PorterDuff.Mode c(TextView textView) {
            return textView.getCompoundDrawableTintMode();
        }

        @g.u
        public static int d(TextView textView) {
            return textView.getHyphenationFrequency();
        }

        @g.u
        public static void e(TextView textView, int i10) {
            textView.setBreakStrategy(i10);
        }

        @g.u
        public static void f(TextView textView, ColorStateList colorStateList) {
            textView.setCompoundDrawableTintList(colorStateList);
        }

        @g.u
        public static void g(TextView textView, PorterDuff.Mode mode) {
            textView.setCompoundDrawableTintMode(mode);
        }

        @g.u
        public static void h(TextView textView, int i10) {
            textView.setHyphenationFrequency(i10);
        }
    }

    @v0(24)
    public static class d {
        @g.u
        public static DecimalFormatSymbols a(Locale locale) {
            return DecimalFormatSymbols.getInstance(locale);
        }
    }

    @v0(26)
    public static class e {
        @g.u
        public static int a(TextView textView) {
            return textView.getAutoSizeMaxTextSize();
        }

        @g.u
        public static int b(TextView textView) {
            return textView.getAutoSizeMinTextSize();
        }

        @g.u
        public static int c(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        @g.u
        public static int[] d(TextView textView) {
            return textView.getAutoSizeTextAvailableSizes();
        }

        @g.u
        public static int e(TextView textView) {
            return textView.getAutoSizeTextType();
        }

        @g.u
        public static void f(TextView textView, int i10, int i11, int i12, int i13) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
        }

        @g.u
        public static void g(TextView textView, int[] iArr, int i10) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
        }

        @g.u
        public static void h(TextView textView, int i10) {
            textView.setAutoSizeTextTypeWithDefaults(i10);
        }
    }

    @v0(28)
    public static class f {
        @g.u
        public static String[] a(DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }

        @g.u
        public static PrecomputedText.Params b(TextView textView) {
            return textView.getTextMetricsParams();
        }

        @g.u
        public static void c(TextView textView, int i10) {
            textView.setFirstBaselineToTopHeight(i10);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface g {
    }

    @v0(26)
    public static class h implements ActionMode.Callback {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f5274g = 100;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f5275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f5276b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Class<?> f5277c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Method f5278d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f5279e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f5280f = false;

        public h(ActionMode.Callback callback, TextView textView) {
            this.f5275a = callback;
            this.f5276b = textView;
        }

        public final Intent a() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        public final Intent b(ResolveInfo resolveInfo, TextView textView) {
            Intent intentPutExtra = a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !e(textView));
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            return intentPutExtra.setClassName(activityInfo.packageName, activityInfo.name);
        }

        public final List<ResolveInfo> c(Context context, PackageManager packageManager) {
            ArrayList arrayList = new ArrayList();
            if (!(context instanceof Activity)) {
                return arrayList;
            }
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(a(), 0)) {
                if (f(resolveInfo, context)) {
                    arrayList.add(resolveInfo);
                }
            }
            return arrayList;
        }

        @n0
        public ActionMode.Callback d() {
            return this.f5275a;
        }

        public final boolean e(TextView textView) {
            return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
        }

        public final boolean f(ResolveInfo resolveInfo, Context context) {
            if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                return true;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            if (!activityInfo.exported) {
                return false;
            }
            String str = activityInfo.permission;
            return str == null || context.checkSelfPermission(str) == 0;
        }

        public final void g(Menu menu) {
            Context context = this.f5276b.getContext();
            PackageManager packageManager = context.getPackageManager();
            if (!this.f5280f) {
                this.f5280f = true;
                try {
                    Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                    this.f5277c = cls;
                    this.f5278d = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                    this.f5279e = true;
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    this.f5277c = null;
                    this.f5278d = null;
                    this.f5279e = false;
                }
            }
            try {
                Method declaredMethod = (this.f5279e && this.f5277c.isInstance(menu)) ? this.f5278d : menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
                for (int size = menu.size() - 1; size >= 0; size--) {
                    MenuItem item = menu.getItem(size);
                    if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                        declaredMethod.invoke(menu, Integer.valueOf(size));
                    }
                }
                List<ResolveInfo> listC = c(context, packageManager);
                for (int i10 = 0; i10 < listC.size(); i10++) {
                    ResolveInfo resolveInfo = listC.get(i10);
                    menu.add(0, 0, i10 + 100, resolveInfo.loadLabel(packageManager)).setIntent(b(resolveInfo, this.f5276b)).setShowAsAction(1);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f5275a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f5275a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f5275a.onDestroyActionMode(actionMode);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            g(menu);
            return this.f5275a.onPrepareActionMode(actionMode, menu);
        }
    }

    public static void A(@n0 TextView textView, @t0 @f0(from = 0) int i10) {
        androidx.core.util.o.i(i10);
        if (Build.VERSION.SDK_INT >= 28) {
            f.c(textView, i10);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i11 = a.a(textView) ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i10 > Math.abs(i11)) {
            textView.setPadding(textView.getPaddingLeft(), i10 + i11, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void B(@n0 TextView textView, @t0 @f0(from = 0) int i10) {
        androidx.core.util.o.i(i10);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i11 = a.a(textView) ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i10 > Math.abs(i11)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i10 - i11);
        }
    }

    public static void C(@n0 TextView textView, @t0 @f0(from = 0) int i10) {
        androidx.core.util.o.i(i10);
        if (i10 != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i10 - r0, 1.0f);
        }
    }

    public static void D(@n0 TextView textView, @n0 y0.g gVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setText(gVar.f());
        } else {
            if (!o(textView).a(gVar.e())) {
                throw new IllegalArgumentException("Given text can not be applied to TextView.");
            }
            textView.setText(gVar);
        }
    }

    public static void E(@n0 TextView textView, @d1 int i10) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i10);
        } else {
            textView.setTextAppearance(textView.getContext(), i10);
        }
    }

    public static void F(@n0 TextView textView, @n0 g.a aVar) {
        int i10 = Build.VERSION.SDK_INT;
        b.h(textView, m(aVar.d()));
        if (i10 >= 23) {
            textView.getPaint().set(aVar.e());
            c.e(textView, aVar.b());
            c.h(textView, aVar.c());
        } else {
            float textScaleX = aVar.e().getTextScaleX();
            textView.getPaint().set(aVar.e());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
        }
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ActionMode.Callback G(@p0 ActionMode.Callback callback) {
        return (!(callback instanceof h) || Build.VERSION.SDK_INT < 26) ? callback : ((h) callback).d();
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ActionMode.Callback H(@n0 TextView textView, @p0 ActionMode.Callback callback) {
        int i10 = Build.VERSION.SDK_INT;
        return (i10 < 26 || i10 > 27 || (callback instanceof h) || callback == null) ? callback : new h(callback, textView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int a(@n0 TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return e.a(textView);
        }
        if (textView instanceof androidx.core.widget.b) {
            return ((androidx.core.widget.b) textView).getAutoSizeMaxTextSize();
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int b(@n0 TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return e.b(textView);
        }
        if (textView instanceof androidx.core.widget.b) {
            return ((androidx.core.widget.b) textView).getAutoSizeMinTextSize();
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int c(@n0 TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return e.c(textView);
        }
        if (textView instanceof androidx.core.widget.b) {
            return ((androidx.core.widget.b) textView).getAutoSizeStepGranularity();
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @n0
    public static int[] d(@n0 TextView textView) {
        return Build.VERSION.SDK_INT >= 27 ? e.d(textView) : textView instanceof androidx.core.widget.b ? ((androidx.core.widget.b) textView).getAutoSizeTextAvailableSizes() : new int[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int e(@n0 TextView textView) {
        if (Build.VERSION.SDK_INT >= 27) {
            return e.e(textView);
        }
        if (textView instanceof androidx.core.widget.b) {
            return ((androidx.core.widget.b) textView).getAutoSizeTextType();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @p0
    public static ColorStateList f(@n0 TextView textView) {
        androidx.core.util.o.l(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            return c.b(textView);
        }
        if (textView instanceof v) {
            return ((v) textView).getSupportCompoundDrawablesTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @p0
    public static PorterDuff.Mode g(@n0 TextView textView) {
        androidx.core.util.o.l(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            return c.c(textView);
        }
        if (textView instanceof v) {
            return ((v) textView).getSupportCompoundDrawablesTintMode();
        }
        return null;
    }

    @n0
    public static Drawable[] h(@n0 TextView textView) {
        return b.a(textView);
    }

    public static int i(@n0 TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int j(@n0 TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static int k(@n0 TextView textView) {
        return a.b(textView);
    }

    public static int l(@n0 TextView textView) {
        return a.c(textView);
    }

    @v0(18)
    public static int m(@n0 TextDirectionHeuristic textDirectionHeuristic) {
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL || textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 1;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
            return 2;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
            return 3;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
            return 4;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
            return 5;
        }
        if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            return 6;
        }
        return textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL ? 7 : 1;
    }

    @v0(18)
    public static TextDirectionHeuristic n(@n0 TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        if (Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
            byte directionality = Character.getDirectionality(f.a(d.a(b.d(textView)))[0].codePointAt(0));
            return (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        boolean z10 = b.b(textView) == 1;
        switch (b.c(textView)) {
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            default:
                if (!z10) {
                }
                break;
        }
        return TextDirectionHeuristics.LTR;
    }

    @n0
    public static g.a o(@n0 TextView textView) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            return new g.a(f.b(textView));
        }
        g.a.C0662a c0662a = new g.a.C0662a(new TextPaint(textView.getPaint()));
        if (i10 >= 23) {
            c0662a.b(c.a(textView));
            c0662a.c(c.d(textView));
        }
        c0662a.d(n(textView));
        return c0662a.a();
    }

    public static Field p(String str) {
        Field declaredField = null;
        try {
            declaredField = TextView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not retrieve ");
            sb2.append(str);
            sb2.append(" field.");
            return declaredField;
        }
    }

    public static int q(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not retrieve value of ");
            sb2.append(field.getName());
            sb2.append(" field.");
            return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void r(@n0 TextView textView, int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 27) {
            e.f(textView, i10, i11, i12, i13);
        } else if (textView instanceof androidx.core.widget.b) {
            ((androidx.core.widget.b) textView).setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void s(@n0 TextView textView, @n0 int[] iArr, int i10) throws IllegalArgumentException {
        if (Build.VERSION.SDK_INT >= 27) {
            e.g(textView, iArr, i10);
        } else if (textView instanceof androidx.core.widget.b) {
            ((androidx.core.widget.b) textView).setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void t(@n0 TextView textView, int i10) {
        if (Build.VERSION.SDK_INT >= 27) {
            e.h(textView, i10);
        } else if (textView instanceof androidx.core.widget.b) {
            ((androidx.core.widget.b) textView).setAutoSizeTextTypeWithDefaults(i10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void u(@n0 TextView textView, @p0 ColorStateList colorStateList) {
        androidx.core.util.o.l(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            c.f(textView, colorStateList);
        } else if (textView instanceof v) {
            ((v) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void v(@n0 TextView textView, @p0 PorterDuff.Mode mode) {
        androidx.core.util.o.l(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            c.g(textView, mode);
        } else if (textView instanceof v) {
            ((v) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    public static void w(@n0 TextView textView, @p0 Drawable drawable, @p0 Drawable drawable2, @p0 Drawable drawable3, @p0 Drawable drawable4) {
        b.e(textView, drawable, drawable2, drawable3, drawable4);
    }

    public static void x(@n0 TextView textView, @g.v int i10, @g.v int i11, @g.v int i12, @g.v int i13) {
        b.f(textView, i10, i11, i12, i13);
    }

    public static void y(@n0 TextView textView, @p0 Drawable drawable, @p0 Drawable drawable2, @p0 Drawable drawable3, @p0 Drawable drawable4) {
        b.g(textView, drawable, drawable2, drawable3, drawable4);
    }

    public static void z(@n0 TextView textView, @n0 ActionMode.Callback callback) {
        textView.setCustomSelectionActionModeCallback(H(textView, callback));
    }
}
