package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class n30 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CharSequence f6869a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1997a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f1998a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1999a;
    public CharSequence b;

    public n30() {
    }

    public n30(String str, String str2) {
        f92.d(str, "title");
        f92.d(str2, "value");
        this.f6869a = str;
        this.f1998a = str2;
    }

    public final CharSequence a() {
        return this.b;
    }

    public final Object b() {
        return this.f1997a;
    }

    public final boolean c() {
        return this.f1999a;
    }

    public final CharSequence d() {
        return this.f6869a;
    }

    public final String e() {
        return this.f1998a;
    }

    public final void f(CharSequence charSequence) {
        this.b = charSequence;
    }

    public final void g(Object obj) {
        this.f1997a = obj;
    }

    public final void h(boolean z) {
        this.f1999a = z;
    }

    public final void i(CharSequence charSequence) {
        this.f6869a = charSequence;
    }

    public final void j(String str) {
        this.f1998a = str;
    }

    public String toString() {
        CharSequence charSequence = this.f6869a;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = this.f6869a;
            f92.b(charSequence2);
            return charSequence2.toString();
        }
        String str = this.f1998a;
        if (str == null || str.length() == 0) {
            return "";
        }
        String str2 = this.f1998a;
        f92.b(str2);
        return str2;
    }
}
