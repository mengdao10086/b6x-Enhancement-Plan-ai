package wg;

import dj.o;
import dj.r;
import java.util.List;
import xi.z;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f54679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f54680c;

    public class a implements dj.b<StringBuilder, String> {
        public a() {
        }

        @Override // dj.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(StringBuilder sb2, String str) throws Exception {
            if (sb2.length() == 0) {
                sb2.append(str);
            } else {
                sb2.append(", ");
                sb2.append(str);
            }
        }
    }

    /* JADX INFO: renamed from: wg.b$b, reason: collision with other inner class name */
    public class C0636b implements o<b, String> {
        public C0636b() {
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String apply(b bVar) throws Exception {
            return bVar.f54678a;
        }
    }

    public class c implements r<b> {
        public c() {
        }

        @Override // dj.r
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean a(b bVar) throws Exception {
            return bVar.f54679b;
        }
    }

    public class d implements r<b> {
        public d() {
        }

        @Override // dj.r
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean a(b bVar) throws Exception {
            return bVar.f54680c;
        }
    }

    public b(String str, boolean z10) {
        this(str, z10, false);
    }

    public final Boolean a(List<b> list) {
        return z.P2(list).d(new c()).i();
    }

    public final String b(List<b> list) {
        return ((StringBuilder) z.P2(list).A3(new C0636b()).Z(new StringBuilder(), new a()).i()).toString();
    }

    public final Boolean c(List<b> list) {
        return z.P2(list).i(new d()).i();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f54679b == bVar.f54679b && this.f54680c == bVar.f54680c) {
            return this.f54678a.equals(bVar.f54678a);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f54678a.hashCode() * 31) + (this.f54679b ? 1 : 0)) * 31) + (this.f54680c ? 1 : 0);
    }

    public String toString() {
        return "Permission{name='" + this.f54678a + "', granted=" + this.f54679b + ", shouldShowRequestPermissionRationale=" + this.f54680c + '}';
    }

    public b(String str, boolean z10, boolean z11) {
        this.f54678a = str;
        this.f54679b = z10;
        this.f54680c = z11;
    }

    public b(List<b> list) {
        this.f54678a = b(list);
        this.f54679b = a(list).booleanValue();
        this.f54680c = c(list).booleanValue();
    }
}
