package z0;

import androidx.annotation.RestrictTo;
import g.i1;
import java.util.Locale;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f57642a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f57643b = 14;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f57644c = 5;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f57645d = 25;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f57646e = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f57648g = "\n\u000b\f\r\u0085\u2028\u2029";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f57649h = "\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f57650i = "\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f57651j = ",*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f57652k = "(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f57654m = ",\"'\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f57655n = "(?=[,\"'\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f57656o = ":,\"'\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f57657p = "(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0681a[] f57647f = {new C0681a(99, 99, -1, -1), new C0681a(35, 36, -1, -1), new C0681a(71, 72, -1, -1), new C0681a(96, 96, -1, -1), new C0681a(85, 86, -1, -1), new C0681a(90, 96, -1, -1), new C0681a(80, 81, -1, -1), new C0681a(6, 6, -1, -1), new C0681a(20, 20, -1, -1), new C0681a(19, 19, -1, -1), new C0681a(32, 34, -1, -1), new C0681a(96, 96, -1, -1), new C0681a(30, 31, -1, -1), new C0681a(96, 96, -1, -1), new C0681a(96, 96, -1, -1), new C0681a(50, 52, -1, -1), new C0681a(83, 83, -1, -1), new C0681a(60, 62, -1, -1), new C0681a(46, 47, -1, -1), new C0681a(66, 67, 73, -1), new C0681a(40, 42, -1, -1), new C0681a(70, 71, -1, -1), new C0681a(1, 2, -1, -1), new C0681a(20, 21, -1, -1), new C0681a(3, 4, -1, -1), new C0681a(96, 96, -1, -1), new C0681a(48, 49, -1, -1), new C0681a(55, 56, -1, -1), new C0681a(63, 65, -1, -1), new C0681a(96, 96, -1, -1), new C0681a(38, 39, -1, -1), new C0681a(55, 56, -1, -1), new C0681a(27, 28, -1, -1), new C0681a(58, 58, -1, -1), new C0681a(68, 69, -1, -1), new C0681a(3, 4, -1, -1), new C0681a(7, 8, -1, -1), new C0681a(87, 88, 86, -1), new C0681a(88, 89, 96, -1), new C0681a(10, 14, 0, 6), new C0681a(43, 45, -1, -1), new C0681a(73, 74, -1, -1), new C0681a(97, 97, -1, -1), new C0681a(15, 19, -1, -1), new C0681a(6, 6, 0, 9), new C0681a(96, 96, -1, -1), new C0681a(2, 2, -1, -1), new C0681a(29, 29, -1, -1), new C0681a(57, 57, -1, -1), new C0681a(37, 38, -1, -1), new C0681a(75, 79, 87, 88), new C0681a(84, 84, -1, -1), new C0681a(22, 24, 20, -1), new C0681a(6, 9, -1, -1), new C0681a(5, 5, -1, -1), new C0681a(98, 99, -1, -1), new C0681a(53, 54, -1, -1), new C0681a(24, 26, -1, -1), new C0681a(82, 83, -1, -1)};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Pattern f57653l = Pattern.compile("[^,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]+(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Pattern f57658q = Pattern.compile("(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?)(?:-(?:one|[0-9]+([a-z](?=[^a-z]|$)|st|nd|rd|th)?))*(?=[,\"'\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Pattern f57659r = Pattern.compile("(?:(ak|alaska)|(al|alabama)|(ar|arkansas)|(as|american[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+samoa)|(az|arizona)|(ca|california)|(co|colorado)|(ct|connecticut)|(dc|district[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+of[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+columbia)|(de|delaware)|(fl|florida)|(fm|federated[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+states[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+of[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+micronesia)|(ga|georgia)|(gu|guam)|(hi|hawaii)|(ia|iowa)|(id|idaho)|(il|illinois)|(in|indiana)|(ks|kansas)|(ky|kentucky)|(la|louisiana)|(ma|massachusetts)|(md|maryland)|(me|maine)|(mh|marshall[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+islands)|(mi|michigan)|(mn|minnesota)|(mo|missouri)|(mp|northern[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+mariana[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+islands)|(ms|mississippi)|(mt|montana)|(nc|north[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+carolina)|(nd|north[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+dakota)|(ne|nebraska)|(nh|new[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+hampshire)|(nj|new[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+jersey)|(nm|new[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+mexico)|(nv|nevada)|(ny|new[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+york)|(oh|ohio)|(ok|oklahoma)|(or|oregon)|(pa|pennsylvania)|(pr|puerto[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+rico)|(pw|palau)|(ri|rhode[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+island)|(sc|south[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+carolina)|(sd|south[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+dakota)|(tn|tennessee)|(tx|texas)|(ut|utah)|(va|virginia)|(vi|virgin[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+islands)|(vt|vermont)|(wa|washington)|(wi|wisconsin)|(wv|west[\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000]+virginia)|(wy|wyoming))(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Pattern f57660s = Pattern.compile("(?:alley|annex|arcade|ave[.]?|avenue|alameda|bayou|beach|bend|bluffs?|bottom|boulevard|branch|bridge|brooks?|burgs?|bypass|broadway|camino|camp|canyon|cape|causeway|centers?|circles?|cliffs?|club|common|corners?|course|courts?|coves?|creek|crescent|crest|crossing|crossroad|curve|circulo|dale|dam|divide|drives?|estates?|expressway|extensions?|falls?|ferry|fields?|flats?|fords?|forest|forges?|forks?|fort|freeway|gardens?|gateway|glens?|greens?|groves?|harbors?|haven|heights|highway|hills?|hollow|inlet|islands?|isle|junctions?|keys?|knolls?|lakes?|land|landing|lane|lights?|loaf|locks?|lodge|loop|mall|manors?|meadows?|mews|mills?|mission|motorway|mount|mountains?|neck|orchard|oval|overpass|parks?|parkways?|pass|passage|path|pike|pines?|plains?|plaza|points?|ports?|prairie|privada|radial|ramp|ranch|rapids?|rd[.]?|rest|ridges?|river|roads?|route|row|rue|run|shoals?|shores?|skyway|springs?|spurs?|squares?|station|stravenue|stream|st[.]?|streets?|summit|speedway|terrace|throughway|trace|track|trafficway|trail|tunnel|turnpike|underpass|unions?|valleys?|viaduct|views?|villages?|ville|vista|walks?|wall|ways?|wells?|xing|xrd)(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Pattern f57661t = Pattern.compile("([0-9]+)(st|nd|rd|th)", 2);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Pattern f57662u = Pattern.compile("(?:[0-9]{5}(?:-[0-9]{4})?)(?=[,*•\t  \u1680\u2000\u2001\u2002\u2003\u2004\u2005\u2006 \u2008\u2009\u200a \u205f\u3000\n\u000b\f\r\u0085\u2028\u2029]|$)", 2);

    /* JADX INFO: renamed from: z0.a$a, reason: collision with other inner class name */
    public static class C0681a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f57663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f57664b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f57665c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f57666d;

        public C0681a(int i10, int i11, int i12, int i13) {
            this.f57663a = i10;
            this.f57664b = i11;
            this.f57665c = i12;
            this.f57666d = i13;
        }

        public boolean a(String str) {
            int i10 = Integer.parseInt(str.substring(0, 2));
            return (this.f57663a <= i10 && i10 <= this.f57664b) || i10 == this.f57665c || i10 == this.f57666d;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d5, code lost:
    
        if (r10 <= 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d7, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d8, code lost:
    
        if (r9 <= 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00db, code lost:
    
        r9 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00dd, code lost:
    
        return -r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
    
        return -r13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(java.lang.String r13, java.util.regex.MatchResult r14) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.a.a(java.lang.String, java.util.regex.MatchResult):int");
    }

    public static boolean b(String str) {
        int i10 = 0;
        for (int i11 = 0; i11 < str.length(); i11++) {
            if (Character.isDigit(str.charAt(i11))) {
                i10++;
            }
        }
        if (i10 > 5) {
            return false;
        }
        Matcher matcher = f57661t.matcher(str);
        if (!matcher.find()) {
            return true;
        }
        int i12 = Integer.parseInt(matcher.group(1));
        if (i12 == 0) {
            return false;
        }
        String lowerCase = matcher.group(2).toLowerCase(Locale.getDefault());
        int i13 = i12 % 10;
        if (i13 == 1) {
            return lowerCase.equals(i12 % 100 != 11 ? "st" : "th");
        }
        if (i13 == 2) {
            return lowerCase.equals(i12 % 100 != 12 ? "nd" : "th");
        }
        if (i13 != 3) {
            return lowerCase.equals("th");
        }
        return lowerCase.equals(i12 % 100 != 13 ? "rd" : "th");
    }

    public static String c(String str) {
        Matcher matcher = f57658q.matcher(str);
        int iEnd = 0;
        while (matcher.find(iEnd)) {
            if (b(matcher.group(0))) {
                int iStart = matcher.start();
                int iA = a(str, matcher);
                if (iA > 0) {
                    return str.substring(iStart, iA);
                }
                iEnd = -iA;
            } else {
                iEnd = matcher.end();
            }
        }
        return null;
    }

    @i1
    public static boolean d(String str) {
        return f57660s.matcher(str).matches();
    }

    @i1
    public static boolean e(String str) {
        return f57662u.matcher(str).matches();
    }

    @i1
    public static boolean f(String str, String str2) {
        return g(str, i(str2, 0));
    }

    public static boolean g(String str, MatchResult matchResult) {
        if (matchResult == null) {
            return false;
        }
        int iGroupCount = matchResult.groupCount();
        while (true) {
            if (iGroupCount <= 0) {
                break;
            }
            int i10 = iGroupCount - 1;
            if (matchResult.group(iGroupCount) != null) {
                iGroupCount = i10;
                break;
            }
            iGroupCount = i10;
        }
        return f57662u.matcher(str).matches() && f57647f[iGroupCount].a(str);
    }

    @i1
    public static MatchResult h(String str, int i10) {
        if (i10 > 0 && f57656o.indexOf(str.charAt(i10 - 1)) == -1) {
            return null;
        }
        Matcher matcherRegion = f57658q.matcher(str).region(i10, str.length());
        if (matcherRegion.lookingAt()) {
            MatchResult matchResult = matcherRegion.toMatchResult();
            if (b(matchResult.group(0))) {
                return matchResult;
            }
        }
        return null;
    }

    @i1
    public static MatchResult i(String str, int i10) {
        if (i10 > 0 && f57651j.indexOf(str.charAt(i10 - 1)) == -1) {
            return null;
        }
        Matcher matcherRegion = f57659r.matcher(str).region(i10, str.length());
        if (matcherRegion.lookingAt()) {
            return matcherRegion.toMatchResult();
        }
        return null;
    }
}
