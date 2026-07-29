package ar;

import java.security.AlgorithmParameters;
import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes5.dex */
public class i {
    public static AlgorithmParameterSpec a(AlgorithmParameters algorithmParameters, Class[] clsArr) {
        try {
            return algorithmParameters.getParameterSpec(AlgorithmParameterSpec.class);
        } catch (Exception unused) {
            for (int i10 = 0; i10 != clsArr.length; i10++) {
                if (clsArr[i10] != null) {
                    try {
                        return algorithmParameters.getParameterSpec(clsArr[i10]);
                    } catch (Exception unused2) {
                        continue;
                    }
                }
            }
            return null;
        }
    }
}
