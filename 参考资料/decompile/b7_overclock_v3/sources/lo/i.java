package lo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.cert.X509CertificateHolder;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final X509CertificateHolder[] f40094a = new X509CertificateHolder[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Set f40095b = Collections.unmodifiableSet(new HashSet());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static List f40096c = Collections.unmodifiableList(new ArrayList());

    public static Date a(gm.o oVar) {
        try {
            return oVar.K();
        } catch (Exception e10) {
            throw new IllegalStateException("exception processing GeneralizedTime: " + e10.getMessage());
        }
    }

    public static Set b(z zVar) {
        return zVar == null ? f40095b : Collections.unmodifiableSet(new HashSet(Arrays.asList(zVar.y())));
    }

    public static List c(z zVar) {
        return zVar == null ? f40096c : Collections.unmodifiableList(Arrays.asList(zVar.B()));
    }

    public static Set d(z zVar) {
        return zVar == null ? f40095b : Collections.unmodifiableSet(new HashSet(Arrays.asList(zVar.H())));
    }
}
