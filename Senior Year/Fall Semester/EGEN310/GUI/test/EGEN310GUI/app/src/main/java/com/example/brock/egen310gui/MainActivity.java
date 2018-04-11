package com.example.brock.egen310gui;

import android.Manifest;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import android.bluetooth.BluetoothAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private static final String TAG = "MainActivity";
    BluetoothAdapter mBluetoothAdapter;
    Button btnEnableDisable_Discoverable;
    public ArrayList<BluetoothDevice> mBTDevices = new ArrayList<>();
    public DeviceListAdapter mDeviceListAdapter;
    ListView lvNewDevices;

    BluetoothSocket btSocket = null;

    // Create a mBroadcastReceiver1 for ACTION_FOUND
    private final BroadcastReceiver mBroadcastReceiver1 = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(mBluetoothAdapter.ACTION_STATE_CHANGED)) { //catch action state changed
                final int state = intent.getIntExtra(mBluetoothAdapter.EXTRA_STATE, mBluetoothAdapter.ERROR);
                switch(state){
                    case BluetoothAdapter.STATE_OFF:
                          Log.d(TAG, "onReceive: STATE OFF");
                          break;
                    case BluetoothAdapter.STATE_TURNING_OFF:
                          Log.d(TAG, "mBroadcastReceiver1: STATE TURNING OFF");
                          break;
                    case BluetoothAdapter.STATE_ON:
                          Log.d(TAG, "mBroadcastReceiver1: STATE ON");
                          break;
                    case BluetoothAdapter.STATE_TURNING_ON:
                          Log.d(TAG, "mBroadcastReceiver1: STATE TURNING ON");
                          break;

                }
            }
        }
    };

    //create mBroadercastReceiver2 for ACTION_FOUND
    private final BroadcastReceiver mBroadcastReceiver2 = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(mBluetoothAdapter.ACTION_SCAN_MODE_CHANGED)) { //catch action mode changed
                final int mode = intent.getIntExtra(mBluetoothAdapter.EXTRA_SCAN_MODE, mBluetoothAdapter.ERROR);
                switch(mode){
                    case BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE:
                        Log.d(TAG, "mBroadcastReceiver2: Discoverability Enabled");
                        break;
                    case BluetoothAdapter.SCAN_MODE_CONNECTABLE:
                        Log.d(TAG, "mBroadcastReceiver2: Discoverability DisEnabled. Able to receive connection");
                        break;
                    case BluetoothAdapter.SCAN_MODE_NONE:
                        Log.d(TAG, "mBroadcastReceiver2: Discoverability Disabled. Not able to receive connection");
                        break;
                    case BluetoothAdapter.STATE_CONNECTING:
                        Log.d(TAG, "mBroadcastReceiver2: Connecting");
                        break;
                    case BluetoothAdapter.STATE_CONNECTED:
                        Log.d(TAG, "mBroadcastReceiver2: Connected.");
                        break;

                }
            }
        }
    };

    //ceate Broadcast reciver for listing devices that are not paired yet
    private final BroadcastReceiver mBroadcastReceiver3= new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            Log.d(TAG, "onReceive;ACTION FOUND");
            if(action.equals(BluetoothDevice.ACTION_FOUND)){
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                mBTDevices.add(device);
                Log.d(TAG, "OnReceive: " + device.getName() + ": " + device.getAddress());
                mDeviceListAdapter = new DeviceListAdapter(context, R.layout.device_adapter_view,mBTDevices);
                lvNewDevices.setAdapter(mDeviceListAdapter);
            }
        }
    };

    //ceate mBroadcastReciver4 for pairing bluetooth
    private final BroadcastReceiver mBroadcastReceiver4= new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();

            if(action.equals(BluetoothDevice.ACTION_BOND_STATE_CHANGED)){
                BluetoothDevice mDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                //if it is bonded already
                if(mDevice.getBondState()==BluetoothDevice.BOND_BONDED){
                    Log.d(TAG,"BroadcastReceiver: BOND_BONDED");
                }

                //create a bond
                if(mDevice.getBondState()==BluetoothDevice.BOND_BONDING){
                    Log.d(TAG,"BroadcastReceiver: BOND_BONDING");
                }

                //if bond is broken
                if(mDevice.getBondState()== BluetoothDevice.BOND_NONE){
                    Log.d(TAG,"BroadcastReceiver: BOND_NONE");
                }
            }
        }
    };

    @Override
    protected void onDestroy(){ //unregister the BroadcastReceiver
        Log.d(TAG, "onDestroy: called.");
        super.onDestroy();
        unregisterReceiver(mBroadcastReceiver1);
        unregisterReceiver(mBroadcastReceiver2);
        unregisterReceiver(mBroadcastReceiver3);
        unregisterReceiver(mBroadcastReceiver4);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button UpButton = (Button)findViewById(R.id.UpButton);
        Button DownButton = (Button)findViewById(R.id.DownButton);
        Button LeftButton = (Button)findViewById(R.id.LeftButton);
        Button RightButton = (Button)findViewById(R.id.RightButton);
        Button BluetoothButton = (Button)findViewById(R.id.BluetoothButton); //get the button from activity
        Button EnableDiscoverable = (Button)findViewById(R.id.EnableDiscoverable);

        lvNewDevices = (ListView) findViewById(R.id.lvNewDevices);
        mBTDevices = new ArrayList<>();

        //broadcast when bond state changed
        IntentFilter filter=new IntentFilter(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        registerReceiver(mBroadcastReceiver4,filter);

        //get default adapter
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        lvNewDevices.setOnItemClickListener(MainActivity.this);
        BluetoothButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.d(TAG, "onClick: enabling/disable bluetoothButton");
                enableDisableBT();
            }

        });


        UpButton.setOnClickListener(                   //or UpButton.sendText("1");
                new Button.OnClickListener(){
                    public void onClick(View v){
                        //Go forward
                        if(btSocket!=null){
                            try{
                                btSocket.getOutputStream().write("1".toString().getBytes());
                            }
                            catch(IOException e){
                                Toast.makeText(getApplicationContext(),"error",0x00000001);
                            }
                        }
                    }

                });
        UpButton.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        //Go forward
                        return true;
                    }

                });

        DownButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        //Go back
                    }

                });
        DownButton.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        //Go back
                        return true;
                    }

                });

        LeftButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        //Go left
                    }

                });
        LeftButton.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        //Go left
                        return true;
                    }

                });

        RightButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        //Go right
                    }

                });
        RightButton.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        //Go right
                        return true;
                    }

                });

    }

    public void enableDisableBT(){  //handle the bluetoothButton for turning on and off the bluetooth
        if(mBluetoothAdapter == null){ //when your device can not use bluetooth
            Log.d(TAG,"enableDisableBT: Does not have BT capabilities.");
        }
        if(!mBluetoothAdapter.isEnabled()){ //when bluetooth is not enabled,turn it on
                Log.d(TAG, "enableDisableBT: enabling BT.");
                Intent enableBTIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivity(enableBTIntent);

                IntentFilter BTIntent = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
                registerReceiver(mBroadcastReceiver1, BTIntent);  //catch the state change
        }
        if(mBluetoothAdapter.isEnabled()){  //disable the bluetooth
            Log.d(TAG, "enableDisableBT: disabling BT.");
            mBluetoothAdapter.disable();

            //register BroadercastReceiver
            IntentFilter BTIntent = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
            registerReceiver(mBroadcastReceiver1, BTIntent);  //catch the state change
        }

    }

    public void btmEnableDisable_Discoverable(View view){//handle the discoverability for bluetooth
            Log.d(TAG, "btmEnableDisable_Discoverable: making device discoverable for 60 second.");
            Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 60);
            startActivity(discoverableIntent);

            //register BroadercastReceiver
            IntentFilter BTIntent = new IntentFilter(mBluetoothAdapter.ACTION_SCAN_MODE_CHANGED);
            registerReceiver(mBroadcastReceiver2, BTIntent);
    }

    public void btnDiscover(View view){
        Log.d(TAG,"btnDiscover: Looking ofr unpaired devices.");
        if(mBluetoothAdapter.isDiscovering()){
            mBluetoothAdapter.cancelDiscovery();
            Log.d(TAG,"btnDiscover: Canceling discovery.");

            //check BT permission
            checkBTPermissions();

            mBluetoothAdapter.startDiscovery();
            IntentFilter discoverDevicesIntent = new IntentFilter(BluetoothDevice.ACTION_FOUND);
            registerReceiver(mBroadcastReceiver3,discoverDevicesIntent);
        }

        if(!mBluetoothAdapter.isDiscovering()){ //if not discovering, start discovery
            checkBTPermissions();

            mBluetoothAdapter.startDiscovery();
            IntentFilter discoverDevicesIntent = new IntentFilter(BluetoothDevice.ACTION_FOUND);
            registerReceiver(mBroadcastReceiver3,discoverDevicesIntent);
        }

    }


    //android must check the permission for bluetooth
    private void checkBTPermissions(){
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
            int permissionCheck = this.checkSelfPermission("Manifest.permission.ACCESS_FINE_LOCATION");
            permissionCheck += this.checkSelfPermission("Manifest.permission.ACCESS_COARSE_LOCATION");
            if(permissionCheck!=0){
                this.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},1001);
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //cancel discovery before pairing a device
       mBluetoothAdapter.cancelDiscovery();
        Log.d(TAG,"onItemClick: You clicked on a device.");
        String deviceName = mBTDevices.get(i).getName();
        String deviceAddress = mBTDevices.get(i).getAddress();

        //create the bond
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR2){
            mBTDevices.get(i).createBond();
        }
    }
}
