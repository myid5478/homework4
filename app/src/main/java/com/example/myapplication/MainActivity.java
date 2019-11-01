package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    EditText mileage_in;                //宣告全域變數
    EditText addition_in;                //宣告全域變數
    EditText amount_in;
    TextView amount_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mileage_in = (EditText)findViewById(R.id.mileage_in);// 取得里程物件
        addition_in = (EditText)findViewById(R.id.addition_in);// 取得加成物件
        amount_in = (EditText)findViewById(R.id.amount_in);// 取得加成金額物件
        amount_out= (TextView) findViewById(R.id.amount_out);
        Button submit = (Button)findViewById(R.id.output);             // 取得按鈕物件 如果ID有誤請回到res->Layout查看預設Button是多少
        submit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                //判斷條件 身高 跟 體重 都有輸入值才執行
                int num1 = Integer.parseInt(mileage_in.getText().toString());
                int num2=Integer.parseInt(addition_in.getText().toString());

                if (num1<num2) {
                    amount_out.setText("75元");




                }
                else  if (num1>num2) {
                    float fresult_out = Float.parseFloat(mileage_in.getEditableText().toString());      // 取得  里程輸入值
                    float addition = Float.parseFloat(addition_in.getEditableText().toString());      // 取得 加成輸入值
                    float amount = Float.parseFloat(amount_in.getEditableText().toString());      // 取得 加成金額輸入值
                    float fresult;                                     // BMI值 計算結果
                    TextView result = (TextView)findViewById(R.id.amount_out);// 取得 顯示結果 物件
                    fresult_out = ((fresult_out-addition)*amount)+75;
                    NumberFormat nf = NumberFormat.getInstance();   // 數字格式
                    nf.setMaximumFractionDigits(2);                 // 限制小數第二位
                    fresult = fresult_out;                                // 計算
                    result.setText(nf.format(fresult_out) +"元");           // 顯示計算結果



                }

            }
        });
    }
}