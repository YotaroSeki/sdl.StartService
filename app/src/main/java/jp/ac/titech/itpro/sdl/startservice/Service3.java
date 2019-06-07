package jp.ac.titech.itpro.sdl.startservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class Service3 extends IntentService {
  private final static String TAG = Service3.class.getSimpleName();
  private final static String EXTRA_ANSWER = "もちもちももち";
  public final static String ACTION_ANSWER = "ももちもちもち、";
  public final static String EXTRA_MYARG = "MYARG";

  public Service3() {
    super(TAG);
  }

  @Override
  protected void onHandleIntent(Intent intent) {
    Log.d(TAG, "onHandleIntent in " + Thread.currentThread());
    Log.d(TAG, "myarg = " + intent.getStringExtra(EXTRA_MYARG));
    Intent answerIntent = new Intent();
    answerIntent.setAction(ACTION_ANSWER);
    answerIntent.putExtra(ACTION_ANSWER, EXTRA_ANSWER);
    sendBroadcast(answerIntent);
    try {
      Thread.sleep(5000); // 5 sec
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onCreate() {
    super.onCreate();
    Log.d(TAG, "onCreate in " + Thread.currentThread());
  }

  @Override
  public void onDestroy() {
    Log.d(TAG, "onDestroy in " + Thread.currentThread());
    super.onDestroy();
  }
}
