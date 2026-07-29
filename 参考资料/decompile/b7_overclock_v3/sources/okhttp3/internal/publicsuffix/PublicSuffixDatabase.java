package okhttp3.internal.publicsuffix;

import androidx.transition.q;
import j3.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.s;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.z1;
import okio.x;
import rl.f;
import yt.k;
import yt.l;
import zl.h;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\u00058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000f\u0010\u0017¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "", "domain", "c", "", "publicSuffixListBytes", "publicSuffixExceptionListBytes", "Lkotlin/z1;", "f", "", "g", "domainLabels", "b", "e", "d", "Ljava/util/concurrent/atomic/AtomicBoolean;", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "listRead", "Ljava/util/concurrent/CountDownLatch;", "Ljava/util/concurrent/CountDownLatch;", "readCompleteLatch", "[B", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class PublicSuffixDatabase {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public static final String f43870f = "publicsuffixes.gz";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final char f43873i = '!';

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final AtomicBoolean f43875a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final CountDownLatch f43876b = new CountDownLatch(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f43877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f43878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public static final a f43869e = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public static final byte[] f43871g = {42};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    public static final List<String> f43872h = s.k("*");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @k
    public static final PublicSuffixDatabase f43874j = new PublicSuffixDatabase();

    @d0(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0006\u0010\u0003\u001a\u00020\u0002J+\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$a;", "", "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "c", "", "", "labels", "", "labelIndex", "", "b", "([B[[BI)Ljava/lang/String;", "", "EXCEPTION_MARKER", "C", "", "PREVAILING_RULE", "Ljava/util/List;", "PUBLIC_SUFFIX_RESOURCE", "Ljava/lang/String;", "WILDCARD_LABEL", "[B", q.F7, "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        public final String b(byte[] bArr, byte[][] bArr2, int i10) {
            int i11;
            boolean z10;
            int iD;
            int iD2;
            int length = bArr.length;
            int i12 = 0;
            while (i12 < length) {
                int i13 = (i12 + length) / 2;
                while (i13 > -1 && bArr[i13] != 10) {
                    i13--;
                }
                int i14 = i13 + 1;
                int i15 = 1;
                while (true) {
                    i11 = i14 + i15;
                    if (bArr[i11] == 10) {
                        break;
                    }
                    i15++;
                }
                int i16 = i11 - i14;
                int i17 = i10;
                boolean z11 = false;
                int i18 = 0;
                int i19 = 0;
                while (true) {
                    if (z11) {
                        iD = 46;
                        z10 = false;
                    } else {
                        z10 = z11;
                        iD = f.d(bArr2[i17][i18], 255);
                    }
                    iD2 = iD - f.d(bArr[i14 + i19], 255);
                    if (iD2 != 0) {
                        break;
                    }
                    i19++;
                    i18++;
                    if (i19 == i16) {
                        break;
                    }
                    if (bArr2[i17].length != i18) {
                        z11 = z10;
                    } else {
                        if (i17 == bArr2.length - 1) {
                            break;
                        }
                        i17++;
                        z11 = true;
                        i18 = -1;
                    }
                }
                if (iD2 >= 0) {
                    if (iD2 <= 0) {
                        int i20 = i16 - i19;
                        int length2 = bArr2[i17].length - i18;
                        int length3 = bArr2.length;
                        for (int i21 = i17 + 1; i21 < length3; i21++) {
                            length2 += bArr2[i21].length;
                        }
                        if (length2 >= i20) {
                            if (length2 <= i20) {
                                Charset UTF_8 = StandardCharsets.UTF_8;
                                f0.o(UTF_8, "UTF_8");
                                return new String(bArr, i14, i16, UTF_8);
                            }
                        }
                    }
                    i12 = i11 + 1;
                }
                length = i14 - 1;
            }
            return null;
        }

        @k
        public final PublicSuffixDatabase c() {
            return PublicSuffixDatabase.f43874j;
        }
    }

    public final List<String> b(List<String> list) {
        String str;
        String str2;
        String strB;
        if (this.f43875a.get() || !this.f43875a.compareAndSet(false, true)) {
            try {
                this.f43876b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            e();
        }
        if (!(this.f43877c != null)) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
        }
        int size = list.size();
        byte[][] bArr = new byte[size][];
        for (int i10 = 0; i10 < size; i10++) {
            String str3 = list.get(i10);
            Charset UTF_8 = StandardCharsets.UTF_8;
            f0.o(UTF_8, "UTF_8");
            byte[] bytes = str3.getBytes(UTF_8);
            f0.o(bytes, "this as java.lang.String).getBytes(charset)");
            bArr[i10] = bytes;
        }
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                str = null;
                break;
            }
            int i12 = i11 + 1;
            a aVar = f43869e;
            byte[] bArr2 = this.f43877c;
            if (bArr2 == null) {
                f0.S("publicSuffixListBytes");
                bArr2 = null;
            }
            String strB2 = aVar.b(bArr2, bArr, i11);
            if (strB2 != null) {
                str = strB2;
                break;
            }
            i11 = i12;
        }
        if (size > 1) {
            byte[][] bArr3 = (byte[][]) bArr.clone();
            int length = bArr3.length - 1;
            int i13 = 0;
            while (i13 < length) {
                int i14 = i13 + 1;
                bArr3[i13] = f43871g;
                a aVar2 = f43869e;
                byte[] bArr4 = this.f43877c;
                if (bArr4 == null) {
                    f0.S("publicSuffixListBytes");
                    bArr4 = null;
                }
                String strB3 = aVar2.b(bArr4, bArr3, i13);
                if (strB3 != null) {
                    str2 = strB3;
                    break;
                }
                i13 = i14;
            }
            str2 = null;
        } else {
            str2 = null;
        }
        if (str2 != null) {
            int i15 = size - 1;
            int i16 = 0;
            while (i16 < i15) {
                int i17 = i16 + 1;
                a aVar3 = f43869e;
                byte[] bArr5 = this.f43878d;
                if (bArr5 == null) {
                    f0.S("publicSuffixExceptionListBytes");
                    bArr5 = null;
                }
                strB = aVar3.b(bArr5, bArr, i16);
                if (strB != null) {
                    break;
                }
                i16 = i17;
            }
            strB = null;
        } else {
            strB = null;
        }
        if (strB != null) {
            return StringsKt__StringsKt.T4(f0.C("!", strB), new char[]{'.'}, false, 0, 6, null);
        }
        if (str == null && str2 == null) {
            return f43872h;
        }
        List<String> listT4 = str == null ? null : StringsKt__StringsKt.T4(str, new char[]{'.'}, false, 0, 6, null);
        if (listT4 == null) {
            listT4 = CollectionsKt__CollectionsKt.E();
        }
        List<String> listT42 = str2 != null ? StringsKt__StringsKt.T4(str2, new char[]{'.'}, false, 0, 6, null) : null;
        if (listT42 == null) {
            listT42 = CollectionsKt__CollectionsKt.E();
        }
        return listT4.size() > listT42.size() ? listT4 : listT42;
    }

    @l
    public final String c(@k String domain) {
        int size;
        int size2;
        f0.p(domain, "domain");
        String unicodeDomain = IDN.toUnicode(domain);
        f0.o(unicodeDomain, "unicodeDomain");
        List<String> listG = g(unicodeDomain);
        List<String> listB = b(listG);
        if (listG.size() == listB.size() && listB.get(0).charAt(0) != '!') {
            return null;
        }
        if (listB.get(0).charAt(0) == '!') {
            size = listG.size();
            size2 = listB.size();
        } else {
            size = listG.size();
            size2 = listB.size() + 1;
        }
        return SequencesKt___SequencesKt.e1(SequencesKt___SequencesKt.k0(CollectionsKt___CollectionsKt.v1(g(domain)), size - size2), b.f36044h, null, null, 0, null, null, 62, null);
    }

    public final void d() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(f43870f);
        if (resourceAsStream == null) {
            return;
        }
        okio.l lVarE = okio.f0.e(new x(okio.f0.u(resourceAsStream)));
        try {
            byte[] bArrW1 = lVarE.w1(lVarE.readInt());
            byte[] bArrW12 = lVarE.w1(lVarE.readInt());
            z1 z1Var = z1.f38230a;
            kotlin.io.b.a(lVarE, null);
            synchronized (this) {
                f0.m(bArrW1);
                this.f43877c = bArrW1;
                f0.m(bArrW12);
                this.f43878d = bArrW12;
            }
            this.f43876b.countDown();
        } finally {
        }
    }

    public final void e() {
        boolean z10 = false;
        while (true) {
            try {
                try {
                    d();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z10 = true;
                } catch (IOException e10) {
                    h.f58636a.g().m("Failed to read public suffix list", 5, e10);
                    if (z10) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th2) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    public final void f(@k byte[] publicSuffixListBytes, @k byte[] publicSuffixExceptionListBytes) {
        f0.p(publicSuffixListBytes, "publicSuffixListBytes");
        f0.p(publicSuffixExceptionListBytes, "publicSuffixExceptionListBytes");
        this.f43877c = publicSuffixListBytes;
        this.f43878d = publicSuffixExceptionListBytes;
        this.f43875a.set(true);
        this.f43876b.countDown();
    }

    public final List<String> g(String str) {
        List<String> listT4 = StringsKt__StringsKt.T4(str, new char[]{'.'}, false, 0, 6, null);
        return f0.g(CollectionsKt___CollectionsKt.k3(listT4), "") ? CollectionsKt___CollectionsKt.Y1(listT4, 1) : listT4;
    }
}
