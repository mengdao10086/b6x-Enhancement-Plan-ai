package com.flydigi.base.widget.recyclerview.adapter;

import android.view.View;
import android.widget.TextView;
import com.flydigi.base.R;
import ei.h;
import eu.davidea.flexibleadapter.b;
import gi.d;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MessageItem extends AbstractModelItem<String, a> {

    public class a extends d {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f13609g;

        public a(View view, b bVar) {
            super(view, bVar);
            this.f13609g = (TextView) view.findViewById(R.id.tv_error_tip);
        }
    }

    public MessageItem(String str) {
        super(str);
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void o(b<h> bVar, a aVar, int i10, List<Object> list) {
        aVar.f13609g.setText(z());
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public a i(View view, b<h> bVar) {
        return new a(view, bVar);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.base_item_message_state;
    }

    @Override // com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem, ei.c
    public boolean equals(Object obj) {
        return false;
    }
}
