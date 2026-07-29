package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.e;
import g.i1;
import g.n0;
import g.p0;
import g.v0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @n0
        public static final String f5345b = "emoji2.text.DefaultEmojiConfig";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @n0
        public static final String f5346c = "androidx.content.action.LOAD_EMOJI_FONT";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @n0
        public static final String f5347d = "emojicompat-emoji-font";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f5348a;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public a(@p0 b bVar) {
            this.f5348a = bVar == null ? e() : bVar;
        }

        @n0
        public static b e() {
            return Build.VERSION.SDK_INT >= 28 ? new d() : new C0048c();
        }

        @p0
        public final e.d a(@n0 Context context, @p0 v0.f fVar) {
            if (fVar == null) {
                return null;
            }
            return new k(context, fVar);
        }

        @n0
        public final List<List<byte[]>> b(@n0 Signature[] signatureArr) {
            ArrayList arrayList = new ArrayList();
            for (Signature signature : signatureArr) {
                arrayList.add(signature.toByteArray());
            }
            return Collections.singletonList(arrayList);
        }

        @p0
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public e.d c(@n0 Context context) {
            return a(context, h(context));
        }

        @n0
        public final v0.f d(@n0 ProviderInfo providerInfo, @n0 PackageManager packageManager) throws PackageManager.NameNotFoundException {
            String str = providerInfo.authority;
            String str2 = providerInfo.packageName;
            return new v0.f(str, str2, f5347d, b(this.f5348a.b(packageManager, str2)));
        }

        public final boolean f(@p0 ProviderInfo providerInfo) {
            ApplicationInfo applicationInfo;
            return (providerInfo == null || (applicationInfo = providerInfo.applicationInfo) == null || (applicationInfo.flags & 1) != 1) ? false : true;
        }

        @p0
        public final ProviderInfo g(@n0 PackageManager packageManager) {
            Iterator<ResolveInfo> it2 = this.f5348a.c(packageManager, new Intent(f5346c), 0).iterator();
            while (it2.hasNext()) {
                ProviderInfo providerInfoA = this.f5348a.a(it2.next());
                if (f(providerInfoA)) {
                    return providerInfoA;
                }
            }
            return null;
        }

        @i1
        @p0
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public v0.f h(@n0 Context context) {
            PackageManager packageManager = context.getPackageManager();
            androidx.core.util.o.m(packageManager, "Package manager required to locate emoji font provider");
            ProviderInfo providerInfoG = g(packageManager);
            if (providerInfoG == null) {
                return null;
            }
            try {
                return d(providerInfoG, packageManager);
            } catch (PackageManager.NameNotFoundException e10) {
                Log.wtf(f5345b, e10);
                return null;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class b {
        @p0
        public ProviderInfo a(@n0 ResolveInfo resolveInfo) {
            throw new IllegalStateException("Unable to get provider info prior to API 19");
        }

        @n0
        public Signature[] b(@n0 PackageManager packageManager, @n0 String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }

        @n0
        public List<ResolveInfo> c(@n0 PackageManager packageManager, @n0 Intent intent, int i10) {
            return Collections.emptyList();
        }
    }

    /* JADX INFO: renamed from: androidx.emoji2.text.c$c, reason: collision with other inner class name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @v0(19)
    public static class C0048c extends b {
        @Override // androidx.emoji2.text.c.b
        @p0
        public ProviderInfo a(@n0 ResolveInfo resolveInfo) {
            return resolveInfo.providerInfo;
        }

        @Override // androidx.emoji2.text.c.b
        @n0
        public List<ResolveInfo> c(@n0 PackageManager packageManager, @n0 Intent intent, int i10) {
            return packageManager.queryIntentContentProviders(intent, i10);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @v0(28)
    public static class d extends C0048c {
        @Override // androidx.emoji2.text.c.b
        @n0
        public Signature[] b(@n0 PackageManager packageManager, @n0 String str) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(str, 64).signatures;
        }
    }

    @p0
    public static k a(@n0 Context context) {
        return (k) new a(null).c(context);
    }
}
