package hi;

import com.android.org.conscrypt.Conscrypt;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes5.dex */
public class a {
    public static byte[] a(SSLSocket sSLSocket, String str, byte[] bArr, int i10) throws SSLException {
        return Conscrypt.exportKeyingMaterial(sSLSocket, str, bArr, i10);
    }
}
