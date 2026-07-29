package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.a;
import com.google.android.exoplayer2.upstream.k;
import g.p0;
import hd.u0;
import hd.w;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import ob.l;
import ob.p;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import ya.g;

/* JADX INFO: loaded from: classes3.dex */
public class SsManifestParser implements k.a<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XmlPullParserFactory f18339a;

    public static class MissingFieldException extends ParserException {
        public MissingFieldException(String str) {
            super("Missing required field: " + str);
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f18341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public final a f18342c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<Pair<String, Object>> f18343d = new LinkedList();

        public a(@p0 a aVar, String str, String str2) {
            this.f18342c = aVar;
            this.f18340a = str;
            this.f18341b = str2;
        }

        public void a(Object obj) {
        }

        public abstract Object b();

        @p0
        public final Object c(String str) {
            for (int i10 = 0; i10 < this.f18343d.size(); i10++) {
                Pair<String, Object> pair = this.f18343d.get(i10);
                if (((String) pair.first).equals(str)) {
                    return pair.second;
                }
            }
            a aVar = this.f18342c;
            if (aVar == null) {
                return null;
            }
            return aVar.c(str);
        }

        public boolean d(String str) {
            return false;
        }

        public final a e(a aVar, String str, String str2) {
            if (c.f18351f.equals(str)) {
                return new c(aVar, str2);
            }
            if (b.f18344h.equals(str)) {
                return new b(aVar, str2);
            }
            if (e.f18382s.equals(str)) {
                return new e(aVar, str2);
            }
            return null;
        }

        public final Object f(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (this.f18341b.equals(name)) {
                        n(xmlPullParser);
                        z10 = true;
                    } else if (z10) {
                        if (i10 > 0) {
                            i10++;
                        } else if (d(name)) {
                            n(xmlPullParser);
                        } else {
                            a aVarE = e(this, name, this.f18340a);
                            if (aVarE == null) {
                                i10 = 1;
                            } else {
                                a(aVarE.f(xmlPullParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z10 && i10 == 0) {
                        o(xmlPullParser);
                    }
                } else if (!z10) {
                    continue;
                } else if (i10 > 0) {
                    i10--;
                } else {
                    String name2 = xmlPullParser.getName();
                    h(xmlPullParser);
                    if (!d(name2)) {
                        return b();
                    }
                }
                xmlPullParser.next();
            }
        }

        public final boolean g(XmlPullParser xmlPullParser, String str, boolean z10) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue != null ? Boolean.parseBoolean(attributeValue) : z10;
        }

        public void h(XmlPullParser xmlPullParser) {
        }

        public final int i(XmlPullParser xmlPullParser, String str, int i10) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return i10;
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e10) {
                throw new ParserException(e10);
            }
        }

        public final long j(XmlPullParser xmlPullParser, String str, long j10) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return j10;
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e10) {
                throw new ParserException(e10);
            }
        }

        public final int k(XmlPullParser xmlPullParser, String str) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                throw new MissingFieldException(str);
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e10) {
                throw new ParserException(e10);
            }
        }

        public final long l(XmlPullParser xmlPullParser, String str) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                throw new MissingFieldException(str);
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e10) {
                throw new ParserException(e10);
            }
        }

        public final String m(XmlPullParser xmlPullParser, String str) throws MissingFieldException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new MissingFieldException(str);
        }

        public void n(XmlPullParser xmlPullParser) throws ParserException {
        }

        public void o(XmlPullParser xmlPullParser) {
        }

        public final void p(String str, @p0 Object obj) {
            this.f18343d.add(Pair.create(str, obj));
        }
    }

    public static class b extends a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f18344h = "Protection";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String f18345i = "ProtectionHeader";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String f18346j = "SystemID";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f18347k = 8;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f18348e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public UUID f18349f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte[] f18350g;

        public b(a aVar, String str) {
            super(aVar, str, f18344h);
        }

        public static p[] q(byte[] bArr) {
            return new p[]{new p(true, null, 8, r(bArr), 0, 0, null)};
        }

        public static byte[] r(byte[] bArr) {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < bArr.length; i10 += 2) {
                sb2.append((char) bArr[i10]);
            }
            String string = sb2.toString();
            byte[] bArrDecode = Base64.decode(string.substring(string.indexOf("<KID>") + 5, string.indexOf("</KID>")), 0);
            t(bArrDecode, 0, 3);
            t(bArrDecode, 1, 2);
            t(bArrDecode, 4, 5);
            t(bArrDecode, 6, 7);
            return bArrDecode;
        }

        public static String s(String str) {
            return (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') ? str.substring(1, str.length() - 1) : str;
        }

        public static void t(byte[] bArr, int i10, int i11) {
            byte b10 = bArr[i10];
            bArr[i10] = bArr[i11];
            bArr[i11] = b10;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            UUID uuid = this.f18349f;
            return new a.C0192a(uuid, l.a(uuid, this.f18350g), q(this.f18350g));
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean d(String str) {
            return f18345i.equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void h(XmlPullParser xmlPullParser) {
            if (f18345i.equals(xmlPullParser.getName())) {
                this.f18348e = false;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) {
            if (f18345i.equals(xmlPullParser.getName())) {
                this.f18348e = true;
                this.f18349f = UUID.fromString(s(xmlPullParser.getAttributeValue(null, f18346j)));
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void o(XmlPullParser xmlPullParser) {
            if (this.f18348e) {
                this.f18350g = Base64.decode(xmlPullParser.getText(), 0);
            }
        }
    }

    public static class c extends a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f18351f = "QualityLevel";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f18352g = "Index";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f18353h = "Bitrate";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String f18354i = "CodecPrivateData";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String f18355j = "SamplingRate";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String f18356k = "Channels";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final String f18357l = "FourCC";

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final String f18358m = "Type";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final String f18359n = "Subtype";

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String f18360o = "Language";

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final String f18361p = "Name";

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final String f18362q = "MaxWidth";

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final String f18363r = "MaxHeight";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Format f18364e;

        public c(a aVar, String str) {
            super(aVar, str, f18351f);
        }

        public static List<byte[]> q(String str) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] bArrQ = u0.Q(str);
                byte[][] bArrI = hd.d.i(bArrQ);
                if (bArrI == null) {
                    arrayList.add(bArrQ);
                } else {
                    Collections.addAll(arrayList, bArrI);
                }
            }
            return arrayList;
        }

        @p0
        public static String r(String str) {
            if (str.equalsIgnoreCase("H264") || str.equalsIgnoreCase("X264") || str.equalsIgnoreCase("AVC1") || str.equalsIgnoreCase("DAVC")) {
                return w.f31190j;
            }
            if (str.equalsIgnoreCase("AAC") || str.equalsIgnoreCase("AACL") || str.equalsIgnoreCase("AACH") || str.equalsIgnoreCase("AACP")) {
                return w.A;
            }
            if (str.equalsIgnoreCase("TTML") || str.equalsIgnoreCase("DFXP")) {
                return w.f31201o0;
            }
            if (str.equalsIgnoreCase("ac-3") || str.equalsIgnoreCase("dac3")) {
                return w.J;
            }
            if (str.equalsIgnoreCase("ec-3") || str.equalsIgnoreCase("dec3")) {
                return w.K;
            }
            if (str.equalsIgnoreCase("dtsc")) {
                return w.O;
            }
            if (str.equalsIgnoreCase("dtsh") || str.equalsIgnoreCase("dtsl")) {
                return w.P;
            }
            if (str.equalsIgnoreCase("dtse")) {
                return w.Q;
            }
            if (str.equalsIgnoreCase("opus")) {
                return w.S;
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            return this.f18364e;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) throws ParserException {
            Format.b bVar = new Format.b();
            String strR = r(m(xmlPullParser, f18357l));
            int iIntValue = ((Integer) c("Type")).intValue();
            if (iIntValue == 2) {
                bVar.K(w.f31182f).j0(k(xmlPullParser, "MaxWidth")).Q(k(xmlPullParser, "MaxHeight")).T(q(xmlPullParser.getAttributeValue(null, f18354i)));
            } else if (iIntValue == 1) {
                if (strR == null) {
                    strR = w.A;
                }
                int iK = k(xmlPullParser, f18356k);
                int iK2 = k(xmlPullParser, f18355j);
                List<byte[]> listQ = q(xmlPullParser.getAttributeValue(null, f18354i));
                if (listQ.isEmpty() && w.A.equals(strR)) {
                    listQ = Collections.singletonList(ab.a.a(iK2, iK));
                }
                bVar.K(w.f31222z).H(iK).f0(iK2).T(listQ);
            } else if (iIntValue == 3) {
                int i10 = 0;
                String str = (String) c("Subtype");
                if (str != null) {
                    if (str.equals("CAPT")) {
                        i10 = 64;
                    } else if (str.equals("DESC")) {
                        i10 = 1024;
                    }
                }
                bVar.K(w.f31181e0).c0(i10);
            } else {
                bVar.K(w.f31181e0);
            }
            this.f18364e = bVar.S(xmlPullParser.getAttributeValue(null, f18352g)).U((String) c("Name")).e0(strR).G(k(xmlPullParser, f18353h)).V((String) c("Language")).E();
        }
    }

    public static class d extends a {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final String f18365n = "SmoothStreamingMedia";

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String f18366o = "MajorVersion";

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final String f18367p = "MinorVersion";

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final String f18368q = "TimeScale";

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final String f18369r = "DVRWindowLength";

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final String f18370s = "Duration";

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final String f18371t = "LookaheadCount";

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final String f18372u = "IsLive";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<a.b> f18373e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f18374f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f18375g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f18376h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f18377i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f18378j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f18379k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f18380l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        @p0
        public a.C0192a f18381m;

        public d(a aVar, String str) {
            super(aVar, str, f18365n);
            this.f18379k = -1;
            this.f18381m = null;
            this.f18373e = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void a(Object obj) {
            if (obj instanceof a.b) {
                this.f18373e.add((a.b) obj);
            } else if (obj instanceof a.C0192a) {
                hd.a.i(this.f18381m == null);
                this.f18381m = (a.C0192a) obj;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            int size = this.f18373e.size();
            a.b[] bVarArr = new a.b[size];
            this.f18373e.toArray(bVarArr);
            if (this.f18381m != null) {
                a.C0192a c0192a = this.f18381m;
                DrmInitData drmInitData = new DrmInitData(new DrmInitData.SchemeData(c0192a.f18413a, w.f31182f, c0192a.f18414b));
                for (int i10 = 0; i10 < size; i10++) {
                    a.b bVar = bVarArr[i10];
                    int i11 = bVar.f18420a;
                    if (i11 == 2 || i11 == 1) {
                        Format[] formatArr = bVar.f18429j;
                        for (int i12 = 0; i12 < formatArr.length; i12++) {
                            formatArr[i12] = formatArr[i12].a().L(drmInitData).E();
                        }
                    }
                }
            }
            return new com.google.android.exoplayer2.source.smoothstreaming.manifest.a(this.f18374f, this.f18375g, this.f18376h, this.f18377i, this.f18378j, this.f18379k, this.f18380l, this.f18381m, bVarArr);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) throws ParserException {
            this.f18374f = k(xmlPullParser, f18366o);
            this.f18375g = k(xmlPullParser, f18367p);
            this.f18376h = j(xmlPullParser, "TimeScale", 10000000L);
            this.f18377i = l(xmlPullParser, f18370s);
            this.f18378j = j(xmlPullParser, f18369r, 0L);
            this.f18379k = i(xmlPullParser, f18371t, -1);
            this.f18380l = g(xmlPullParser, f18372u, false);
            p("TimeScale", Long.valueOf(this.f18376h));
        }
    }

    public static class e extends a {
        public static final String A = "Url";
        public static final String B = "MaxWidth";
        public static final String C = "MaxHeight";
        public static final String D = "DisplayWidth";
        public static final String E = "DisplayHeight";
        public static final String F = "Language";
        public static final String G = "TimeScale";
        public static final String H = "d";
        public static final String I = "t";
        public static final String J = "r";

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final String f18382s = "StreamIndex";

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final String f18383t = "c";

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final String f18384u = "Type";

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final String f18385v = "audio";

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final String f18386w = "video";

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final String f18387x = "text";

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final String f18388y = "Subtype";

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final String f18389z = "Name";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f18390e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<Format> f18391f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f18392g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f18393h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f18394i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f18395j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f18396k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f18397l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f18398m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f18399n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f18400o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f18401p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public ArrayList<Long> f18402q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public long f18403r;

        public e(a aVar, String str) {
            super(aVar, str, f18382s);
            this.f18390e = str;
            this.f18391f = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void a(Object obj) {
            if (obj instanceof Format) {
                this.f18391f.add((Format) obj);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public Object b() {
            Format[] formatArr = new Format[this.f18391f.size()];
            this.f18391f.toArray(formatArr);
            return new a.b(this.f18390e, this.f18396k, this.f18392g, this.f18393h, this.f18394i, this.f18395j, this.f18397l, this.f18398m, this.f18399n, this.f18400o, this.f18401p, formatArr, this.f18402q, this.f18403r);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public boolean d(String str) {
            return "c".equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.a
        public void n(XmlPullParser xmlPullParser) throws ParserException {
            if ("c".equals(xmlPullParser.getName())) {
                r(xmlPullParser);
            } else {
                q(xmlPullParser);
            }
        }

        public final void q(XmlPullParser xmlPullParser) throws ParserException {
            int iS = s(xmlPullParser);
            this.f18392g = iS;
            p("Type", Integer.valueOf(iS));
            if (this.f18392g == 3) {
                this.f18393h = m(xmlPullParser, "Subtype");
            } else {
                this.f18393h = xmlPullParser.getAttributeValue(null, "Subtype");
            }
            p("Subtype", this.f18393h);
            this.f18395j = xmlPullParser.getAttributeValue(null, "Name");
            this.f18396k = m(xmlPullParser, A);
            this.f18397l = i(xmlPullParser, "MaxWidth", -1);
            this.f18398m = i(xmlPullParser, "MaxHeight", -1);
            this.f18399n = i(xmlPullParser, D, -1);
            this.f18400o = i(xmlPullParser, E, -1);
            String attributeValue = xmlPullParser.getAttributeValue(null, "Language");
            this.f18401p = attributeValue;
            p("Language", attributeValue);
            long jI = i(xmlPullParser, "TimeScale", -1);
            this.f18394i = jI;
            if (jI == -1) {
                this.f18394i = ((Long) c("TimeScale")).longValue();
            }
            this.f18402q = new ArrayList<>();
        }

        public final void r(XmlPullParser xmlPullParser) throws ParserException {
            int size = this.f18402q.size();
            long j10 = j(xmlPullParser, "t", g.f56663b);
            int i10 = 1;
            if (j10 == g.f56663b) {
                if (size == 0) {
                    j10 = 0;
                } else {
                    if (this.f18403r == -1) {
                        throw new ParserException("Unable to infer start time");
                    }
                    j10 = this.f18402q.get(size - 1).longValue() + this.f18403r;
                }
            }
            this.f18402q.add(Long.valueOf(j10));
            this.f18403r = j(xmlPullParser, "d", g.f56663b);
            long j11 = j(xmlPullParser, J, 1L);
            if (j11 > 1 && this.f18403r == g.f56663b) {
                throw new ParserException("Repeated chunk with unspecified duration");
            }
            while (true) {
                long j12 = i10;
                if (j12 >= j11) {
                    return;
                }
                this.f18402q.add(Long.valueOf((this.f18403r * j12) + j10));
                i10++;
            }
        }

        public final int s(XmlPullParser xmlPullParser) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, "Type");
            if (attributeValue == null) {
                throw new MissingFieldException("Type");
            }
            if ("audio".equalsIgnoreCase(attributeValue)) {
                return 1;
            }
            if ("video".equalsIgnoreCase(attributeValue)) {
                return 2;
            }
            if ("text".equalsIgnoreCase(attributeValue)) {
                return 3;
            }
            throw new ParserException("Invalid key value[" + attributeValue + "]");
        }
    }

    public SsManifestParser() {
        try {
            this.f18339a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e10) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e10);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a a(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.f18339a.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, null);
            return (com.google.android.exoplayer2.source.smoothstreaming.manifest.a) new d(null, uri.toString()).f(xmlPullParserNewPullParser);
        } catch (XmlPullParserException e10) {
            throw new ParserException(e10);
        }
    }
}
