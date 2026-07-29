package vc;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import com.google.common.primitives.Ints;
import g.l;
import g.p0;
import hd.t;
import hd.u0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f52938g = "SsaStyle";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f52939h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f52940i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f52941j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f52942k = 3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f52943l = 4;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f52944m = 5;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f52945n = 6;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f52946o = 7;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f52947p = 8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f52948q = 9;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f52949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f52950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    @p0
    public final Integer f52951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f52952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f52953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f52954f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f52955a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f52956b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f52957c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f52958d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f52959e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f52960f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f52961g;

        public a(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
            this.f52955a = i10;
            this.f52956b = i11;
            this.f52957c = i12;
            this.f52958d = i13;
            this.f52959e = i14;
            this.f52960f = i15;
            this.f52961g = i16;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:7:0x002b  */
        @g.p0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static vc.c.a a(java.lang.String r11) {
            /*
                r0 = 7
                java.lang.String r11 = r11.substring(r0)
                java.lang.String r0 = ","
                java.lang.String[] r11 = android.text.TextUtils.split(r11, r0)
                r0 = 0
                r1 = -1
                r2 = 0
                r4 = -1
                r5 = -1
                r6 = -1
                r7 = -1
                r8 = -1
                r9 = -1
            L14:
                int r3 = r11.length
                if (r2 >= r3) goto L80
                r3 = r11[r2]
                java.lang.String r3 = r3.trim()
                java.lang.String r3 = hd.u0.w1(r3)
                r3.hashCode()
                int r10 = r3.hashCode()
                switch(r10) {
                    case -1178781136: goto L64;
                    case -70925746: goto L59;
                    case 3029637: goto L4e;
                    case 3373707: goto L43;
                    case 366554320: goto L38;
                    case 1767875043: goto L2d;
                    default: goto L2b;
                }
            L2b:
                r3 = -1
                goto L6e
            L2d:
                java.lang.String r10 = "alignment"
                boolean r3 = r3.equals(r10)
                if (r3 != 0) goto L36
                goto L2b
            L36:
                r3 = 5
                goto L6e
            L38:
                java.lang.String r10 = "fontsize"
                boolean r3 = r3.equals(r10)
                if (r3 != 0) goto L41
                goto L2b
            L41:
                r3 = 4
                goto L6e
            L43:
                java.lang.String r10 = "name"
                boolean r3 = r3.equals(r10)
                if (r3 != 0) goto L4c
                goto L2b
            L4c:
                r3 = 3
                goto L6e
            L4e:
                java.lang.String r10 = "bold"
                boolean r3 = r3.equals(r10)
                if (r3 != 0) goto L57
                goto L2b
            L57:
                r3 = 2
                goto L6e
            L59:
                java.lang.String r10 = "primarycolour"
                boolean r3 = r3.equals(r10)
                if (r3 != 0) goto L62
                goto L2b
            L62:
                r3 = 1
                goto L6e
            L64:
                java.lang.String r10 = "italic"
                boolean r3 = r3.equals(r10)
                if (r3 != 0) goto L6d
                goto L2b
            L6d:
                r3 = 0
            L6e:
                switch(r3) {
                    case 0: goto L7c;
                    case 1: goto L7a;
                    case 2: goto L78;
                    case 3: goto L76;
                    case 4: goto L74;
                    case 5: goto L72;
                    default: goto L71;
                }
            L71:
                goto L7d
            L72:
                r5 = r2
                goto L7d
            L74:
                r7 = r2
                goto L7d
            L76:
                r4 = r2
                goto L7d
            L78:
                r8 = r2
                goto L7d
            L7a:
                r6 = r2
                goto L7d
            L7c:
                r9 = r2
            L7d:
                int r2 = r2 + 1
                goto L14
            L80:
                if (r4 == r1) goto L8a
                vc.c$a r0 = new vc.c$a
                int r10 = r11.length
                r3 = r0
                r3.<init>(r4, r5, r6, r7, r8, r9, r10)
                goto L8b
            L8a:
                r0 = 0
            L8b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: vc.c.a.a(java.lang.String):vc.c$a");
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f52962c = "SsaStyle.Overrides";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Pattern f52963d = Pattern.compile("\\{([^}]*)\\}");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f52964e = "\\s*\\d+(?:\\.\\d+)?\\s*";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Pattern f52965f = Pattern.compile(u0.I("\\\\pos\\((%1$s),(%1$s)\\)", f52964e));

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Pattern f52966g = Pattern.compile(u0.I("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", f52964e));

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final Pattern f52967h = Pattern.compile("\\\\an(\\d+)");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f52968a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public final PointF f52969b;

        public b(int i10, @p0 PointF pointF) {
            this.f52968a = i10;
            this.f52969b = pointF;
        }

        public static int a(String str) {
            Matcher matcher = f52967h.matcher(str);
            if (matcher.find()) {
                return c.d((String) hd.a.g(matcher.group(1)));
            }
            return -1;
        }

        public static b b(String str) {
            Matcher matcher = f52963d.matcher(str);
            PointF pointF = null;
            int i10 = -1;
            while (matcher.find()) {
                String str2 = (String) hd.a.g(matcher.group(1));
                try {
                    PointF pointFC = c(str2);
                    if (pointFC != null) {
                        pointF = pointFC;
                    }
                } catch (RuntimeException unused) {
                }
                try {
                    int iA = a(str2);
                    if (iA != -1) {
                        i10 = iA;
                    }
                } catch (RuntimeException unused2) {
                }
            }
            return new b(i10, pointF);
        }

        @p0
        public static PointF c(String str) {
            String strGroup;
            String strGroup2;
            Matcher matcher = f52965f.matcher(str);
            Matcher matcher2 = f52966g.matcher(str);
            boolean zFind = matcher.find();
            boolean zFind2 = matcher2.find();
            if (zFind) {
                if (zFind2) {
                    t.i(f52962c, "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
                }
                strGroup = matcher.group(1);
                strGroup2 = matcher.group(2);
            } else {
                if (!zFind2) {
                    return null;
                }
                strGroup = matcher2.group(1);
                strGroup2 = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(((String) hd.a.g(strGroup)).trim()), Float.parseFloat(((String) hd.a.g(strGroup2)).trim()));
        }

        public static String d(String str) {
            return f52963d.matcher(str).replaceAll("");
        }
    }

    /* JADX INFO: renamed from: vc.c$c, reason: collision with other inner class name */
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterfaceC0617c {
    }

    public c(String str, int i10, @l @p0 Integer num, float f10, boolean z10, boolean z11) {
        this.f52949a = str;
        this.f52950b = i10;
        this.f52951c = num;
        this.f52952d = f10;
        this.f52953e = z10;
        this.f52954f = z11;
    }

    @p0
    public static c b(String str, a aVar) {
        hd.a.a(str.startsWith(vc.a.f52925w));
        String[] strArrSplit = TextUtils.split(str.substring(6), ag.c.f654g);
        int length = strArrSplit.length;
        int i10 = aVar.f52961g;
        if (length != i10) {
            t.n(f52938g, u0.I("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i10), Integer.valueOf(strArrSplit.length), str));
            return null;
        }
        try {
            String strTrim = strArrSplit[aVar.f52955a].trim();
            int i11 = aVar.f52956b;
            int iD = i11 != -1 ? d(strArrSplit[i11].trim()) : -1;
            int i12 = aVar.f52957c;
            Integer numF = i12 != -1 ? f(strArrSplit[i12].trim()) : null;
            int i13 = aVar.f52958d;
            float fG = i13 != -1 ? g(strArrSplit[i13].trim()) : -3.4028235E38f;
            int i14 = aVar.f52959e;
            boolean zE = i14 != -1 ? e(strArrSplit[i14].trim()) : false;
            int i15 = aVar.f52960f;
            return new c(strTrim, iD, numF, fG, zE, i15 != -1 ? e(strArrSplit[i15].trim()) : false);
        } catch (RuntimeException e10) {
            t.o(f52938g, "Skipping malformed 'Style:' line: '" + str + "'", e10);
            return null;
        }
    }

    public static boolean c(int i10) {
        switch (i10) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    public static int d(String str) {
        try {
            int i10 = Integer.parseInt(str.trim());
            if (c(i10)) {
                return i10;
            }
        } catch (NumberFormatException unused) {
        }
        t.n(f52938g, "Ignoring unknown alignment: " + str);
        return -1;
    }

    public static boolean e(String str) {
        try {
            int i10 = Integer.parseInt(str);
            return i10 == 1 || i10 == -1;
        } catch (NumberFormatException e10) {
            t.o(f52938g, "Failed to parse bold/italic: '" + str + "'", e10);
            return false;
        }
    }

    @l
    @p0
    public static Integer f(String str) {
        try {
            long j10 = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            hd.a.a(j10 <= 4294967295L);
            return Integer.valueOf(Color.argb(Ints.checkedCast(((j10 >> 24) & 255) ^ 255), Ints.checkedCast(j10 & 255), Ints.checkedCast((j10 >> 8) & 255), Ints.checkedCast((j10 >> 16) & 255)));
        } catch (IllegalArgumentException e10) {
            t.o(f52938g, "Failed to parse color expression: '" + str + "'", e10);
            return null;
        }
    }

    public static float g(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e10) {
            t.o(f52938g, "Failed to parse font size: '" + str + "'", e10);
            return -3.4028235E38f;
        }
    }
}
