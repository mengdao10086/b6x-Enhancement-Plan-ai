package wi;

import io.objectbox.tree.LeafNode;
import java.nio.charset.StandardCharsets;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@li.b
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LeafNode f54706a;

    public b(LeafNode leafNode) {
        this.f54706a = leafNode;
    }

    @Nullable
    public Double a() {
        String strJ;
        if (m()) {
            return Double.valueOf(e());
        }
        if (n()) {
            return Double.valueOf(g());
        }
        if (!o() || (strJ = j()) == null) {
            return null;
        }
        try {
            return Double.valueOf(strJ);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Nullable
    public Long b() {
        String strJ;
        if (n()) {
            return Long.valueOf(g());
        }
        if (m()) {
            return Long.valueOf((long) e());
        }
        if (!o() || (strJ = j()) == null) {
            return null;
        }
        try {
            return Long.valueOf(strJ);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Nullable
    public String c() {
        String[] strArrK;
        if (o()) {
            return j();
        }
        if (n()) {
            return String.valueOf(g());
        }
        if (m()) {
            return String.valueOf(e());
        }
        if (!p() || (strArrK = k()) == null) {
            return null;
        }
        return a.a(", ", strArrK);
    }

    @Nullable
    public String[] d() {
        if (p()) {
            return k();
        }
        String strC = c();
        if (strC != null) {
            return new String[]{strC};
        }
        return null;
    }

    public double e() {
        u();
        return this.f54706a.f32966e;
    }

    public long f() {
        return this.f54706a.f32962a;
    }

    public long g() {
        v();
        return this.f54706a.f32965d;
    }

    public long h() {
        return this.f54706a.f32964c;
    }

    public long i() {
        return this.f54706a.f32963b;
    }

    @Nullable
    public String j() {
        w();
        Object obj = this.f54706a.f32967f;
        return obj instanceof String ? (String) obj : new String((byte[]) obj, StandardCharsets.UTF_8);
    }

    @Nullable
    public String[] k() {
        x();
        return (String[]) this.f54706a.f32967f;
    }

    public short l() {
        return this.f54706a.f32968g;
    }

    public boolean m() {
        return this.f54706a.f32968g == 8;
    }

    public boolean n() {
        return this.f54706a.f32968g == 6;
    }

    public boolean o() {
        return this.f54706a.f32968g == 23;
    }

    public boolean p() {
        return this.f54706a.f32968g == 24;
    }

    public void q(double d10) {
        u();
        this.f54706a.f32966e = d10;
    }

    public void r(long j10) {
        v();
        this.f54706a.f32965d = j10;
    }

    public void s(@Nullable String str) {
        w();
        this.f54706a.f32967f = str;
    }

    public void t(@Nullable String[] strArr) {
        x();
        this.f54706a.f32967f = strArr;
    }

    public final void u() {
        if (m()) {
            return;
        }
        throw new IllegalStateException("value is not floating point (" + ((int) this.f54706a.f32968g) + ee.a.f26979d);
    }

    public final void v() {
        if (n()) {
            return;
        }
        throw new IllegalStateException("value is not integer (" + ((int) this.f54706a.f32968g) + ee.a.f26979d);
    }

    public final void w() {
        if (o()) {
            return;
        }
        throw new IllegalStateException("value is not string (" + ((int) this.f54706a.f32968g) + ee.a.f26979d);
    }

    public final void x() {
        if (!p()) {
            throw new IllegalStateException("value is not string array");
        }
    }
}
