package no;

import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.cert.path.CertPathValidationException;
import org.bouncycastle.util.j;

/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f42320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f42321b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Integer> f42322c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<CertPathValidationException> f42323d = new ArrayList();

    public f(d dVar) {
        this.f42320a = dVar;
    }

    public void a(int i10, int i11, CertPathValidationException certPathValidationException) {
        this.f42321b.add(j.g(i10));
        this.f42322c.add(j.g(i11));
        this.f42323d.add(certPathValidationException);
    }

    public e b() {
        if (this.f42323d.isEmpty()) {
            return new e(this.f42320a);
        }
        d dVar = this.f42320a;
        int[] iArrC = c(this.f42321b);
        int[] iArrC2 = c(this.f42322c);
        List<CertPathValidationException> list = this.f42323d;
        return new e(dVar, iArrC, iArrC2, (CertPathValidationException[]) list.toArray(new CertPathValidationException[list.size()]));
    }

    public final int[] c(List<Integer> list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i10 = 0; i10 != size; i10++) {
            iArr[i10] = list.get(i10).intValue();
        }
        return iArr;
    }
}
