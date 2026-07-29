package fd;

import g.p0;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class g implements Comparable<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f28054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f28055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f28056c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f28057d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final File f28058e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f28059f;

    public g(String str, long j10, long j11) {
        this(str, j10, j11, ya.g.f56663b, null);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(g gVar) {
        if (!this.f28054a.equals(gVar.f28054a)) {
            return this.f28054a.compareTo(gVar.f28054a);
        }
        long j10 = this.f28055b - gVar.f28055b;
        if (j10 == 0) {
            return 0;
        }
        return j10 < 0 ? -1 : 1;
    }

    public boolean d() {
        return !this.f28057d;
    }

    public boolean e() {
        return this.f28056c == -1;
    }

    public String toString() {
        return "[" + this.f28055b + ", " + this.f28056c + "]";
    }

    public g(String str, long j10, long j11, long j12, @p0 File file) {
        this.f28054a = str;
        this.f28055b = j10;
        this.f28056c = j11;
        this.f28057d = file != null;
        this.f28058e = file;
        this.f28059f = j12;
    }
}
