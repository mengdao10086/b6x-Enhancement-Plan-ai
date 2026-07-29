package ur;

import cs.p;
import java.io.IOException;
import java.io.InputStream;
import sr.i;
import sr.l;

/* JADX INFO: loaded from: classes6.dex */
public class f implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f52434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f52435b;

    public f(String str, p pVar) {
        this.f52434a = str;
        this.f52435b = pVar;
    }

    @Override // sr.l
    public i a(sr.e eVar, InputStream inputStream) throws IOException {
        return new sr.a(new d(this.f52434a, this.f52435b), eVar, g.a(inputStream));
    }

    @Override // sr.l
    public i b(InputStream inputStream) throws IOException {
        return new sr.a(new d(this.f52434a, this.f52435b), g.a(inputStream));
    }
}
