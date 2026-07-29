package com.flydigi.device_manager.ui.home.game;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.flydigi.base.widget.FZDialog;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.LocalGameBean;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.home.game.p;
import i9.a;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class b {
    public static /* synthetic */ void b(DialogFragment dialogFragment) {
        h3.a.j().d(a.f.f31974c).withInt(DataConstant.KEY_ROUTER_HOME_TAB_INDEX, 1).navigation();
        dialogFragment.I5();
    }

    public static void c(p.a aVar, List<LocalGameBean> list, int i10) {
        if (o5.p.d()) {
            aVar.c0(list, i10);
        }
    }

    public static void d(Fragment fragment) {
        o5.a.t0(fragment.U1(), new FZDialog.a().t(fragment.c3(R.string.device_game_local_game_not_found_title)).j(fragment.c3(R.string.device_game_local_game_not_found_content)).d(fragment.c3(R.string.cancel)).g(fragment.c3(R.string.device_game_local_game_see)).c(b6.c.f9082a).f(new FZDialog.c() { // from class: com.flydigi.device_manager.ui.home.game.a
            @Override // com.flydigi.base.widget.FZDialog.c
            public final void a(DialogFragment dialogFragment) {
                b.b(dialogFragment);
            }
        }).a());
    }
}
