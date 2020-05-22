package org.o7planning.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    // 0 - X
    // 1 - O
    TextView status;
    Button mUndoButton;
    boolean gameActive = true;
    int activePlayer = 0;
    int gameState[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int prevState[][] = new int[12][9];

    int stateArr[] = new int[12];

    int statenumber = 0;
    ImageView imageViews[];
    // State Meanings
    //  0 - X
    //  1 - O
    //  2 - null

    // Since there are only 8 winning positions so we store them

    int winPositions[][] = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    public void playerTap(View view) {
        ImageView img = (ImageView) view;
        String tappedImageTag = img.getTag().toString();

        System.out.println(tappedImageTag);

        char number = tappedImageTag.charAt(1);
        int tappedImage = Integer.parseInt(String.valueOf(number));

        prevState[statenumber] = gameState;
        statenumber++;

        if (!gameActive) {
            System.out.println("Reseting");
            gameReset(view);
            return;
        }

        if (gameState[tappedImage] == 2 && gameActive)   // if the postion is available then place the X or O
        {
            gameState[tappedImage] = activePlayer;
//            img.setTranslationY(-1000);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                activePlayer = 1;
                status.setText("O's turn to play");
            } else {
                img.setImageResource(R.drawable.o);
                activePlayer = 0;
                status.setText("X's turn to play");
            }
        }
//        img.animate().translationYBy(300);

        // CHECK IF ANY PLAYER HAS WON
        for (int[] winPosition : winPositions) {
            if (gameState[winPosition[0]] == gameState[winPosition[1]] && gameState[winPosition[2]] == gameState[winPosition[1]] && gameState[winPosition[0]] != 2) {
                if (gameState[winPosition[0]] == 0) {
                    status.setText("Player X has won");
                } else {
                    status.setText("Player O has won");
                }
                gameActive = false;
            }
        }

        if(statenumber==9 && gameActive)
        {
            status.setText("Tie--No Winner");
            gameActive=false;
        }
    }

    public void gameReset(View view) {

        status.setText("X's turn to play");

        statenumber = 0;
        gameActive = true;
        activePlayer = 0;
        for (int i = 0; i < gameState.length; i++) {
            gameState[i] = 2;
        }
        for (int i = 0; i < prevState.length; i++) {
            prevState[i] = gameState;
        }

        // REMOVE ALL THE IMAGES
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        status = findViewById(R.id.status);
        mUndoButton = findViewById(R.id.undo_button);

//        mUndoButton.setOnClickListener(v -> restorePrevState());

        ImageView imageViews2[] = {findViewById(R.id.imageView0),
                findViewById(R.id.imageView1),
                findViewById(R.id.imageView2),
                findViewById(R.id.imageView3),
                findViewById(R.id.imageView4),
                findViewById(R.id.imageView5),
                findViewById(R.id.imageView6),
                findViewById(R.id.imageView7),
                findViewById(R.id.imageView8)};

        imageViews = imageViews2;

//        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
//        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
//        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
//        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
//        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
//        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
//        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
//        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
//        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
    }

    private void restorePrevState() {

        if (statenumber > 0) {

            statenumber--;
            gameActive = true;
            activePlayer = 1 - activePlayer;
            gameState = prevState[statenumber];
        }
        setState(gameState);
    }

    public void setState(int arr[]) {

//        ((ImageView) findViewById(R.id.imageViews[stateArr[statenumber]]).setImageResource(0);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {


            }
            else if (arr[i] == 1) {


            }
            else{

            }
        }
    }
}
