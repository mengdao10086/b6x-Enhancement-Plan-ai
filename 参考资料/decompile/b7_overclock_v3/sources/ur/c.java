package ur;

import cs.o;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.operator.OperatorCreationException;
import sr.h;
import sr.j;

/* JADX INFO: loaded from: classes6.dex */
public class c implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f52426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o[] f52427b;

    public class a implements sr.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f52428a;

        public a(int i10) {
            this.f52428a = i10;
        }

        @Override // sr.g
        public InputStream b(sr.e eVar, InputStream inputStream) throws IOException {
            if (this.f52428a != 0) {
                return inputStream;
            }
            OutputStream outputStreamF = c.this.f();
            eVar.d(outputStreamF);
            outputStreamF.write(13);
            outputStreamF.write(10);
            return new kt.d(inputStream, new sr.c(c.this.f52426a, eVar, outputStreamF));
        }
    }

    public c(j jVar, sr.e eVar) {
        this.f52426a = (d) jVar;
        this.f52427b = d(eVar);
    }

    @Override // sr.h
    public sr.g a(int i10) throws IOException {
        return new a(i10);
    }

    @Override // sr.g
    public InputStream b(sr.e eVar, InputStream inputStream) throws IOException {
        return inputStream;
    }

    public final o[] d(sr.e eVar) {
        try {
            String str = eVar.i().get("micalg");
            if (str == null) {
                throw new IllegalStateException("No micalg field on content-type header");
            }
            String[] strArrSplit = str.substring(str.indexOf(61) + 1).split(ag.c.f654g);
            o[] oVarArr = new o[strArrSplit.length];
            for (int i10 = 0; i10 < strArrSplit.length; i10++) {
                oVarArr[i10] = this.f52426a.b().a(new zn.b(g.d(g.f(strArrSplit[i10]).trim())));
            }
            return oVarArr;
        } catch (OperatorCreationException unused) {
            return null;
        }
    }

    public o[] e() {
        return this.f52427b;
    }

    public OutputStream f() {
        o[] oVarArr = this.f52427b;
        int i10 = 1;
        if (oVarArr.length == 1) {
            return oVarArr[0].b();
        }
        OutputStream outputStreamB = oVarArr[0].b();
        while (i10 < this.f52427b.length) {
            kt.e eVar = new kt.e(this.f52427b[i10].b(), outputStreamB);
            i10++;
            outputStreamB = eVar;
        }
        return outputStreamB;
    }
}
