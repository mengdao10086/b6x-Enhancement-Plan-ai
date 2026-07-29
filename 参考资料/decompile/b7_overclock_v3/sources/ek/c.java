package ek;

import jt.l;
import kotlin.collections.m;
import kotlin.jvm.internal.t0;
import kotlin.v0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nBase64.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Base64.kt\nkotlin/io/encoding/Base64Kt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,647:1\n13654#2,3:648\n13654#2,3:651\n*S KotlinDebug\n*F\n+ 1 Base64.kt\nkotlin/io/encoding/Base64Kt\n*L\n582#1:648,3\n601#1:651,3\n*E\n"})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final byte[] f27014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public static final int[] f27015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public static final byte[] f27016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public static final int[] f27017d;

    static {
        byte[] bArr = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, l.f36951s, 81, 82, 83, 84, 85, 86, 87, o5.b.f42741j, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, pq.b.f46992i, pq.b.f46991h, pq.b.f46994k, pq.b.f46993j, 114, 115, 116, 117, 118, 119, tc.a.f51065w, 121, 122, l.f36949q, 49, 50, 51, 52, 53, 54, 55, 56, 57, rc.a.f48411c0, 47};
        f27014a = bArr;
        int[] iArr = new int[256];
        int i10 = 0;
        m.u2(iArr, -1, 0, 0, 6, null);
        iArr[61] = -2;
        int length = bArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            iArr[bArr[i11]] = i12;
            i11++;
            i12++;
        }
        f27015b = iArr;
        byte[] bArr2 = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, l.f36951s, 81, 82, 83, 84, 85, 86, 87, o5.b.f42741j, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, pq.b.f46992i, pq.b.f46991h, pq.b.f46994k, pq.b.f46993j, 114, 115, 116, 117, 118, 119, tc.a.f51065w, 121, 122, l.f36949q, 49, 50, 51, 52, 53, 54, 55, 56, 57, rc.a.f48413e0, 95};
        f27016c = bArr2;
        int[] iArr2 = new int[256];
        m.u2(iArr2, -1, 0, 0, 6, null);
        iArr2[61] = -2;
        int length2 = bArr2.length;
        int i13 = 0;
        while (i10 < length2) {
            iArr2[bArr2[i10]] = i13;
            i10++;
            i13++;
        }
        f27017d = iArr2;
    }

    @f
    public static /* synthetic */ void e() {
    }

    public static /* synthetic */ void f() {
    }

    @f
    public static /* synthetic */ void g() {
    }

    public static /* synthetic */ void h() {
    }

    @v0(version = "1.8")
    @f
    public static final boolean i(int i10) {
        return (i10 >= 0 && i10 < f27015b.length) && f27015b[i10] != -1;
    }
}
