package com.philips.lighting.quickstart;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Switch;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.philips.lighting.hue.listener.PHLightListener;
import com.philips.lighting.hue.sdk.PHAccessPoint;
import com.philips.lighting.hue.sdk.PHHueSDK;
import com.philips.lighting.model.PHBridge;
import com.philips.lighting.model.PHBridgeResource;
import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHLight;
import com.philips.lighting.model.PHLightState;

import huetv.LightObject;


public class MyApplicationActivity extends Activity {
    private PHHueSDK phHueSDK;
    public static final String TAG = "hueTV Demo";
    private static final int NUM_LIGHTS = 3;
    private static final int TIME_DELAY_MS = 1000;

    private Handler mHandler;
    public int time = 0;
    public int buttonNumber = 0;
    public MediaPlayer mp = null;


    ArrayList<ArrayList<LightObject>> applause_light_track = new ArrayList<ArrayList<LightObject>>(
            NUM_LIGHTS);
    ArrayList<ArrayList<LightObject>> cricket_light_track = new ArrayList<ArrayList<LightObject>>(
            NUM_LIGHTS);
    ArrayList<ArrayList<LightObject>> darth_light_track = new ArrayList<ArrayList<LightObject>>(
            NUM_LIGHTS);
    ArrayList<ArrayList<LightObject>> laugh_light_track = new ArrayList<ArrayList<LightObject>>(
            NUM_LIGHTS);
    ArrayList<ArrayList<LightObject>> reactor_light_track= new ArrayList<ArrayList<LightObject>>(
            NUM_LIGHTS);
    ArrayList<ArrayList<LightObject>> wave_light_track= new ArrayList<ArrayList<LightObject>>(
            NUM_LIGHTS);
    ArrayList<ArrayList<LightObject>> fire_light_track= new ArrayList<ArrayList<LightObject>>(
            NUM_LIGHTS);

    ArrayList<ArrayList<LightObject>> firework_light_track= new ArrayList<ArrayList<LightObject>>(
            NUM_LIGHTS);

    ArrayList<ArrayList<LightObject>> space_light_track= new ArrayList<ArrayList<LightObject>>(
            NUM_LIGHTS);
    ArrayList<ArrayList<LightObject>> j_light_track= new ArrayList<ArrayList<LightObject>>(
            NUM_LIGHTS);

    ArrayList<ArrayList<LightObject>> sh_light_track= new ArrayList<ArrayList<LightObject>>(
            NUM_LIGHTS);

    ArrayList<ArrayList<LightObject>>si_light_track= new ArrayList<ArrayList<LightObject>>(
            NUM_LIGHTS);

    ArrayList<ArrayList<LightObject>> d_light_track= new ArrayList<ArrayList<LightObject>>(
            NUM_LIGHTS);


    ArrayList<ArrayList<LightObject>> c_light_track= new ArrayList<ArrayList<LightObject>>(
            NUM_LIGHTS);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.app_name);
        setContentView(R.layout.activity_main);
        phHueSDK = PHHueSDK.create();

        mHandler = new Handler();

        loadLightTrack(applause_light_track, "applasue.json");
        //printLightTrackToConsole(applause_light_track);

        loadLightTrack(cricket_light_track, "cricket1.json");
        //printLightTrackToConsole(applause_light_track);

        loadLightTrack(darth_light_track, "darth2.json");
        //printLightTrackToConsole(applause_light_track);

        loadLightTrack(laugh_light_track, "laugh.json");
        //printLightTrackToConsole(applause_light_track);

        loadLightTrack(reactor_light_track, "alarm2.json");
        //printLightTrackToConsole(applause_light_track);
        loadLightTrack(wave_light_track, "wave.json");

        loadLightTrack(fire_light_track, "fire2.json");

        loadLightTrack(firework_light_track, "fire_work.json");

        loadLightTrack(space_light_track, "space.json");

        loadLightTrack(sh_light_track, "sh.json");

        loadLightTrack(d_light_track, "d.json");

        loadLightTrack(j_light_track, "j.json");

        loadLightTrack(si_light_track, "si.json");

        loadLightTrack(c_light_track, "c.json");

        Button offButton;
        offButton = (Button) findViewById(R.id.offButton);
        offButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                off();
            }
        });
        
        Button onButton;
        onButton = (Button) findViewById(R.id.onButton);
        onButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
            	on();
            }
        });

        Button applauseButton;
        applauseButton = (Button) findViewById(R.id.applauseButton);
        applauseButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonNumber = 1;
                playSound();
                start();
            }
        });

        Button cricketButton;
        cricketButton = (Button) findViewById(R.id.cricketButton);
        cricketButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonNumber = 2;
                playSound();
                start();
            }
        });

        Button noooButton;
        noooButton = (Button) findViewById(R.id.noooButton);
        noooButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonNumber = 3;
                playSound();
                start();
            }
        });

        Button laughButton;
        laughButton = (Button) findViewById(R.id.laughButton);
        laughButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonNumber = 4;
                playSound();
                start();
            }
        });

        Button reactorButton;
        reactorButton = (Button) findViewById(R.id.reactorButton);
        reactorButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonNumber = 5;
                playSound();
                start();
            }
        });


        Button waveButton;
        waveButton = (Button) findViewById(R.id.waveButton);
        waveButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonNumber = 6;
                playSound();
                start();
            }
        });



        Button fireButton;
        fireButton = (Button) findViewById(R.id.fireButton);
        fireButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonNumber = 7;
                playSound();
                start();
            }
        });

        Button fireworkButton;
        fireworkButton = (Button) findViewById(R.id.fireworkButton);
        fireworkButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonNumber =8;
                playSound();
                start();
            }
        });


        Button spaceButton;
        spaceButton = (Button) findViewById(R.id.spaceButton);
        spaceButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonNumber =9;
                playSound();

                start();
            }
        });

        Button cbutton;
        cbutton = (Button) findViewById(R.id.c);
        cbutton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonNumber =10;
                start();
            }
        });

        Button dButton;
        dButton = (Button) findViewById(R.id.d);
        dButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonNumber =11;
                start();
            }
        });

        Button jButton;
        jButton = (Button) findViewById(R.id.j);
        jButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonNumber =12;

                start();
            }
        });

        Button shButton;
        shButton = (Button) findViewById(R.id.sh);
        shButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonNumber =13;

                start();
            }
        });



        Button siButton;
        siButton = (Button) findViewById(R.id.si);
        siButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                buttonNumber =14;

                start();
            }
        });


    }

    public void printLightTrackToConsole(ArrayList<ArrayList<LightObject>> lightTrack) {

        int counter = 0;
        for (int outside = 0; outside < lightTrack.size(); outside++) {
            Log.i("Light Track", "Light Number: " + counter);
            for (int inside = 0; inside < lightTrack.get(outside).size(); inside++) {
                String track = lightTrack.get(outside).get(inside).toString();
                Log.i("Light Track", track);
            }
            counter++;
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void loadLightTrack(ArrayList<ArrayList<LightObject>> lightTrack, String assetsName) {

        InputStream input = null;

        try {
            input = getAssets().open(assetsName);
        } catch (IOException e1) {
            Log.i("Error", "Load Light Track I/O Exception");
        }

        ArrayList<LightObject> LightObjects = new ArrayList<LightObject>();

        Integer temp = 0;
        Integer count = 0;

        try (JsonReader jsonReader = new JsonReader(new InputStreamReader(input))) {
            Gson myGson = new Gson();
            JsonParser jsonParser = new JsonParser();
            JsonArray userArray = jsonParser.parse(jsonReader).getAsJsonArray();

            for (JsonElement aUser : userArray) {
                LightObject aLightObject = myGson.fromJson(aUser,
                        LightObject.class);
                while (temp != aLightObject.getTimeSeconds()) {
                    for (Integer i = 0; i < NUM_LIGHTS; i++) {
                        LightObject emptyLight = new LightObject(temp);
                        emptyLight.setFiller(true);
                        emptyLight.setLightNumber(i);
                        LightObjects.add(emptyLight);
                    }
                    temp++;
                }

                if (count < NUM_LIGHTS - 1) {
                    aLightObject.setLightNumber(count);
                    LightObjects.add(aLightObject);
                    count++;
                } else if (count == NUM_LIGHTS - 1) {
                    aLightObject.setLightNumber(count);
                    LightObjects.add(aLightObject);
                    count = 0;
                    temp++;
                }
            }
        } catch (FileNotFoundException e) {
            Log.i("Error", "File not found.");
        } catch (IOException e) {
            Log.i("Error", "I/O Exception.");
        } catch (NullPointerException e) {
            Log.i("Error", "Null Pointer Exception.");
        } catch (IllegalStateException e) {
            Log.i("Error", "Illegal State Exception.");
        }

        for (int i = 0; i < NUM_LIGHTS; i++) {
            lightTrack.add(new ArrayList<LightObject>());
        }

        for (int outside = 0; outside < NUM_LIGHTS; outside++) {
            for (int inside = 0; inside < LightObjects.size(); inside++) {
                if (outside == LightObjects.get(inside).getLightNumber()) {
                    lightTrack.get(outside).add(LightObjects.get(inside));
                }
            }
        }
    }
    
    public void off() {
        PHBridge bridge = phHueSDK.getSelectedBridge();

        List<PHLight> allLights = bridge.getResourceCache().getAllLights();
        
        for (PHLight light : allLights) {
            PHLightState lightState = new PHLightState();
            
            lightState.setOn(false);
            bridge.updateLightState(light, lightState, listener);
        }

    }
    
    public void on() {
        PHBridge bridge = phHueSDK.getSelectedBridge();

        List<PHLight> allLights = bridge.getResourceCache().getAllLights();
        
        for (PHLight light : allLights) {
            PHLightState lightState = new PHLightState();
            
            lightState.setOn(true);
            bridge.updateLightState(light, lightState, listener);
        }

    }

    public void threadRun(){
        if(Looper.myLooper()== Looper.getMainLooper()) {
            new Thread(new Runnable(){
                @Override
                public void run() {
                    if(buttonNumber == 1) {
                        runLightTrack(applause_light_track);
                    }
                    else if(buttonNumber == 2) {
                        runLightTrack(cricket_light_track);
                    }
                    else if(buttonNumber == 3) {
                        runLightTrack(darth_light_track);
                    }
                    else if(buttonNumber == 4) {
                        runLightTrack(laugh_light_track);
                    }
                    else if(buttonNumber == 5) {
                        runLightTrack(reactor_light_track);
                    }
                    else if(buttonNumber == 6) {
                        runLightTrack(wave_light_track);
                    }
                    else if(buttonNumber == 7) {
                        runLightTrack(fire_light_track);
                    }
                    else if(buttonNumber == 8) {
                        runLightTrack(firework_light_track);
                    }

                    else if(buttonNumber == 9) {
                        runLightTrack(space_light_track);
                    }


                    else if(buttonNumber == 10) {
                        runLightTrack(c_light_track);
                    }

                    else if(buttonNumber == 11) {
                        runLightTrack(d_light_track);
                    }

                    else if(buttonNumber == 12) {
                        runLightTrack(j_light_track);
                    }

                    else if(buttonNumber == 13) {
                        runLightTrack(sh_light_track);
                    }

                    else if(buttonNumber == 14) {
                        runLightTrack(si_light_track);
                    }


                }
            }).start();
            return;
        }
    }

    Runnable lightTrackRunnable = new Runnable() {
        @Override
        public void run() {
            mHandler.postDelayed(lightTrackRunnable, TIME_DELAY_MS);
            threadRun();
        }
    };

    public void start() {
        time = 0;
        lightTrackRunnable.run();
    }

    public void stop() {
        mHandler.removeCallbacks(lightTrackRunnable);
        time = 0;
    }

    public void runLightTrack(ArrayList<ArrayList<LightObject>> listLights) {

        PHBridge bridge = phHueSDK.getSelectedBridge();
        List<PHLight> allLights = bridge.getResourceCache().getAllLights();

        if (time >= listLights.get(0).size()) {
            stop();
        }

        for (ArrayList<LightObject> LightObjectList : listLights) {

            LightObject LO = LightObjectList.get(time);
            PHLightState lightStateTemp = new PHLightState();

            if (!LO.isFiller()) {
                if (!LO.getOn()) {
                    lightStateTemp.setOn(false);
                } else {
                    lightStateTemp.setOn(true);
                    lightStateTemp.setHue(LO.getHue());
                    lightStateTemp.setSaturation(LO.getSaturation());
                    lightStateTemp.setBrightness(LO.getBrightness());

                    if (LO.getAlert().equalsIgnoreCase("select")) {
                        lightStateTemp
                                .setAlertMode(PHLight.PHLightAlertMode.ALERT_SELECT);
                    } else {
                        lightStateTemp
                                .setAlertMode(PHLight.PHLightAlertMode.ALERT_NONE);
                    }
                }
                bridge.updateLightState(allLights.get(LO.getLightNumber()),
                        lightStateTemp, listener);
            }
        }
        time++;

        if (time == listLights.get(0).size()) {
            stop();
        }
    }

    public void playSound() {

        String fileName = "";

        if(buttonNumber == 1) {
            fileName = "applause.mp3";
        }
        else if(buttonNumber == 2) {
            fileName = "cricket.WAV";
        }
        else if(buttonNumber == 3) {
            fileName = "darthVader.mp3";
        }
        else if(buttonNumber == 4) {
            fileName = "laugh.mp3";
        }
        else if(buttonNumber == 5) {
            fileName = "reactor.wav";
        }
        else if(buttonNumber == 6) {
            fileName = "waves.mp3";
        }
        else if(buttonNumber == 7) {
            fileName = "fire.mp3";
        }
        else if(buttonNumber == 8) {
            fileName = "firework.mp3";
        }
        else if(buttonNumber == 9) {
            fileName = "space.mp3";
        }

        AssetFileDescriptor afd = null;

        try{
            afd = getAssets().openFd(fileName);
        } catch(IOException e) {
            Log.i("Error", "Assets file I/O Error");
        }

        mp = new MediaPlayer();
        try{
            mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(),afd.getLength());
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            Log.i("Error", "Media player I/O Exception");
        }

    }
    

    // If you want to handle the response from the bridge, create a PHLightListener object.
    PHLightListener listener = new PHLightListener() {
        
        @Override
        public void onSuccess() {  
        }
        
        @Override
        public void onStateUpdate(Map<String, String> arg0, List<PHHueError> arg1) {
           Log.w(TAG, "Light has updated");
        }
        
        @Override
        public void onError(int arg0, String arg1) {}

        @Override
        public void onReceivingLightDetails(PHLight arg0) {}

        @Override
        public void onReceivingLights(List<PHBridgeResource> arg0) {}

        @Override
        public void onSearchComplete() {}
    };
    
    @Override
    protected void onDestroy() {
        PHBridge bridge = phHueSDK.getSelectedBridge();
        if (bridge != null) {
            
            if (phHueSDK.isHeartbeatEnabled(bridge)) {
                phHueSDK.disableHeartbeat(bridge);
            }
            
            phHueSDK.disconnect(bridge);
            super.onDestroy();
        }
    }
}
