package ic;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Xml;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.upstream.k;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import g.p0;
import hd.s0;
import hd.t;
import hd.u0;
import hd.v0;
import hd.w;
import ic.j;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes3.dex */
public class c extends DefaultHandler implements k.a<b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f32045b = "MpdParser";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f32046c = Pattern.compile("(\\d+)(?:/(\\d+))?");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f32047d = Pattern.compile("CC([1-4])=.*");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f32048e = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f32049f = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XmlPullParserFactory f32050a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Format f32051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f32052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final j f32053c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public final String f32054d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ArrayList<DrmInitData.SchemeData> f32055e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ArrayList<d> f32056f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f32057g;

        public a(Format format, String str, j jVar, @p0 String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<d> arrayList2, long j10) {
            this.f32051a = format;
            this.f32052b = str;
            this.f32053c = jVar;
            this.f32054d = str2;
            this.f32055e = arrayList;
            this.f32056f = arrayList2;
            this.f32057g = j10;
        }
    }

    public c() {
        try {
            this.f32050a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e10) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e10);
        }
    }

    public static int B(List<d> list) {
        String str;
        for (int i10 = 0; i10 < list.size(); i10++) {
            d dVar = list.get(i10);
            if ("urn:scte:dash:cc:cea-608:2015".equals(dVar.f32058a) && (str = dVar.f32059b) != null) {
                Matcher matcher = f32047d.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                t.n(f32045b, "Unable to parse CEA-608 channel number from: " + dVar.f32059b);
            }
        }
        return -1;
    }

    public static int C(List<d> list) {
        String str;
        for (int i10 = 0; i10 < list.size(); i10++) {
            d dVar = list.get(i10);
            if ("urn:scte:dash:cc:cea-708:2015".equals(dVar.f32058a) && (str = dVar.f32059b) != null) {
                Matcher matcher = f32048e.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                t.n(f32045b, "Unable to parse CEA-708 service block number from: " + dVar.f32059b);
            }
        }
        return -1;
    }

    public static long F(XmlPullParser xmlPullParser, String str, long j10) throws ParserException {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j10 : u0.Y0(attributeValue);
    }

    public static d G(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String strM0 = m0(xmlPullParser, "schemeIdUri", "");
        String strM02 = m0(xmlPullParser, "value", null);
        String strM03 = m0(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!v0.d(xmlPullParser, str));
        return new d(strM0, strM02, strM03);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int H(org.xmlpull.v1.XmlPullParser r4) {
        /*
            r0 = 0
            java.lang.String r1 = "value"
            java.lang.String r4 = r4.getAttributeValue(r0, r1)
            java.lang.String r4 = hd.u0.w1(r4)
            r0 = -1
            if (r4 != 0) goto Lf
            return r0
        Lf:
            int r1 = r4.hashCode()
            r2 = 2
            r3 = 1
            switch(r1) {
                case 1596796: goto L3b;
                case 2937391: goto L30;
                case 3094035: goto L25;
                case 3133436: goto L1a;
                default: goto L18;
            }
        L18:
            r4 = -1
            goto L45
        L1a:
            java.lang.String r1 = "fa01"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L23
            goto L18
        L23:
            r4 = 3
            goto L45
        L25:
            java.lang.String r1 = "f801"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L2e
            goto L18
        L2e:
            r4 = 2
            goto L45
        L30:
            java.lang.String r1 = "a000"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L39
            goto L18
        L39:
            r4 = 1
            goto L45
        L3b:
            java.lang.String r1 = "4000"
            boolean r4 = r4.equals(r1)
            if (r4 != 0) goto L44
            goto L18
        L44:
            r4 = 0
        L45:
            switch(r4) {
                case 0: goto L4f;
                case 1: goto L4e;
                case 2: goto L4c;
                case 3: goto L49;
                default: goto L48;
            }
        L48:
            return r0
        L49:
            r4 = 8
            return r4
        L4c:
            r4 = 6
            return r4
        L4e:
            return r2
        L4f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: ic.c.H(org.xmlpull.v1.XmlPullParser):int");
    }

    public static long I(XmlPullParser xmlPullParser, String str, long j10) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j10 : u0.Z0(attributeValue);
    }

    public static String J(List<d> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            d dVar = list.get(i10);
            String str = dVar.f32058a;
            if ("tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) && "JOC".equals(dVar.f32059b)) {
                return w.L;
            }
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && "ec+3".equals(dVar.f32059b)) {
                return w.L;
            }
        }
        return w.K;
    }

    public static float N(XmlPullParser xmlPullParser, String str, float f10) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? f10 : Float.parseFloat(attributeValue);
    }

    public static float O(XmlPullParser xmlPullParser, float f10) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue == null) {
            return f10;
        }
        Matcher matcher = f32046c.matcher(attributeValue);
        if (!matcher.matches()) {
            return f10;
        }
        int i10 = Integer.parseInt(matcher.group(1));
        return !TextUtils.isEmpty(matcher.group(2)) ? i10 / Integer.parseInt(r2) : i10;
    }

    public static int Q(XmlPullParser xmlPullParser, String str, int i10) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i10 : Integer.parseInt(attributeValue);
    }

    public static long S(List<d> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            d dVar = list.get(i10);
            if (Ascii.equalsIgnoreCase("http://dashif.org/guidelines/last-segment-number", dVar.f32058a)) {
                return Long.parseLong(dVar.f32059b);
            }
        }
        return -1L;
    }

    public static long T(XmlPullParser xmlPullParser, String str, long j10) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j10 : Long.parseLong(attributeValue);
    }

    public static int V(XmlPullParser xmlPullParser) {
        int iQ = Q(xmlPullParser, "value", -1);
        if (iQ < 0) {
            return -1;
        }
        int[] iArr = f32049f;
        if (iQ < iArr.length) {
            return iArr[iQ];
        }
        return -1;
    }

    public static String m0(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    public static String n0(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String text = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                text = xmlPullParser.getText();
            } else {
                u(xmlPullParser);
            }
        } while (!v0.d(xmlPullParser, str));
        return text;
    }

    public static int p(int i10, int i11) {
        if (i10 == -1) {
            return i11;
        }
        if (i11 == -1) {
            return i10;
        }
        hd.a.i(i10 == i11);
        return i10;
    }

    @p0
    public static String q(@p0 String str, @p0 String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        hd.a.i(str.equals(str2));
        return str;
    }

    public static void r(ArrayList<DrmInitData.SchemeData> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DrmInitData.SchemeData schemeData = arrayList.get(size);
            if (!schemeData.e()) {
                int i10 = 0;
                while (true) {
                    if (i10 >= arrayList.size()) {
                        break;
                    }
                    if (arrayList.get(i10).a(schemeData)) {
                        arrayList.remove(size);
                        break;
                    }
                    i10++;
                }
            }
        }
    }

    public static long s(long j10, long j11) {
        if (j11 != ya.g.f56663b) {
            j10 = j11;
        }
        return j10 == Long.MAX_VALUE ? ya.g.f56663b : j10;
    }

    @p0
    public static String t(@p0 String str, @p0 String str2) {
        if (w.p(str)) {
            return w.c(str2);
        }
        if (w.s(str)) {
            return w.o(str2);
        }
        if (w.r(str)) {
            return w.f31209s0.equals(str) ? w.j(str2) : str;
        }
        if (!w.f31181e0.equals(str)) {
            return null;
        }
        String strG = w.g(str2);
        return w.f31177c0.equals(strG) ? w.f31205q0 : strG;
    }

    public static void u(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (v0.e(xmlPullParser)) {
            int i10 = 1;
            while (i10 != 0) {
                xmlPullParser.next();
                if (v0.e(xmlPullParser)) {
                    i10++;
                } else if (v0.c(xmlPullParser)) {
                    i10--;
                }
            }
        }
    }

    public String A(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        return s0.d(str, n0(xmlPullParser, "BaseURL"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ea  */
    /* JADX WARN: Type inference failed for: r4v10, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.util.Pair<java.lang.String, com.google.android.exoplayer2.drm.DrmInitData.SchemeData> D(org.xmlpull.v1.XmlPullParser r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ic.c.D(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

    public int E(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, so.d.f50127a);
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        return "text".equals(attributeValue) ? 3 : -1;
    }

    public Pair<Long, EventMessage> K(XmlPullParser xmlPullParser, String str, String str2, long j10, ByteArrayOutputStream byteArrayOutputStream) throws XmlPullParserException, IOException {
        long jT = T(xmlPullParser, "id", 0L);
        long jT2 = T(xmlPullParser, "duration", ya.g.f56663b);
        long jT3 = T(xmlPullParser, "presentationTime", 0L);
        long jH1 = u0.h1(jT2, 1000L, j10);
        long jH12 = u0.h1(jT3, 1000000L, j10);
        String strM0 = m0(xmlPullParser, "messageData", null);
        byte[] bArrL = L(xmlPullParser, byteArrayOutputStream);
        Long lValueOf = Long.valueOf(jH12);
        if (strM0 != null) {
            bArrL = u0.w0(strM0);
        }
        return Pair.create(lValueOf, d(str, str2, jT, jH1, bArrL));
    }

    public byte[] L(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) throws XmlPullParserException, IOException {
        byteArrayOutputStream.reset();
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        xmlSerializerNewSerializer.setOutput(byteArrayOutputStream, Charsets.UTF_8.name());
        xmlPullParser.nextToken();
        while (!v0.d(xmlPullParser, "Event")) {
            switch (xmlPullParser.getEventType()) {
                case 0:
                    xmlSerializerNewSerializer.startDocument(null, Boolean.FALSE);
                    break;
                case 1:
                    xmlSerializerNewSerializer.endDocument();
                    break;
                case 2:
                    xmlSerializerNewSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i10 = 0; i10 < xmlPullParser.getAttributeCount(); i10++) {
                        xmlSerializerNewSerializer.attribute(xmlPullParser.getAttributeNamespace(i10), xmlPullParser.getAttributeName(i10), xmlPullParser.getAttributeValue(i10));
                    }
                    break;
                case 3:
                    xmlSerializerNewSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    xmlSerializerNewSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    xmlSerializerNewSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    xmlSerializerNewSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    xmlSerializerNewSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    xmlSerializerNewSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    xmlSerializerNewSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    xmlSerializerNewSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
            xmlPullParser.nextToken();
        }
        xmlSerializerNewSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public e M(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String strM0 = m0(xmlPullParser, "schemeIdUri", "");
        String strM02 = m0(xmlPullParser, "value", "");
        long jT = T(xmlPullParser, "timescale", 1L);
        ArrayList arrayList = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        do {
            xmlPullParser.next();
            if (v0.f(xmlPullParser, "Event")) {
                arrayList.add(K(xmlPullParser, strM0, strM02, jT, byteArrayOutputStream));
            } else {
                u(xmlPullParser);
            }
        } while (!v0.d(xmlPullParser, "EventStream"));
        long[] jArr = new long[arrayList.size()];
        EventMessage[] eventMessageArr = new EventMessage[arrayList.size()];
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            Pair pair = (Pair) arrayList.get(i10);
            jArr[i10] = ((Long) pair.first).longValue();
            eventMessageArr[i10] = (EventMessage) pair.second;
        }
        return e(strM0, strM02, jT, jArr, eventMessageArr);
    }

    public h P(XmlPullParser xmlPullParser) {
        return Y(xmlPullParser, "sourceURL", "range");
    }

    public String R(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return n0(xmlPullParser, "Label");
    }

    public b U(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        long j10;
        String strA;
        ArrayList arrayList;
        long j11;
        c cVar = this;
        long jF = F(xmlPullParser, "availabilityStartTime", ya.g.f56663b);
        long jI = I(xmlPullParser, "mediaPresentationDuration", ya.g.f56663b);
        long jI2 = I(xmlPullParser, "minBufferTime", ya.g.f56663b);
        boolean zEquals = "dynamic".equals(xmlPullParser.getAttributeValue(null, "type"));
        long jI3 = zEquals ? I(xmlPullParser, "minimumUpdatePeriod", ya.g.f56663b) : -9223372036854775807L;
        long jI4 = zEquals ? I(xmlPullParser, "timeShiftBufferDepth", ya.g.f56663b) : -9223372036854775807L;
        long jI5 = zEquals ? I(xmlPullParser, "suggestedPresentationDelay", ya.g.f56663b) : -9223372036854775807L;
        long jF2 = F(xmlPullParser, "publishTime", ya.g.f56663b);
        long j12 = zEquals ? 0L : -9223372036854775807L;
        ArrayList arrayList2 = new ArrayList();
        String str2 = str;
        g gVarX = null;
        n nVarQ0 = null;
        Uri uri = null;
        k kVarL0 = null;
        long j13 = zEquals ? -9223372036854775807L : 0L;
        long jZ = j12;
        boolean z10 = false;
        boolean z11 = false;
        while (true) {
            xmlPullParser.next();
            if (!v0.f(xmlPullParser, "BaseURL")) {
                if (v0.f(xmlPullParser, "ProgramInformation")) {
                    gVarX = X(xmlPullParser);
                } else if (v0.f(xmlPullParser, "UTCTiming")) {
                    nVarQ0 = q0(xmlPullParser);
                } else if (v0.f(xmlPullParser, "Location")) {
                    uri = Uri.parse(xmlPullParser.nextText());
                } else if (v0.f(xmlPullParser, "ServiceDescription")) {
                    kVarL0 = l0(xmlPullParser);
                } else {
                    if (!v0.f(xmlPullParser, "Period") || z11) {
                        j10 = jZ;
                        strA = str2;
                        arrayList = arrayList2;
                        u(xmlPullParser);
                    } else {
                        j10 = jZ;
                        ArrayList arrayList3 = arrayList2;
                        strA = str2;
                        Pair<f, Long> pairW = W(xmlPullParser, str2, j13, jZ, jF, jI4);
                        f fVar = (f) pairW.first;
                        if (fVar.f32067b != ya.g.f56663b) {
                            long jLongValue = ((Long) pairW.second).longValue();
                            if (jLongValue == ya.g.f56663b) {
                                arrayList = arrayList3;
                                j13 = -9223372036854775807L;
                            } else {
                                arrayList = arrayList3;
                                j13 = fVar.f32067b + jLongValue;
                            }
                            arrayList.add(fVar);
                        } else {
                            if (!zEquals) {
                                throw new ParserException("Unable to determine start of period " + arrayList3.size());
                            }
                            arrayList = arrayList3;
                            z11 = true;
                        }
                    }
                    jZ = j10;
                }
                strA = str2;
                arrayList = arrayList2;
            } else if (z10) {
                j10 = jZ;
                strA = str2;
                arrayList = arrayList2;
                jZ = j10;
            } else {
                jZ = cVar.z(xmlPullParser, jZ);
                strA = cVar.A(xmlPullParser, str2);
                arrayList = arrayList2;
                z10 = true;
            }
            if (v0.d(xmlPullParser, "MPD")) {
                if (jI != ya.g.f56663b) {
                    j11 = jI;
                } else if (j13 != ya.g.f56663b) {
                    j11 = j13;
                } else {
                    if (!zEquals) {
                        throw new ParserException("Unable to determine duration of static manifest.");
                    }
                    j11 = jI;
                }
                if (arrayList.isEmpty()) {
                    throw new ParserException("No periods found.");
                }
                return g(jF, j11, jI2, zEquals, jI3, jI4, jI5, jF2, gVarX, nVarQ0, kVarL0, uri, arrayList);
            }
            cVar = this;
            arrayList2 = arrayList;
            str2 = strA;
        }
    }

    public Pair<f, Long> W(XmlPullParser xmlPullParser, String str, long j10, long j11, long j12, long j13) throws XmlPullParserException, IOException {
        long j14;
        String str2;
        ArrayList arrayList;
        ArrayList arrayList2;
        Object obj;
        long j15;
        j jVarG0;
        c cVar = this;
        Object obj2 = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        long jI = I(xmlPullParser, xc.d.f55084n0, j10);
        long j16 = ya.g.f56663b;
        long j17 = j12 != ya.g.f56663b ? j12 + jI : -9223372036854775807L;
        long jI2 = I(xmlPullParser, "duration", ya.g.f56663b);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        String strA = str;
        long jZ = j11;
        long j18 = -9223372036854775807L;
        j jVarE0 = null;
        d dVarG = null;
        boolean z10 = false;
        while (true) {
            xmlPullParser.next();
            if (!v0.f(xmlPullParser, "BaseURL")) {
                if (v0.f(xmlPullParser, "AdaptationSet")) {
                    j14 = jZ;
                    str2 = strA;
                    arrayList = arrayList3;
                    arrayList.add(w(xmlPullParser, strA, jVarE0, jI2, jZ, j18, j17, j13));
                    arrayList2 = arrayList4;
                } else {
                    j14 = jZ;
                    ArrayList arrayList5 = arrayList4;
                    str2 = strA;
                    arrayList = arrayList3;
                    if (v0.f(xmlPullParser, "EventStream")) {
                        arrayList5.add(M(xmlPullParser));
                        arrayList2 = arrayList5;
                    } else if (v0.f(xmlPullParser, "SegmentBase")) {
                        arrayList2 = arrayList5;
                        jVarE0 = e0(xmlPullParser, null);
                        obj = null;
                        jZ = j14;
                        strA = str2;
                        j15 = ya.g.f56663b;
                    } else {
                        arrayList2 = arrayList5;
                        if (v0.f(xmlPullParser, "SegmentList")) {
                            long jZ2 = z(xmlPullParser, ya.g.f56663b);
                            obj = null;
                            jVarG0 = f0(xmlPullParser, null, j17, jI2, j14, jZ2, j13);
                            j18 = jZ2;
                            jZ = j14;
                            strA = str2;
                            j15 = ya.g.f56663b;
                        } else {
                            obj = null;
                            if (v0.f(xmlPullParser, "SegmentTemplate")) {
                                long jZ3 = z(xmlPullParser, ya.g.f56663b);
                                j15 = -9223372036854775807L;
                                jVarG0 = g0(xmlPullParser, null, ImmutableList.of(), j17, jI2, j14, jZ3, j13);
                                j18 = jZ3;
                                jZ = j14;
                                strA = str2;
                            } else {
                                j15 = ya.g.f56663b;
                                if (v0.f(xmlPullParser, "AssetIdentifier")) {
                                    dVarG = G(xmlPullParser, "AssetIdentifier");
                                } else {
                                    u(xmlPullParser);
                                }
                                jZ = j14;
                                strA = str2;
                            }
                        }
                        jVarE0 = jVarG0;
                    }
                }
                obj = null;
                j15 = ya.g.f56663b;
                jZ = j14;
                strA = str2;
            } else if (z10) {
                j14 = jZ;
                arrayList2 = arrayList4;
                str2 = strA;
                j15 = j16;
                obj = obj2;
                arrayList = arrayList3;
                jZ = j14;
                strA = str2;
            } else {
                jZ = cVar.z(xmlPullParser, jZ);
                strA = cVar.A(xmlPullParser, strA);
                arrayList2 = arrayList4;
                j15 = j16;
                obj = obj2;
                arrayList = arrayList3;
                z10 = true;
            }
            if (v0.d(xmlPullParser, "Period")) {
                return Pair.create(h(attributeValue, jI, arrayList, arrayList2, dVarG), Long.valueOf(jI2));
            }
            arrayList3 = arrayList;
            obj2 = obj;
            arrayList4 = arrayList2;
            j16 = j15;
            cVar = this;
        }
    }

    public g X(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String strNextText = null;
        String strM0 = m0(xmlPullParser, "moreInformationURL", null);
        String strM02 = m0(xmlPullParser, zc.f.f58391u, null);
        String strNextText2 = null;
        String strNextText3 = null;
        while (true) {
            xmlPullParser.next();
            if (v0.f(xmlPullParser, "Title")) {
                strNextText = xmlPullParser.nextText();
            } else if (v0.f(xmlPullParser, "Source")) {
                strNextText2 = xmlPullParser.nextText();
            } else if (v0.f(xmlPullParser, i1.a.f31548a0)) {
                strNextText3 = xmlPullParser.nextText();
            } else {
                u(xmlPullParser);
            }
            String str = strNextText3;
            if (v0.d(xmlPullParser, "ProgramInformation")) {
                return new g(strNextText, strNextText2, str, strM0, strM02);
            }
            strNextText3 = str;
        }
    }

    public h Y(XmlPullParser xmlPullParser, String str, String str2) {
        long j10;
        long j11;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] strArrSplit = attributeValue2.split("-");
            j10 = Long.parseLong(strArrSplit[0]);
            if (strArrSplit.length == 2) {
                j11 = (Long.parseLong(strArrSplit[1]) - j10) + 1;
            }
            return i(attributeValue, j10, j11);
        }
        j10 = 0;
        j11 = -1;
        return i(attributeValue, j10, j11);
    }

    public a Z(XmlPullParser xmlPullParser, String str, @p0 String str2, @p0 String str3, int i10, int i11, float f10, int i12, int i13, @p0 String str4, List<d> list, List<d> list2, List<d> list3, List<d> list4, @p0 j jVar, long j10, long j11, long j12, long j13, long j14) throws XmlPullParserException, IOException {
        long j15;
        String strA;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        int iY;
        long jZ;
        j eVar;
        c cVar = this;
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        int iQ = Q(xmlPullParser, "bandwidth", -1);
        String strM0 = m0(xmlPullParser, "mimeType", str2);
        String strM02 = m0(xmlPullParser, "codecs", str3);
        int iQ2 = Q(xmlPullParser, SocializeProtocolConstants.WIDTH, i10);
        int iQ3 = Q(xmlPullParser, SocializeProtocolConstants.HEIGHT, i11);
        float fO = O(xmlPullParser, f10);
        int iQ4 = Q(xmlPullParser, "audioSamplingRate", i13);
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList(list3);
        ArrayList arrayList10 = new ArrayList(list4);
        String str5 = str;
        int i14 = i12;
        long j16 = j12;
        long j17 = j13;
        String str6 = null;
        boolean z10 = false;
        j jVarG0 = jVar;
        while (true) {
            xmlPullParser.next();
            if (!v0.f(xmlPullParser, "BaseURL")) {
                if (v0.f(xmlPullParser, "AudioChannelConfiguration")) {
                    eVar = jVarG0;
                    strA = str5;
                    arrayList4 = arrayList7;
                    iY = y(xmlPullParser);
                } else if (v0.f(xmlPullParser, "SegmentBase")) {
                    j.e eVarE0 = cVar.e0(xmlPullParser, (j.e) jVarG0);
                    strA = str5;
                    arrayList4 = arrayList7;
                    iY = i14;
                    eVar = eVarE0;
                } else {
                    if (v0.f(xmlPullParser, "SegmentList")) {
                        jZ = cVar.z(xmlPullParser, j17);
                        j15 = j16;
                        strA = str5;
                        arrayList = arrayList10;
                        arrayList2 = arrayList8;
                        arrayList3 = arrayList9;
                        jVarG0 = f0(xmlPullParser, (j.b) jVarG0, j10, j11, j15, jZ, j14);
                        arrayList4 = arrayList7;
                    } else {
                        j15 = j16;
                        strA = str5;
                        arrayList = arrayList10;
                        arrayList2 = arrayList8;
                        arrayList3 = arrayList9;
                        if (v0.f(xmlPullParser, "SegmentTemplate")) {
                            jZ = cVar.z(xmlPullParser, j17);
                            arrayList4 = arrayList7;
                            jVarG0 = g0(xmlPullParser, (j.c) jVarG0, list4, j10, j11, j15, jZ, j14);
                        } else {
                            arrayList4 = arrayList7;
                            if (v0.f(xmlPullParser, "ContentProtection")) {
                                Pair<String, DrmInitData.SchemeData> pairD = D(xmlPullParser);
                                Object obj = pairD.first;
                                if (obj != null) {
                                    str6 = (String) obj;
                                }
                                Object obj2 = pairD.second;
                                if (obj2 != null) {
                                    arrayList4.add((DrmInitData.SchemeData) obj2);
                                }
                                iY = i14;
                                j16 = j15;
                                arrayList6 = arrayList;
                                arrayList5 = arrayList2;
                                arrayList9 = arrayList3;
                                eVar = jVarG0;
                            } else {
                                if (v0.f(xmlPullParser, "InbandEventStream")) {
                                    arrayList5 = arrayList2;
                                    arrayList5.add(G(xmlPullParser, "InbandEventStream"));
                                    arrayList6 = arrayList;
                                    arrayList9 = arrayList3;
                                } else {
                                    arrayList5 = arrayList2;
                                    if (v0.f(xmlPullParser, "EssentialProperty")) {
                                        arrayList9 = arrayList3;
                                        arrayList9.add(G(xmlPullParser, "EssentialProperty"));
                                        arrayList6 = arrayList;
                                    } else {
                                        arrayList9 = arrayList3;
                                        if (v0.f(xmlPullParser, "SupplementalProperty")) {
                                            arrayList6 = arrayList;
                                            arrayList6.add(G(xmlPullParser, "SupplementalProperty"));
                                        } else {
                                            arrayList6 = arrayList;
                                            u(xmlPullParser);
                                        }
                                    }
                                }
                                iY = i14;
                                j16 = j15;
                                eVar = jVarG0;
                            }
                        }
                    }
                    iY = i14;
                    j17 = jZ;
                    j16 = j15;
                    arrayList6 = arrayList;
                    arrayList5 = arrayList2;
                    arrayList9 = arrayList3;
                    eVar = jVarG0;
                }
                arrayList5 = arrayList8;
                arrayList6 = arrayList10;
            } else if (z10) {
                j15 = j16;
                strA = str5;
                arrayList4 = arrayList7;
                arrayList5 = arrayList8;
                arrayList6 = arrayList10;
                iY = i14;
                j16 = j15;
                eVar = jVarG0;
            } else {
                long jZ2 = cVar.z(xmlPullParser, j16);
                strA = cVar.A(xmlPullParser, str5);
                arrayList4 = arrayList7;
                iY = i14;
                z10 = true;
                eVar = jVarG0;
                j16 = jZ2;
                arrayList5 = arrayList8;
                arrayList6 = arrayList10;
            }
            if (v0.d(xmlPullParser, "Representation")) {
                break;
            }
            arrayList10 = arrayList6;
            arrayList8 = arrayList5;
            arrayList7 = arrayList4;
            jVarG0 = eVar;
            cVar = this;
            i14 = iY;
            str5 = strA;
        }
        ArrayList arrayList11 = arrayList5;
        Format formatF = f(attributeValue, strM0, iQ2, iQ3, fO, iY, iQ4, iQ, str4, list, list2, strM02, arrayList9, arrayList6);
        if (eVar == null) {
            eVar = new j.e();
        }
        return new a(formatF, strA, eVar, str6, arrayList4, arrayList11, -1L);
    }

    public int a0(List<d> list) {
        int iO0;
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            d dVar = list.get(i11);
            if (Ascii.equalsIgnoreCase("urn:mpeg:dash:role:2011", dVar.f32058a)) {
                iO0 = b0(dVar.f32059b);
            } else if (Ascii.equalsIgnoreCase("urn:tva:metadata:cs:AudioPurposeCS:2007", dVar.f32058a)) {
                iO0 = o0(dVar.f32059b);
            }
            i10 |= iO0;
        }
        return i10;
    }

    public final long b(List<j.d> list, long j10, long j11, int i10, long j12) {
        int iN = i10 >= 0 ? i10 + 1 : (int) u0.n(j12 - j10, j11);
        for (int i11 = 0; i11 < iN; i11++) {
            list.add(m(j10, j11));
            j10 += j11;
        }
        return j10;
    }

    public int b0(@p0 String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
        }
        return 0;
    }

    public ic.a c(int i10, int i11, List<i> list, List<d> list2, List<d> list3, List<d> list4) {
        return new ic.a(i10, i11, list, list2, list3, list4);
    }

    public int c0(List<d> list) {
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (Ascii.equalsIgnoreCase("http://dashif.org/guidelines/trickmode", list.get(i11).f32058a)) {
                i10 |= 16384;
            }
        }
        return i10;
    }

    public EventMessage d(String str, String str2, long j10, long j11, byte[] bArr) {
        return new EventMessage(str, str2, j11, j10, bArr);
    }

    public int d0(List<d> list) {
        int iB0 = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            d dVar = list.get(i10);
            if (Ascii.equalsIgnoreCase("urn:mpeg:dash:role:2011", dVar.f32058a)) {
                iB0 |= b0(dVar.f32059b);
            }
        }
        return iB0;
    }

    public e e(String str, String str2, long j10, long[] jArr, EventMessage[] eventMessageArr) {
        return new e(str, str2, j10, jArr, eventMessageArr);
    }

    public j.e e0(XmlPullParser xmlPullParser, @p0 j.e eVar) throws XmlPullParserException, IOException {
        long j10;
        long j11;
        long jT = T(xmlPullParser, "timescale", eVar != null ? eVar.f32094b : 1L);
        long jT2 = T(xmlPullParser, "presentationTimeOffset", eVar != null ? eVar.f32095c : 0L);
        long j12 = eVar != null ? eVar.f32108d : 0L;
        long j13 = eVar != null ? eVar.f32109e : 0L;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] strArrSplit = attributeValue.split("-");
            long j14 = Long.parseLong(strArrSplit[0]);
            j10 = (Long.parseLong(strArrSplit[1]) - j14) + 1;
            j11 = j14;
        } else {
            j10 = j13;
            j11 = j12;
        }
        h hVarP = eVar != null ? eVar.f32093a : null;
        do {
            xmlPullParser.next();
            if (v0.f(xmlPullParser, "Initialization")) {
                hVarP = P(xmlPullParser);
            } else {
                u(xmlPullParser);
            }
        } while (!v0.d(xmlPullParser, "SegmentBase"));
        return n(hVarP, jT, jT2, j11, j10);
    }

    public Format f(@p0 String str, @p0 String str2, int i10, int i11, float f10, int i12, int i13, int i14, @p0 String str3, List<d> list, List<d> list2, @p0 String str4, List<d> list3, List<d> list4) {
        String strT = t(str2, str4);
        if (w.K.equals(strT)) {
            strT = J(list4);
        }
        int iK0 = k0(list);
        Format.b bVarV = new Format.b().S(str).K(str2).e0(strT).I(str4).Z(i14).g0(iK0).c0(d0(list) | a0(list2) | c0(list3) | c0(list4)).V(str3);
        if (w.s(strT)) {
            bVarV.j0(i10).Q(i11).P(f10);
        } else if (w.p(strT)) {
            bVarV.H(i12).f0(i13);
        } else if (w.r(strT)) {
            int iC = -1;
            if (w.f31195l0.equals(strT)) {
                iC = B(list2);
            } else if (w.f31197m0.equals(strT)) {
                iC = C(list2);
            }
            bVarV.F(iC);
        }
        return bVarV.E();
    }

    public j.b f0(XmlPullParser xmlPullParser, @p0 j.b bVar, long j10, long j11, long j12, long j13, long j14) throws XmlPullParserException, IOException {
        long jT = T(xmlPullParser, "timescale", bVar != null ? bVar.f32094b : 1L);
        long jT2 = T(xmlPullParser, "presentationTimeOffset", bVar != null ? bVar.f32095c : 0L);
        long jT3 = T(xmlPullParser, "duration", bVar != null ? bVar.f32097e : ya.g.f56663b);
        long jT4 = T(xmlPullParser, "startNumber", bVar != null ? bVar.f32096d : 1L);
        long jS = s(j12, j13);
        List<j.d> listH0 = null;
        List<h> arrayList = null;
        h hVarP = null;
        do {
            xmlPullParser.next();
            if (v0.f(xmlPullParser, "Initialization")) {
                hVarP = P(xmlPullParser);
            } else if (v0.f(xmlPullParser, "SegmentTimeline")) {
                listH0 = h0(xmlPullParser, jT, j11);
            } else if (v0.f(xmlPullParser, "SegmentURL")) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(i0(xmlPullParser));
            } else {
                u(xmlPullParser);
            }
        } while (!v0.d(xmlPullParser, "SegmentList"));
        if (bVar != null) {
            if (hVarP == null) {
                hVarP = bVar.f32093a;
            }
            if (listH0 == null) {
                listH0 = bVar.f32098f;
            }
            if (arrayList == null) {
                arrayList = bVar.f32102j;
            }
        }
        return k(hVarP, jT, jT2, jT4, jT3, listH0, jS, arrayList, j14, j10);
    }

    public b g(long j10, long j11, long j12, boolean z10, long j13, long j14, long j15, long j16, @p0 g gVar, @p0 n nVar, @p0 k kVar, @p0 Uri uri, List<f> list) {
        return new b(j10, j11, j12, z10, j13, j14, j15, j16, gVar, nVar, kVar, uri, list);
    }

    public j.c g0(XmlPullParser xmlPullParser, @p0 j.c cVar, List<d> list, long j10, long j11, long j12, long j13, long j14) throws XmlPullParserException, IOException {
        long jT = T(xmlPullParser, "timescale", cVar != null ? cVar.f32094b : 1L);
        long jT2 = T(xmlPullParser, "presentationTimeOffset", cVar != null ? cVar.f32095c : 0L);
        long jT3 = T(xmlPullParser, "duration", cVar != null ? cVar.f32097e : ya.g.f56663b);
        long jT4 = T(xmlPullParser, "startNumber", cVar != null ? cVar.f32096d : 1L);
        long jS = S(list);
        long jS2 = s(j12, j13);
        List<j.d> listH0 = null;
        m mVarP0 = p0(xmlPullParser, SocializeConstants.KEY_PLATFORM, cVar != null ? cVar.f32104k : null);
        m mVarP02 = p0(xmlPullParser, "initialization", cVar != null ? cVar.f32103j : null);
        h hVarP = null;
        do {
            xmlPullParser.next();
            if (v0.f(xmlPullParser, "Initialization")) {
                hVarP = P(xmlPullParser);
            } else if (v0.f(xmlPullParser, "SegmentTimeline")) {
                listH0 = h0(xmlPullParser, jT, j11);
            } else {
                u(xmlPullParser);
            }
        } while (!v0.d(xmlPullParser, "SegmentTemplate"));
        if (cVar != null) {
            if (hVarP == null) {
                hVarP = cVar.f32093a;
            }
            if (listH0 == null) {
                listH0 = cVar.f32098f;
            }
        }
        return l(hVarP, jT, jT2, jT4, jS, jT3, listH0, jS2, mVarP02, mVarP0, j14, j10);
    }

    public f h(@p0 String str, long j10, List<ic.a> list, List<e> list2, @p0 d dVar) {
        return new f(str, j10, list, list2, dVar);
    }

    public List<j.d> h0(XmlPullParser xmlPullParser, long j10, long j11) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long jB = 0;
        long jT = -9223372036854775807L;
        boolean z10 = false;
        int iQ = 0;
        do {
            xmlPullParser.next();
            if (v0.f(xmlPullParser, i1.a.R4)) {
                long jT2 = T(xmlPullParser, "t", ya.g.f56663b);
                if (z10) {
                    jB = b(arrayList, jB, jT, iQ, jT2);
                }
                if (jT2 == ya.g.f56663b) {
                    jT2 = jB;
                }
                jT = T(xmlPullParser, "d", ya.g.f56663b);
                iQ = Q(xmlPullParser, SsManifestParser.e.J, 0);
                jB = jT2;
                z10 = true;
            } else {
                u(xmlPullParser);
            }
        } while (!v0.d(xmlPullParser, "SegmentTimeline"));
        if (z10) {
            b(arrayList, jB, jT, iQ, u0.h1(j11, j10, 1000L));
        }
        return arrayList;
    }

    public h i(String str, long j10, long j11) {
        return new h(str, j10, j11);
    }

    public h i0(XmlPullParser xmlPullParser) {
        return Y(xmlPullParser, SocializeConstants.KEY_PLATFORM, "mediaRange");
    }

    public i j(a aVar, @p0 String str, @p0 String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<d> arrayList2) {
        Format.b bVarA = aVar.f32051a.a();
        if (str != null) {
            bVarA.U(str);
        }
        String str3 = aVar.f32054d;
        if (str3 != null) {
            str2 = str3;
        }
        ArrayList<DrmInitData.SchemeData> arrayList3 = aVar.f32055e;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            r(arrayList3);
            bVarA.L(new DrmInitData(str2, arrayList3));
        }
        ArrayList<d> arrayList4 = aVar.f32056f;
        arrayList4.addAll(arrayList2);
        return i.p(aVar.f32057g, bVarA.E(), aVar.f32052b, aVar.f32053c, arrayList4);
    }

    public int j0(@p0 String str) {
        if (str == null) {
            return 0;
        }
        if (str.equals("forced_subtitle")) {
            return 2;
        }
        return !str.equals("main") ? 0 : 1;
    }

    public j.b k(h hVar, long j10, long j11, long j12, long j13, @p0 List<j.d> list, long j14, @p0 List<h> list2, long j15, long j16) {
        return new j.b(hVar, j10, j11, j12, j13, list, j14, list2, ya.g.c(j15), ya.g.c(j16));
    }

    public int k0(List<d> list) {
        int iJ0 = 0;
        for (int i10 = 0; i10 < list.size(); i10++) {
            d dVar = list.get(i10);
            if (Ascii.equalsIgnoreCase("urn:mpeg:dash:role:2011", dVar.f32058a)) {
                iJ0 |= j0(dVar.f32059b);
            }
        }
        return iJ0;
    }

    public j.c l(h hVar, long j10, long j11, long j12, long j13, long j14, List<j.d> list, long j15, @p0 m mVar, @p0 m mVar2, long j16, long j17) {
        return new j.c(hVar, j10, j11, j12, j13, j14, list, j15, mVar, mVar2, ya.g.c(j16), ya.g.c(j17));
    }

    public k l0(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        long jT = -9223372036854775807L;
        long jT2 = -9223372036854775807L;
        long jT3 = -9223372036854775807L;
        float fN = -3.4028235E38f;
        float fN2 = -3.4028235E38f;
        while (true) {
            xmlPullParser.next();
            if (v0.f(xmlPullParser, "Latency")) {
                jT = T(xmlPullParser, "target", ya.g.f56663b);
                jT2 = T(xmlPullParser, "min", ya.g.f56663b);
                jT3 = T(xmlPullParser, "max", ya.g.f56663b);
            } else if (v0.f(xmlPullParser, "PlaybackRate")) {
                fN = N(xmlPullParser, "min", -3.4028235E38f);
                fN2 = N(xmlPullParser, "max", -3.4028235E38f);
            }
            long j10 = jT;
            long j11 = jT2;
            long j12 = jT3;
            float f10 = fN;
            float f11 = fN2;
            if (v0.d(xmlPullParser, "ServiceDescription")) {
                return new k(j10, j11, j12, f10, f11);
            }
            jT = j10;
            jT2 = j11;
            jT3 = j12;
            fN = f10;
            fN2 = f11;
        }
    }

    public j.d m(long j10, long j11) {
        return new j.d(j10, j11);
    }

    public j.e n(h hVar, long j10, long j11, long j12, long j13) {
        return new j.e(hVar, j10, j11, j12, j13);
    }

    public n o(String str, String str2) {
        return new n(str, str2);
    }

    public int o0(@p0 String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
        }
        return 0;
    }

    @p0
    public m p0(XmlPullParser xmlPullParser, String str, @p0 m mVar) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? m.b(attributeValue) : mVar;
    }

    public n q0(XmlPullParser xmlPullParser) {
        return o(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, "value"));
    }

    @Override // com.google.android.exoplayer2.upstream.k.a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public b a(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f32050a.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, null);
            if (xmlPullParserNewPullParser.next() == 2 && "MPD".equals(xmlPullParserNewPullParser.getName())) {
                return U(xmlPullParserNewPullParser, uri.toString());
            }
            throw new ParserException("inputStream does not contain a valid media presentation description");
        } catch (XmlPullParserException e10) {
            throw new ParserException(e10);
        }
    }

    public ic.a w(XmlPullParser xmlPullParser, String str, @p0 j jVar, long j10, long j11, long j12, long j13, long j14) throws XmlPullParserException, IOException {
        String str2;
        long j15;
        String str3;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList<DrmInitData.SchemeData> arrayList5;
        String str4;
        Object obj;
        ArrayList arrayList6;
        int i10;
        ArrayList<d> arrayList7;
        long jZ;
        c cVar = this;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        int iQ = Q(xmlPullParser2, "id", -1);
        int iE = E(xmlPullParser);
        String attributeValue = xmlPullParser2.getAttributeValue(null, "mimeType");
        String attributeValue2 = xmlPullParser2.getAttributeValue(null, "codecs");
        int iQ2 = Q(xmlPullParser2, SocializeProtocolConstants.WIDTH, -1);
        int iQ3 = Q(xmlPullParser2, SocializeProtocolConstants.HEIGHT, -1);
        float fO = O(xmlPullParser2, -1.0f);
        int iQ4 = Q(xmlPullParser2, "audioSamplingRate", -1);
        String str5 = zc.f.f58391u;
        String attributeValue3 = xmlPullParser2.getAttributeValue(null, zc.f.f58391u);
        String attributeValue4 = xmlPullParser2.getAttributeValue(null, "label");
        ArrayList<DrmInitData.SchemeData> arrayList8 = new ArrayList<>();
        ArrayList<d> arrayList9 = new ArrayList<>();
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        String strA = str;
        j jVarG0 = jVar;
        int iP = iE;
        String strQ = attributeValue3;
        String strR = attributeValue4;
        String str6 = null;
        int iY = -1;
        boolean z10 = false;
        long jZ2 = j11;
        long j16 = j12;
        while (true) {
            xmlPullParser.next();
            if (v0.f(xmlPullParser2, "BaseURL")) {
                if (z10) {
                    j15 = jZ2;
                    arrayList6 = arrayList14;
                    arrayList = arrayList13;
                    arrayList2 = arrayList12;
                    arrayList3 = arrayList11;
                    arrayList4 = arrayList10;
                    arrayList7 = arrayList9;
                    arrayList5 = arrayList8;
                    str4 = str5;
                    i10 = iP;
                    str2 = strQ;
                    obj = null;
                    str3 = strA;
                    strA = str3;
                    strQ = str2;
                    iP = i10;
                } else {
                    jZ2 = cVar.z(xmlPullParser2, jZ2);
                    strA = cVar.A(xmlPullParser2, strA);
                    z10 = true;
                    j15 = jZ2;
                    arrayList6 = arrayList14;
                    arrayList = arrayList13;
                    arrayList2 = arrayList12;
                    arrayList3 = arrayList11;
                    arrayList4 = arrayList10;
                    arrayList7 = arrayList9;
                    arrayList5 = arrayList8;
                    str4 = str5;
                    obj = null;
                }
            } else if (v0.f(xmlPullParser2, "ContentProtection")) {
                Pair<String, DrmInitData.SchemeData> pairD = D(xmlPullParser);
                long j17 = j16;
                Object obj2 = pairD.first;
                if (obj2 != null) {
                    str6 = (String) obj2;
                }
                Object obj3 = pairD.second;
                if (obj3 != null) {
                    arrayList8.add((DrmInitData.SchemeData) obj3);
                }
                j16 = j17;
                j15 = jZ2;
                arrayList6 = arrayList14;
                arrayList = arrayList13;
                arrayList2 = arrayList12;
                arrayList3 = arrayList11;
                arrayList4 = arrayList10;
                arrayList7 = arrayList9;
                arrayList5 = arrayList8;
                str4 = str5;
                obj = null;
            } else {
                long j18 = j16;
                if (v0.f(xmlPullParser2, "ContentComponent")) {
                    strQ = q(strQ, xmlPullParser2.getAttributeValue(null, str5));
                    iP = p(iP, E(xmlPullParser));
                    j15 = jZ2;
                    arrayList6 = arrayList14;
                    arrayList = arrayList13;
                    arrayList2 = arrayList12;
                    arrayList3 = arrayList11;
                    arrayList4 = arrayList10;
                    arrayList7 = arrayList9;
                    arrayList5 = arrayList8;
                    str4 = str5;
                    obj = null;
                    j16 = j18;
                } else {
                    int i11 = iP;
                    String str7 = strQ;
                    if (v0.f(xmlPullParser2, "Role")) {
                        arrayList11.add(G(xmlPullParser2, "Role"));
                    } else if (v0.f(xmlPullParser2, "AudioChannelConfiguration")) {
                        iY = y(xmlPullParser);
                        strQ = str7;
                        j15 = jZ2;
                        arrayList = arrayList13;
                        arrayList2 = arrayList12;
                        arrayList3 = arrayList11;
                        arrayList4 = arrayList10;
                        arrayList7 = arrayList9;
                        arrayList5 = arrayList8;
                        str4 = str5;
                        obj = null;
                        iP = i11;
                        j16 = j18;
                        arrayList6 = arrayList14;
                    } else if (v0.f(xmlPullParser2, "Accessibility")) {
                        arrayList10.add(G(xmlPullParser2, "Accessibility"));
                    } else if (v0.f(xmlPullParser2, "EssentialProperty")) {
                        arrayList12.add(G(xmlPullParser2, "EssentialProperty"));
                    } else if (v0.f(xmlPullParser2, "SupplementalProperty")) {
                        arrayList13.add(G(xmlPullParser2, "SupplementalProperty"));
                    } else if (v0.f(xmlPullParser2, "Representation")) {
                        j15 = jZ2;
                        arrayList = arrayList13;
                        arrayList2 = arrayList12;
                        arrayList3 = arrayList11;
                        arrayList4 = arrayList10;
                        arrayList5 = arrayList8;
                        str4 = str5;
                        obj = null;
                        a aVarZ = Z(xmlPullParser, strA, attributeValue, attributeValue2, iQ2, iQ3, fO, iY, iQ4, str7, arrayList3, arrayList4, arrayList2, arrayList, jVarG0, j13, j10, j15, j18, j14);
                        int iP2 = p(i11, w.l(aVarZ.f32051a.f16699l));
                        arrayList6 = arrayList14;
                        arrayList6.add(aVarZ);
                        xmlPullParser2 = xmlPullParser;
                        strA = strA;
                        arrayList7 = arrayList9;
                        strQ = str7;
                        iP = iP2;
                        j16 = j18;
                    } else {
                        str2 = str7;
                        j15 = jZ2;
                        str3 = strA;
                        arrayList = arrayList13;
                        arrayList2 = arrayList12;
                        arrayList3 = arrayList11;
                        arrayList4 = arrayList10;
                        ArrayList<d> arrayList15 = arrayList9;
                        arrayList5 = arrayList8;
                        str4 = str5;
                        obj = null;
                        arrayList6 = arrayList14;
                        if (v0.f(xmlPullParser, "SegmentBase")) {
                            jVarG0 = e0(xmlPullParser, (j.e) jVarG0);
                            strA = str3;
                            arrayList7 = arrayList15;
                            j16 = j18;
                            strQ = str2;
                            iP = i11;
                            xmlPullParser2 = xmlPullParser;
                        } else {
                            if (v0.f(xmlPullParser, "SegmentList")) {
                                jZ = z(xmlPullParser, j18);
                                i10 = i11;
                                jVarG0 = f0(xmlPullParser, (j.b) jVarG0, j13, j10, j15, jZ, j14);
                                xmlPullParser2 = xmlPullParser;
                            } else {
                                j16 = j18;
                                i10 = i11;
                                if (v0.f(xmlPullParser, "SegmentTemplate")) {
                                    jZ = z(xmlPullParser, j16);
                                    xmlPullParser2 = xmlPullParser;
                                    jVarG0 = g0(xmlPullParser, (j.c) jVarG0, arrayList, j13, j10, j15, jZ, j14);
                                } else {
                                    xmlPullParser2 = xmlPullParser;
                                    if (v0.f(xmlPullParser2, "InbandEventStream")) {
                                        arrayList7 = arrayList15;
                                        arrayList7.add(G(xmlPullParser2, "InbandEventStream"));
                                    } else {
                                        arrayList7 = arrayList15;
                                        if (v0.f(xmlPullParser2, "Label")) {
                                            strR = R(xmlPullParser);
                                        } else if (v0.e(xmlPullParser)) {
                                            x(xmlPullParser);
                                        }
                                    }
                                    strA = str3;
                                    strQ = str2;
                                    iP = i10;
                                }
                            }
                            j16 = jZ;
                            strA = str3;
                            arrayList7 = arrayList15;
                            strQ = str2;
                            iP = i10;
                        }
                    }
                    str2 = str7;
                    j15 = jZ2;
                    str3 = strA;
                    arrayList = arrayList13;
                    arrayList2 = arrayList12;
                    arrayList3 = arrayList11;
                    arrayList4 = arrayList10;
                    arrayList7 = arrayList9;
                    arrayList5 = arrayList8;
                    str4 = str5;
                    obj = null;
                    i10 = i11;
                    j16 = j18;
                    arrayList6 = arrayList14;
                    strA = str3;
                    strQ = str2;
                    iP = i10;
                }
            }
            if (v0.d(xmlPullParser2, "AdaptationSet")) {
                break;
            }
            arrayList9 = arrayList7;
            arrayList14 = arrayList6;
            jZ2 = j15;
            arrayList13 = arrayList;
            arrayList12 = arrayList2;
            arrayList11 = arrayList3;
            arrayList10 = arrayList4;
            arrayList8 = arrayList5;
            str5 = str4;
            cVar = this;
        }
        ArrayList arrayList16 = new ArrayList(arrayList6.size());
        for (int i12 = 0; i12 < arrayList6.size(); i12++) {
            arrayList16.add(j((a) arrayList6.get(i12), strR, str6, arrayList5, arrayList7));
        }
        return c(iQ, iP, arrayList16, arrayList4, arrayList2, arrayList);
    }

    public void x(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        u(xmlPullParser);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int y(org.xmlpull.v1.XmlPullParser r4) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "schemeIdUri"
            r1 = 0
            java.lang.String r0 = m0(r4, r0, r1)
            r0.hashCode()
            int r1 = r0.hashCode()
            r2 = -1
            switch(r1) {
                case -1352850286: goto L35;
                case -1138141449: goto L2a;
                case -986633423: goto L1f;
                case 2036691300: goto L14;
                default: goto L12;
            }
        L12:
            r0 = -1
            goto L3f
        L14:
            java.lang.String r1 = "urn:dolby:dash:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L1d
            goto L12
        L1d:
            r0 = 3
            goto L3f
        L1f:
            java.lang.String r1 = "urn:mpeg:mpegB:cicp:ChannelConfiguration"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L28
            goto L12
        L28:
            r0 = 2
            goto L3f
        L2a:
            java.lang.String r1 = "tag:dolby.com,2014:dash:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L33
            goto L12
        L33:
            r0 = 1
            goto L3f
        L35:
            java.lang.String r1 = "urn:mpeg:dash:23003:3:audio_channel_configuration:2011"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L3e
            goto L12
        L3e:
            r0 = 0
        L3f:
            switch(r0) {
                case 0: goto L4d;
                case 1: goto L48;
                case 2: goto L43;
                case 3: goto L48;
                default: goto L42;
            }
        L42:
            goto L53
        L43:
            int r2 = V(r4)
            goto L53
        L48:
            int r2 = H(r4)
            goto L53
        L4d:
            java.lang.String r0 = "value"
            int r2 = Q(r4, r0, r2)
        L53:
            r4.next()
            java.lang.String r0 = "AudioChannelConfiguration"
            boolean r0 = hd.v0.d(r4, r0)
            if (r0 == 0) goto L53
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: ic.c.y(org.xmlpull.v1.XmlPullParser):int");
    }

    public long z(XmlPullParser xmlPullParser, long j10) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j10;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return (long) (Float.parseFloat(attributeValue) * 1000000.0f);
    }
}
