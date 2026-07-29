package et;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.pqc.crypto.lms.LMOtsParameters;
import org.bouncycastle.pqc.crypto.lms.LMSigParameters;

/* JADX INFO: loaded from: classes6.dex */
public class c implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LMSigParameters f27133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LMOtsParameters f27134b;

    public c(LMSigParameters lMSigParameters, LMOtsParameters lMOtsParameters) {
        this.f27133a = lMSigParameters;
        this.f27134b = lMOtsParameters;
    }

    public LMOtsParameters a() {
        return this.f27134b;
    }

    public LMSigParameters b() {
        return this.f27133a;
    }
}
