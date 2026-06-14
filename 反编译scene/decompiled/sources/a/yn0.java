package a;

import android.os.Build;
import com.omarea.model.MagiskModuleUnofficial;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yn0 extends r50 {
    /* JADX WARN: Multi-variable type inference failed */
    public yn0() {
        super(null, 1, 0 == true ? 1 : 0);
    }

    public final FutureTask<ArrayList<MagiskModuleUnofficial>> A() {
        FutureTask<ArrayList<MagiskModuleUnofficial>> futureTask = new FutureTask<>(new xn0(this));
        qc2.d(xd2.a(qe2.b()), null, null, new wn0(futureTask, null), 3, null);
        return futureTask;
    }

    public final boolean B(String str, String str2, int i, String str3) {
        f92.d(str, "dbId");
        f92.d(str2, "uid");
        f92.d(str3, "message");
        String str4 = no0.f6937a.a() + "/scene-magisk-like";
        g30 g30Var = new g30();
        g30Var.x("moduleId", str);
        g30Var.x("uid", str2);
        g30Var.v("rank", i);
        g30Var.x("message", str3);
        m42 m42Var = m42.f6769a;
        g30 g30VarN = r50.n(this, str4, g30Var, 0L, 4, null);
        return g30VarN != null && g30VarN.c("success");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final MagiskModuleUnofficial C(g30 g30Var) {
        try {
            MagiskModuleUnofficial magiskModuleUnofficial = new MagiskModuleUnofficial();
            Iterator<String> itK = g30Var.k();
            f92.c(itK, "item.keys()");
            while (itK.hasNext()) {
                String next = itK.next();
                if (next != null) {
                    switch (next.hashCode()) {
                        case -1973090466:
                            if (!next.equals("detailUrl")) {
                                continue;
                            } else {
                                String strI = g30Var.i(next);
                                f92.c(strI, "item.getString(it)");
                                magiskModuleUnofficial.setDetailUrl(strI);
                            }
                            break;
                        case -1724546052:
                            if (!next.equals("description")) {
                                continue;
                            } else {
                                magiskModuleUnofficial.setDescription(g30Var.i(next));
                            }
                            break;
                        case -1406328437:
                            if (!next.equals("author")) {
                                continue;
                            } else {
                                magiskModuleUnofficial.setAuthor(g30Var.i(next));
                            }
                            break;
                        case -1211148345:
                            if (!next.equals("downloadUrl")) {
                                continue;
                            } else {
                                String strI2 = g30Var.i(next);
                                f92.c(strI2, "item.getString(it)");
                                magiskModuleUnofficial.setDownloadUrl(strI2);
                            }
                            break;
                        case -980226692:
                            if (!next.equals("praise")) {
                                continue;
                            } else {
                                magiskModuleUnofficial.setPraise(g30Var.e(next));
                            }
                            break;
                        case -896505829:
                            if (!next.equals("source")) {
                                continue;
                            } else {
                                magiskModuleUnofficial.setSource(g30Var.i(next));
                            }
                            break;
                        case -815589143:
                            if (!next.equals("targetSDK")) {
                                continue;
                            } else {
                                magiskModuleUnofficial.setTargetSDK(Integer.valueOf(g30Var.e("targetSDK")));
                            }
                            break;
                        case 3355:
                            if (!next.equals("id")) {
                                continue;
                            } else {
                                String strI3 = g30Var.i(next);
                                f92.c(strI3, "item.getString(it)");
                                magiskModuleUnofficial.setId(strI3);
                            }
                            break;
                        case 115792:
                            if (!next.equals("uid")) {
                                continue;
                            } else {
                                String strI4 = g30Var.i(next);
                                f92.c(strI4, "item.getString(it)");
                                magiskModuleUnofficial.setUid(strI4);
                            }
                            break;
                        case 3075641:
                            if (!next.equals("dbId")) {
                                continue;
                            } else {
                                magiskModuleUnofficial.setDbId(g30Var.i(next));
                            }
                            break;
                        case 3321751:
                            if (!next.equals("like")) {
                                continue;
                            } else {
                                magiskModuleUnofficial.setLike(g30Var.e(next));
                            }
                            break;
                        case 3373707:
                            if (!next.equals("name")) {
                                continue;
                            } else {
                                magiskModuleUnofficial.setName(g30Var.i(next));
                            }
                            break;
                        case 3492908:
                            if (!next.equals("rank")) {
                                continue;
                            } else {
                                magiskModuleUnofficial.setRank(g30Var.d(next));
                            }
                            break;
                        case 688591589:
                            if (next.equals("versionCode")) {
                                try {
                                    magiskModuleUnofficial.setVersionCode(String.valueOf(g30Var.h(next)));
                                } catch (Exception unused) {
                                    magiskModuleUnofficial.setVersionCode(g30Var.i(next));
                                }
                            }
                            break;
                        case 688906115:
                            if (!next.equals("versionName")) {
                                continue;
                            } else {
                                magiskModuleUnofficial.setVersionName(g30Var.i(next));
                            }
                            break;
                        case 1312704747:
                            if (!next.equals("downloads")) {
                                continue;
                            } else {
                                magiskModuleUnofficial.setDownloads(g30Var.e(next));
                            }
                            break;
                        case 1671642405:
                            if (!next.equals("dislike")) {
                                continue;
                            } else {
                                magiskModuleUnofficial.setDislike(g30Var.e(next));
                            }
                            break;
                        case 2059003624:
                            if (!next.equals("detailContent")) {
                                continue;
                            } else {
                                String strI5 = g30Var.i(next);
                                f92.c(strI5, "item.getString(it)");
                                magiskModuleUnofficial.setDetailContent(strI5);
                            }
                            break;
                    }
                }
            }
            if (f92.a(magiskModuleUnofficial.getUid(), "helloklf@outlook.com")) {
                magiskModuleUnofficial.setSource("official");
            }
            if (magiskModuleUnofficial.getTargetSDK() != null) {
                Integer targetSDK = magiskModuleUnofficial.getTargetSDK();
                int i = Build.VERSION.SDK_INT;
                if (targetSDK != null) {
                    if (targetSDK.intValue() != i) {
                    }
                }
                return null;
            }
            return magiskModuleUnofficial;
        } catch (Exception unused2) {
            return null;
        }
    }

    public final boolean D(MagiskModuleUnofficial magiskModuleUnofficial) {
        f92.d(magiskModuleUnofficial, "moduleInfo");
        g30 g30Var = new g30();
        g30Var.x("id", magiskModuleUnofficial.getId());
        g30Var.x("dbId", magiskModuleUnofficial.getDbId());
        g30Var.x("name", magiskModuleUnofficial.getName());
        try {
            String versionCode = magiskModuleUnofficial.getVersionCode();
            f92.b(versionCode);
            g30Var.v("versionCode", Integer.parseInt(versionCode));
        } catch (Exception unused) {
        }
        g30Var.x("versionName", magiskModuleUnofficial.getVersionName());
        g30Var.x("downloadUrl", magiskModuleUnofficial.getDownloadUrl());
        g30Var.x("author", magiskModuleUnofficial.getAuthor());
        g30Var.x("description", magiskModuleUnofficial.getDescription());
        g30Var.x("detailContent", magiskModuleUnofficial.getDetailContent());
        g30Var.x("uid", magiskModuleUnofficial.getUid());
        g30 g30VarN = r50.n(this, no0.f6937a.a() + "/scene-magisk-share", g30Var, 0L, 4, null);
        return g30VarN != null && g30VarN.c("success");
    }

    public final boolean y(String str, String str2) {
        f92.d(str, "dbId");
        f92.d(str2, "uid");
        String str3 = no0.f6937a.a() + "/scene-magisk-delete";
        g30 g30Var = new g30();
        g30Var.x("dbId", str);
        g30Var.x("uid", str2);
        m42 m42Var = m42.f6769a;
        g30 g30VarN = r50.n(this, str3, g30Var, 0L, 4, null);
        return g30VarN != null && g30VarN.c("success");
    }

    public final MagiskModuleUnofficial z(String str) {
        f92.d(str, "dbId");
        String str2 = no0.f6937a.a() + "/scene-magisk-detail";
        g30 g30Var = new g30();
        g30Var.x("dbId", str);
        m42 m42Var = m42.f6769a;
        g30 g30VarN = r50.n(this, str2, g30Var, 0L, 4, null);
        if (g30VarN != null) {
            return C(g30VarN);
        }
        return null;
    }
}
