package fh;

import com.google.common.net.HttpHeaders;
import com.upyun.library.exception.RespException;
import com.upyun.library.exception.UpYunException;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.d0;

/* JADX INFO: loaded from: classes5.dex */
public class d extends fh.a {
    public volatile int K;
    public int L;
    public int[] M;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f28442a;

        public a(int i10) {
            this.f28442a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (d.this.f28358e) {
                    throw new UpYunException("upload paused");
                }
                if (d.this.M[this.f28442a] == 1) {
                    gh.c cVar = d.this.f28371r;
                    if (cVar != null) {
                        cVar.a(r0.K + 2, d.this.f28372s);
                    }
                    d.x(d.this);
                    return;
                }
                if (d.this.M[this.f28442a] == 2) {
                    return;
                }
                int[] iArr = d.this.M;
                int i10 = this.f28442a;
                iArr[i10] = 2;
                byte[] bArrJ = d.this.j(i10);
                c0 c0VarH = c0.h(null, bArrJ);
                String strI = d.this.f28365l ? hh.c.i(bArrJ) : null;
                d dVar = d.this;
                if (!dVar.f28359f) {
                    dVar.f28373t = dVar.d();
                    d dVar2 = d.this;
                    dVar2.f28374u = hh.c.k("PUT", dVar2.f28373t, dVar2.f28361h, dVar2.f28367n, dVar2.f28368o, strI).trim();
                }
                b0.a aVarS = new b0.a().B(d.this.f28370q).n(HttpHeaders.DATE, d.this.f28373t).n("Authorization", d.this.f28374u).n(fh.a.D, "upload").n(fh.a.G, d.this.f28360g).n(fh.a.H, this.f28442a + "").n("User-Agent", hh.c.f31296b).s(c0VarH);
                Map<String, String> map = d.this.f28357d;
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        aVarS.n(entry.getKey(), entry.getValue());
                    }
                }
                if (strI != null) {
                    aVarS.n("Content-MD5", strI);
                }
                d.this.f28360g = d.this.E(aVarS).G0(fh.a.G, "");
                d.this.M[this.f28442a] = 1;
            } catch (Exception e10) {
                d.this.M[this.f28442a] = 3;
                throw new RuntimeException(e10.getMessage());
            }
        }
    }

    public d(String str, String str2, String str3) {
        super(str, str2, str3);
        this.L = 4;
    }

    public static /* synthetic */ int x(d dVar) {
        int i10 = dVar.K;
        dVar.K = i10 + 1;
        return i10;
    }

    public d0 A(String str, int[] iArr) throws UpYunException, IOException {
        this.f28360g = str;
        this.M = iArr;
        if (str == null || iArr == null || iArr.length != this.f28372s - 2) {
            throw new UpYunException("uuid or status is wrong, please restart!");
        }
        this.f28358e = false;
        return p();
    }

    public void B(int i10) {
        this.L = i10;
    }

    public void C(int[] iArr) {
        this.M = iArr;
    }

    public final Runnable D(int i10) {
        return new a(i10);
    }

    public final d0 E(b0.a aVar) throws UpYunException {
        try {
            d0 d0VarX = this.f28362i.a(aVar.b()).X();
            if (!d0VarX.k1()) {
                this.f28360g = null;
                throw new RespException(d0VarX.W(), d0VarX.L().string());
            }
            gh.c cVar = this.f28371r;
            if (cVar != null) {
                cVar.a(this.K + 2, this.f28372s);
            }
            this.K++;
            return d0VarX;
        } catch (IOException e10) {
            throw new UpYunException(e10.toString());
        }
    }

    @Override // fh.a
    public d0 c() throws UpYunException, IOException {
        d0 d0VarB = b();
        this.M = null;
        this.f28360g = null;
        if (d0VarB.k1()) {
            return d0VarB;
        }
        throw new RespException(d0VarB.W(), d0VarB.L().string());
    }

    @Override // fh.a
    public d0 i() throws UpYunException, IOException {
        this.K = 0;
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(this.L);
        for (int i10 = 0; i10 < this.f28372s - 2; i10++) {
            try {
                executorServiceNewFixedThreadPool.submit(D(i10)).get();
            } catch (Exception e10) {
                executorServiceNewFixedThreadPool.shutdown();
                if (this.f28364k != null) {
                    this.f28364k.close();
                    this.f28364k = null;
                }
                throw new UpYunException(e10.getMessage());
            }
        }
        executorServiceNewFixedThreadPool.shutdown();
        try {
            executorServiceNewFixedThreadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);
        } catch (InterruptedException e11) {
            e11.printStackTrace();
        }
        return c();
    }

    @Override // fh.a
    public void n(int i10) {
        this.f28369p = i10;
    }

    @Override // fh.a
    public d0 q(File file, String str, String str2, String str3, Map<String, String> map) throws UpYunException, IOException {
        f(file, str, str2, str3, map);
        int[] iArr = this.M;
        if (iArr == null || iArr.length != this.f28372s - 2 || this.f28360g == null) {
            this.M = new int[this.f28372s - 2];
        }
        this.f28357d.put(fh.a.C, "true");
        return p();
    }

    @Override // fh.a
    public d0 r(File file, String str, Map<String, String> map) throws UpYunException, IOException {
        g(file, str, map);
        int[] iArr = this.M;
        if (iArr == null || iArr.length != this.f28372s - 2 || this.f28360g == null) {
            this.M = new int[this.f28372s - 2];
        }
        this.f28357d.put(fh.a.C, "true");
        return p();
    }

    public int[] z() {
        return this.M;
    }

    public d() {
        this.L = 4;
    }
}
