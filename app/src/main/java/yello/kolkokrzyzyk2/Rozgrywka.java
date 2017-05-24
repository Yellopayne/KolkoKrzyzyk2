package yello.kolkokrzyzyk2;

import android.content.pm.ActivityInfo;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Rozgrywka extends AppCompatActivity implements View.OnClickListener {

    Button a1,a2,a3,b1,b2,b3,c1,c2,c3;
    Button newGame;
    Button resetS;
    boolean turn =true;

    TextView v1,v2;

    int scoreX =0;
    int scoreY =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rozgrywka);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        v1 = (TextView)findViewById(R.id.textView);
        v2 = (TextView)findViewById(R.id.textView2);
        resetS= (Button)findViewById(R.id.button11);

        a1 = (Button)findViewById(R.id.button);
        a2 = (Button)findViewById(R.id.button2);
        a3 = (Button)findViewById(R.id.button3);

        b1 = (Button)findViewById(R.id.button4);
        b2 = (Button)findViewById(R.id.button5);
        b3 = (Button)findViewById(R.id.button6);

        c1 = (Button)findViewById(R.id.button7);
        c2 = (Button)findViewById(R.id.button8);
        c3 = (Button)findViewById(R.id.button9);

        resetS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1.setText("");
                v2.setText("");
                scoreX=0;
                scoreY=0;
            }
        });


        newGame = (Button)findViewById(R.id.button10);

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a1.setText("");
                a1.setClickable(true);

                a2.setText("");
                a2.setClickable(true);

                a3.setText("");
                a3.setClickable(true);

                b1.setText("");
                b1.setClickable(true);

                b2.setText("");
                b2.setClickable(true);

                b3.setText("");
                b3.setClickable(true);

                c1.setText("");
                c1.setClickable(true);

                c2.setText("");
                c2.setClickable(true);

                c3.setText("");
                c3.setClickable(true);

                turn = true;
            }
        });

        Button [] bArray  = new Button[]{a1,a2,a3,b1,b2,b3,c1,c2,c3};

        for(Button b : bArray){
            b.setOnClickListener(this);
        }




    }



    @Override
    public void onClick(View v) {
        Button b = (Button)v;

        if(turn){
            b.setText("X");
            turn=false;
            b.setClickable(false);
        }
        else{
            b.setText("O");
            b.setClickable(false);
            turn=true;
        }

        checkforWinner();



    }

    public void toastMessage(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void checkforWinner(){
        boolean winner= false;

        if((a1.getText()==a2.getText()) && (a2.getText()==a3.getText()) &&(!a3.isClickable())) {

            winner = true;
        }
        if((b1.getText()==b2.getText()) && (b2.getText()==b3.getText()) &&(!b3.isClickable())) {

            winner = true;
        }
        if((c1.getText()==c2.getText()) && (c2.getText()==c3.getText()) &&(!c3.isClickable())) {

            winner = true;
        }


        if((a1.getText()==b1.getText()) && (b1.getText()==c1.getText()) &&(!c1.isClickable())) {

            winner = true;
        }
        if((a2.getText()==b2.getText()) && (b2.getText()==c2.getText()) &&(!c2.isClickable())) {

            winner = true;
        }
        if((a3.getText()==b3.getText()) && (b3.getText()==c3.getText()) &&(!c3.isClickable())) {

            winner = true;
        }


        if((a1.getText()==b2.getText()) && (b2.getText()==c3.getText()) &&(!c3.isClickable())) {

            winner = true;
        }
        if((c1.getText()==b2.getText()) && (b2.getText()==a3.getText()) &&(!a3.isClickable())) {

            winner = true;
        }








        if(winner){

            if(turn){
                toastMessage("O player wins");
                scoreY++;
                String score2 = ""+scoreY;
                v2.setText(score2);

            }

            else{
                toastMessage("X player wins");
                scoreX++;
                String score3 = ""+scoreX;

                v1.setText(score3);
            }
        }





    }


}
