package z8;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flydigi.game.R;
import com.flydigi.game.data.bean.GameCatEntity;
import com.flydigi.game.ui.download.adapter.GameCatPopAdapter;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class i extends PopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutInflater f57930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f57931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f57932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<GameCatEntity> f57933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f57934e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f57935f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public GameCatPopAdapter f57936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f57937h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearLayout f57938i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public a f57939j;

    public interface a {
        void a(PopupWindow popupWindow, int i10);
    }

    public i(Context context, List<GameCatEntity> list, int i10) {
        super(context);
        this.f57937h = context;
        this.f57932c = i10;
        this.f57933d = list;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f57930a = layoutInflater;
        View viewInflate = layoutInflater.inflate(R.layout.game_view_game_cat, (ViewGroup) null);
        this.f57931b = viewInflate;
        setContentView(viewInflate);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        setTouchable(true);
        update();
        setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.color_black_trans)));
        setAnimationStyle(R.style.Widget_AppCompat_Spinner_DropDown);
        this.f57938i = (LinearLayout) viewInflate.findViewById(R.id.ll_root);
        this.f57935f = (LinearLayout) viewInflate.findViewById(R.id.ll_select);
        this.f57934e = (RecyclerView) viewInflate.findViewById(R.id.rv_content);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        a aVar = this.f57939j;
        if (aVar != null) {
            aVar.a(this, i10);
        }
    }

    public final void d() {
        this.f57938i.setOnClickListener(new View.OnClickListener() { // from class: z8.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f57928a.e(view);
            }
        });
        this.f57935f.setOnClickListener(new View.OnClickListener() { // from class: z8.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f57927a.f(view);
            }
        });
        GameCatPopAdapter gameCatPopAdapter = new GameCatPopAdapter(this.f57932c);
        this.f57936g = gameCatPopAdapter;
        gameCatPopAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: z8.h
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                this.f57929a.g(baseQuickAdapter, view, i10);
            }
        });
        this.f57934e.n(new u8.b());
        this.f57934e.setLayoutManager(new GridLayoutManager(this.f57937h, 4));
        this.f57934e.setAdapter(this.f57936g);
        this.f57936g.addData((Collection) this.f57933d);
        this.f57934e.L1(this.f57932c);
    }

    public void h(a aVar) {
        this.f57939j = aVar;
    }
}
