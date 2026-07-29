package go;

import gm.w;
import gm.y;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.cert.crmf.CRMFRuntimeException;
import zn.a0;

/* JADX INFO: loaded from: classes5.dex */
public class b {
    public static void a(a0 a0Var, y yVar, boolean z10, gm.h hVar) throws CertIOException {
        try {
            a0Var.a(yVar, z10, hVar);
        } catch (IOException e10) {
            throw new CertIOException("cannot encode extension: " + e10.getMessage(), e10);
        }
    }

    public static void b(w wVar, OutputStream outputStream) {
        try {
            wVar.u(outputStream, gm.j.f29713a);
            outputStream.close();
        } catch (IOException e10) {
            throw new CRMFRuntimeException("unable to DER encode object: " + e10.getMessage(), e10);
        }
    }
}
