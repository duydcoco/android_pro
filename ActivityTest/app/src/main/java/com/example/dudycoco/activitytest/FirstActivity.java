package com.example.dudycoco.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button_01 = (Button)findViewById(R.id.button_1);
        button_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //添加提示
//                Toast.makeText(FirstActivity.this,
//                        "You clicked Button 1",
//                        Toast.LENGTH_SHORT).show();

                //主动调用销毁
//                finish();

                //显式intent
//                Intent intent  = new Intent(FirstActivity.this,SecondActivity.class);
//                startActivity(intent);

                //隐式intent
//                Intent intent = new Intent("com.example.activitytest.ACTION_START");
//                startActivity(intent);

//                Intent intent = new Intent("com.example.activitytest.ACTION_START");
//                intent.addCategory("com.example.activitytest.MY_CATEGORY");
//                startActivity(intent);

                //隐式Intent 多个应用程序共享功能
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("https://www.baidu.com"));
//                startActivity(intent);

//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));
//                startActivity(intent);

                //向下一个intent传递数据
//                String data = "Hello SecondActivity";
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                intent.putExtra("extra_data",data);
//                startActivity(intent);

                //返回数据给上一个intent
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(FirstActivity.this,"You clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    //回调获取下一个intent返回的数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String resultData = data.getStringExtra("data_return");
                    Log.d("FirstActivity",resultData);
                }
        }


    }
}
