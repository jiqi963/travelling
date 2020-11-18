package wangk6.travelling.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import op.wangk6.travelling.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_map.*

class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var googleMap: GoogleMap
    private val Wellington = LatLng(-41.276825, 174.777969)
    private val BEIJING = LatLng(39.916668, 116.383331)
    private val Tokyo = LatLng(35.652832, 139.839478)
    private val Rome = LatLng(41.902782, 12.496366)
    private val Berlin = LatLng(52.520008, 13.404954)
    private val CiudaddeMéxico = LatLng(19.432241, -99.177254)
    private val Ottawa = LatLng(45.424721, -75.695000)
    private val Brasilia = LatLng(-15.793889, -47.882778)
    private val CapeTown = LatLng(-33.918861, 18.423300)
    private val Paramaribo = LatLng(5.839398, -55.199089)
    private val Antananarivo = LatLng(-18.91368, 47.53613)
    private val Suva = LatLng(-18.141600, 178.441895)

    private val mWellington: Marker? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        map_view.onCreate(savedInstanceState)
        map_view.onResume()

        map_view.getMapAsync(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_map, container, false)

        return view
    }

    override fun onMapReady(map: GoogleMap?) {
        map?.let {
            googleMap = it

            googleMap.addMarker(MarkerOptions().position(Wellington).title("New Zealand & Wellington"))
            googleMap.addMarker(MarkerOptions().position(BEIJING).title("China & Wellington"))
            googleMap.addMarker(MarkerOptions().position(Tokyo).title("Japan & Tokyo"))
            googleMap.addMarker(MarkerOptions().position(Rome).title("Italy & Rome"))
            googleMap.addMarker(MarkerOptions().position(Berlin).title("Deutschland & Berlin"))
            googleMap.addMarker(MarkerOptions().position(CiudaddeMéxico).title("México & Ciudad de México"))
            googleMap.addMarker(MarkerOptions().position(Ottawa).title("Canada & Ottawa"))
            googleMap.addMarker(MarkerOptions().position(Brasilia).title("Brasil & Brasilia"))
            googleMap.addMarker(MarkerOptions().position(CapeTown).title("South Africa & CapeTown"))
            googleMap.addMarker(MarkerOptions().position(Paramaribo).title("Suriname & Paramaribo"))
            googleMap.addMarker(MarkerOptions().position(Antananarivo).title("Madagascar & Antananarivo"))
            googleMap.addMarker(MarkerOptions().position(Suva).title("Fiji & Suva"))
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(Wellington))
        }
    }

}