package com.flydigi.qiji.ui.home;

import android.content.Context;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.n0;
import com.fdg.flashplay.farsef.R;
import com.flydigi.action.ArticleReadLog;
import com.flydigi.baseProvider.ICommunityProvider;
import com.flydigi.baseProvider.IDeviceManagerProvider;
import com.flydigi.baseProvider.IGameCenterProvider;
import com.flydigi.data.DataConstant;
import com.flydigi.qiji.ui.account.AccountFragment;
import com.flydigi.qiji.ui.mall.MallFragment;
import i9.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f16135a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f16136b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16137c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16138d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16139e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int[] f16140f = {R.string.app_title_mall, R.string.game, R.string.device_manager, R.string.community, R.string.account};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f16141g = {R.drawable.app_selector_home_bottom_icon_mall, R.drawable.app_selector_home_bottom_icon_game, R.drawable.app_selector_home_bottom_icon_device_manager, R.drawable.app_selector_home_bottom_icon_community, R.drawable.app_selector_home_bottom_icon_account};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final SparseIntArray f16142h = new SparseIntArray();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final SparseArray<Fragment> f16143i = new SparseArray<>();

    public static boolean a(int i10) {
        return f16142h.get(i10) == 3;
    }

    public static void b(Context context) {
    }

    public static int c() {
        return f16142h.indexOfValue(2);
    }

    public static Fragment d(int i10) {
        int i11 = f16142h.get(i10);
        SparseArray<Fragment> sparseArray = f16143i;
        Fragment fragmentH6 = sparseArray.get(i11);
        if (fragmentH6 == null) {
            if (i11 == 0) {
                fragmentH6 = MallFragment.H6();
            } else if (i11 == 1) {
                fragmentH6 = ((IGameCenterProvider) h3.a.j().d(a.e.f31966b).navigation()).o();
            } else if (i11 == 2) {
                fragmentH6 = ((IDeviceManagerProvider) h3.a.j().d(a.d.f31946b).navigation()).o();
            } else if (i11 == 3) {
                fragmentH6 = ((ICommunityProvider) h3.a.j().d(a.b.f31917b).navigation()).o();
            } else if (i11 == 4) {
                fragmentH6 = AccountFragment.C6();
            }
            if (fragmentH6 != null) {
                sparseArray.put(i11, fragmentH6);
            }
        }
        return fragmentH6;
    }

    public static List<Fragment> e(int i10) {
        SparseArray<Fragment> sparseArray = f16143i;
        ArrayList arrayList = new ArrayList(sparseArray.size());
        Fragment fragment = sparseArray.get(f16142h.get(i10));
        int i11 = 0;
        while (true) {
            SparseArray<Fragment> sparseArray2 = f16143i;
            if (i11 >= sparseArray2.size()) {
                return arrayList;
            }
            Fragment fragmentValueAt = sparseArray2.valueAt(i11);
            if (fragmentValueAt != fragment) {
                arrayList.add(fragmentValueAt);
            }
            i11++;
        }
    }

    public static int f(int i10) {
        int i11 = f16142h.get(i10);
        if (i11 < 0) {
            return R.drawable.bg_empty_holder;
        }
        int[] iArr = f16141g;
        return i11 < iArr.length ? iArr[i11] : R.drawable.bg_empty_holder;
    }

    public static int g(int i10) {
        int i11 = f16142h.get(i10);
        if (i11 < 0) {
            return R.string.app_empty_holder;
        }
        int[] iArr = f16140f;
        return i11 < iArr.length ? iArr[i11] : R.string.app_empty_holder;
    }

    public static int h() {
        return f16142h.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 6 */
    public static void i() {
        n0.b(o5.m.l(DataConstant.SP_FLOAT, 2).r(DataConstant.SP_FLOAT_KEY_CHANNEL_NAME, ""), "nubia");
        SparseIntArray sparseIntArray = f16142h;
        sparseIntArray.put(0, 2);
        sparseIntArray.put(1, 4);
        f16143i.clear();
    }

    public static void j(int i10, Fragment fragment) {
        f16143i.put(f16142h.get(i10), fragment);
    }

    public static void k(Context context, int i10) {
        HashMap map = new HashMap();
        int i11 = f16142h.get(i10);
        if (i11 == 0) {
            map.put("tab", ArticleReadLog.f13287e);
        } else if (i11 == 1) {
            map.put("tab", ArticleReadLog.f13288f);
        } else if (i11 == 2) {
            map.put("tab", "外设管理");
        } else if (i11 == 3) {
            map.put("tab", "社区");
        } else if (i11 != 4) {
            return;
        } else {
            map.put("tab", "账号");
        }
        u9.g.a().e(context, "home_tab_switch", map);
    }
}
