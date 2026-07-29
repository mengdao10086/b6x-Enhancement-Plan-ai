package jf;

import com.blankj.utilcode.util.i0;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p001if.b f36364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p001if.b f36365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p001if.c f36366c;

    public b(p001if.b bVar, p001if.b bVar2, p001if.c cVar) {
        this.f36364a = bVar;
        this.f36365b = bVar2;
        this.f36366c = cVar;
    }

    public p001if.c a() {
        return this.f36366c;
    }

    public p001if.b b() {
        return this.f36364a;
    }

    public p001if.b c() {
        return this.f36365b;
    }

    public boolean d() {
        return this.f36365b == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Objects.equals(this.f36364a, bVar.f36364a) && Objects.equals(this.f36365b, bVar.f36365b) && Objects.equals(this.f36366c, bVar.f36366c);
    }

    public int hashCode() {
        return (Objects.hashCode(this.f36364a) ^ Objects.hashCode(this.f36365b)) ^ Objects.hashCode(this.f36366c);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[ ");
        sb2.append(this.f36364a);
        sb2.append(" , ");
        sb2.append(this.f36365b);
        sb2.append(" : ");
        p001if.c cVar = this.f36366c;
        sb2.append(cVar == null ? i0.f11859x : Integer.valueOf(cVar.c()));
        sb2.append(" ]");
        return sb2.toString();
    }
}
