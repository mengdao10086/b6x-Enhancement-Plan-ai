package cr;

import java.math.BigInteger;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;

/* JADX INFO: loaded from: classes5.dex */
public class d extends DHPrivateKeySpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DHParameterSpec f25807a;

    public d(BigInteger bigInteger, DHParameterSpec dHParameterSpec) {
        super(bigInteger, dHParameterSpec.getP(), dHParameterSpec.getG());
        this.f25807a = dHParameterSpec;
    }

    public DHParameterSpec a() {
        return this.f25807a;
    }
}
