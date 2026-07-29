package h0;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import g.v0;
import h0.i;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f30122p = "IntentSanitizer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.core.util.w<String> f30124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.core.util.w<Uri> f30125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.core.util.w<String> f30126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public androidx.core.util.w<String> f30127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.core.util.w<String> f30128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public androidx.core.util.w<ComponentName> f30129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f30130h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, androidx.core.util.w<Object>> f30131i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f30132j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public androidx.core.util.w<Uri> f30133k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public androidx.core.util.w<ClipData> f30134l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f30135m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f30136n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f30137o;

    @v0(15)
    public static class b {
        @g.u
        public static Intent a(Intent intent) {
            return intent.getSelector();
        }

        @g.u
        public static void b(Intent intent, Intent intent2) {
            intent.setSelector(intent2);
        }
    }

    @v0(16)
    public static class c {

        @v0(31)
        public static class a {
            @g.u
            public static void a(int i10, ClipData.Item item, androidx.core.util.d<String> dVar) {
                if (item.getHtmlText() == null && item.getIntent() == null && item.getTextLinks() == null) {
                    return;
                }
                dVar.accept("ClipData item at position " + i10 + " contains htmlText, textLinks or intent: " + item);
            }
        }

        public static void a(int i10, ClipData.Item item, androidx.core.util.d<String> dVar) {
            if (item.getHtmlText() == null && item.getIntent() == null) {
                return;
            }
            dVar.accept("ClipData item at position " + i10 + " contains htmlText, textLinks or intent: " + item);
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x00bc  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x00cd  */
        @g.u
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static void b(@g.n0 android.content.Intent r7, android.content.Intent r8, androidx.core.util.w<android.content.ClipData> r9, boolean r10, androidx.core.util.w<android.net.Uri> r11, androidx.core.util.d<java.lang.String> r12) {
            /*
                Method dump skipped, instruction units count: 223
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: h0.i.c.b(android.content.Intent, android.content.Intent, androidx.core.util.w, boolean, androidx.core.util.w, androidx.core.util.d):void");
        }
    }

    @v0(29)
    public static class d {
        @g.u
        public static String a(Intent intent) {
            return intent.getIdentifier();
        }

        @g.u
        public static Intent b(Intent intent, String str) {
            return intent.setIdentifier(str);
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f30138q = 2112614400;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final int f30139r = 2015363072;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30140a;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f30147h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f30148i;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f30153n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f30154o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f30155p;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public androidx.core.util.w<String> f30141b = new androidx.core.util.w() { // from class: h0.o
            @Override // androidx.core.util.w
            public final boolean a(Object obj) {
                return i.e.g0((String) obj);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w b(androidx.core.util.w wVar) {
                return androidx.core.util.v.a(this, wVar);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w c() {
                return androidx.core.util.v.b(this);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w d(androidx.core.util.w wVar) {
                return androidx.core.util.v.c(this, wVar);
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.core.util.w<Uri> f30142c = new androidx.core.util.w() { // from class: h0.m
            @Override // androidx.core.util.w
            public final boolean a(Object obj) {
                return i.e.h0((Uri) obj);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w b(androidx.core.util.w wVar) {
                return androidx.core.util.v.a(this, wVar);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w c() {
                return androidx.core.util.v.b(this);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w d(androidx.core.util.w wVar) {
                return androidx.core.util.v.c(this, wVar);
            }
        };

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public androidx.core.util.w<String> f30143d = new androidx.core.util.w() { // from class: h0.n
            @Override // androidx.core.util.w
            public final boolean a(Object obj) {
                return i.e.i0((String) obj);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w b(androidx.core.util.w wVar) {
                return androidx.core.util.v.a(this, wVar);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w c() {
                return androidx.core.util.v.b(this);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w d(androidx.core.util.w wVar) {
                return androidx.core.util.v.c(this, wVar);
            }
        };

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public androidx.core.util.w<String> f30144e = new androidx.core.util.w() { // from class: h0.q
            @Override // androidx.core.util.w
            public final boolean a(Object obj) {
                return i.e.j0((String) obj);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w b(androidx.core.util.w wVar) {
                return androidx.core.util.v.a(this, wVar);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w c() {
                return androidx.core.util.v.b(this);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w d(androidx.core.util.w wVar) {
                return androidx.core.util.v.c(this, wVar);
            }
        };

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public androidx.core.util.w<String> f30145f = new androidx.core.util.w() { // from class: h0.p
            @Override // androidx.core.util.w
            public final boolean a(Object obj) {
                return i.e.k0((String) obj);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w b(androidx.core.util.w wVar) {
                return androidx.core.util.v.a(this, wVar);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w c() {
                return androidx.core.util.v.b(this);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w d(androidx.core.util.w wVar) {
                return androidx.core.util.v.c(this, wVar);
            }
        };

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public androidx.core.util.w<ComponentName> f30146g = new androidx.core.util.w() { // from class: h0.k
            @Override // androidx.core.util.w
            public final boolean a(Object obj) {
                return i.e.l0((ComponentName) obj);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w b(androidx.core.util.w wVar) {
                return androidx.core.util.v.a(this, wVar);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w c() {
                return androidx.core.util.v.b(this);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w d(androidx.core.util.w wVar) {
                return androidx.core.util.v.c(this, wVar);
            }
        };

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Map<String, androidx.core.util.w<Object>> f30149j = new HashMap();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f30150k = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public androidx.core.util.w<Uri> f30151l = new androidx.core.util.w() { // from class: h0.l
            @Override // androidx.core.util.w
            public final boolean a(Object obj) {
                return i.e.m0((Uri) obj);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w b(androidx.core.util.w wVar) {
                return androidx.core.util.v.a(this, wVar);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w c() {
                return androidx.core.util.v.b(this);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w d(androidx.core.util.w wVar) {
                return androidx.core.util.v.c(this, wVar);
            }
        };

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public androidx.core.util.w<ClipData> f30152m = new androidx.core.util.w() { // from class: h0.a0
            @Override // androidx.core.util.w
            public final boolean a(Object obj) {
                return i.e.n0((ClipData) obj);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w b(androidx.core.util.w wVar) {
                return androidx.core.util.v.a(this, wVar);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w c() {
                return androidx.core.util.v.b(this);
            }

            @Override // androidx.core.util.w
            public /* synthetic */ androidx.core.util.w d(androidx.core.util.w wVar) {
                return androidx.core.util.v.c(this, wVar);
            }
        };

        public static /* synthetic */ boolean X(ComponentName componentName) {
            return true;
        }

        public static /* synthetic */ boolean Y(String str, Uri uri) {
            return str.equals(uri.getAuthority());
        }

        public static /* synthetic */ boolean Z(String str, ComponentName componentName) {
            return str.equals(componentName.getPackageName());
        }

        public static /* synthetic */ boolean a0(String str, Uri uri) {
            return str.equals(uri.getAuthority());
        }

        public static /* synthetic */ boolean b0(Object obj) {
            return true;
        }

        public static /* synthetic */ boolean c0(Class cls, androidx.core.util.w wVar, Object obj) {
            return cls.isInstance(obj) && wVar.a(cls.cast(obj));
        }

        public static /* synthetic */ boolean d0(Object obj) {
            return false;
        }

        public static /* synthetic */ boolean e0(String str, Uri uri) {
            return str.equals(uri.getAuthority());
        }

        public static /* synthetic */ boolean f0(String str, Uri uri) {
            return str.equals(uri.getAuthority());
        }

        public static /* synthetic */ boolean g0(String str) {
            return false;
        }

        public static /* synthetic */ boolean h0(Uri uri) {
            return false;
        }

        public static /* synthetic */ boolean i0(String str) {
            return false;
        }

        public static /* synthetic */ boolean j0(String str) {
            return false;
        }

        public static /* synthetic */ boolean k0(String str) {
            return false;
        }

        public static /* synthetic */ boolean l0(ComponentName componentName) {
            return false;
        }

        public static /* synthetic */ boolean m0(Uri uri) {
            return false;
        }

        public static /* synthetic */ boolean n0(ClipData clipData) {
            return false;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e A(@g.n0 final ComponentName componentName) {
            androidx.core.util.o.l(componentName);
            Objects.requireNonNull(componentName);
            return B(new androidx.core.util.w() { // from class: h0.j
                @Override // androidx.core.util.w
                public final boolean a(Object obj) {
                    return componentName.equals((ComponentName) obj);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w b(androidx.core.util.w wVar) {
                    return androidx.core.util.v.a(this, wVar);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w c() {
                    return androidx.core.util.v.b(this);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w d(androidx.core.util.w wVar) {
                    return androidx.core.util.v.c(this, wVar);
                }
            });
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e B(@g.n0 androidx.core.util.w<ComponentName> wVar) {
            androidx.core.util.o.l(wVar);
            this.f30148i = true;
            this.f30146g = this.f30146g.d(wVar);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e C(@g.n0 final String str) {
            androidx.core.util.o.l(str);
            return B(new androidx.core.util.w() { // from class: h0.u
                @Override // androidx.core.util.w
                public final boolean a(Object obj) {
                    return i.e.Z(str, (ComponentName) obj);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w b(androidx.core.util.w wVar) {
                    return androidx.core.util.v.a(this, wVar);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w c() {
                    return androidx.core.util.v.b(this);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w d(androidx.core.util.w wVar) {
                    return androidx.core.util.v.c(this, wVar);
                }
            });
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e D(@g.n0 androidx.core.util.w<Uri> wVar) {
            androidx.core.util.o.l(wVar);
            this.f30142c = this.f30142c.d(wVar);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e E(@g.n0 final String str) {
            androidx.core.util.o.l(str);
            D(new androidx.core.util.w() { // from class: h0.x
                @Override // androidx.core.util.w
                public final boolean a(Object obj) {
                    return i.e.a0(str, (Uri) obj);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w b(androidx.core.util.w wVar) {
                    return androidx.core.util.v.a(this, wVar);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w c() {
                    return androidx.core.util.v.b(this);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w d(androidx.core.util.w wVar) {
                    return androidx.core.util.v.c(this, wVar);
                }
            });
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e F(@g.n0 String str, @g.n0 androidx.core.util.w<Object> wVar) {
            androidx.core.util.o.l(str);
            androidx.core.util.o.l(wVar);
            androidx.core.util.w<Object> wVar2 = this.f30149j.get(str);
            if (wVar2 == null) {
                wVar2 = new androidx.core.util.w() { // from class: h0.r
                    @Override // androidx.core.util.w
                    public final boolean a(Object obj) {
                        return i.e.d0(obj);
                    }

                    @Override // androidx.core.util.w
                    public /* synthetic */ androidx.core.util.w b(androidx.core.util.w wVar3) {
                        return androidx.core.util.v.a(this, wVar3);
                    }

                    @Override // androidx.core.util.w
                    public /* synthetic */ androidx.core.util.w c() {
                        return androidx.core.util.v.b(this);
                    }

                    @Override // androidx.core.util.w
                    public /* synthetic */ androidx.core.util.w d(androidx.core.util.w wVar3) {
                        return androidx.core.util.v.c(this, wVar3);
                    }
                };
            }
            this.f30149j.put(str, wVar2.d(wVar));
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e G(@g.n0 String str, @g.n0 Class<?> cls) {
            return H(str, cls, new androidx.core.util.w() { // from class: h0.s
                @Override // androidx.core.util.w
                public final boolean a(Object obj) {
                    return i.e.b0(obj);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w b(androidx.core.util.w wVar) {
                    return androidx.core.util.v.a(this, wVar);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w c() {
                    return androidx.core.util.v.b(this);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w d(androidx.core.util.w wVar) {
                    return androidx.core.util.v.c(this, wVar);
                }
            });
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public <T> e H(@g.n0 String str, @g.n0 final Class<T> cls, @g.n0 final androidx.core.util.w<T> wVar) {
            androidx.core.util.o.l(str);
            androidx.core.util.o.l(cls);
            androidx.core.util.o.l(wVar);
            return F(str, new androidx.core.util.w() { // from class: h0.t
                @Override // androidx.core.util.w
                public final boolean a(Object obj) {
                    return i.e.c0(cls, wVar, obj);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w b(androidx.core.util.w wVar2) {
                    return androidx.core.util.v.a(this, wVar2);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w c() {
                    return androidx.core.util.v.b(this);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w d(androidx.core.util.w wVar2) {
                    return androidx.core.util.v.c(this, wVar2);
                }
            });
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e I(@g.n0 androidx.core.util.w<Uri> wVar) {
            H("output", Uri.class, wVar);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e J(@g.n0 final String str) {
            H("output", Uri.class, new androidx.core.util.w() { // from class: h0.v
                @Override // androidx.core.util.w
                public final boolean a(Object obj) {
                    return i.e.e0(str, (Uri) obj);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w b(androidx.core.util.w wVar) {
                    return androidx.core.util.v.a(this, wVar);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w c() {
                    return androidx.core.util.v.b(this);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w d(androidx.core.util.w wVar) {
                    return androidx.core.util.v.c(this, wVar);
                }
            });
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e K(@g.n0 androidx.core.util.w<Uri> wVar) {
            H("android.intent.extra.STREAM", Uri.class, wVar);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e L(@g.n0 final String str) {
            androidx.core.util.o.l(str);
            H("android.intent.extra.STREAM", Uri.class, new androidx.core.util.w() { // from class: h0.y
                @Override // androidx.core.util.w
                public final boolean a(Object obj) {
                    return i.e.f0(str, (Uri) obj);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w b(androidx.core.util.w wVar) {
                    return androidx.core.util.v.a(this, wVar);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w c() {
                    return androidx.core.util.v.b(this);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w d(androidx.core.util.w wVar) {
                    return androidx.core.util.v.c(this, wVar);
                }
            });
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e M(int i10) {
            this.f30140a = i10 | this.f30140a;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e N() {
            this.f30140a |= f30138q;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e O() {
            this.f30153n = true;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e P(@g.n0 androidx.core.util.w<String> wVar) {
            androidx.core.util.o.l(wVar);
            this.f30145f = this.f30145f.d(wVar);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e Q(@g.n0 String str) {
            androidx.core.util.o.l(str);
            Objects.requireNonNull(str);
            return P(new z(str));
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e R() {
            this.f30140a |= f30139r;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e S() {
            this.f30154o = true;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e T() {
            this.f30155p = true;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e U(@g.n0 androidx.core.util.w<String> wVar) {
            androidx.core.util.o.l(wVar);
            this.f30143d = this.f30143d.d(wVar);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e V(@g.n0 String str) {
            androidx.core.util.o.l(str);
            Objects.requireNonNull(str);
            return U(new z(str));
        }

        @SuppressLint({"SyntheticAccessor"})
        @g.n0
        public i W() {
            boolean z10 = this.f30147h;
            if ((z10 && this.f30148i) || (!z10 && !this.f30148i)) {
                throw new SecurityException("You must call either allowAnyComponent or one or more of the allowComponent methods; but not both.");
            }
            i iVar = new i();
            iVar.f30123a = this.f30140a;
            iVar.f30124b = this.f30141b;
            iVar.f30125c = this.f30142c;
            iVar.f30126d = this.f30143d;
            iVar.f30127e = this.f30144e;
            iVar.f30128f = this.f30145f;
            iVar.f30130h = this.f30147h;
            iVar.f30129g = this.f30146g;
            iVar.f30131i = this.f30149j;
            iVar.f30132j = this.f30150k;
            iVar.f30133k = this.f30151l;
            iVar.f30134l = this.f30152m;
            iVar.f30135m = this.f30153n;
            iVar.f30136n = this.f30154o;
            iVar.f30137o = this.f30155p;
            return iVar;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e r(@g.n0 androidx.core.util.w<String> wVar) {
            androidx.core.util.o.l(wVar);
            this.f30141b = this.f30141b.d(wVar);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e s(@g.n0 String str) {
            androidx.core.util.o.l(str);
            Objects.requireNonNull(str);
            r(new z(str));
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e t() {
            this.f30147h = true;
            this.f30146g = new androidx.core.util.w() { // from class: h0.b0
                @Override // androidx.core.util.w
                public final boolean a(Object obj) {
                    return i.e.X((ComponentName) obj);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w b(androidx.core.util.w wVar) {
                    return androidx.core.util.v.a(this, wVar);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w c() {
                    return androidx.core.util.v.b(this);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w d(androidx.core.util.w wVar) {
                    return androidx.core.util.v.c(this, wVar);
                }
            };
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e u(@g.n0 androidx.core.util.w<String> wVar) {
            androidx.core.util.o.l(wVar);
            this.f30144e = this.f30144e.d(wVar);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e v(@g.n0 String str) {
            androidx.core.util.o.l(str);
            Objects.requireNonNull(str);
            return u(new z(str));
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e w(@g.n0 androidx.core.util.w<ClipData> wVar) {
            androidx.core.util.o.l(wVar);
            this.f30152m = this.f30152m.d(wVar);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e x() {
            this.f30150k = true;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e y(@g.n0 androidx.core.util.w<Uri> wVar) {
            androidx.core.util.o.l(wVar);
            this.f30151l = this.f30151l.d(wVar);
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public e z(@g.n0 final String str) {
            androidx.core.util.o.l(str);
            return y(new androidx.core.util.w() { // from class: h0.w
                @Override // androidx.core.util.w
                public final boolean a(Object obj) {
                    return i.e.Y(str, (Uri) obj);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w b(androidx.core.util.w wVar) {
                    return androidx.core.util.v.a(this, wVar);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w c() {
                    return androidx.core.util.v.b(this);
                }

                @Override // androidx.core.util.w
                public /* synthetic */ androidx.core.util.w d(androidx.core.util.w wVar) {
                    return androidx.core.util.v.c(this, wVar);
                }
            });
        }
    }

    public static /* synthetic */ void r(String str) {
    }

    public static /* synthetic */ void s(String str) {
        throw new SecurityException(str);
    }

    public final void t(Intent intent, String str, Object obj) {
        if (obj == null) {
            intent.getExtras().putString(str, null);
            return;
        }
        if (obj instanceof Parcelable) {
            intent.putExtra(str, (Parcelable) obj);
            return;
        }
        if (obj instanceof Parcelable[]) {
            intent.putExtra(str, (Parcelable[]) obj);
        } else {
            if (obj instanceof Serializable) {
                intent.putExtra(str, (Serializable) obj);
                return;
            }
            throw new IllegalArgumentException("Unsupported type " + obj.getClass());
        }
    }

    @g.n0
    public Intent u(@g.n0 Intent intent, @g.n0 androidx.core.util.d<String> dVar) {
        Intent intent2 = new Intent();
        ComponentName component = intent.getComponent();
        if ((this.f30130h && component == null) || this.f30129g.a(component)) {
            intent2.setComponent(component);
        } else {
            dVar.accept("Component is not allowed: " + component);
            intent2.setComponent(new ComponentName(l4.f.f39447b, "java.lang.Void"));
        }
        String str = intent.getPackage();
        if (str == null || this.f30128f.a(str)) {
            intent2.setPackage(str);
        } else {
            dVar.accept("Package is not allowed: " + str);
        }
        int flags = this.f30123a | intent.getFlags();
        int i10 = this.f30123a;
        if (flags == i10) {
            intent2.setFlags(intent.getFlags());
        } else {
            intent2.setFlags(intent.getFlags() & i10);
            dVar.accept("The intent contains flags that are not allowed: 0x" + Integer.toHexString(intent.getFlags() & (~this.f30123a)));
        }
        String action = intent.getAction();
        if (action == null || this.f30124b.a(action)) {
            intent2.setAction(action);
        } else {
            dVar.accept("Action is not allowed: " + action);
        }
        Uri data = intent.getData();
        if (data == null || this.f30125c.a(data)) {
            intent2.setData(data);
        } else {
            dVar.accept("Data is not allowed: " + data);
        }
        String type = intent.getType();
        if (type == null || this.f30126d.a(type)) {
            intent2.setDataAndType(intent2.getData(), type);
        } else {
            dVar.accept("Type is not allowed: " + type);
        }
        Set<String> categories = intent.getCategories();
        if (categories != null) {
            for (String str2 : categories) {
                if (this.f30127e.a(str2)) {
                    intent2.addCategory(str2);
                } else {
                    dVar.accept("Category is not allowed: " + str2);
                }
            }
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (String str3 : extras.keySet()) {
                if (str3.equals("android.intent.extra.STREAM") && (this.f30123a & 1) == 0) {
                    dVar.accept("Allowing Extra Stream requires also allowing at least  FLAG_GRANT_READ_URI_PERMISSION Flag.");
                } else if (!str3.equals("output") || ((~this.f30123a) & 3) == 0) {
                    Object obj = extras.get(str3);
                    androidx.core.util.w<Object> wVar = this.f30131i.get(str3);
                    if (wVar == null || !wVar.a(obj)) {
                        dVar.accept("Extra is not allowed. Key: " + str3 + ". Value: " + obj);
                    } else {
                        t(intent2, str3, obj);
                    }
                } else {
                    dVar.accept("Allowing Extra Output requires also allowing FLAG_GRANT_READ_URI_PERMISSION and FLAG_GRANT_WRITE_URI_PERMISSION Flags.");
                }
            }
        }
        int i11 = Build.VERSION.SDK_INT;
        c.b(intent, intent2, this.f30134l, this.f30132j, this.f30133k, dVar);
        if (i11 >= 29) {
            if (this.f30135m) {
                d.b(intent2, d.a(intent));
            } else if (d.a(intent) != null) {
                dVar.accept("Identifier is not allowed: " + d.a(intent));
            }
        }
        if (this.f30136n) {
            b.b(intent2, b.a(intent));
        } else if (b.a(intent) != null) {
            dVar.accept("Selector is not allowed: " + b.a(intent));
        }
        if (this.f30137o) {
            intent2.setSourceBounds(intent.getSourceBounds());
        } else if (intent.getSourceBounds() != null) {
            dVar.accept("SourceBounds is not allowed: " + intent.getSourceBounds());
        }
        return intent2;
    }

    @g.n0
    public Intent v(@g.n0 Intent intent) {
        return u(intent, new androidx.core.util.d() { // from class: h0.h
            @Override // androidx.core.util.d
            public final void accept(Object obj) {
                i.r((String) obj);
            }
        });
    }

    @g.n0
    public Intent w(@g.n0 Intent intent) {
        return u(intent, new androidx.core.util.d() { // from class: h0.g
            @Override // androidx.core.util.d
            public final void accept(Object obj) {
                i.s((String) obj);
            }
        });
    }

    public i() {
    }
}
