package so;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import org.bouncycastle.cms.CMSException;

/* JADX INFO: loaded from: classes5.dex */
public class o1 implements r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.y f50250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.h f50251b;

    public o1(gm.y yVar, gm.h hVar) {
        this.f50250a = yVar;
        this.f50251b = hVar;
    }

    @Override // so.r0
    public gm.y a() {
        return this.f50250a;
    }

    @Override // so.d0
    public Object b() {
        return this.f50251b;
    }

    @Override // so.d0
    public void d(OutputStream outputStream) throws CMSException, IOException {
        gm.h hVar = this.f50251b;
        if (hVar instanceof gm.f0) {
            Iterator<gm.h> it2 = gm.f0.J(hVar).iterator();
            while (it2.hasNext()) {
                outputStream.write(it2.next().b().v(gm.j.f29713a));
            }
        } else {
            byte[] bArrV = hVar.b().v(gm.j.f29713a);
            int i10 = 1;
            while ((bArrV[i10] & 255) > 127) {
                i10++;
            }
            int i11 = i10 + 1;
            outputStream.write(bArrV, i11, bArrV.length - i11);
        }
    }
}
