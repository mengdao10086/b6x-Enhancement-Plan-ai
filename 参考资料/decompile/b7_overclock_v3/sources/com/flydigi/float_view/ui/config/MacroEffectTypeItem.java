package com.flydigi.float_view.ui.config;

import android.view.View;
import android.widget.TextView;
import com.flydigi.base.widget.recyclerview.adapter.AbstractModelItem;
import com.flydigi.float_view.R;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class MacroEffectTypeItem extends AbstractModelItem<Integer, a> {

    public static class a extends gi.d {
        public a(View view, eu.davidea.flexibleadapter.b bVar) {
            super(view, bVar);
        }
    }

    public MacroEffectTypeItem(Integer num) {
        super(num);
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public void o(eu.davidea.flexibleadapter.b<ei.h> bVar, a aVar, int i10, List<Object> list) {
        if (aVar.itemView instanceof TextView) {
            if (z().intValue() == 0) {
                View view = aVar.itemView;
                ((TextView) view).setText(view.getResources().getString(R.string.floatview_property_macro_key_trigger_mode_pressed));
            } else if (z().intValue() == 1) {
                View view2 = aVar.itemView;
                ((TextView) view2).setText(view2.getResources().getString(R.string.floatview_property_macro_key_trigger_mode_released));
            } else if (z().intValue() == 2) {
                View view3 = aVar.itemView;
                ((TextView) view3).setText(view3.getResources().getString(R.string.floatview_property_macro_key_trigger_mode_hold));
            }
        }
    }

    @Override // ei.c, ei.h
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public a i(View view, eu.davidea.flexibleadapter.b<ei.h> bVar) {
        return new a(view, bVar);
    }

    @Override // ei.c, ei.h
    public int c() {
        return R.layout.floatview_item_macro_effect_type;
    }
}
