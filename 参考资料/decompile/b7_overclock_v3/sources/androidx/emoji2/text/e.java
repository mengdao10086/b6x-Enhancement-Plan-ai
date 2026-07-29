package androidx.emoji2.text;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.c;
import g.b0;
import g.f0;
import g.n0;
import g.p0;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
@g.d
public class e {
    public static final int A = 2;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int B = Integer.MAX_VALUE;
    public static final Object C = new Object();
    public static final Object D = new Object();

    @p0
    @b0("INSTANCE_LOCK")
    public static volatile e E = null;

    @b0("CONFIG_LOCK")
    public static volatile boolean F = false;
    public static final String G = "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f5352n = "android.support.text.emoji.emojiCompat_metadataVersion";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f5353o = "android.support.text.emoji.emojiCompat_replaceAll";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f5354p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f5355q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f5356r = 1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f5357s = 2;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f5358t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f5359u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f5360v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f5361w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f5362x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f5363y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f5364z = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @b0("mInitLock")
    @n0
    public final Set<f> f5366b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @n0
    public final c f5369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public final i f5370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f5371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f5372h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public final int[] f5373i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f5374j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f5375k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f5376l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final InterfaceC0049e f5377m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final ReadWriteLock f5365a = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @b0("mInitLock")
    public volatile int f5367c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final Handler f5368d = new Handler(Looper.getMainLooper());

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface a {
    }

    @v0(19)
    public static final class b extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile androidx.emoji2.text.i f5378b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile o f5379c;

        public class a extends j {
            public a() {
            }

            @Override // androidx.emoji2.text.e.j
            public void a(@p0 Throwable th2) {
                b.this.f5381a.s(th2);
            }

            @Override // androidx.emoji2.text.e.j
            public void b(@n0 o oVar) {
                b.this.h(oVar);
            }
        }

        public b(e eVar) {
            super(eVar);
        }

        @Override // androidx.emoji2.text.e.c
        public String a() {
            String strN = this.f5379c.g().N();
            return strN == null ? "" : strN;
        }

        @Override // androidx.emoji2.text.e.c
        public int b(CharSequence charSequence, int i10) {
            return this.f5378b.d(charSequence, i10);
        }

        @Override // androidx.emoji2.text.e.c
        public boolean c(@n0 CharSequence charSequence) {
            return this.f5378b.c(charSequence) == 1;
        }

        @Override // androidx.emoji2.text.e.c
        public boolean d(@n0 CharSequence charSequence, int i10) {
            return this.f5378b.d(charSequence, i10) == 1;
        }

        @Override // androidx.emoji2.text.e.c
        public void e() {
            try {
                this.f5381a.f5370f.a(new a());
            } catch (Throwable th2) {
                this.f5381a.s(th2);
            }
        }

        @Override // androidx.emoji2.text.e.c
        public CharSequence f(@n0 CharSequence charSequence, int i10, int i11, int i12, boolean z10) {
            return this.f5378b.j(charSequence, i10, i11, i12, z10);
        }

        @Override // androidx.emoji2.text.e.c
        public void g(@n0 EditorInfo editorInfo) {
            editorInfo.extras.putInt(e.f5352n, this.f5379c.h());
            editorInfo.extras.putBoolean(e.f5353o, this.f5381a.f5371g);
        }

        public void h(@n0 o oVar) {
            if (oVar == null) {
                this.f5381a.s(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f5379c = oVar;
            o oVar2 = this.f5379c;
            l lVar = new l();
            InterfaceC0049e interfaceC0049e = this.f5381a.f5377m;
            e eVar = this.f5381a;
            this.f5378b = new androidx.emoji2.text.i(oVar2, lVar, interfaceC0049e, eVar.f5372h, eVar.f5373i);
            this.f5381a.t();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f5381a;

        public c(e eVar) {
            this.f5381a = eVar;
        }

        public String a() {
            return "";
        }

        public int b(CharSequence charSequence, int i10) {
            return 0;
        }

        public boolean c(@n0 CharSequence charSequence) {
            return false;
        }

        public boolean d(@n0 CharSequence charSequence, int i10) {
            return false;
        }

        public void e() {
            this.f5381a.t();
        }

        public CharSequence f(@n0 CharSequence charSequence, @f0(from = 0) int i10, @f0(from = 0) int i11, @f0(from = 0) int i12, boolean z10) {
            return charSequence;
        }

        public void g(@n0 EditorInfo editorInfo) {
        }
    }

    public static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final i f5382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f5383b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f5384c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public int[] f5385d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @p0
        public Set<f> f5386e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f5387f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f5388g = -16711936;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f5389h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @n0
        public InterfaceC0049e f5390i = new androidx.emoji2.text.d();

        public d(@n0 i iVar) {
            androidx.core.util.o.m(iVar, "metadataLoader cannot be null.");
            this.f5382a = iVar;
        }

        @n0
        public final i a() {
            return this.f5382a;
        }

        @n0
        public d b(@n0 f fVar) {
            androidx.core.util.o.m(fVar, "initCallback cannot be null");
            if (this.f5386e == null) {
                this.f5386e = new androidx.collection.c();
            }
            this.f5386e.add(fVar);
            return this;
        }

        @n0
        public d c(@g.l int i10) {
            this.f5388g = i10;
            return this;
        }

        @n0
        public d d(boolean z10) {
            this.f5387f = z10;
            return this;
        }

        @n0
        public d e(@n0 InterfaceC0049e interfaceC0049e) {
            androidx.core.util.o.m(interfaceC0049e, "GlyphChecker cannot be null");
            this.f5390i = interfaceC0049e;
            return this;
        }

        @n0
        public d f(int i10) {
            this.f5389h = i10;
            return this;
        }

        @n0
        public d g(boolean z10) {
            this.f5383b = z10;
            return this;
        }

        @n0
        public d h(boolean z10) {
            return i(z10, null);
        }

        @n0
        public d i(boolean z10, @p0 List<Integer> list) {
            this.f5384c = z10;
            if (!z10 || list == null) {
                this.f5385d = null;
            } else {
                this.f5385d = new int[list.size()];
                int i10 = 0;
                Iterator<Integer> it2 = list.iterator();
                while (it2.hasNext()) {
                    this.f5385d[i10] = it2.next().intValue();
                    i10++;
                }
                Arrays.sort(this.f5385d);
            }
            return this;
        }

        @n0
        public d j(@n0 f fVar) {
            androidx.core.util.o.m(fVar, "initCallback cannot be null");
            Set<f> set = this.f5386e;
            if (set != null) {
                set.remove(fVar);
            }
            return this;
        }
    }

    /* JADX INFO: renamed from: androidx.emoji2.text.e$e, reason: collision with other inner class name */
    public interface InterfaceC0049e {
        boolean a(@n0 CharSequence charSequence, @f0(from = 0) int i10, @f0(from = 0) int i11, @f0(from = 0) int i12);
    }

    public static abstract class f {
        public void a(@p0 Throwable th2) {
        }

        public void b() {
        }
    }

    public static class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<f> f5391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f5392b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f5393c;

        public g(@n0 f fVar, int i10) {
            this(Arrays.asList((f) androidx.core.util.o.m(fVar, "initCallback cannot be null")), i10, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f5391a.size();
            int i10 = 0;
            if (this.f5393c != 1) {
                while (i10 < size) {
                    this.f5391a.get(i10).a(this.f5392b);
                    i10++;
                }
            } else {
                while (i10 < size) {
                    this.f5391a.get(i10).b();
                    i10++;
                }
            }
        }

        public g(@n0 Collection<f> collection, int i10) {
            this(collection, i10, null);
        }

        public g(@n0 Collection<f> collection, int i10, @p0 Throwable th2) {
            androidx.core.util.o.m(collection, "initCallbacks cannot be null");
            this.f5391a = new ArrayList(collection);
            this.f5393c = i10;
            this.f5392b = th2;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface h {
    }

    public interface i {
        void a(@n0 j jVar);
    }

    public static abstract class j {
        public abstract void a(@p0 Throwable th2);

        public abstract void b(@n0 o oVar);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface k {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @v0(19)
    public static class l {
        public androidx.emoji2.text.j a(@n0 androidx.emoji2.text.h hVar) {
            return new q(hVar);
        }
    }

    public e(@n0 d dVar) {
        this.f5371g = dVar.f5383b;
        this.f5372h = dVar.f5384c;
        this.f5373i = dVar.f5385d;
        this.f5374j = dVar.f5387f;
        this.f5375k = dVar.f5388g;
        this.f5370f = dVar.f5382a;
        this.f5376l = dVar.f5389h;
        this.f5377m = dVar.f5390i;
        androidx.collection.c cVar = new androidx.collection.c();
        this.f5366b = cVar;
        Set<f> set = dVar.f5386e;
        if (set != null && !set.isEmpty()) {
            cVar.addAll(dVar.f5386e);
        }
        this.f5369e = new b(this);
        r();
    }

    @p0
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static e A(@p0 e eVar) {
        e eVar2;
        synchronized (C) {
            E = eVar;
            eVar2 = E;
        }
        return eVar2;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static void B(boolean z10) {
        synchronized (D) {
            F = z10;
        }
    }

    @n0
    public static e b() {
        e eVar;
        synchronized (C) {
            eVar = E;
            androidx.core.util.o.o(eVar != null, G);
        }
        return eVar;
    }

    public static boolean g(@n0 InputConnection inputConnection, @n0 Editable editable, @f0(from = 0) int i10, @f0(from = 0) int i11, boolean z10) {
        return androidx.emoji2.text.i.e(inputConnection, editable, i10, i11, z10);
    }

    public static boolean h(@n0 Editable editable, int i10, @n0 KeyEvent keyEvent) {
        return androidx.emoji2.text.i.f(editable, i10, keyEvent);
    }

    @p0
    public static e k(@n0 Context context) {
        return l(context, null);
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static e l(@n0 Context context, @p0 c.a aVar) {
        e eVar;
        if (F) {
            return E;
        }
        if (aVar == null) {
            aVar = new c.a(null);
        }
        d dVarC = aVar.c(context);
        synchronized (D) {
            if (!F) {
                if (dVarC != null) {
                    m(dVarC);
                }
                F = true;
            }
            eVar = E;
        }
        return eVar;
    }

    @n0
    public static e m(@n0 d dVar) {
        e eVar = E;
        if (eVar == null) {
            synchronized (C) {
                eVar = E;
                if (eVar == null) {
                    eVar = new e(dVar);
                    E = eVar;
                }
            }
        }
        return eVar;
    }

    public static boolean n() {
        return E != null;
    }

    @n0
    public static e z(@n0 d dVar) {
        e eVar;
        synchronized (C) {
            eVar = new e(dVar);
            E = eVar;
        }
        return eVar;
    }

    public void C(@n0 f fVar) {
        androidx.core.util.o.m(fVar, "initCallback cannot be null");
        this.f5365a.writeLock().lock();
        try {
            this.f5366b.remove(fVar);
        } finally {
            this.f5365a.writeLock().unlock();
        }
    }

    public void D(@n0 EditorInfo editorInfo) {
        if (!p() || editorInfo == null) {
            return;
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        this.f5369e.g(editorInfo);
    }

    @n0
    public String c() {
        androidx.core.util.o.o(p(), "Not initialized yet");
        return this.f5369e.a();
    }

    public int d(@n0 CharSequence charSequence, @f0(from = 0) int i10) {
        androidx.core.util.o.o(p(), "Not initialized yet");
        androidx.core.util.o.m(charSequence, "sequence cannot be null");
        return this.f5369e.b(charSequence, i10);
    }

    @g.l
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int e() {
        return this.f5375k;
    }

    public int f() {
        this.f5365a.readLock().lock();
        try {
            return this.f5367c;
        } finally {
            this.f5365a.readLock().unlock();
        }
    }

    @Deprecated
    public boolean i(@n0 CharSequence charSequence) {
        androidx.core.util.o.o(p(), "Not initialized yet");
        androidx.core.util.o.m(charSequence, "sequence cannot be null");
        return this.f5369e.c(charSequence);
    }

    @Deprecated
    public boolean j(@n0 CharSequence charSequence, @f0(from = 0) int i10) {
        androidx.core.util.o.o(p(), "Not initialized yet");
        androidx.core.util.o.m(charSequence, "sequence cannot be null");
        return this.f5369e.d(charSequence, i10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean o() {
        return this.f5374j;
    }

    public final boolean p() {
        return f() == 1;
    }

    public void q() {
        androidx.core.util.o.o(this.f5376l == 1, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (p()) {
            return;
        }
        this.f5365a.writeLock().lock();
        try {
            if (this.f5367c == 0) {
                return;
            }
            this.f5367c = 0;
            this.f5365a.writeLock().unlock();
            this.f5369e.e();
        } finally {
            this.f5365a.writeLock().unlock();
        }
    }

    public final void r() {
        this.f5365a.writeLock().lock();
        try {
            if (this.f5376l == 0) {
                this.f5367c = 0;
            }
            this.f5365a.writeLock().unlock();
            if (f() == 0) {
                this.f5369e.e();
            }
        } catch (Throwable th2) {
            this.f5365a.writeLock().unlock();
            throw th2;
        }
    }

    public void s(@p0 Throwable th2) {
        ArrayList arrayList = new ArrayList();
        this.f5365a.writeLock().lock();
        try {
            this.f5367c = 2;
            arrayList.addAll(this.f5366b);
            this.f5366b.clear();
            this.f5365a.writeLock().unlock();
            this.f5368d.post(new g(arrayList, this.f5367c, th2));
        } catch (Throwable th3) {
            this.f5365a.writeLock().unlock();
            throw th3;
        }
    }

    public void t() {
        ArrayList arrayList = new ArrayList();
        this.f5365a.writeLock().lock();
        try {
            this.f5367c = 1;
            arrayList.addAll(this.f5366b);
            this.f5366b.clear();
            this.f5365a.writeLock().unlock();
            this.f5368d.post(new g(arrayList, this.f5367c));
        } catch (Throwable th2) {
            this.f5365a.writeLock().unlock();
            throw th2;
        }
    }

    @p0
    @g.j
    public CharSequence u(@p0 CharSequence charSequence) {
        return v(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    @p0
    @g.j
    public CharSequence v(@p0 CharSequence charSequence, @f0(from = 0) int i10, @f0(from = 0) int i11) {
        return w(charSequence, i10, i11, Integer.MAX_VALUE);
    }

    @p0
    @g.j
    public CharSequence w(@p0 CharSequence charSequence, @f0(from = 0) int i10, @f0(from = 0) int i11, @f0(from = 0) int i12) {
        return x(charSequence, i10, i11, i12, 0);
    }

    @p0
    @g.j
    public CharSequence x(@p0 CharSequence charSequence, @f0(from = 0) int i10, @f0(from = 0) int i11, @f0(from = 0) int i12, int i13) {
        androidx.core.util.o.o(p(), "Not initialized yet");
        androidx.core.util.o.j(i10, "start cannot be negative");
        androidx.core.util.o.j(i11, "end cannot be negative");
        androidx.core.util.o.j(i12, "maxEmojiCount cannot be negative");
        androidx.core.util.o.b(i10 <= i11, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        androidx.core.util.o.b(i10 <= charSequence.length(), "start should be < than charSequence length");
        androidx.core.util.o.b(i11 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i10 == i11) {
            return charSequence;
        }
        return this.f5369e.f(charSequence, i10, i11, i12, i13 != 1 ? i13 != 2 ? this.f5371g : false : true);
    }

    public void y(@n0 f fVar) {
        androidx.core.util.o.m(fVar, "initCallback cannot be null");
        this.f5365a.writeLock().lock();
        try {
            if (this.f5367c == 1 || this.f5367c == 2) {
                this.f5368d.post(new g(fVar, this.f5367c));
            } else {
                this.f5366b.add(fVar);
            }
        } finally {
            this.f5365a.writeLock().unlock();
        }
    }
}
