package af;

import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<byte[]> f592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f593e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f594f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f595g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f596h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f597i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f598j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f599k;

    public d(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1, 0);
    }

    public List<byte[]> a() {
        return this.f592d;
    }

    public String b() {
        return this.f593e;
    }

    public Integer c() {
        return this.f595g;
    }

    public Integer d() {
        return this.f594f;
    }

    public int e() {
        return this.f590b;
    }

    public Object f() {
        return this.f596h;
    }

    public byte[] g() {
        return this.f589a;
    }

    public int h() {
        return this.f597i;
    }

    public int i() {
        return this.f598j;
    }

    public int j() {
        return this.f599k;
    }

    public String k() {
        return this.f591c;
    }

    public boolean l() {
        return this.f597i >= 0 && this.f598j >= 0;
    }

    public void m(Integer num) {
        this.f595g = num;
    }

    public void n(Integer num) {
        this.f594f = num;
    }

    public void o(int i10) {
        this.f590b = i10;
    }

    public void p(Object obj) {
        this.f596h = obj;
    }

    public d(byte[] bArr, String str, List<byte[]> list, String str2, int i10) {
        this(bArr, str, list, str2, -1, -1, i10);
    }

    public d(byte[] bArr, String str, List<byte[]> list, String str2, int i10, int i11) {
        this(bArr, str, list, str2, i10, i11, 0);
    }

    public d(byte[] bArr, String str, List<byte[]> list, String str2, int i10, int i11, int i12) {
        this.f589a = bArr;
        this.f590b = bArr == null ? 0 : bArr.length * 8;
        this.f591c = str;
        this.f592d = list;
        this.f593e = str2;
        this.f597i = i11;
        this.f598j = i10;
        this.f599k = i12;
    }
}
