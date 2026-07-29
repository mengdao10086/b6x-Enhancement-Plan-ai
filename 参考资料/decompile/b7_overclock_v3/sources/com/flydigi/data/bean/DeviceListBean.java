package com.flydigi.data.bean;

import com.google.gson.annotations.SerializedName;
import com.umeng.analytics.pro.an;
import db.d;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class DeviceListBean {

    @SerializedName("app_version")
    private String appVersion;

    @SerializedName("products")
    private List<CategoryBean> categories;

    @SerializedName(d.f26139i)
    private long version;

    public static class CategoryBean {

        @SerializedName("category")
        private String category;

        @SerializedName("sections")
        private List<SectionBean> sections;

        public static class SectionBean {

            @SerializedName("category")
            private String category;

            @SerializedName("devices")
            private List<DeviceBean> devices;

            public static class DeviceBean {

                @SerializedName("device_name")
                private String deviceName;

                @SerializedName(an.f23207ai)
                private String deviceType;

                @SerializedName("list_pic")
                private String listPic;

                @SerializedName("type")
                private int type;

                public String getDeviceName() {
                    return this.deviceName;
                }

                public String getDeviceType() {
                    return this.deviceType;
                }

                public String getListPic() {
                    return this.listPic;
                }

                public int getType() {
                    return this.type;
                }

                public void setDeviceName(String deviceName) {
                    this.deviceName = deviceName;
                }

                public void setDeviceType(String deviceType) {
                    this.deviceType = deviceType;
                }

                public void setListPic(String listPic) {
                    this.listPic = listPic;
                }

                public void setType(int type) {
                    this.type = type;
                }
            }

            public String getCategory() {
                return this.category;
            }

            public List<DeviceBean> getDevices() {
                return this.devices;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public void setDevices(List<DeviceBean> devices) {
                this.devices = devices;
            }
        }

        public String getCategory() {
            return this.category;
        }

        public List<SectionBean> getSections() {
            return this.sections;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public void setSections(List<SectionBean> sections) {
            this.sections = sections;
        }
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public List<CategoryBean> getCategories() {
        return this.categories;
    }

    public long getVersion() {
        return this.version;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public void setCategories(List<CategoryBean> categories) {
        this.categories = categories;
    }

    public void setVersion(long version) {
        this.version = version;
    }
}
