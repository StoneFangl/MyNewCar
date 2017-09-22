package dagger2.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Stone
 * @time 2017/9/22  9:52
 * @desc ${TODD}
 */

public class SplashResponse implements Serializable {
    public class DataMoudle implements Serializable {
        // 记录id
        public String id = "";
        // 等待时间，秒为单位
        public int waitTime;
        // 启动页图片地址
        public String image = "";
        // 跳转方式：0直接进入，1点击跳转
        public int type;
        //是否显示跳过按钮：0：否，1：是
        public int isIgnore;
        // 图片点击链接
        public String url = "";
        // 发布地区
        public String city = "";
        // 上线时间
        public long upTime;
        // 下线时间
        public long downTime;

        public String toString() {
            return "DataMoudle{" +
                    "id='" + id + '\'' +
                    ", waitTime=" + waitTime +
                    ", image='" + image + '\'' +
                    ", type=" + type +
                    ", isIgnore=" + isIgnore +
                    ", url='" + url + '\'' +
                    ", city='" + city + '\'' +
                    ", upTime=" + upTime +
                    ", downTime=" + downTime +
                    '}';
        }
    }

    public Data data = new Data();

    public String msg = "";

    public String success = "";

    public String code = "";

    public class Data implements Serializable {

        // 广告数据集合
        public List<DataMoudle> bootPageList = new ArrayList<DataMoudle>();

        public String toString() {
            return "Data{" +
                    "bootPageList=" + bootPageList +
                    '}';
        }
    }

    public String toString() {
        return "SplashResponse{" +
                "data=" + data +
                ", msg='" + msg + '\'' +
                ", success='" + success + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
