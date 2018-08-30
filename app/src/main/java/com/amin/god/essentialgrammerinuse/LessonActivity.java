package com.amin.god.essentialgrammerinuse;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;


import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

/**
 * Created by aMIN on 3/19/2018.
 */

public class LessonActivity extends AppCompatActivity implements Runnable {
    ArrayList<HashMap<String, String>> lessonList;
    private ListView viewList;

    ProgressBar progress;
    public static final int RequestPermissionCode = 1;
    private int secondsProgress = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lesson_activity);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        lessonList = new ArrayList<>();
        viewList = findViewById(R.id.record_list);



        for (int i = 0; i < 55; i++) {
            HashMap<String, String> movie = new HashMap<>();
            movie.put("name", "Unit " + (i + 1));
            movie.put("description", "am/is/are");
            lessonList.add(movie);
        }

        // adding contact to contact list
        AminAdapter adapter = new AminAdapter(LessonActivity.this, lessonList,
                R.layout.lesson_list_item, new String[]{"name", "description"},
                new int[]{R.id.name_text_view, R.id.description});

        viewList.setAdapter(adapter);

        viewList.setOnItemClickListener((parent, view, position, id) -> {
            TextView gg = (TextView) (view.findViewById(R.id.name_text_view));
            gg.setTextColor(Color.RED);
            Intent intent = new Intent(this, TabActivity.class);
            Toast.makeText(LessonActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();

            intent.putExtra("unit_number", position+1);
            LessonActivity.this.startActivity(intent);
        });

        viewList.setOnLongClickListener(v -> {
            Toast.makeText(LessonActivity.this, "all item longed", Toast.LENGTH_SHORT).show();
            return true;
        });

    }


    private void requestPermission() {
        ActivityCompat.requestPermissions(LessonActivity.this, new
                String[]{WRITE_EXTERNAL_STORAGE, RECORD_AUDIO}, RequestPermissionCode);
        if (!checkPermission())
            onBackPressed();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RequestPermissionCode:
                if (grantResults.length > 0) {
                    boolean StoragePermission = grantResults[0] ==
                            PackageManager.PERMISSION_GRANTED;
                    boolean RecordPermission = grantResults[1] ==
                            PackageManager.PERMISSION_GRANTED;

                    if (StoragePermission && RecordPermission) {
                        Toast.makeText(LessonActivity.this, "Permission Granted",
                                Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(LessonActivity.this, "Permission Denied", Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }

    public boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(),
                WRITE_EXTERNAL_STORAGE);
        int result1 = ContextCompat.checkSelfPermission(getApplicationContext(),
                RECORD_AUDIO);
        return result == PackageManager.PERMISSION_GRANTED &&
                result1 == PackageManager.PERMISSION_GRANTED;
    }

    public View getViewByPosition(int pos, ListView listView) {
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;

        if (pos < firstListItemPosition || pos > lastListItemPosition) {
            return listView.getAdapter().getView(pos, null, listView);
        } else {
            final int childIndex = pos - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }

    }

    @Override
    public void run() {
        while (true) {
            progress.setProgress(secondsProgress);
            secondsProgress++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        super.onBackPressed();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
