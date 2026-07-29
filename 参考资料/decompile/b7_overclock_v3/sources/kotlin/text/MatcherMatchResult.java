package kotlin.text;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.internal.f0;
import kotlin.text.k;

/* JADX INFO: loaded from: classes5.dex */
public final class MatcherMatchResult implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Matcher f38141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final CharSequence f38142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final i f38143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public List<String> f38144d;

    public static final class a extends kotlin.collections.b<String> {
        public a() {
        }

        @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
        public int a() {
            return MatcherMatchResult.this.f().groupCount() + 1;
        }

        public /* bridge */ boolean b(String str) {
            return super.contains(str);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return b((String) obj);
            }
            return false;
        }

        public /* bridge */ int d(String str) {
            return super.indexOf(str);
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return d((String) obj);
            }
            return -1;
        }

        public /* bridge */ int l(String str) {
            return super.lastIndexOf(str);
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return l((String) obj);
            }
            return -1;
        }

        @Override // kotlin.collections.b, java.util.List
        @yt.k
        public String get(int i10) {
            String strGroup = MatcherMatchResult.this.f().group(i10);
            return strGroup == null ? "" : strGroup;
        }
    }

    public MatcherMatchResult(@yt.k Matcher matcher, @yt.k CharSequence input) {
        f0.p(matcher, "matcher");
        f0.p(input, "input");
        this.f38141a = matcher;
        this.f38142b = input;
        this.f38143c = new MatcherMatchResult$groups$1(this);
    }

    @Override // kotlin.text.k
    @yt.k
    public k.b a() {
        return k.a.a(this);
    }

    @Override // kotlin.text.k
    @yt.k
    public List<String> b() {
        if (this.f38144d == null) {
            this.f38144d = new a();
        }
        List<String> list = this.f38144d;
        f0.m(list);
        return list;
    }

    @Override // kotlin.text.k
    @yt.k
    public i c() {
        return this.f38143c;
    }

    @Override // kotlin.text.k
    @yt.k
    public qk.m d() {
        return RegexKt.i(f());
    }

    public final MatchResult f() {
        return this.f38141a;
    }

    @Override // kotlin.text.k
    @yt.k
    public String getValue() {
        String strGroup = f().group();
        f0.o(strGroup, "matchResult.group()");
        return strGroup;
    }

    @Override // kotlin.text.k
    @yt.l
    public k next() {
        int iEnd = f().end() + (f().end() == f().start() ? 1 : 0);
        if (iEnd > this.f38142b.length()) {
            return null;
        }
        Matcher matcher = this.f38141a.pattern().matcher(this.f38142b);
        f0.o(matcher, "matcher.pattern().matcher(input)");
        return RegexKt.f(matcher, iEnd, this.f38142b);
    }
}
