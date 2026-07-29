package lt;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes6.dex */
public class f extends BufferedWriter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f40454c = 64;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f40455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public char[] f40456b;

    public f(Writer writer) {
        super(writer);
        this.f40456b = new char[64];
        String strE = Strings.e();
        this.f40455a = strE != null ? strE.length() : 2;
    }

    public int a(b bVar) {
        int length = ((bVar.c().length() + 10 + this.f40455a) * 2) + 6 + 4;
        if (!bVar.b().isEmpty()) {
            for (a aVar : bVar.b()) {
                length += aVar.b().length() + 2 + aVar.c().length() + this.f40455a;
            }
            length += this.f40455a;
        }
        return length + (((bVar.a().length + 2) / 3) * 4) + ((((r5 + 64) - 1) / 64) * this.f40455a);
    }

    public final void c(byte[] bArr) throws IOException {
        char[] cArr;
        int i10;
        byte[] bArrG = jt.c.g(bArr);
        int length = 0;
        while (length < bArrG.length) {
            int i11 = 0;
            while (true) {
                cArr = this.f40456b;
                if (i11 == cArr.length || (i10 = length + i11) >= bArrG.length) {
                    break;
                }
                cArr[i11] = (char) bArrG[i10];
                i11++;
            }
            write(cArr, 0, i11);
            newLine();
            length += this.f40456b.length;
        }
    }

    public void d(c cVar) throws IOException {
        b bVarGenerate = cVar.generate();
        h(bVarGenerate.c());
        if (!bVarGenerate.b().isEmpty()) {
            for (a aVar : bVarGenerate.b()) {
                write(aVar.b());
                write(": ");
                write(aVar.c());
                newLine();
            }
            newLine();
        }
        c(bVarGenerate.a());
        f(bVarGenerate.c());
    }

    public final void f(String str) throws IOException {
        write(e.f40453b + str + "-----");
        newLine();
    }

    public final void h(String str) throws IOException {
        write(e.f40452a + str + "-----");
        newLine();
    }
}
