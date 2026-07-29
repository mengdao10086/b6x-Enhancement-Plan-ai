package f0;

import android.app.Person;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public class f0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f27438g = "name";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f27439h = "icon";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f27440i = "uri";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f27441j = "key";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f27442k = "isBot";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f27443l = "isImportant";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public CharSequence f27444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public IconCompat f27445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public String f27446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public String f27447d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f27448e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f27449f;

    @v0(22)
    public static class a {
        @g.u
        public static f0 a(PersistableBundle persistableBundle) {
            return new c().f(persistableBundle.getString("name")).g(persistableBundle.getString("uri")).e(persistableBundle.getString("key")).b(persistableBundle.getBoolean(f0.f27442k)).d(persistableBundle.getBoolean(f0.f27443l)).a();
        }

        @g.u
        public static PersistableBundle b(f0 f0Var) {
            PersistableBundle persistableBundle = new PersistableBundle();
            CharSequence charSequence = f0Var.f27444a;
            persistableBundle.putString("name", charSequence != null ? charSequence.toString() : null);
            persistableBundle.putString("uri", f0Var.f27446c);
            persistableBundle.putString("key", f0Var.f27447d);
            persistableBundle.putBoolean(f0.f27442k, f0Var.f27448e);
            persistableBundle.putBoolean(f0.f27443l, f0Var.f27449f);
            return persistableBundle;
        }
    }

    @v0(28)
    public static class b {
        @g.u
        public static f0 a(Person person) {
            return new c().f(person.getName()).c(person.getIcon() != null ? IconCompat.n(person.getIcon()) : null).g(person.getUri()).e(person.getKey()).b(person.isBot()).d(person.isImportant()).a();
        }

        @g.u
        public static Person b(f0 f0Var) {
            return new Person.Builder().setName(f0Var.f()).setIcon(f0Var.d() != null ? f0Var.d().M() : null).setUri(f0Var.g()).setKey(f0Var.e()).setBot(f0Var.h()).setImportant(f0Var.i()).build();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public CharSequence f27450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public IconCompat f27451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public String f27452c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public String f27453d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f27454e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f27455f;

        public c() {
        }

        @n0
        public f0 a() {
            return new f0(this);
        }

        @n0
        public c b(boolean z10) {
            this.f27454e = z10;
            return this;
        }

        @n0
        public c c(@p0 IconCompat iconCompat) {
            this.f27451b = iconCompat;
            return this;
        }

        @n0
        public c d(boolean z10) {
            this.f27455f = z10;
            return this;
        }

        @n0
        public c e(@p0 String str) {
            this.f27453d = str;
            return this;
        }

        @n0
        public c f(@p0 CharSequence charSequence) {
            this.f27450a = charSequence;
            return this;
        }

        @n0
        public c g(@p0 String str) {
            this.f27452c = str;
            return this;
        }

        public c(f0 f0Var) {
            this.f27450a = f0Var.f27444a;
            this.f27451b = f0Var.f27445b;
            this.f27452c = f0Var.f27446c;
            this.f27453d = f0Var.f27447d;
            this.f27454e = f0Var.f27448e;
            this.f27455f = f0Var.f27449f;
        }
    }

    public f0(c cVar) {
        this.f27444a = cVar.f27450a;
        this.f27445b = cVar.f27451b;
        this.f27446c = cVar.f27452c;
        this.f27447d = cVar.f27453d;
        this.f27448e = cVar.f27454e;
        this.f27449f = cVar.f27455f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @n0
    @v0(28)
    public static f0 a(@n0 Person person) {
        return b.a(person);
    }

    @n0
    public static f0 b(@n0 Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("icon");
        return new c().f(bundle.getCharSequence("name")).c(bundle2 != null ? IconCompat.l(bundle2) : null).g(bundle.getString("uri")).e(bundle.getString("key")).b(bundle.getBoolean(f27442k)).d(bundle.getBoolean(f27443l)).a();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @n0
    @v0(22)
    public static f0 c(@n0 PersistableBundle persistableBundle) {
        return a.a(persistableBundle);
    }

    @p0
    public IconCompat d() {
        return this.f27445b;
    }

    @p0
    public String e() {
        return this.f27447d;
    }

    @p0
    public CharSequence f() {
        return this.f27444a;
    }

    @p0
    public String g() {
        return this.f27446c;
    }

    public boolean h() {
        return this.f27448e;
    }

    public boolean i() {
        return this.f27449f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @n0
    public String j() {
        String str = this.f27446c;
        if (str != null) {
            return str;
        }
        if (this.f27444a == null) {
            return "";
        }
        return "name:" + ((Object) this.f27444a);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @n0
    @v0(28)
    public Person k() {
        return b.b(this);
    }

    @n0
    public c l() {
        return new c(this);
    }

    @n0
    public Bundle m() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f27444a);
        IconCompat iconCompat = this.f27445b;
        bundle.putBundle("icon", iconCompat != null ? iconCompat.L() : null);
        bundle.putString("uri", this.f27446c);
        bundle.putString("key", this.f27447d);
        bundle.putBoolean(f27442k, this.f27448e);
        bundle.putBoolean(f27443l, this.f27449f);
        return bundle;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @n0
    @v0(22)
    public PersistableBundle n() {
        return a.b(this);
    }
}
