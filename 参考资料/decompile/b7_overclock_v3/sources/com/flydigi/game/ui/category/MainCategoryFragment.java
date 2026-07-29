package com.flydigi.game.ui.category;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.viewpager.widget.ViewPager;
import com.blankj.utilcode.util.b1;
import com.blankj.utilcode.util.j1;
import com.flydigi.base.common.FZLazyFragment;
import com.flydigi.base.net.BaseResponse;
import com.flydigi.game.R;
import com.flydigi.game.data.bean.GameCatEntity;
import com.flydigi.game.ui.category.a;
import com.flydigi.game.ui.game_cat_detail.GameCatActivity;
import dl.e;
import g.p0;
import il.c;
import il.d;
import java.util.List;
import net.lucode.hackware.magicindicator.MagicIndicator;
import xi.z;
import yt.k;
import z8.i;

/* JADX INFO: loaded from: classes7.dex */
public class MainCategoryFragment extends FZLazyFragment implements a.InterfaceC0161a {

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public MagicIndicator f15822p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public LinearLayout f15823q8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public ViewPager f15824r8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public s8.a f15825s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public int f15826t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public List<GameCatEntity> f15827u8;

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public com.flydigi.game.ui.category.b f15828v8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public GameCatEntity f15829w8;

    public class a extends il.a {

        /* JADX INFO: renamed from: com.flydigi.game.ui.category.MainCategoryFragment$a$a, reason: collision with other inner class name */
        public class C0160a extends ll.b {
            public C0160a(Context context) {
                super(context);
            }

            @Override // ll.b, ll.e, il.d
            public void a(int i10, int i11) {
                super.a(i10, i11);
                setTypeface(Typeface.defaultFromStyle(0));
            }

            @Override // ll.b, ll.e, il.d
            public void c(int i10, int i11) {
                super.c(i10, i11);
                setTypeface(Typeface.defaultFromStyle(1));
                MainCategoryFragment.this.f15826t8 = i10;
            }
        }

        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(int i10, View view) {
            MainCategoryFragment.this.f15824r8.U(i10, false);
        }

        @Override // il.a
        public int a() {
            return MainCategoryFragment.this.f15825s8.getCount();
        }

        @Override // il.a
        public c b(Context context) {
            jl.b bVar = new jl.b(context);
            bVar.setLineHeight(b1.b(2.0f));
            bVar.setColors(Integer.valueOf(j1.a().getResources().getColor(R.color.colorPrimary)));
            return bVar;
        }

        @Override // il.a
        public d c(Context context, final int i10) {
            C0160a c0160a = new C0160a(MainCategoryFragment.this.H1());
            c0160a.setSelectedColor(j1.a().getResources().getColor(R.color.colorPrimary));
            c0160a.setNormalColor(j1.a().getResources().getColor(R.color.colorTextPrimary));
            c0160a.setTextSize(14.0f);
            c0160a.setText(MainCategoryFragment.this.f15825s8.getPageTitle(i10));
            c0160a.setOnClickListener(new View.OnClickListener() { // from class: s8.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f49526a.j(i10, view);
                }
            });
            return c0160a;
        }
    }

    public class b extends m5.c<BaseResponse<List<GameCatEntity>>> {
        public b() {
        }

        @Override // m5.c
        public void d(BaseResponse<List<GameCatEntity>> baseResponse) {
            MainCategoryFragment.this.k6(baseResponse.data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h6(View view) {
        l6();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i6(PopupWindow popupWindow, int i10) {
        popupWindow.dismiss();
        this.f15824r8.U(i10, false);
    }

    public static MainCategoryFragment j6(GameCatEntity gameCatEntity) {
        MainCategoryFragment mainCategoryFragment = new MainCategoryFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(GameCatActivity.K2, gameCatEntity);
        mainCategoryFragment.c5(bundle);
        return mainCategoryFragment;
    }

    @Override // com.flydigi.game.ui.category.a.InterfaceC0161a
    public void D1(z<BaseResponse<List<GameCatEntity>>> zVar) {
        zVar.c(new b());
    }

    @Override // com.flydigi.base.common.FZFragment
    public int L5() {
        return R.layout.game_fragment_category;
    }

    @Override // androidx.fragment.app.Fragment
    public boolean Y3(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        I5();
        return true;
    }

    @Override // com.flydigi.base.common.FZLazyFragment
    public void Z5() {
        this.f15828v8.E();
    }

    public final void g6() {
        this.f15825s8.setData(this.f15827u8);
        hl.a aVar = new hl.a(X1());
        aVar.setAdapter(new a());
        this.f15822p8.setNavigator(aVar);
        e.a(this.f15822p8, this.f15824r8);
        for (GameCatEntity gameCatEntity : this.f15827u8) {
            GameCatEntity gameCatEntity2 = this.f15829w8;
            if (gameCatEntity2 != null && TextUtils.equals(gameCatEntity2.f15817id, gameCatEntity.f15817id)) {
                this.f15824r8.setCurrentItem(this.f15827u8.indexOf(gameCatEntity));
                return;
            }
        }
    }

    @Override // com.flydigi.base.common.BaseFragment, com.trello.rxlifecycle3.components.support.RxFragment, androidx.fragment.app.Fragment
    public void j4(@k View view, @p0 Bundle bundle) {
        super.j4(view, bundle);
        if (T1() != null) {
            this.f15829w8 = (GameCatEntity) T1().getSerializable(GameCatActivity.K2);
        }
        J5(view);
        this.f13321h8.setText(R.string.game_category);
        this.f15822p8 = (MagicIndicator) F5(R.id.magic_indicator);
        this.f15823q8 = (LinearLayout) F5(R.id.ll_select);
        this.f15824r8 = (ViewPager) F5(R.id.vp_game_category);
        this.f15828v8 = new com.flydigi.game.ui.category.b(this);
        s8.a aVar = new s8.a(U1());
        this.f15825s8 = aVar;
        this.f15824r8.setAdapter(aVar);
        this.f15823q8.setOnClickListener(new View.OnClickListener() { // from class: s8.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f49524a.h6(view2);
            }
        });
    }

    public final void k6(List<GameCatEntity> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f15827u8 = list;
        g6();
    }

    public final void l6() {
        if (this.f15827u8 == null) {
            return;
        }
        i iVar = new i(this.f13317d8, this.f15827u8, this.f15826t8);
        iVar.showAsDropDown(this.f15822p8, 0, -b1.b(96.0f));
        iVar.h(new i.a() { // from class: s8.c
            @Override // z8.i.a
            public final void a(PopupWindow popupWindow, int i10) {
                this.f49525a.i6(popupWindow, i10);
            }
        });
    }
}
