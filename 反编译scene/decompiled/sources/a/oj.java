package a;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.widget.TextView;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class oj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f7027a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f2253a;
    public static Field b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static boolean f2254b;

    public static Drawable[] a(TextView textView) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            return textView.getCompoundDrawablesRelative();
        }
        if (i < 17) {
            return textView.getCompoundDrawables();
        }
        boolean z = textView.getLayoutDirection() == 1;
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        if (z) {
            Drawable drawable = compoundDrawables[2];
            Drawable drawable2 = compoundDrawables[0];
            compoundDrawables[0] = drawable;
            compoundDrawables[2] = drawable2;
        }
        return compoundDrawables;
    }

    public static int b(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int c(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static int d(TextView textView) {
        if (Build.VERSION.SDK_INT >= 16) {
            return textView.getMaxLines();
        }
        if (!f2254b) {
            b = h("mMaxMode");
            f2254b = true;
        }
        Field field = b;
        if (field == null || i(field, textView) != 1) {
            return -1;
        }
        if (!f2253a) {
            f7027a = h("mMaximum");
            f2253a = true;
        }
        Field field2 = f7027a;
        if (field2 != null) {
            return i(field2, textView);
        }
        return -1;
    }

    public static int e(TextDirectionHeuristic textDirectionHeuristic) {
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

    public static TextDirectionHeuristic f(TextView textView) {
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            return TextDirectionHeuristics.LTR;
        }
        if (Build.VERSION.SDK_INT >= 28 && (textView.getInputType() & 15) == 3) {
            byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
            return (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        }
        boolean z = textView.getLayoutDirection() == 1;
        switch (textView.getTextDirection()) {
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
                if (!z) {
                }
                break;
        }
        return TextDirectionHeuristics.LTR;
    }

    public static we g(TextView textView) {
        if (Build.VERSION.SDK_INT >= 28) {
            return new we(textView.getTextMetricsParams());
        }
        ve veVar = new ve(new TextPaint(textView.getPaint()));
        if (Build.VERSION.SDK_INT >= 23) {
            veVar.b(textView.getBreakStrategy());
            veVar.c(textView.getHyphenationFrequency());
        }
        if (Build.VERSION.SDK_INT >= 18) {
            veVar.d(f(textView));
        }
        return veVar.a();
    }

    public static Field h(String str) {
        Field declaredField = null;
        try {
            declaredField = TextView.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (NoSuchFieldException unused) {
            Log.e("TextViewCompat", "Could not retrieve " + str + " field.");
            return declaredField;
        }
    }

    public static int i(Field field, TextView textView) {
        try {
            return field.getInt(textView);
        } catch (IllegalAccessException unused) {
            Log.d("TextViewCompat", "Could not retrieve value of " + field.getName() + " field.");
            return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void j(TextView textView, ColorStateList colorStateList) {
        pf.b(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintList(colorStateList);
        } else if (textView instanceof qj) {
            ((qj) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void k(TextView textView, PorterDuff.Mode mode) {
        pf.b(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            textView.setCompoundDrawableTintMode(mode);
        } else if (textView instanceof qj) {
            ((qj) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    public static void l(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
            return;
        }
        if (i < 17) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
            return;
        }
        boolean z = textView.getLayoutDirection() == 1;
        Drawable drawable5 = z ? drawable3 : drawable;
        if (!z) {
            drawable = drawable3;
        }
        textView.setCompoundDrawables(drawable5, drawable2, drawable, drawable4);
    }

    public static void m(TextView textView, int i) {
        pf.a(i);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i2 = (Build.VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), i + i2, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void n(TextView textView, int i) {
        pf.a(i);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i2 = (Build.VERSION.SDK_INT < 16 || textView.getIncludeFontPadding()) ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
        }
    }

    public static void o(TextView textView, int i) {
        pf.a(i);
        if (i != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i - r0, 1.0f);
        }
    }

    public static void p(TextView textView, xe xeVar) {
        xe xeVarB;
        if (Build.VERSION.SDK_INT >= 29) {
            xeVarB = xeVar.b();
        } else {
            boolean zA = g(textView).a(xeVar.a());
            xeVarB = xeVar;
            if (!zA) {
                throw new IllegalArgumentException("Given text can not be applied to TextView.");
            }
        }
        textView.setText(xeVarB);
    }

    public static void q(TextView textView, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i);
        } else {
            textView.setTextAppearance(textView.getContext(), i);
        }
    }

    public static void r(TextView textView, we weVar) {
        if (Build.VERSION.SDK_INT >= 18) {
            textView.setTextDirection(e(weVar.d()));
        }
        if (Build.VERSION.SDK_INT >= 23) {
            textView.getPaint().set(weVar.e());
            textView.setBreakStrategy(weVar.b());
            textView.setHyphenationFrequency(weVar.c());
        } else {
            float textScaleX = weVar.e().getTextScaleX();
            textView.getPaint().set(weVar.e());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
        }
    }

    public static ActionMode.Callback s(TextView textView, ActionMode.Callback callback) {
        int i = Build.VERSION.SDK_INT;
        return (i < 26 || i > 27 || (callback instanceof nj)) ? callback : new nj(callback, textView);
    }
}
