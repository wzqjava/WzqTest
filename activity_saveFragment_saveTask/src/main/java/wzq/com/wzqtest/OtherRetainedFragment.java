package wzq.com.wzqtest;

/**
 * author:Created by WangZhiQiang on 2018/11/30.
 */

import android.os.Bundle;
import androidx.fragment.app.Fragment;

/**
 * 保存对象的Fragment
 *
 * @author zhy
 *
 *
 */
public class OtherRetainedFragment extends Fragment {

    // data object we want to retain
    // 保存一个异步的任务
    private MyAsyncTask data;

    // this method is only called once for this fragment
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // retain this fragment
        /**
         * 跨越Activity保留活动对象的推荐方法是在一个Retained Fragment中包装和管理它们。默认情况下，但配置发生变化时，
         * Fragment会随着它们的宿主Activity被创建和销毁。调用Fragment#setRetaininstance(true)允许我们跳过销毁和重新创建的周期。
         * 指示系统保留当前的fragment实例，即使是在Activity被创新创建的时候。
         * 不难想到使用fragment持有像运行中的线程、AsyncTask、Socket等对象将有效地解决上面的问题。
         */
        setRetainInstance(true);
    }

    public void setData(MyAsyncTask data) {
        this.data = data;
    }

    public MyAsyncTask getData() {
        return data;
    }


}