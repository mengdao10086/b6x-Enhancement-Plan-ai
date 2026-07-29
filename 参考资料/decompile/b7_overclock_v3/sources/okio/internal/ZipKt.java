package okio.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.flydigi.sdk.bluetooth.l;
import ik.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d0;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.f0;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.u;
import kotlin.v1;
import kotlin.z1;
import okio.k0;
import okio.q;
import okio.r;
import okio.s;
import okio.x0;
import w.w;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a.\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0000\u001a\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00050\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0002\u001a\f\u0010\u000f\u001a\u00020\u0005*\u00020\u000eH\u0000\u001a\f\u0010\u0011\u001a\u00020\u0010*\u00020\u000eH\u0002\u001a\u0014\u0010\u0013\u001a\u00020\u0010*\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0010H\u0002\u001a.\u0010\u001a\u001a\u00020\u0018*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00142\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0002\u001a\f\u0010\u001b\u001a\u00020\u0018*\u00020\u000eH\u0000\u001a\u0014\u0010\u001e\u001a\u00020\u001c*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0000\u001a\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c*\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002\u001a!\u0010\"\u001a\u0004\u0018\u00010\u00172\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\"\u0010#\"\u0014\u0010%\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010$\"\u0014\u0010&\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010$\"\u0014\u0010(\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010$\"\u0014\u0010)\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010$\"\u0014\u0010+\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010$\"\u0014\u0010,\u001a\u00020\u00148\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000f\u0010$\"\u0014\u0010-\u001a\u00020\u00148\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0011\u0010$\"\u0014\u0010.\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010$\"\u0014\u0010/\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010$\"\u0014\u00101\u001a\u00020\u00178\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u00100\"\u0014\u00102\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010$\"\u0014\u00103\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010$\"\u0018\u00106\u001a\u000204*\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b'\u00105¨\u00067"}, d2 = {"Lokio/k0;", "zipPath", "Lokio/s;", "fileSystem", "Lkotlin/Function1;", "Lokio/internal/c;", "", "predicate", "Lokio/x0;", "d", "", "entries", "", "a", "Lokio/l;", "f", "Lokio/internal/a;", "g", "regularRecord", "k", "", "extraSize", "Lkotlin/Function2;", "", "Lkotlin/z1;", "block", "h", l.f16298a, "Lokio/r;", "basicMetadata", "i", xf.j.f55230b, fh.e.f28447d, "time", "b", "(II)Ljava/lang/Long;", "I", "LOCAL_FILE_HEADER_SIGNATURE", "CENTRAL_FILE_HEADER_SIGNATURE", "c", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "e", "ZIP64_EOCD_RECORD_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "BIT_FLAG_ENCRYPTED", "BIT_FLAG_UNSUPPORTED_MASK", "J", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", "HEADER_ID_ZIP64_EXTENDED_INFO", "HEADER_ID_EXTENDED_TIMESTAMP", "", "(I)Ljava/lang/String;", "hex", "okio"}, k = 2, mv = {1, 5, 1})
public final class ZipKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f44077a = 67324752;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f44078b = 33639248;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f44079c = 101010256;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f44080d = 117853008;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f44081e = 101075792;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f44082f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f44083g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f44084h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f44085i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final long f44086j = 4294967295L;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f44087k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f44088l = 21589;

    @d0(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {i1.a.f31577d5, "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "uj/g$a", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return uj.g.l(((c) t10).a(), ((c) t11).a());
        }
    }

    public static final Map<k0, c> a(List<c> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (c cVar : CollectionsKt___CollectionsKt.p5(list, new a())) {
            if (((c) linkedHashMap.put(cVar.a(), cVar)) == null) {
                while (true) {
                    k0 k0VarT = cVar.a().t();
                    if (k0VarT != null) {
                        c cVar2 = (c) linkedHashMap.get(k0VarT);
                        if (cVar2 != null) {
                            cVar2.b().add(cVar.a());
                            break;
                        }
                        c cVar3 = new c(k0VarT, true, null, 0L, 0L, 0L, 0, null, 0L, w.g.f53777p, null);
                        linkedHashMap.put(k0VarT, cVar3);
                        cVar3.b().add(cVar.a());
                        cVar = cVar3;
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public static final Long b(int i10, int i11) {
        if (i11 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        gregorianCalendar.set(((i10 >> 9) & 127) + 1980, ((i10 >> 5) & 15) - 1, i10 & 31, (i11 >> 11) & 31, (i11 >> 5) & 63, (i11 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    public static final String c(int i10) {
        String string = Integer.toString(i10, kotlin.text.b.a(16));
        f0.o(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return f0.C("0x", string);
    }

    @k
    public static final x0 d(@k k0 zipPath, @k s fileSystem, @k ik.l<? super c, Boolean> predicate) throws IOException {
        okio.l lVarE;
        int iQ1;
        okio.l lVarE2;
        f0.p(zipPath, "zipPath");
        f0.p(fileSystem, "fileSystem");
        f0.p(predicate, "predicate");
        q qVarE = fileSystem.E(zipPath);
        long j10 = 0;
        try {
            lVarE = okio.f0.e(q.i1(qVarE, 0L, 1, null));
            try {
                iQ1 = lVarE.q1();
            } finally {
                try {
                    throw th;
                } finally {
                    kotlin.io.b.a(lVarE, th);
                }
            }
        } finally {
        }
        if (iQ1 != 67324752) {
            if (iQ1 == 101010256) {
                throw new IOException("unsupported zip: empty");
            }
            throw new IOException("not a zip: expected " + c(f44077a) + " but was " + c(iQ1));
        }
        z1 z1Var = z1.f38230a;
        kotlin.io.b.a(lVarE, null);
        long jD1 = qVarE.d1() - ((long) 22);
        if (jD1 < 0) {
            throw new IOException(f0.C("not a zip: size=", Long.valueOf(qVarE.d1())));
        }
        long jMax = Math.max(jD1 - PlaybackStateCompat.C, 0L);
        do {
            okio.l lVarE3 = okio.f0.e(qVarE.h1(jD1));
            try {
                if (lVarE3.q1() == 101010256) {
                    okio.internal.a aVarG = g(lVarE3);
                    String strQ = lVarE3.q(aVarG.b());
                    lVarE3.close();
                    long j11 = jD1 - ((long) 20);
                    if (j11 > 0) {
                        lVarE2 = okio.f0.e(qVarE.h1(j11));
                        try {
                            if (lVarE2.q1() == 117853008) {
                                int iQ12 = lVarE2.q1();
                                long jH1 = lVarE2.H1();
                                if (lVarE2.q1() != 1 || iQ12 != 0) {
                                    throw new IOException("unsupported zip: spanned");
                                }
                                lVarE2 = okio.f0.e(qVarE.h1(jH1));
                                try {
                                    int iQ13 = lVarE2.q1();
                                    if (iQ13 != 101075792) {
                                        throw new IOException("bad zip: expected " + c(f44081e) + " but was " + c(iQ13));
                                    }
                                    okio.internal.a aVarK = k(lVarE2, aVarG);
                                    z1 z1Var2 = z1.f38230a;
                                    kotlin.io.b.a(lVarE2, null);
                                    aVarG = aVarK;
                                } finally {
                                }
                            }
                            z1 z1Var3 = z1.f38230a;
                            kotlin.io.b.a(lVarE2, null);
                        } finally {
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    lVarE2 = okio.f0.e(qVarE.h1(aVarG.a()));
                    try {
                        long jC = aVarG.c();
                        if (0 < jC) {
                            do {
                                j10++;
                                c cVarF = f(lVarE2);
                                if (cVarF.h() >= aVarG.a()) {
                                    throw new IOException("bad zip: local file header offset >= central directory offset");
                                }
                                if (predicate.i(cVarF).booleanValue()) {
                                    arrayList.add(cVarF);
                                }
                            } while (j10 < jC);
                        }
                        z1 z1Var4 = z1.f38230a;
                        kotlin.io.b.a(lVarE2, null);
                        x0 x0Var = new x0(zipPath, fileSystem, a(arrayList), strQ);
                        kotlin.io.b.a(qVarE, null);
                        return x0Var;
                    } finally {
                        try {
                            throw th;
                        } finally {
                            kotlin.io.b.a(lVarE2, th);
                        }
                    }
                }
                lVarE3.close();
                jD1--;
            } catch (Throwable th2) {
                lVarE3.close();
                throw th2;
            }
        } while (jD1 >= jMax);
        throw new IOException("not a zip: end of central directory signature not found");
    }

    public static /* synthetic */ x0 e(k0 k0Var, s sVar, ik.l lVar, int i10, Object obj) throws IOException {
        if ((i10 & 4) != 0) {
            lVar = new ik.l<c, Boolean>() { // from class: okio.internal.ZipKt$openZip$1
                @Override // ik.l
                @k
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Boolean i(@k c it2) {
                    f0.p(it2, "it");
                    return Boolean.TRUE;
                }
            };
        }
        return d(k0Var, sVar, lVar);
    }

    @k
    public static final c f(@k final okio.l lVar) throws IOException {
        int i10;
        Long l10;
        long j10;
        f0.p(lVar, "<this>");
        int iQ1 = lVar.q1();
        if (iQ1 != 33639248) {
            throw new IOException("bad zip: expected " + c(f44078b) + " but was " + c(iQ1));
        }
        lVar.skip(4L);
        int iE1 = lVar.E1() & v1.f38215d;
        if ((iE1 & 1) != 0) {
            throw new IOException(f0.C("unsupported zip: general purpose bit flag=", c(iE1)));
        }
        int iE12 = lVar.E1() & v1.f38215d;
        Long lB = b(lVar.E1() & v1.f38215d, lVar.E1() & v1.f38215d);
        long jQ1 = ((long) lVar.q1()) & 4294967295L;
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = ((long) lVar.q1()) & 4294967295L;
        final Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.element = ((long) lVar.q1()) & 4294967295L;
        int iE13 = lVar.E1() & v1.f38215d;
        int iE14 = lVar.E1() & v1.f38215d;
        int iE15 = lVar.E1() & v1.f38215d;
        lVar.skip(8L);
        final Ref.LongRef longRef3 = new Ref.LongRef();
        longRef3.element = ((long) lVar.q1()) & 4294967295L;
        String strQ = lVar.q(iE13);
        if (StringsKt__StringsKt.V2(strQ, (char) 0, false, 2, null)) {
            throw new IOException("bad zip: filename contains 0x00");
        }
        if (longRef2.element == 4294967295L) {
            j10 = ((long) 8) + 0;
            i10 = iE12;
            l10 = lB;
        } else {
            i10 = iE12;
            l10 = lB;
            j10 = 0;
        }
        if (longRef.element == 4294967295L) {
            j10 += (long) 8;
        }
        if (longRef3.element == 4294967295L) {
            j10 += (long) 8;
        }
        final long j11 = j10;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        h(lVar, iE14, new p<Integer, Long, z1>() { // from class: okio.internal.ZipKt$readEntry$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final void b(int i11, long j12) throws IOException {
                if (i11 == 1) {
                    Ref.BooleanRef booleanRef2 = booleanRef;
                    if (booleanRef2.element) {
                        throw new IOException("bad zip: zip64 extra repeated");
                    }
                    booleanRef2.element = true;
                    if (j12 < j11) {
                        throw new IOException("bad zip: zip64 extra too short");
                    }
                    Ref.LongRef longRef4 = longRef2;
                    long jH1 = longRef4.element;
                    if (jH1 == 4294967295L) {
                        jH1 = lVar.H1();
                    }
                    longRef4.element = jH1;
                    Ref.LongRef longRef5 = longRef;
                    longRef5.element = longRef5.element == 4294967295L ? lVar.H1() : 0L;
                    Ref.LongRef longRef6 = longRef3;
                    longRef6.element = longRef6.element == 4294967295L ? lVar.H1() : 0L;
                }
            }

            @Override // ik.p
            public /* bridge */ /* synthetic */ z1 r0(Integer num, Long l11) throws IOException {
                b(num.intValue(), l11.longValue());
                return z1.f38230a;
            }
        });
        if (j11 > 0 && !booleanRef.element) {
            throw new IOException("bad zip: zip64 extra required but absent");
        }
        return new c(k0.a.h(k0.f44129b, fh.a.f28350w, false, 1, null).v(strQ), u.K1(strQ, fh.a.f28350w, false, 2, null), lVar.q(iE15), jQ1, longRef.element, longRef2.element, i10, l10, longRef3.element);
    }

    public static final okio.internal.a g(okio.l lVar) throws IOException {
        int iE1 = lVar.E1() & v1.f38215d;
        int iE12 = lVar.E1() & v1.f38215d;
        long jE1 = lVar.E1() & v1.f38215d;
        if (jE1 != (lVar.E1() & v1.f38215d) || iE1 != 0 || iE12 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        lVar.skip(4L);
        return new okio.internal.a(jE1, 4294967295L & ((long) lVar.q1()), lVar.E1() & v1.f38215d);
    }

    public static final void h(okio.l lVar, int i10, p<? super Integer, ? super Long, z1> pVar) throws IOException {
        long j10 = i10;
        while (j10 != 0) {
            if (j10 < 4) {
                throw new IOException("bad zip: truncated header in extra field");
            }
            int iE1 = lVar.E1() & v1.f38215d;
            long jE1 = ((long) lVar.E1()) & dm.g.f26388t;
            long j11 = j10 - ((long) 4);
            if (j11 < jE1) {
                throw new IOException("bad zip: truncated value in extra field");
            }
            lVar.U1(jE1);
            long jM2 = lVar.g().m2();
            pVar.r0(Integer.valueOf(iE1), Long.valueOf(jE1));
            long jM22 = (lVar.g().m2() + jE1) - jM2;
            if (jM22 < 0) {
                throw new IOException(f0.C("unsupported zip: too many bytes processed for ", Integer.valueOf(iE1)));
            }
            if (jM22 > 0) {
                lVar.g().skip(jM22);
            }
            j10 = j11 - jE1;
        }
    }

    @k
    public static final r i(@k okio.l lVar, @k r basicMetadata) throws IOException {
        f0.p(lVar, "<this>");
        f0.p(basicMetadata, "basicMetadata");
        r rVarJ = j(lVar, basicMetadata);
        f0.m(rVarJ);
        return rVarJ;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final r j(final okio.l lVar, r rVar) throws IOException {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = rVar == null ? 0 : rVar.g();
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        int iQ1 = lVar.q1();
        if (iQ1 != 67324752) {
            throw new IOException("bad zip: expected " + c(f44077a) + " but was " + c(iQ1));
        }
        lVar.skip(2L);
        int iE1 = lVar.E1() & v1.f38215d;
        if ((iE1 & 1) != 0) {
            throw new IOException(f0.C("unsupported zip: general purpose bit flag=", c(iE1)));
        }
        lVar.skip(18L);
        long jE1 = ((long) lVar.E1()) & dm.g.f26388t;
        int iE12 = lVar.E1() & v1.f38215d;
        lVar.skip(jE1);
        if (rVar == null) {
            lVar.skip(iE12);
            return null;
        }
        h(lVar, iE12, new p<Integer, Long, z1>() { // from class: okio.internal.ZipKt$readOrSkipLocalHeader$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Type inference failed for: r0v13, types: [T, java.lang.Long] */
            /* JADX WARN: Type inference failed for: r0v17, types: [T, java.lang.Long] */
            /* JADX WARN: Type inference failed for: r10v3, types: [T, java.lang.Long] */
            public final void b(int i10, long j10) throws IOException {
                if (i10 == 21589) {
                    if (j10 < 1) {
                        throw new IOException("bad zip: extended timestamp extra too short");
                    }
                    int i11 = lVar.readByte() & 255;
                    boolean z10 = (i11 & 1) == 1;
                    boolean z11 = (i11 & 2) == 2;
                    boolean z12 = (i11 & 4) == 4;
                    okio.l lVar2 = lVar;
                    long j11 = z10 ? 5L : 1L;
                    if (z11) {
                        j11 += 4;
                    }
                    if (z12) {
                        j11 += 4;
                    }
                    if (j10 < j11) {
                        throw new IOException("bad zip: extended timestamp extra too short");
                    }
                    if (z10) {
                        objectRef.element = Long.valueOf(((long) lVar2.q1()) * 1000);
                    }
                    if (z11) {
                        objectRef2.element = Long.valueOf(((long) lVar.q1()) * 1000);
                    }
                    if (z12) {
                        objectRef3.element = Long.valueOf(((long) lVar.q1()) * 1000);
                    }
                }
            }

            @Override // ik.p
            public /* bridge */ /* synthetic */ z1 r0(Integer num, Long l10) throws IOException {
                b(num.intValue(), l10.longValue());
                return z1.f38230a;
            }
        });
        return new r(rVar.k(), rVar.j(), null, rVar.h(), (Long) objectRef3.element, (Long) objectRef.element, (Long) objectRef2.element, null, 128, null);
    }

    public static final okio.internal.a k(okio.l lVar, okio.internal.a aVar) throws IOException {
        lVar.skip(12L);
        int iQ1 = lVar.q1();
        int iQ12 = lVar.q1();
        long jH1 = lVar.H1();
        if (jH1 != lVar.H1() || iQ1 != 0 || iQ12 != 0) {
            throw new IOException("unsupported zip: spanned");
        }
        lVar.skip(8L);
        return new okio.internal.a(jH1, lVar.H1(), aVar.b());
    }

    public static final void l(@k okio.l lVar) throws IOException {
        f0.p(lVar, "<this>");
        j(lVar, null);
    }
}
