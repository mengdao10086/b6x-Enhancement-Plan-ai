package cr;

import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public class m implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f25831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AlgorithmParameterSpec f25832c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zn.b f25833d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f25834e;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f25835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f25836b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public AlgorithmParameterSpec f25837c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public zn.b f25838d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f25839e;

        public b(String str, int i10) {
            this(str, i10, null);
        }

        public b(String str, int i10, byte[] bArr) {
            this.f25835a = str;
            this.f25836b = i10;
            this.f25838d = new zn.b(co.r.f11187r1, new zn.b(kn.d.f37592c));
            this.f25839e = bArr == null ? new byte[0] : org.bouncycastle.util.a.p(bArr);
        }

        public m a() {
            return new m(this.f25835a, this.f25836b, this.f25837c, this.f25838d, this.f25839e);
        }

        public b b(zn.b bVar) {
            this.f25838d = bVar;
            return this;
        }

        public b c(AlgorithmParameterSpec algorithmParameterSpec) {
            this.f25837c = algorithmParameterSpec;
            return this;
        }
    }

    public m(String str, int i10, AlgorithmParameterSpec algorithmParameterSpec, zn.b bVar, byte[] bArr) {
        this.f25830a = str;
        this.f25831b = i10;
        this.f25832c = algorithmParameterSpec;
        this.f25833d = bVar;
        this.f25834e = bArr;
    }

    public zn.b a() {
        return this.f25833d;
    }

    public String b() {
        return this.f25830a;
    }

    public int c() {
        return this.f25831b;
    }

    public byte[] d() {
        return org.bouncycastle.util.a.p(this.f25834e);
    }

    public AlgorithmParameterSpec e() {
        return this.f25832c;
    }
}
