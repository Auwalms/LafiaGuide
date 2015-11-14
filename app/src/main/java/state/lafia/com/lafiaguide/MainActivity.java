package state.lafia.com.lafiaguide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private Toolbar mToolbar;
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY =200 ;
    private ViewFlipper mViewFlipper;
    private AnimationListener mAnimationListener;
    private Context mContext;

    @SuppressWarnings ("deprecation" )

    private final GestureDetector detector = new GestureDetector( new SwipeGestureDetector());
    public boolean mShowingBack,nShowingBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar_actionbar);
        setSupportActionBar(mToolbar);
        mToolbar.setLogo(R.drawable.ic_launcher);
        mToolbar.setSubtitle("City Guide");


        final ArrayList<City> list = getList();

        final CustomAdapter adapter = new CustomAdapter(this, R.layout.test_layout, list);

        final GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent myIntent = null;
                if(position == 0){
                    myIntent = new Intent(MainActivity.this, Hospital_map.class);

                }
                if(position == 1) {
                    myIntent = new Intent(MainActivity.this, School_map.class);

                }
                if(position ==2){
                    myIntent = new Intent(MainActivity.this, Markets.class);

                }
                if(position ==3){
                    myIntent = new Intent(MainActivity.this, Security.class);
                    startActivity(myIntent);
                }
                if(position ==4){
                    myIntent = new Intent(MainActivity.this, Hotels_map.class);

                }
                if(position ==5){
                    myIntent = new Intent(MainActivity.this, Motor_Park_Map.class);

                }
                if(position ==6){
                    myIntent = new Intent(MainActivity.this, Attractions_Maps.class);

                }
                if(position ==7){
                    myIntent = new Intent(MainActivity.this, Banks_Maps.class);

                }
                if(position ==8){
                    myIntent = new Intent(MainActivity.this, Sports_Centers_Map.class);
                }
                startActivity(myIntent);

            }
        });










        mContext = this;

        mViewFlipper = (ViewFlipper) this . findViewById(R.id.view_flipper);
        mViewFlipper . setAutoStart(true);
        mViewFlipper . setFlipInterval(5000 );
        mViewFlipper . startFlipping();


        mViewFlipper.setInAnimation
                (AnimationUtils.loadAnimation(mContext, R.anim.slide_in_from_left));

        mViewFlipper . setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch ( final View view, final
            MotionEvent event) {
                detector . onTouchEvent(event);
                return true;
            }
        });

        mAnimationListener = new Animation.AnimationListener
                () {
            public void onAnimationStart (Animation animation) {
//animation started event
            }
            public void onAnimationRepeat(Animation animation ) {
            }
            public void onAnimationEnd(Animation animation ) {

//TODO animation stopped event

            }
        };


        
    }

    public ArrayList<City> getList() {
        ArrayList<City> list = new ArrayList<City>();
        list.add(new City("Hospitals", R.drawable.hospital));
        list.add(new City("Schools", R.drawable.school));
        list.add(new City("Markets", R.drawable.market));
        list.add(new City("Securitys", R.drawable.security_safety));
        list.add(new City("Hotels", R.drawable.hotel));
        list.add(new City("Motor Parks", R.drawable.park));
        list.add(new City("Attractions", R.drawable.attraction));
        list.add(new City("Banks", R.drawable.bank));
        list.add(new City("Sport Centres", R.drawable.sports));
        return list;
    }



    class SwipeGestureDetector extends SimpleOnGestureListener {

        @Override

        public boolean onFling(MotionEvent e1, MotionEvent e2,
                               float velocityX, float velocityY) {

            try {

// right to left swipe

                if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE &&
                        Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {

                    mViewFlipper.setInAnimation
                            (AnimationUtils.loadAnimation(mContext, R.anim.slide_in_from_left)
                            );

                    mViewFlipper.setOutAnimation
                            (AnimationUtils.loadAnimation(mContext, R.anim.slide_out_to_left));

// controlling animation

                    mViewFlipper.getInAnimation().setAnimationListener
                            (mAnimationListener);

                    mViewFlipper.showNext();

                    return true;

                } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
                        && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {

                    mViewFlipper.setInAnimation
                            (AnimationUtils.loadAnimation(mContext, R.anim.slide_in_from_right));

                    mViewFlipper.setOutAnimation
                            (AnimationUtils.loadAnimation(mContext, R.anim.slide_out_to_right));

// controlling animation

                    mViewFlipper.getInAnimation().setAnimationListener
                            (mAnimationListener);

                    mViewFlipper.showPrevious();

                    return true;

                }


            } catch (Exception e) {

                e.printStackTrace();

            }


            return false;
        }

    }



            @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                // Code you want run when activity is clicked
                Intent mintent = new Intent (this,About.class);
                startActivity(mintent);
                return true;
            case R.id.gdglafia:
                // Code you want run when activity is clicked
                Intent lintent = new Intent (this,AboutGDG.class);
                startActivity(lintent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    class CustomAdapter extends ArrayAdapter<City> {

        private LayoutInflater inflater;

        private int resource;

        public CustomAdapter(Context context, int resource, List<City> data) {
            super(context, resource, data);
            inflater = LayoutInflater.from(context);
            this.resource = resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = inflater.inflate(resource, parent, false);
            }

            City fruit = getItem(position);

            TextView tv = (TextView) convertView.findViewById(R.id.tv_test);
            tv.setText(fruit.name);

            ImageView iv = (ImageView) convertView.findViewById(R.id.iv_image);
            iv.setImageResource(fruit.drawableRes);

            return convertView;
        }
    }
}
