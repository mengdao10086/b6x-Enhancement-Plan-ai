package com.flydigi.game.ui.download;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import com.flydigi.base.common.FZFragment;
import com.flydigi.data.DataConstant;
import com.flydigi.game.R;
import com.flydigi.game.ui.download.DownloadSettingFragment;
import g.p0;
import o5.m;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public class DownloadSettingFragment extends FZFragment {

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public SwitchCompat f15845o8;

    public static /* synthetic */ void a6(CompoundButton compoundButton, boolean z10) {
        m.k(DataConstant.SP_MAIN).F(DataConstant.SP_MAIN_AUTO_DELETE_APK, z10);
    }

    public static DownloadSettingFragment b6() {
        return new DownloadSettingFragment();
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.game_fragment_download_setting;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean Y3(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        I5();
        return true;
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        J5(view);
        this.f13321h8.setText(R.string.game_download_setting);
        this.f15845o8 = (SwitchCompat) F5(R.id.switchWidget);
        this.f15845o8.setChecked(m.k(DataConstant.SP_MAIN).f(DataConstant.SP_MAIN_AUTO_DELETE_APK, true));
        this.f15845o8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: t8.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                DownloadSettingFragment.a6(compoundButton, z10);
            }
        });
    }
}
