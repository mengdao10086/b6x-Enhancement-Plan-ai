package com.flydigi.device_manager.ui.home.game;

import android.text.TextUtils;
import android.view.View;
import c7.a2;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.data.bean.ArticleForGame;
import com.flydigi.data.bean.LocalGameBean;
import com.flydigi.device_manager.R;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class MyGameItem extends AbstractModelItem<LocalGameBean, a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f15221a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f15222b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f15223c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f15224d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f15225e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f15226f = 2;
    private String buttonText;
    private String jumpData;
    private int jumpType;

    public static class a extends gi.d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final a2 f15227g;

        public a(View view, eu.davidea.flexibleadapter.b bVar) {
            super(view, bVar);
            a2 a2VarA = a2.a(view);
            this.f15227g = a2VarA;
            com.blankj.utilcode.util.o.r(a2VarA.f9807d, this);
            com.blankj.utilcode.util.o.r(a2VarA.f9805b, this);
            com.blankj.utilcode.util.o.r(a2VarA.f9806c, this);
        }
    }

    public MyGameItem(LocalGameBean localGameBean) {
        super(localGameBean);
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void o(eu.davidea.flexibleadapter.b<ei.h> bVar, a aVar, int i10, List<Object> list) {
        if (list.isEmpty()) {
            aVar.f15227g.f9809f.setImageDrawable(com.blankj.utilcode.util.d.e(z().localPackageName));
            aVar.f15227g.f9811h.setText(z().name);
            if (i10 == (bVar.r2().size() + bVar.l2()) - 1) {
                aVar.f15227g.f9812i.setVisibility(8);
            } else {
                aVar.f15227g.f9812i.setVisibility(0);
            }
        }
        if (list.isEmpty() || (list.get(0) instanceof ArticleForGame)) {
            if (!list.isEmpty() && (list.get(0) instanceof ArticleForGame)) {
                D((ArticleForGame) list.get(0));
            }
            aVar.f15227g.f9805b.setTag(R.id.device_tag_article_type, Integer.valueOf(this.jumpType));
            aVar.f15227g.f9805b.setTag(R.id.device_tag_article_id, this.jumpData);
            if (TextUtils.isEmpty(this.buttonText)) {
                aVar.f15227g.f9805b.setVisibility(8);
            } else {
                aVar.f15227g.f9805b.setVisibility(0);
                aVar.f15227g.f9805b.setText(this.buttonText);
            }
        }
        if (list.isEmpty() || list.get(0) == f15225e) {
            if (!list.isEmpty() && list.get(0) == f15225e) {
                if (z().getGameMode() == 0) {
                    z().setGameMode(1);
                } else if (z().getGameMode() == 1) {
                    z().setGameMode(0);
                }
            }
            if (z().getGameMode() == 1) {
                aVar.f15227g.f9806c.setVisibility(0);
                aVar.f15227g.f9810g.setText(R.string.device_game_gamepad_native_mode);
            } else {
                aVar.f15227g.f9806c.setVisibility(0);
                aVar.f15227g.f9810g.setText(R.string.device_game_gamepad_mapping_mode);
            }
        }
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public a i(View view, eu.davidea.flexibleadapter.b<ei.h> bVar) {
        return new a(view, bVar);
    }

    public void D(ArticleForGame articleForGame) {
        this.buttonText = articleForGame.getButtonText();
        this.jumpData = articleForGame.getJumpData();
        int jumpType = articleForGame.getJumpType();
        if (jumpType == 2) {
            if (articleForGame.getArchives() == null) {
                this.buttonText = "";
                return;
            } else {
                this.jumpType = 2;
                this.jumpData = articleForGame.getArchives().getId();
                return;
            }
        }
        if (jumpType == 3) {
            this.jumpType = 3;
        } else if (jumpType != 4) {
            this.buttonText = "";
        } else {
            this.jumpType = 1;
        }
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.device_item_local_game;
    }
}
