package vh;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import com.zhihu.matisse.R;
import com.zhihu.matisse.internal.entity.Item;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import zh.d;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f53174d = "state_selection";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f53175e = "state_collection_type";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f53176f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f53177g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f53178h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f53179i = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f53180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Set<Item> f53181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f53182c = 0;

    public c(Context context) {
        this.f53180a = context;
    }

    public boolean a(Item item) {
        if (t(item)) {
            throw new IllegalArgumentException("Can't select images and videos at the same time.");
        }
        boolean zAdd = this.f53181b.add(item);
        if (zAdd) {
            int i10 = this.f53182c;
            if (i10 == 0) {
                if (item.g()) {
                    this.f53182c = 1;
                } else if (item.j()) {
                    this.f53182c = 2;
                }
            } else if (i10 == 1) {
                if (item.j()) {
                    this.f53182c = 3;
                }
            } else if (i10 == 2 && item.g()) {
                this.f53182c = 3;
            }
        }
        return zAdd;
    }

    public List<Item> b() {
        return new ArrayList(this.f53181b);
    }

    public List<String> c() {
        ArrayList arrayList = new ArrayList();
        Iterator<Item> it2 = this.f53181b.iterator();
        while (it2.hasNext()) {
            arrayList.add(zh.c.b(this.f53180a, it2.next().a()));
        }
        return arrayList;
    }

    public List<Uri> d() {
        ArrayList arrayList = new ArrayList();
        Iterator<Item> it2 = this.f53181b.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().a());
        }
        return arrayList;
    }

    public int e(Item item) {
        int iIndexOf = new ArrayList(this.f53181b).indexOf(item);
        if (iIndexOf == -1) {
            return Integer.MIN_VALUE;
        }
        return iIndexOf + 1;
    }

    public int f() {
        return this.f53181b.size();
    }

    public final int g() {
        th.c cVarB = th.c.b();
        int i10 = cVarB.f51298g;
        if (i10 > 0) {
            return i10;
        }
        int i11 = this.f53182c;
        return i11 == 1 ? cVarB.f51299h : i11 == 2 ? cVarB.f51300i : i10;
    }

    public int h() {
        return this.f53182c;
    }

    public Bundle i() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(f53174d, new ArrayList<>(this.f53181b));
        bundle.putInt(f53175e, this.f53182c);
        return bundle;
    }

    public th.b j(Item item) {
        String string;
        if (!m()) {
            return t(item) ? new th.b(this.f53180a.getString(R.string.error_type_conflict)) : d.f(this.f53180a, item);
        }
        int iG = g();
        try {
            string = this.f53180a.getResources().getQuantityString(R.plurals.error_over_count, iG, Integer.valueOf(iG));
        } catch (Resources.NotFoundException unused) {
            string = this.f53180a.getString(R.string.error_over_count, Integer.valueOf(iG));
        } catch (NoClassDefFoundError unused2) {
            string = this.f53180a.getString(R.string.error_over_count, Integer.valueOf(iG));
        }
        return new th.b(string);
    }

    public boolean k() {
        Set<Item> set = this.f53181b;
        return set == null || set.isEmpty();
    }

    public boolean l(Item item) {
        return this.f53181b.contains(item);
    }

    public boolean m() {
        return this.f53181b.size() == g();
    }

    public void n(Bundle bundle) {
        if (bundle == null) {
            this.f53181b = new LinkedHashSet();
        } else {
            this.f53181b = new LinkedHashSet(bundle.getParcelableArrayList(f53174d));
            this.f53182c = bundle.getInt(f53175e, 0);
        }
    }

    public void o(Bundle bundle) {
        bundle.putParcelableArrayList(f53174d, new ArrayList<>(this.f53181b));
        bundle.putInt(f53175e, this.f53182c);
    }

    public void p(ArrayList<Item> arrayList, int i10) {
        if (arrayList.size() == 0) {
            this.f53182c = 0;
        } else {
            this.f53182c = i10;
        }
        this.f53181b.clear();
        this.f53181b.addAll(arrayList);
    }

    public final void q() {
        boolean z10 = false;
        boolean z11 = false;
        for (Item item : this.f53181b) {
            if (item.g() && !z10) {
                z10 = true;
            }
            if (item.j() && !z11) {
                z11 = true;
            }
        }
        if (z10 && z11) {
            this.f53182c = 3;
        } else if (z10) {
            this.f53182c = 1;
        } else if (z11) {
            this.f53182c = 2;
        }
    }

    public boolean r(Item item) {
        boolean zRemove = this.f53181b.remove(item);
        if (zRemove) {
            if (this.f53181b.size() == 0) {
                this.f53182c = 0;
            } else if (this.f53182c == 3) {
                q();
            }
        }
        return zRemove;
    }

    public void s(List<Item> list) {
        this.f53181b.addAll(list);
    }

    public boolean t(Item item) {
        int i10;
        int i11;
        if (th.c.b().f51293b) {
            if (item.g() && ((i11 = this.f53182c) == 2 || i11 == 3)) {
                return true;
            }
            if (item.j() && ((i10 = this.f53182c) == 1 || i10 == 3)) {
                return true;
            }
        }
        return false;
    }
}
