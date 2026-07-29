package okio.internal;

import com.flydigi.sdk.bluetooth.l;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.collections.x;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import m0.k;
import okio.ByteString;
import okio.k0;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u001a\u001a\u000f\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u00020\u0000H\u0080\b\u001a\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002*\u00020\u0000H\u0080\b\u001a\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002*\u00020\u0000H\u0080\b\u001a\f\u0010\b\u001a\u00020\u0007*\u00020\u0000H\u0002\u001a\r\u0010\n\u001a\u00020\t*\u00020\u0000H\u0080\b\u001a\r\u0010\u000b\u001a\u00020\t*\u00020\u0000H\u0080\b\u001a\u0016\u0010\r\u001a\u0004\u0018\u00010\f*\u00020\u0000H\u0080\b¢\u0006\u0004\b\r\u0010\u000e\u001a\r\u0010\u000f\u001a\u00020\u0005*\u00020\u0000H\u0080\b\u001a\r\u0010\u0010\u001a\u00020\u0003*\u00020\u0000H\u0080\b\u001a\u000f\u0010\u0011\u001a\u0004\u0018\u00010\u0000*\u00020\u0000H\u0080\b\u001a\f\u0010\u0012\u001a\u00020\t*\u00020\u0000H\u0002\u001a\r\u0010\u0013\u001a\u00020\t*\u00020\u0000H\u0080\b\u001a\u001d\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\tH\u0080\b\u001a\u001d\u0010\u0017\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\tH\u0080\b\u001a\u001d\u0010\u0019\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\tH\u0080\b\u001a\u001c\u0010\u001a\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\tH\u0000\u001a\u0015\u0010\u001c\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0000H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u0000*\u00020\u0000H\u0080\b\u001a\u0015\u0010\u001e\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0000H\u0080\b\u001a\u0017\u0010 \u001a\u00020\t*\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001fH\u0080\b\u001a\r\u0010!\u001a\u00020\u0007*\u00020\u0000H\u0080\b\u001a\r\u0010\"\u001a\u00020\u0003*\u00020\u0000H\u0080\b\u001a\u0012\u0010#\u001a\u00020\u0000*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\t\u001a\u0014\u0010$\u001a\u00020\u0000*\u00020\u00182\u0006\u0010\u0015\u001a\u00020\tH\u0000\u001a\f\u0010%\u001a\u00020\u0005*\u00020\u0003H\u0002\u001a\f\u0010'\u001a\u00020\u0005*\u00020&H\u0002\u001a\u0014\u0010)\u001a\u00020\t*\u00020\u00182\u0006\u0010(\u001a\u00020\u0005H\u0002\"\u001a\u0010.\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\f\n\u0004\b*\u0010+\u0012\u0004\b,\u0010-\"\u001a\u00101\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\f\n\u0004\b/\u0010+\u0012\u0004\b0\u0010-\"\u001a\u00104\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\f\n\u0004\b2\u0010+\u0012\u0004\b3\u0010-\"\u001a\u00107\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\f\n\u0004\b5\u0010+\u0012\u0004\b6\u0010-\"\u001a\u0010:\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\f\n\u0004\b8\u0010+\u0012\u0004\b9\u0010-\"\u0018\u0010=\u001a\u00020\u0007*\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<\"\u001a\u0010(\u001a\u0004\u0018\u00010\u0005*\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006@"}, d2 = {"Lokio/k0;", "y", "", "", an.aD, "Lokio/ByteString;", i1.a.W4, "", "M", "", k.f40564b, "n", "", "D", "(Lokio/k0;)Ljava/lang/Character;", "q", "p", an.aB, "L", "o", "child", "normalize", "u", "w", "Lokio/j;", "v", "x", "other", "t", SsManifestParser.e.J, xf.j.f55230b, "", "k", l.f16298a, "C", "B", "O", "Q", "", "P", "slash", "N", "a", "Lokio/ByteString;", "getSLASH$annotations", "()V", "SLASH", "b", "getBACKSLASH$annotations", "BACKSLASH", "c", "getANY_SLASH$annotations", "ANY_SLASH", "d", "getDOT$annotations", "DOT", "e", "getDOT_DOT$annotations", "DOT_DOT", "I", "(Lokio/k0;)I", "indexOfLastSlash", "K", "(Lokio/k0;)Lokio/ByteString;", "okio"}, k = 2, mv = {1, 5, 1})
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final ByteString f44111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final ByteString f44112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final ByteString f44113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final ByteString f44114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final ByteString f44115e;

    static {
        ByteString.a aVar = ByteString.f44029c;
        f44111a = aVar.l(fh.a.f28350w);
        f44112b = aVar.l("\\");
        f44113c = aVar.l("/\\");
        f44114d = aVar.l(j3.b.f36044h);
        f44115e = aVar.l("..");
    }

    @yt.k
    public static final List<ByteString> A(@yt.k k0 k0Var) {
        f0.p(k0Var, "<this>");
        ArrayList arrayList = new ArrayList();
        int iM = M(k0Var);
        if (iM == -1) {
            iM = 0;
        } else if (iM < k0Var.j().x0() && k0Var.j().v(iM) == ((byte) 92)) {
            iM++;
        }
        int iX0 = k0Var.j().x0();
        if (iM < iX0) {
            int i10 = iM;
            while (true) {
                int i11 = iM + 1;
                if (k0Var.j().v(iM) == ((byte) 47) || k0Var.j().v(iM) == ((byte) 92)) {
                    arrayList.add(k0Var.j().F0(i10, iM));
                    i10 = i11;
                }
                if (i11 >= iX0) {
                    break;
                }
                iM = i11;
            }
            iM = i10;
        }
        if (iM < k0Var.j().x0()) {
            arrayList.add(k0Var.j().F0(iM, k0Var.j().x0()));
        }
        return arrayList;
    }

    @yt.k
    public static final k0 B(@yt.k String str, boolean z10) {
        f0.p(str, "<this>");
        return O(new okio.j().H0(str), z10);
    }

    @yt.k
    public static final String C(@yt.k k0 k0Var) {
        f0.p(k0Var, "<this>");
        return k0Var.j().O0();
    }

    @yt.l
    public static final Character D(@yt.k k0 k0Var) {
        f0.p(k0Var, "<this>");
        boolean z10 = false;
        if (ByteString.M(k0Var.j(), f44111a, 0, 2, null) != -1 || k0Var.j().x0() < 2 || k0Var.j().v(1) != ((byte) 58)) {
            return null;
        }
        char cV = (char) k0Var.j().v(0);
        if (!('a' <= cV && cV <= 'z')) {
            if ('A' <= cV && cV <= 'Z') {
                z10 = true;
            }
            if (!z10) {
                return null;
            }
        }
        return Character.valueOf(cV);
    }

    public static /* synthetic */ void E() {
    }

    public static /* synthetic */ void F() {
    }

    public static /* synthetic */ void G() {
    }

    public static /* synthetic */ void H() {
    }

    public static final int I(k0 k0Var) {
        int iW = ByteString.W(k0Var.j(), f44111a, 0, 2, null);
        return iW != -1 ? iW : ByteString.W(k0Var.j(), f44112b, 0, 2, null);
    }

    public static /* synthetic */ void J() {
    }

    public static final ByteString K(k0 k0Var) {
        ByteString byteStringJ = k0Var.j();
        ByteString byteString = f44111a;
        if (ByteString.M(byteStringJ, byteString, 0, 2, null) != -1) {
            return byteString;
        }
        ByteString byteStringJ2 = k0Var.j();
        ByteString byteString2 = f44112b;
        if (ByteString.M(byteStringJ2, byteString2, 0, 2, null) != -1) {
            return byteString2;
        }
        return null;
    }

    public static final boolean L(k0 k0Var) {
        return k0Var.j().t(f44115e) && (k0Var.j().x0() == 2 || k0Var.j().o0(k0Var.j().x0() + (-3), f44111a, 0, 1) || k0Var.j().o0(k0Var.j().x0() + (-3), f44112b, 0, 1));
    }

    public static final int M(k0 k0Var) {
        if (k0Var.j().x0() == 0) {
            return -1;
        }
        boolean z10 = false;
        if (k0Var.j().v(0) == ((byte) 47)) {
            return 1;
        }
        byte b10 = (byte) 92;
        if (k0Var.j().v(0) == b10) {
            if (k0Var.j().x0() <= 2 || k0Var.j().v(1) != b10) {
                return 1;
            }
            int iJ = k0Var.j().J(f44112b, 2);
            return iJ == -1 ? k0Var.j().x0() : iJ;
        }
        if (k0Var.j().x0() <= 2 || k0Var.j().v(1) != ((byte) 58) || k0Var.j().v(2) != b10) {
            return -1;
        }
        char cV = (char) k0Var.j().v(0);
        if ('a' <= cV && cV <= 'z') {
            return 3;
        }
        if ('A' <= cV && cV <= 'Z') {
            z10 = true;
        }
        return !z10 ? -1 : 3;
    }

    public static final boolean N(okio.j jVar, ByteString byteString) {
        if (!f0.g(byteString, f44112b) || jVar.m2() < 2 || jVar.d1(1L) != ((byte) 58)) {
            return false;
        }
        char cD1 = (char) jVar.d1(0L);
        if (!('a' <= cD1 && cD1 <= 'z')) {
            if (!('A' <= cD1 && cD1 <= 'Z')) {
                return false;
            }
        }
        return true;
    }

    @yt.k
    public static final k0 O(@yt.k okio.j jVar, boolean z10) throws EOFException {
        ByteString byteString;
        ByteString byteStringY;
        f0.p(jVar, "<this>");
        okio.j jVar2 = new okio.j();
        int i10 = 0;
        ByteString byteStringP = null;
        int i11 = 0;
        while (true) {
            if (!jVar.N0(0L, f44111a)) {
                byteString = f44112b;
                if (!jVar.N0(0L, byteString)) {
                    break;
                }
            }
            byte b10 = jVar.readByte();
            if (byteStringP == null) {
                byteStringP = P(b10);
            }
            i11++;
        }
        boolean z11 = i11 >= 2 && f0.g(byteStringP, byteString);
        if (z11) {
            f0.m(byteStringP);
            jVar2.B1(byteStringP);
            jVar2.B1(byteStringP);
        } else if (i11 > 0) {
            f0.m(byteStringP);
            jVar2.B1(byteStringP);
        } else {
            long jJ0 = jVar.j0(f44113c);
            if (byteStringP == null) {
                byteStringP = jJ0 == -1 ? Q(k0.f44130c) : P(jVar.d1(jJ0));
            }
            if (N(jVar, byteStringP)) {
                if (jJ0 == 2) {
                    jVar2.V0(jVar, 3L);
                } else {
                    jVar2.V0(jVar, 2L);
                }
            }
        }
        boolean z12 = jVar2.m2() > 0;
        ArrayList arrayList = new ArrayList();
        while (!jVar.d0()) {
            long jJ02 = jVar.j0(f44113c);
            if (jJ02 == -1) {
                byteStringY = jVar.Z0();
            } else {
                byteStringY = jVar.y(jJ02);
                jVar.readByte();
            }
            ByteString byteString2 = f44115e;
            if (f0.g(byteStringY, byteString2)) {
                if (!z12 || !arrayList.isEmpty()) {
                    if (!z10 || (!z12 && (arrayList.isEmpty() || f0.g(CollectionsKt___CollectionsKt.k3(arrayList), byteString2)))) {
                        arrayList.add(byteStringY);
                    } else if (!z11 || arrayList.size() != 1) {
                        x.M0(arrayList);
                    }
                }
            } else if (!f0.g(byteStringY, f44114d) && !f0.g(byteStringY, ByteString.f44030d)) {
                arrayList.add(byteStringY);
            }
        }
        int size = arrayList.size();
        if (size > 0) {
            while (true) {
                int i12 = i10 + 1;
                if (i10 > 0) {
                    jVar2.B1(byteStringP);
                }
                jVar2.B1((ByteString) arrayList.get(i10));
                if (i12 >= size) {
                    break;
                }
                i10 = i12;
            }
        }
        if (jVar2.m2() == 0) {
            jVar2.B1(f44114d);
        }
        return new k0(jVar2.Z0());
    }

    public static final ByteString P(byte b10) {
        if (b10 == 47) {
            return f44111a;
        }
        if (b10 == 92) {
            return f44112b;
        }
        throw new IllegalArgumentException(f0.C("not a directory separator: ", Byte.valueOf(b10)));
    }

    public static final ByteString Q(String str) {
        if (f0.g(str, fh.a.f28350w)) {
            return f44111a;
        }
        if (f0.g(str, "\\")) {
            return f44112b;
        }
        throw new IllegalArgumentException(f0.C("not a directory separator: ", str));
    }

    public static final int j(@yt.k k0 k0Var, @yt.k k0 other) {
        f0.p(k0Var, "<this>");
        f0.p(other, "other");
        return k0Var.j().compareTo(other.j());
    }

    public static final boolean k(@yt.k k0 k0Var, @yt.l Object obj) {
        f0.p(k0Var, "<this>");
        return (obj instanceof k0) && f0.g(((k0) obj).j(), k0Var.j());
    }

    public static final int l(@yt.k k0 k0Var) {
        f0.p(k0Var, "<this>");
        return k0Var.j().hashCode();
    }

    public static final boolean m(@yt.k k0 k0Var) {
        f0.p(k0Var, "<this>");
        return M(k0Var) != -1;
    }

    public static final boolean n(@yt.k k0 k0Var) {
        f0.p(k0Var, "<this>");
        return M(k0Var) == -1;
    }

    public static final boolean o(@yt.k k0 k0Var) {
        f0.p(k0Var, "<this>");
        return M(k0Var) == k0Var.j().x0();
    }

    @yt.k
    public static final String p(@yt.k k0 k0Var) {
        f0.p(k0Var, "<this>");
        return k0Var.r().O0();
    }

    @yt.k
    public static final ByteString q(@yt.k k0 k0Var) {
        f0.p(k0Var, "<this>");
        int I = I(k0Var);
        return I != -1 ? ByteString.G0(k0Var.j(), I + 1, 0, 2, null) : (k0Var.I() == null || k0Var.j().x0() != 2) ? k0Var.j() : ByteString.f44030d;
    }

    @yt.k
    public static final k0 r(@yt.k k0 k0Var) {
        f0.p(k0Var, "<this>");
        return k0.f44129b.d(k0Var.toString(), true);
    }

    @yt.l
    public static final k0 s(@yt.k k0 k0Var) {
        f0.p(k0Var, "<this>");
        if (f0.g(k0Var.j(), f44114d) || f0.g(k0Var.j(), f44111a) || f0.g(k0Var.j(), f44112b) || L(k0Var)) {
            return null;
        }
        int I = I(k0Var);
        if (I == 2 && k0Var.I() != null) {
            if (k0Var.j().x0() == 3) {
                return null;
            }
            return new k0(ByteString.G0(k0Var.j(), 0, 3, 1, null));
        }
        if (I == 1 && k0Var.j().y0(f44112b)) {
            return null;
        }
        if (I != -1 || k0Var.I() == null) {
            return I == -1 ? new k0(f44114d) : I == 0 ? new k0(ByteString.G0(k0Var.j(), 0, 1, 1, null)) : new k0(ByteString.G0(k0Var.j(), 0, I, 1, null));
        }
        if (k0Var.j().x0() == 2) {
            return null;
        }
        return new k0(ByteString.G0(k0Var.j(), 0, 2, 1, null));
    }

    @yt.k
    public static final k0 t(@yt.k k0 k0Var, @yt.k k0 other) {
        f0.p(k0Var, "<this>");
        f0.p(other, "other");
        if (!f0.g(k0Var.k(), other.k())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + k0Var + " and " + other).toString());
        }
        List<ByteString> listM = k0Var.m();
        List<ByteString> listM2 = other.m();
        int iMin = Math.min(listM.size(), listM2.size());
        int i10 = 0;
        while (i10 < iMin && f0.g(listM.get(i10), listM2.get(i10))) {
            i10++;
        }
        if (i10 == iMin && k0Var.j().x0() == other.j().x0()) {
            return k0.a.h(k0.f44129b, j3.b.f36044h, false, 1, null);
        }
        if (!(listM2.subList(i10, listM2.size()).indexOf(f44115e) == -1)) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + k0Var + " and " + other).toString());
        }
        okio.j jVar = new okio.j();
        ByteString byteStringK = K(other);
        if (byteStringK == null && (byteStringK = K(k0Var)) == null) {
            byteStringK = Q(k0.f44130c);
        }
        int size = listM2.size();
        if (i10 < size) {
            int i11 = i10;
            do {
                i11++;
                jVar.B1(f44115e);
                jVar.B1(byteStringK);
            } while (i11 < size);
        }
        int size2 = listM.size();
        if (i10 < size2) {
            while (true) {
                int i12 = i10 + 1;
                jVar.B1(listM.get(i10));
                jVar.B1(byteStringK);
                if (i12 >= size2) {
                    break;
                }
                i10 = i12;
            }
        }
        return O(jVar, false);
    }

    @yt.k
    public static final k0 u(@yt.k k0 k0Var, @yt.k String child, boolean z10) {
        f0.p(k0Var, "<this>");
        f0.p(child, "child");
        return x(k0Var, O(new okio.j().H0(child), false), z10);
    }

    @yt.k
    public static final k0 v(@yt.k k0 k0Var, @yt.k okio.j child, boolean z10) {
        f0.p(k0Var, "<this>");
        f0.p(child, "child");
        return x(k0Var, O(child, false), z10);
    }

    @yt.k
    public static final k0 w(@yt.k k0 k0Var, @yt.k ByteString child, boolean z10) {
        f0.p(k0Var, "<this>");
        f0.p(child, "child");
        return x(k0Var, O(new okio.j().B1(child), false), z10);
    }

    @yt.k
    public static final k0 x(@yt.k k0 k0Var, @yt.k k0 child, boolean z10) {
        f0.p(k0Var, "<this>");
        f0.p(child, "child");
        if (child.n() || child.I() != null) {
            return child;
        }
        ByteString byteStringK = K(k0Var);
        if (byteStringK == null && (byteStringK = K(child)) == null) {
            byteStringK = Q(k0.f44130c);
        }
        okio.j jVar = new okio.j();
        jVar.B1(k0Var.j());
        if (jVar.m2() > 0) {
            jVar.B1(byteStringK);
        }
        jVar.B1(child.j());
        return O(jVar, z10);
    }

    @yt.l
    public static final k0 y(@yt.k k0 k0Var) {
        f0.p(k0Var, "<this>");
        int iM = M(k0Var);
        if (iM == -1) {
            return null;
        }
        return new k0(k0Var.j().F0(0, iM));
    }

    @yt.k
    public static final List<String> z(@yt.k k0 k0Var) {
        f0.p(k0Var, "<this>");
        ArrayList arrayList = new ArrayList();
        int iM = M(k0Var);
        if (iM == -1) {
            iM = 0;
        } else if (iM < k0Var.j().x0() && k0Var.j().v(iM) == ((byte) 92)) {
            iM++;
        }
        int iX0 = k0Var.j().x0();
        if (iM < iX0) {
            int i10 = iM;
            while (true) {
                int i11 = iM + 1;
                if (k0Var.j().v(iM) == ((byte) 47) || k0Var.j().v(iM) == ((byte) 92)) {
                    arrayList.add(k0Var.j().F0(i10, iM));
                    i10 = i11;
                }
                if (i11 >= iX0) {
                    break;
                }
                iM = i11;
            }
            iM = i10;
        }
        if (iM < k0Var.j().x0()) {
            arrayList.add(k0Var.j().F0(iM, k0Var.j().x0()));
        }
        ArrayList arrayList2 = new ArrayList(t.Y(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((ByteString) it2.next()).O0());
        }
        return arrayList2;
    }
}
