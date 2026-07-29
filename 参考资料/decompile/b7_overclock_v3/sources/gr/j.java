package gr;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public class j implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f29952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BigInteger f29953b;

    public j(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f29952a = bigInteger;
        this.f29953b = bigInteger2;
    }

    public BigInteger a() {
        return this.f29953b;
    }

    public BigInteger b() {
        return this.f29952a;
    }
}
