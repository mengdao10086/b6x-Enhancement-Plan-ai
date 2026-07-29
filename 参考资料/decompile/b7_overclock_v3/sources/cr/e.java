package cr;

import java.math.BigInteger;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;

/* JADX INFO: loaded from: classes5.dex */
public class e extends DHPublicKeySpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DHParameterSpec f25808a;

    public e(BigInteger bigInteger, DHParameterSpec dHParameterSpec) {
        super(bigInteger, dHParameterSpec.getP(), dHParameterSpec.getG());
        this.f25808a = dHParameterSpec;
    }

    public DHParameterSpec a() {
        return this.f25808a;
    }
}
