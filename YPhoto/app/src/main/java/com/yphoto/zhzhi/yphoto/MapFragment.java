package com.yphoto.zhzhi.yphoto;

import android.Manifest;
import android.app.Fragment;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.yphoto.zhzhi.yphoto.maps.ClusterOverlay;
import com.yphoto.zhzhi.yphoto.maps.RegionItem;
import com.yphoto.zhzhi.yphoto.tools.CircleTask;

import java.util.Random;

import static com.yphoto.zhzhi.yphoto.maps.ClusterOverlay.dp2px;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MapFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MapFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MapFragment extends Fragment implements AMap.OnMapLongClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    Context mContext;

    // 高德地图view
    MapView mMapView;
    // 显示该位置附近的photo（不是定位坐标）
    LatLng mCurrentLocation;
    // 地图中位置闪烁点
    CircleTask mCircle;

    private int clusterRadius = 100;

    // 负责地图中聚合点的显示
    private ClusterOverlay mClusterOverlay;

    public MapFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MapFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MapFragment newInstance(String param1, String param2) {
        MapFragment fragment = new MapFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragment = inflater.inflate(R.layout.fragment_map, container, false);

        mMapView = (MapView) fragment.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);

        initAMap();

        return fragment;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
        mClusterOverlay.onDestroy();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    /**
     * 长按Map，居中地图
     */
    @Override
    public void onMapLongClick(LatLng latLng) {
        centerMap(latLng);
    }

    /**
     * 初始化Map
     */
    private void initAMap() {
        if(mMapView !=null) {
            AMap aMap = mMapView.getMap();

            // 初始化ClusterOverlay
            mClusterOverlay = new ClusterOverlay(aMap, null,
                    dp2px(mContext, clusterRadius),
                    mContext);

            // Map UI设置
            aMap.getUiSettings().setZoomControlsEnabled(false);
            aMap.getUiSettings().setMyLocationButtonEnabled(false);
            aMap.getUiSettings().setRotateGesturesEnabled(false);
            aMap.getUiSettings().setCompassEnabled(true);
            aMap.getUiSettings().setLogoBottomMargin(20);
            aMap.getUiSettings().setLogoLeftMargin(20);

            //aMap.setMapType(AMap.MAP_TYPE_NIGHT);

            // 显示室内地图
            aMap.showIndoorMap(true);

            LatLng loc = getMyLocation();
            // 初始化Map显示位置
            centerMap(loc);

            // 注册事件
            aMap.setOnMapLongClickListener(this);
        }
    }
    /**
     * Map居中到指定点，动画移动Map相机 并且开始加载周边photo
     */
    private void centerMap(LatLng loc) {
        if (loc != null) {
            mCurrentLocation = loc;
            AMap aMap = mMapView.getMap();

            CameraUpdate mCameraUpdate = CameraUpdateFactory.newCameraPosition(new CameraPosition(loc,14,0,0));
            aMap.animateCamera(mCameraUpdate, 1000, null);

            // 更新闪烁点
            if (mCircle == null) {
                mCircle = new CircleTask(aMap, loc);
            } else {
                mCircle.updateLocation(loc);
            }

            // 开始加载周边photo

            //添加测试数据
            new Thread() {
                public void run() {
                    int[] avatars = new int[] {R.drawable.avatar1, R.drawable.avatar2, R.drawable.avatar3, R.drawable.avatar4, R.drawable.avatar5, R.drawable.avatar6};
                    Random r = new Random();
                    //随机10000个点
                    for (int i = 0; i < 100; i++) {

                        double lat = Math.random() + mCurrentLocation.latitude;
                        double lon = Math.random() + mCurrentLocation.longitude;

                        LatLng latLng = new LatLng(lat, lon, false);
                        RegionItem regionItem = new RegionItem(latLng,
                                "test" + i, avatars[r.nextInt(6)], i);

                        mClusterOverlay.addClusterItem(regionItem);
                    }
                }

            }.start();
        }
    }

    /**
     * 获取定位坐标
     */
    private LatLng getMyLocation() {
        int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION);
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            Location loc = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
            return new LatLng(loc.getLatitude(), loc.getLongitude());
        } else {
            return null;
        }
    }

    /**
     * 加载周边photo
     */
    private void loadPhotoAsync() {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
