package u9;

import android.content.Intent;
import android.net.Uri;
import com.blankj.utilcode.util.j1;
import com.flydigi.data.DataConstant;
import hk.m;
import i9.a;
import kotlin.jvm.internal.f0;
import kotlin.text.StringsKt__StringsKt;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final d f51961a = new d();

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @m
    public static final void a(@yt.k String type, @yt.k String data, @l String str) {
        String str2;
        f0.p(type, "type");
        f0.p(data, "data");
        switch (type.hashCode()) {
            case 49:
                if (type.equals("1")) {
                    h3.a.j().d(a.b.f31919d).withInt("id", Integer.parseInt(data)).withString(DataConstant.COMMUNITY_ARTICLE_SOURCE, str).navigation();
                    return;
                }
                return;
            case 50:
                if (type.equals("2")) {
                    h3.a.j().d(a.e.f31969e).withString(DataConstant.KEY_GAME_ID, data).navigation();
                    h.n(com.blankj.utilcode.util.a.P(), "游戏详情访问", data, "game_banner");
                    return;
                }
                return;
            case 51:
                if (!type.equals("3")) {
                    return;
                }
                break;
            case 52:
                if (type.equals("4")) {
                    Intent launchIntentForPackage = j1.a().getPackageManager().getLaunchIntentForPackage("com.taobao.taobao");
                    if (launchIntentForPackage == null) {
                        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, DataConstant.MAIN_RECOMMEND_GAME_GOOD_DETAIL_URL + data).navigation();
                        return;
                    }
                    launchIntentForPackage.setAction("android.intent.action.VIEW");
                    launchIntentForPackage.setClassName("com.taobao.taobao", "com.taobao.tao.detail.activity.DetailActivity");
                    launchIntentForPackage.setData(Uri.parse(DataConstant.MAIN_RECOMMEND_GAME_GOOD_DETAIL_URL + data));
                    if (com.blankj.utilcode.util.a.O0(launchIntentForPackage)) {
                        return;
                    }
                    h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, DataConstant.MAIN_RECOMMEND_GAME_GOOD_DETAIL_URL + data).navigation();
                    return;
                }
                return;
            case 53:
                if (type.equals("5")) {
                    if (!o5.f.a(j1.a(), "com.taobao.taobao")) {
                        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, DataConstant.MAIN_RECOMMEND_TAOBAO_SHOP_WEB + data).navigation();
                        return;
                    }
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(DataConstant.MAIN_RECOMMEND_TAOBAO_SHOP_URL + data));
                    com.blankj.utilcode.util.a.P().startActivity(intent);
                    return;
                }
                return;
            case 54:
                if (type.equals("6")) {
                    if (!o5.f.a(j1.a(), "air.tv.douyu.android")) {
                        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, DataConstant.URL_DOUYU_LIVE + data).navigation();
                        return;
                    }
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(DataConstant.SCHEMA_DOUYU + data + "&isVertical=0"));
                    com.blankj.utilcode.util.a.P().startActivity(intent2);
                    return;
                }
                return;
            case 55:
                if (!type.equals("7")) {
                    return;
                }
                break;
            default:
                return;
        }
        if (StringsKt__StringsKt.W2(data, "?", false, 2, null)) {
            str2 = data + "&hideTop=1";
        } else {
            str2 = data + "?hideTop=1";
        }
        h3.a.j().d(i9.a.f31902d).withString(DataConstant.WEB_URL, str2).navigation();
    }

    public static /* synthetic */ void b(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = "";
        }
        a(str, str2, str3);
    }
}
