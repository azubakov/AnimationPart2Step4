package tomerbu.edu.animationsparttwo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.RelativeLayout;

public class CircularActivity extends AppCompatActivity {
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular);
        layout = (RelativeLayout) findViewById(R.id.layout);
    }

    public void reveal(View view) {
        final boolean shouldHide = layout.getVisibility() == View.VISIBLE;

        int cx = layout.getWidth();
        int cy = layout.getHeight();

        float startRadius = 0;
        float endRadius = 0;

        if (shouldHide){
            startRadius = Math.max(layout.getWidth(), layout.getHeight());
            endRadius = 0;
        }
        else {
            startRadius = 0;
            endRadius =  Math.max(layout.getWidth(), layout.getHeight());
        }

        Animator circularReveal = ViewAnimationUtils.createCircularReveal(layout, cx, cy, startRadius, endRadius);

        if (!shouldHide){
            layout.setVisibility(View.VISIBLE);
        }

        circularReveal.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (shouldHide)
                    layout.setVisibility(View.INVISIBLE);
            }
        });
        circularReveal.start();

    }
}
