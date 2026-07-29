package com.flydigi.game.ui.game_cat_detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.flydigi.base.common.p;
import com.flydigi.game.R;
import com.flydigi.game.data.bean.GameCatEntity;
import com.flydigi.game.ui.category.MainCategoryFragment;
import g.p0;
import o5.a;

/* JADX INFO: loaded from: classes7.dex */
public class GameCatActivity extends p {
    public static final String K2 = "game_entity";

    public static void j4(Context context, GameCatEntity gameCatEntity) {
        Intent intent = new Intent(context, (Class<?>) GameCatActivity.class);
        intent.putExtra(K2, gameCatEntity);
        context.startActivity(intent);
    }

    @Override // com.flydigi.base.common.p
    public int f4() {
        return R.layout.activity_fragment;
    }

    @Override // com.flydigi.base.common.p, com.flydigi.base.common.c, ch.a, androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(@p0 Bundle bundle) {
        super.onCreate(bundle);
        GameCatEntity gameCatEntity = (GameCatEntity) getIntent().getSerializableExtra(K2);
        if (a4(MainCategoryFragment.class.getSimpleName()) == null) {
            a.m(n3(), MainCategoryFragment.j6(gameCatEntity), MainCategoryFragment.class.getSimpleName(), R.id.fl_container);
        }
    }
}
