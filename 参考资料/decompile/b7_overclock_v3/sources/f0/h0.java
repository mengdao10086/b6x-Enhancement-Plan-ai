package f0;

import android.app.RemoteInput;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class h0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f27458h = "android.remoteinput.results";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f27459i = "android.remoteinput.resultsData";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f27460j = "android.remoteinput.dataTypeResultsData";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f27461k = "android.remoteinput.resultsSource";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f27462l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f27463m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f27464n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f27465o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f27466p = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f27467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f27468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CharSequence[] f27469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f27470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f27471e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f27472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<String> f27473g;

    @v0(16)
    public static class a {
        @g.u
        public static ClipData a(Intent intent) {
            return intent.getClipData();
        }

        @g.u
        public static void b(Intent intent, ClipData clipData) {
            intent.setClipData(clipData);
        }
    }

    @v0(20)
    public static class b {
        @g.u
        public static void a(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        public static RemoteInput b(h0 h0Var) {
            Set<String> setG;
            RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(h0Var.o()).setLabel(h0Var.n()).setChoices(h0Var.h()).setAllowFreeFormInput(h0Var.f()).addExtras(h0Var.m());
            if (Build.VERSION.SDK_INT >= 26 && (setG = h0Var.g()) != null) {
                Iterator<String> it2 = setG.iterator();
                while (it2.hasNext()) {
                    c.d(builderAddExtras, it2.next(), true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                e.b(builderAddExtras, h0Var.k());
            }
            return builderAddExtras.build();
        }

        public static h0 c(Object obj) {
            Set<String> setB;
            RemoteInput remoteInput = (RemoteInput) obj;
            f fVarA = new f(remoteInput.getResultKey()).h(remoteInput.getLabel()).f(remoteInput.getChoices()).e(remoteInput.getAllowFreeFormInput()).a(remoteInput.getExtras());
            if (Build.VERSION.SDK_INT >= 26 && (setB = c.b(remoteInput)) != null) {
                Iterator<String> it2 = setB.iterator();
                while (it2.hasNext()) {
                    fVarA.d(it2.next(), true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                fVarA.g(e.a(remoteInput));
            }
            return fVarA.b();
        }

        @g.u
        public static Bundle d(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    @v0(26)
    public static class c {
        @g.u
        public static void a(h0 h0Var, Intent intent, Map<String, Uri> map) {
            RemoteInput.addDataResultToIntent(h0.c(h0Var), intent, map);
        }

        @g.u
        public static Set<String> b(Object obj) {
            return ((RemoteInput) obj).getAllowedDataTypes();
        }

        @g.u
        public static Map<String, Uri> c(Intent intent, String str) {
            return RemoteInput.getDataResultsFromIntent(intent, str);
        }

        @g.u
        public static RemoteInput.Builder d(RemoteInput.Builder builder, String str, boolean z10) {
            return builder.setAllowDataType(str, z10);
        }
    }

    @v0(28)
    public static class d {
        @g.u
        public static int a(Intent intent) {
            return RemoteInput.getResultsSource(intent);
        }

        @g.u
        public static void b(Intent intent, int i10) {
            RemoteInput.setResultsSource(intent, i10);
        }
    }

    @v0(29)
    public static class e {
        @g.u
        public static int a(Object obj) {
            return ((RemoteInput) obj).getEditChoicesBeforeSending();
        }

        @g.u
        public static RemoteInput.Builder b(RemoteInput.Builder builder, int i10) {
            return builder.setEditChoicesBeforeSending(i10);
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f27474a;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public CharSequence f27477d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public CharSequence[] f27478e;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<String> f27475b = new HashSet();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Bundle f27476c = new Bundle();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f27479f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f27480g = 0;

        public f(@n0 String str) {
            if (str == null) {
                throw new IllegalArgumentException("Result key can't be null");
            }
            this.f27474a = str;
        }

        @n0
        public f a(@n0 Bundle bundle) {
            if (bundle != null) {
                this.f27476c.putAll(bundle);
            }
            return this;
        }

        @n0
        public h0 b() {
            return new h0(this.f27474a, this.f27477d, this.f27478e, this.f27479f, this.f27480g, this.f27476c, this.f27475b);
        }

        @n0
        public Bundle c() {
            return this.f27476c;
        }

        @n0
        public f d(@n0 String str, boolean z10) {
            if (z10) {
                this.f27475b.add(str);
            } else {
                this.f27475b.remove(str);
            }
            return this;
        }

        @n0
        public f e(boolean z10) {
            this.f27479f = z10;
            return this;
        }

        @n0
        public f f(@p0 CharSequence[] charSequenceArr) {
            this.f27478e = charSequenceArr;
            return this;
        }

        @n0
        public f g(int i10) {
            this.f27480g = i10;
            return this;
        }

        @n0
        public f h(@p0 CharSequence charSequence) {
            this.f27477d = charSequence;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface g {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface h {
    }

    public h0(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z10, int i10, Bundle bundle, Set<String> set) {
        this.f27467a = str;
        this.f27468b = charSequence;
        this.f27469c = charSequenceArr;
        this.f27470d = z10;
        this.f27471e = i10;
        this.f27472f = bundle;
        this.f27473g = set;
        if (k() == 2 && !f()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    public static void a(@n0 h0 h0Var, @n0 Intent intent, @n0 Map<String, Uri> map) {
        if (Build.VERSION.SDK_INT >= 26) {
            c.a(h0Var, intent, map);
            return;
        }
        Intent intentI = i(intent);
        if (intentI == null) {
            intentI = new Intent();
        }
        for (Map.Entry<String, Uri> entry : map.entrySet()) {
            String key = entry.getKey();
            Uri value = entry.getValue();
            if (key != null) {
                Bundle bundleExtra = intentI.getBundleExtra(l(key));
                if (bundleExtra == null) {
                    bundleExtra = new Bundle();
                }
                bundleExtra.putString(h0Var.o(), value.toString());
                intentI.putExtra(l(key), bundleExtra);
            }
        }
        a.b(intent, ClipData.newIntent(f27458h, intentI));
    }

    public static void b(@n0 h0[] h0VarArr, @n0 Intent intent, @n0 Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 26) {
            b.a(d(h0VarArr), intent, bundle);
            return;
        }
        Bundle bundleP = p(intent);
        int iQ = q(intent);
        if (bundleP != null) {
            bundleP.putAll(bundle);
            bundle = bundleP;
        }
        for (h0 h0Var : h0VarArr) {
            Map<String, Uri> mapJ = j(intent, h0Var.o());
            b.a(d(new h0[]{h0Var}), intent, bundle);
            if (mapJ != null) {
                a(h0Var, intent, mapJ);
            }
        }
        s(intent, iQ);
    }

    @v0(20)
    public static RemoteInput c(h0 h0Var) {
        return b.b(h0Var);
    }

    @v0(20)
    public static RemoteInput[] d(h0[] h0VarArr) {
        if (h0VarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[h0VarArr.length];
        for (int i10 = 0; i10 < h0VarArr.length; i10++) {
            remoteInputArr[i10] = c(h0VarArr[i10]);
        }
        return remoteInputArr;
    }

    @v0(20)
    public static h0 e(RemoteInput remoteInput) {
        return b.c(remoteInput);
    }

    @v0(16)
    public static Intent i(Intent intent) {
        ClipData clipDataA = a.a(intent);
        if (clipDataA == null) {
            return null;
        }
        ClipDescription description = clipDataA.getDescription();
        if (description.hasMimeType("text/vnd.android.intent") && description.getLabel().toString().contentEquals(f27458h)) {
            return clipDataA.getItemAt(0).getIntent();
        }
        return null;
    }

    @p0
    public static Map<String, Uri> j(@n0 Intent intent, @n0 String str) {
        String string;
        if (Build.VERSION.SDK_INT >= 26) {
            return c.c(intent, str);
        }
        Intent intentI = i(intent);
        if (intentI == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (String str2 : intentI.getExtras().keySet()) {
            if (str2.startsWith(f27460j)) {
                String strSubstring = str2.substring(39);
                if (!strSubstring.isEmpty() && (string = intentI.getBundleExtra(str2).getString(str)) != null && !string.isEmpty()) {
                    map.put(strSubstring, Uri.parse(string));
                }
            }
        }
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }

    public static String l(String str) {
        return f27460j + str;
    }

    @p0
    public static Bundle p(@n0 Intent intent) {
        return b.d(intent);
    }

    public static int q(@n0 Intent intent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return d.a(intent);
        }
        Intent intentI = i(intent);
        if (intentI == null) {
            return 0;
        }
        return intentI.getExtras().getInt(f27461k, 0);
    }

    public static void s(@n0 Intent intent, int i10) {
        if (Build.VERSION.SDK_INT >= 28) {
            d.b(intent, i10);
            return;
        }
        Intent intentI = i(intent);
        if (intentI == null) {
            intentI = new Intent();
        }
        intentI.putExtra(f27461k, i10);
        a.b(intent, ClipData.newIntent(f27458h, intentI));
    }

    public boolean f() {
        return this.f27470d;
    }

    @p0
    public Set<String> g() {
        return this.f27473g;
    }

    @p0
    public CharSequence[] h() {
        return this.f27469c;
    }

    public int k() {
        return this.f27471e;
    }

    @n0
    public Bundle m() {
        return this.f27472f;
    }

    @p0
    public CharSequence n() {
        return this.f27468b;
    }

    @n0
    public String o() {
        return this.f27467a;
    }

    public boolean r() {
        return (f() || (h() != null && h().length != 0) || g() == null || g().isEmpty()) ? false : true;
    }
}
