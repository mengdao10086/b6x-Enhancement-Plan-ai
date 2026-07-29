package et;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.pqc.crypto.lms.LMOtsParameters;
import org.bouncycastle.pqc.crypto.lms.LMSigParameters;

/* JADX INFO: loaded from: classes6.dex */
public class d implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LMSigParameters f27135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LMOtsParameters f27136b;

    public d(LMSigParameters lMSigParameters, LMOtsParameters lMOtsParameters) {
        this.f27135a = lMSigParameters;
        this.f27136b = lMOtsParameters;
    }

    public LMOtsParameters a() {
        return this.f27136b;
    }

    public LMSigParameters b() {
        return this.f27135a;
    }
}
