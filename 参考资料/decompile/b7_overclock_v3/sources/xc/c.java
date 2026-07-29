package xc;

import com.blankj.utilcode.util.i0;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import g.p0;
import hd.t;
import hd.u0;
import hd.v0;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends qc.d {
    public static final int E = 30;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f55051p = "TtmlDecoder";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f55052q = "http://www.w3.org/ns/ttml#parameter";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f55053r = "begin";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f55054s = "dur";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f55055t = "end";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f55056u = "style";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f55057v = "region";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f55058w = "backgroundImage";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final XmlPullParserFactory f55062o;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Pattern f55059x = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Pattern f55060y = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Pattern f55061z = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    public static final Pattern A = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    public static final Pattern B = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    public static final Pattern C = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
    public static final Pattern D = Pattern.compile("^(\\d+) (\\d+)$");
    public static final b F = new b(30.0f, 1, 1);
    public static final a G = new a(32, 15);

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f55063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f55064b;

        public a(int i10, int i11) {
            this.f55063a = i10;
            this.f55064b = i11;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f55065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f55066b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f55067c;

        public b(float f10, int i10, int i11) {
            this.f55065a = f10;
            this.f55066b = i10;
            this.f55067c = i11;
        }
    }

    /* JADX INFO: renamed from: xc.c$c, reason: collision with other inner class name */
    public static final class C0649c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f55068a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f55069b;

        public C0649c(int i10, int i11) {
            this.f55068a = i10;
            this.f55069b = i11;
        }
    }

    public c() {
        super(f55051p);
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.f55062o = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e10) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e10);
        }
    }

    public static g B(@p0 g gVar) {
        return gVar == null ? new g() : gVar;
    }

    public static boolean C(String str) {
        return str.equals(d.f55083n) || str.equals(d.f55085o) || str.equals("body") || str.equals(d.f55089q) || str.equals("p") || str.equals(d.f55093s) || str.equals(d.f55095t) || str.equals("style") || str.equals(d.f55099v) || str.equals(d.f55101w) || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals(d.B);
    }

    public static a D(XmlPullParser xmlPullParser, a aVar) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue(f55052q, "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = D.matcher(attributeValue);
        if (!matcher.matches()) {
            t.n(f55051p, "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
        try {
            int i10 = Integer.parseInt((String) hd.a.g(matcher.group(1)));
            int i11 = Integer.parseInt((String) hd.a.g(matcher.group(2)));
            if (i10 != 0 && i11 != 0) {
                return new a(i10, i11);
            }
            throw new SubtitleDecoderException("Invalid cell resolution " + i10 + i0.f11861z + i11);
        } catch (NumberFormatException unused) {
            t.n(f55051p, "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
    }

    public static void E(String str, g gVar) throws SubtitleDecoderException {
        Matcher matcher;
        String str2;
        String[] strArrN1 = u0.n1(str, "\\s+");
        if (strArrN1.length == 1) {
            matcher = f55061z.matcher(str);
        } else {
            if (strArrN1.length != 2) {
                throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + strArrN1.length + j3.b.f36044h);
            }
            matcher = f55061z.matcher(strArrN1[1]);
            t.n(f55051p, "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
        }
        str2 = (String) hd.a.g(matcher.group(3));
        str2.hashCode();
        switch (str2) {
            case "%":
                gVar.z(3);
                break;
            case "em":
                gVar.z(2);
                break;
            case "px":
                gVar.z(1);
                break;
            default:
                throw new SubtitleDecoderException("Invalid unit for fontSize: '" + str2 + "'.");
        }
        gVar.y(Float.parseFloat((String) hd.a.g(matcher.group(1))));
    }

    public static b F(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue(f55052q, "frameRate");
        int i10 = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        float f10 = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue(f55052q, "frameRateMultiplier");
        if (attributeValue2 != null) {
            if (u0.n1(attributeValue2, i0.f11861z).length != 2) {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
            f10 = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
        }
        b bVar = F;
        int i11 = bVar.f55066b;
        String attributeValue3 = xmlPullParser.getAttributeValue(f55052q, "subFrameRate");
        if (attributeValue3 != null) {
            i11 = Integer.parseInt(attributeValue3);
        }
        int i12 = bVar.f55067c;
        String attributeValue4 = xmlPullParser.getAttributeValue(f55052q, "tickRate");
        if (attributeValue4 != null) {
            i12 = Integer.parseInt(attributeValue4);
        }
        return new b(i10 * f10, i11, i12);
    }

    public static Map<String, g> G(XmlPullParser xmlPullParser, Map<String, g> map, a aVar, @p0 C0649c c0649c, Map<String, e> map2, Map<String, String> map3) throws XmlPullParserException, IOException {
        do {
            xmlPullParser.next();
            if (v0.f(xmlPullParser, "style")) {
                String strA = v0.a(xmlPullParser, "style");
                g gVarL = L(xmlPullParser, new g());
                if (strA != null) {
                    for (String str : M(strA)) {
                        gVarL.a(map.get(str));
                    }
                }
                String strG = gVarL.g();
                if (strG != null) {
                    map.put(strG, gVarL);
                }
            } else if (v0.f(xmlPullParser, "region")) {
                e eVarJ = J(xmlPullParser, aVar, c0649c);
                if (eVarJ != null) {
                    map2.put(eVarJ.f55122a, eVarJ);
                }
            } else if (v0.f(xmlPullParser, "metadata")) {
                H(xmlPullParser, map3);
            }
        } while (!v0.d(xmlPullParser, d.f55085o));
        return map;
    }

    public static void H(XmlPullParser xmlPullParser, Map<String, String> map) throws XmlPullParserException, IOException {
        String strA;
        do {
            xmlPullParser.next();
            if (v0.f(xmlPullParser, "image") && (strA = v0.a(xmlPullParser, "id")) != null) {
                map.put(strA, xmlPullParser.nextText());
            }
        } while (!v0.d(xmlPullParser, "metadata"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static xc.d I(org.xmlpull.v1.XmlPullParser r19, @g.p0 xc.d r20, java.util.Map<java.lang.String, xc.e> r21, xc.c.b r22) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xc.c.I(org.xmlpull.v1.XmlPullParser, xc.d, java.util.Map, xc.c$b):xc.d");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01b2  */
    @g.p0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static xc.e J(org.xmlpull.v1.XmlPullParser r17, xc.c.a r18, @g.p0 xc.c.C0649c r19) {
        /*
            Method dump skipped, instruction units count: 564
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xc.c.J(org.xmlpull.v1.XmlPullParser, xc.c$a, xc.c$c):xc.e");
    }

    public static float K(String str) {
        Matcher matcher = A.matcher(str);
        if (!matcher.matches()) {
            t.n(f55051p, "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) hd.a.g(matcher.group(1)))));
        } catch (NumberFormatException e10) {
            t.o(f55051p, "Failed to parse shear: " + str, e10);
            return Float.MAX_VALUE;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static xc.g L(org.xmlpull.v1.XmlPullParser r12, xc.g r13) {
        /*
            Method dump skipped, instruction units count: 1030
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xc.c.L(org.xmlpull.v1.XmlPullParser, xc.g):xc.g");
    }

    public static String[] M(String str) {
        String strTrim = str.trim();
        return strTrim.isEmpty() ? new String[0] : u0.n1(strTrim, "\\s+");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long N(java.lang.String r13, xc.c.b r14) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        /*
            Method dump skipped, instruction units count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xc.c.N(java.lang.String, xc.c$b):long");
    }

    @p0
    public static C0649c O(XmlPullParser xmlPullParser) {
        String strA = v0.a(xmlPullParser, d.F);
        if (strA == null) {
            return null;
        }
        Matcher matcher = C.matcher(strA);
        if (!matcher.matches()) {
            t.n(f55051p, "Ignoring non-pixel tts extent: " + strA);
            return null;
        }
        try {
            return new C0649c(Integer.parseInt((String) hd.a.g(matcher.group(1))), Integer.parseInt((String) hd.a.g(matcher.group(2))));
        } catch (NumberFormatException unused) {
            t.n(f55051p, "Ignoring malformed tts extent: " + strA);
            return null;
        }
    }

    @Override // qc.d
    public qc.f A(byte[] bArr, int i10, boolean z10) throws SubtitleDecoderException {
        b bVar;
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f55062o.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new e(""));
            C0649c c0649cO = null;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, 0, i10), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVarF = F;
            a aVarD = G;
            h hVar = null;
            int i11 = 0;
            for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.getEventType()) {
                d dVar = (d) arrayDeque.peek();
                if (i11 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    if (eventType == 2) {
                        if (d.f55083n.equals(name)) {
                            bVarF = F(xmlPullParserNewPullParser);
                            aVarD = D(xmlPullParserNewPullParser, G);
                            c0649cO = O(xmlPullParserNewPullParser);
                        }
                        C0649c c0649c = c0649cO;
                        b bVar2 = bVarF;
                        a aVar = aVarD;
                        if (C(name)) {
                            if (d.f55085o.equals(name)) {
                                bVar = bVar2;
                                G(xmlPullParserNewPullParser, map, aVar, c0649c, map2, map3);
                            } else {
                                bVar = bVar2;
                                try {
                                    d dVarI = I(xmlPullParserNewPullParser, dVar, map2, bVar);
                                    arrayDeque.push(dVarI);
                                    if (dVar != null) {
                                        dVar.a(dVarI);
                                    }
                                } catch (SubtitleDecoderException e10) {
                                    t.o(f55051p, "Suppressing parser error", e10);
                                    i11++;
                                }
                            }
                            bVarF = bVar;
                        } else {
                            t.i(f55051p, "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                            i11++;
                            bVarF = bVar2;
                        }
                        c0649cO = c0649c;
                        aVarD = aVar;
                    } else if (eventType == 4) {
                        ((d) hd.a.g(dVar)).a(d.d(xmlPullParserNewPullParser.getText()));
                    } else if (eventType == 3) {
                        if (xmlPullParserNewPullParser.getName().equals(d.f55083n)) {
                            hVar = new h((d) hd.a.g((d) arrayDeque.peek()), map, map2, map3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i11++;
                } else if (eventType == 3) {
                    i11--;
                }
                xmlPullParserNewPullParser.next();
            }
            if (hVar != null) {
                return hVar;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        } catch (IOException e11) {
            throw new IllegalStateException("Unexpected error when reading input.", e11);
        } catch (XmlPullParserException e12) {
            throw new SubtitleDecoderException("Unable to decode source", e12);
        }
    }
}
