package lb;

import com.google.android.exoplayer2.ParserException;
import com.google.common.collect.ImmutableList;
import g.p0;
import hd.t;
import hd.v0;
import hd.w;
import java.io.IOException;
import java.io.StringReader;
import lb.b;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import ya.g;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f39557a = "MotionPhotoXmpParser";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f39558b = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f39559c = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f39560d = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    @p0
    public static b a(String str) throws IOException {
        try {
            return b(str);
        } catch (ParserException | NumberFormatException | XmlPullParserException unused) {
            t.n(f39557a, "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    @p0
    public static b b(String str) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(new StringReader(str));
        xmlPullParserNewPullParser.next();
        if (!v0.f(xmlPullParserNewPullParser, "x:xmpmeta")) {
            throw new ParserException("Couldn't find xmp metadata");
        }
        long jE = g.f56663b;
        ImmutableList<b.a> immutableListOf = ImmutableList.of();
        do {
            xmlPullParserNewPullParser.next();
            if (v0.f(xmlPullParserNewPullParser, "rdf:Description")) {
                if (!d(xmlPullParserNewPullParser)) {
                    return null;
                }
                jE = e(xmlPullParserNewPullParser);
                immutableListOf = c(xmlPullParserNewPullParser);
            } else if (v0.f(xmlPullParserNewPullParser, "Container:Directory")) {
                immutableListOf = f(xmlPullParserNewPullParser, "Container", "Item");
            } else if (v0.f(xmlPullParserNewPullParser, "GContainer:Directory")) {
                immutableListOf = f(xmlPullParserNewPullParser, "GContainer", "GContainerItem");
            }
        } while (!v0.d(xmlPullParserNewPullParser, "x:xmpmeta"));
        if (immutableListOf.isEmpty()) {
            return null;
        }
        return new b(jE, immutableListOf);
    }

    public static ImmutableList<b.a> c(XmlPullParser xmlPullParser) {
        for (String str : f39560d) {
            String strA = v0.a(xmlPullParser, str);
            if (strA != null) {
                return ImmutableList.of(new b.a(w.C0, "Primary", 0L, 0L), new b.a(w.f31182f, "MotionPhoto", Long.parseLong(strA), 0L));
            }
        }
        return ImmutableList.of();
    }

    public static boolean d(XmlPullParser xmlPullParser) {
        for (String str : f39558b) {
            String strA = v0.a(xmlPullParser, str);
            if (strA != null) {
                return Integer.parseInt(strA) == 1;
            }
        }
        return false;
    }

    public static long e(XmlPullParser xmlPullParser) {
        for (String str : f39559c) {
            String strA = v0.a(xmlPullParser, str);
            if (strA != null) {
                long j10 = Long.parseLong(strA);
                return j10 == -1 ? g.f56663b : j10;
            }
        }
        return g.f56663b;
    }

    public static ImmutableList<b.a> f(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        ImmutableList.Builder builder = ImmutableList.builder();
        String str3 = str + ":Item";
        String str4 = str + ":Directory";
        do {
            xmlPullParser.next();
            if (v0.f(xmlPullParser, str3)) {
                String strA = v0.a(xmlPullParser, str2 + ":Mime");
                String strA2 = v0.a(xmlPullParser, str2 + ":Semantic");
                String strA3 = v0.a(xmlPullParser, str2 + ":Length");
                String strA4 = v0.a(xmlPullParser, str2 + ":Padding");
                if (strA == null || strA2 == null) {
                    return ImmutableList.of();
                }
                builder.add(new b.a(strA, strA2, strA3 != null ? Long.parseLong(strA3) : 0L, strA4 != null ? Long.parseLong(strA4) : 0L));
            }
        } while (!v0.d(xmlPullParser, str4));
        return builder.build();
    }
}
