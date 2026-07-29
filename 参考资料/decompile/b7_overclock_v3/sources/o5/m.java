package o5;

import android.content.SharedPreferences;
import com.blankj.utilcode.util.j1;
import com.tencent.mmkv.MMKV;
import g.n0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, m> f42769b = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MMKV f42770a;

    public m(String str) {
        this(str, 1);
    }

    public static m i() {
        return l("", 1);
    }

    public static m j(int i10) {
        return l("", i10);
    }

    public static m k(String str) {
        return l(str, 1);
    }

    public static m l(String str, int i10) {
        if (u(str)) {
            str = "spUtils";
        }
        Map<String, m> map = f42769b;
        m mVar = map.get(str);
        if (mVar == null) {
            synchronized (m.class) {
                mVar = map.get(str);
                if (mVar == null) {
                    mVar = new m(str, i10);
                    map.put(str, mVar);
                }
            }
        }
        return mVar;
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

    public void A(@n0 String str, long j10, boolean z10) {
        this.f42770a.edit().putLong(str, j10);
    }

    public void B(@n0 String str, String str2) {
        C(str, str2, false);
    }

    public void C(@n0 String str, String str2, boolean z10) {
        this.f42770a.edit().putString(str, str2);
    }

    public void D(@n0 String str, Set<String> set) {
        E(str, set, false);
    }

    public void E(@n0 String str, Set<String> set, boolean z10) {
        this.f42770a.edit().putStringSet(str, set);
    }

    public void F(@n0 String str, boolean z10) {
        G(str, z10, false);
    }

    public void G(@n0 String str, boolean z10, boolean z11) {
        this.f42770a.edit().putBoolean(str, z10);
    }

    public void H(@n0 String str) {
        I(str, false);
    }

    public void I(@n0 String str, boolean z10) {
        this.f42770a.edit().remove(str);
    }

    public void a() {
        b(false);
    }

    public void b(boolean z10) {
        if (this.f42770a.actualSize() > 0) {
            this.f42770a.edit().clear();
        }
    }

    public boolean c(@n0 String str) {
        return this.f42770a.contains(str);
    }

    public Map<String, ?> d() {
        return this.f42770a.getAll();
    }

    public boolean e(@n0 String str) {
        return f(str, false);
    }

    public boolean f(@n0 String str, boolean z10) {
        return this.f42770a.getBoolean(str, z10);
    }

    public float g(@n0 String str) {
        return h(str, -1.0f);
    }

    public float h(@n0 String str, float f10) {
        return this.f42770a.getFloat(str, f10);
    }

    public int m(@n0 String str) {
        return n(str, -1);
    }

    public int n(@n0 String str, int i10) {
        return this.f42770a.getInt(str, i10);
    }

    public long o(@n0 String str) {
        return p(str, -1L);
    }

    public long p(@n0 String str, long j10) {
        return this.f42770a.getLong(str, j10);
    }

    public String q(@n0 String str) {
        return r(str, "");
    }

    public String r(@n0 String str, String str2) {
        return this.f42770a.getString(str, str2);
    }

    public Set<String> s(@n0 String str) {
        return t(str, Collections.emptySet());
    }

    public Set<String> t(@n0 String str, Set<String> set) {
        return this.f42770a.getStringSet(str, set);
    }

    public void v(@n0 String str, float f10) {
        w(str, f10, false);
    }

    public void w(@n0 String str, float f10, boolean z10) {
        this.f42770a.edit().putFloat(str, f10);
    }

    public void x(@n0 String str, int i10) {
        y(str, i10, false);
    }

    public void y(@n0 String str, int i10, boolean z10) {
        this.f42770a.edit().putInt(str, i10);
    }

    public void z(@n0 String str, long j10) {
        A(str, j10, false);
    }

    public m(String str, int i10) {
        MMKV mmkvMmkvWithID = MMKV.mmkvWithID(str, i10);
        this.f42770a = mmkvMmkvWithID;
        try {
            SharedPreferences sharedPreferences = j1.a().getSharedPreferences(str, 0);
            mmkvMmkvWithID.importFromSharedPreferences(sharedPreferences);
            sharedPreferences.edit().clear().apply();
        } catch (Exception unused) {
        }
    }
}
