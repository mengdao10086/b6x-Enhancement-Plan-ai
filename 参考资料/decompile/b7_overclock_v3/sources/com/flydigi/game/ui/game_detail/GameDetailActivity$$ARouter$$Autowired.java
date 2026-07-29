package com.flydigi.game.ui.game_detail;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.flydigi.data.DataConstant;
import h3.a;

/* JADX INFO: loaded from: classes7.dex */
public class GameDetailActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) a.j().p(SerializationService.class);
        GameDetailActivity gameDetailActivity = (GameDetailActivity) obj;
        gameDetailActivity.K2 = gameDetailActivity.getIntent().getExtras() == null ? gameDetailActivity.K2 : gameDetailActivity.getIntent().getExtras().getString(DataConstant.KEY_GAME_ID, gameDetailActivity.K2);
    }
}
