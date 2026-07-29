package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ApplySharedPref"})
public final class w0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, w0> f12021b = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f12022a;

    public w0(String str) {
        this.f12022a = j1.a().getSharedPreferences(str, 0);
    }

    public static w0 i() {
        return l("", 0);
    }

    public static w0 j(int i10) {
        return l("", i10);
    }

    public static w0 k(String str) {
        return l(str, 0);
    }

    public static w0 l(String str, int i10) {
        if (u(str)) {
            str = "spUtils";
        }
        Map<String, w0> map = f12021b;
        w0 w0Var = map.get(str);
        if (w0Var == null) {
            synchronized (w0.class) {
                w0Var = map.get(str);
                if (w0Var == null) {
                    w0Var = new w0(str, i10);
                    map.put(str, w0Var);
                }
            }
        }
        return w0Var;
    }

    public static boolean u(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isWhitespace(str.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public void A(@g.n0 String str, long j10, boolean z10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (z10) {
            this.f12022a.edit().putLong(str, j10).commit();
        } else {
            this.f12022a.edit().putLong(str, j10).apply();
        }
    }

    public void B(@g.n0 String str, String str2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        C(str, str2, false);
    }

    public void C(@g.n0 String str, String str2, boolean z10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (z10) {
            this.f12022a.edit().putString(str, str2).commit();
        } else {
            this.f12022a.edit().putString(str, str2).apply();
        }
    }

    public void D(@g.n0 String str, Set<String> set) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        E(str, set, false);
    }

    public void E(@g.n0 String str, Set<String> set, boolean z10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (z10) {
            this.f12022a.edit().putStringSet(str, set).commit();
        } else {
            this.f12022a.edit().putStringSet(str, set).apply();
        }
    }

    public void F(@g.n0 String str, boolean z10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        G(str, z10, false);
    }

    public void G(@g.n0 String str, boolean z10, boolean z11) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (z11) {
            this.f12022a.edit().putBoolean(str, z10).commit();
        } else {
            this.f12022a.edit().putBoolean(str, z10).apply();
        }
    }

    public void H(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        I(str, false);
    }

    public void I(@g.n0 String str, boolean z10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (z10) {
            this.f12022a.edit().remove(str).commit();
        } else {
            this.f12022a.edit().remove(str).apply();
        }
    }

    public void a() {
        b(false);
    }

    public void b(boolean z10) {
        if (z10) {
            this.f12022a.edit().clear().commit();
        } else {
            this.f12022a.edit().clear().apply();
        }
    }

    public boolean c(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return this.f12022a.contains(str);
    }

    public Map<String, ?> d() {
        return this.f12022a.getAll();
    }

    public boolean e(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return f(str, false);
    }

    public boolean f(@g.n0 String str, boolean z10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return this.f12022a.getBoolean(str, z10);
    }

    public float g(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return h(str, -1.0f);
    }

    public float h(@g.n0 String str, float f10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return this.f12022a.getFloat(str, f10);
    }

    public int m(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return n(str, -1);
    }

    public int n(@g.n0 String str, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return this.f12022a.getInt(str, i10);
    }

    public long o(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return p(str, -1L);
    }

    public long p(@g.n0 String str, long j10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return this.f12022a.getLong(str, j10);
    }

    public String q(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return r(str, "");
    }

    public String r(@g.n0 String str, String str2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return this.f12022a.getString(str, str2);
    }

    public Set<String> s(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return t(str, Collections.emptySet());
    }

    public Set<String> t(@g.n0 String str, Set<String> set) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return this.f12022a.getStringSet(str, set);
    }

    public void v(@g.n0 String str, float f10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        w(str, f10, false);
    }

    public void w(@g.n0 String str, float f10, boolean z10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (z10) {
            this.f12022a.edit().putFloat(str, f10).commit();
        } else {
            this.f12022a.edit().putFloat(str, f10).apply();
        }
    }

    public void x(@g.n0 String str, int i10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        y(str, i10, false);
    }

    public void y(@g.n0 String str, int i10, boolean z10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (z10) {
            this.f12022a.edit().putInt(str, i10).commit();
        } else {
            this.f12022a.edit().putInt(str, i10).apply();
        }
    }

    public void z(@g.n0 String str, long j10) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        A(str, j10, false);
    }

    public w0(String str, int i10) {
        this.f12022a = j1.a().getSharedPreferences(str, i10);
    }
}
