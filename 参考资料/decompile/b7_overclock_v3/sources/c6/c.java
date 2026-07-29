package c6;

import android.view.View;
import com.flydigi.community.R;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c extends ei.c<a> {

    public class a extends gi.d {
        public a(View view, eu.davidea.flexibleadapter.b bVar) {
            super(view, bVar);
        }
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public a i(View view, eu.davidea.flexibleadapter.b<ei.h> bVar) {
        return new a(view, bVar);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.community_item_search_empty;
    }

    @Override // ei.c
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void o(eu.davidea.flexibleadapter.b<ei.h> bVar, a aVar, int i10, List<Object> list) {
    }
}
