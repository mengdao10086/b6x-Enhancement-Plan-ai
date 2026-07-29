package com.flydigi.device_manager.ui.home.game;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flydigi.data.DBManager;
import com.flydigi.data.bean.InstalledGameBean;
import com.flydigi.data.bean.LocalGameBean;
import com.flydigi.device_manager.R;
import com.flydigi.device_manager.ui.home.game.GameModeChooseFragment;
import com.flydigi.device_manager.ui.home.game.GameSelectBottomSheetDialog;
import com.flydigi.device_manager.ui.home.game.adapter.LocalGameSquareAdapter;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.z1;

/* JADX INFO: loaded from: classes7.dex */
public final class GameSelectBottomSheetDialog extends BottomSheetDialogFragment {

    @yt.k
    public static final a F8 = new a(null);

    @yt.k
    public static final String G8 = "key_games";

    @yt.l
    public b E8;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final GameSelectBottomSheetDialog a(@yt.k ArrayList<LocalGameBean> games) {
            kotlin.jvm.internal.f0.p(games, "games");
            GameSelectBottomSheetDialog gameSelectBottomSheetDialog = new GameSelectBottomSheetDialog();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList(GameSelectBottomSheetDialog.G8, games);
            gameSelectBottomSheetDialog.c5(bundle);
            return gameSelectBottomSheetDialog;
        }
    }

    public interface b {
        void a();
    }

    public static final class c implements GameModeChooseFragment.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocalGameBean f15216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GameSelectBottomSheetDialog f15217b;

        public c(LocalGameBean localGameBean, GameSelectBottomSheetDialog gameSelectBottomSheetDialog) {
            this.f15216a = localGameBean;
            this.f15217b = gameSelectBottomSheetDialog;
        }

        @Override // com.flydigi.device_manager.ui.home.game.GameModeChooseFragment.b
        public void a(int i10, @yt.k String packageName) {
            kotlin.jvm.internal.f0.p(packageName, "packageName");
            LocalGameBean localGameBean = this.f15216a;
            localGameBean.gameMode = i10;
            this.f15217b.l6(localGameBean);
        }
    }

    public static final InstalledGameBean m6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        return (InstalledGameBean) tmp0.i(obj);
    }

    public static final void n6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void o6(ik.l tmp0, Object obj) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        tmp0.i(obj);
    }

    public static final void q6(GameSelectBottomSheetDialog this$0, View view) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        this$0.I5();
    }

    public static final void r6(GameSelectBottomSheetDialog this$0, BaseQuickAdapter adapter, View view, int i10) {
        kotlin.jvm.internal.f0.p(this$0, "this$0");
        kotlin.jvm.internal.f0.p(adapter, "adapter");
        Object obj = adapter.getData().get(i10);
        kotlin.jvm.internal.f0.n(obj, "null cannot be cast to non-null type com.flydigi.data.bean.LocalGameBean");
        this$0.t6((LocalGameBean) obj);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    @yt.k
    public Dialog P5(@yt.l Bundle bundle) {
        Dialog dialogP5 = super.P5(bundle);
        kotlin.jvm.internal.f0.o(dialogP5, "super.onCreateDialog(savedInstanceState)");
        View viewInflate = View.inflate(X1(), R.layout.device_fragment_game_select, null);
        dialogP5.setContentView(viewInflate);
        Object parent = viewInflate.getParent();
        kotlin.jvm.internal.f0.n(parent, "null cannot be cast to non-null type android.view.View");
        ((View) parent).setBackgroundColor(V2().getColor(android.R.color.transparent));
        View viewFindViewById = viewInflate.findViewById(R.id.btn_close);
        View viewFindViewById2 = viewInflate.findViewById(R.id.rv_game_list);
        kotlin.jvm.internal.f0.o(viewFindViewById2, "mView.findViewById(R.id.rv_game_list)");
        RecyclerView recyclerView = (RecyclerView) viewFindViewById2;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.flydigi.device_manager.ui.home.game.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameSelectBottomSheetDialog.q6(this.f15260a, view);
            }
        });
        Bundle bundleT1 = T1();
        List parcelableArrayList = bundleT1 != null ? bundleT1.getParcelableArrayList(G8) : null;
        if (parcelableArrayList == null) {
            parcelableArrayList = CollectionsKt__CollectionsKt.E();
        }
        LocalGameSquareAdapter localGameSquareAdapter = new LocalGameSquareAdapter(parcelableArrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(X1(), 4));
        recyclerView.setAdapter(localGameSquareAdapter);
        localGameSquareAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.flydigi.device_manager.ui.home.game.j
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                GameSelectBottomSheetDialog.r6(this.f15262a, baseQuickAdapter, view, i10);
            }
        });
        return dialogP5;
    }

    public final void l6(LocalGameBean localGameBean) {
        xi.z zVarM3 = xi.z.m3(localGameBean);
        final GameSelectBottomSheetDialog$addNotSupportGame$1 gameSelectBottomSheetDialog$addNotSupportGame$1 = new ik.l<LocalGameBean, InstalledGameBean>() { // from class: com.flydigi.device_manager.ui.home.game.GameSelectBottomSheetDialog$addNotSupportGame$1
            @Override // ik.l
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final InstalledGameBean i(@yt.k LocalGameBean localGameBean1) {
                kotlin.jvm.internal.f0.p(localGameBean1, "localGameBean1");
                InstalledGameBean installedGameBean = new InstalledGameBean();
                installedGameBean.setId(0L);
                installedGameBean.setTitle(localGameBean1.getName());
                installedGameBean.setLocalPackageName(localGameBean1.getLocalPackageName());
                installedGameBean.setStandardPackageName(localGameBean1.getStandardPackageName());
                installedGameBean.setThumb(null);
                installedGameBean.setGameMode(localGameBean1.gameMode);
                return installedGameBean;
            }
        };
        xi.z zVarA3 = zVarM3.A3(new dj.o() { // from class: com.flydigi.device_manager.ui.home.game.m
            @Override // dj.o
            public final Object apply(Object obj) {
                return GameSelectBottomSheetDialog.m6(gameSelectBottomSheetDialog$addNotSupportGame$1, obj);
            }
        });
        final GameSelectBottomSheetDialog$addNotSupportGame$2 gameSelectBottomSheetDialog$addNotSupportGame$2 = new ik.l<InstalledGameBean, z1>() { // from class: com.flydigi.device_manager.ui.home.game.GameSelectBottomSheetDialog$addNotSupportGame$2
            public final void b(@yt.l InstalledGameBean installedGameBean) {
                DBManager.getInstance().addInstalledGame(installedGameBean);
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(InstalledGameBean installedGameBean) {
                b(installedGameBean);
                return z1.f38230a;
            }
        };
        xi.z zVarS0 = zVarA3.Y1(new dj.g() { // from class: com.flydigi.device_manager.ui.home.game.l
            @Override // dj.g
            public final void accept(Object obj) {
                GameSelectBottomSheetDialog.n6(gameSelectBottomSheetDialog$addNotSupportGame$2, obj);
            }
        }).s0(o5.l.d());
        final ik.l<InstalledGameBean, z1> lVar = new ik.l<InstalledGameBean, z1>() { // from class: com.flydigi.device_manager.ui.home.game.GameSelectBottomSheetDialog$addNotSupportGame$3
            {
                super(1);
            }

            public final void b(InstalledGameBean installedGameBean) {
                this.this$0.I5();
                GameSelectBottomSheetDialog.b bVarP6 = this.this$0.p6();
                if (bVarP6 != null) {
                    bVarP6.a();
                }
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(InstalledGameBean installedGameBean) {
                b(installedGameBean);
                return z1.f38230a;
            }
        };
        zVarS0.E5(new dj.g() { // from class: com.flydigi.device_manager.ui.home.game.k
            @Override // dj.g
            public final void accept(Object obj) {
                GameSelectBottomSheetDialog.o6(lVar, obj);
            }
        });
    }

    @yt.l
    public final b p6() {
        return this.E8;
    }

    public final void s6(@yt.l b bVar) {
        this.E8 = bVar;
    }

    public final void t6(LocalGameBean localGameBean) {
        GameModeChooseFragment.a aVar = GameModeChooseFragment.I8;
        String str = localGameBean.localPackageName;
        kotlin.jvm.internal.f0.o(str, "localGameBean.localPackageName");
        GameModeChooseFragment gameModeChooseFragmentA = aVar.a(str, localGameBean.gameMode);
        gameModeChooseFragmentA.t6(new c(localGameBean, this));
        o5.a.t0(U1(), gameModeChooseFragmentA);
    }
}
