package ur;

import cs.o;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.mime.MimeIOException;
import org.bouncycastle.util.s;
import so.e2;
import so.l0;
import so.n1;
import so.y;
import so.y1;
import sr.j;
import sr.k;

/* JADX INFO: loaded from: classes6.dex */
public abstract class e implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o[] f52432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f52433b;

    @Override // sr.k
    public void a(j jVar, sr.e eVar, InputStream inputStream) throws IOException {
        try {
            if (!eVar.g().equals("application/pkcs7-signature") && !eVar.g().equals("application/x-pkcs7-signature")) {
                if (!eVar.g().equals("application/pkcs7-mime") && !eVar.g().equals("application/x-pkcs7-mime")) {
                    c(jVar, eVar, inputStream);
                    return;
                }
                y yVar = new y(inputStream);
                d(jVar, eVar, yVar.f(), yVar.g());
                yVar.a();
                return;
            }
            HashMap map = new HashMap();
            int i10 = 0;
            while (true) {
                o[] oVarArr = this.f52432a;
                if (i10 == oVarArr.length) {
                    l0 l0Var = new l0(map, kt.c.e(inputStream));
                    e(jVar, eVar, l0Var.d(), l0Var.c(), l0Var.b(), l0Var.k());
                    return;
                } else {
                    oVarArr[i10].b().close();
                    map.put(this.f52432a[i10].a().x(), this.f52432a[i10].c());
                    i10++;
                }
            }
        } catch (CMSException e10) {
            throw new MimeIOException("CMS failure: " + e10.getMessage(), e10);
        }
    }

    @Override // sr.k
    public sr.g b(j jVar, sr.e eVar) {
        if (!eVar.m()) {
            return new sr.d();
        }
        c cVar = new c(jVar, eVar);
        this.f52433b = cVar;
        this.f52432a = cVar.e();
        return this.f52433b;
    }

    public void c(j jVar, sr.e eVar, InputStream inputStream) throws IOException {
        throw new IllegalStateException("content handling not implemented");
    }

    public void d(j jVar, sr.e eVar, n1 n1Var, y1 y1Var) throws CMSException, IOException {
        throw new IllegalStateException("envelopedData handling not implemented");
    }

    public void e(j jVar, sr.e eVar, s sVar, s sVar2, s sVar3, e2 e2Var) throws CMSException, IOException {
        throw new IllegalStateException("signedData handling not implemented");
    }
}
