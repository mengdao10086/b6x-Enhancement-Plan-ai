package androidx.core.os;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import g.f0;
import g.i1;
import g.n0;
import g.p0;
import g.v0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Locale[] f4664c = new Locale[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Locale f4665d = new Locale(SocializeProtocolConstants.PROTOCOL_KEY_EN, "XA");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Locale f4666e = new Locale("ar", "XB");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Locale f4667f = l.b("en-Latn");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Locale[] f4668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final String f4669b;

    @v0(21)
    public static class a {
        @g.u
        public static String a(Locale locale) {
            return locale.getScript();
        }
    }

    public m(@n0 Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f4668a = f4664c;
            this.f4669b = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < localeArr.length; i10++) {
            Locale locale = localeArr[i10];
            if (locale == null) {
                throw new NullPointerException("list[" + i10 + "] is null");
            }
            if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                arrayList.add(locale2);
                k(sb2, locale2);
                if (i10 < localeArr.length - 1) {
                    sb2.append(',');
                }
                hashSet.add(locale2);
            }
        }
        this.f4668a = (Locale[]) arrayList.toArray(new Locale[0]);
        this.f4669b = sb2.toString();
    }

    public static String h(Locale locale) {
        String strA = a.a(locale);
        return !strA.isEmpty() ? strA : "";
    }

    public static boolean i(Locale locale) {
        return f4665d.equals(locale) || f4666e.equals(locale);
    }

    @f0(from = 0, to = 1)
    public static int j(Locale locale, Locale locale2) {
        if (locale.equals(locale2)) {
            return 1;
        }
        if (!locale.getLanguage().equals(locale2.getLanguage()) || i(locale) || i(locale2)) {
            return 0;
        }
        String strH = h(locale);
        if (!strH.isEmpty()) {
            return strH.equals(h(locale2)) ? 1 : 0;
        }
        String country = locale.getCountry();
        return (country.isEmpty() || country.equals(locale2.getCountry())) ? 1 : 0;
    }

    @i1
    public static void k(StringBuilder sb2, Locale locale) {
        sb2.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country == null || country.isEmpty()) {
            return;
        }
        sb2.append('-');
        sb2.append(locale.getCountry());
    }

    @Override // androidx.core.os.n
    public int a(Locale locale) {
        int i10 = 0;
        while (true) {
            Locale[] localeArr = this.f4668a;
            if (i10 >= localeArr.length) {
                return -1;
            }
            if (localeArr[i10].equals(locale)) {
                return i10;
            }
            i10++;
        }
    }

    @Override // androidx.core.os.n
    public String b() {
        return this.f4669b;
    }

    @Override // androidx.core.os.n
    @p0
    public Object c() {
        return null;
    }

    @Override // androidx.core.os.n
    public Locale d(@n0 String[] strArr) {
        return e(Arrays.asList(strArr), false);
    }

    public final Locale e(Collection<String> collection, boolean z10) {
        int iF = f(collection, z10);
        if (iF == -1) {
            return null;
        }
        return this.f4668a[iF];
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        Locale[] localeArr = ((m) obj).f4668a;
        if (this.f4668a.length != localeArr.length) {
            return false;
        }
        int i10 = 0;
        while (true) {
            Locale[] localeArr2 = this.f4668a;
            if (i10 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i10].equals(localeArr[i10])) {
                return false;
            }
            i10++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(java.util.Collection<java.lang.String> r5, boolean r6) {
        /*
            r4 = this;
            java.util.Locale[] r0 = r4.f4668a
            int r1 = r0.length
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L8
            return r2
        L8:
            int r0 = r0.length
            if (r0 != 0) goto Ld
            r5 = -1
            return r5
        Ld:
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r6 == 0) goto L1e
            java.util.Locale r6 = androidx.core.os.m.f4667f
            int r6 = r4.g(r6)
            if (r6 != 0) goto L1b
            return r2
        L1b:
            if (r6 >= r0) goto L1e
            goto L21
        L1e:
            r6 = 2147483647(0x7fffffff, float:NaN)
        L21:
            java.util.Iterator r5 = r5.iterator()
        L25:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L40
            java.lang.Object r1 = r5.next()
            java.lang.String r1 = (java.lang.String) r1
            java.util.Locale r1 = androidx.core.os.l.b(r1)
            int r1 = r4.g(r1)
            if (r1 != 0) goto L3c
            return r2
        L3c:
            if (r1 >= r6) goto L25
            r6 = r1
            goto L25
        L40:
            if (r6 != r0) goto L43
            return r2
        L43:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.os.m.f(java.util.Collection, boolean):int");
    }

    public final int g(Locale locale) {
        int i10 = 0;
        while (true) {
            Locale[] localeArr = this.f4668a;
            if (i10 >= localeArr.length) {
                return Integer.MAX_VALUE;
            }
            if (j(locale, localeArr[i10]) > 0) {
                return i10;
            }
            i10++;
        }
    }

    @Override // androidx.core.os.n
    public Locale get(int i10) {
        if (i10 >= 0) {
            Locale[] localeArr = this.f4668a;
            if (i10 < localeArr.length) {
                return localeArr[i10];
            }
        }
        return null;
    }

    public int hashCode() {
        int iHashCode = 1;
        for (Locale locale : this.f4668a) {
            iHashCode = (iHashCode * 31) + locale.hashCode();
        }
        return iHashCode;
    }

    @Override // androidx.core.os.n
    public boolean isEmpty() {
        return this.f4668a.length == 0;
    }

    @Override // androidx.core.os.n
    public int size() {
        return this.f4668a.length;
    }

    @n0
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        int i10 = 0;
        while (true) {
            Locale[] localeArr = this.f4668a;
            if (i10 >= localeArr.length) {
                sb2.append("]");
                return sb2.toString();
            }
            sb2.append(localeArr[i10]);
            if (i10 < this.f4668a.length - 1) {
                sb2.append(',');
            }
            i10++;
        }
    }
}
