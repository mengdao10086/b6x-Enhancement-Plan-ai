package com.flydigi.base.ui.image_preview;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class ImagePreviewActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) h3.a.j().p(SerializationService.class);
        ImagePreviewActivity imagePreviewActivity = (ImagePreviewActivity) obj;
        imagePreviewActivity.K2 = (ArrayList) imagePreviewActivity.getIntent().getSerializableExtra("main_image_urls");
        imagePreviewActivity.E7 = imagePreviewActivity.getIntent().getIntExtra("main_image_current_position", imagePreviewActivity.E7);
    }
}
