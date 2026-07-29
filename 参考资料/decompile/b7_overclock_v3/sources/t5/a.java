package t5;

import android.view.View;
import android.widget.TextView;
import com.flydigi.base.R;
import ei.c;
import ei.h;
import gi.d;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a extends c<C0578a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f50885a;

    /* JADX INFO: renamed from: t5.a$a, reason: collision with other inner class name */
    public class C0578a extends d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public TextView f50886g;

        public C0578a(View view, eu.davidea.flexibleadapter.b bVar) {
            super(view, bVar);
            this.f50886g = (TextView) view.findViewById(R.id.tv_state);
        }
    }

    public a(String str) {
        this.f50885a = str;
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public C0578a i(View view, eu.davidea.flexibleadapter.b bVar) {
        return new C0578a(view, bVar);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.base_item_no_more;
    }

    @Override // ei.c
    public boolean equals(Object obj) {
        return obj == this;
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void o(eu.davidea.flexibleadapter.b<h> bVar, C0578a c0578a, int i10, List<Object> list) {
        c0578a.f50886g.setText(this.f50885a);
    }
}
