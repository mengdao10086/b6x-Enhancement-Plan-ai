package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LineHeightSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ReplacementSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.text.style.UpdateAppearance;
import android.view.View;
import android.widget.TextView;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class SpanUtils {

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int f11542b0 = -16777217;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int f11543c0 = 0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f11544d0 = 1;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f11545e0 = 2;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f11546f0 = 3;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final String f11547g0 = System.getProperty("line.separator");
    public String A;
    public Typeface B;
    public Layout.Alignment C;
    public int D;
    public ClickableSpan E;
    public String F;
    public float G;
    public BlurMaskFilter.Blur H;
    public Shader I;
    public float J;
    public float K;
    public float L;
    public int M;
    public Object[] N;
    public Bitmap O;
    public Drawable P;
    public Uri Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public SerializableSpannableStringBuilder V;
    public boolean W;
    public int X;
    public final int Y;
    public final int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f11548a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final int f11549a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f11550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f11555g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f11556h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f11557i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f11558j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f11559k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f11560l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f11561m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f11562n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f11563o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f11564p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f11565q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f11566r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f11567s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f11568t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f11569u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f11570v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f11571w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f11572x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f11573y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f11574z;

    @SuppressLint({"ParcelCreator"})
    public static class CustomTypefaceSpan extends TypefaceSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Typeface f11575a;

        public /* synthetic */ CustomTypefaceSpan(Typeface typeface, a aVar) {
            this(typeface);
        }

        public final void a(Paint paint, Typeface typeface) {
            Typeface typeface2 = paint.getTypeface();
            int style = (typeface2 == null ? 0 : typeface2.getStyle()) & (~typeface.getStyle());
            if ((style & 1) != 0) {
                paint.setFakeBoldText(true);
            }
            if ((style & 2) != 0) {
                paint.setTextSkewX(-0.25f);
            }
            paint.getShader();
            paint.setTypeface(typeface);
        }

        @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            a(textPaint, this.f11575a);
        }

        @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
        public void updateMeasureState(TextPaint textPaint) {
            a(textPaint, this.f11575a);
        }

        public CustomTypefaceSpan(Typeface typeface) {
            super("");
            this.f11575a = typeface;
        }
    }

    public static class SerializableSpannableStringBuilder extends SpannableStringBuilder implements Serializable {
        private static final long serialVersionUID = 4909567650765875771L;

        private SerializableSpannableStringBuilder() {
        }

        public /* synthetic */ SerializableSpannableStringBuilder(a aVar) {
            this();
        }
    }

    public class a extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f11576a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f11577b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f11578c;

        public a(int i10, boolean z10, View.OnClickListener onClickListener) {
            this.f11576a = i10;
            this.f11577b = z10;
            this.f11578c = onClickListener;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@g.n0 View view) {
            Objects.requireNonNull(view, "Argument 'widget' of type View (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            View.OnClickListener onClickListener = this.f11578c;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@g.n0 TextPaint textPaint) {
            Objects.requireNonNull(textPaint, "Argument 'paint' of type TextPaint (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            textPaint.setColor(this.f11576a);
            textPaint.setUnderlineText(this.f11577b);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public static class c implements LeadingMarginSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f11581b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f11582c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Path f11583d;

        public /* synthetic */ c(int i10, int i11, int i12, a aVar) {
            this(i10, i11, i12);
        }

        @Override // android.text.style.LeadingMarginSpan
        public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
            if (((Spanned) charSequence).getSpanStart(this) == i15) {
                Paint.Style style = paint.getStyle();
                int color = paint.getColor();
                paint.setColor(this.f11580a);
                paint.setStyle(Paint.Style.FILL);
                if (canvas.isHardwareAccelerated()) {
                    if (this.f11583d == null) {
                        Path path = new Path();
                        this.f11583d = path;
                        path.addCircle(0.0f, 0.0f, this.f11581b, Path.Direction.CW);
                    }
                    canvas.save();
                    canvas.translate(i10 + (i11 * this.f11581b), (i12 + i14) / 2.0f);
                    canvas.drawPath(this.f11583d, paint);
                    canvas.restore();
                } else {
                    canvas.drawCircle(i10 + (i11 * r10), (i12 + i14) / 2.0f, this.f11581b, paint);
                }
                paint.setColor(color);
                paint.setStyle(style);
            }
        }

        @Override // android.text.style.LeadingMarginSpan
        public int getLeadingMargin(boolean z10) {
            return (this.f11581b * 2) + this.f11582c;
        }

        public c(int i10, int i11, int i12) {
            this.f11583d = null;
            this.f11580a = i10;
            this.f11581b = i11;
            this.f11582c = i12;
        }
    }

    public static abstract class d extends ReplacementSpan {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f11584c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f11585d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f11586e = 2;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f11587f = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WeakReference<Drawable> f11589b;

        public /* synthetic */ d(int i10, a aVar) {
            this(i10);
        }

        public final Drawable a() {
            WeakReference<Drawable> weakReference = this.f11589b;
            Drawable drawable = weakReference != null ? weakReference.get() : null;
            if (drawable != null) {
                return drawable;
            }
            Drawable drawableB = b();
            this.f11589b = new WeakReference<>(drawableB);
            return drawableB;
        }

        public abstract Drawable b();

        @Override // android.text.style.ReplacementSpan
        public void draw(@g.n0 Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, @g.n0 Paint paint) {
            int iHeight;
            float fHeight;
            Objects.requireNonNull(canvas, "Argument 'canvas' of type Canvas (#0 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Objects.requireNonNull(paint, "Argument 'paint' of type Paint (#8 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Drawable drawableA = a();
            Rect bounds = drawableA.getBounds();
            canvas.save();
            if (bounds.height() < i14 - i12) {
                int i15 = this.f11588a;
                if (i15 == 3) {
                    fHeight = i12;
                } else {
                    if (i15 == 2) {
                        iHeight = ((i14 + i12) - bounds.height()) / 2;
                    } else if (i15 == 1) {
                        fHeight = i13 - bounds.height();
                    } else {
                        iHeight = i14 - bounds.height();
                    }
                    fHeight = iHeight;
                }
                canvas.translate(f10, fHeight);
            } else {
                canvas.translate(f10, i12);
            }
            drawableA.draw(canvas);
            canvas.restore();
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(@g.n0 Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
            int i12;
            Objects.requireNonNull(paint, "Argument 'paint' of type Paint (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Rect bounds = a().getBounds();
            if (fontMetricsInt != null && (i12 = fontMetricsInt.bottom - fontMetricsInt.top) < bounds.height()) {
                int i13 = this.f11588a;
                if (i13 == 3) {
                    fontMetricsInt.top = fontMetricsInt.top;
                    fontMetricsInt.bottom = bounds.height() + fontMetricsInt.top;
                } else if (i13 == 2) {
                    int i14 = i12 / 4;
                    fontMetricsInt.top = ((-bounds.height()) / 2) - i14;
                    fontMetricsInt.bottom = (bounds.height() / 2) - i14;
                } else {
                    int i15 = -bounds.height();
                    int i16 = fontMetricsInt.bottom;
                    fontMetricsInt.top = i15 + i16;
                    fontMetricsInt.bottom = i16;
                }
                fontMetricsInt.ascent = fontMetricsInt.top;
                fontMetricsInt.descent = fontMetricsInt.bottom;
            }
            return bounds.right;
        }

        public d() {
            this.f11588a = 0;
        }

        public d(int i10) {
            this.f11588a = i10;
        }
    }

    public static class e extends d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Drawable f11590g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Uri f11591h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f11592i;

        public /* synthetic */ e(int i10, int i11, a aVar) {
            this(i10, i11);
        }

        @Override // com.blankj.utilcode.util.SpanUtils.d
        public Drawable b() {
            Drawable drawableI;
            BitmapDrawable bitmapDrawable;
            InputStream inputStreamOpenInputStream;
            BitmapDrawable bitmapDrawable2;
            Drawable drawable = this.f11590g;
            if (drawable != null) {
                return drawable;
            }
            if (this.f11591h != null) {
                try {
                    inputStreamOpenInputStream = j1.a().getContentResolver().openInputStream(this.f11591h);
                    bitmapDrawable2 = new BitmapDrawable(j1.a().getResources(), BitmapFactory.decodeStream(inputStreamOpenInputStream));
                } catch (Exception unused) {
                    bitmapDrawable = null;
                }
                try {
                    bitmapDrawable2.setBounds(0, 0, bitmapDrawable2.getIntrinsicWidth(), bitmapDrawable2.getIntrinsicHeight());
                    if (inputStreamOpenInputStream != null) {
                        inputStreamOpenInputStream.close();
                    }
                    return bitmapDrawable2;
                } catch (Exception unused2) {
                    bitmapDrawable = bitmapDrawable2;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to loaded content ");
                    sb2.append(this.f11591h);
                    return bitmapDrawable;
                }
            }
            try {
                drawableI = h0.d.i(j1.a(), this.f11592i);
                try {
                    drawableI.setBounds(0, 0, drawableI.getIntrinsicWidth(), drawableI.getIntrinsicHeight());
                    return drawableI;
                } catch (Exception unused3) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Unable to find resource: ");
                    sb3.append(this.f11592i);
                    return drawableI;
                }
            } catch (Exception unused4) {
                drawableI = null;
            }
        }

        public /* synthetic */ e(Bitmap bitmap, int i10, a aVar) {
            this(bitmap, i10);
        }

        public /* synthetic */ e(Drawable drawable, int i10, a aVar) {
            this(drawable, i10);
        }

        public /* synthetic */ e(Uri uri, int i10, a aVar) {
            this(uri, i10);
        }

        public e(Bitmap bitmap, int i10) {
            super(i10, null);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(j1.a().getResources(), bitmap);
            this.f11590g = bitmapDrawable;
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), this.f11590g.getIntrinsicHeight());
        }

        public e(Drawable drawable, int i10) {
            super(i10, null);
            this.f11590g = drawable;
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f11590g.getIntrinsicHeight());
        }

        public e(Uri uri, int i10) {
            super(i10, null);
            this.f11591h = uri;
        }

        public e(@g.v int i10, int i11) {
            super(i11, null);
            this.f11592i = i10;
        }
    }

    public static class f implements LineHeightSpan {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f11593c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f11594d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static Paint.FontMetricsInt f11595e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f11597b;

        public f(int i10, int i11) {
            this.f11596a = i10;
            this.f11597b = i11;
        }

        @Override // android.text.style.LineHeightSpan
        public void chooseHeight(CharSequence charSequence, int i10, int i11, int i12, int i13, Paint.FontMetricsInt fontMetricsInt) {
            Paint.FontMetricsInt fontMetricsInt2 = f11595e;
            if (fontMetricsInt2 == null) {
                Paint.FontMetricsInt fontMetricsInt3 = new Paint.FontMetricsInt();
                f11595e = fontMetricsInt3;
                fontMetricsInt3.top = fontMetricsInt.top;
                fontMetricsInt3.ascent = fontMetricsInt.ascent;
                fontMetricsInt3.descent = fontMetricsInt.descent;
                fontMetricsInt3.bottom = fontMetricsInt.bottom;
                fontMetricsInt3.leading = fontMetricsInt.leading;
            } else {
                fontMetricsInt.top = fontMetricsInt2.top;
                fontMetricsInt.ascent = fontMetricsInt2.ascent;
                fontMetricsInt.descent = fontMetricsInt2.descent;
                fontMetricsInt.bottom = fontMetricsInt2.bottom;
                fontMetricsInt.leading = fontMetricsInt2.leading;
            }
            int i14 = this.f11596a;
            int i15 = fontMetricsInt.descent;
            int i16 = fontMetricsInt.ascent;
            int i17 = i14 - (((i13 + i15) - i16) - i12);
            if (i17 > 0) {
                int i18 = this.f11597b;
                if (i18 == 3) {
                    fontMetricsInt.descent = i15 + i17;
                } else if (i18 == 2) {
                    int i19 = i17 / 2;
                    fontMetricsInt.descent = i15 + i19;
                    fontMetricsInt.ascent = i16 - i19;
                } else {
                    fontMetricsInt.ascent = i16 - i17;
                }
            }
            int i20 = fontMetricsInt.bottom;
            int i21 = fontMetricsInt.top;
            int i22 = i14 - (((i13 + i20) - i21) - i12);
            if (i22 > 0) {
                int i23 = this.f11597b;
                if (i23 == 3) {
                    fontMetricsInt.bottom = i20 + i22;
                } else if (i23 == 2) {
                    int i24 = i22 / 2;
                    fontMetricsInt.bottom = i20 + i24;
                    fontMetricsInt.top = i21 - i24;
                } else {
                    fontMetricsInt.top = i21 - i22;
                }
            }
            if (i11 == ((Spanned) charSequence).getSpanEnd(this)) {
                f11595e = null;
            }
        }
    }

    public static class g implements LeadingMarginSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f11599b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f11600c;

        public /* synthetic */ g(int i10, int i11, int i12, a aVar) {
            this(i10, i11, i12);
        }

        @Override // android.text.style.LeadingMarginSpan
        public void drawLeadingMargin(Canvas canvas, Paint paint, int i10, int i11, int i12, int i13, int i14, CharSequence charSequence, int i15, int i16, boolean z10, Layout layout) {
            Paint.Style style = paint.getStyle();
            int color = paint.getColor();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.f11598a);
            canvas.drawRect(i10, i12, i10 + (this.f11599b * i11), i14, paint);
            paint.setStyle(style);
            paint.setColor(color);
        }

        @Override // android.text.style.LeadingMarginSpan
        public int getLeadingMargin(boolean z10) {
            return this.f11599b + this.f11600c;
        }

        public g(int i10, int i11, int i12) {
            this.f11598a = i10;
            this.f11599b = i11;
            this.f11600c = i12;
        }
    }

    public static class h extends CharacterStyle implements UpdateAppearance {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Shader f11601a;

        public /* synthetic */ h(Shader shader, a aVar) {
            this(shader);
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setShader(this.f11601a);
        }

        public h(Shader shader) {
            this.f11601a = shader;
        }
    }

    public static class i extends CharacterStyle implements UpdateAppearance {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f11602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f11603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f11604c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11605d;

        public /* synthetic */ i(float f10, float f11, float f12, int i10, a aVar) {
            this(f10, f11, f12, i10);
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setShadowLayer(this.f11602a, this.f11603b, this.f11604c, this.f11605d);
        }

        public i(float f10, float f11, float f12, int i10) {
            this.f11602a = f10;
            this.f11603b = f11;
            this.f11604c = f12;
            this.f11605d = i10;
        }
    }

    public static class j extends ReplacementSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11606a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f11607b;

        public /* synthetic */ j(int i10, int i11, a aVar) {
            this(i10, i11);
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(@g.n0 Canvas canvas, CharSequence charSequence, @g.f0(from = 0) int i10, @g.f0(from = 0) int i11, float f10, int i12, int i13, int i14, @g.n0 Paint paint) {
            Objects.requireNonNull(canvas, "Argument 'canvas' of type Canvas (#0 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Objects.requireNonNull(paint, "Argument 'paint' of type Paint (#8 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            canvas.drawRect(f10, i12, f10 + this.f11606a, i14, this.f11607b);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(@g.n0 Paint paint, CharSequence charSequence, @g.f0(from = 0) int i10, @g.f0(from = 0) int i11, @g.p0 Paint.FontMetricsInt fontMetricsInt) {
            Objects.requireNonNull(paint, "Argument 'paint' of type Paint (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            return this.f11606a;
        }

        public j(int i10) {
            this(i10, 0);
        }

        public j(int i10, int i11) {
            Paint paint = new Paint();
            this.f11607b = paint;
            this.f11606a = i10;
            paint.setColor(i11);
            paint.setStyle(Paint.Style.FILL);
        }
    }

    public static class k extends ReplacementSpan {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f11608b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f11609c = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11610a;

        public k(int i10) {
            this.f11610a = i10;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(@g.n0 Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, @g.n0 Paint paint) {
            Objects.requireNonNull(canvas, "Argument 'canvas' of type Canvas (#0 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            Objects.requireNonNull(paint, "Argument 'paint' of type Paint (#8 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            CharSequence charSequenceSubSequence = charSequence.subSequence(i10, i11);
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            canvas.drawText(charSequenceSubSequence.toString(), f10, i13 - (((((fontMetricsInt.descent + i13) + i13) + fontMetricsInt.ascent) / 2) - ((i14 + i12) / 2)), paint);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(@g.n0 Paint paint, CharSequence charSequence, int i10, int i11, @g.p0 Paint.FontMetricsInt fontMetricsInt) {
            Objects.requireNonNull(paint, "Argument 'paint' of type Paint (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            return (int) paint.measureText(charSequence.subSequence(i10, i11).toString());
        }
    }

    public SpanUtils(TextView textView) {
        this();
        this.f11548a = textView;
    }

    public static SpanUtils b0(TextView textView) {
        return new SpanUtils(textView);
    }

    public SpanUtils A(int i10) {
        this.f11551c = i10;
        return this;
    }

    public SpanUtils B(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'fontFamily' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.A = str;
        return this;
    }

    public SpanUtils C(float f10) {
        this.f11566r = f10;
        return this;
    }

    public SpanUtils D(@g.f0(from = 0) int i10) {
        return E(i10, false);
    }

    public SpanUtils E(@g.f0(from = 0) int i10, boolean z10) {
        this.f11564p = i10;
        this.f11565q = z10;
        return this;
    }

    public SpanUtils F(float f10) {
        this.f11567s = f10;
        return this;
    }

    public SpanUtils G(@g.l int i10) {
        this.f11552d = i10;
        return this;
    }

    public SpanUtils H(@g.n0 Layout.Alignment alignment) {
        Objects.requireNonNull(alignment, "Argument 'alignment' of type Alignment (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.C = alignment;
        return this;
    }

    public SpanUtils I() {
        this.f11573y = true;
        return this;
    }

    public SpanUtils J(@g.f0(from = 0) int i10, @g.f0(from = 0) int i11) {
        this.f11559k = i10;
        this.f11560l = i11;
        return this;
    }

    public SpanUtils K(@g.f0(from = 0) int i10) {
        return L(i10, 2);
    }

    public SpanUtils L(@g.f0(from = 0) int i10, int i11) {
        this.f11554f = i10;
        this.f11555g = i11;
        return this;
    }

    public SpanUtils M(@g.l int i10) {
        return N(i10, 2, 2);
    }

    public SpanUtils N(@g.l int i10, @g.f0(from = 1) int i11, @g.f0(from = 0) int i12) {
        this.f11556h = i10;
        this.f11557i = i11;
        this.f11558j = i12;
        return this;
    }

    public SpanUtils O(@g.n0 Shader shader) {
        Objects.requireNonNull(shader, "Argument 'shader' of type Shader (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.I = shader;
        return this;
    }

    public SpanUtils P(@g.x(from = 0.0d, fromInclusive = false) float f10, float f11, float f12, int i10) {
        this.J = f10;
        this.K = f11;
        this.L = f12;
        this.M = i10;
        return this;
    }

    public SpanUtils Q(@g.n0 Object... objArr) {
        Objects.requireNonNull(objArr, "Argument 'spans' of type Object[] (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (objArr.length > 0) {
            this.N = objArr;
        }
        return this;
    }

    public SpanUtils R() {
        this.f11568t = true;
        return this;
    }

    public SpanUtils S() {
        this.f11571w = true;
        return this;
    }

    public SpanUtils T() {
        this.f11570v = true;
        return this;
    }

    public SpanUtils U(@g.n0 Typeface typeface) {
        Objects.requireNonNull(typeface, "Argument 'typeface' of type Typeface (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.B = typeface;
        return this;
    }

    public SpanUtils V() {
        this.f11569u = true;
        return this;
    }

    public SpanUtils W(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'url' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        TextView textView = this.f11548a;
        if (textView != null && textView.getMovementMethod() == null) {
            this.f11548a.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.F = str;
        return this;
    }

    public SpanUtils X(int i10) {
        this.D = i10;
        return this;
    }

    public final void Y() {
        if (this.f11550b.length() == 0) {
            return;
        }
        int length = this.V.length();
        if (length == 0 && this.f11554f != -1) {
            this.V.append((CharSequence) Character.toString((char) 2)).append((CharSequence) "\n").setSpan(new AbsoluteSizeSpan(0), 0, 2, 33);
            length = 2;
        }
        this.V.append(this.f11550b);
        int length2 = this.V.length();
        if (this.D != -1) {
            this.V.setSpan(new k(this.D), length, length2, this.f11551c);
        }
        if (this.f11552d != -16777217) {
            this.V.setSpan(new ForegroundColorSpan(this.f11552d), length, length2, this.f11551c);
        }
        if (this.f11553e != -16777217) {
            this.V.setSpan(new BackgroundColorSpan(this.f11553e), length, length2, this.f11551c);
        }
        if (this.f11559k != -1) {
            this.V.setSpan(new LeadingMarginSpan.Standard(this.f11559k, this.f11560l), length, length2, this.f11551c);
        }
        int i10 = this.f11556h;
        a aVar = null;
        if (i10 != -16777217) {
            this.V.setSpan(new g(i10, this.f11557i, this.f11558j, aVar), length, length2, this.f11551c);
        }
        int i11 = this.f11561m;
        if (i11 != -16777217) {
            this.V.setSpan(new c(i11, this.f11562n, this.f11563o, aVar), length, length2, this.f11551c);
        }
        if (this.f11564p != -1) {
            this.V.setSpan(new AbsoluteSizeSpan(this.f11564p, this.f11565q), length, length2, this.f11551c);
        }
        if (this.f11566r != -1.0f) {
            this.V.setSpan(new RelativeSizeSpan(this.f11566r), length, length2, this.f11551c);
        }
        if (this.f11567s != -1.0f) {
            this.V.setSpan(new ScaleXSpan(this.f11567s), length, length2, this.f11551c);
        }
        int i12 = this.f11554f;
        if (i12 != -1) {
            this.V.setSpan(new f(i12, this.f11555g), length, length2, this.f11551c);
        }
        if (this.f11568t) {
            this.V.setSpan(new StrikethroughSpan(), length, length2, this.f11551c);
        }
        if (this.f11569u) {
            this.V.setSpan(new UnderlineSpan(), length, length2, this.f11551c);
        }
        if (this.f11570v) {
            this.V.setSpan(new SuperscriptSpan(), length, length2, this.f11551c);
        }
        if (this.f11571w) {
            this.V.setSpan(new SubscriptSpan(), length, length2, this.f11551c);
        }
        if (this.f11572x) {
            this.V.setSpan(new StyleSpan(1), length, length2, this.f11551c);
        }
        if (this.f11573y) {
            this.V.setSpan(new StyleSpan(2), length, length2, this.f11551c);
        }
        if (this.f11574z) {
            this.V.setSpan(new StyleSpan(3), length, length2, this.f11551c);
        }
        if (this.A != null) {
            this.V.setSpan(new TypefaceSpan(this.A), length, length2, this.f11551c);
        }
        if (this.B != null) {
            this.V.setSpan(new CustomTypefaceSpan(this.B, aVar), length, length2, this.f11551c);
        }
        if (this.C != null) {
            this.V.setSpan(new AlignmentSpan.Standard(this.C), length, length2, this.f11551c);
        }
        ClickableSpan clickableSpan = this.E;
        if (clickableSpan != null) {
            this.V.setSpan(clickableSpan, length, length2, this.f11551c);
        }
        if (this.F != null) {
            this.V.setSpan(new URLSpan(this.F), length, length2, this.f11551c);
        }
        if (this.G != -1.0f) {
            this.V.setSpan(new MaskFilterSpan(new BlurMaskFilter(this.G, this.H)), length, length2, this.f11551c);
        }
        if (this.I != null) {
            this.V.setSpan(new h(this.I, aVar), length, length2, this.f11551c);
        }
        if (this.J != -1.0f) {
            this.V.setSpan(new i(this.J, this.K, this.L, this.M, null), length, length2, this.f11551c);
        }
        Object[] objArr = this.N;
        if (objArr != null) {
            for (Object obj : objArr) {
                this.V.setSpan(obj, length, length2, this.f11551c);
            }
        }
    }

    public final void Z() {
        int length = this.V.length();
        this.f11550b = "<img>";
        Y();
        int length2 = this.V.length();
        a aVar = null;
        if (this.O != null) {
            this.V.setSpan(new e(this.O, this.S, aVar), length, length2, this.f11551c);
            return;
        }
        if (this.P != null) {
            this.V.setSpan(new e(this.P, this.S, aVar), length, length2, this.f11551c);
        } else if (this.Q != null) {
            this.V.setSpan(new e(this.Q, this.S, aVar), length, length2, this.f11551c);
        } else if (this.R != -1) {
            this.V.setSpan(new e(this.R, this.S, aVar), length, length2, this.f11551c);
        }
    }

    public SpanUtils a(@g.n0 CharSequence charSequence) {
        Objects.requireNonNull(charSequence, "Argument 'text' of type CharSequence (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        n(0);
        this.f11550b = charSequence;
        return this;
    }

    public final void a0() {
        int length = this.V.length();
        this.f11550b = "< >";
        Y();
        this.V.setSpan(new j(this.T, this.U, null), length, this.V.length(), this.f11551c);
    }

    public SpanUtils b(@g.v int i10) {
        return c(i10, 0);
    }

    public SpanUtils c(@g.v int i10, int i11) {
        n(1);
        this.R = i10;
        this.S = i11;
        return this;
    }

    public SpanUtils d(@g.n0 Bitmap bitmap) {
        Objects.requireNonNull(bitmap, "Argument 'bitmap' of type Bitmap (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return e(bitmap, 0);
    }

    public SpanUtils e(@g.n0 Bitmap bitmap, int i10) {
        Objects.requireNonNull(bitmap, "Argument 'bitmap' of type Bitmap (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        n(1);
        this.O = bitmap;
        this.S = i10;
        return this;
    }

    public SpanUtils f(@g.n0 Drawable drawable) {
        Objects.requireNonNull(drawable, "Argument 'drawable' of type Drawable (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return g(drawable, 0);
    }

    public SpanUtils g(@g.n0 Drawable drawable, int i10) {
        Objects.requireNonNull(drawable, "Argument 'drawable' of type Drawable (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        n(1);
        this.P = drawable;
        this.S = i10;
        return this;
    }

    public SpanUtils h(@g.n0 Uri uri) {
        Objects.requireNonNull(uri, "Argument 'uri' of type Uri (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return i(uri, 0);
    }

    public SpanUtils i(@g.n0 Uri uri, int i10) {
        Objects.requireNonNull(uri, "Argument 'uri' of type Uri (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        n(1);
        this.Q = uri;
        this.S = i10;
        return this;
    }

    public SpanUtils j() {
        n(0);
        this.f11550b = f11547g0;
        return this;
    }

    public SpanUtils k(@g.n0 CharSequence charSequence) {
        Objects.requireNonNull(charSequence, "Argument 'text' of type CharSequence (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        n(0);
        this.f11550b = ((Object) charSequence) + f11547g0;
        return this;
    }

    public SpanUtils l(@g.f0(from = 0) int i10) {
        return m(i10, 0);
    }

    public SpanUtils m(@g.f0(from = 0) int i10, @g.l int i11) {
        n(2);
        this.T = i10;
        this.U = i11;
        return this;
    }

    public final void n(int i10) {
        o();
        this.X = i10;
    }

    public final void o() {
        if (this.W) {
            return;
        }
        int i10 = this.X;
        if (i10 == 0) {
            Y();
        } else if (i10 == 1) {
            Z();
        } else if (i10 == 2) {
            a0();
        }
        z();
    }

    public SpannableStringBuilder p() {
        o();
        TextView textView = this.f11548a;
        if (textView != null) {
            textView.setText(this.V);
        }
        this.W = true;
        return this.V;
    }

    public SpannableStringBuilder q() {
        return this.V;
    }

    public SpanUtils r(@g.l int i10) {
        this.f11553e = i10;
        return this;
    }

    public SpanUtils s(@g.x(from = 0.0d, fromInclusive = false) float f10, BlurMaskFilter.Blur blur) {
        this.G = f10;
        this.H = blur;
        return this;
    }

    public SpanUtils t() {
        this.f11572x = true;
        return this;
    }

    public SpanUtils u() {
        this.f11574z = true;
        return this;
    }

    public SpanUtils v(@g.f0(from = 0) int i10) {
        return w(0, 3, i10);
    }

    public SpanUtils w(@g.l int i10, @g.f0(from = 0) int i11, @g.f0(from = 0) int i12) {
        this.f11561m = i10;
        this.f11562n = i11;
        this.f11563o = i12;
        return this;
    }

    public SpanUtils x(@g.l int i10, boolean z10, View.OnClickListener onClickListener) {
        TextView textView = this.f11548a;
        if (textView != null && textView.getMovementMethod() == null) {
            this.f11548a.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.E = new a(i10, z10, onClickListener);
        return this;
    }

    public SpanUtils y(@g.n0 ClickableSpan clickableSpan) {
        Objects.requireNonNull(clickableSpan, "Argument 'clickSpan' of type ClickableSpan (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        TextView textView = this.f11548a;
        if (textView != null && textView.getMovementMethod() == null) {
            this.f11548a.setMovementMethod(LinkMovementMethod.getInstance());
        }
        this.E = clickableSpan;
        return this;
    }

    public final void z() {
        this.f11551c = 33;
        this.f11552d = -16777217;
        this.f11553e = -16777217;
        this.f11554f = -1;
        this.f11556h = -16777217;
        this.f11559k = -1;
        this.f11561m = -16777217;
        this.f11564p = -1;
        this.f11566r = -1.0f;
        this.f11567s = -1.0f;
        this.f11568t = false;
        this.f11569u = false;
        this.f11570v = false;
        this.f11571w = false;
        this.f11572x = false;
        this.f11573y = false;
        this.f11574z = false;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = -1;
        this.E = null;
        this.F = null;
        this.G = -1.0f;
        this.I = null;
        this.J = -1.0f;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = -1;
        this.T = -1;
    }

    public SpanUtils() {
        this.Y = 0;
        this.Z = 1;
        this.f11549a0 = 2;
        this.V = new SerializableSpannableStringBuilder(null);
        this.f11550b = "";
        this.X = -1;
        z();
    }
}
