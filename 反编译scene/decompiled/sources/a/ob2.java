package a;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ob2 {
    public static final gb2 c(Matcher matcher, int i, CharSequence charSequence) {
        if (matcher.find(i)) {
            return new jb2(matcher, charSequence);
        }
        return null;
    }

    public static final ea2 d(MatchResult matchResult, int i) {
        return ga2.i(matchResult.start(i), matchResult.end(i));
    }
}
