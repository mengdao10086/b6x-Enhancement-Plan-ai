package a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class jc {
    public static ic a(ic icVar, int i, int i2, boolean z, int i3) {
        return icVar != null ? icVar : z ? new ic(i, i3, i2) : new ic(i, i2);
    }

    public static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray typedArrayK = sc.k(resources, theme, attributeSet, sa.GradientColor);
        float f = sc.f(typedArrayK, xmlPullParser, "startX", sa.GradientColor_android_startX, 0.0f);
        float f2 = sc.f(typedArrayK, xmlPullParser, "startY", sa.GradientColor_android_startY, 0.0f);
        float f3 = sc.f(typedArrayK, xmlPullParser, "endX", sa.GradientColor_android_endX, 0.0f);
        float f4 = sc.f(typedArrayK, xmlPullParser, "endY", sa.GradientColor_android_endY, 0.0f);
        float f5 = sc.f(typedArrayK, xmlPullParser, "centerX", sa.GradientColor_android_centerX, 0.0f);
        float f6 = sc.f(typedArrayK, xmlPullParser, "centerY", sa.GradientColor_android_centerY, 0.0f);
        int iG = sc.g(typedArrayK, xmlPullParser, "type", sa.GradientColor_android_type, 0);
        int iB = sc.b(typedArrayK, xmlPullParser, "startColor", sa.GradientColor_android_startColor, 0);
        boolean zJ = sc.j(xmlPullParser, "centerColor");
        int iB2 = sc.b(typedArrayK, xmlPullParser, "centerColor", sa.GradientColor_android_centerColor, 0);
        int iB3 = sc.b(typedArrayK, xmlPullParser, "endColor", sa.GradientColor_android_endColor, 0);
        int iG2 = sc.g(typedArrayK, xmlPullParser, "tileMode", sa.GradientColor_android_tileMode, 0);
        float f7 = sc.f(typedArrayK, xmlPullParser, "gradientRadius", sa.GradientColor_android_gradientRadius, 0.0f);
        typedArrayK.recycle();
        ic icVarA = a(c(resources, xmlPullParser, attributeSet, theme), iB, iB3, zJ, iB2);
        if (iG != 1) {
            return iG != 2 ? new LinearGradient(f, f2, f3, f4, icVarA.f1350a, icVarA.f6396a, d(iG2)) : new SweepGradient(f5, f6, icVarA.f1350a, icVarA.f6396a);
        }
        if (f7 > 0.0f) {
            return new RadialGradient(f5, f6, f7, icVarA.f1350a, icVarA.f6396a, d(iG2));
        }
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0089, code lost:
    
        if (r4.size() <= 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0090, code lost:
    
        return new a.ic(r4, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0091, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static a.ic c(android.content.res.Resources r8, org.xmlpull.v1.XmlPullParser r9, android.util.AttributeSet r10, android.content.res.Resources.Theme r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r9.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L12:
            int r3 = r9.next()
            if (r3 == r1) goto L85
            int r5 = r9.getDepth()
            if (r5 >= r0) goto L21
            r6 = 3
            if (r3 == r6) goto L85
        L21:
            r6 = 2
            if (r3 == r6) goto L25
            goto L12
        L25:
            if (r5 > r0) goto L12
            java.lang.String r3 = r9.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L34
            goto L12
        L34:
            int[] r3 = a.sa.GradientColorItem
            android.content.res.TypedArray r3 = a.sc.k(r8, r11, r10, r3)
            int r5 = a.sa.GradientColorItem_android_color
            boolean r5 = r3.hasValue(r5)
            int r6 = a.sa.GradientColorItem_android_offset
            boolean r6 = r3.hasValue(r6)
            if (r5 == 0) goto L6a
            if (r6 == 0) goto L6a
            int r5 = a.sa.GradientColorItem_android_color
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            int r6 = a.sa.GradientColorItem_android_offset
            r7 = 0
            float r6 = r3.getFloat(r6, r7)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L12
        L6a:
            org.xmlpull.v1.XmlPullParserException r8 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r9 = r9.getPositionDescription()
            r10.append(r9)
            java.lang.String r9 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r8.<init>(r9)
            throw r8
        L85:
            int r8 = r4.size()
            if (r8 <= 0) goto L91
            a.ic r8 = new a.ic
            r8.<init>(r4, r2)
            return r8
        L91:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a.jc.c(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):a.ic");
    }

    public static Shader.TileMode d(int i) {
        return i != 1 ? i != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT;
    }
}
