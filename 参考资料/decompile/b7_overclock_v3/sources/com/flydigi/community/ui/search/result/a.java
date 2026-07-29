package com.flydigi.community.ui.search.result;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.flydigi.community.R;
import com.flydigi.community.ui.search.DeviceCategoryBean;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a extends PopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f14079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f14080b;

    /* JADX INFO: renamed from: com.flydigi.community.ui.search.result.a$a, reason: collision with other inner class name */
    public class C0147a extends BaseQuickAdapter<DeviceCategoryBean, BaseViewHolder> {
        public C0147a() {
            super(R.layout.community_item_pop_device_category);
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void convert(BaseViewHolder baseViewHolder, DeviceCategoryBean deviceCategoryBean) {
            baseViewHolder.setText(R.id.tv_category, deviceCategoryBean.a());
        }
    }

    public interface b {
        void a(PopupWindow popupWindow, int i10);
    }

    public a(Context context, List<DeviceCategoryBean> list) {
        super(context);
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.community_pop_window_device_category_choose, (ViewGroup) null);
        this.f14079a = viewInflate;
        setContentView(viewInflate);
        setWidth(-2);
        setHeight(-2);
        setFocusable(true);
        setTouchable(true);
        update();
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: c6.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f9761a.e(view);
            }
        });
        setBackgroundDrawable(null);
        setAnimationStyle(R.style.Widget_AppCompat_Spinner_DropDown);
        c(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        b bVar = this.f14080b;
        if (bVar != null) {
            bVar.a(this, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        dismiss();
    }

    public final void c(List<DeviceCategoryBean> list) {
        RecyclerView recyclerView = (RecyclerView) this.f14079a.findViewById(R.id.recycler_view);
        C0147a c0147a = new C0147a();
        c0147a.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: c6.b
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                this.f9762a.d(baseQuickAdapter, view, i10);
            }
        });
        recyclerView.setAdapter(c0147a);
        c0147a.addData((Collection) list);
    }

    public void f(b bVar) {
        this.f14080b = bVar;
    }
}
