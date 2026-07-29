package fh;

import com.google.common.net.HttpHeaders;
import com.upyun.library.exception.RespException;
import com.upyun.library.exception.UpYunException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.d0;

/* JADX INFO: loaded from: classes5.dex */
public class i extends a {
    public i(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    @Override // fh.a
    public d0 c() throws UpYunException, IOException {
        d0 d0VarB = b();
        this.f28360g = null;
        if (!d0VarB.k1()) {
            throw new RespException(d0VarB.W(), d0VarB.L().string());
        }
        this.f28354a = 0;
        return d0VarB;
    }

    @Override // fh.a
    public d0 i() throws UpYunException, IOException {
        while (this.f28354a >= 0) {
            if (this.f28358e) {
                throw new UpYunException("upload paused");
            }
            byte[] bArrJ = j(this.f28354a);
            c0 c0VarH = c0.h(null, bArrJ);
            String strI = this.f28365l ? hh.c.i(bArrJ) : null;
            if (!this.f28359f) {
                String strD = d();
                this.f28373t = strD;
                this.f28374u = hh.c.k("PUT", strD, this.f28361h, this.f28367n, this.f28368o, strI).trim();
            }
            b0.a aVarS = new b0.a().B(this.f28370q).n(HttpHeaders.DATE, this.f28373t).n("Authorization", this.f28374u).n(a.D, "upload").n(a.G, this.f28360g).n(a.H, this.f28354a + "").n("User-Agent", hh.c.f31296b).s(c0VarH);
            Map<String, String> map = this.f28357d;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    aVarS.n(entry.getKey(), entry.getValue());
                }
            }
            if (strI != null) {
                aVarS.n("Content-MD5", strI);
            }
            gh.c cVar = this.f28371r;
            if (cVar != null) {
                cVar.a(this.f28354a + 2, this.f28372s);
            }
            v(aVarS.b());
        }
        return c();
    }

    @Override // fh.a
    public void o(String str) {
        this.f28360g = str;
    }

    @Override // fh.a
    public d0 q(File file, String str, String str2, String str3, Map<String, String> map) throws UpYunException, IOException {
        f(file, str, str2, str3, map);
        return p();
    }

    @Override // fh.a
    public d0 r(File file, String str, Map<String, String> map) throws UpYunException, IOException {
        g(file, str, map);
        return p();
    }

    public final void v(b0 b0Var) throws UpYunException, IOException {
        d0 d0VarX = this.f28362i.a(b0Var).X();
        if (d0VarX.k1()) {
            this.f28360g = d0VarX.G0(a.G, "");
            this.f28354a = Integer.parseInt(d0VarX.G0(a.I, "-2"));
            return;
        }
        RandomAccessFile randomAccessFile = this.f28364k;
        if (randomAccessFile != null) {
            randomAccessFile.close();
            this.f28364k = null;
        }
        this.f28360g = null;
        throw new RespException(d0VarX.W(), d0VarX.L().string());
    }

    public int w() {
        return this.f28354a;
    }

    public d0 x(String str, int i10) throws UpYunException, IOException {
        this.f28360g = str;
        this.f28354a = i10;
        if (str == null) {
            throw new UpYunException("uuid is null, please restart!");
        }
        this.f28358e = false;
        return p();
    }

    public void y(int i10) {
        this.f28354a = i10;
    }

    public i() {
    }
}
