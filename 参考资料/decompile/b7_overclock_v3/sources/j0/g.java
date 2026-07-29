package j0;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import g.n0;
import g.p0;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f35984a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f35985b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f35986c = 2;

    public static a a(@p0 a aVar, @g.l int i10, @g.l int i11, boolean z10, @g.l int i12) {
        return aVar != null ? aVar : z10 ? new a(i10, i12, i11) : new a(i10, i11);
    }

    public static Shader b(@n0 Resources resources, @n0 XmlPullParser xmlPullParser, @p0 Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return c(resources, xmlPullParser, attributeSetAsAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static Shader c(@n0 Resources resources, @n0 XmlPullParser xmlPullParser, @n0 AttributeSet attributeSet, @p0 Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray typedArrayS = n.s(resources, theme, attributeSet, R.styleable.GradientColor);
        float fJ = n.j(typedArrayS, xmlPullParser, "startX", R.styleable.GradientColor_android_startX, 0.0f);
        float fJ2 = n.j(typedArrayS, xmlPullParser, "startY", R.styleable.GradientColor_android_startY, 0.0f);
        float fJ3 = n.j(typedArrayS, xmlPullParser, "endX", R.styleable.GradientColor_android_endX, 0.0f);
        float fJ4 = n.j(typedArrayS, xmlPullParser, "endY", R.styleable.GradientColor_android_endY, 0.0f);
        float fJ5 = n.j(typedArrayS, xmlPullParser, "centerX", R.styleable.GradientColor_android_centerX, 0.0f);
        float fJ6 = n.j(typedArrayS, xmlPullParser, "centerY", R.styleable.GradientColor_android_centerY, 0.0f);
        int iK = n.k(typedArrayS, xmlPullParser, "type", R.styleable.GradientColor_android_type, 0);
        int iF = n.f(typedArrayS, xmlPullParser, "startColor", R.styleable.GradientColor_android_startColor, 0);
        boolean zR = n.r(xmlPullParser, "centerColor");
        int iF2 = n.f(typedArrayS, xmlPullParser, "centerColor", R.styleable.GradientColor_android_centerColor, 0);
        int iF3 = n.f(typedArrayS, xmlPullParser, "endColor", R.styleable.GradientColor_android_endColor, 0);
        int iK2 = n.k(typedArrayS, xmlPullParser, "tileMode", R.styleable.GradientColor_android_tileMode, 0);
        float fJ7 = n.j(typedArrayS, xmlPullParser, "gradientRadius", R.styleable.GradientColor_android_gradientRadius, 0.0f);
        typedArrayS.recycle();
        a aVarA = a(d(resources, xmlPullParser, attributeSet, theme), iF, iF3, zR, iF2);
        if (iK != 1) {
            return iK != 2 ? new LinearGradient(fJ, fJ2, fJ3, fJ4, aVarA.f35987a, aVarA.f35988b, e(iK2)) : new SweepGradient(fJ5, fJ6, aVarA.f35987a, aVarA.f35988b);
        }
        if (fJ7 > 0.0f) {
            return new RadialGradient(fJ5, fJ6, fJ7, aVarA.f35987a, aVarA.f35988b, e(iK2));
        }
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0085, code lost:
    
        if (r4.size() <= 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008c, code lost:
    
        return new j0.g.a(r4, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008d, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static j0.g.a d(@g.n0 android.content.res.Resources r9, @g.n0 org.xmlpull.v1.XmlPullParser r10, @g.n0 android.util.AttributeSet r11, @g.p0 android.content.res.Resources.Theme r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r10.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L12:
            int r3 = r10.next()
            if (r3 == r1) goto L81
            int r5 = r10.getDepth()
            if (r5 >= r0) goto L21
            r6 = 3
            if (r3 == r6) goto L81
        L21:
            r6 = 2
            if (r3 == r6) goto L25
            goto L12
        L25:
            if (r5 > r0) goto L12
            java.lang.String r3 = r10.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L34
            goto L12
        L34:
            int[] r3 = androidx.core.R.styleable.GradientColorItem
            android.content.res.TypedArray r3 = j0.n.s(r9, r12, r11, r3)
            int r5 = androidx.core.R.styleable.GradientColorItem_android_color
            boolean r6 = r3.hasValue(r5)
            int r7 = androidx.core.R.styleable.GradientColorItem_android_offset
            boolean r8 = r3.hasValue(r7)
            if (r6 == 0) goto L66
            if (r8 == 0) goto L66
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            r6 = 0
            float r6 = r3.getFloat(r7, r6)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L12
        L66:
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r11.append(r10)
            java.lang.String r10 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r10)
            throw r9
        L81:
            int r9 = r4.size()
            if (r9 <= 0) goto L8d
            j0.g$a r9 = new j0.g$a
            r9.<init>(r4, r2)
            return r9
        L8d:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.g.d(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):j0.g$a");
    }

    public static Shader.TileMode e(int i10) {
        return i10 != 1 ? i10 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT;
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f35987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float[] f35988b;

        public a(@n0 List<Integer> list, @n0 List<Float> list2) {
            int size = list.size();
            this.f35987a = new int[size];
            this.f35988b = new float[size];
            for (int i10 = 0; i10 < size; i10++) {
                this.f35987a[i10] = list.get(i10).intValue();
                this.f35988b[i10] = list2.get(i10).floatValue();
            }
        }

        public a(@g.l int i10, @g.l int i11) {
            this.f35987a = new int[]{i10, i11};
            this.f35988b = new float[]{0.0f, 1.0f};
        }

        public a(@g.l int i10, @g.l int i11, @g.l int i12) {
            this.f35987a = new int[]{i10, i11, i12};
            this.f35988b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
