package wzq.com.wzqtest;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

/**
 *
 * https://blog.csdn.net/lmj623565791/article/details/37936275
 * https://blog.csdn.net/codemydream/article/details/53423888
 * 2、难点
 * 假设当前Activity在onCreate中启动一个异步线程去夹在数据，当然为了给用户一个很好的体验，会有一个ProgressDialog，
 * 当数据加载完成，ProgressDialog消失，设置数据。
 *
 * 这里，如果在异步数据完成加载之后，旋转屏幕，使用上述a、b两种方法都不会很难，无非是保存数据和恢复数据。
 *
 * 但是，如果正在线程加载的时候，进行旋转，会存在以下问题：
 *
 * a)此时数据没有完成加载，onCreate重新启动时，会再次启动线程；而上个线程可能还在运行，并且可能会更新已经不存在的控件，造成错误。
 *
 * b)关闭ProgressDialog的代码在线程的onPostExecutez中，但是上个线程如果已经杀死，无法关闭之前ProgressDialog。
 *
 * c)谷歌的官方不建议使用ProgressDialog，这里我们会使用官方推荐的DialogFragment来创建我的加载框，
 * 如果你不了解：请看 Android 官方推荐 : DialogFragment 创建对话框。这样，其实给我们带来一个很大的问题，
 * DialogFragment说白了是Fragment，和当前的Activity的生命周期会发生绑定，我们旋转屏幕会造成Activity的销毁，
 * 当然也会对DialogFragment造成影响。

 */
public class FixProblemsActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ListAdapter mAdapter;
    private List<String> mDatas;
    private OtherRetainedFragment dataFragment;
    private MyAsyncTask mMyTask;
    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);
        Log.e(TAG, "onCreate");

        // find the retained fragment on activity restarts
        FragmentManager fm = getSupportFragmentManager();
        dataFragment = (OtherRetainedFragment) fm.findFragmentByTag("data");

        // create the fragment and data the first time
        if (dataFragment == null) {
            // add the fragment
            dataFragment = new OtherRetainedFragment();
            fm.beginTransaction().add(dataFragment, "data").commit();
        }
        mMyTask = dataFragment.getData();
        if (mMyTask != null) {
            mMyTask.setActivity(this);
        } else {
            mMyTask = new MyAsyncTask(this);
            dataFragment.setData(mMyTask);
            mMyTask.execute();
        }
        // the data is available in dataFragment.getData()
    }


    @Override
    protected void onRestoreInstanceState(Bundle state) {
        super.onRestoreInstanceState(state);
        Log.e(TAG, "onRestoreInstanceState");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        mMyTask.setActivity(null);
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, "onDestroy");
        super.onDestroy();

    }

    /**
     * 回调
     */
    public void onTaskCompleted() {
        mDatas = mMyTask.getItems();
        mAdapter = new ArrayAdapter<String>(FixProblemsActivity.this,
                android.R.layout.simple_list_item_1, mDatas);

        listView.setAdapter(mAdapter);
    }


}