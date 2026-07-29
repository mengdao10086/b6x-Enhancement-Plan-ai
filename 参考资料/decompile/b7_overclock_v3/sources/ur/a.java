package ur;

import com.google.common.net.HttpHeaders;
import cs.d0;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.mime.MimeIOException;
import org.bouncycastle.util.Strings;
import so.n1;
import so.w1;
import so.z;
import sr.m;

/* JADX INFO: loaded from: classes6.dex */
public class a extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f52393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f52394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OutputStream f52395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f52396e;

    public static class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String[] f52397d = {"Content-Type", HttpHeaders.CONTENT_DISPOSITION, "Content-Transfer-Encoding", "Content-Description"};

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String[] f52398e = {"application/pkcs7-mime; name=\"smime.p7m\"; smime-type=enveloped-data", "attachment; filename=\"smime.p7m\"", "base64", "S/MIME Encrypted Message"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z f52399a = new z();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f52400b = new LinkedHashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f52401c = "base64";

        public b() {
            int i10 = 0;
            while (true) {
                String[] strArr = f52397d;
                if (i10 == strArr.length) {
                    return;
                }
                this.f52400b.put(strArr[i10], f52398e[i10]);
                i10++;
            }
        }

        public b c(w1 w1Var) {
            this.f52399a.a(w1Var);
            return this;
        }

        public a d(OutputStream outputStream, d0 d0Var) {
            return new a(this, d0Var, g.b(outputStream));
        }

        public b e(int i10) {
            this.f52399a.k(i10);
            return this;
        }

        public b f(n1 n1Var) {
            this.f52399a.b(n1Var);
            return this;
        }

        public b g(so.d dVar) {
            this.f52399a.c(dVar);
            return this;
        }

        public b h(String str, String str2) {
            this.f52400b.put(str, str2);
            return this;
        }
    }

    public class c extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OutputStream f52402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OutputStream f52403b;

        public c(OutputStream outputStream, OutputStream outputStream2) {
            this.f52402a = outputStream;
            this.f52403b = outputStream2;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f52402a.close();
            OutputStream outputStream = this.f52403b;
            if (outputStream != null) {
                outputStream.close();
            }
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            this.f52402a.write(i10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f52402a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            this.f52402a.write(bArr, i10, i11);
        }
    }

    public a(b bVar, d0 d0Var, OutputStream outputStream) {
        super(new sr.e(m.c(bVar.f52400b), bVar.f52401c));
        this.f52393b = bVar.f52399a;
        this.f52396e = bVar.f52401c;
        this.f52394c = d0Var;
        this.f52395d = outputStream;
    }

    @Override // sr.m
    public OutputStream a() throws IOException {
        this.f50412a.d(this.f52395d);
        this.f52395d.write(Strings.i("\r\n"));
        try {
            OutputStream bVar = this.f52395d;
            if ("base64".equals(this.f52396e)) {
                bVar = new tr.b(bVar);
            }
            return new c(this.f52393b.h(g.c(bVar), this.f52394c), bVar);
        } catch (CMSException e10) {
            throw new MimeIOException(e10.getMessage(), e10);
        }
    }
}
