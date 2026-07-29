package cc;

import com.google.android.exoplayer2.offline.DownloadRequest;
import g.j1;
import g.p0;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: cc.a$a, reason: collision with other inner class name */
    public interface InterfaceC0108a {
        String a(DownloadRequest downloadRequest);
    }

    public static void a(DownloadRequest downloadRequest, com.google.android.exoplayer2.offline.b bVar, boolean z10, long j10) throws Exception {
        c cVar;
        c cVarF = bVar.f(downloadRequest.f17407a);
        if (cVarF != null) {
            cVar = p.r(cVarF, downloadRequest, cVarF.f10716f, j10);
        } else {
            cVar = new c(downloadRequest, z10 ? 3 : 0, j10, j10, -1L, 0, 0);
        }
        bVar.d(cVar);
    }

    @j1
    public static void b(File file, @p0 InterfaceC0108a interfaceC0108a, com.google.android.exoplayer2.offline.b bVar, boolean z10, boolean z11) throws IOException {
        com.google.android.exoplayer2.offline.a aVar = new com.google.android.exoplayer2.offline.a(file);
        if (aVar.b()) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (DownloadRequest downloadRequestA : aVar.e()) {
                    if (interfaceC0108a != null) {
                        downloadRequestA = downloadRequestA.a(interfaceC0108a.a(downloadRequestA));
                    }
                    a(downloadRequestA, bVar, z11, jCurrentTimeMillis);
                }
                aVar.a();
            } catch (Throwable th2) {
                if (z10) {
                    aVar.a();
                }
                throw th2;
            }
        }
    }
}
