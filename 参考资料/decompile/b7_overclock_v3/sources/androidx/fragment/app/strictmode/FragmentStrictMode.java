package androidx.fragment.app.strictmode;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import com.flydigi.sdk.bluetooth.l;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import g.i1;
import hk.e;
import hk.m;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.d1;
import kotlin.collections.s0;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import m0.k;
import xc.d;
import xf.j;

/* JADX INFO: loaded from: classes2.dex */
@d0(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\u000323'B\t\b\u0002¢\u0006\u0004\b0\u00101J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0007J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0007J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J0\u0010\"\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001b2\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u001f2\u000e\u0010!\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u001fH\u0002J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$H\u0002R\u0014\u0010)\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010(R\"\u0010/\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.¨\u00064"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode;", "", "Landroidx/fragment/app/Fragment;", "fragment", "", "previousFragmentId", "Lkotlin/z1;", "i", "Landroid/view/ViewGroup;", d.V, j.f55230b, "o", "k", "", "isVisibleToUser", "q", "violatingFragment", "targetFragment", "", "requestCode", "p", k.f40564b, l.f16298a, SsManifestParser.e.J, "Landroidx/fragment/app/strictmode/Violation;", "violation", "n", "Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "d", "h", "policy", "Ljava/lang/Class;", "fragmentClass", "violationClass", "u", "e", "Ljava/lang/Runnable;", "runnable", an.aB, "b", "Ljava/lang/String;", "TAG", "c", "Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "t", "(Landroidx/fragment/app/strictmode/FragmentStrictMode$b;)V", "defaultPolicy", "<init>", "()V", "Flag", "a", "fragment_release"}, k = 1, mv = {1, 6, 0})
public final class FragmentStrictMode {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public static final String f6031b = "FragmentStrictMode";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final FragmentStrictMode f6030a = new FragmentStrictMode();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static b f6032c = b.f6034e;

    @d0(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "", "(Ljava/lang/String;I)V", "PENALTY_LOG", "PENALTY_DEATH", "DETECT_FRAGMENT_REUSE", "DETECT_FRAGMENT_TAG_USAGE", "DETECT_RETAIN_INSTANCE_USAGE", "DETECT_SET_USER_VISIBLE_HINT", "DETECT_TARGET_FRAGMENT_USAGE", "DETECT_WRONG_FRAGMENT_CONTAINER", "fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Flag {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    @d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$a;", "", "Landroidx/fragment/app/strictmode/Violation;", "violation", "Lkotlin/z1;", "a", "fragment_release"}, k = 1, mv = {1, 6, 0})
    public interface a {
        void a(@yt.k Violation violation);
    }

    @d0(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0002\u0004\tBC\b\u0000\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u0012 \u0010\u0016\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f0\u00150\r¢\u0006\u0004\b\u0017\u0010\u0018R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR4\u0010\u0014\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f0\u00020\r8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u001a"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "a", "Ljava/util/Set;", "()Ljava/util/Set;", "flags", "Landroidx/fragment/app/strictmode/FragmentStrictMode$a;", "b", "Landroidx/fragment/app/strictmode/FragmentStrictMode$a;", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$a;", "listener", "", "", "Ljava/lang/Class;", "Landroidx/fragment/app/strictmode/Violation;", "c", "Ljava/util/Map;", "()Ljava/util/Map;", "mAllowedViolations", "", "allowedViolations", "<init>", "(Ljava/util/Set;Landroidx/fragment/app/strictmode/FragmentStrictMode$a;Ljava/util/Map;)V", "d", "fragment_release"}, k = 1, mv = {1, 6, 0})
    public static final class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @yt.k
        public static final C0051b f6033d = new C0051b(null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @e
        @yt.k
        public static final b f6034e = new b(d1.k(), null, s0.z());

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final Set<Flag> f6035a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.l
        public final a f6036b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.k
        public final Map<String, Set<Class<? extends Violation>>> f6037c;

        @d0(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0002\u001a\u00020\u0000H\u0007J\b\u0010\u0003\u001a\u00020\u0000H\u0007J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0000H\u0007J\b\u0010\b\u001a\u00020\u0000H\u0007J\b\u0010\t\u001a\u00020\u0000H\u0007J\b\u0010\n\u001a\u00020\u0000H\u0007J\b\u0010\u000b\u001a\u00020\u0000H\u0007J\b\u0010\f\u001a\u00020\u0000H\u0007J(\u0010\u0012\u001a\u00020\u00002\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r2\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\rH\u0007J \u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00132\u000e\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\rH\u0007J\u0006\u0010\u0016\u001a\u00020\u0015R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0019R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001bR.\u0010\u001e\u001a\u001c\u0012\u0004\u0012\u00020\u0013\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\r0\u00170\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001d¨\u0006!"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$b$a;", "", l.f16298a, j.f55230b, "Landroidx/fragment/app/strictmode/FragmentStrictMode$a;", "listener", "k", "d", "e", "f", "g", "h", "i", "Ljava/lang/Class;", "Landroidx/fragment/app/Fragment;", "fragmentClass", "Landroidx/fragment/app/strictmode/Violation;", "violationClass", "a", "", "b", "Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "c", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "Ljava/util/Set;", "flags", "Landroidx/fragment/app/strictmode/FragmentStrictMode$a;", "", "Ljava/util/Map;", "mAllowedViolations", "<init>", "()V", "fragment_release"}, k = 1, mv = {1, 6, 0})
        public static final class a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @yt.l
            public a f6039b;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @yt.k
            public final Set<Flag> f6038a = new LinkedHashSet();

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @yt.k
            public final Map<String, Set<Class<? extends Violation>>> f6040c = new LinkedHashMap();

            @yt.k
            @SuppressLint({"BuilderSetStyle"})
            public final a a(@yt.k Class<? extends Fragment> fragmentClass, @yt.k Class<? extends Violation> violationClass) {
                f0.p(fragmentClass, "fragmentClass");
                f0.p(violationClass, "violationClass");
                String fragmentClassString = fragmentClass.getName();
                f0.o(fragmentClassString, "fragmentClassString");
                return b(fragmentClassString, violationClass);
            }

            @yt.k
            @SuppressLint({"BuilderSetStyle"})
            public final a b(@yt.k String fragmentClass, @yt.k Class<? extends Violation> violationClass) {
                f0.p(fragmentClass, "fragmentClass");
                f0.p(violationClass, "violationClass");
                Set<Class<? extends Violation>> linkedHashSet = this.f6040c.get(fragmentClass);
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet<>();
                }
                linkedHashSet.add(violationClass);
                this.f6040c.put(fragmentClass, linkedHashSet);
                return this;
            }

            @yt.k
            public final b c() {
                if (this.f6039b == null && !this.f6038a.contains(Flag.PENALTY_DEATH)) {
                    l();
                }
                return new b(this.f6038a, this.f6039b, this.f6040c);
            }

            @yt.k
            @SuppressLint({"BuilderSetStyle"})
            public final a d() {
                this.f6038a.add(Flag.DETECT_FRAGMENT_REUSE);
                return this;
            }

            @yt.k
            @SuppressLint({"BuilderSetStyle"})
            public final a e() {
                this.f6038a.add(Flag.DETECT_FRAGMENT_TAG_USAGE);
                return this;
            }

            @yt.k
            @SuppressLint({"BuilderSetStyle"})
            public final a f() {
                this.f6038a.add(Flag.DETECT_RETAIN_INSTANCE_USAGE);
                return this;
            }

            @yt.k
            @SuppressLint({"BuilderSetStyle"})
            public final a g() {
                this.f6038a.add(Flag.DETECT_SET_USER_VISIBLE_HINT);
                return this;
            }

            @yt.k
            @SuppressLint({"BuilderSetStyle"})
            public final a h() {
                this.f6038a.add(Flag.DETECT_TARGET_FRAGMENT_USAGE);
                return this;
            }

            @yt.k
            @SuppressLint({"BuilderSetStyle"})
            public final a i() {
                this.f6038a.add(Flag.DETECT_WRONG_FRAGMENT_CONTAINER);
                return this;
            }

            @yt.k
            @SuppressLint({"BuilderSetStyle"})
            public final a j() {
                this.f6038a.add(Flag.PENALTY_DEATH);
                return this;
            }

            @yt.k
            @SuppressLint({"BuilderSetStyle"})
            public final a k(@yt.k a listener) {
                f0.p(listener, "listener");
                this.f6039b = listener;
                return this;
            }

            @yt.k
            @SuppressLint({"BuilderSetStyle"})
            public final a l() {
                this.f6038a.add(Flag.PENALTY_LOG);
                return this;
            }
        }

        /* JADX INFO: renamed from: androidx.fragment.app.strictmode.FragmentStrictMode$b$b, reason: collision with other inner class name */
        @d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$b$b;", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "LAX", "Landroidx/fragment/app/strictmode/FragmentStrictMode$b;", "<init>", "()V", "fragment_release"}, k = 1, mv = {1, 6, 0})
        public static final class C0051b {
            public C0051b() {
            }

            public /* synthetic */ C0051b(u uVar) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(@yt.k Set<? extends Flag> flags, @yt.l a aVar, @yt.k Map<String, ? extends Set<Class<? extends Violation>>> allowedViolations) {
            f0.p(flags, "flags");
            f0.p(allowedViolations, "allowedViolations");
            this.f6035a = flags;
            this.f6036b = aVar;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Set<Class<? extends Violation>>> entry : allowedViolations.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            this.f6037c = linkedHashMap;
        }

        @yt.k
        public final Set<Flag> a() {
            return this.f6035a;
        }

        @yt.l
        public final a b() {
            return this.f6036b;
        }

        @yt.k
        public final Map<String, Set<Class<? extends Violation>>> c() {
            return this.f6037c;
        }
    }

    public static final void f(b policy, Violation violation) {
        f0.p(policy, "$policy");
        f0.p(violation, "$violation");
        policy.b().a(violation);
    }

    public static final void g(String str, Violation violation) {
        f0.p(violation, "$violation");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Policy violation with PENALTY_DEATH in ");
        sb2.append(str);
        throw violation;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void i(@yt.k Fragment fragment, @yt.k String previousFragmentId) {
        f0.p(fragment, "fragment");
        f0.p(previousFragmentId, "previousFragmentId");
        FragmentReuseViolation fragmentReuseViolation = new FragmentReuseViolation(fragment, previousFragmentId);
        FragmentStrictMode fragmentStrictMode = f6030a;
        fragmentStrictMode.h(fragmentReuseViolation);
        b bVarD = fragmentStrictMode.d(fragment);
        if (bVarD.a().contains(Flag.DETECT_FRAGMENT_REUSE) && fragmentStrictMode.u(bVarD, fragment.getClass(), fragmentReuseViolation.getClass())) {
            fragmentStrictMode.e(bVarD, fragmentReuseViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void j(@yt.k Fragment fragment, @yt.l ViewGroup viewGroup) {
        f0.p(fragment, "fragment");
        FragmentTagUsageViolation fragmentTagUsageViolation = new FragmentTagUsageViolation(fragment, viewGroup);
        FragmentStrictMode fragmentStrictMode = f6030a;
        fragmentStrictMode.h(fragmentTagUsageViolation);
        b bVarD = fragmentStrictMode.d(fragment);
        if (bVarD.a().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) && fragmentStrictMode.u(bVarD, fragment.getClass(), fragmentTagUsageViolation.getClass())) {
            fragmentStrictMode.e(bVarD, fragmentTagUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void k(@yt.k Fragment fragment) {
        f0.p(fragment, "fragment");
        GetRetainInstanceUsageViolation getRetainInstanceUsageViolation = new GetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f6030a;
        fragmentStrictMode.h(getRetainInstanceUsageViolation);
        b bVarD = fragmentStrictMode.d(fragment);
        if (bVarD.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.u(bVarD, fragment.getClass(), getRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.e(bVarD, getRetainInstanceUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void l(@yt.k Fragment fragment) {
        f0.p(fragment, "fragment");
        GetTargetFragmentRequestCodeUsageViolation getTargetFragmentRequestCodeUsageViolation = new GetTargetFragmentRequestCodeUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f6030a;
        fragmentStrictMode.h(getTargetFragmentRequestCodeUsageViolation);
        b bVarD = fragmentStrictMode.d(fragment);
        if (bVarD.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.u(bVarD, fragment.getClass(), getTargetFragmentRequestCodeUsageViolation.getClass())) {
            fragmentStrictMode.e(bVarD, getTargetFragmentRequestCodeUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void m(@yt.k Fragment fragment) {
        f0.p(fragment, "fragment");
        GetTargetFragmentUsageViolation getTargetFragmentUsageViolation = new GetTargetFragmentUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f6030a;
        fragmentStrictMode.h(getTargetFragmentUsageViolation);
        b bVarD = fragmentStrictMode.d(fragment);
        if (bVarD.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.u(bVarD, fragment.getClass(), getTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.e(bVarD, getTargetFragmentUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void o(@yt.k Fragment fragment) {
        f0.p(fragment, "fragment");
        SetRetainInstanceUsageViolation setRetainInstanceUsageViolation = new SetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = f6030a;
        fragmentStrictMode.h(setRetainInstanceUsageViolation);
        b bVarD = fragmentStrictMode.d(fragment);
        if (bVarD.a().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.u(bVarD, fragment.getClass(), setRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.e(bVarD, setRetainInstanceUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void p(@yt.k Fragment violatingFragment, @yt.k Fragment targetFragment, int i10) {
        f0.p(violatingFragment, "violatingFragment");
        f0.p(targetFragment, "targetFragment");
        SetTargetFragmentUsageViolation setTargetFragmentUsageViolation = new SetTargetFragmentUsageViolation(violatingFragment, targetFragment, i10);
        FragmentStrictMode fragmentStrictMode = f6030a;
        fragmentStrictMode.h(setTargetFragmentUsageViolation);
        b bVarD = fragmentStrictMode.d(violatingFragment);
        if (bVarD.a().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.u(bVarD, violatingFragment.getClass(), setTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.e(bVarD, setTargetFragmentUsageViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void q(@yt.k Fragment fragment, boolean z10) {
        f0.p(fragment, "fragment");
        SetUserVisibleHintViolation setUserVisibleHintViolation = new SetUserVisibleHintViolation(fragment, z10);
        FragmentStrictMode fragmentStrictMode = f6030a;
        fragmentStrictMode.h(setUserVisibleHintViolation);
        b bVarD = fragmentStrictMode.d(fragment);
        if (bVarD.a().contains(Flag.DETECT_SET_USER_VISIBLE_HINT) && fragmentStrictMode.u(bVarD, fragment.getClass(), setUserVisibleHintViolation.getClass())) {
            fragmentStrictMode.e(bVarD, setUserVisibleHintViolation);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void r(@yt.k Fragment fragment, @yt.k ViewGroup container) {
        f0.p(fragment, "fragment");
        f0.p(container, "container");
        WrongFragmentContainerViolation wrongFragmentContainerViolation = new WrongFragmentContainerViolation(fragment, container);
        FragmentStrictMode fragmentStrictMode = f6030a;
        fragmentStrictMode.h(wrongFragmentContainerViolation);
        b bVarD = fragmentStrictMode.d(fragment);
        if (bVarD.a().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) && fragmentStrictMode.u(bVarD, fragment.getClass(), wrongFragmentContainerViolation.getClass())) {
            fragmentStrictMode.e(bVarD, wrongFragmentContainerViolation);
        }
    }

    @yt.k
    public final b c() {
        return f6032c;
    }

    public final b d(Fragment fragment) {
        while (fragment != null) {
            if (fragment.s3()) {
                FragmentManager fragmentManagerL2 = fragment.L2();
                f0.o(fragmentManagerL2, "declaringFragment.parentFragmentManager");
                if (fragmentManagerL2.P0() != null) {
                    b bVarP0 = fragmentManagerL2.P0();
                    f0.m(bVarP0);
                    return bVarP0;
                }
            }
            fragment = fragment.J2();
        }
        return f6032c;
    }

    public final void e(final b bVar, final Violation violation) {
        Fragment fragmentA = violation.a();
        final String name = fragmentA.getClass().getName();
        if (bVar.a().contains(Flag.PENALTY_LOG)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Policy violation in ");
            sb2.append(name);
        }
        if (bVar.b() != null) {
            s(fragmentA, new Runnable() { // from class: j1.a
                @Override // java.lang.Runnable
                public final void run() {
                    FragmentStrictMode.f(bVar, violation);
                }
            });
        }
        if (bVar.a().contains(Flag.PENALTY_DEATH)) {
            s(fragmentA, new Runnable() { // from class: j1.b
                @Override // java.lang.Runnable
                public final void run() {
                    FragmentStrictMode.g(name, violation);
                }
            });
        }
    }

    public final void h(Violation violation) {
        if (FragmentManager.W0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("StrictMode violation in ");
            sb2.append(violation.a().getClass().getName());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @i1
    public final void n(@yt.k Violation violation) {
        f0.p(violation, "violation");
        h(violation);
        Fragment fragmentA = violation.a();
        b bVarD = d(fragmentA);
        if (u(bVarD, fragmentA.getClass(), violation.getClass())) {
            e(bVarD, violation);
        }
    }

    public final void s(Fragment fragment, Runnable runnable) {
        if (!fragment.s3()) {
            runnable.run();
            return;
        }
        Handler handlerH = fragment.L2().J0().h();
        f0.o(handlerH, "fragment.parentFragmentManager.host.handler");
        if (f0.g(handlerH.getLooper(), Looper.myLooper())) {
            runnable.run();
        } else {
            handlerH.post(runnable);
        }
    }

    public final void t(@yt.k b bVar) {
        f0.p(bVar, "<set-?>");
        f6032c = bVar;
    }

    public final boolean u(b bVar, Class<? extends Fragment> cls, Class<? extends Violation> cls2) {
        Set<Class<? extends Violation>> set = bVar.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (f0.g(cls2.getSuperclass(), Violation.class) || !CollectionsKt___CollectionsKt.R1(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }
}
