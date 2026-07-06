package a;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jb2 implements gb2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb2 f6496a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CharSequence f1521a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Matcher f1522a;

    public jb2(Matcher matcher, CharSequence charSequence) {
        f92.d(matcher, "matcher");
        f92.d(charSequence, "input");
        this.f1522a = matcher;
        this.f1521a = charSequence;
        this.f6496a = new ib2(this);
    }

    @Override // a.gb2
    public fb2 a() {
        return this.f6496a;
    }

    @Override // a.gb2
    public String b() {
        String strGroup = e().group();
        f92.c(strGroup, "matchResult.group()");
        return strGroup;
    }

    @Override // a.gb2
    public gb2 c() {
        int iEnd = e().end() + (e().end() == e().start() ? 1 : 0);
        if (iEnd > this.f1521a.length()) {
            return null;
        }
        Matcher matcher = this.f1522a.pattern().matcher(this.f1521a);
        f92.c(matcher, "matcher.pattern().matcher(input)");
        return ob2.c(matcher, iEnd, this.f1521a);
    }

    public final MatchResult e() {
        return this.f1522a;
    }
}
