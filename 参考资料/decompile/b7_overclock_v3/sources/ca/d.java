package ca;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.json.JSONArray;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005J\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¨\u0006\u0018"}, d2 = {"Lca/d;", "", "", "defaultColor", "d", "", "e", "", "f", "color", "Lkotlin/z1;", "a", "key", "default", "b", "value", "h", "Lorg/json/JSONArray;", "jsonArray", "g", "Landroid/content/Context;", com.umeng.analytics.pro.d.R, "<init>", "(Landroid/content/Context;)V", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public static final a f10678b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f10679c = 10;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public static final String f10680d = "com.github.dhaval2404.colorpicker";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public static final String f10681e = "recent_colors";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final SharedPreferences f10682a;

    @d0(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lca/d$a;", "", "", "KEY_RECENT_COLORS", "Ljava/lang/String;", "", "RECENT_COLORS_LIMIT", "I", "SHARED_PREF_NAME", "<init>", "()V", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public d(@k Context context) {
        f0.p(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.github.dhaval2404.colorpicker", 0);
        f0.o(sharedPreferences, "context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)");
        this.f10682a = sharedPreferences;
    }

    public static /* synthetic */ String c(d dVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return dVar.b(str, str2);
    }

    public final void a(@k String color) {
        f0.p(color, "color");
        List listT5 = CollectionsKt___CollectionsKt.T5(f());
        Iterator it2 = listT5.iterator();
        int i10 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i10 = -1;
                break;
            }
            String str = (String) it2.next();
            b bVar = b.f10676a;
            if (b.j(color, str, 0, 4, null)) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 >= 0) {
            listT5.remove(i10);
        }
        if (listT5.size() >= 10) {
            listT5.remove(listT5.size() - 1);
        }
        listT5.add(0, color);
        String string = new JSONArray((Collection) listT5).toString();
        f0.o(string, "JSONArray(colors).toString()");
        h(f10681e, string);
    }

    public final String b(String str, String str2) {
        return this.f10682a.getString(str, str2);
    }

    public final int d(int i10) {
        b bVar = b.f10676a;
        return b.k(e(b.a(i10)));
    }

    @k
    public final String e(@k String defaultColor) {
        f0.p(defaultColor, "defaultColor");
        List<String> listF = f();
        return listF.isEmpty() ^ true ? (String) CollectionsKt___CollectionsKt.w2(listF) : defaultColor;
    }

    @k
    public final List<String> f() {
        String strC = c(this, f10681e, null, 2, null);
        if (!(strC == null || kotlin.text.u.V1(strC))) {
            return g(new JSONArray(strC));
        }
        List<String> listEmptyList = Collections.emptyList();
        f0.o(listEmptyList, "emptyList()");
        return listEmptyList;
    }

    public final List<String> g(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        if (length > 0) {
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                arrayList.add(jSONArray.getString(i10));
                if (i11 >= length) {
                    break;
                }
                i10 = i11;
            }
        }
        return arrayList;
    }

    public final void h(String str, Object obj) {
        SharedPreferences.Editor editorEdit = this.f10682a.edit();
        if (obj instanceof Boolean) {
            editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Integer) {
            editorEdit.putInt(str, ((Number) obj).intValue());
        } else if (obj instanceof Float) {
            editorEdit.putFloat(str, ((Number) obj).floatValue());
        } else if (obj instanceof Long) {
            editorEdit.putLong(str, ((Number) obj).longValue());
        } else if (obj instanceof String) {
            editorEdit.putString(str, (String) obj);
        } else if (obj instanceof Enum) {
            editorEdit.putString(str, ((Enum) obj).toString());
        } else {
            if (obj != null) {
                throw new RuntimeException("Attempting to save non-supported preference");
            }
            editorEdit.remove(str);
        }
        editorEdit.apply();
    }
}
