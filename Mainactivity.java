package com.example.project7_3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText dlgEdtName, dlgEdtEmail, etName, etEmail;
    View dialogView, toastView;
    TextView toastText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                final String[] versionArray = new String[]{"Q(10)", "R(11)", "S(12)"};
//                final boolean[] checkArray = new boolean[] {true, false, false};
                View dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setView(dialogView);
                dlg.setPositiveButton("취소", null);
                dlg.setPositiveButton("확인", null);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    dlgEdtName = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                    dlgEdtEmail = (EditText) dialogView.findViewById(R.id.dlgEdt2);

                    etName = (EditText) findViewById(R.id.etName);
                    etEmail = (EditText) findViewById(R.id.etEmail);

                    etName.setText(dlgEdtName.getText().toString());
                    etEmail.setText(dlgEdtEmail.getText().toString());

                    }
                });


                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = new Toast(MainActivity.this);
                        toastView = (View) View.inflate(MainActivity.this, R.layout.toast,null);
                        toastText = (TextView) toastView.findViewById(R.id.toastText1);
                        toastText.setText("취소했습니다");

                        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                        int xOffset = (int) (Math.random() * display.getWidth());
                        int yOffset = (int) (Math.random() * display.getHeight());
                        toast.setView(toastView);
                        toast.setGravity(Gravity.TOP | Gravity.LEFT, xOffset, yOffset);
                        toast.show();
                    }
                });
                dlg.show();
            }
        });
    }
}
