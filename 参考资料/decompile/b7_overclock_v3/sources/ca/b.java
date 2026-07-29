package ca;

import android.content.Context;
import android.graphics.Color;
import hk.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.v0;
import kotlin.text.u;
import m0.g;
import org.json.JSONException;
import org.json.JSONObject;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007J\"\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0007J\"\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0007J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0002J8\u0010\u0017\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00150\u0014j\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0015`\u00162\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¨\u0006\u001a"}, d2 = {"Lca/b;", "", "", "color", "", "k", "a", "", "f", "e", "color1", "color2", "tolerance", "h", "g", "Landroid/content/Context;", com.umeng.analytics.pro.d.R, "brightness", "", "c", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "b", "<init>", "()V", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final b f10676a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, ? extends List<String>> f10677b;

    @m
    @k
    public static final String a(int i10) {
        v0 v0Var = v0.f37964a;
        String str = String.format("#%06x", Arrays.copyOf(new Object[]{Integer.valueOf(i10 & 16777215)}, 1));
        f0.o(str, "java.lang.String.format(format, *args)");
        return str;
    }

    public static /* synthetic */ List d(b bVar, Context context, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "500";
        }
        return bVar.c(context, str);
    }

    @m
    public static final boolean e(int i10) {
        return g.m(i10) <= 0.4d;
    }

    @m
    public static final boolean f(@k String color) {
        f0.p(color, "color");
        return e(k(color));
    }

    @m
    public static final boolean g(int i10, int i11, int i12) {
        int iRed = Color.red(i10);
        int iGreen = Color.green(i10);
        int iBlue = Color.blue(i10);
        int iRed2 = Color.red(i11);
        int iGreen2 = Color.green(i11);
        int iBlue2 = Color.blue(i11);
        return iRed >= iRed2 - i12 && iRed <= iRed2 + i12 && iGreen >= iGreen2 - i12 && iGreen <= iGreen2 + i12 && iBlue >= iBlue2 - i12 && iBlue <= iBlue2 + i12;
    }

    @m
    public static final boolean h(@k String color1, @k String color2, int i10) {
        f0.p(color1, "color1");
        f0.p(color2, "color2");
        return g(k(color1), k(color2), i10);
    }

    public static /* synthetic */ boolean i(int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            i12 = 50;
        }
        return g(i10, i11, i12);
    }

    public static /* synthetic */ boolean j(String str, String str2, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = 50;
        }
        return h(str, str2, i10);
    }

    @m
    public static final int k(@k String color) {
        f0.p(color, "color");
        if (u.V1(color)) {
            return 0;
        }
        return Color.parseColor(color);
    }

    public final HashMap<String, List<String>> b(Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject(a.f10675a.a(context, "material-colors.json"));
        HashMap<String, List<String>> map = new HashMap<>();
        Iterator<String> itKeys = jSONObject.keys();
        f0.o(itKeys, "colorMain.keys()");
        while (itKeys.hasNext()) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(itKeys.next());
            Iterator<String> itKeys2 = jSONObject2.keys();
            f0.o(itKeys2, "jsonObject.keys()");
            while (itKeys2.hasNext()) {
                String colorCode = itKeys2.next();
                String colorHex = jSONObject2.getString(colorCode);
                List<String> arrayList = map.get(colorCode);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    f0.o(colorCode, "colorCode");
                    map.put(colorCode, arrayList);
                }
                f0.o(colorHex, "colorHex");
                arrayList.add(colorHex);
            }
        }
        return map;
    }

    @k
    public final List<String> c(@k Context context, @k String brightness) {
        f0.p(context, "context");
        f0.p(brightness, "brightness");
        if (f10677b == null) {
            f10677b = b(context);
        }
        Map<String, ? extends List<String>> map = f10677b;
        if (map == null) {
            f0.S("mColorMap");
            throw null;
        }
        List<String> list = map.get(brightness);
        if (list != null) {
            return list;
        }
        List<String> listEmptyList = Collections.emptyList();
        f0.o(listEmptyList, "emptyList()");
        return listEmptyList;
    }
}
