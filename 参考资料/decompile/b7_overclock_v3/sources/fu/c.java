package fu;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f28833b;

    public void a(boolean z10) {
        this.f28833b = Boolean.valueOf(z10);
    }

    public boolean b() {
        return this.f28833b != null;
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f28832a, str);
    }

    public void d(String str) {
        this.f28832a = str;
    }

    public boolean e() {
        Boolean bool = this.f28833b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
