package okio;

import java.io.IOException;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u000b\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0014B!\b\u0002\u0012\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0002R\"\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lokio/i0;", "Lkotlin/collections/b;", "Lokio/ByteString;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "index", "d", "", "b", "[Lokio/ByteString;", com.flydigi.sdk.bluetooth.l.f16298a, "()[Lokio/ByteString;", "byteStrings", "", "c", "[I", m0.k.f40564b, "()[I", "trie", "a", "()I", "size", "<init>", "([Lokio/ByteString;[I)V", "okio"}, k = 1, mv = {1, 5, 1})
public final class i0 extends kotlin.collections.b<ByteString> implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final a f44070d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final ByteString[] f44071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final int[] f44072c;

    @kotlin.d0(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\"\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007JT\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000eH\u0002R\u0018\u0010\u0016\u001a\u00020\b*\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lokio/i0$a;", "", "", "Lokio/ByteString;", "byteStrings", "Lokio/i0;", "d", "([Lokio/ByteString;)Lokio/i0;", "", "nodeOffset", "Lokio/j;", "node", "", "byteStringOffset", "", "fromIndex", "toIndex", "indexes", "Lkotlin/z1;", "a", "c", "(Lokio/j;)J", "intCount", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        public static /* synthetic */ void b(a aVar, long j10, j jVar, int i10, List list, int i11, int i12, List list2, int i13, Object obj) throws IOException {
            aVar.a((i13 & 1) != 0 ? 0L : j10, jVar, (i13 & 4) != 0 ? 0 : i10, list, (i13 & 16) != 0 ? 0 : i11, (i13 & 32) != 0 ? list.size() : i12, list2);
        }

        public final void a(long j10, j jVar, int i10, List<? extends ByteString> list, int i11, int i12, List<Integer> list2) throws IOException {
            int i13;
            int i14;
            int i15;
            int i16;
            int i17;
            j jVar2;
            int i18 = i10;
            if (!(i11 < i12)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (i11 < i12) {
                int i19 = i11;
                while (true) {
                    int i20 = i19 + 1;
                    if (!(list.get(i19).x0() >= i18)) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    if (i20 >= i12) {
                        break;
                    } else {
                        i19 = i20;
                    }
                }
            }
            ByteString byteString = list.get(i11);
            ByteString byteString2 = list.get(i12 - 1);
            if (i18 == byteString.x0()) {
                int iIntValue = list2.get(i11).intValue();
                int i21 = i11 + 1;
                ByteString byteString3 = list.get(i21);
                i13 = i21;
                i14 = iIntValue;
                byteString = byteString3;
            } else {
                i13 = i11;
                i14 = -1;
            }
            if (byteString.v(i18) == byteString2.v(i18)) {
                int iMin = Math.min(byteString.x0(), byteString2.x0());
                if (i18 < iMin) {
                    int i22 = i18;
                    i15 = 0;
                    while (true) {
                        int i23 = i22 + 1;
                        if (byteString.v(i22) != byteString2.v(i22)) {
                            break;
                        }
                        i15++;
                        if (i23 >= iMin) {
                            break;
                        } else {
                            i22 = i23;
                        }
                    }
                } else {
                    i15 = 0;
                }
                long jC = j10 + c(jVar) + ((long) 2) + ((long) i15) + 1;
                jVar.writeInt(-i15);
                jVar.writeInt(i14);
                int i24 = i18 + i15;
                if (i18 < i24) {
                    while (true) {
                        int i25 = i18 + 1;
                        jVar.writeInt(byteString.v(i18) & 255);
                        if (i25 >= i24) {
                            break;
                        } else {
                            i18 = i25;
                        }
                    }
                }
                if (i13 + 1 == i12) {
                    if (!(i24 == list.get(i13).x0())) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    jVar.writeInt(list2.get(i13).intValue());
                    return;
                } else {
                    j jVar3 = new j();
                    jVar.writeInt(((int) (c(jVar3) + jC)) * (-1));
                    a(jC, jVar3, i24, list, i13, i12, list2);
                    jVar.X0(jVar3);
                    return;
                }
            }
            int i26 = i13 + 1;
            int i27 = 1;
            if (i26 < i12) {
                while (true) {
                    int i28 = i26 + 1;
                    if (list.get(i26 - 1).v(i18) != list.get(i26).v(i18)) {
                        i27++;
                    }
                    if (i28 >= i12) {
                        break;
                    } else {
                        i26 = i28;
                    }
                }
            }
            long jC2 = j10 + c(jVar) + ((long) 2) + ((long) (i27 * 2));
            jVar.writeInt(i27);
            jVar.writeInt(i14);
            if (i13 < i12) {
                int i29 = i13;
                while (true) {
                    int i30 = i29 + 1;
                    byte bV = list.get(i29).v(i18);
                    if (i29 == i13 || bV != list.get(i29 - 1).v(i18)) {
                        jVar.writeInt(bV & 255);
                    }
                    if (i30 >= i12) {
                        break;
                    } else {
                        i29 = i30;
                    }
                }
            }
            j jVar4 = new j();
            while (i13 < i12) {
                byte bV2 = list.get(i13).v(i18);
                int i31 = i13 + 1;
                if (i31 < i12) {
                    int i32 = i31;
                    while (true) {
                        int i33 = i32 + 1;
                        if (bV2 != list.get(i32).v(i18)) {
                            i16 = i32;
                            break;
                        } else if (i33 >= i12) {
                            break;
                        } else {
                            i32 = i33;
                        }
                    }
                    i16 = i12;
                } else {
                    i16 = i12;
                }
                if (i31 == i16 && i18 + 1 == list.get(i13).x0()) {
                    jVar.writeInt(list2.get(i13).intValue());
                    i17 = i16;
                    jVar2 = jVar4;
                } else {
                    jVar.writeInt(((int) (jC2 + c(jVar4))) * (-1));
                    i17 = i16;
                    jVar2 = jVar4;
                    a(jC2, jVar4, i18 + 1, list, i13, i16, list2);
                }
                jVar4 = jVar2;
                i13 = i17;
            }
            jVar.X0(jVar4);
        }

        public final long c(j jVar) {
            return jVar.m2() / ((long) 4);
        }

        /* JADX WARN: Code restructure failed: missing block: B:55:0x00e4, code lost:
        
            continue;
         */
        @hk.m
        @yt.k
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final okio.i0 d(@yt.k okio.ByteString... r17) throws java.io.IOException {
            /*
                Method dump skipped, instruction units count: 316
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.i0.a.d(okio.ByteString[]):okio.i0");
        }
    }

    public i0(ByteString[] byteStringArr, int[] iArr) {
        this.f44071b = byteStringArr;
        this.f44072c = iArr;
    }

    public /* synthetic */ i0(ByteString[] byteStringArr, int[] iArr, kotlin.jvm.internal.u uVar) {
        this(byteStringArr, iArr);
    }

    @hk.m
    @yt.k
    public static final i0 q(@yt.k ByteString... byteStringArr) {
        return f44070d.d(byteStringArr);
    }

    @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
    public int a() {
        return this.f44071b.length;
    }

    public /* bridge */ boolean b(ByteString byteString) {
        return super.contains(byteString);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return b((ByteString) obj);
        }
        return false;
    }

    @Override // kotlin.collections.b, java.util.List
    @yt.k
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ByteString get(int i10) {
        return this.f44071b[i10];
    }

    @Override // kotlin.collections.b, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return o((ByteString) obj);
        }
        return -1;
    }

    @yt.k
    public final ByteString[] l() {
        return this.f44071b;
    }

    @Override // kotlin.collections.b, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return p((ByteString) obj);
        }
        return -1;
    }

    @yt.k
    public final int[] m() {
        return this.f44072c;
    }

    public /* bridge */ int o(ByteString byteString) {
        return super.indexOf(byteString);
    }

    public /* bridge */ int p(ByteString byteString) {
        return super.lastIndexOf(byteString);
    }
}
