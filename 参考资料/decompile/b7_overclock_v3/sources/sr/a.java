package sr;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f50384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f50385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f50386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f50387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f50388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f50389f;

    public a(InputStream inputStream) throws IOException {
        this(null, new e(inputStream, "7bit"), inputStream);
    }

    public a(e eVar, InputStream inputStream) {
        this(null, eVar, inputStream);
    }

    public a(j jVar, InputStream inputStream) throws IOException {
        this(jVar, new e(inputStream, jVar.a()), inputStream);
    }

    public a(j jVar, e eVar, InputStream inputStream) {
        String strE;
        this.f50388e = false;
        if (eVar.m()) {
            this.f50388e = true;
            strE = eVar.e();
        } else {
            strE = null;
        }
        this.f50389f = strE;
        this.f50387d = eVar;
        this.f50385b = jVar;
        this.f50384a = inputStream;
        this.f50386c = jVar != null ? jVar.a() : "7bit";
    }

    @Override // sr.i
    public void a(k kVar) throws IOException {
        g gVarB = kVar.b(this.f50385b, this.f50387d);
        if (!this.f50388e) {
            InputStream inputStreamB = gVarB.b(this.f50387d, this.f50384a);
            j jVar = this.f50385b;
            e eVar = this.f50387d;
            kVar.a(jVar, eVar, c(eVar, inputStreamB));
            return;
        }
        h hVar = (h) gVarB;
        String str = "--" + this.f50389f;
        f fVar = new f(this.f50384a);
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            String strA = fVar.a();
            if (strA == null || "--".equals(strA)) {
                return;
            }
            if (z10) {
                b bVar = new b(this.f50384a, this.f50389f);
                e eVar2 = new e(bVar, this.f50386c);
                int i11 = i10 + 1;
                InputStream inputStreamB2 = hVar.a(i10).b(eVar2, bVar);
                kVar.a(this.f50385b, eVar2, c(eVar2, inputStreamB2));
                if (inputStreamB2.read() >= 0) {
                    throw new IOException("MIME object not fully processed");
                }
                i10 = i11;
            } else if (str.equals(strA)) {
                b bVar2 = new b(this.f50384a, this.f50389f);
                e eVar3 = new e(bVar2, this.f50386c);
                int i12 = i10 + 1;
                InputStream inputStreamB3 = hVar.a(i10).b(eVar3, bVar2);
                kVar.a(this.f50385b, eVar3, c(eVar3, inputStreamB3));
                if (inputStreamB3.read() >= 0) {
                    throw new IOException("MIME object not fully processed");
                }
                z10 = true;
                i10 = i12;
            } else {
                continue;
            }
        }
    }

    public boolean b() {
        return this.f50388e;
    }

    public final InputStream c(e eVar, InputStream inputStream) {
        return eVar.f().equals("base64") ? new tr.a(inputStream) : eVar.f().equals("quoted-printable") ? new tr.c(inputStream) : inputStream;
    }
}
