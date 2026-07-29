package i0;

import android.annotation.SuppressLint;
import android.app.Person;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.o;
import f0.f0;
import g.i1;
import g.n0;
import g.p0;
import g.v0;
import h0.c0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static final String C = "extraPersonCount";
    public static final String D = "extraPerson_";
    public static final String E = "extraLocusId";
    public static final String F = "extraLongLived";
    public static final String G = "extraSliceUri";
    public static final int H = 1;
    public int A;
    public int B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f31497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f31498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f31499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Intent[] f31500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ComponentName f31501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f31502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CharSequence f31503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f31504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IconCompat f31505i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f31506j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f0[] f31507k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Set<String> f31508l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public c0 f31509m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f31510n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f31511o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public PersistableBundle f31512p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Bundle f31513q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f31514r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public UserHandle f31515s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f31516t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f31517u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f31518v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f31519w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f31520x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f31521y = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f31522z;

    @v0(33)
    public static class a {
        public static void a(@n0 ShortcutInfo.Builder builder, int i10) {
            builder.setExcludedFromSurfaces(i10);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface c {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @v0(25)
    public static List<e> c(@n0 Context context, @n0 List<ShortcutInfo> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<ShortcutInfo> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(new b(context, it2.next()).c());
        }
        return arrayList;
    }

    @p0
    @v0(25)
    public static c0 p(@n0 ShortcutInfo shortcutInfo) {
        if (Build.VERSION.SDK_INT < 29) {
            return q(shortcutInfo.getExtras());
        }
        if (shortcutInfo.getLocusId() == null) {
            return null;
        }
        return c0.d(shortcutInfo.getLocusId());
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @v0(25)
    public static c0 q(@p0 PersistableBundle persistableBundle) {
        String string;
        if (persistableBundle == null || (string = persistableBundle.getString(E)) == null) {
            return null;
        }
        return new c0(string);
    }

    @i1
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @v0(25)
    public static boolean s(@p0 PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey(F)) {
            return false;
        }
        return persistableBundle.getBoolean(F);
    }

    @i1
    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @v0(25)
    public static f0[] u(@n0 PersistableBundle persistableBundle) {
        if (persistableBundle == null || !persistableBundle.containsKey(C)) {
            return null;
        }
        int i10 = persistableBundle.getInt(C);
        f0[] f0VarArr = new f0[i10];
        int i11 = 0;
        while (i11 < i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(D);
            int i12 = i11 + 1;
            sb2.append(i12);
            f0VarArr[i11] = f0.c(persistableBundle.getPersistableBundle(sb2.toString()));
            i11 = i12;
        }
        return f0VarArr;
    }

    public boolean A() {
        return this.f31516t;
    }

    public boolean B() {
        return this.f31519w;
    }

    public boolean C() {
        return this.f31517u;
    }

    public boolean D() {
        return this.f31521y;
    }

    public boolean E(int i10) {
        return (i10 & this.B) != 0;
    }

    public boolean F() {
        return this.f31520x;
    }

    public boolean G() {
        return this.f31518v;
    }

    @v0(25)
    public ShortcutInfo H() {
        ShortcutInfo.Builder intents = new ShortcutInfo.Builder(this.f31497a, this.f31498b).setShortLabel(this.f31502f).setIntents(this.f31500d);
        IconCompat iconCompat = this.f31505i;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.N(this.f31497a));
        }
        if (!TextUtils.isEmpty(this.f31503g)) {
            intents.setLongLabel(this.f31503g);
        }
        if (!TextUtils.isEmpty(this.f31504h)) {
            intents.setDisabledMessage(this.f31504h);
        }
        ComponentName componentName = this.f31501e;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        Set<String> set = this.f31508l;
        if (set != null) {
            intents.setCategories(set);
        }
        intents.setRank(this.f31511o);
        PersistableBundle persistableBundle = this.f31512p;
        if (persistableBundle != null) {
            intents.setExtras(persistableBundle);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            f0[] f0VarArr = this.f31507k;
            if (f0VarArr != null && f0VarArr.length > 0) {
                int length = f0VarArr.length;
                Person[] personArr = new Person[length];
                for (int i10 = 0; i10 < length; i10++) {
                    personArr[i10] = this.f31507k[i10].k();
                }
                intents.setPersons(personArr);
            }
            c0 c0Var = this.f31509m;
            if (c0Var != null) {
                intents.setLocusId(c0Var.c());
            }
            intents.setLongLived(this.f31510n);
        } else {
            intents.setExtras(b());
        }
        if (Build.VERSION.SDK_INT >= 33) {
            a.a(intents, this.B);
        }
        return intents.build();
    }

    public Intent a(Intent intent) {
        intent.putExtra("android.intent.extra.shortcut.INTENT", this.f31500d[r0.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.f31502f.toString());
        if (this.f31505i != null) {
            Drawable activityIcon = null;
            if (this.f31506j) {
                PackageManager packageManager = this.f31497a.getPackageManager();
                ComponentName componentName = this.f31501e;
                if (componentName != null) {
                    try {
                        activityIcon = packageManager.getActivityIcon(componentName);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                if (activityIcon == null) {
                    activityIcon = this.f31497a.getApplicationInfo().loadIcon(packageManager);
                }
            }
            this.f31505i.j(intent, activityIcon, this.f31497a);
        }
        return intent;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @v0(22)
    public final PersistableBundle b() {
        if (this.f31512p == null) {
            this.f31512p = new PersistableBundle();
        }
        f0[] f0VarArr = this.f31507k;
        if (f0VarArr != null && f0VarArr.length > 0) {
            this.f31512p.putInt(C, f0VarArr.length);
            int i10 = 0;
            while (i10 < this.f31507k.length) {
                PersistableBundle persistableBundle = this.f31512p;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(D);
                int i11 = i10 + 1;
                sb2.append(i11);
                persistableBundle.putPersistableBundle(sb2.toString(), this.f31507k[i10].n());
                i10 = i11;
            }
        }
        c0 c0Var = this.f31509m;
        if (c0Var != null) {
            this.f31512p.putString(E, c0Var.a());
        }
        this.f31512p.putBoolean(F, this.f31510n);
        return this.f31512p;
    }

    @p0
    public ComponentName d() {
        return this.f31501e;
    }

    @p0
    public Set<String> e() {
        return this.f31508l;
    }

    @p0
    public CharSequence f() {
        return this.f31504h;
    }

    public int g() {
        return this.A;
    }

    public int h() {
        return this.B;
    }

    @p0
    public PersistableBundle i() {
        return this.f31512p;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public IconCompat j() {
        return this.f31505i;
    }

    @n0
    public String k() {
        return this.f31498b;
    }

    @n0
    public Intent l() {
        return this.f31500d[r0.length - 1];
    }

    @n0
    public Intent[] m() {
        Intent[] intentArr = this.f31500d;
        return (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
    }

    public long n() {
        return this.f31514r;
    }

    @p0
    public c0 o() {
        return this.f31509m;
    }

    @p0
    public CharSequence r() {
        return this.f31503g;
    }

    @n0
    public String t() {
        return this.f31499c;
    }

    public int v() {
        return this.f31511o;
    }

    @n0
    public CharSequence w() {
        return this.f31502f;
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bundle x() {
        return this.f31513q;
    }

    @p0
    public UserHandle y() {
        return this.f31515s;
    }

    public boolean z() {
        return this.f31522z;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f31523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f31524b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Set<String> f31525c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, Map<String, List<String>>> f31526d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Uri f31527e;

        public b(@n0 Context context, @n0 String str) {
            e eVar = new e();
            this.f31523a = eVar;
            eVar.f31497a = context;
            eVar.f31498b = str;
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        @n0
        public b a(@n0 String str) {
            if (this.f31525c == null) {
                this.f31525c = new HashSet();
            }
            this.f31525c.add(str);
            return this;
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        @n0
        public b b(@n0 String str, @n0 String str2, @n0 List<String> list) {
            a(str);
            if (!list.isEmpty()) {
                if (this.f31526d == null) {
                    this.f31526d = new HashMap();
                }
                if (this.f31526d.get(str) == null) {
                    this.f31526d.put(str, new HashMap());
                }
                this.f31526d.get(str).put(str2, list);
            }
            return this;
        }

        @n0
        public e c() {
            if (TextUtils.isEmpty(this.f31523a.f31502f)) {
                throw new IllegalArgumentException("Shortcut must have a non-empty label");
            }
            e eVar = this.f31523a;
            Intent[] intentArr = eVar.f31500d;
            if (intentArr == null || intentArr.length == 0) {
                throw new IllegalArgumentException("Shortcut must have an intent");
            }
            if (this.f31524b) {
                if (eVar.f31509m == null) {
                    eVar.f31509m = new c0(eVar.f31498b);
                }
                this.f31523a.f31510n = true;
            }
            if (this.f31525c != null) {
                e eVar2 = this.f31523a;
                if (eVar2.f31508l == null) {
                    eVar2.f31508l = new HashSet();
                }
                this.f31523a.f31508l.addAll(this.f31525c);
            }
            if (this.f31526d != null) {
                e eVar3 = this.f31523a;
                if (eVar3.f31512p == null) {
                    eVar3.f31512p = new PersistableBundle();
                }
                for (String str : this.f31526d.keySet()) {
                    Map<String, List<String>> map = this.f31526d.get(str);
                    this.f31523a.f31512p.putStringArray(str, (String[]) map.keySet().toArray(new String[0]));
                    for (String str2 : map.keySet()) {
                        List<String> list = map.get(str2);
                        this.f31523a.f31512p.putStringArray(str + fh.a.f28350w + str2, list == null ? new String[0] : (String[]) list.toArray(new String[0]));
                    }
                }
            }
            if (this.f31527e != null) {
                e eVar4 = this.f31523a;
                if (eVar4.f31512p == null) {
                    eVar4.f31512p = new PersistableBundle();
                }
                this.f31523a.f31512p.putString(e.G, u0.e.a(this.f31527e));
            }
            return this.f31523a;
        }

        @n0
        public b d(@n0 ComponentName componentName) {
            this.f31523a.f31501e = componentName;
            return this;
        }

        @n0
        public b e() {
            this.f31523a.f31506j = true;
            return this;
        }

        @n0
        public b f(@n0 Set<String> set) {
            this.f31523a.f31508l = set;
            return this;
        }

        @n0
        public b g(@n0 CharSequence charSequence) {
            this.f31523a.f31504h = charSequence;
            return this;
        }

        @n0
        public b h(int i10) {
            this.f31523a.B = i10;
            return this;
        }

        @n0
        public b i(@n0 PersistableBundle persistableBundle) {
            this.f31523a.f31512p = persistableBundle;
            return this;
        }

        @n0
        public b j(IconCompat iconCompat) {
            this.f31523a.f31505i = iconCompat;
            return this;
        }

        @n0
        public b k(@n0 Intent intent) {
            return l(new Intent[]{intent});
        }

        @n0
        public b l(@n0 Intent[] intentArr) {
            this.f31523a.f31500d = intentArr;
            return this;
        }

        @n0
        public b m() {
            this.f31524b = true;
            return this;
        }

        @n0
        public b n(@p0 c0 c0Var) {
            this.f31523a.f31509m = c0Var;
            return this;
        }

        @n0
        public b o(@n0 CharSequence charSequence) {
            this.f31523a.f31503g = charSequence;
            return this;
        }

        @n0
        @Deprecated
        public b p() {
            this.f31523a.f31510n = true;
            return this;
        }

        @n0
        public b q(boolean z10) {
            this.f31523a.f31510n = z10;
            return this;
        }

        @n0
        public b r(@n0 f0 f0Var) {
            return s(new f0[]{f0Var});
        }

        @n0
        public b s(@n0 f0[] f0VarArr) {
            this.f31523a.f31507k = f0VarArr;
            return this;
        }

        @n0
        public b t(int i10) {
            this.f31523a.f31511o = i10;
            return this;
        }

        @n0
        public b u(@n0 CharSequence charSequence) {
            this.f31523a.f31502f = charSequence;
            return this;
        }

        @SuppressLint({"MissingGetterMatchingBuilder"})
        @n0
        public b v(@n0 Uri uri) {
            this.f31527e = uri;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @n0
        public b w(@n0 Bundle bundle) {
            this.f31523a.f31513q = (Bundle) o.l(bundle);
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public b(@n0 e eVar) {
            e eVar2 = new e();
            this.f31523a = eVar2;
            eVar2.f31497a = eVar.f31497a;
            eVar2.f31498b = eVar.f31498b;
            eVar2.f31499c = eVar.f31499c;
            Intent[] intentArr = eVar.f31500d;
            eVar2.f31500d = (Intent[]) Arrays.copyOf(intentArr, intentArr.length);
            eVar2.f31501e = eVar.f31501e;
            eVar2.f31502f = eVar.f31502f;
            eVar2.f31503g = eVar.f31503g;
            eVar2.f31504h = eVar.f31504h;
            eVar2.A = eVar.A;
            eVar2.f31505i = eVar.f31505i;
            eVar2.f31506j = eVar.f31506j;
            eVar2.f31515s = eVar.f31515s;
            eVar2.f31514r = eVar.f31514r;
            eVar2.f31516t = eVar.f31516t;
            eVar2.f31517u = eVar.f31517u;
            eVar2.f31518v = eVar.f31518v;
            eVar2.f31519w = eVar.f31519w;
            eVar2.f31520x = eVar.f31520x;
            eVar2.f31521y = eVar.f31521y;
            eVar2.f31509m = eVar.f31509m;
            eVar2.f31510n = eVar.f31510n;
            eVar2.f31522z = eVar.f31522z;
            eVar2.f31511o = eVar.f31511o;
            f0[] f0VarArr = eVar.f31507k;
            if (f0VarArr != null) {
                eVar2.f31507k = (f0[]) Arrays.copyOf(f0VarArr, f0VarArr.length);
            }
            if (eVar.f31508l != null) {
                eVar2.f31508l = new HashSet(eVar.f31508l);
            }
            PersistableBundle persistableBundle = eVar.f31512p;
            if (persistableBundle != null) {
                eVar2.f31512p = persistableBundle;
            }
            eVar2.B = eVar.B;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        @v0(25)
        public b(@n0 Context context, @n0 ShortcutInfo shortcutInfo) {
            e eVar = new e();
            this.f31523a = eVar;
            eVar.f31497a = context;
            eVar.f31498b = shortcutInfo.getId();
            eVar.f31499c = shortcutInfo.getPackage();
            Intent[] intents = shortcutInfo.getIntents();
            eVar.f31500d = (Intent[]) Arrays.copyOf(intents, intents.length);
            eVar.f31501e = shortcutInfo.getActivity();
            eVar.f31502f = shortcutInfo.getShortLabel();
            eVar.f31503g = shortcutInfo.getLongLabel();
            eVar.f31504h = shortcutInfo.getDisabledMessage();
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 28) {
                eVar.A = shortcutInfo.getDisabledReason();
            } else {
                eVar.A = shortcutInfo.isEnabled() ? 0 : 3;
            }
            eVar.f31508l = shortcutInfo.getCategories();
            eVar.f31507k = e.u(shortcutInfo.getExtras());
            eVar.f31515s = shortcutInfo.getUserHandle();
            eVar.f31514r = shortcutInfo.getLastChangedTimestamp();
            if (i10 >= 30) {
                eVar.f31516t = shortcutInfo.isCached();
            }
            eVar.f31517u = shortcutInfo.isDynamic();
            eVar.f31518v = shortcutInfo.isPinned();
            eVar.f31519w = shortcutInfo.isDeclaredInManifest();
            eVar.f31520x = shortcutInfo.isImmutable();
            eVar.f31521y = shortcutInfo.isEnabled();
            eVar.f31522z = shortcutInfo.hasKeyFieldsOnly();
            eVar.f31509m = e.p(shortcutInfo);
            eVar.f31511o = shortcutInfo.getRank();
            eVar.f31512p = shortcutInfo.getExtras();
        }
    }
}
