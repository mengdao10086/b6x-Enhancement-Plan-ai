package p8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.blankj.utilcode.util.b0;
import com.flydigi.base.common.n;
import com.flydigi.data.DataConstant;
import com.flydigi.data.event.APKInstallEvent;
import com.flydigi.game.data.DBManager;
import com.flydigi.game.data.bean.GameBean;
import com.flydigi.game.data.bean.GameBean_;
import io.objectbox.query.QueryBuilder;
import java.util.Objects;
import o5.m;
import o5.p;
import u9.h;

/* JADX INFO: loaded from: classes7.dex */
public class b extends BroadcastReceiver {
    public static IntentFilter c() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        return intentFilter;
    }

    public static b f() {
        return new b();
    }

    public final void b(Context context, String str, ii.a<GameBean> aVar, GameBean gameBean) {
        if (p.c(str)) {
            n.a("App 更新");
            return;
        }
        n.a("App 卸载");
        tt.c.f().q(new APKInstallEvent(str, false));
        b0.p(gameBean.localPath);
        aVar.U(gameBean);
        b0.p(gameBean.localPath);
        gameBean.localPath = "";
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final void e(Context context, String str, Intent intent) {
        ii.a<GameBean> aVarI = DBManager.getInstance().getBoxStore().i(GameBean.class);
        GameBean gameBeanH1 = aVarI.L().s(GameBean_.packageName, str, QueryBuilder.StringOrder.CASE_INSENSITIVE).g().h1();
        if (gameBeanH1 != null) {
            if (!TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_ADDED")) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_REMOVED")) {
                    b(context, str, aVarI, gameBeanH1);
                    return;
                }
                return;
            }
            tt.c.f().q(new APKInstallEvent(str, true));
            if (m.k(DataConstant.SP_MAIN).f(DataConstant.SP_MAIN_AUTO_DELETE_APK, true)) {
                b0.p(gameBeanH1.localPath);
                gameBeanH1.localPath = "";
            }
            gameBeanH1.installed = true;
            gameBeanH1.progress = -1.0f;
            gameBeanH1.lastOperateTime = System.currentTimeMillis();
            if (com.blankj.utilcode.util.d.i(gameBeanH1.packageName).e() >= gameBeanH1.versionCode) {
                gameBeanH1.updateAble = false;
            }
            h.o(context, gameBeanH1.f15815id, "end", "");
            aVarI.G(gameBeanH1);
        }
    }

    public void g(Context context) {
        context.registerReceiver(this, c());
    }

    public void h(Context context) {
        context.unregisterReceiver(this);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        try {
            String dataString = intent.getDataString();
            Objects.requireNonNull(dataString);
            final String strSubstring = dataString.substring(8);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("接收到的app包名：");
            sb2.append(strSubstring);
            DBManager.getInstance().getBoxStore().E2(new Runnable() { // from class: p8.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f46499a.e(context, strSubstring, intent);
                }
            }, null);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
