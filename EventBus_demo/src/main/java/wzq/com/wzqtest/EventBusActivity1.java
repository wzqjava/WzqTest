package wzq.com.wzqtest;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * https://www.jianshu.com/p/e7d5c7bda783
 *
 */
public class EventBusActivity1 extends AppCompatActivity {


  @BindView(R.id.btn_reg)
  Button btnReg;
  @BindView(R.id.btn_nav_2)
  Button btnNav2;
  @BindView(R.id.btn_stop)
  Button btnStop;
  @BindView(R.id.tv_message)
  TextView tvMessage;
  @BindView(R.id.tv_sticky_message)
  TextView tvStickyMessage;
  private boolean stopDelivery = false;


  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_event_bus1);
    ButterKnife.bind(this);

    btnReg.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        EventBus.getDefault().register(EventBusActivity1.this);
        Toast.makeText(EventBusActivity1.this, "注册事件儿 " , Toast.LENGTH_SHORT).show();
      }
    });


    btnNav2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(EventBusActivity1.this,EventBusActivity2.class));
      }
    });

    btnStop.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        stopDelivery = true;
      }
    });
  }


  @Subscribe(threadMode = ThreadMode.POSTING, priority = 0)
  public void onGetMessage(MessageWrap message) {
    tvMessage.setText(message.message);
  }

  @Subscribe(threadMode = ThreadMode.POSTING, sticky = true, priority = 1)
  public void onGetStickyEvent(MessageWrap message) {
    String txt = "Sticky event: " + message.message;
    tvStickyMessage.setText(txt);
    if (stopDelivery) {
      EventBus.getDefault().cancelEventDelivery(message);
    }
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    EventBus.getDefault().unregister(this);
  }
}
