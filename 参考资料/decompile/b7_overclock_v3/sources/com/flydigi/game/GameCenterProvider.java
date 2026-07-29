package com.flydigi.game;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.flydigi.base.common.FZFragment;
import com.flydigi.baseProvider.IGameCenterProvider;
import com.flydigi.game.ui.main.GameHomeFragment;
import i9.a;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
@Route(path = a.e.f31966b)
public class GameCenterProvider extends IGameCenterProvider {
    @Override // com.flydigi.baseProvider.IGameCenterProvider
    @k
    public FZFragment o() {
        return GameHomeFragment.B6();
    }
}
