package t5;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blankj.utilcode.util.NetworkUtils;
import com.flydigi.base.R;
import ei.c;
import ei.h;
import gi.d;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b extends c<a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f50888b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f50889c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f50890d = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f50891a;

    public class a extends d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ProgressBar f50892g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public TextView f50893h;

        public a(View view, eu.davidea.flexibleadapter.b bVar) {
            super(view, bVar);
            this.f50893h = (TextView) view.findViewById(R.id.tv_state);
            this.f50892g = (ProgressBar) view.findViewById(R.id.progress);
        }
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public a i(View view, eu.davidea.flexibleadapter.b bVar) {
        return new a(view, bVar);
    }

    public int B() {
        return this.f50891a;
    }

    public void C(int i10) {
        this.f50891a = i10;
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.base_item_progress;
    }

    @Override // ei.c
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void o(eu.davidea.flexibleadapter.b<h> bVar, a aVar, int i10, List<Object> list) {
        Context context = aVar.itemView.getContext();
        if (list.size() > 0) {
            this.f50891a = ((Integer) list.get(0)).intValue();
        }
        int i11 = this.f50891a;
        if (i11 == 1) {
            aVar.f50893h.setText(context.getString(R.string.base_no_more_data));
        } else if (i11 != 2) {
            aVar.f50893h.setText(context.getString(R.string.loading));
        } else {
            aVar.f50893h.setText(context.getString(NetworkUtils.K() ? R.string.api_error_notice : R.string.net_state_error));
        }
    }
}
