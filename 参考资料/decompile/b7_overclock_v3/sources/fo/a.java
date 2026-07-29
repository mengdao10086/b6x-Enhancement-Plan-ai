package fo;

import gm.j;
import gm.w;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.cert.cmp.CMPRuntimeException;

/* JADX INFO: loaded from: classes5.dex */
public class a {
    public static void a(w wVar, OutputStream outputStream) {
        try {
            wVar.u(outputStream, j.f29713a);
            outputStream.close();
        } catch (IOException e10) {
            throw new CMPRuntimeException("unable to DER encode object: " + e10.getMessage(), e10);
        }
    }
}
