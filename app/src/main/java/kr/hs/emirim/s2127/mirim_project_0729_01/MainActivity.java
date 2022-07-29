package kr.hs.emirim.s2127.mirim_project_0729_01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    RadioGroup rg;
    public static final int Plus = 0;
    public static final int Minus = 1;
    public static final int Multi = 2;
    public static final int Divide = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        rg=findViewById(R.id.rg);
        Button btnResult = findViewById(R.id.btn_result);
        btnResult.setOnClickListener(btnResultListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //if(resultCode==RESULT_OK){
        int sum = data.getIntExtra("sum", 0);
        Toast.makeText(getApplicationContext(), "계산결과 :" + sum, Toast.LENGTH_LONG).show();
    }

    View.OnClickListener btnResultListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
            intent.putExtra("num1", Integer.parseInt(edit1.getText().toString()));
            intent.putExtra("num2", Integer.parseInt(edit2.getText().toString()));
            int op = 0;
            switch (rg.getCheckedRadioButtonId()) {
                case R.id.btn_plus:
                    op = Plus;
                    //int sum=data.getIntExtra("sum",0);
                    //Toast.makeText(getApplicationContext(),"덧셈결과 :"+sum,Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn_minus:
                    op = Minus;
                    //int cha=data.getIntExtra("cha",0);
                    //Toast.makeText(getApplicationContext(),"뺄셈결과 :"+cha,Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn_gob:
                    op = Multi;
                    //int gob=data.getIntExtra("gob",0);
                    //Toast.makeText(getApplicationContext(),"곱셈결과 :"+gob,Toast.LENGTH_LONG).show();
                    break;
                case R.id.btn_divide:
                    op = Divide;
                    //int nanu=data.getIntExtra("nanu",0);
                    //Toast.makeText(getApplicationContext(),"나누기 결과 :"+nanu,Toast.LENGTH_LONG).show();
                    break;
            }
            intent.putExtra("op",op);
            startActivityForResult(intent,0);
        }

    };
}

