package j0;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Base64;
import android.util.Xml;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import g.n0;
import g.p0;
import g.u;
import g.v0;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f35967a = 400;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f35968b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f35969c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f35970d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f35971e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f35972f = 500;

    @v0(21)
    public static class a {
        @u
        public static int a(TypedArray typedArray, int i10) {
            return typedArray.getType(i10);
        }
    }

    public interface b {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface c {
    }

    public static final class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final e[] f35973a;

        public d(@n0 e[] eVarArr) {
            this.f35973a = eVarArr;
        }

        @n0
        public e[] a() {
            return this.f35973a;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final String f35974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f35975b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f35976c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f35977d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f35978e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f35979f;

        public e(@n0 String str, int i10, boolean z10, @p0 String str2, int i11, int i12) {
            this.f35974a = str;
            this.f35975b = i10;
            this.f35976c = z10;
            this.f35977d = str2;
            this.f35978e = i11;
            this.f35979f = i12;
        }

        @n0
        public String a() {
            return this.f35974a;
        }

        public int b() {
            return this.f35979f;
        }

        public int c() {
            return this.f35978e;
        }

        @p0
        public String d() {
            return this.f35977d;
        }

        public int e() {
            return this.f35975b;
        }

        public boolean f() {
            return this.f35976c;
        }
    }

    public static int a(TypedArray typedArray, int i10) {
        return a.a(typedArray, i10);
    }

    @p0
    public static b b(@n0 XmlPullParser xmlPullParser, @n0 Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    @n0
    public static List<List<byte[]>> c(@n0 Resources resources, @g.e int i10) {
        if (i10 == 0) {
            return Collections.emptyList();
        }
        TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i10);
        try {
            if (typedArrayObtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(typedArrayObtainTypedArray, 0) == 1) {
                for (int i11 = 0; i11 < typedArrayObtainTypedArray.length(); i11++) {
                    int resourceId = typedArrayObtainTypedArray.getResourceId(i11, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i10)));
            }
            return arrayList;
        } finally {
            typedArrayObtainTypedArray.recycle();
        }
    }

    @p0
    public static b d(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, zc.a.f58320h);
        if (xmlPullParser.getName().equals(zc.a.f58320h)) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    @p0
    public static b e(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamily);
        String string = typedArrayObtainAttributes.getString(R.styleable.FontFamily_fontProviderAuthority);
        String string2 = typedArrayObtainAttributes.getString(R.styleable.FontFamily_fontProviderPackage);
        String string3 = typedArrayObtainAttributes.getString(R.styleable.FontFamily_fontProviderQuery);
        int resourceId = typedArrayObtainAttributes.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int integer = typedArrayObtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        String string4 = typedArrayObtainAttributes.getString(R.styleable.FontFamily_fontProviderSystemFontFamily);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new C0405f(new v0.f(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new d((e[]) arrayList.toArray(new e[0]));
    }

    public static e f(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamilyFont);
        int i10 = R.styleable.FontFamilyFont_fontWeight;
        if (!typedArrayObtainAttributes.hasValue(i10)) {
            i10 = R.styleable.FontFamilyFont_android_fontWeight;
        }
        int i11 = typedArrayObtainAttributes.getInt(i10, 400);
        int i12 = R.styleable.FontFamilyFont_fontStyle;
        if (!typedArrayObtainAttributes.hasValue(i12)) {
            i12 = R.styleable.FontFamilyFont_android_fontStyle;
        }
        boolean z10 = 1 == typedArrayObtainAttributes.getInt(i12, 0);
        int i13 = R.styleable.FontFamilyFont_ttcIndex;
        if (!typedArrayObtainAttributes.hasValue(i13)) {
            i13 = R.styleable.FontFamilyFont_android_ttcIndex;
        }
        int i14 = R.styleable.FontFamilyFont_fontVariationSettings;
        if (!typedArrayObtainAttributes.hasValue(i14)) {
            i14 = R.styleable.FontFamilyFont_android_fontVariationSettings;
        }
        String string = typedArrayObtainAttributes.getString(i14);
        int i15 = typedArrayObtainAttributes.getInt(i13, 0);
        int i16 = R.styleable.FontFamilyFont_font;
        if (!typedArrayObtainAttributes.hasValue(i16)) {
            i16 = R.styleable.FontFamilyFont_android_font;
        }
        int resourceId = typedArrayObtainAttributes.getResourceId(i16, 0);
        String string2 = typedArrayObtainAttributes.getString(i16);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new e(string2, i11, z10, string, i15, resourceId);
    }

    public static void g(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i10 = 1;
        while (i10 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i10++;
            } else if (next == 3) {
                i10--;
            }
        }
    }

    public static List<byte[]> h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: j0.f$f, reason: collision with other inner class name */
    public static final class C0405f implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final v0.f f35980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f35981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f35982c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public final String f35983d;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public C0405f(@n0 v0.f fVar, int i10, int i11, @p0 String str) {
            this.f35980a = fVar;
            this.f35982c = i10;
            this.f35981b = i11;
            this.f35983d = str;
        }

        public int a() {
            return this.f35982c;
        }

        @n0
        public v0.f b() {
            return this.f35980a;
        }

        @p0
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public String c() {
            return this.f35983d;
        }

        public int d() {
            return this.f35981b;
        }

        public C0405f(@n0 v0.f fVar, int i10, int i11) {
            this(fVar, i10, i11, null);
        }
    }
}
