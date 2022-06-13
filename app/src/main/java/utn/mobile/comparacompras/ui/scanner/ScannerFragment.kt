package utn.mobile.comparacompras.ui.scanner

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.Detector
import com.google.android.gms.vision.barcode.Barcode
import com.google.android.gms.vision.barcode.BarcodeDetector
import utn.mobile.comparacompras.R
import utn.mobile.comparacompras.databinding.FragmentScannerBinding
import utn.mobile.comparacompras.utils.Permissions
import java.io.IOException


class ScannerFragment : Fragment()
{
    private val requestCodeCameraPermission = 1001
    private lateinit var cameraSource: CameraSource
    private lateinit var barcodeDetector: BarcodeDetector

    private var _binding: FragmentScannerBinding? = null

    private val binding get() = _binding!!

   override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScannerBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val aniSlide: Animation = AnimationUtils.loadAnimation(this.context, R.anim.scanner_animation)
        binding.barcodeLine.startAnimation(aniSlide)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (Permissions.checkForPermissions(this, android.Manifest.permission.CAMERA, requestCodeCameraPermission, resources.getString(R.string.cameraPermissionTitle)))
            setupControls()
    }

    @Deprecated("")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            requestCodeCameraPermission -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // tenemos permiso, continuar con la tarea
                    setupControls()
                }
                else {
                    // Controlar que no nos dieron permiso, por ejemplo mostrando un Toast
                    Toast.makeText(activity, resources.getString(R.string.no_tienes_permiso_camara), Toast.LENGTH_SHORT).show()
                }
                return
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        cameraSource.stop()
        _binding = null
    }

    private fun setupControls() {

        barcodeDetector = BarcodeDetector.Builder(requireContext()).setBarcodeFormats(Barcode.ALL_FORMATS).build()

        cameraSource = CameraSource.Builder(requireContext(), barcodeDetector)
            .setRequestedPreviewSize(1920, 1080)
            .setAutoFocusEnabled(true) //you should add this feature
            .build()

        binding.cameraSurfaceView.holder.addCallback(object : SurfaceHolder.Callback {
            @SuppressLint("MissingPermission")
            override fun surfaceCreated(holder: SurfaceHolder) {
                try {
                    //Start preview after 1s delay
                    cameraSource.start(holder)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }

            @SuppressLint("MissingPermission")
            override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
                try {
                    cameraSource.start(holder)
                }
                catch (e: IOException) {
                    e.printStackTrace()
                }
            }

            override fun surfaceDestroyed(holder: SurfaceHolder) {
                cameraSource.stop()
            }
        })


        barcodeDetector.setProcessor(object : Detector.Processor<Barcode> {
            override fun release() {
                requireActivity().runOnUiThread {
                    Toast.makeText(requireContext(), "Scanner has been closed", Toast.LENGTH_SHORT).show()
                }
            }

            override fun receiveDetections(detections: Detector.Detections<Barcode>) {
                val barcodes = detections.detectedItems
                if (barcodes.size() == 1) {
                    requireActivity().runOnUiThread {
                        val scannedValue = barcodes.valueAt(0).rawValue
                        cameraSource.stop()
                        val bundle = bundleOf("ScannedValue" to scannedValue)
                        val action = R.id.action_fragment_scanner_to_navigation_search
                        findNavController().navigate(action, bundle)
                    }
                }
                //else {
                //    requireActivity().runOnUiThread {
                //        Toast.makeText(requireContext(), "Error: no se detectó un código de barras único", Toast.LENGTH_SHORT).show()
                //    }
                //}
            }
        })
    }
}