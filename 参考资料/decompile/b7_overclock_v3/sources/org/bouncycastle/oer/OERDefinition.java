package org.bouncycastle.oer;

import com.blankj.utilcode.util.i0;
import gm.h;
import gm.t;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class OERDefinition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BigInteger[] f45532a = {new BigInteger("256"), new BigInteger("65536"), new BigInteger("4294967296"), new BigInteger("18446744073709551616")};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BigInteger[][] f45533b = {new BigInteger[]{new BigInteger("-128"), new BigInteger("127")}, new BigInteger[]{new BigInteger("-32768"), new BigInteger("32767")}, new BigInteger[]{new BigInteger("-2147483648"), new BigInteger("2147483647")}, new BigInteger[]{new BigInteger("-9223372036854775808"), new BigInteger("9223372036854775807")}};

    public enum BaseType {
        SEQ,
        SEQ_OF,
        CHOICE,
        ENUM,
        INT,
        OCTET_STRING,
        UTF8_STRING,
        BIT_STRING,
        NULL,
        EXTENSION,
        ENUM_ITEM,
        BOOLEAN,
        IS0646String,
        PrintableString,
        NumericString,
        BMPString,
        UniversalString,
        IA5String,
        VisibleString
    }

    public static class OptionalList extends ArrayList<Object> {
        public OptionalList(List<Object> list) {
            addAll(list);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BaseType f45534a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<a> f45535b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f45536c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f45537d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public BigInteger f45538e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public BigInteger f45539f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public BigInteger f45540g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public h f45541h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public a f45542i;

        public a(BaseType baseType) {
            this.f45534a = baseType;
        }

        public b a() {
            ArrayList arrayList = new ArrayList();
            boolean z10 = false;
            if (this.f45534a == BaseType.ENUM) {
                HashSet hashSet = new HashSet();
                int i10 = 0;
                for (int i11 = 0; i11 < this.f45535b.size(); i11++) {
                    a aVar = this.f45535b.get(i11);
                    if (aVar.f45540g == null) {
                        aVar.f45540g = BigInteger.valueOf(i10);
                        i10++;
                    }
                    if (hashSet.contains(aVar.f45540g)) {
                        throw new IllegalStateException("duplicate enum value at index " + i11);
                    }
                    hashSet.add(aVar.f45540g);
                }
            }
            boolean z11 = false;
            for (a aVar2 : this.f45535b) {
                if (!z11 && aVar2.f45534a == BaseType.EXTENSION) {
                    if (!aVar2.f45535b.isEmpty() || this.f45534a == BaseType.CHOICE) {
                        z11 = true;
                    } else {
                        z11 = true;
                    }
                }
                arrayList.add(aVar2.a());
            }
            BaseType baseType = this.f45534a;
            h hVar = this.f45541h;
            if (hVar == null && this.f45536c) {
                z10 = true;
            }
            return new b(baseType, arrayList, z10, this.f45537d, this.f45539f, this.f45538e, z11, this.f45540g, hVar);
        }

        public a b() {
            a aVar = new a(this.f45534a);
            Iterator<a> it2 = this.f45535b.iterator();
            while (it2.hasNext()) {
                aVar.f45535b.add(it2.next().b());
            }
            aVar.f45536c = this.f45536c;
            aVar.f45537d = this.f45537d;
            aVar.f45538e = this.f45538e;
            aVar.f45539f = this.f45539f;
            aVar.f45541h = this.f45541h;
            aVar.f45540g = this.f45540g;
            return aVar;
        }

        public a c(h hVar) {
            a aVarB = b();
            aVarB.f45541h = hVar;
            return aVarB;
        }

        public a d(BigInteger bigInteger) {
            a aVarB = b();
            this.f45540g = bigInteger;
            return aVarB;
        }

        public a e(boolean z10) {
            a aVarB = b();
            aVarB.f45536c = z10;
            return aVarB;
        }

        public a f(long j10) {
            a aVarB = b();
            aVarB.f45538e = BigInteger.valueOf(j10);
            aVarB.f45539f = BigInteger.valueOf(j10);
            return aVarB;
        }

        public a g(Object... objArr) {
            a aVarB = b();
            for (int i10 = 0; i10 != objArr.length; i10++) {
                Object obj = objArr[i10];
                if (obj instanceof OptionalList) {
                    Iterator it2 = ((List) obj).iterator();
                    while (it2.hasNext()) {
                        aVarB.f45535b.add(o(false, it2.next()));
                    }
                } else if (obj.getClass().isArray()) {
                    g((Object[]) obj);
                } else {
                    aVarB.f45535b.add(o(true, obj));
                }
            }
            return aVarB;
        }

        public a h(String str) {
            a aVarB = b();
            if (str != null) {
                aVarB.f45537d = str;
            }
            aVarB.f45536c = this.f45536c;
            return aVarB;
        }

        public a i(String str) {
            a aVarB = b();
            aVarB.f45537d = str + i0.f11861z + this.f45537d;
            return aVarB;
        }

        public a j(long j10, long j11, h hVar) {
            a aVarB = b();
            aVarB.f45539f = BigInteger.valueOf(j10);
            aVarB.f45538e = BigInteger.valueOf(j11);
            aVarB.f45541h = hVar;
            return aVarB;
        }

        public a k(BigInteger bigInteger, BigInteger bigInteger2) {
            a aVarB = b();
            aVarB.f45539f = bigInteger;
            aVarB.f45538e = bigInteger2;
            return aVarB;
        }

        public a l(long j10) {
            a aVarB = b();
            aVarB.f45539f = BigInteger.valueOf(j10);
            aVarB.f45538e = null;
            return aVarB;
        }

        public a m(long j10) {
            a aVarB = b();
            aVarB.f45538e = BigInteger.valueOf(j10);
            aVarB.f45539f = BigInteger.ZERO;
            return aVarB;
        }

        public a n() {
            a aVarB = b();
            aVarB.f45539f = null;
            aVarB.f45538e = null;
            return aVarB;
        }

        public final a o(boolean z10, Object obj) {
            if (obj instanceof a) {
                return ((a) obj).e(z10);
            }
            if (obj instanceof BaseType) {
                return new a((BaseType) obj).e(z10);
            }
            throw new IllegalStateException("Unable to wrap item in builder");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BaseType f45543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<b> f45544b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f45545c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f45546d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List<b> f45547e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final BigInteger f45548f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final BigInteger f45549g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f45550h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final BigInteger f45551i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final h f45552j;

        public b(BaseType baseType, List<b> list, boolean z10, String str, BigInteger bigInteger, BigInteger bigInteger2, boolean z11, BigInteger bigInteger3, h hVar) {
            this.f45543a = baseType;
            this.f45544b = list;
            this.f45545c = z10;
            this.f45546d = str;
            this.f45548f = bigInteger;
            this.f45549g = bigInteger2;
            this.f45550h = z11;
            this.f45551i = bigInteger3;
            this.f45552j = hVar;
        }

        public String a(String str) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[");
            String str2 = this.f45546d;
            if (str2 == null) {
                str2 = "";
            }
            sb2.append(str2);
            sb2.append(this.f45545c ? " (E)" : "");
            sb2.append("] ");
            sb2.append(str);
            return sb2.toString();
        }

        public boolean b() {
            BigInteger bigInteger = this.f45548f;
            return bigInteger != null && BigInteger.ZERO.compareTo(bigInteger) > 0;
        }

        public h c() {
            return this.f45552j;
        }

        public b d() {
            return this.f45544b.get(0);
        }

        public boolean e() {
            Iterator<b> it2 = this.f45544b.iterator();
            while (it2.hasNext()) {
                if (it2.next().f45552j != null) {
                    return true;
                }
            }
            return false;
        }

        public boolean f() {
            Iterator<b> it2 = this.f45544b.iterator();
            while (it2.hasNext()) {
                if (it2.next().f45543a == BaseType.EXTENSION) {
                    return true;
                }
            }
            return false;
        }

        public int g() {
            BigInteger bigInteger = this.f45548f;
            if (bigInteger != null && this.f45549g != null) {
                int i10 = 1;
                if (BigInteger.ZERO.equals(bigInteger)) {
                    int i11 = 0;
                    while (i11 < OERDefinition.f45532a.length) {
                        if (this.f45549g.compareTo(OERDefinition.f45532a[i11]) < 0) {
                            return i10;
                        }
                        i11++;
                        i10 *= 2;
                    }
                } else {
                    int i12 = 0;
                    int i13 = 1;
                    while (i12 < OERDefinition.f45533b.length) {
                        if (this.f45548f.compareTo(OERDefinition.f45533b[i12][0]) >= 0 && this.f45549g.compareTo(OERDefinition.f45533b[i12][1]) < 0) {
                            return -i13;
                        }
                        i12++;
                        i13 *= 2;
                    }
                }
            }
            return 0;
        }

        public boolean h() {
            BigInteger bigInteger = this.f45548f;
            return bigInteger != null && bigInteger.equals(this.f45549g);
        }

        public boolean i() {
            return BigInteger.ZERO.equals(this.f45548f);
        }

        public boolean j() {
            return this.f45549g == null && this.f45548f == null;
        }

        public boolean k() {
            BigInteger bigInteger;
            return i() && (bigInteger = this.f45549g) != null && BigInteger.ZERO.compareTo(bigInteger) < 0;
        }

        public List<b> l() {
            List<b> list;
            synchronized (this) {
                if (this.f45547e == null) {
                    ArrayList arrayList = new ArrayList();
                    for (b bVar : this.f45544b) {
                        if (!bVar.f45545c || bVar.c() != null) {
                            arrayList.add(bVar);
                        }
                    }
                    this.f45547e = Collections.unmodifiableList(arrayList);
                }
                list = this.f45547e;
            }
            return list;
        }

        public String m() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ee.a.f26978c);
            BigInteger bigInteger = this.f45548f;
            sb2.append(bigInteger != null ? bigInteger.toString() : "MIN");
            sb2.append(" ... ");
            BigInteger bigInteger2 = this.f45549g;
            sb2.append(bigInteger2 != null ? bigInteger2.toString() : "MAX");
            sb2.append(ee.a.f26979d);
            return sb2.toString();
        }
    }

    public static class c extends a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f45553j;

        public c(BaseType baseType) {
            super(baseType);
            this.f45553j = false;
        }

        public void p(a... aVarArr) {
            if (this.f45553j) {
                throw new IllegalStateException("build cannot be modified and must be copied only");
            }
            for (int i10 = 0; i10 != aVarArr.length; i10++) {
                this.f45535b.add(aVarArr[i10]);
            }
            this.f45553j = true;
        }
    }

    public static a c(long j10) {
        return new a(BaseType.BIT_STRING).f(j10);
    }

    public static a d(Object... objArr) {
        return new a(BaseType.CHOICE).g(objArr);
    }

    public static a e(String str) {
        return new a(BaseType.ENUM_ITEM).h(str);
    }

    public static a f(String str, BigInteger bigInteger) {
        return new a(BaseType.ENUM_ITEM).d(bigInteger).h(str);
    }

    public static a g(Object... objArr) {
        return new a(BaseType.ENUM).g(objArr);
    }

    public static a h() {
        return new a(BaseType.EXTENSION).h("extension");
    }

    public static a i() {
        return new a(BaseType.INT);
    }

    public static a j(long j10) {
        return new a(BaseType.INT).c(new t(j10));
    }

    public static a k(long j10, long j11) {
        return new a(BaseType.INT).k(BigInteger.valueOf(j10), BigInteger.valueOf(j11));
    }

    public static a l(long j10, long j11, h hVar) {
        return new a(BaseType.INT).j(j10, j11, hVar);
    }

    public static a m(BigInteger bigInteger, BigInteger bigInteger2) {
        return new a(BaseType.INT).k(bigInteger, bigInteger2);
    }

    public static a n() {
        return new a(BaseType.NULL);
    }

    public static a o() {
        return new a(BaseType.OCTET_STRING).n();
    }

    public static a p(int i10) {
        return new a(BaseType.OCTET_STRING).f(i10);
    }

    public static a q(int i10, int i11) {
        return new a(BaseType.OCTET_STRING).k(BigInteger.valueOf(i10), BigInteger.valueOf(i11));
    }

    public static a r() {
        return new a(BaseType.OCTET_STRING).n();
    }

    public static List<Object> s(Object... objArr) {
        return new OptionalList(Arrays.asList(objArr));
    }

    public static a t() {
        return new a(null);
    }

    public static a u() {
        return new a(BaseType.SEQ);
    }

    public static a v(Object... objArr) {
        return new a(BaseType.SEQ).g(objArr);
    }

    public static a w(Object... objArr) {
        return new a(BaseType.SEQ_OF).g(objArr);
    }

    public static a x() {
        return new a(BaseType.UTF8_STRING);
    }

    public static a y(int i10) {
        return new a(BaseType.UTF8_STRING).l(i10);
    }

    public static a z(int i10, int i11) {
        return new a(BaseType.UTF8_STRING).k(BigInteger.valueOf(i10), BigInteger.valueOf(i11));
    }
}
