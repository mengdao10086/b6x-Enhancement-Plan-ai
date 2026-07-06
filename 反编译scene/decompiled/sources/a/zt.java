package a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class zt extends cu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f8095a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public cc f3883a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint.Cap f3884a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint.Join f3885a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f3886a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public cc f3887b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;

    public zt() {
        this.f8095a = 0.0f;
        this.b = 1.0f;
        this.c = 1.0f;
        this.d = 0.0f;
        this.e = 1.0f;
        this.f = 0.0f;
        this.f3884a = Paint.Cap.BUTT;
        this.f3885a = Paint.Join.MITER;
        this.g = 4.0f;
    }

    public zt(zt ztVar) {
        super(ztVar);
        this.f8095a = 0.0f;
        this.b = 1.0f;
        this.c = 1.0f;
        this.d = 0.0f;
        this.e = 1.0f;
        this.f = 0.0f;
        this.f3884a = Paint.Cap.BUTT;
        this.f3885a = Paint.Join.MITER;
        this.g = 4.0f;
        this.f3886a = ztVar.f3886a;
        this.f3883a = ztVar.f3883a;
        this.f8095a = ztVar.f8095a;
        this.b = ztVar.b;
        this.f3887b = ztVar.f3887b;
        ((cu) this).f5828a = ((cu) ztVar).f5828a;
        this.c = ztVar.c;
        this.d = ztVar.d;
        this.e = ztVar.e;
        this.f = ztVar.f;
        this.f3884a = ztVar.f3884a;
        this.f3885a = ztVar.f3885a;
        this.g = ztVar.g;
    }

    @Override // a.bu
    public boolean a() {
        return this.f3887b.i() || this.f3883a.i();
    }

    @Override // a.bu
    public boolean b(int[] iArr) {
        return this.f3883a.j(iArr) | this.f3887b.j(iArr);
    }

    public final Paint.Cap e(int i, Paint.Cap cap) {
        return i != 0 ? i != 1 ? i != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
    }

    public final Paint.Join f(int i, Paint.Join join) {
        return i != 0 ? i != 1 ? i != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
    }

    public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
        TypedArray typedArrayK = sc.k(resources, theme, attributeSet, mt.c);
        h(typedArrayK, xmlPullParser, theme);
        typedArrayK.recycle();
    }

    public float getFillAlpha() {
        return this.c;
    }

    public int getFillColor() {
        return this.f3887b.e();
    }

    public float getStrokeAlpha() {
        return this.b;
    }

    public int getStrokeColor() {
        return this.f3883a.e();
    }

    public float getStrokeWidth() {
        return this.f8095a;
    }

    public float getTrimPathEnd() {
        return this.e;
    }

    public float getTrimPathOffset() {
        return this.f;
    }

    public float getTrimPathStart() {
        return this.d;
    }

    public final void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        this.f3886a = null;
        if (sc.j(xmlPullParser, "pathData")) {
            String string = typedArray.getString(0);
            if (string != null) {
                ((cu) this).f444a = string;
            }
            String string2 = typedArray.getString(2);
            if (string2 != null) {
                ((cu) this).f445a = xc.d(string2);
            }
            this.f3887b = sc.e(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
            this.c = sc.f(typedArray, xmlPullParser, "fillAlpha", 12, this.c);
            this.f3884a = e(sc.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f3884a);
            this.f3885a = f(sc.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f3885a);
            this.g = sc.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.g);
            this.f3883a = sc.e(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
            this.b = sc.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.b);
            this.f8095a = sc.f(typedArray, xmlPullParser, "strokeWidth", 4, this.f8095a);
            this.e = sc.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.e);
            this.f = sc.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.f);
            this.d = sc.f(typedArray, xmlPullParser, "trimPathStart", 5, this.d);
            ((cu) this).f5828a = sc.g(typedArray, xmlPullParser, "fillType", 13, ((cu) this).f5828a);
        }
    }

    public void setFillAlpha(float f) {
        this.c = f;
    }

    public void setFillColor(int i) {
        this.f3887b.k(i);
    }

    public void setStrokeAlpha(float f) {
        this.b = f;
    }

    public void setStrokeColor(int i) {
        this.f3883a.k(i);
    }

    public void setStrokeWidth(float f) {
        this.f8095a = f;
    }

    public void setTrimPathEnd(float f) {
        this.e = f;
    }

    public void setTrimPathOffset(float f) {
        this.f = f;
    }

    public void setTrimPathStart(float f) {
        this.d = f;
    }
}
