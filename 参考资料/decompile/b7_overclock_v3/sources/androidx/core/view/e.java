package androidx.core.view;

import android.content.ClipData;
import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.ContentInfo;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f4846b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f4847c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f4848d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f4849e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f4850f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f4851g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f4852h = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final g f4853a;

    @g.v0(31)
    public static final class a {
        @g.u
        @g.n0
        public static Pair<ContentInfo, ContentInfo> a(@g.n0 ContentInfo contentInfo, @g.n0 final Predicate<ClipData.Item> predicate) {
            ClipData clip = contentInfo.getClip();
            if (clip.getItemCount() != 1) {
                Objects.requireNonNull(predicate);
                Pair<ClipData, ClipData> pairH = e.h(clip, new androidx.core.util.w() { // from class: androidx.core.view.d
                    @Override // androidx.core.util.w
                    public final boolean a(Object obj) {
                        return predicate.test((ClipData.Item) obj);
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
                return pairH.first == null ? Pair.create(null, contentInfo) : pairH.second == null ? Pair.create(contentInfo, null) : Pair.create(new ContentInfo.Builder(contentInfo).setClip((ClipData) pairH.first).build(), new ContentInfo.Builder(contentInfo).setClip((ClipData) pairH.second).build());
            }
            boolean zTest = predicate.test(clip.getItemAt(0));
            ContentInfo contentInfo2 = zTest ? contentInfo : null;
            if (zTest) {
                contentInfo = null;
            }
            return Pair.create(contentInfo2, contentInfo);
        }
    }

    public interface d {
        @g.n0
        e a();

        void b(int i10);

        void c(int i10);

        void d(@g.p0 Uri uri);

        void e(@g.n0 ClipData clipData);

        void setExtras(@g.p0 Bundle bundle);
    }

    @g.v0(31)
    public static final class f implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g.n0
        public final ContentInfo f4861a;

        public f(@g.n0 ContentInfo contentInfo) {
            this.f4861a = (ContentInfo) androidx.core.util.o.l(contentInfo);
        }

        @Override // androidx.core.view.e.g
        @g.p0
        public Uri a() {
            return this.f4861a.getLinkUri();
        }

        @Override // androidx.core.view.e.g
        @g.n0
        public ClipData b() {
            return this.f4861a.getClip();
        }

        @Override // androidx.core.view.e.g
        @g.n0
        public ContentInfo c() {
            return this.f4861a;
        }

        @Override // androidx.core.view.e.g
        public int d() {
            return this.f4861a.getSource();
        }

        @Override // androidx.core.view.e.g
        public int e() {
            return this.f4861a.getFlags();
        }

        @Override // androidx.core.view.e.g
        @g.p0
        public Bundle getExtras() {
            return this.f4861a.getExtras();
        }

        @g.n0
        public String toString() {
            return "ContentInfoCompat{" + this.f4861a + zc.a.f58317e;
        }
    }

    public interface g {
        @g.p0
        Uri a();

        @g.n0
        ClipData b();

        @g.p0
        ContentInfo c();

        int d();

        int e();

        @g.p0
        Bundle getExtras();
    }

    public static final class h implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g.n0
        public final ClipData f4862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f4863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f4864c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @g.p0
        public final Uri f4865d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @g.p0
        public final Bundle f4866e;

        public h(C0043e c0043e) {
            this.f4862a = (ClipData) androidx.core.util.o.l(c0043e.f4856a);
            this.f4863b = androidx.core.util.o.g(c0043e.f4857b, 0, 5, "source");
            this.f4864c = androidx.core.util.o.k(c0043e.f4858c, 1);
            this.f4865d = c0043e.f4859d;
            this.f4866e = c0043e.f4860e;
        }

        @Override // androidx.core.view.e.g
        @g.p0
        public Uri a() {
            return this.f4865d;
        }

        @Override // androidx.core.view.e.g
        @g.n0
        public ClipData b() {
            return this.f4862a;
        }

        @Override // androidx.core.view.e.g
        @g.p0
        public ContentInfo c() {
            return null;
        }

        @Override // androidx.core.view.e.g
        public int d() {
            return this.f4863b;
        }

        @Override // androidx.core.view.e.g
        public int e() {
            return this.f4864c;
        }

        @Override // androidx.core.view.e.g
        @g.p0
        public Bundle getExtras() {
            return this.f4866e;
        }

        @g.n0
        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ContentInfoCompat{clip=");
            sb2.append(this.f4862a.getDescription());
            sb2.append(", source=");
            sb2.append(e.k(this.f4863b));
            sb2.append(", flags=");
            sb2.append(e.b(this.f4864c));
            if (this.f4865d == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.f4865d.toString().length() + ee.a.f26979d;
            }
            sb2.append(str);
            sb2.append(this.f4866e != null ? ", hasExtras" : "");
            sb2.append(zc.a.f58317e);
            return sb2.toString();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface i {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface j {
    }

    public e(@g.n0 g gVar) {
        this.f4853a = gVar;
    }

    @g.n0
    public static ClipData a(@g.n0 ClipDescription clipDescription, @g.n0 List<ClipData.Item> list) {
        ClipData clipData = new ClipData(new ClipDescription(clipDescription), list.get(0));
        for (int i10 = 1; i10 < list.size(); i10++) {
            clipData.addItem(list.get(i10));
        }
        return clipData;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @g.n0
    public static String b(int i10) {
        return (i10 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i10);
    }

    @g.n0
    public static Pair<ClipData, ClipData> h(@g.n0 ClipData clipData, @g.n0 androidx.core.util.w<ClipData.Item> wVar) {
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (int i10 = 0; i10 < clipData.getItemCount(); i10++) {
            ClipData.Item itemAt = clipData.getItemAt(i10);
            if (wVar.a(itemAt)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(itemAt);
            } else {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(itemAt);
            }
        }
        return arrayList == null ? Pair.create(null, clipData) : arrayList2 == null ? Pair.create(clipData, null) : Pair.create(a(clipData.getDescription(), arrayList), a(clipData.getDescription(), arrayList2));
    }

    @g.n0
    @g.v0(31)
    public static Pair<ContentInfo, ContentInfo> i(@g.n0 ContentInfo contentInfo, @g.n0 Predicate<ClipData.Item> predicate) {
        return a.a(contentInfo, predicate);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @g.n0
    public static String k(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? String.valueOf(i10) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    @g.n0
    @g.v0(31)
    public static e m(@g.n0 ContentInfo contentInfo) {
        return new e(new f(contentInfo));
    }

    @g.n0
    public ClipData c() {
        return this.f4853a.b();
    }

    @g.p0
    public Bundle d() {
        return this.f4853a.getExtras();
    }

    public int e() {
        return this.f4853a.e();
    }

    @g.p0
    public Uri f() {
        return this.f4853a.a();
    }

    public int g() {
        return this.f4853a.d();
    }

    @g.n0
    public Pair<e, e> j(@g.n0 androidx.core.util.w<ClipData.Item> wVar) {
        ClipData clipDataB = this.f4853a.b();
        if (clipDataB.getItemCount() == 1) {
            boolean zA = wVar.a(clipDataB.getItemAt(0));
            return Pair.create(zA ? this : null, zA ? null : this);
        }
        Pair<ClipData, ClipData> pairH = h(clipDataB, wVar);
        return pairH.first == null ? Pair.create(null, this) : pairH.second == null ? Pair.create(this, null) : Pair.create(new b(this).b((ClipData) pairH.first).a(), new b(this).b((ClipData) pairH.second).a());
    }

    @g.n0
    @g.v0(31)
    public ContentInfo l() {
        ContentInfo contentInfoC = this.f4853a.c();
        Objects.requireNonNull(contentInfoC);
        return contentInfoC;
    }

    @g.n0
    public String toString() {
        return this.f4853a.toString();
    }

    @g.v0(31)
    public static final class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g.n0
        public final ContentInfo.Builder f4855a;

        public c(@g.n0 ClipData clipData, int i10) {
            this.f4855a = new ContentInfo.Builder(clipData, i10);
        }

        @Override // androidx.core.view.e.d
        @g.n0
        public e a() {
            return new e(new f(this.f4855a.build()));
        }

        @Override // androidx.core.view.e.d
        public void b(int i10) {
            this.f4855a.setFlags(i10);
        }

        @Override // androidx.core.view.e.d
        public void c(int i10) {
            this.f4855a.setSource(i10);
        }

        @Override // androidx.core.view.e.d
        public void d(@g.p0 Uri uri) {
            this.f4855a.setLinkUri(uri);
        }

        @Override // androidx.core.view.e.d
        public void e(@g.n0 ClipData clipData) {
            this.f4855a.setClip(clipData);
        }

        @Override // androidx.core.view.e.d
        public void setExtras(@g.p0 Bundle bundle) {
            this.f4855a.setExtras(bundle);
        }

        public c(@g.n0 e eVar) {
            this.f4855a = new ContentInfo.Builder(eVar.l());
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.e$e, reason: collision with other inner class name */
    public static final class C0043e implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g.n0
        public ClipData f4856a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4857b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4858c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @g.p0
        public Uri f4859d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @g.p0
        public Bundle f4860e;

        public C0043e(@g.n0 ClipData clipData, int i10) {
            this.f4856a = clipData;
            this.f4857b = i10;
        }

        @Override // androidx.core.view.e.d
        @g.n0
        public e a() {
            return new e(new h(this));
        }

        @Override // androidx.core.view.e.d
        public void b(int i10) {
            this.f4858c = i10;
        }

        @Override // androidx.core.view.e.d
        public void c(int i10) {
            this.f4857b = i10;
        }

        @Override // androidx.core.view.e.d
        public void d(@g.p0 Uri uri) {
            this.f4859d = uri;
        }

        @Override // androidx.core.view.e.d
        public void e(@g.n0 ClipData clipData) {
            this.f4856a = clipData;
        }

        @Override // androidx.core.view.e.d
        public void setExtras(@g.p0 Bundle bundle) {
            this.f4860e = bundle;
        }

        public C0043e(@g.n0 e eVar) {
            this.f4856a = eVar.c();
            this.f4857b = eVar.g();
            this.f4858c = eVar.e();
            this.f4859d = eVar.f();
            this.f4860e = eVar.d();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g.n0
        public final d f4854a;

        public b(@g.n0 e eVar) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f4854a = new c(eVar);
            } else {
                this.f4854a = new C0043e(eVar);
            }
        }

        @g.n0
        public e a() {
            return this.f4854a.a();
        }

        @g.n0
        public b b(@g.n0 ClipData clipData) {
            this.f4854a.e(clipData);
            return this;
        }

        @g.n0
        public b c(@g.p0 Bundle bundle) {
            this.f4854a.setExtras(bundle);
            return this;
        }

        @g.n0
        public b d(int i10) {
            this.f4854a.b(i10);
            return this;
        }

        @g.n0
        public b e(@g.p0 Uri uri) {
            this.f4854a.d(uri);
            return this;
        }

        @g.n0
        public b f(int i10) {
            this.f4854a.c(i10);
            return this;
        }

        public b(@g.n0 ClipData clipData, int i10) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f4854a = new c(clipData, i10);
            } else {
                this.f4854a = new C0043e(clipData, i10);
            }
        }
    }
}
