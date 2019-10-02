package wzq.com.wzqtest;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;


public class EventBusActivity2 extends AppCompatActivity {


  @BindView(R.id.et_message)
  EditText etMessage;
  @BindView(R.id.btn_publish)
  Button btnPublish;
  @BindView(R.id.btn_publish_and_finish)
  Button btnPublishAndFinish;
  @BindView(R.id.btn_publish_sticky)
  Button btnPublishSticky;
  @BindView(R.id.tv_message)
  TextView tvMessage;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_event_bus2);
    ButterKnife.bind(this);
    EventBus.getDefault().register(this);

    btnPublish.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        publishContent();
      }
    });

    btnPublishAndFinish.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        publishContent();
        finish();
      }
    });

    btnPublishSticky.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        publishStickyontent();
      }
    });
  }

  private void publishContent() {
    String msg = etMessage.getText().toString();
    EventBus.getDefault().post(MessageWrap.getInstance(msg));
    Toast.makeText(this, "Published : " + msg, Toast.LENGTH_SHORT).show();
  }

  private void publishStickyontent() {
    String msg = etMessage.getText().toString();
    EventBus.getDefault().postSticky(MessageWrap.getInstance(msg));
    Toast.makeText(this, "Published : " + msg, Toast.LENGTH_SHORT).show();

  }



  @Subscribe(threadMode = ThreadMode.MAIN)
  public void onGetMessage(MessageWrap message) {
    tvMessage.setText(message.message);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    EventBus.getDefault().unregister(this);
  }
}
