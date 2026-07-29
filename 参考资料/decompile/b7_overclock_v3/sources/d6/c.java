package d6;

import android.content.Context;
import com.blankj.utilcode.util.d1;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.data.DataConstant;
import i9.a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f26067a = "https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f26068b = "\\d+$";

    public static Boolean a(String str) {
        return Boolean.valueOf(Pattern.compile(f26067a).matcher(str).find());
    }

    public static String b(String str) {
        Matcher matcher = Pattern.compile(f26067a).matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group();
            str = str.replace(strGroup, String.format("[%s]", strGroup));
        }
        return str;
    }

    public static void c(Context context, String str) {
        if (!d1.l(str).contains("bbs.flydigi.com")) {
            h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_TITLE, "").withString(DataConstant.WEB_URL, str).navigation();
            return;
        }
        if (str.contains("?")) {
            str = str.substring(0, str.indexOf("?"));
        }
        Matcher matcher = Pattern.compile(f26068b).matcher(str);
        if (!matcher.find()) {
            h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_TITLE, "").withString(DataConstant.WEB_URL, str).navigation();
        } else {
            h3.a.j().d(a.b.f31919d).withInt("id", Integer.parseInt(matcher.group())).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, ArticleReadLog.f13289g).navigation();
        }
    }
}
