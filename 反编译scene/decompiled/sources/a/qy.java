package a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class qy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f7250a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f2652a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ColorStateList f2653a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Typeface f2654a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f2655a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2656a = false;
    public final float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int f2657b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ColorStateList f2658b;
    public final float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final int f2659c;
    public final float d;

    public qy(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, jv.TextAppearance);
        this.f7250a = typedArrayObtainStyledAttributes.getDimension(jv.TextAppearance_android_textSize, 0.0f);
        this.f2653a = ny.a(context, typedArrayObtainStyledAttributes, jv.TextAppearance_android_textColor);
        ny.a(context, typedArrayObtainStyledAttributes, jv.TextAppearance_android_textColorHint);
        ny.a(context, typedArrayObtainStyledAttributes, jv.TextAppearance_android_textColorLink);
        this.f2652a = typedArrayObtainStyledAttributes.getInt(jv.TextAppearance_android_textStyle, 0);
        this.f2657b = typedArrayObtainStyledAttributes.getInt(jv.TextAppearance_android_typeface, 1);
        int iE = ny.e(typedArrayObtainStyledAttributes, jv.TextAppearance_fontFamily, jv.TextAppearance_android_fontFamily);
        this.f2659c = typedArrayObtainStyledAttributes.getResourceId(iE, 0);
        this.f2655a = typedArrayObtainStyledAttributes.getString(iE);
        typedArrayObtainStyledAttributes.getBoolean(jv.TextAppearance_textAllCaps, false);
        this.f2658b = ny.a(context, typedArrayObtainStyledAttributes, jv.TextAppearance_android_shadowColor);
        this.b = typedArrayObtainStyledAttributes.getFloat(jv.TextAppearance_android_shadowDx, 0.0f);
        this.c = typedArrayObtainStyledAttributes.getFloat(jv.TextAppearance_android_shadowDy, 0.0f);
        this.d = typedArrayObtainStyledAttributes.getFloat(jv.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void d() {
        String str;
        if (this.f2654a == null && (str = this.f2655a) != null) {
            this.f2654a = Typeface.create(str, this.f2652a);
        }
        if (this.f2654a == null) {
            int i = this.f2657b;
            this.f2654a = i != 1 ? i != 2 ? i != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            this.f2654a = Typeface.create(this.f2654a, this.f2652a);
        }
    }

    public Typeface e() {
        d();
        return this.f2654a;
    }

    public Typeface f(Context context) {
        if (this.f2656a) {
            return this.f2654a;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceB = rc.b(context, this.f2659c);
                this.f2654a = typefaceB;
                if (typefaceB != null) {
                    this.f2654a = Typeface.create(typefaceB, this.f2652a);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e) {
                Log.d("TextAppearance", "Error loading font " + this.f2655a, e);
            }
        }
        d();
        this.f2656a = true;
        return this.f2654a;
    }

    public void g(Context context, TextPaint textPaint, sy syVar) {
        k(textPaint, e());
        h(context, new py(this, textPaint, syVar));
    }

    public void h(Context context, sy syVar) {
        if (ry.a()) {
            f(context);
        } else {
            d();
        }
        if (this.f2659c == 0) {
            this.f2656a = true;
        }
        if (this.f2656a) {
            syVar.b(this.f2654a, true);
            return;
        }
        try {
            rc.d(context, this.f2659c, new oy(this, syVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f2656a = true;
            syVar.a(1);
        } catch (Exception e) {
            Log.d("TextAppearance", "Error loading font " + this.f2655a, e);
            this.f2656a = true;
            syVar.a(-3);
        }
    }

    public void i(Context context, TextPaint textPaint, sy syVar) {
        j(context, textPaint, syVar);
        ColorStateList colorStateList = this.f2653a;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f = this.d;
        float f2 = this.b;
        float f3 = this.c;
        ColorStateList colorStateList2 = this.f2658b;
        textPaint.setShadowLayer(f, f2, f3, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void j(Context context, TextPaint textPaint, sy syVar) {
        if (ry.a()) {
            k(textPaint, f(context));
        } else {
            g(context, textPaint, syVar);
        }
    }

    public void k(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int i = (~typeface.getStyle()) & this.f2652a;
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f7250a);
    }
}
